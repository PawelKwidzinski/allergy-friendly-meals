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
    private String histamine;
    private String otherAmines;
    private String liberator;
    private String blocker;
    private String ingredient;
    private String remarks;
    private String foodSubcategory;
    private String foodCategory;
}
