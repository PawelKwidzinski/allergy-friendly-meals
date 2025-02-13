package pl.kwidz.foodingredient.histamine;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Document(collection = "histamine_foods")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Histamine {

    String _id;
    String compatibility;
    String level;
    String otherAmines;
    String liberator;
    String blocker;
    String ingredient;
    String remarks;
    String subcategory;
    String category;

}
