package com.shubhi.booking.restcontroller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@SpringBootTest
@WithMockUser(username = "mock", password = "mock", roles = "user")
class RestDataControllerTest {

	static final String URI = "http://localhost:8081/";

	@Test
	 public void getLocationsSuccess() {
		RestAssured.baseURI = URI;
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET, "locations");
		int statusCode = response.getStatusCode();
		assertEquals(200, statusCode);
	}

	@Test
	 public void getMoviesSuccess() {
		RestAssured.baseURI = URI;
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET, "movie/111");
		int statusCode = response.getStatusCode();
		assertEquals(200, statusCode);
	}

	@Test
	 public void getMoviesFail() {
		RestAssured.baseURI = URI;
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET, "movie/1");
		int statusCode = response.getStatusCode();
		assertEquals(204, statusCode);
	}

	@Test
	 public void getTheaterSuccess() {
		RestAssured.baseURI = URI;
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET, "theater/111/13456");
		int statusCode = response.getStatusCode();
		assertEquals(200, statusCode);
	}

	@Test
	 public void getTheaterFail() {
		RestAssured.baseURI = URI;
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET, "theater/111/1");
		int statusCode = response.getStatusCode();
		assertEquals(204, statusCode);
	}

	@Test
	 public void getDateSuccess() {
		RestAssured.baseURI = URI;
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET, "dates");
		int statusCode = response.getStatusCode();
		assertEquals(200, statusCode);
	}

	@Test
	 public void getScreenSuccess() {
		RestAssured.baseURI = URI;
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET, "screen/13456/3344");
		int statusCode = response.getStatusCode();
		assertEquals(200, statusCode);
	}

	@Test
	 public void getScreenFail() {
		RestAssured.baseURI = URI;
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET, "screen/45/45");
		int statusCode = response.getStatusCode();
		assertEquals(204, statusCode);
	}

	@Test
	 public void getBookedSeatsSuccess() {
		RestAssured.baseURI = URI;
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET, "seat/carnival cinemas/2019-12-03/21:00/1");
		int statusCode = response.getStatusCode();
		assertEquals(200, statusCode);
	}

	@Test
	 public void getTotalSeatsSuccess() {
		RestAssured.baseURI = URI;
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET, "totalSeats");
		int statusCode = response.getStatusCode();
		assertEquals(200, statusCode);
	}

	@Test
	 public void TotalSeatsFail() {
		RestAssured.baseURI = URI;
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET, "totalSeat");
		int statusCode = response.getStatusCode();
		assertEquals(404, statusCode);
	}

	@Test
	 public void saveTicketFail() {
		RestAssured.baseURI = URI;
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET, "bookTicket");
		int statusCode = response.getStatusCode();
		assertEquals(400, statusCode);
	}

}
