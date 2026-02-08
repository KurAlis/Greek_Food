package net.tommybutz.greek_food.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.tommybutz.greek_food.data.loot.ModBlockLootTables;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider {
    public static LootTableProvider create(PackOutput output,
                                           CompletableFuture<HolderLookup.Provider> lookupProvider) {
        return new LootTableProvider(
                output,
                Set.of(), // required tables
                List.of(
                        new LootTableProvider.SubProviderEntry(
                                (lookup) -> new ModBlockLootTables(lookup),
                                LootContextParamSets.BLOCK
                        )
                ),
                lookupProvider
        );
    }
}
