package weather.com.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import weather.com.property.AppProperties;
import weather.com.model.CurrentWeather;

@Component
public class OpenWeatherMapAPI {

	public static final String ID = "id";
	public static final String APP_ID = "appid";

	@Autowired
	private AppProperties appProperties;

	private static final Logger log = LoggerFactory.getLogger(OpenWeatherMapAPI.class);

	@GetMapping("/weather")
	public ResponseEntity<CurrentWeather> getCurrentWeatherByCityId(Integer id) {
		UriComponentsBuilder builder = UriComponentsBuilder
			.fromUriString(appProperties.getWeatherByCityIdUrl())
			.queryParam(ID, id)
			.queryParam(APP_ID, appProperties.getAppid());
		if(log.isInfoEnabled()) {
			log.info("URI: {}", builder.toUriString());
		}
		CurrentWeather currentWeather = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			currentWeather = restTemplate.getForObject(
				builder.toUriString(), 
				CurrentWeather.class);
			if(log.isInfoEnabled() && currentWeather != null) {
				log.info(currentWeather.toString());
			}
		} catch(HttpStatusCodeException exception) {
			HttpStatus statusCode = exception.getStatusCode();
			log.error("OpenWeatherMapAPI Status code = {}", statusCode.value());
			return new ResponseEntity<>(statusCode);
		}

		return new ResponseEntity<>(currentWeather, HttpStatus.OK);
	}
}