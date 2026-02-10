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
        simpleItem(ModItems.GREEK_YOGHURT.get());
        simpleItem(ModItems.TZATZIKI.get());
        simpleItem(ModItems.RAW_KEBAB.get());
        simpleItem(ModItems.KEBAB.get());
        simpleItem(ModItems.GYROS_CHICKEN.get());
        simpleItem(ModItems.GYROS_BEEF.get());
        simpleItem(ModItems.GYROS_CHICKEN_FULL.get());
        simpleItem(ModItems.GYROS_BEEF_FULL.get());
        simpleItem(ModItems.SPINACH_PIE.get());
        simpleItem(ModItems.RAW_FRENCH_FRIES.get());
        //CHICKEN SOUVLAKIA
        simpleItem(ModItems.SOUVLAKI_CHICKEN_APO_OLA.get());
        simpleItem(ModItems.SOUVLAKI_CHICKEN_APO_OLA_TZATZIKI.get());
        simpleItem(ModItems.SOUVLAKI_CHICKEN_XWRIS_KREMIDI.get());
        simpleItem(ModItems.SOUVLAKI_CHICKEN_XWRIS_KREMIDI_TZATZIKI.get());
        simpleItem(ModItems.SOUVLAKI_CHICKEN_XWRIS_KREMIDI_NTOMATA.get());
        simpleItem(ModItems.SOUVLAKI_CHICKEN_XWRIS_KREMIDI_NTOMATA_TZATZIKI.get());
        simpleItem(ModItems.SOUVLAKI_CHICKEN_XWRIS_KREMIDI_MAROULI.get());
        simpleItem(ModItems.SOUVLAKI_CHICKEN_XWRIS_KREMIDI_MAROULI_TZATZIKI.get());
        simpleItem(ModItems.SOUVLAKI_CHICKEN_XWRIS_NTOMATA.get());
        simpleItem(ModItems.SOUVLAKI_CHICKEN_XWRIS_NTOMATA_TZATZIKI.get());
        simpleItem(ModItems.SOUVLAKI_CHICKEN_XWRIS_NTOMATA_MAROULI.get());
        simpleItem(ModItems.SOUVLAKI_CHICKEN_XWRIS_NTOMATA_MAROULI_TZATZIKI.get());
        simpleItem(ModItems.SOUVLAKI_CHICKEN_XWRIS_MAROULI.get());
        simpleItem(ModItems.SOUVLAKI_CHICKEN_XWRIS_MAROULI_TZATZIKI.get());
        simpleItem(ModItems.SOUVLAKI_CHICKEN_XWRIS_TIPOTA.get());
        simpleItem(ModItems.SOUVLAKI_CHICKEN_XWRIS_TIPOTA_TZATZIKI.get());
        //BEEF SOUVLAKIA
        simpleItem(ModItems.SOUVLAKI_BEEF_APO_OLA.get());
        simpleItem(ModItems.SOUVLAKI_BEEF_APO_OLA_TZATZIKI.get());
        simpleItem(ModItems.SOUVLAKI_BEEF_XWRIS_KREMIDI.get());
        simpleItem(ModItems.SOUVLAKI_BEEF_XWRIS_KREMIDI_TZATZIKI.get());
        simpleItem(ModItems.SOUVLAKI_BEEF_XWRIS_KREMIDI_NTOMATA.get());
        simpleItem(ModItems.SOUVLAKI_BEEF_XWRIS_KREMIDI_NTOMATA_TZATZIKI.get());
        simpleItem(ModItems.SOUVLAKI_BEEF_XWRIS_KREMIDI_MAROULI.get());
        simpleItem(ModItems.SOUVLAKI_BEEF_XWRIS_KREMIDI_MAROULI_TZATZIKI.get());
        simpleItem(ModItems.SOUVLAKI_BEEF_XWRIS_NTOMATA.get());
        simpleItem(ModItems.SOUVLAKI_BEEF_XWRIS_NTOMATA_TZATZIKI.get());
        simpleItem(ModItems.SOUVLAKI_BEEF_XWRIS_NTOMATA_MAROULI.get());
        simpleItem(ModItems.SOUVLAKI_BEEF_XWRIS_NTOMATA_MAROULI_TZATZIKI.get());
        simpleItem(ModItems.SOUVLAKI_BEEF_XWRIS_MAROULI.get());
        simpleItem(ModItems.SOUVLAKI_BEEF_XWRIS_MAROULI_TZATZIKI.get());
        simpleItem(ModItems.SOUVLAKI_BEEF_XWRIS_TIPOTA.get());
        simpleItem(ModItems.SOUVLAKI_BEEF_XWRIS_TIPOTA_TZATZIKI.get());
    }

    private void simpleItem(Item item) {
        String name = BuiltInRegistries.ITEM.getKey(item).getPath();
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", modLoc("item/" + name));
    }
}
