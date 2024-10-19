package net.julian.tutorialmod.item;

import net.julian.tutorialmod.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties POO = (new FoodProperties.Builder()).fast().nutrition(1).saturationMod(0.2F).effect(new MobEffectInstance(MobEffects.CONFUSION, 200, 1), 1.0F).alwaysEat().build();
    public static final FoodProperties BOTTLE_OF_FART = (new FoodProperties.Builder()).fast().nutrition(1).saturationMod(0.2F).effect(new MobEffectInstance(MobEffects.LEVITATION, 200, 25), 1.0F).alwaysEat().build();
    public static final FoodProperties BOTTLE_OF_PEE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).effect(new MobEffectInstance(MobEffects.WITHER, 200, 5), 1.0F).alwaysEat().build();
    public static final FoodProperties WHITE_RICE_CRUMBS = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).fast().build();
    public static final FoodProperties GOLDEN_APPLE_JUICE= (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 1), 1.0F).alwaysEat().build();
    public static final FoodProperties FANCY_GOLDEN_APPLE_JUICE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F).effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 2400, 1), 1.0F).alwaysEat().build();
    public static final FoodProperties ENCHANTED_GOLDEN_APPLE_JUICE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0F).effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 2400, 4), 1.0F).alwaysEat().build();
    public static final FoodProperties GATORADE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1), 1.0F).alwaysEat().build();
    public static final FoodProperties ONIGIRI= (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).build();
    public static final FoodProperties SUSHI= (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F).build();
    public static final FoodProperties ICE_CREAM = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.4F).effect(new MobEffectInstance(ModEffects.FREEZE.get(), 60, 1), 1.0F).build();
}
