package ru.gb.market.msproduct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.market.msproduct.models.entities.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findCategoryByName(String name);
}
