package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

	private final String applicationName;

	public DemoController(@Value("${spring.application.name}") String applicationName) {
		this.applicationName = applicationName;
	}

	@GetMapping("/hello")
	public GreetingResponse hello(@RequestParam(defaultValue = "World") String name) {
		return new GreetingResponse("Hello, " + name + "!", applicationName);
	}

	@GetMapping("/status")
	public StatusResponse status() {
		return new StatusResponse("UP", applicationName, System.getProperty("java.version"));
	}

	@PostMapping("/echo")
	public EchoResponse echo(@RequestBody EchoRequest request) {
		String message = request.message() == null ? "" : request.message();
		return new EchoResponse(message, message.toUpperCase(), message.length());
	}

	public record GreetingResponse(String message, String application) {
	}

	public record StatusResponse(String status, String application, String javaVersion) {
	}

	public record EchoRequest(String message) {
	}

	public record EchoResponse(String original, String uppercase, int length) {
	}
}