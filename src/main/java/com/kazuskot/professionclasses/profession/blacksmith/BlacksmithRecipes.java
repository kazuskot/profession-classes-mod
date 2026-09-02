package com.kazuskot.professionclasses.profession.blacksmith;

import java.util.*;

public class BlacksmithRecipes {
    
    public static final Set<String> LEVEL_1_RECIPES = Set.of(
        "wooden_pickaxe",
        "wooden_axe",
        "wooden_shovel",
        "wooden_hoe",
        "wooden_sword"
    );

    public static final Set<String> LEVEL_2_RECIPES = Set.copyOf(
        new HashSet<>(LEVEL_1_RECIPES)
    );

    public static final Set<String> LEVEL_3_RECIPES = Set.copyOf(
        new HashSet<>(LEVEL_2_RECIPES)
    );

    public static final Set<String> LEVEL_4_RECIPES = Set.copyOf(
        new HashSet<>(LEVEL_3_RECIPES)
    );

    public static final Set<String> LEVEL_5_RECIPES = Set.copyOf(
        new HashSet<>(LEVEL_4_RECIPES)
    );

    public static final Set<String> LEVEL_6_RECIPES = Set.copyOf(
        new HashSet<>(LEVEL_5_RECIPES)
    );

    public static final Set<String> LEVEL_7_RECIPES = Set.copyOf(
        new HashSet<>(LEVEL_6_RECIPES)
    );

    static {
        // Уровень 2: Каменные инструменты
        ((HashSet<String>) LEVEL_2_RECIPES).addAll(Set.of(
            "stone_pickaxe",
            "stone_axe",
            "stone_shovel",
            "stone_hoe",
            "stone_sword"
        ));

        // Уровень 3: Медные инструменты
        ((HashSet<String>) LEVEL_3_RECIPES).addAll(Set.of(
            "copper_pickaxe",
            "copper_axe",
            "copper_shovel",
            "copper_hoe",
            "copper_sword"
        ));

        // Уровень 4: Железные инструменты (база перед подклассами)
        ((HashSet<String>) LEVEL_4_RECIPES).addAll(Set.of(
            "iron_pickaxe",
            "iron_axe",
            "iron_shovel",
            "iron_hoe",
            "iron_sword",
            "iron_helmet",
            "iron_chestplate",
            "iron_leggings",
            "iron_boots"
        ));

        // Уровень 5: Алмазные инструменты
        ((HashSet<String>) LEVEL_5_RECIPES).addAll(Set.of(
            "diamond_pickaxe",
            "diamond_axe",
            "diamond_shovel",
            "diamond_hoe",
            "diamond_sword",
            "diamond_helmet",
            "diamond_chestplate",
            "diamond_leggings",
            "diamond_boots"
        ));

        // Уровень 6: Специальные рецепты
        ((HashSet<String>) LEVEL_6_RECIPES).addAll(Set.of(
            "netherite_pickaxe",
            "netherite_axe",
            "netherite_shovel",
            "netherite_hoe",
            "netherite_sword",
            "netherite_helmet",
            "netherite_chestplate",
            "netherite_leggings",
            "netherite_boots",
            "enchanted_golden_apple"
        ));

        // Уровень 7: Мастерство
        ((HashSet<String>) LEVEL_7_RECIPES).addAll(Set.of(
            "smithing_table",
            "anvil",
            "grindstone"
        ));
    }

    public static Set<String> getRecipesForLevel(int level) {
        return switch (level) {
            case 1 -> LEVEL_1_RECIPES;
            case 2 -> LEVEL_2_RECIPES;
            case 3 -> LEVEL_3_RECIPES;
            case 4 -> LEVEL_4_RECIPES;
            case 5 -> LEVEL_5_RECIPES;
            case 6 -> LEVEL_6_RECIPES;
            default -> LEVEL_7_RECIPES;
        };
    }

    public static boolean canCraft(int level, String recipeName) {
        for (int i = level; i >= 1; i--) {
            if (getRecipesForLevel(i).contains(recipeName)) {
                return true;
            }
        }
        return false;
    }
}
