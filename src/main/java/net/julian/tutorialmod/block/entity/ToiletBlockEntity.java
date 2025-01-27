package net.julian.tutorialmod.block.entity;

import net.julian.tutorialmod.block.custom.ToiletBlock;
import net.julian.tutorialmod.item.ModItems;
import net.julian.tutorialmod.networking.ModMessages;
import net.julian.tutorialmod.networking.packet.EnergySyncS2CPacket;
import net.julian.tutorialmod.recipe.ToiletRecipe;
import net.julian.tutorialmod.screen.ToiletMenu;
import net.julian.tutorialmod.util.ModEnergyStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;

import net.minecraftforge.energy.IEnergyStorage;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

public class ToiletBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(3){
        @Override
        protected void onContentsChanged(int slot){
            setChanged();
        }
        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack){
            return switch (slot){
                case 0 -> stack.getItem() == ModItems.TOILET_PAPER.get();
                case 1 -> true;
                case 2 -> false;
                default -> super.isItemValid(slot,stack);
            };
        }
    };
    private final ModEnergyStorage ENERGY_STORAGE = new ModEnergyStorage(4096, 2048) {
        @Override
        public void onEnergyChanged() {
            setChanged();
            ModMessages.sendToClients(new EnergySyncS2CPacket(this.energy, getBlockPos()));
        }
    };
    private static final int ENERGY_REQ = 64;
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private final Map<Direction, LazyOptional<net.julian.tutorialmod.block.entity.WrappedHandler>> directionWrappedHandlerMap =
            Map.of(Direction.DOWN, LazyOptional.of(() -> new net.julian.tutorialmod.block.entity.WrappedHandler(itemHandler, (i) -> i == 2, (i, s) -> false)),
                    Direction.NORTH, LazyOptional.of(() -> new net.julian.tutorialmod.block.entity.WrappedHandler(itemHandler, (index) -> index == 1,
                            (index, stack) -> itemHandler.isItemValid(1, stack))),
                    Direction.SOUTH, LazyOptional.of(() -> new net.julian.tutorialmod.block.entity.WrappedHandler(itemHandler, (i) -> i == 2, (i, s) -> false)),
                    Direction.EAST, LazyOptional.of(() -> new net.julian.tutorialmod.block.entity.WrappedHandler(itemHandler, (i) -> i == 1,
                            (index, stack) -> itemHandler.isItemValid(1, stack))),
                    Direction.WEST, LazyOptional.of(() -> new net.julian.tutorialmod.block.entity.WrappedHandler(itemHandler, (index) -> index == 0 || index == 1,
                            (index, stack) -> itemHandler.isItemValid(0, stack) || itemHandler.isItemValid(1, stack))));

    private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();
    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 4;

    public ToiletBlockEntity(BlockPos pos, BlockState state) {
        super(net.julian.tutorialmod.block.entity.ModBlockEntities.TOILET.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index){
                    case 0 -> ToiletBlockEntity.this.progress;
                    case 1 -> ToiletBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> ToiletBlockEntity.this.progress = pValue;
                    case 1 -> ToiletBlockEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Toilet");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory inventory, Player player) {
        return new ToiletMenu(pContainerId, inventory, this, this.data);
    }
    public IEnergyStorage getEnergyStorage() {
        return ENERGY_STORAGE;
    }
    public void setEnergyLevel(int energy) {
        this.ENERGY_STORAGE.setEnergy(energy);
    }
    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap==ForgeCapabilities.ENERGY){
            return lazyEnergyHandler.cast();
        }
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            if(side == null) {
                return lazyItemHandler.cast();
            }

            if(directionWrappedHandlerMap.containsKey(side)) {
                Direction localDir = this.getBlockState().getValue(ToiletBlock.FACING);

                if(side == Direction.UP || side == Direction.DOWN) {
                    return directionWrappedHandlerMap.get(side).cast();
                }

                return switch (localDir) {
                    default -> directionWrappedHandlerMap.get(side.getOpposite()).cast();
                    case EAST -> directionWrappedHandlerMap.get(side.getClockWise()).cast();
                    case SOUTH -> directionWrappedHandlerMap.get(side).cast();
                    case WEST -> directionWrappedHandlerMap.get(side.getCounterClockWise()).cast();
                };
            }
        }

        return super.getCapability(cap, side);
    }


    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(()->itemHandler);
        lazyEnergyHandler = LazyOptional.of(()->ENERGY_STORAGE);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
        lazyEnergyHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("toilet.progress", this.progress);
        pTag.putInt("toilet.energy", ENERGY_STORAGE.getEnergyStored());
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress= pTag.getInt("toilet.progress");
        ENERGY_STORAGE.setEnergy(pTag.getInt("toilet.energy"));
    }
    public void drops(){
        SimpleContainer inventory = new SimpleContainer((itemHandler.getSlots()));
        for (int i = 0; i<itemHandler.getSlots(); i++){
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, ToiletBlockEntity entity) {
        if(level.isClientSide()){
            return;
        }
        if (hasToiletPaperInFirstSlot(entity)){
            entity.ENERGY_STORAGE.receiveEnergy(1024, false);
            if (entity.ENERGY_STORAGE.getEnergyStored() < 4096) {
                entity.itemHandler.extractItem(0, 1, false);
            }
        }
        if(hasRecipe(entity) && hasEnoughEnergy(entity)) {
            entity.progress++;
            extractEnergy(entity);
            setChanged(level, blockPos, blockState);
            if (entity.progress >= entity.maxProgress) {
                craftItem(entity);
            }
        }else{
            entity.resetProgress();
            setChanged(level, blockPos, blockState);
        }
        entity.outputEnergy();
    }

    private static void extractEnergy(ToiletBlockEntity pEntity) {
        pEntity.ENERGY_STORAGE.extractEnergy(ENERGY_REQ,false);
    }

    private static boolean hasEnoughEnergy(ToiletBlockEntity entity) {
        return entity.ENERGY_STORAGE.getEnergyStored() >= ENERGY_REQ * entity.maxProgress;
    }

    private static boolean hasToiletPaperInFirstSlot(ToiletBlockEntity pEntity){
        return pEntity.itemHandler.getStackInSlot(0).getItem() == ModItems.TOILET_PAPER.get();
    }
    private void resetProgress() {
        this.progress = 0;
    }

    private static void craftItem(ToiletBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i<entity.itemHandler.getSlots(); i++){
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }
        Optional<ToiletRecipe> recipe = level.getRecipeManager().getRecipeFor(ToiletRecipe.Type.INSTANCE,inventory,level);

        if (hasRecipe(entity)){
            if (entity.ENERGY_STORAGE.getEnergyStored() < 4096) {
                entity.itemHandler.extractItem(0, 1, false);
            }
            entity.itemHandler.extractItem(1,1,false);
            entity.itemHandler.setStackInSlot(2, new ItemStack(recipe.get().getResultItem().getItem(), entity.itemHandler.getStackInSlot(2).getCount()+1));
            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(ToiletBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i<entity.itemHandler.getSlots(); i++){
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }
        Optional<ToiletRecipe> recipe = level.getRecipeManager().getRecipeFor(ToiletRecipe.Type.INSTANCE,inventory,level);
        return recipe.isPresent() &&canInsertAmountIntoOutputSlot(inventory)&& canInsertItemIntoOutputSlot(inventory,recipe.get().getResultItem());
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack stack) {
        return inventory.getItem(2).getItem()==stack.getItem()||inventory.getItem(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(2).getMaxStackSize() > inventory.getItem(2).getCount();
    }
    public void outputEnergy() {
        if (this.ENERGY_STORAGE.getEnergyStored() >= 2048 && this.ENERGY_STORAGE.canExtract()) {
            for (final var direction : Direction.values()) {
                final BlockEntity be = this.level.getBlockEntity(this.worldPosition.relative(direction));
                if (be == null) {
                    continue;
                }

                be.getCapability(ForgeCapabilities.ENERGY, direction.getOpposite()).ifPresent(storage -> {
                    if (be != this && storage.getEnergyStored() < storage.getMaxEnergyStored()) {
                        final int toSend = ToiletBlockEntity.this.ENERGY_STORAGE.extractEnergy(2048,
                                false);

                        final int received = storage.receiveEnergy(toSend, false);


                        ToiletBlockEntity.this.ENERGY_STORAGE.setEnergy(
                                ToiletBlockEntity.this.ENERGY_STORAGE.getEnergyStored() + toSend - received);
                    }
                });
            }
        }
    }


}
