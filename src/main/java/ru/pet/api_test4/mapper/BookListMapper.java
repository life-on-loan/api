package ru.pet.api_test4.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.pet.api_test4.dto.BookDto;
import ru.pet.api_test4.entities.BookEntity;

import java.util.List;

@Mapper(componentModel = "spring", uses = BookMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BookListMapper {
    List<BookEntity> toBookEntityList(List<BookDto> dtoList);
    List<BookDto> toBookDtoList(List<BookEntity> entityList);
}
