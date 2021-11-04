
package com.shubhi.booking.controller.test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import com.shubhi.booking.dto.MovieDTO;
import com.shubhi.booking.rest.client.RestClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
public class MovieControllerTest {

	@Autowired
	MockMvc mock;

	@MockBean
    RestClient clientMock;

	@MockBean
	ResponseEntity<List<MovieDTO>> response;

	@Test
	public void getMovieSuccess() throws Exception {

		response = new ResponseEntity<List<MovieDTO>>(HttpStatus.OK);
		when(clientMock.getMoviesFromRestClient(Mockito.anyInt())).thenReturn(response);
		mock.perform(MockMvcRequestBuilders.get("/Movie?location=111-hyderabad")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		verify(clientMock).getMoviesFromRestClient(Mockito.anyInt());

	}

	@Test
	public void getMovieFail() throws Exception {

		response = new ResponseEntity<List<MovieDTO>>(HttpStatus.NO_CONTENT);
		when(clientMock.getMoviesFromRestClient(Mockito.anyInt())).thenReturn(response);
		mock.perform(MockMvcRequestBuilders.get("/Movie?location=111-hyderabad")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)).andExpect(status().isNoContent())
				.andReturn();
		verify(clientMock).getMoviesFromRestClient(Mockito.anyInt());

	}

}
