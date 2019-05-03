package weather.com.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormat;

public class Util {
	public static final double CONST_K_TO_C = 273.16d;
	public static final double CONST_K_TO_F_D = 273d;
	public static final double CONST_K_TO_F_T = 9/5d;
	public static final int CONST_K_TO_F_I = 32;
	public static final Long ONE_THOUSAND = 1000L;
	public static final DateTimeFormatter DTF_STD = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
	public static final DateTimeFormatter DTF_12H = DateTimeFormat.forPattern("hh:mm a");
	public static final DateTimeZone DTZ_HONG_KONG = DateTimeZone.forID("Asia/Hong_Kong");
	public static final DateTimeZone DTZ_LONDON = DateTimeZone.forID("Europe/London");
	public static final String NAME_HONG_KONG = "Hong Kong";
	public static final String NAME_LONDON = "London";
	
	private Util() {
	}

	public static Double convertKelvinToCelsius(Double kelvin) {
		return (kelvin - CONST_K_TO_C);
	}

	public static Double convertKelvinToFahrenheit(Double kelvin) {
		return (((kelvin - CONST_K_TO_F_D) * CONST_K_TO_F_T) + CONST_K_TO_F_I);
	}

	public static String printDateTime(Long millis, String name, DateTimeFormatter dtf) {
		DateTime dateTime = DateTime.now();
		if (NAME_HONG_KONG.equalsIgnoreCase(name)) {
			dateTime = new DateTime( ( millis * ONE_THOUSAND ), DTZ_HONG_KONG );
		}
		else if (NAME_LONDON.equalsIgnoreCase(name)) {
			dateTime = new DateTime( ( millis * ONE_THOUSAND ), DTZ_LONDON );
		}
		return dtf.print(dateTime);
	}
}
