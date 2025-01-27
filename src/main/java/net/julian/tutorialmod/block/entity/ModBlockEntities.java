package net.julian.tutorialmod.block.entity;

import net.julian.tutorialmod.TutorialMod;
import net.julian.tutorialmod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>>BLOCK_ENTITIES=DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TutorialMod.MOD_ID);
    public static final RegistryObject<BlockEntityType<net.julian.tutorialmod.block.entity.ToiletBlockEntity>> TOILET=BLOCK_ENTITIES.register("toilet", ()-> BlockEntityType.Builder.of(net.julian.tutorialmod.block.entity.ToiletBlockEntity::new, ModBlocks.TOILET.get()).build(null));
    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
