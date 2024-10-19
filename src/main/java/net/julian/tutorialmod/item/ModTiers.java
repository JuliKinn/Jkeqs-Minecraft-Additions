package net.julian.tutorialmod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier THOR = new ForgeTier(0, 4, 12f,
            0f, 22, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.SMOKE_BOMB.get()));
}