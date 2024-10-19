package net.julian.tutorialmod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class ThorHammerItem extends SwordItem {
    public ThorHammerItem(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
        super(p_43269_, p_43270_, p_43271_, p_43272_);
    }
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {

        if(!pAttacker.level().isClientSide()) {
            ServerLevel world = ((ServerLevel) pAttacker.level());
            BlockPos position = pTarget.blockPosition();


            EntityType.LIGHTNING_BOLT.spawn(world, (ItemStack) null, null, position,
                    MobSpawnType.TRIGGERED, true, true);
        }


        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
