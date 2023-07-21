package ru.pet.api_test4.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "cart")
public class CartEntity {
    @Id
    @Column(name = "id_cart", nullable = false)
    @GeneratedValue(strategy = IDENTITY)
    Integer idCart;
    @Column(name = "cart_elements")
    @ElementCollection
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    List<CartElement> cartElements = new ArrayList<>();

    public List<CartElement> getCartElements() {
        return cartElements;
    }

    public void setCartElements(List<CartElement> cartElements) {
        this.cartElements = cartElements;
    }

    public Integer getIdCart() {
        return idCart;
    }

    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
    }
}
