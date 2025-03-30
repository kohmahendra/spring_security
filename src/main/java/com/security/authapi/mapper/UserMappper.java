package com.security.authapi.mapper;

import com.security.authapi.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMappper {
    com.security.authapi.dtos.User getUserDto(User source);
}
