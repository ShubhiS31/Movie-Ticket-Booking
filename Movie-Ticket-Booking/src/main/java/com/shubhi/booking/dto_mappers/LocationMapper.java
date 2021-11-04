package com.shubhi.booking.dto_mappers;

import java.util.List;

import com.shubhi.booking.dto.LocationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.shubhi.booking.entity.Location;

@Mapper(componentModel = "spring")
public interface LocationMapper {

	LocationMapper MAPPER = Mappers.getMapper(LocationMapper.class);

	LocationDTO toLocationDTO(Location location);

	List<LocationDTO> toLocationDTOs(List<Location> locations);

	Location toLocation(LocationDTO locationDTO);

}
