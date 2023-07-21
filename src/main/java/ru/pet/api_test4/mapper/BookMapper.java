package ru.pet.api_test4.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.pet.api_test4.dto.BookDto;
import ru.pet.api_test4.entities.BookEntity;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(source = "idBook", target = "idBook")
    @Mapping(source = "nameBook", target = "nameBook")
    @Mapping(source = "author", target = "author")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "costBook", target = "costBook")
    @Mapping(source = "countPages", target = "countPages")
    @Mapping(source = "description", target = "description")
    BookDto toDto(BookEntity entity);

    @Mapping(source = "idBook", target = "idBook")
    @Mapping(source = "nameBook", target = "nameBook")
    @Mapping(source = "author", target = "author")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "costBook", target = "costBook")
    @Mapping(source = "countPages", target = "countPages")
    @Mapping(source = "description", target = "description")
    @Mapping(target = "cartElements", ignore = true)
    BookEntity toEntity(BookDto dto);
}
