package com.globalia.belive.prueba.configurations;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class ConfigurationPrueba {

	@Value("${tomcat.ajp.port}")
	private int ajpPort;


	@Bean
	public ConfigurableServletWebServerFactory webServerFactory() {
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();

		factory.addAdditionalTomcatConnectors(ajpConnector());

		return factory;
	}

	private Connector ajpConnector() {
		Connector connector = new Connector("AJP/1.3");
		connector.setScheme("http");
		connector.setPort(ajpPort);
		connector.setSecure(false);
		connector.setAllowTrace(false);
		return connector;
	}



}
