
package com.shubhi.booking.controller.test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import com.shubhi.booking.rest.client.RestClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest

@AutoConfigureMockMvc

@WithMockUser(username = "mock", password = "mock", roles = "user")
public class DateControllerTest {

	@Autowired
	MockMvc mock;

	@MockBean
    RestClient clientMock;

	@MockBean
	ResponseEntity<List<String>> response;

	@Test
	public void getDateSuccess() throws Exception {

		response = new ResponseEntity<List<String>>(HttpStatus.OK);
		when(clientMock.getDatesFromRestClient()).thenReturn(response);
		mock.perform(MockMvcRequestBuilders.get("/date?theater=4455-carnival+cinemas")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		verify(clientMock).getDatesFromRestClient();

	}

	@Test
	public void getDateFail() throws Exception {

		response = new ResponseEntity<List<String>>(HttpStatus.BAD_REQUEST);
		when(clientMock.getDatesFromRestClient()).thenReturn(response);
		mock.perform(MockMvcRequestBuilders.get("/date?theater=4455-carnival+cinemas")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest())
				.andReturn();
		verify(clientMock).getDatesFromRestClient();

	}

}
