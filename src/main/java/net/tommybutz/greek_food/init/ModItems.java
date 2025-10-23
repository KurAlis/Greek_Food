package net.tommybutz.greek_food.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.tommybutz.greek_food.greek_food;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, greek_food.MOD_ID);


    public static final Supplier<Item> GREEK_PITA =
            ITEMS.register("greek_pita", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(2)        // hunger restored (1=half-bar)
                                    .saturationModifier(0.2f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> FROZEN_GREEK_PITA =
            ITEMS.register("frozen_greek_pita", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(1)        // hunger restored (1=half-bar)
                                    .saturationModifier(0.1f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> GREEK_PITA_OILED =
            ITEMS.register("greek_pita_oiled", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(3)        // hunger restored (1=half-bar)
                                    .saturationModifier(0.25f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> GRILLED_GREEK_PITA =
            ITEMS.register("grilled_greek_pita", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(5)        // hunger restored (1=half-bar)
                                    .saturationModifier(0.275f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> TZATZIKI =
            ITEMS.register("tzatziki", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(3)        // hunger restored (1=half-bar)
                                    .saturationModifier(0.2f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> RAW_GYROS_CHICKEN =
            ITEMS.register("raw_gyros_chicken", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(2)        // hunger restored (1=half-bar)
                                    .saturationModifier(0.3f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> RAW_GYROS_BEEF =
            ITEMS.register("raw_gyros_beef", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(2)        // hunger restored (1=half-bar)
                                    .saturationModifier(0.3f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> GYROS_CHICKEN =
            ITEMS.register("gyros_chicken", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(6)        // hunger restored (1=half-bar)
                                    .saturationModifier(0.4f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> GYROS_BEEF =
            ITEMS.register("gyros_beef", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(6)        // hunger restored (1=half-bar)
                                    .saturationModifier(0.4f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> RAW_KEBAB =
            ITEMS.register("raw_kebab", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(3)        // hunger restored (1=half-bar)
                                    .saturationModifier(0.3f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> KEBAB =
            ITEMS.register("kebab", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(6)        // hunger restored (1=half-bar)
                                    .saturationModifier(0.5f) // saturation multiplier
                                    .build()
                    )
            ));
}
