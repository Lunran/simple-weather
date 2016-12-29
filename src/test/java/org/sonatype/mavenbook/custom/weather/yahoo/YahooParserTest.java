package org.sonatype.mavenbook.custom.weather.yahoo;

import java.io.InputStream;

import org.sonatype.mavenbook.custom.weather.Weather;
import org.sonatype.mavenbook.custom.weather.YahooParser;

import junit.framework.TestCase;

public class YahooParserTest extends TestCase {

	public YahooParserTest (String name) {
		super(name);
	}

	public void testParser() throws Exception {
		InputStream tsuData = getClass().getClassLoader().getResourceAsStream("tsu-weather.xml");
		Weather weather = new YahooParser().parse(tsuData);

		assertEquals("Tsu-shi", weather.getCity());
		assertEquals(" Mie Prefecture", weather.getRegion());
		assertEquals("Japan", weather.getCountry());
		assertEquals("40", weather.getTemp());
		assertEquals("Mostly Clear", weather.getCondition());
		assertEquals("32", weather.getChill());
		//assertEquals("75", weather.getHumidity());
		assertEquals("76", weather.getHumidity());
	}
}
