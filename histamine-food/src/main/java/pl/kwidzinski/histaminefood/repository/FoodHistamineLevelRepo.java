package pl.kwidzinski.histaminefood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kwidzinski.histaminefood.model.FoodHistamineLevel;

@Repository
public interface FoodHistamineLevelRepo extends JpaRepository<FoodHistamineLevel, Integer> {
}
