package pl.kwidz.hista_food_ms.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HistamineFoodDto {

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
