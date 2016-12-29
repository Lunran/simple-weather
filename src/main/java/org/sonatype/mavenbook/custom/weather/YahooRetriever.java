package org.sonatype.mavenbook.custom.weather;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

public class YahooRetriever {

	private static Logger log = Logger.getLogger(YahooRetriever.class);

	public InputStream retrieve(String cityname) throws Exception {
		log.info("Retrieving Weather Data");
		StringBuilder url = new StringBuilder("https://query.yahooapis.com/v1/public/yql?q=");
		url.append("select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22");
		url.append(cityname);
		url.append("%22)&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
		URLConnection conn = new URL(url.toString()).openConnection();

		return conn.getInputStream();
	}
}
