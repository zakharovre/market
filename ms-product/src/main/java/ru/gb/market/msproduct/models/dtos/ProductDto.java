package ru.gb.market.msproduct.models.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.gb.market.msproduct.models.entities.Category;
import ru.gb.market.msproduct.models.entities.Product;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class ProductDto {
    private int id;
    private String name;
    private int cost;
    private String[] categories;

    public ProductDto(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.cost = product.getCost();
        this.categories = product.getCategories().stream().map(Category::getName).toArray(String[]::new);
    }

}
