package org.sonatype.mavenbook.custom.weather;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXReader;

/**
 * Parse the response (xml) of Yahoo Weather API
 * Refer to https://developer.yahoo.com/weather/#js for the format
 *
 */
public class YahooParser {

	private static Logger log = Logger.getLogger(YahooParser.class);

	public Weather parse(InputStream inputStream) throws Exception {
		Weather weather = new Weather();

		log.info("Creating XML Reader");
		SAXReader xmlReader = createXmlReader();
		Document doc = xmlReader.read(inputStream);

		log.info("Parsing XML Response");
		String base = "/query/results/channel/";
		weather.setCity(doc.valueOf(base + "yweather:location/@city"));
		weather.setRegion(doc.valueOf(base + "yweather:location/@region"));
		weather.setCountry(doc.valueOf(base + "yweather:location/@country"));
		weather.setCondition(doc.valueOf(base + "item/yweather:condition/@text"));
		weather.setTemp(doc.valueOf(base + "item/yweather:condition/@temp"));
		weather.setChill(doc.valueOf(base + "yweather:wind/@chill"));
		weather.setHumidity(doc.valueOf(base + "yweather:atmosphere/@humidity"));

		return weather;
	}

	private SAXReader createXmlReader() {
		Map<String, String> uris = new HashMap<>();
		uris.put("yweather", "http://xml.weather.yahoo.com/ns/rss/1.0");

		DocumentFactory factory = new DocumentFactory();
		factory.setXPathNamespaceURIs(uris);

		SAXReader xmlReader = new SAXReader();
		xmlReader.setDocumentFactory(factory);

		return xmlReader;
	}
}
