package net.tommybutz.greek_food.data;

import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.tommybutz.greek_food.greek_food;

public final class DataGenerators {
    private DataGenerators() {} // prevent instantiation

    public static void gatherData(GatherDataEvent event) {
        var output = event.getGenerator().getPackOutput();
        var existing = event.getExistingFileHelper();

        if (event.includeClient()) {
            event.getGenerator().addProvider(true, new GreekFoodItemModels(output, existing));
        }

        event.getGenerator().addProvider(
                event.includeServer(),
                new GreekFoodCampfireRecipes(event.getGenerator().getPackOutput(), event.getLookupProvider())
        );


    }
}
