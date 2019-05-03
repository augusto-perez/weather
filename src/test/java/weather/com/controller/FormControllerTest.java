package weather.com.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.ui.ConcurrentModel;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import weather.com.dto.City;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FormControllerTest {

	private static final Integer ID_MEXICO_CITY = 111;
	private static final String NAME_MEXICO_CITY = "Mexico City";
	private static final Integer ID_LONDON = 2643743;
	private static final String NAME_LONDON = "London";
	private static final String NOT_FOUND_VIEW = "notfound";
	private static final String RESULT_VIEW = "result";

	@Autowired
    private FormController controller;

    @Test
    public void contextLoads() {
        assertNotNull(controller);
    }

	@Test
	public void whenCityChoosenIsNull() {
		// Mexico City is not included in our two cities list for this app, thus cityChoosen is null
		City city = new City(ID_MEXICO_CITY, NAME_MEXICO_CITY);
		Model model = new ConcurrentModel();
		assertEquals(NOT_FOUND_VIEW, controller.formPost(city, model));
	}

	@Test
	public void whenCityChoosenIsNotNull() {
		// London is included in our two cities for this app, thus cityChoosen is null
		City city = new City(ID_LONDON, NAME_LONDON);
		Model model = new ConcurrentModel();
		assertEquals(RESULT_VIEW, controller.formPost(city, model));
	}
}