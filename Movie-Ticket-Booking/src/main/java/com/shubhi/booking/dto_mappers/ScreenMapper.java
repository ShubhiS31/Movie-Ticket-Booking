package com.shubhi.booking.dto_mappers;

import com.shubhi.booking.dto.ScreenDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.shubhi.booking.entity.Screen;
import com.shubhi.booking.exceptions.NoScreenAvailableException;

@Mapper(componentModel = "spring")
public interface ScreenMapper {

	ScreenMapper MAPPER = Mappers.getMapper(ScreenMapper.class);

	ScreenDTO toScreenDTO(Screen screen) throws NoScreenAvailableException;

	Screen toScreen(ScreenDTO screenDTO);

}
