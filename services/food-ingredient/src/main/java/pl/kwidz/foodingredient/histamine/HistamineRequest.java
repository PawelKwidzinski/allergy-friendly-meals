package pl.kwidz.foodingredient.histamine;

public record HistamineRequest(
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
