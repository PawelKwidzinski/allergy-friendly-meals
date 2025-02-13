package pl.kwidz.foodingredient.histamine;

public record HistamineResponse(
        String id,
        String compatibility,
        String level,
        String otherAmines,
        String liberator,
        String blocker,
        String ingredient,
        String remarks,
        String subcategory,
        String category
) {
}
