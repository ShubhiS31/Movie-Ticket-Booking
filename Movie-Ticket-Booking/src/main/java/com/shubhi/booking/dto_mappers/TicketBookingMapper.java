package com.shubhi.booking.dto_mappers;

import com.shubhi.booking.dto.TicketBookingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.shubhi.booking.entity.TicketBooking;

@Mapper(componentModel = "spring")
public interface TicketBookingMapper {

	TicketBookingMapper MAPPER = Mappers.getMapper(TicketBookingMapper.class);

	TicketBookingDTO toTicketBookingDTO(TicketBooking ticket);

	TicketBooking toTicketBooking(TicketBookingDTO locationDTO);

}
