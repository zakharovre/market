package ru.gb.market.msproduct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.gb.market.msproduct.models.entities.Product;


import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findProductByCostGreaterThanEqual(int minCost);

    List<Product> findProductByCostLessThanEqual(int maxCost);

    List<Product> findProductByCostBetween(int minCost, int maxCost);

    @Query("select p from Product p where p.name like %:str%")
    List<Product> findProductByRegex(String str);
}
