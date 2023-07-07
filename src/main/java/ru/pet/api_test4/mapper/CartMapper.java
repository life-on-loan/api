package ru.pet.api_test4.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.pet.api_test4.dto.CartDto;
import ru.pet.api_test4.entities.CartEntity;

@Mapper(componentModel = "spring")
public interface CartMapper {
    @Mapping(source = "idCart", target = "idCart")
    @Mapping(source = "entity.nameBooks", target = "nameBooks")
    @Mapping(source = "entity.costBooks", target = "costBooks")
    @Mapping(source = "entity.countBooks", target = "countBooks")
    CartDto toDto(CartEntity entity);

    @Mapping(source = "dto.idCart", target = "idCart")
    @Mapping(source = "dto.nameBooks", target = "nameBooks")
    @Mapping(source = "dto.costBooks", target = "costBooks")
    @Mapping(source = "dto.countBooks", target = "countBooks")
    CartEntity toEntity(CartDto dto);
}
