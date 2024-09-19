package pl.pkwidz.dashboard.dto;

public record HistamineFoodDto(
        Integer id,
        String compatibility,
        String level,
        String otherAmines,
        String liberator,
        String blocker,
        String ingredient,
        String remarks,
        String subcategory,
        String category
) { }
