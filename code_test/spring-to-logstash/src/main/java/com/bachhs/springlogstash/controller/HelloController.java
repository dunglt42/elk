package com.bachhs.springlogstash.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

	@RequestMapping("/")
	String home() {
		log.info("home() has been called");
		return "Hello World!";
	}

}
