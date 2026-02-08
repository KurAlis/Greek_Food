package net.tommybutz.greek_food.data;

import com.google.gson.JsonObject;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.tommybutz.greek_food.blocks.ModBlocks;
import net.tommybutz.greek_food.init.ModItems;

import java.util.concurrent.CompletableFuture;

public class GreekFoodCampfireRecipes extends RecipeProvider {

    public GreekFoodCampfireRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }


    //campfire recipes

    @Override
    protected void buildRecipes(RecipeOutput output) {
        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(ModItems.GREEK_PITA_OILED.get()),
                        RecipeCategory.FOOD,
                        ModItems.GRILLED_GREEK_PITA.get(),
                        0.35f,
                        300
                )
                .unlockedBy("has_greek_pita_oiled", has(ModItems.GREEK_PITA_OILED.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("greek_food", "grilled_greek_pita_from_campfire"));

        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(ModItems.RAW_KEBAB.get()),
                        RecipeCategory.FOOD,
                        ModItems.KEBAB.get(),
                        0.35f,
                        300
                )
                .unlockedBy("has_raw_kebab", has(ModItems.RAW_KEBAB.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("greek_food", "kebab_from_campfire"));

        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(ModItems.RAW_FRENCH_FRIES.get()),
                        RecipeCategory.FOOD,
                        croptopia("french_fries"),
                        0.35f,
                        225
                )
                .unlockedBy("has_raw_french_fries", has(ModItems.RAW_FRENCH_FRIES.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("greek_food", "french_fries_from_campfire"));


        SimpleCookingRecipeBuilder.smoking(
                        Ingredient.of(croptopia("milk_bottle")),
                        RecipeCategory.FOOD,
                        ModItems.GREEK_YOGHURT.get(),
                        0.3f,
                        205
                )
                .unlockedBy("has_milk_bottle", has(croptopia("milk_bottle")))
                .save(output, ResourceLocation.fromNamespaceAndPath("greek_food", "greek_yoghurt_from_smoking"));


        //Crafting table (shaped)

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.TZATZIKI.get(), 3)
                .pattern("   ")
                .pattern("YCY")
                .pattern("   ")
                .define('Y', ModItems.GREEK_YOGHURT.get())
                .define('C', croptopia("cucumber"))
                .unlockedBy("has_greek_yoghurt", has(ModItems.GREEK_YOGHURT.get()))
                .save(output, id("tzatziki"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.GREEK_PITA_OILED.get())
                .pattern("   ")
                .pattern("GO ")
                .pattern("   ")
                .define('G', ModItems.GREEK_PITA.get())
                .define('O', croptopia("olive"))
                .unlockedBy("has_greekpita", has(ModItems.GREEK_PITA.get()))
                .save(output, id("greek_pita_oiled"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.GREEK_PITA.get(), 3)
                .pattern("WWW")
                .pattern(" B ")
                .pattern("WWW")
                .define('B', Items.WATER_BUCKET)
                .define('W', croptopia("flour"))
                .unlockedBy("has_wheat", has(Items.WHEAT))
                .save(output, id("greek_pita"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.GYROS_CHICKEN_FULL.get(), 1)
                .pattern("WWW")
                .pattern("WBW")
                .pattern("WWW")
                .define('B', Items.CHAIN)
                .define('W', Items.CHICKEN)
                .unlockedBy("has_chicken", has(Items.CHICKEN))
                .save(output, id("gyros_chicken_full"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.GYROS_BEEF_FULL.get(), 1)
                .pattern("WWW")
                .pattern("WBW")
                .pattern("WWW")
                .define('B', Items.CHAIN)
                .define('W', Items.BEEF)
                .unlockedBy("has_beef", has(Items.BEEF))
                .save(output, id("gyros_beef_full"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.RAW_KEBAB.get(), 4)
                .pattern("KKK")
                .pattern("OCO")
                .pattern("CCC")
                .define('K', Items.KELP)
                .define('O', croptopia("olive"))
                .define('C', Items.CHICKEN)
                .unlockedBy("has_chicken", has(Items.CHICKEN))
                .save(output, id("raw_kebab"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.RAW_KEBAB.get(), 4)
                .pattern("KKK")
                .pattern("OCO")
                .pattern("CCC")
                .define('K', Items.KELP)
                .define('O', croptopia("olive"))
                .define('C', Items.MUTTON)
                .unlockedBy("has_mutton", has(Items.MUTTON))
                .save(output, id("raw_kebab2"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.RAW_KEBAB.get(), 4)
                .pattern("KKK")
                .pattern("OCO")
                .pattern("CCC")
                .define('K', Items.KELP)
                .define('O', croptopia("olive"))
                .define('C', Items.BEEF)
                .unlockedBy("has_beef", has(Items.BEEF))
                .save(output, id("raw_kebab3"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SPINACH_PIE.get(), 2)
                .pattern("CSC")
                .pattern("DSD")
                .pattern("   ")
                .define('C', croptopia("cheese"))
                .define('D', vectorwing.farmersdelight.common.registry.ModItems.WHEAT_DOUGH.get())
                .define('S', croptopia("spinach"))
                .unlockedBy("has_wheat", has(Items.WHEAT))
                .save(output, id("spinach_pie"));

        //BLOCKS

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModBlocks.GYROS_WARMER.get(), 2)
                .pattern("BBB")
                .pattern("SCS")
                .pattern("LLL")
                .define('B', Items.IRON_BLOCK)
                .define('S', Items.COBBLESTONE)
                .define('L', Items.COBBLESTONE_SLAB)
                .define('C', Items.IRON_BARS)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(output, id("gyros_warmer"));

        //SOUVLAKIA

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SOUVLAKI_APO_OLA.get(), 1)
                .pattern("KNM")
                .pattern("P C")
                .pattern("XXX")
                .define('K', vectorwing.farmersdelight.common.registry.ModItems.ONION.get())
                .define('N', vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get())
                .define('M', croptopia("lettuce"))
                .define('P', ModItems.GRILLED_GREEK_PITA.get())
                .define('X', Items.PAPER)
                .define('C', ModItems.GYROS_CHICKEN.get())
                .unlockedBy("has_paper", has(Items.PAPER))
                .save(output, id("souvlaki_apo_ola"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SOUVLAKI_APO_OLA_TZATZIKI.get(), 1)
                .pattern("KNM")
                .pattern("PTC")
                .pattern("XXX")
                .define('K', vectorwing.farmersdelight.common.registry.ModItems.ONION.get())
                .define('N', vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get())
                .define('M', croptopia("lettuce"))
                .define('P', ModItems.GRILLED_GREEK_PITA.get())
                .define('X', Items.PAPER)
                .define('C', ModItems.GYROS_CHICKEN.get())
                .define('T', ModItems.TZATZIKI.get())
                .unlockedBy("has_paper", has(Items.PAPER))
                .save(output, id("souvlaki_apo_ola_tzatziki"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SOUVLAKI_XWRIS_KREMIDI.get(), 1)
                .pattern(" NM")
                .pattern("P C")
                .pattern("XXX")
                .define('N', vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get())
                .define('M', croptopia("lettuce"))
                .define('P', ModItems.GRILLED_GREEK_PITA.get())
                .define('X', Items.PAPER)
                .define('C', ModItems.GYROS_CHICKEN.get())
                .unlockedBy("has_paper", has(Items.PAPER))
                .save(output, id("souvlaki_xwris_kremidi"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SOUVLAKI_XWRIS_KREMIDI_TZATZIKI.get(), 1)
                .pattern(" NM")
                .pattern("PTC")
                .pattern("XXX")
                .define('N', vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get())
                .define('M', croptopia("lettuce"))
                .define('P', ModItems.GRILLED_GREEK_PITA.get())
                .define('X', Items.PAPER)
                .define('C', ModItems.GYROS_CHICKEN.get())
                .define('T', ModItems.TZATZIKI.get())
                .unlockedBy("has_paper", has(Items.PAPER))
                .save(output, id("souvlaki_xwris_kremidi_tzatziki"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SOUVLAKI_XWRIS_KREMIDI_NTOMATA.get(), 1)
                .pattern("  M")
                .pattern("P C")
                .pattern("XXX")
                .define('M', croptopia("lettuce"))
                .define('P', ModItems.GRILLED_GREEK_PITA.get())
                .define('X', Items.PAPER)
                .define('C', ModItems.GYROS_CHICKEN.get())
                .unlockedBy("has_paper", has(Items.PAPER))
                .save(output, id("souvlaki_xwris_kremidi_ntomata"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SOUVLAKI_XWRIS_KREMIDI_NTOMATA_TZATZIKI.get(), 1)
                .pattern("  M")
                .pattern("PTC")
                .pattern("XXX")
                .define('M', croptopia("lettuce"))
                .define('P', ModItems.GRILLED_GREEK_PITA.get())
                .define('X', Items.PAPER)
                .define('C', ModItems.GYROS_CHICKEN.get())
                .define('T', ModItems.TZATZIKI.get())
                .unlockedBy("has_paper", has(Items.PAPER))
                .save(output, id("souvlaki_xwris_kremidi_ntomata_tzatziki"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SOUVLAKI_XWRIS_KREMIDI_MAROULI.get(), 1)
                .pattern(" N ")
                .pattern("P C")
                .pattern("XXX")
                .define('N', vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get())
                .define('P', ModItems.GRILLED_GREEK_PITA.get())
                .define('X', Items.PAPER)
                .define('C', ModItems.GYROS_CHICKEN.get())
                .unlockedBy("has_paper", has(Items.PAPER))
                .save(output, id("souvlaki_xwris_kremidi_marouli"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SOUVLAKI_XWRIS_KREMIDI_MAROULI_TZATZIKI.get(), 1)
                .pattern(" N ")
                .pattern("PTC")
                .pattern("XXX")
                .define('N', vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get())
                .define('P', ModItems.GRILLED_GREEK_PITA.get())
                .define('X', Items.PAPER)
                .define('C', ModItems.GYROS_CHICKEN.get())
                .define('T', ModItems.TZATZIKI.get())
                .unlockedBy("has_paper", has(Items.PAPER))
                .save(output, id("souvlaki_xwris_kremidi_marouli_tzatziki"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SOUVLAKI_XWRIS_NTOMATA.get(), 1)
                .pattern("K M")
                .pattern("P C")
                .pattern("XXX")
                .define('K', vectorwing.farmersdelight.common.registry.ModItems.ONION.get())
                .define('M', croptopia("lettuce"))
                .define('P', ModItems.GRILLED_GREEK_PITA.get())
                .define('X', Items.PAPER)
                .define('C', ModItems.GYROS_CHICKEN.get())
                .unlockedBy("has_paper", has(Items.PAPER))
                .save(output, id("souvlaki_xwris_ntomata"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SOUVLAKI_XWRIS_NTOMATA_TZATZIKI.get(), 1)
                .pattern("K M")
                .pattern("PTC")
                .pattern("XXX")
                .define('K', vectorwing.farmersdelight.common.registry.ModItems.ONION.get())
                .define('M', croptopia("lettuce"))
                .define('P', ModItems.GRILLED_GREEK_PITA.get())
                .define('X', Items.PAPER)
                .define('C', ModItems.GYROS_CHICKEN.get())
                .define('T', ModItems.TZATZIKI.get())
                .unlockedBy("has_paper", has(Items.PAPER))
                .save(output, id("souvlaki_xwris_ntomata_tzatziki"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SOUVLAKI_XWRIS_NTOMATA_MAROULI.get(), 1)
                .pattern("K  ")
                .pattern("P C")
                .pattern("XXX")
                .define('K', vectorwing.farmersdelight.common.registry.ModItems.ONION.get())
                .define('P', ModItems.GRILLED_GREEK_PITA.get())
                .define('X', Items.PAPER)
                .define('C', ModItems.GYROS_CHICKEN.get())
                .unlockedBy("has_paper", has(Items.PAPER))
                .save(output, id("souvlaki_xwris_ntomata_marouli"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SOUVLAKI_XWRIS_NTOMATA_MAROULI_TZATZIKI.get(), 1)
                .pattern("K  ")
                .pattern("PTC")
                .pattern("XXX")
                .define('K', vectorwing.farmersdelight.common.registry.ModItems.ONION.get())
                .define('P', ModItems.GRILLED_GREEK_PITA.get())
                .define('X', Items.PAPER)
                .define('C', ModItems.GYROS_CHICKEN.get())
                .define('T', ModItems.TZATZIKI.get())
                .unlockedBy("has_paper", has(Items.PAPER))
                .save(output, id("souvlaki_xwris_ntomata_marouli_tzatziki"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SOUVLAKI_XWRIS_MAROULI.get(), 1)
                .pattern("KN ")
                .pattern("P C")
                .pattern("XXX")
                .define('K', vectorwing.farmersdelight.common.registry.ModItems.ONION.get())
                .define('N', vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get())
                .define('P', ModItems.GRILLED_GREEK_PITA.get())
                .define('X', Items.PAPER)
                .define('C', ModItems.GYROS_CHICKEN.get())
                .unlockedBy("has_paper", has(Items.PAPER))
                .save(output, id("souvlaki_xwris_marouli"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SOUVLAKI_XWRIS_MAROULI_TZATZIKI.get(), 1)
                .pattern("KN ")
                .pattern("PTC")
                .pattern("XXX")
                .define('K', vectorwing.farmersdelight.common.registry.ModItems.ONION.get())
                .define('N', vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get())
                .define('P', ModItems.GRILLED_GREEK_PITA.get())
                .define('X', Items.PAPER)
                .define('C', ModItems.GYROS_CHICKEN.get())
                .define('T', ModItems.TZATZIKI.get())
                .unlockedBy("has_paper", has(Items.PAPER))
                .save(output, id("souvlaki_xwris_marouli_tzatziki"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SOUVLAKI_XWRIS_TIPOTA.get(), 1)
                .pattern("   ")
                .pattern("P C")
                .pattern("XXX")
                .define('P', ModItems.GRILLED_GREEK_PITA.get())
                .define('X', Items.PAPER)
                .define('C', ModItems.GYROS_CHICKEN.get())
                .unlockedBy("has_paper", has(Items.PAPER))
                .save(output, id("souvlaki_xwris_tipota"));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SOUVLAKI_XWRIS_TIPOTA_TZATZIKI.get(), 1)
                .pattern("   ")
                .pattern("PTC")
                .pattern("XXX")
                .define('P', ModItems.GRILLED_GREEK_PITA.get())
                .define('X', Items.PAPER)
                .define('C', ModItems.GYROS_CHICKEN.get())
                .define('T', ModItems.TZATZIKI.get())
                .unlockedBy("has_paper", has(Items.PAPER))
                .save(output, id("souvlaki_xwris_tipota_tzatziki"));

    }


    private static Item croptopia(String path) {
        return BuiltInRegistries.ITEM.get(
                ResourceLocation.tryParse("croptopia:" + path)
        );
    }

    private static net.minecraft.resources.ResourceLocation id(String path) {
        return net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("greek_food", path);
    }

    private JsonObject ingredient(String id) {
        JsonObject obj = new JsonObject();
        obj.addProperty("item", id);
        return obj;
    }

}
