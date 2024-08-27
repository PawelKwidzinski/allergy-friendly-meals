package pl.pkwidzinski.ingredient_mgmt_ms.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@RequiredArgsConstructor
public class Ingredient extends BaseDocument{

    private String name;
    private String foodSubcategory;
    private String foodCategory;
    private Integer histLevelId;
}
