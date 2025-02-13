package pl.kwidz.foodingredient.histamine;

import org.springframework.stereotype.Component;

@Component
public class HistamineMapper {

    public HistamineResponse toHistamineResponse(Histamine histamine) {
        return new HistamineResponse(
                histamine.get_id(),
                histamine.getCompatibility(),
                histamine.getLevel(),
                histamine.getOtherAmines(),
                histamine.getLiberator(),
                histamine.getBlocker(),
                histamine.getIngredient(),
                histamine.getRemarks(),
                histamine.getSubcategory(),
                histamine.getCategory()
        );
    }

    public Histamine toHistamine(HistamineRequest histamineRequest) {
        return Histamine.builder()
                .compatibility(histamineRequest.compatibility())
                .level(histamineRequest.level())
                .otherAmines(histamineRequest.otherAmines())
                .liberator(histamineRequest.liberator())
                .blocker(histamineRequest.blocker())
                .ingredient(histamineRequest.ingredient())
                .remarks(histamineRequest.remarks())
                .subcategory(histamineRequest.subcategory())
                .category(histamineRequest.category())
                .build();
    }
}
