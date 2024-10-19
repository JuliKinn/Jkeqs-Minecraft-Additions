package net.julian.tutorialmod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DiceItem extends Item {
    public DiceItem(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(!pLevel.isClientSide() && pUsedHand==InteractionHand.MAIN_HAND){
            outputRandomNumber(pPlayer, 1);
            pPlayer.getCooldowns().addCooldown(this, 20);
        }else if (!pLevel.isClientSide() && pUsedHand==InteractionHand.OFF_HAND){
            outputRandomNumber(pPlayer, 2);
            pPlayer.getCooldowns().addCooldown(this, 20);
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()){
            components.add(Component.literal("Right-click Dice in off-hand to roll a number between 1 and 20... DND style!").withStyle(ChatFormatting.AQUA));
        }else{
            components.add(Component.literal("Right-click Dice in main hand to roll a number between 1 and 6... Also Press SHIFT for more info"));
        }
    }

    private void outputRandomNumber(Player player, int Rando){
        if (Rando == 1){
            player.sendSystemMessage(Component.literal("Your number is "+ getRandomNumber()));
        }else{
            player.sendSystemMessage(Component.literal("Your number is "+ getRandomNumber2()));
        }

    }
    private int getRandomNumber(){
        return (RandomSource.createNewThreadLocalInstance().nextInt(6)+1);
    }
    private int getRandomNumber2(){
        return (RandomSource.createNewThreadLocalInstance().nextInt(20)+1);
    }
}
