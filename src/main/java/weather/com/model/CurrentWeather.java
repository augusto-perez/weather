package weather.com.model;

import static weather.com.util.Util.DTF_STD;
import static weather.com.util.Util.DTF_12H;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import weather.com.util.Util;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeather implements Serializable {
	private static final long serialVersionUID = -9191434518446571327L;

	private Long id;
    private String name;
    private Long dt;
    @JsonProperty("weather")
    private List<Weather> weathers;
    @JsonProperty("main")
    private MainWeather main;
    @JsonProperty("sys")
    private SysWeather sys;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getDt() {
		return dt;
	}

	public String getCurrentDt() {
		return Util.printDateTime(getDt(), getName(), DTF_STD);
	}

	public void setDt(Long dt) {
		this.dt = dt;
	}

	public List<Weather> getWeathers() {
		return weathers;
	}

	public void setWeathers(List<Weather> weathers) {
		this.weathers = weathers;
	}

	public String getDescriptionWeathers() {
		return getWeathers().stream()
				.map(Weather::getDescription)
				.collect(Collectors.joining(","));
	}

	public MainWeather getMain() {
		return main;
	}

	public void setMain(MainWeather main) {
		this.main = main;
	}

	public SysWeather getSys() {
		return sys;
	}

	public void setSys(SysWeather sys) {
		this.sys = sys;
	}

	public String getSunrise12hFormat() {
		return Util.printDateTime(getSys().getSunrise(), getName(), DTF_12H);
	}

	public String getSunset12hFormat() {
		return Util.printDateTime(getSys().getSunset(), getName(), DTF_12H);
	}

	@Override
	public String toString() {
		return "CurrentWeather [id=" + id + ", name=" + name + ", dt=" + dt
				+ ", weather=" + weathers + ", main=" + main + ", sys=" + sys
				+ "]";
	}
}