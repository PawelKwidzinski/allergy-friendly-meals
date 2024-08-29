package pl.kwidz.hista_food_ms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "histamine_foods")
public class HistamineFood {

    @Id
    private Integer id;
    private String compatibility;
    private String level;
    private String otherAmines;
    private String liberator;
    private String blocker;
    private String ingredient;
    private String remarks;
    private String subcategory;
    private String category;

}
