package com.skilldistillery.photonerds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PhotosForMeApplication extends SpringBootServletInitializer {
	  @Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(PhotosForMeApplication.class);
	  }
	  public static void main(String[] args) {
		    SpringApplication.run(PhotosForMeApplication.class, args);
		  }
		}