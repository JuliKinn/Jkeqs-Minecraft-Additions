package net.julian.tutorialmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class PooBlock extends Block {


    public PooBlock(Properties properties) {
        super(properties);
    }
    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity){
        if (!pLevel.isClientSide()){
            if (pEntity instanceof LivingEntity){
                LivingEntity livingEntity = ((LivingEntity) pEntity);
                livingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 300));
                livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 300));
                livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 300));
                livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 2));
            }
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }


}
