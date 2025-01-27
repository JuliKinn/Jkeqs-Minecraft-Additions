package net.julian.tutorialmod.util;

import net.julian.tutorialmod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;


public class ModItemProperties {
    public static void addCustomItemProperties(){
        makeBow(ModItems.SCOPED_CROSSBOW.get());
    }

    private static void makeBow(Item item) {
        ItemProperties.register(Items.CROSSBOW, new ResourceLocation("pull"), (p_174620_, p_174621_, p_174622_, p_174623_) -> {
            if (p_174622_ == null) {
                return 0.0F;
            } else {
                return CrossbowItem.isCharged(p_174620_) ? 0.0F : (float)(p_174620_.getUseDuration() - p_174622_.getUseItemRemainingTicks()) / (float)CrossbowItem.getChargeDuration(p_174620_);
            }
        });
        ItemProperties.register(Items.CROSSBOW, new ResourceLocation("pulling"), (p_174615_, p_174616_, p_174617_, p_174618_) -> {
            return p_174617_ != null && p_174617_.isUsingItem() && p_174617_.getUseItem() == p_174615_ && !CrossbowItem.isCharged(p_174615_) ? 1.0F : 0.0F;
        });
        ItemProperties.register(Items.CROSSBOW, new ResourceLocation("charged"), (p_174610_, p_174611_, p_174612_, p_174613_) -> {
            return p_174612_ != null && CrossbowItem.isCharged(p_174610_) ? 1.0F : 0.0F;
        });
        ItemProperties.register(Items.CROSSBOW, new ResourceLocation("firework"), (p_174605_, p_174606_, p_174607_, p_174608_) -> {
            return p_174607_ != null && CrossbowItem.isCharged(p_174605_) && CrossbowItem.containsChargedProjectile(p_174605_, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
        });
    }

}
