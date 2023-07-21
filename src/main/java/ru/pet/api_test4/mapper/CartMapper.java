package ru.pet.api_test4.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.pet.api_test4.dto.CartDto;
import ru.pet.api_test4.entities.CartElement;
import ru.pet.api_test4.entities.CartEntity;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {
    @Mapping(source = "idCart", target = "idCart")
    @Mapping(source = "cartElements", target = "idBook", qualifiedByName = "mapBookId")
    @Mapping(source = "cartElements", target = "countBooks", qualifiedByName = "mapBookCount")
    CartDto toDto(CartEntity entity);

    @Named("mapBookId")
    default List<Integer> mapBookId(List<CartElement> value){
        List<Integer> bookId = new ArrayList<>();
        for (CartElement cartElement : value) {
            bookId.add(cartElement.getBook().getIdBook());
        }
        return bookId;
    }

    @Named("mapBookCount")
    default List<Integer> mapBookCount(List<CartElement> value){
        List<Integer> bookCount = new ArrayList<>();
        for (CartElement cartElement : value) {
            bookCount.add(cartElement.getAmount());
        }
        return bookCount;
    }
}
