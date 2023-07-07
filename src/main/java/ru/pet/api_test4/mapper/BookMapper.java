package ru.pet.api_test4.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.pet.api_test4.dto.BookDto;
import ru.pet.api_test4.entities.BookEntity;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(source = "idBook", target = "idBook")
    @Mapping(source = "entity.nameBook", target = "nameBook")
    @Mapping(source = "entity.author", target = "author")
    @Mapping(source = "entity.genre", target = "genre")
    @Mapping(source = "entity.costBook", target = "costBook")
    @Mapping(source = "entity.countPages", target = "countPages")
    @Mapping(source = "entity.description", target = "description")
    BookDto toDto(BookEntity entity);

    @Mapping(source = "dto.idBook", target = "idBook")
    @Mapping(source = "dto.nameBook", target = "nameBook")
    @Mapping(source = "dto.author", target = "author")
    @Mapping(source = "dto.genre", target = "genre")
    @Mapping(source = "dto.costBook", target = "costBook")
    @Mapping(source = "dto.countPages", target = "countPages")
    @Mapping(source = "dto.description", target = "description")
    BookEntity toEntity(BookDto dto);
}
