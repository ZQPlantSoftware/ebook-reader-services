package com.gz.fz.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="configure")
public class Configuration {
	
	private String decompPath;
	private String webServerPath;

	public String getDecompPath() {
		return decompPath;
	}

	public void setDecompPath(String decompPath) {
		this.decompPath = decompPath;
	}

	public String getWebServerPath() {
		return webServerPath;
	}

	public void setWebServerPath(String webServerPath) {
		this.webServerPath = webServerPath;
	}
	
}
