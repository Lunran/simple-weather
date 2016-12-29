package org.sonatype.mavenbook.custom.weather.yahoo;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.sonatype.mavenbook.custom.weather.Weather;
import org.sonatype.mavenbook.custom.weather.WeatherFormatter;
import org.sonatype.mavenbook.custom.weather.YahooParser;

import junit.framework.TestCase;

public class WeatherFormatterTest extends TestCase {

	public WeatherFormatterTest(String name) {
		super(name);
	}

	public void testFormat() throws Exception {
		InputStream tsuData = getClass().getClassLoader().getResourceAsStream("tsu-weather.xml");
		Weather weather = new YahooParser().parse(tsuData);
		String formattedResult = new WeatherFormatter().format(weather);
		InputStream expected = getClass().getClassLoader().getResourceAsStream("format-expected.dat");
		assertEquals(IOUtils.toString(expected).trim(), formattedResult.trim());
	}
}
