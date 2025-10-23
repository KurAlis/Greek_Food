package net.tommybutz.greek_food.blocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.tommybutz.greek_food.greek_food;
import net.tommybutz.greek_food.init.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    // Main block registry
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(Registries.BLOCK, greek_food.MOD_ID);


/*
    // === Example Block Registration ===
    public static final Supplier<Block> PITA_WARMER = registerBlock(
            "pita_warmer",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BROWN)
                    .strength(2.0f, 6.0f))
    );
*/


    // === Helper method to register block + block item ===
    private static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> blockSupplier) {
        Supplier<T> block = BLOCKS.register(name, blockSupplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }
}
