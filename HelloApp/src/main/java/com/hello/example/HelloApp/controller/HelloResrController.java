package com.hello.example.HelloApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/hello")
public class HelloResrController {
	@GetMapping(value="/msg")
public String getMessage() {
	return "Say Hello 2 All...!!";
}
}
