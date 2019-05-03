package weather.com.service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weather.com.dto.City;
import weather.com.property.AppProperties;

@Service
public class CityService {
	
	@Autowired
	private AppProperties appProperties;

    public List<City> getAvailableCities() {
    	List<City> cities = new ArrayList<>();
		
		if(appProperties.getHongkongcityid() != null) {
			cities.add(new City(appProperties.getHongkongcityid(), appProperties.getHongkongcityname()));
		}
		if (appProperties.getLondoncityid() != null) {
			cities.add(new City(appProperties.getLondoncityid(), appProperties.getLondoncityname()));
		}

        return cities;
    }
}