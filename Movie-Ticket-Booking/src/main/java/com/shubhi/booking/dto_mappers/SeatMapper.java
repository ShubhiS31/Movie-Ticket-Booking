package com.shubhi.booking.dto_mappers;

import java.util.List;

import com.shubhi.booking.dto.SeatDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.shubhi.booking.entity.Seat;
import com.shubhi.booking.exceptions.NoSeatsFoundException;

@Mapper(componentModel = "spring")
public interface SeatMapper {

	SeatMapper MAPPER = Mappers.getMapper(SeatMapper.class);

	SeatDTO toSeatDTO(Seat seat) throws NoSeatsFoundException;

	List<SeatDTO> toSeatDTOs(List<Seat> seats) throws NoSeatsFoundException;

	Seat toSeat(SeatDTO seatDTO);

}
