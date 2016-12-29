# Simple Weather Project

This is a sample maven project in "Maven by Example", improved to adopt the new Yahoo Weather API.

## How to use

    $ git clone https://github.com/Lunran/simple-weather.git
    $ cd simple-weather
    $ mvn install
    $ mvn exec:java -Dexec.mainClass=org.sonatype.mavenbook.custom.weather.Main
    $ mvn exec:java -Dexec.mainClass=org.sonatype.mavenbook.custom.weather.Main -Dexec.args="Tokyo"

## Improvement

1. added jaxen to pom.xml
2. changed query URI
3. fixed parser to deal with the new xml format

## Original

- http://books.sonatype.com/mvnex-book/reference/public-book.html
    - http://books.sonatype.com/mvnex-book/reference/customizing-sect-simple-weather.html
- https://github.com/sonatype/maven-example-en
    - https://github.com/sonatype/maven-example-en/tree/master/examples/ch-custom/simple-weather

## Yahoo Weather API

- https://developer.yahoo.com/weather/
- Example of query URI and response
    - https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22Tsu%22)&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys
