package weather.com.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import weather.com.property.AppProperties;
import weather.com.model.CurrentWeather;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OpenWeatherMapAPITest {

	private static final Integer ID_NOT_FOUND = 1129942;
	private static final Integer ID_BAD_REQUEST = 0;

	@Autowired
	private OpenWeatherMapAPI api;

	@Autowired
    private AppProperties properties;

    @Test
    public void contextLoads() {
        assertNotNull(properties);
    }

	@Test
	public void whenStatusCodeIs200() {
		ResponseEntity<CurrentWeather> responseEntity = api.getCurrentWeatherByCityId(properties.getHongkongcityid());
		assertNotNull(responseEntity);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void whenStatusCodeIs404() {
		ResponseEntity<CurrentWeather> responseEntity = api.getCurrentWeatherByCityId(ID_NOT_FOUND);
		assertNotNull(responseEntity);
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	}

	@Test
	public void whenStatusCodeIs400() {
		ResponseEntity<CurrentWeather> responseEntity = api.getCurrentWeatherByCityId(ID_BAD_REQUEST);
		assertNotNull(responseEntity);
		assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
	}
}