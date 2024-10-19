package net.julian.tutorialmod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class TicklerHoeItem extends HoeItem {
    public TicklerHoeItem(Tier p_41336_, int p_41337_, float p_41338_, Properties p_41339_) {
        super(p_41336_, p_41337_, p_41338_, p_41339_);

    }


    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 300), pAttacker);
        pTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 2), pAttacker);
        pTarget.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 300, 2), pAttacker);

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

}
