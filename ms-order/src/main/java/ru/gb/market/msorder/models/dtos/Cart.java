package ru.gb.market.msorder.models.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.market.msproduct.models.dtos.ProductDto;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class Cart {
    private int totalPrice;
    private Map<ProductDto, Integer> cartItems = new HashMap<>();

    public void add(ProductDto productDto, int quantity) {
        totalPrice += productDto.getCost() * quantity;
        if (cartItems.containsKey(productDto))
            quantity += cartItems.get(productDto);
        cartItems.put(productDto, quantity);

    }

    public void remove(ProductDto productDto, int quantity) {
        if(!cartItems.containsKey(productDto))
            return;
        if (quantity < cartItems.get(productDto) && quantity != 0) {
            totalPrice -= productDto.getCost() * quantity;
            cartItems.put(productDto, cartItems.get(productDto) - quantity);
        } else {
            totalPrice -= productDto.getCost() * cartItems.get(productDto);
            cartItems.remove(productDto);
        }
    }
}
