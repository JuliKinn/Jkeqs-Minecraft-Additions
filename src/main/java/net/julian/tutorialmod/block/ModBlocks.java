package net.julian.tutorialmod.block;

import net.julian.tutorialmod.TutorialMod;
import net.julian.tutorialmod.block.custom.WhiteRicePlantBlock;
import net.julian.tutorialmod.block.custom.PooBlock;
import net.julian.tutorialmod.block.custom.ToiletBlock;
import net.julian.tutorialmod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> BROWNISH_BLOCK = registerBlock("brownish_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> REDDISH_BLOCK = registerBlock("reddish_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> POO_BLOCK = registerBlock("poo_block",
            () -> new PooBlock(BlockBehaviour.Properties.copy(Blocks.DIRT)
                    .strength(1f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> LIME_TRAPDOOR = registerBlock("lime_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_TRAPDOOR).strength(5f).requiresCorrectToolForDrops().noOcclusion(), BlockSetType.WARPED));
    public static final RegistryObject<Block> BLACK_TRAPDOOR = registerBlock("black_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_TRAPDOOR).strength(5f).requiresCorrectToolForDrops().noOcclusion(), BlockSetType.WARPED));
    public static final RegistryObject<Block> WHITE_TRAPDOOR = registerBlock("white_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_TRAPDOOR).strength(5f).requiresCorrectToolForDrops().noOcclusion(),BlockSetType.WARPED));
    public static final RegistryObject<Block> LIGHT_GRAY_TRAPDOOR = registerBlock("light_gray_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_TRAPDOOR).strength(5f).requiresCorrectToolForDrops().noOcclusion(),BlockSetType.WARPED));
    public static final RegistryObject<Block> RED_TRAPDOOR = registerBlock("red_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_TRAPDOOR).strength(5f).requiresCorrectToolForDrops().noOcclusion(), BlockSetType.WARPED));
    public static final RegistryObject<Block> ORANGE_TRAPDOOR = registerBlock("orange_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_TRAPDOOR).strength(5f).requiresCorrectToolForDrops().noOcclusion(), BlockSetType.WARPED));
    public static final RegistryObject<Block> YELLOW_TRAPDOOR = registerBlock("yellow_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_TRAPDOOR).strength(5f).requiresCorrectToolForDrops().noOcclusion(),BlockSetType.WARPED));
    public static final RegistryObject<Block> GREEN_TRAPDOOR = registerBlock("green_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_TRAPDOOR).strength(5f).requiresCorrectToolForDrops().noOcclusion(),BlockSetType.WARPED));
    public static final RegistryObject<Block> CYAN_TRAPDOOR = registerBlock("cyan_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_TRAPDOOR).strength(5f).requiresCorrectToolForDrops().noOcclusion(), BlockSetType.WARPED));
    public static final RegistryObject<Block> PINK_TRAPDOOR = registerBlock("pink_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_TRAPDOOR).strength(5f).requiresCorrectToolForDrops().noOcclusion(), BlockSetType.WARPED));
    public static final RegistryObject<Block> BROWN_TRAPDOOR = registerBlock("brown_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_TRAPDOOR).strength(5f).requiresCorrectToolForDrops().noOcclusion(),BlockSetType.WARPED));
    public static final RegistryObject<Block> MAGENTA_TRAPDOOR = registerBlock("magenta_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_TRAPDOOR).strength(5f).requiresCorrectToolForDrops().noOcclusion(), BlockSetType.WARPED));
    public static final RegistryObject<Block> LIGHT_BLUE_TRAPDOOR = registerBlock("light_blue_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_TRAPDOOR).strength(5f).requiresCorrectToolForDrops().noOcclusion(), BlockSetType.WARPED));
    public static final RegistryObject<Block> PURPLE_TRAPDOOR = registerBlock("purple_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_TRAPDOOR).strength(5f).requiresCorrectToolForDrops().noOcclusion(),BlockSetType.WARPED));
    public static final RegistryObject<Block> GRAY_TRAPDOOR = registerBlock("gray_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_TRAPDOOR).strength(5f).requiresCorrectToolForDrops().noOcclusion(),BlockSetType.WARPED));
    public static final RegistryObject<Block> BLUE_TRAPDOOR = registerBlock("blue_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_TRAPDOOR).strength(5f).requiresCorrectToolForDrops().noOcclusion(),BlockSetType.WARPED));
    public static final RegistryObject<Block> BLUE_STAIRS = registerBlock("blue_stairs",
            () -> new StairBlock(()-> ModBlocks.REDDISH_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(5f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> WHITE_RICE_PLANT = registerBlockWithoutBlockItem("white_rice_plant",
            () -> new WhiteRicePlantBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> TOILET = registerBlock("toilet",
            () -> new ToiletBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BRICKS).noOcclusion()));




    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block){
        return BLOCKS.register(name, block);
    }


    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab, String tooltipkey) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()){
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                pTooltip.add(Component.translatable(tooltipkey));
            }
        });
    }


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}