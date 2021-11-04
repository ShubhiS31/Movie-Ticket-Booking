package com.shubhi.booking.dto_mappers;

import java.util.List;

import com.shubhi.booking.dto.TheaterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.shubhi.booking.entity.Theater;
import com.shubhi.booking.exceptions.TheaterNotFoundException;

@Mapper(componentModel = "spring")
public interface TheaterMapper {

	TheaterMapper MAPPER = Mappers.getMapper(TheaterMapper.class);

	TheaterDTO toTheaterDTO(Theater theater) throws TheaterNotFoundException;

	List<TheaterDTO> toTheaterDTOs(List<Theater> theaters) throws TheaterNotFoundException;

	Theater toTheater(TheaterDTO theaterDTO);

}
