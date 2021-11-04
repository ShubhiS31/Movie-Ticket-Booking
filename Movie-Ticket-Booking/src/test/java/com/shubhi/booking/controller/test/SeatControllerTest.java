
package com.shubhi.booking.controller.test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import com.shubhi.booking.dto.SeatDTO;
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
public class SeatControllerTest {

	@Autowired
	MockMvc mock;

	@MockBean
    RestClient clientMock;

	@Autowired
	MockHttpSession session;

	@MockBean
	ResponseEntity<List<String>> responseFromBookedSeatMock;

	@MockBean
	ResponseEntity<List<SeatDTO>> responseFromTotalSeatMock;

	@Test
	public void getSeatsSuccess() throws Exception {
		responseFromTotalSeatMock = new ResponseEntity<List<SeatDTO>>(HttpStatus.OK);
		when(clientMock.getBookedSeatsFromRestClient(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(),
				Mockito.anyInt())).thenReturn(responseFromBookedSeatMock);
		when(clientMock.getTotalSeatsFromRestClient()).thenReturn(responseFromTotalSeatMock);
		mock.perform(MockMvcRequestBuilders.get("/seat?time=11%3A00").sessionAttr("theater", "pvr")
				.sessionAttr("date", "2019-11-28").sessionAttr("showTime", "10:00").sessionAttr("screen", 2)
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		verify(clientMock).getBookedSeatsFromRestClient(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(),
				Mockito.anyInt());

	}

	@Test
	public void getSeatsFail() throws Exception {
		responseFromTotalSeatMock = new ResponseEntity<List<SeatDTO>>(HttpStatus.NO_CONTENT);
		when(clientMock.getBookedSeatsFromRestClient(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(),
				Mockito.anyInt())).thenReturn(responseFromBookedSeatMock);
		when(clientMock.getTotalSeatsFromRestClient()).thenReturn(responseFromTotalSeatMock);
		mock.perform(MockMvcRequestBuilders.get("/seat?time=11%3A00").sessionAttr("theater", "pvr")
				.sessionAttr("date", "2019-11-28").sessionAttr("showTime", "10:00").sessionAttr("screen", 2)
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)).andReturn();
		verify(clientMock).getBookedSeatsFromRestClient(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(),
				Mockito.anyInt());

	}

}
