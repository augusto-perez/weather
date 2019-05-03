package weather.com.model;

import java.io.Serializable;

public class SysWeather implements Serializable {
	private static final long serialVersionUID = 2147590578723687445L;

	private Integer id;
	private Long sunrise;
	private Long sunset;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getSunrise() {
		return sunrise;
	}

	public void setSunrise(Long sunrise) {
		this.sunrise = sunrise;
	}

	public Long getSunset() {
		return sunset;
	}

	public void setSunset(Long sunset) {
		this.sunset = sunset;
	}

	@Override
	public String toString() {
		return "SysWeather [id=" + id + ", sunrise=" + sunrise + ", sunset="
				+ sunset + "]";
	}
}
