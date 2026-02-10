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


    public static final Supplier<Item> SPINACH_PIE =
            ITEMS.register("spinach_pie", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(6)        // hunger restored (1=half-bar)
                                    .saturationModifier(0.45f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> GREEK_YOGHURT =
            ITEMS.register("greek_yoghurt", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(2)        // hunger restored (1=half-bar)
                                    .saturationModifier(0.2f) // saturation multiplier
                                    .build()
                    )
            ));

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

    public static final Supplier<Item> RAW_FRENCH_FRIES =
            ITEMS.register("raw_french_fries", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(6)        // hunger restored (1=half-bar)
                                    .saturationModifier(0.5f) // saturation multiplier
                                    .build()
                    )
            ));

    //CHICKEN SOUVLAKIA
    public static final Supplier<Item> SOUVLAKI_CHICKEN_APO_OLA =
            ITEMS.register("souvlaki_chicken_apo_ola", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(14)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.3f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_CHICKEN_APO_OLA_TZATZIKI =
            ITEMS.register("souvlaki_chicken_apo_ola_tzatziki", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(15)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.4f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_CHICKEN_XWRIS_KREMIDI =
            ITEMS.register("souvlaki_chicken_xwris_kremidi", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(12)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.1f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_CHICKEN_XWRIS_KREMIDI_TZATZIKI =
            ITEMS.register("souvlaki_chicken_xwris_kremidi_tzatziki", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(13)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.2f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_CHICKEN_XWRIS_NTOMATA =
            ITEMS.register("souvlaki_chicken_xwris_ntomata", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(12)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.1f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_CHICKEN_XWRIS_NTOMATA_TZATZIKI =
            ITEMS.register("souvlaki_chicken_xwris_ntomata_tzatziki", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(13)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.2f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_CHICKEN_XWRIS_MAROULI =
            ITEMS.register("souvlaki_chicken_xwris_marouli", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(12)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.1f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_CHICKEN_XWRIS_MAROULI_TZATZIKI =
            ITEMS.register("souvlaki_chicken_xwris_marouli_tzatziki", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(13)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.2f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_CHICKEN_XWRIS_KREMIDI_MAROULI =
            ITEMS.register("souvlaki_chicken_xwris_kremidi_marouli", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(12)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.1f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_CHICKEN_XWRIS_KREMIDI_MAROULI_TZATZIKI =
            ITEMS.register("souvlaki_chicken_xwris_kremidi_marouli_tzatziki", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(13)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.2f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_CHICKEN_XWRIS_KREMIDI_NTOMATA =
            ITEMS.register("souvlaki_chicken_xwris_kremidi_ntomata", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(12)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.1f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_CHICKEN_XWRIS_KREMIDI_NTOMATA_TZATZIKI =
            ITEMS.register("souvlaki_chicken_xwris_kremidi_ntomata_tzatziki", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(13)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.2f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_CHICKEN_XWRIS_NTOMATA_MAROULI =
            ITEMS.register("souvlaki_chicken_xwris_ntomata_marouli", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(12)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.1f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_CHICKEN_XWRIS_NTOMATA_MAROULI_TZATZIKI =
            ITEMS.register("souvlaki_chicken_xwris_ntomata_marouli_tzatziki", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(13)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.2f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_CHICKEN_XWRIS_TIPOTA =
            ITEMS.register("souvlaki_chicken_xwris_tipota", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(10)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.1f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_CHICKEN_XWRIS_TIPOTA_TZATZIKI =
            ITEMS.register("souvlaki_chicken_xwris_tipota_tzatziki", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(11)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.2f) // saturation multiplier
                                    .build()
                    )
            ));


    //BEEF SOUVLAKIA
    public static final Supplier<Item> SOUVLAKI_BEEF_APO_OLA =
            ITEMS.register("souvlaki_beef_apo_ola", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(14)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.3f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_BEEF_APO_OLA_TZATZIKI =
            ITEMS.register("souvlaki_beef_apo_ola_tzatziki", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(15)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.4f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_BEEF_XWRIS_KREMIDI =
            ITEMS.register("souvlaki_beef_xwris_kremidi", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(12)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.1f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_BEEF_XWRIS_KREMIDI_TZATZIKI =
            ITEMS.register("souvlaki_beef_xwris_kremidi_tzatziki", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(13)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.2f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_BEEF_XWRIS_NTOMATA =
            ITEMS.register("souvlaki_beef_xwris_ntomata", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(12)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.1f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_BEEF_XWRIS_NTOMATA_TZATZIKI =
            ITEMS.register("souvlaki_beef_xwris_ntomata_tzatziki", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(13)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.2f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_BEEF_XWRIS_MAROULI =
            ITEMS.register("souvlaki_beef_xwris_marouli", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(12)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.1f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_BEEF_XWRIS_MAROULI_TZATZIKI =
            ITEMS.register("souvlaki_beef_xwris_marouli_tzatziki", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(13)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.2f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_BEEF_XWRIS_KREMIDI_MAROULI =
            ITEMS.register("souvlaki_beef_xwris_kremidi_marouli", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(12)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.1f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_BEEF_XWRIS_KREMIDI_MAROULI_TZATZIKI =
            ITEMS.register("souvlaki_beef_xwris_kremidi_marouli_tzatziki", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(13)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.2f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_BEEF_XWRIS_KREMIDI_NTOMATA =
            ITEMS.register("souvlaki_beef_xwris_kremidi_ntomata", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(12)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.1f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_BEEF_XWRIS_KREMIDI_NTOMATA_TZATZIKI =
            ITEMS.register("souvlaki_beef_xwris_kremidi_ntomata_tzatziki", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(13)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.2f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_BEEF_XWRIS_NTOMATA_MAROULI =
            ITEMS.register("souvlaki_beef_xwris_ntomata_marouli", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(12)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.1f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_BEEF_XWRIS_NTOMATA_MAROULI_TZATZIKI =
            ITEMS.register("souvlaki_beef_xwris_ntomata_marouli_tzatziki", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(13)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.2f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_BEEF_XWRIS_TIPOTA =
            ITEMS.register("souvlaki_beef_xwris_tipota", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(10)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.1f) // saturation multiplier
                                    .build()
                    )
            ));

    public static final Supplier<Item> SOUVLAKI_BEEF_XWRIS_TIPOTA_TZATZIKI =
            ITEMS.register("souvlaki_beef_xwris_tipota_tzatziki", () -> new Item(
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(11)        // hunger restored (1=half-bar)
                                    .saturationModifier(1.2f) // saturation multiplier
                                    .build()
                    )
            ));


    public static final Supplier<Item> GYROS_CHICKEN_FULL =
            ITEMS.register("gyros_chicken_full", () -> new Item(new Item.Properties()));

    public static final Supplier<Item> GYROS_BEEF_FULL =
            ITEMS.register("gyros_beef_full", () -> new Item(new Item.Properties()));
}
