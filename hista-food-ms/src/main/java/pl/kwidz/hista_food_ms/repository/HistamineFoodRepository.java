package pl.kwidz.hista_food_ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.kwidz.hista_food_ms.model.HistamineFood;

import java.util.List;

public interface HistamineFoodRepository extends JpaRepository<HistamineFood, Integer> {

    @Query("SELECT f FROM HistamineFood f where f.ingredient LIKE %:name%")
    List<HistamineFood> findIngredientsByName(String name);
}
