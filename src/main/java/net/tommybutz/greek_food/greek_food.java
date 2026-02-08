package net.tommybutz.greek_food;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.tommybutz.greek_food.blocks.ModBlocks;
import net.tommybutz.greek_food.creativemodetab.ModCreativeTabs;
import net.tommybutz.greek_food.data.DataGenerators;
import net.tommybutz.greek_food.init.ModItems;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(greek_food.MOD_ID)
public class greek_food {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "greek_food";

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public greek_food(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModCreativeTabs.TABS.register(modEventBus);

        modEventBus.addListener(DataGenerators::gatherData);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}
}
