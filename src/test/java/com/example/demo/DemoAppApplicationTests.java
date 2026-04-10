package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DemoAppApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void helloEndpointReturnsGreeting() throws Exception {
		mockMvc.perform(get("/api/hello").param("name", "GitHub Actions"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.message").value("Hello, GitHub Actions!"))
			.andExpect(jsonPath("$.application").value("demo-app"));
	}

	@Test
	void statusEndpointReturnsApplicationStatus() throws Exception {
		mockMvc.perform(get("/api/status"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.status").value("UP"))
			.andExpect(jsonPath("$.application").value("demo-app"))
			.andExpect(jsonPath("$.javaVersion").isNotEmpty());
	}

	@Test
	void echoEndpointReturnsDerivedValues() throws Exception {
		mockMvc.perform(post("/api/echo")
				.contentType(MediaType.APPLICATION_JSON)
				.content("""
					{"message":"build and test"}
					"""))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.original").value("build and test"))
			.andExpect(jsonPath("$.uppercase").value("BUILD AND TEST"))
			.andExpect(jsonPath("$.length").value(14));
	}

}
