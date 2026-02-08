package net.tommybutz.greek_food.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tommybutz.greek_food.init.ModItems;
import vectorwing.farmersdelight.common.registry.ModSounds;

public class GyrosWarmerBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public static final IntegerProperty MEAT_LEVEL = IntegerProperty.create("meat_level", 0, 3);

    public enum MeatKind implements StringRepresentable {
        NONE("none"),
        CHICKEN("chicken"),
        BEEF("beef");

        private final String name;
        MeatKind(String name) { this.name = name; }
        @Override public String getSerializedName() { return name; }
    }

    public static final EnumProperty<MeatKind> MEAT_KIND =
            EnumProperty.create("meat_kind", MeatKind.class);


    // Define your shape: from (0,0,0) to (16,32,16) in "voxel units"
    // Each block is 16 units, so 32 = 2 blocks tall
    private static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D,
            14.0D, 28.0D, 14.0D);

    public GyrosWarmerBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(MEAT_LEVEL, 0)
                .setValue(MEAT_KIND, MeatKind.NONE));


    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, MEAT_LEVEL, MEAT_KIND);
    }


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    // Override the shape
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        return 0.5F; // break quickly with anything
    }

    @Override
    public boolean canHarvestBlock(BlockState state, BlockGetter level, BlockPos pos, Player player) {
        return true; // always harvestable
    }



    @Override
    public ItemInteractionResult useItemOn(ItemStack stack,
                                           BlockState state,
                                           Level level,
                                           BlockPos pos,
                                           Player player,
                                           InteractionHand hand,
                                           BlockHitResult hit) {
        int meatLevel = state.getValue(MEAT_LEVEL);
        MeatKind kind = state.getValue(MEAT_KIND);

        // Load with chicken
        if (stack.is(ModItems.GYROS_CHICKEN_FULL.get()) && meatLevel == 0) {
            if (!level.isClientSide) {
                if (!player.isCreative()) stack.shrink(1);
                level.setBlock(pos, state.setValue(MEAT_LEVEL, 3).setValue(MEAT_KIND, MeatKind.CHICKEN), 3);

                level.playSound(
                        null,                // player (null = everyone hears it)
                        pos,                 // block position
                        ModSounds.BLOCK_SKILLET_ADD_FOOD.get(), // pick any sound event
                        SoundSource.BLOCKS,  // category
                        1.0F,                // volume
                        1.0F                 // pitch
                );

            }
            return ItemInteractionResult.SUCCESS;
        }

        // Load with beef
        if (stack.is(ModItems.GYROS_BEEF_FULL.get()) && meatLevel == 0) {
            if (!level.isClientSide) {
                if (!player.isCreative()) stack.shrink(1);
                level.setBlock(pos, state.setValue(MEAT_LEVEL, 3).setValue(MEAT_KIND, MeatKind.BEEF), 3);

                level.playSound(
                        null,                // player (null = everyone hears it)
                        pos,                 // block position
                        ModSounds.BLOCK_SKILLET_ADD_FOOD.get(), // pick any sound event
                        SoundSource.BLOCKS,  // category
                        1.0F,                // volume
                        1.0F                 // pitch
                );

            }
            return ItemInteractionResult.SUCCESS;
        }

        // Carve with knife
        if (stack.is(vectorwing.farmersdelight.common.registry.ModItems.IRON_KNIFE.get()) && meatLevel > 0) {
            if (!level.isClientSide) {
                int count = 2 + level.random.nextInt(2); // 2–3 slices

                if (kind == MeatKind.CHICKEN) {
                    Block.popResourceFromFace(level, pos, hit.getDirection(),
                            new ItemStack(ModItems.GYROS_CHICKEN.get(), count));

                } else if (kind == MeatKind.BEEF) {
                    Block.popResourceFromFace(level, pos, hit.getDirection(),
                            new ItemStack(ModItems.GYROS_BEEF.get(), count));

                }

                // Last cut also drops a chain
                if (meatLevel == 1) {
                    Block.popResourceFromFace(level, pos, hit.getDirection(),
                            new ItemStack(Items.CHAIN));

                    // Reset to empty
                    level.setBlock(pos, state.setValue(MEAT_LEVEL, 0).setValue(MEAT_KIND, MeatKind.NONE), 3);
                } else {
                    level.setBlock(pos, state.setValue(MEAT_LEVEL, meatLevel - 1), 3);
                }
                level.playSound(
                        null,                // player (null = everyone hears it)
                        pos,                 // block position
                        SoundEvents.SLIME_SQUISH, // pick any sound event
                        SoundSource.BLOCKS,  // category
                        1.0F,                // volume
                        1.0F                 // pitch
                );

            }
            return ItemInteractionResult.SUCCESS;
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }



    // Called when right-clicking the block with an empty hand
    @Override
    public InteractionResult useWithoutItem(BlockState state,
                                            Level level,
                                            BlockPos pos,
                                            Player player,
                                            BlockHitResult hit) {
        // If you don’t need empty-hand behavior, just pass
        return InteractionResult.PASS;
    }

}
