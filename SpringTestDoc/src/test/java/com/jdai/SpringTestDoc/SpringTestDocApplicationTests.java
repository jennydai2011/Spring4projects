package com.jdai.SpringTestDoc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@SpringBootTest
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
class SpringTestDocApplicationTests {
	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	List<Order> orders = null;

	@BeforeEach
	public void setup(WebApplicationContext webApplicationContext,
					  RestDocumentationContextProvider restDocumentationContextProvider){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.apply(documentationConfiguration(restDocumentationContextProvider))
				.build();

		orders = Stream.of(new Order(10L, "order10", 100.0, 3),
				new Order(11L, "order11", 11.01, 5)).collect(Collectors.toList());
	}
	@Test
	void contextLoads() {
	}

	@Test
	void addOrder() throws Exception {
		String orderJson = new ObjectMapper().writeValueAsString(orders);
		mockMvc.perform(post("/PlaceOrder")
				.content(orderJson)
				.contentType("application/json"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(orderJson))
				.andDo(document("{methodName}",
						preprocessRequest(prettyPrint()),
						preprocessResponse(prettyPrint())));
	}

	@Test
	void getOrders() throws Exception {
		mockMvc.perform(get("/orders").contentType("application/json")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(orders)))
				.andDo(document("{methodName}",
						preprocessRequest(prettyPrint()),
						preprocessResponse(prettyPrint())));
	}

}
