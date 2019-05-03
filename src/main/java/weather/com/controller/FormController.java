package weather.com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import weather.com.api.OpenWeatherMapAPI;
import weather.com.dto.City;
import weather.com.model.CurrentWeather;
import weather.com.service.CityService;

@Controller
public class FormController {
	
	public static final String CURRENT_WEATHER = "currentWeather";
	
	@Autowired
	private OpenWeatherMapAPI openWeatherMapAPI;
	@Autowired
	private CityService cityService;

    @GetMapping("/")
    public String index() {
        return "redirect:/form";
    }

    @GetMapping("/form")
    public String formGet() {
        return "form";
    }

    @PostMapping("/postform")
    public String formPost(City city, Model model) {
    	List<City> cities = cityService.getAvailableCities();
		
		City cityChoosen = cities.stream()
			.filter(c -> city.getName().equalsIgnoreCase(c.getName()))
			.findAny()
			.orElse(null);
		
		if(cityChoosen != null) {
			ResponseEntity<CurrentWeather> responseEntity = openWeatherMapAPI.getCurrentWeatherByCityId(cityChoosen.getId());
			if (HttpStatus.OK.equals(responseEntity.getStatusCode())) {
				CurrentWeather currentWeather = responseEntity.getBody();
				model.addAttribute(CURRENT_WEATHER, currentWeather);
				return "result";
			}
		}
		
        return "notfound";
    }
}