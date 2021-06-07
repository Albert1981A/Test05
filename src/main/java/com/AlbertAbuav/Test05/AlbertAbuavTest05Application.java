package com.AlbertAbuav.Test05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AlbertAbuavTest05Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(AlbertAbuavTest05Application.class, args);
		System.out.println("Spring IoC container was Loaded!");
	}

}
