package net.tommybutz.greek_food.data;

import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.tommybutz.greek_food.blocks.ModBlocks;
import net.tommybutz.greek_food.blocks.custom.CuttingBoardBlock;
import net.tommybutz.greek_food.blocks.custom.GyrosWarmerBlock;
import net.tommybutz.greek_food.greek_food;

import java.util.function.Supplier;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, greek_food.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        //blockWithItem(ModBlocks.EXAMPLE_BLOCK);


        // Gyros Warmer: facing + meat_level
        getVariantBuilder(ModBlocks.GYROS_WARMER.get()).forAllStates(state -> {
            Direction facing = state.getValue(GyrosWarmerBlock.FACING);
            int meatLevel = state.getValue(GyrosWarmerBlock.MEAT_LEVEL);
            GyrosWarmerBlock.MeatKind kind = state.getValue(GyrosWarmerBlock.MEAT_KIND);

            String suffix = switch (kind) {
                case CHICKEN -> "chicken";
                case BEEF    -> "beef";
                default      -> "empty";
            };

            String modelName = switch (meatLevel) {
                case 0 -> "gyros_stand_empty";
                case 1 -> "gyros_stand_small_" + suffix;
                case 2 -> "gyros_stand_medium_" + suffix;
                case 3 -> "gyros_stand_full_" + suffix;
                default -> "gyros_stand_empty";
            };

            ModelFile model = new ModelFile.UncheckedModelFile(modLoc("block/" + modelName));

            int yRot = switch (facing) {
                case SOUTH -> 180;
                case WEST  -> 270;
                case EAST  -> 90;
                default    -> 0;
            };

            return ConfiguredModel.builder()
                    .modelFile(model)
                    .rotationY(yRot)
                    .build();
        });


        // Item model (just point to the full block model, or your Blockbench JSON)
        itemModels().withExistingParent("gyros_warmer", modLoc("block/gyros_stand_empty"));

        // Cutting Board: facing + item
        getVariantBuilder(ModBlocks.CUTTING_BOARD.get()).forAllStates(state -> {
            Direction facing = state.getValue(CuttingBoardBlock.FACING);
            CuttingBoardBlock.BoardItem item = state.getValue(CuttingBoardBlock.ITEM);

            String modelName = switch (item) {
                case POTATO -> "cutting_board_potato";
                case RAW_FRENCH_FRIES -> "cutting_board_raw_french_fries";
                default -> "cutting_board_empty";
            };

            ModelFile model = new ModelFile.UncheckedModelFile(modLoc("block/" + modelName));

            int yRot = switch (facing) {
                case SOUTH -> 180;
                case WEST  -> 270;
                case EAST  -> 90;
                default    -> 0;
            };

            return ConfiguredModel.builder()
                    .modelFile(model)
                    .rotationY(yRot)
                    .build();
        });

        // Item model for cutting board
        itemModels().withExistingParent("cutting_board", modLoc("block/cutting_board_empty"));

    }
    private void blockWithItem(Supplier<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}
