package ru.pet.api_test4.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.pet.api_test4.entities.BookEntity;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {
}
