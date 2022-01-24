package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigClientRestController {
	@Value("${db.url:Unable to connect to config server}")
	private String dbUrl;

	@Value("${db.username:guest}")
	private String dbUserName;
	
	@Value("${db.password:password}")
	private String dbPassword;
	
	@RequestMapping("/dbserver/url")
	String getDBServerURL() {
		return this.dbUrl;
	}
	
	@RequestMapping("/dbserver/user")
	String getDBUserName() {
		return this.dbUserName;
	}
	
	@RequestMapping("/dbserver/password")
	String getDBPassword() {
		return this.dbPassword;
	}
}
