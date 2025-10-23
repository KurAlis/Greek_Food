package net.tommybutz.greek_food.data;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.tommybutz.greek_food.greek_food;
import net.tommybutz.greek_food.init.ModItems;

public class GreekFoodItemModels extends ItemModelProvider {
    public GreekFoodItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, greek_food.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.GREEK_PITA.get());
        simpleItem(ModItems.FROZEN_GREEK_PITA.get());
        simpleItem(ModItems.GREEK_PITA_OILED.get());
        simpleItem(ModItems.GRILLED_GREEK_PITA.get());
        simpleItem(ModItems.TZATZIKI.get());
    }

    private void simpleItem(Item item) {
        String name = BuiltInRegistries.ITEM.getKey(item).getPath();
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", modLoc("item/" + name));
    }
}
