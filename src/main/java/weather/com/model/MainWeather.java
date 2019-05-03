package weather.com.model;

import java.io.Serializable;
import weather.com.util.Util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MainWeather implements Serializable {

	private static final long serialVersionUID = -3068254693667101110L;
	
	private Double temp;

	public Double getTemp() {
		return temp;
	}

	public void setTemp(Double temp) {
		this.temp = temp;
	}
	
	public Double getTempInCelsius() {
		return Util.convertKelvinToCelsius(temp);
	}
	
	public Double getTempInFahrenheit() {
		return Util.convertKelvinToFahrenheit(temp);
	}

	@Override
	public String toString() {
		return "MainWeather [temp=" + temp + "]";
	}
}
