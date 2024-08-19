package pl.kwidzinski.histaminefood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kwidzinski.histaminefood.model.HistamineLevel;

import java.util.List;

@Repository
public interface HistamineLevelRepo extends JpaRepository<HistamineLevel, Integer> {

    @Query("SELECT f FROM HistamineLevel f where f.ingredient LIKE %:name%")
    List<HistamineLevel> findIngredientsByName(String name);
}
