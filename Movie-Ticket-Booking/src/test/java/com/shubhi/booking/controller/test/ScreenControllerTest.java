
package com.shubhi.booking.controller.test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.shubhi.booking.dto.ScreenDTO;
import com.shubhi.booking.rest.client.RestClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest

@AutoConfigureMockMvc

@WithMockUser(username = "mock", password = "mock", roles = "user")
public class ScreenControllerTest {

	@Autowired
	MockMvc mock;

	@MockBean
    RestClient clientMock;

	@Autowired
	MockHttpSession session;

	@MockBean
	ResponseEntity<ScreenDTO> response;

	@MockBean
	ScreenDTO screen;

	@Test
	public void getScreenSuccess() throws Exception {

		response = new ResponseEntity<ScreenDTO>(screen, HttpStatus.OK);
		when(clientMock.getScreenTimesFromRestClient(Mockito.anyInt(), Mockito.anyInt())).thenReturn(response);
		when(response.getBody().getScreenId()).thenReturn(2);
		mock.perform(MockMvcRequestBuilders.get("/screen?date=2019-12-06").sessionAttr("movieId", 1234)
				.sessionAttr("theaterId", 2314).accept(org.springframework.http.MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		verify(clientMock).getScreenTimesFromRestClient(Mockito.anyInt(), Mockito.anyInt());

	}

	@Test
	public void getScreenFail() throws Exception {

		response = new ResponseEntity<ScreenDTO>(screen, HttpStatus.NO_CONTENT);
		when(clientMock.getScreenTimesFromRestClient(Mockito.anyInt(), Mockito.anyInt())).thenReturn(response);
		when(response.getBody().getScreenId()).thenReturn(2);
		mock.perform(MockMvcRequestBuilders.get("/screen?date=2019-12-06").sessionAttr("movieId", 1234)
				.sessionAttr("theaterId", 2314).accept(org.springframework.http.MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent()).andReturn();
		verify(clientMock).getScreenTimesFromRestClient(Mockito.anyInt(), Mockito.anyInt());

	}

}
