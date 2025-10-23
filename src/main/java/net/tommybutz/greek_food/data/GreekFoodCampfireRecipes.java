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

        SimpleCookingRecipeBuilder.smoking(
                        Ingredient.of(croptopia("milk_bottle")),
                        RecipeCategory.FOOD,
                        ModItems.TZATZIKI.get(),
                        0.3f,
                        275
                )
                .unlockedBy("has_milk_bottle", has(croptopia("milk_bottle")))
                .save(output, ResourceLocation.fromNamespaceAndPath("greek_food", "tzatziki_from_smoking"));


        //Crafting table (shaped)

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
