package com.realm.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.realm.converters.UserRealmToRealmResponse;
import com.realm.exceptions.RealmNotFound;
import com.realm.model.UserRealm;
import com.realm.service.RealmService;

public class RealmControllerTest {
	
	RealmController controller;
	MockMvc mockMvc;
	
	@Mock
	RealmService service;
	@Mock
	UserRealmToRealmResponse userRealmToRealmResponse;
	
	UserRealm userRealm;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new RealmController(service, userRealmToRealmResponse);
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.setControllerAdvice(new ExceptionHandlerController())
				.build(); 
		
		userRealm = new UserRealm(1L, "Name", "Description", "");
	}
	
	
	@Test
	public void createRealmTestJSON() throws Exception {
		mockMvc.perform(post("/service/user/realm")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{ \"name\": \"name\", \"description\": \"description\" } "))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated());
		
		verify(service).createRealm("name", "description");
		verify(userRealmToRealmResponse).convert(any());
		
	}
	
	@Test
	public void createRealmTestJSONInvalidRealmName() throws Exception {
		mockMvc.perform(post("/service/user/realm")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{ \"name\": \"\", \"description\": \"description\" } "))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest());
		
		verify(service, never()).createRealm("", "");
		verify(userRealmToRealmResponse, never()).convert(any());
	}
	
	
	@Test
	public void createRealmTestXML() throws Exception {
		mockMvc.perform(post("/service/user/realm")
				.contentType(MediaType.APPLICATION_XML)
				.content("<realm name = \"name\"> <description>description</description> </realm>"))
		.andExpect(content().contentType(MediaType.APPLICATION_XML))
		.andExpect(status().isCreated());
		
		verify(service).createRealm("name", "description");
		verify(userRealmToRealmResponse).convert(any());
		
	}
	
	@Test
	public void createRealmTestXMLInvalidRealmName() throws Exception {
		mockMvc.perform(post("/service/user/realm")
				.contentType(MediaType.APPLICATION_XML)
				.content("<realm name = \"\"> <description>description</description> </realm>"))
		.andExpect(content().contentType(MediaType.APPLICATION_XML))
		.andExpect(status().isBadRequest());
		
		verify(service, never()).createRealm("", "");
		verify(userRealmToRealmResponse, never()).convert(any());
	}
	
	
	@Test
	public void getRealmTestJSON() throws Exception {
		when(service.getById(anyLong())).thenReturn(userRealm);
		
		mockMvc.perform(get("/service/user/realm/1")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
		verify(service).getById(Long.valueOf(1));
		verify(userRealmToRealmResponse).convert(any());
	}
	
	
	@Test
	public void getRealmTestJSONInvalidArgument() throws Exception {
		mockMvc.perform(get("/service/user/realm/1a")
				.accept(MediaType.APPLICATION_XML))
		.andExpect(status().isBadRequest());
		
		verify(service, never()).getById(anyLong());
		verify(userRealmToRealmResponse, never()).convert(any());
	}
	
	@Test
	public void getRealmTestXML() throws Exception {
		when(service.getById(anyLong())).thenReturn(userRealm);
		
		mockMvc.perform(get("/service/user/realm/1")
				.accept(MediaType.APPLICATION_XML))
		.andExpect(status().isOk());
		
		verify(service).getById(Long.valueOf(1));
		verify(userRealmToRealmResponse).convert(any());
	}
	
	
	@Test
	public void getRealmTestXMLInvalidArgument() throws Exception {
		mockMvc.perform(get("/service/user/realm/1a")
				.accept(MediaType.APPLICATION_XML))
		.andExpect(status().isBadRequest());
		
		verify(service, never()).getById(anyLong());
		verify(userRealmToRealmResponse, never()).convert(any());
	}
	
	
}
