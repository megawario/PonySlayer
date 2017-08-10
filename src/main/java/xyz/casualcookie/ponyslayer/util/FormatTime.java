package xyz.casualcookie.ponyslayer.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;


/**
 * Static methods to help out with time display
 * @author mpinto
 *
 */
public class FormatTime {
	
	public static final List<Instant> INTERVALS = getInstantList();
	
	private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)
			.withLocale(Locale.UK).withZone(ZoneId.systemDefault());
	
	private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
	.withLocale(Locale.UK).withZone(ZoneId.systemDefault());

	public static String formatTime(Instant intant){
		return timeFormatter.format(intant);
	}
	
	public static String formatDate(Instant instant){
		return dateFormatter.format(instant);
	}
	
	//time selection list
	private static List<Instant> getInstantList(){
		LinkedList<Instant> list = new LinkedList<>();
		Instant inst= LocalDateTime.now().withHour(13).withMinute(0).toInstant(ZoneOffset.ofHours(0));
		list.add(inst);
		for(int i=95;i>0;i--){
			list.add(list.getLast().plus(15,ChronoUnit.MINUTES));
		}
		return list;
	}

}
