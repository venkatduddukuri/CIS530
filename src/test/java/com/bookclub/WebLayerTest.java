package com.bookclub;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.bookclub.service.dao.BookOfTheMonthDao;
import com.bookclub.web.HomeController;

@RunWith(SpringRunner.class)
@WebMvcTest(value=HomeController.class)
public class WebLayerTest {

	@Autowired
	protected MockMvc mvc;


	@Mock
	private HomeController controller;
	@MockBean
	BookOfTheMonthDao bookOfTheMonthDao;
	@Test
	public void contextLoads() throws Exception {
	  assertThat(controller).isNotNull();
	}
	
	@Test
	public void getContactPageFailed() throws Exception {
	   String uri = "/contact";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(302, status);
	}
	
	@Test
	public void getaboutPageFailed() throws Exception {
	   String uri = "/about";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(302, status);
	}
}