package ru.pet.api_test4.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.pet.api_test4.dto.CartDto;
import ru.pet.api_test4.entities.CartEntity;

import java.util.List;

@Mapper(componentModel = "spring", uses = CartMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CartListMapper {
    List<CartEntity> toCartEntityList(List<CartDto> dtoList);
    List<CartDto> toCartDtoList(List<CartEntity> entityList);
}
