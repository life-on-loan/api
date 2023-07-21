package ru.pet.api_test4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pet.api_test4.entities.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer> {
}
