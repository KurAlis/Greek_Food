package net.tommybutz.greek_food.data;

import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.tommybutz.greek_food.greek_food;

public final class DataGenerators {
    private DataGenerators() {}

    public static void gatherData(GatherDataEvent event) {
        var generator = event.getGenerator();
        var output = generator.getPackOutput();
        var existing = event.getExistingFileHelper();
        var lookup = event.getLookupProvider();

        // CLIENT-SIDE DATA
        if (event.includeClient()) {
            generator.addProvider(true, new GreekFoodItemModels(output, existing));
            generator.addProvider(true, new ModBlockStateProvider(output, existing));
        }

        // SERVER-SIDE DATA
        if (event.includeServer()) {
            generator.addProvider(true, new GreekFoodCampfireRecipes(output, lookup));
            generator.addProvider(true, new ModBlockTagGenerator(output, lookup, existing));
            generator.addProvider(true, ModLootTableProvider.create(output, lookup));
        }
    }
}
