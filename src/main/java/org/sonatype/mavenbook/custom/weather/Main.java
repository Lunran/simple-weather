package org.sonatype.mavenbook.custom.weather;

import java.io.InputStream;

import org.apache.log4j.PropertyConfigurator;

public class Main {

	public static void main(String args[]) throws Exception {
		// Configure Log4J
		PropertyConfigurator.configure(Main.class.getClassLoader().getResource("log4j.properties"));

		// Read the city name from the command line
		// (if none supplied, use Tsu-city)
		String cityname = args.length >= 1 ? args[0] : "Tsu";

		// Start the program
		new Main(cityname).start();
	}

	private String cityname;

	public Main(String cityname) {
		this.cityname = cityname;
	}

	public void start() throws Exception {
		//Retrieve Data
		InputStream dataIn = new YahooRetriever().retrieve(cityname);

		// Parse Data
		Weather weather = new YahooParser().parse(dataIn);

		// Format (Print) Data
		System.out.print(new WeatherFormatter().format(weather));
	}
}
