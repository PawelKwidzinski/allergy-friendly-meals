package pl.kwidz.foodingredient.histamine;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

interface HistamineRepository extends MongoRepository<Histamine, String> {

    List<Histamine> findHistamineByIngredientContainingIgnoreCase(String ingredient);
}
