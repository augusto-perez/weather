package weather.com.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class AppProperties {
    private String weatherByCityIdUrl;
    private String appid;
	private Integer hongkongcityid;
	private Integer londoncityid;
	private String hongkongcityname;
	private String londoncityname;
	private String hongkongcitydtzone;
	private String londoncitydtzone;

    public String getWeatherByCityIdUrl() {
        return weatherByCityIdUrl;
    }

    public void setWeatherByCityIdUrl(String weatherByCityIdUrl) {
        this.weatherByCityIdUrl = weatherByCityIdUrl;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

	public Integer getHongkongcityid() {
		return hongkongcityid;
	}

	public void setHongkongcityid(Integer hongkongcityid) {
		this.hongkongcityid = hongkongcityid;
	}

	public Integer getLondoncityid() {
		return londoncityid;
	}

	public void setLondoncityid(Integer londoncityid) {
		this.londoncityid = londoncityid;
	}

	public String getHongkongcityname() {
		return hongkongcityname;
	}

	public void setHongkongcityname(String hongkongcityname) {
		this.hongkongcityname = hongkongcityname;
	}

	public String getLondoncityname() {
		return londoncityname;
	}

	public void setLondoncityname(String londoncityname) {
		this.londoncityname = londoncityname;
	}

	public String getHongkongcitydtzone() {
		return hongkongcitydtzone;
	}

	public void setHongkongcitydtzone(String hongkongcitydtzone) {
		this.hongkongcitydtzone = hongkongcitydtzone;
	}

	public String getLondoncitydtzone() {
		return londoncitydtzone;
	}

	public void setLondoncitydtzone(String londoncitydtzone) {
		this.londoncitydtzone = londoncitydtzone;
	}
}