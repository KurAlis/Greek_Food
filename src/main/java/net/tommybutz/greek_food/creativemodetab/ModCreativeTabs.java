package net.tommybutz.greek_food.creativemodetab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.tommybutz.greek_food.greek_food;
import net.tommybutz.greek_food.init.ModItems;
import net.tommybutz.greek_food.blocks.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, greek_food.MOD_ID);

    public static final Supplier<CreativeModeTab> GREEK_FOOD_TAB =
            TABS.register("greek_food_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.greek_food_tab"))
                    .icon(() -> new ItemStack(ModItems.GRILLED_GREEK_PITA.get()))
                    .displayItems((params, output) -> {

                        // ===== FOODS =====
                        output.accept(ModItems.GREEK_PITA.get());
                        output.accept(ModItems.FROZEN_GREEK_PITA.get());
                        output.accept(ModItems.GREEK_PITA_OILED.get());
                        output.accept(ModItems.GRILLED_GREEK_PITA.get());
                        output.accept(ModItems.GREEK_YOGHURT.get());
                        output.accept(ModItems.TZATZIKI.get());
                        output.accept(ModItems.RAW_KEBAB.get());
                        output.accept(ModItems.GYROS_CHICKEN.get());
                        output.accept(ModItems.GYROS_BEEF.get());
                        output.accept(ModItems.KEBAB.get());
                        output.accept(ModItems.GYROS_CHICKEN_FULL.get());
                        output.accept(ModItems.GYROS_BEEF_FULL.get());
                        output.accept(ModItems.SPINACH_PIE.get());
                        output.accept(ModItems.RAW_FRENCH_FRIES.get());
                        //souvlakia
                        output.accept(ModItems.SOUVLAKI_CHICKEN_APO_OLA.get());
                        output.accept(ModItems.SOUVLAKI_CHICKEN_APO_OLA_TZATZIKI.get());
                        output.accept(ModItems.SOUVLAKI_CHICKEN_XWRIS_KREMIDI.get());
                        output.accept(ModItems.SOUVLAKI_CHICKEN_XWRIS_KREMIDI_TZATZIKI.get());
                        output.accept(ModItems.SOUVLAKI_CHICKEN_XWRIS_KREMIDI_MAROULI.get());
                        output.accept(ModItems.SOUVLAKI_CHICKEN_XWRIS_KREMIDI_MAROULI_TZATZIKI.get());
                        output.accept(ModItems.SOUVLAKI_CHICKEN_XWRIS_KREMIDI_NTOMATA.get());
                        output.accept(ModItems.SOUVLAKI_CHICKEN_XWRIS_KREMIDI_NTOMATA_TZATZIKI.get());
                        output.accept(ModItems.SOUVLAKI_CHICKEN_XWRIS_NTOMATA.get());
                        output.accept(ModItems.SOUVLAKI_CHICKEN_XWRIS_NTOMATA_TZATZIKI.get());
                        output.accept(ModItems.SOUVLAKI_CHICKEN_XWRIS_NTOMATA_MAROULI.get());
                        output.accept(ModItems.SOUVLAKI_CHICKEN_XWRIS_NTOMATA_MAROULI_TZATZIKI.get());
                        output.accept(ModItems.SOUVLAKI_CHICKEN_XWRIS_MAROULI.get());
                        output.accept(ModItems.SOUVLAKI_CHICKEN_XWRIS_MAROULI_TZATZIKI.get());
                        output.accept(ModItems.SOUVLAKI_CHICKEN_XWRIS_TIPOTA.get());
                        output.accept(ModItems.SOUVLAKI_CHICKEN_XWRIS_TIPOTA_TZATZIKI.get());

                        output.accept(ModItems.SOUVLAKI_BEEF_APO_OLA.get());
                        output.accept(ModItems.SOUVLAKI_BEEF_APO_OLA_TZATZIKI.get());
                        output.accept(ModItems.SOUVLAKI_BEEF_XWRIS_KREMIDI.get());
                        output.accept(ModItems.SOUVLAKI_BEEF_XWRIS_KREMIDI_TZATZIKI.get());
                        output.accept(ModItems.SOUVLAKI_BEEF_XWRIS_KREMIDI_MAROULI.get());
                        output.accept(ModItems.SOUVLAKI_BEEF_XWRIS_KREMIDI_MAROULI_TZATZIKI.get());
                        output.accept(ModItems.SOUVLAKI_BEEF_XWRIS_KREMIDI_NTOMATA.get());
                        output.accept(ModItems.SOUVLAKI_BEEF_XWRIS_KREMIDI_NTOMATA_TZATZIKI.get());
                        output.accept(ModItems.SOUVLAKI_BEEF_XWRIS_NTOMATA.get());
                        output.accept(ModItems.SOUVLAKI_BEEF_XWRIS_NTOMATA_TZATZIKI.get());
                        output.accept(ModItems.SOUVLAKI_BEEF_XWRIS_NTOMATA_MAROULI.get());
                        output.accept(ModItems.SOUVLAKI_BEEF_XWRIS_NTOMATA_MAROULI_TZATZIKI.get());
                        output.accept(ModItems.SOUVLAKI_BEEF_XWRIS_MAROULI.get());
                        output.accept(ModItems.SOUVLAKI_BEEF_XWRIS_MAROULI_TZATZIKI.get());
                        output.accept(ModItems.SOUVLAKI_BEEF_XWRIS_TIPOTA.get());
                        output.accept(ModItems.SOUVLAKI_BEEF_XWRIS_TIPOTA_TZATZIKI.get());
                        // output.accept(ModItems.OTHER_FOOD.get());

                        // ===== BLOCKS =====
                        output.accept(ModBlocks.GYROS_WARMER.get());
                        output.accept(ModBlocks.CUTTING_BOARD.get());
                        // output.accept(ModBlocks.OTHER_BLOCK.get());

                        // ===== TOOLS =====
                        // output.accept(ModItems.PITA_KNIFE.get());
                        // output.accept(ModItems.OTHER_TOOL.get());

                        // ===== MISC =====
                        // output.accept(ModItems.SPECIAL_ITEM.get());
                    })
                    .build()
            );
}
