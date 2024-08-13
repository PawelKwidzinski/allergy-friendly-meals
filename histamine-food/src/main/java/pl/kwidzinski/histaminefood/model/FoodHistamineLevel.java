package pl.kwidzinski.histaminefood.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "food_histamine_levels")
public class FoodHistamineLevel {

    @Id
    private Integer id;
    private Integer compatibility;
    private String histamineScore;
    private String amines;
    private String liberators;
    private String blockers;
    private String foodItem;
    private String notes;
    private String foodSubcategory;
    private String foodCategory;
}
