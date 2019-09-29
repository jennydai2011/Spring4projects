package com.jdai.SpringMvcMock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdai.SpringMvcMock.api.model.Employee;
import com.jdai.SpringMvcMock.api.model.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMvcMockApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	ObjectMapper om = new ObjectMapper();

	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void addEmployeeTest() throws Exception {
		Employee employee = new Employee();
		employee.setName("User1");
		employee.setDept("dept1");

		String jsonRequest = om.writeValueAsString(employee);
		MvcResult result = mockMvc.perform(post("/EmployeeService/addEmployee")
											.content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();

		String resultContent = result.getResponse().getContentAsString();
		Response response = om.readValue(resultContent, Response.class);
		System.out.println("response status:"+ response.isSuccess());

		//Assert.assertTrue(response.isSuccess() == Boolean.TRUE);
	}

	@Test
	public void getAllEmployeesTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/EmployeeService/getEmployees")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();

	}

}
