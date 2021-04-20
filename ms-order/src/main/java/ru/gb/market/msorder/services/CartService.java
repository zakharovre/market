package ru.gb.market.msorder.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.market.msorder.models.dtos.Cart;
import ru.gb.market.msproduct.models.dtos.ProductDto;
import ru.gb.market.msproduct.repositories.ProductRepository;


@Service
@Data
@RequiredArgsConstructor
public class CartService {

    private final ProductRepository productRepository;

    private Cart cart = new Cart();

    public Cart showCart() {
        return cart;
    }

    public Cart addProduct(int id, int quantity) {
        ProductDto productDto = new ProductDto(productRepository.findById(id).get());
        cart.add(productDto, quantity);
        return cart;
    }

    public Cart removeProduct(int id, int quantity) {
        ProductDto productDto = new ProductDto(productRepository.findById(id).get());
        cart.remove(productDto, quantity);
        return cart;
    }
}
