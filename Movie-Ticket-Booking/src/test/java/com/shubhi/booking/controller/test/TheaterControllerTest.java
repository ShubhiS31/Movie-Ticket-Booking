
package com.shubhi.booking.controller.test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import com.shubhi.booking.dto.TheaterDTO;
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
public class TheaterControllerTest {

	@Autowired
	MockMvc mock;

	@MockBean
    RestClient clientMock;

	@Autowired
	MockHttpSession session;

	@MockBean
	ResponseEntity<List<TheaterDTO>> responseMock;

	@Test
	public void getTheaterSuccess() throws Exception {
		responseMock = new ResponseEntity<List<TheaterDTO>>(HttpStatus.OK);
		when(clientMock.getTheatersFromRestClient(Mockito.anyInt(), Mockito.anyInt())).thenReturn(responseMock);
		mock.perform(MockMvcRequestBuilders.get("/theater?movie=24567-notebook").sessionAttr("locationId", 111)
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		verify(clientMock).getTheatersFromRestClient(Mockito.anyInt(), Mockito.anyInt());

	}

	@Test
	public void getTheaterFail() throws Exception {

		responseMock = new ResponseEntity<List<TheaterDTO>>(HttpStatus.NO_CONTENT);
		when(clientMock.getTheatersFromRestClient(Mockito.anyInt(), Mockito.anyInt())).thenReturn(responseMock);
		mock.perform(MockMvcRequestBuilders.get("/theater?movie=24567-notebook").sessionAttr("locationId", 111)
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)).andExpect(status().isNoContent())
				.andReturn();
		verify(clientMock).getTheatersFromRestClient(Mockito.anyInt(), Mockito.anyInt());

	}

}
