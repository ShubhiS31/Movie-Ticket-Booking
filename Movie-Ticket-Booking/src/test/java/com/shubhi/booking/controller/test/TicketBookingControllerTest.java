
package com.shubhi.booking.controller.test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.shubhi.booking.dto.TicketBookingDTO;
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
class TicketBookingControllerTest {

	@Autowired
	MockMvc mock;

	@MockBean
    RestClient clientMock;

	@MockBean
	ResponseEntity<TicketBookingDTO> response;

	@Autowired
	MockHttpSession session;

	@MockBean
	TicketBookingDTO ticketData;

	@Test
	public void BookTicketSuccess() throws Exception {
		response = new ResponseEntity<TicketBookingDTO>(ticketData, HttpStatus.OK);
		when(clientMock.saveTicketData(Mockito.any(), Mockito.any())).thenReturn(response);
		mock.perform(MockMvcRequestBuilders.get("/bookTicket?seat=e1").sessionAttr("location", "bhopal")
				.sessionAttr("movie", "saaho").sessionAttr("theater", "pvr").sessionAttr("date", "2019-11-28")
				.sessionAttr("screen", 2).sessionAttr("showTime", "10.00")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)).andReturn();
		verify(clientMock).saveTicketData(Mockito.any(), Mockito.any());

	}

	@Test
	public void BookTicketFail() throws Exception {
		response = new ResponseEntity<TicketBookingDTO>(ticketData, HttpStatus.INTERNAL_SERVER_ERROR);
		when(clientMock.saveTicketData(Mockito.any(), Mockito.any())).thenReturn(response);
		mock.perform(MockMvcRequestBuilders.get("/bookTicket?seat=e1").sessionAttr("location", "bhopal")
				.sessionAttr("movie", "saaho").sessionAttr("theater", "pvr").sessionAttr("date", "2019-11-28")
				.sessionAttr("screen", 2).sessionAttr("showTime", "10.00")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)).andReturn();
		verify(clientMock).saveTicketData(Mockito.any(), Mockito.any());

	}

}
