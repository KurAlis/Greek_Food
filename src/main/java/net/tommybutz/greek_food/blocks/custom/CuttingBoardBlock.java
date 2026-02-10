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
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tommybutz.greek_food.init.ModItems;
import vectorwing.farmersdelight.common.registry.ModSounds;

public class CuttingBoardBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public enum BoardItem implements StringRepresentable {
        NONE("none"),
        POTATO("potato"),
        RAW_FRENCH_FRIES("raw_french_fries");

        private final String name;
        BoardItem(String name) { this.name = name; }
        @Override public String getSerializedName() { return name; }
    }

    public static final EnumProperty<BoardItem> ITEM =
            EnumProperty.create("item", BoardItem.class);

    private static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 2.0D,
            15.0D, 1.0D, 14.0D);

    public CuttingBoardBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(ITEM, BoardItem.NONE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, ITEM);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case SOUTH -> SHAPE;
            case WEST -> Block.box(2.0D, 0.0D, 1.0D, 14.0D, 1.0D, 15.0D);
            case EAST -> Block.box(2.0D, 0.0D, 1.0D, 14.0D, 1.0D, 15.0D);
            case NORTH -> Block.box(1.0D, 0.0D, 2.0D, 15.0D, 1.0D, 14.0D);
            default -> SHAPE;
        };
    }

    @Override
    public float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        return 0.5F;
    }

    @Override
    public boolean canHarvestBlock(BlockState state, BlockGetter level, BlockPos pos, Player player) {
        return true;
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack,
                                           BlockState state,
                                           Level level,
                                           BlockPos pos,
                                           Player player,
                                           InteractionHand hand,
                                           BlockHitResult hit) {
        BoardItem currentItem = state.getValue(ITEM);

        // Place potato on cutting board
        if (stack.is(Items.POTATO) && currentItem == BoardItem.NONE) {
            if (!level.isClientSide) {
                if (!player.isCreative()) stack.shrink(1);
                level.setBlock(pos, state.setValue(ITEM, BoardItem.POTATO), 3);
                level.playSound(null, pos, SoundEvents.ITEM_FRAME_ADD_ITEM, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
            return ItemInteractionResult.SUCCESS;
        }

        // Cut potato with knife to produce raw_french_fries
        if (isKnife(stack) && currentItem == BoardItem.POTATO) {
            if (!level.isClientSide) {
                Block.popResourceFromFace(level, pos, hit.getDirection(),
                        new ItemStack(ModItems.RAW_FRENCH_FRIES.get(), 3));
                level.setBlock(pos, state.setValue(ITEM, BoardItem.NONE), 3);
                level.playSound(null, pos, ModSounds.BLOCK_CUTTING_BOARD_KNIFE.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
            }
            return ItemInteractionResult.SUCCESS;
        }

        // Pick up item from cutting board
        if (stack.isEmpty() && currentItem != BoardItem.NONE) {
            if (!level.isClientSide) {
                ItemStack dropItem;
                if (currentItem == BoardItem.POTATO) {
                    dropItem = new ItemStack(Items.POTATO);
                } else {
                    dropItem = new ItemStack(ModItems.RAW_FRENCH_FRIES.get());
                }
                player.getInventory().add(dropItem);
                level.setBlock(pos, state.setValue(ITEM, BoardItem.NONE), 3);
                level.playSound(null, pos, SoundEvents.ITEM_FRAME_REMOVE_ITEM, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
            return ItemInteractionResult.SUCCESS;
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state,
                                            Level level,
                                            BlockPos pos,
                                            Player player,
                                            BlockHitResult hit) {
        BoardItem currentItem = state.getValue(ITEM);

        // Pick up item from cutting board with empty hand
        if (currentItem != BoardItem.NONE) {
            if (!level.isClientSide) {
                ItemStack dropItem;
                if (currentItem == BoardItem.POTATO) {
                    dropItem = new ItemStack(Items.POTATO);
                } else {
                    dropItem = new ItemStack(ModItems.RAW_FRENCH_FRIES.get());
                }
                player.getInventory().add(dropItem);
                level.setBlock(pos, state.setValue(ITEM, BoardItem.NONE), 3);
                level.playSound(null, pos, SoundEvents.ITEM_FRAME_REMOVE_ITEM, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    private boolean isKnife(ItemStack stack) {
        return stack.is(vectorwing.farmersdelight.common.registry.ModItems.IRON_KNIFE.get()) ||
               stack.is(vectorwing.farmersdelight.common.registry.ModItems.GOLDEN_KNIFE.get()) ||
               stack.is(vectorwing.farmersdelight.common.registry.ModItems.DIAMOND_KNIFE.get()) ||
               stack.is(vectorwing.farmersdelight.common.registry.ModItems.NETHERITE_KNIFE.get());
    }
}
