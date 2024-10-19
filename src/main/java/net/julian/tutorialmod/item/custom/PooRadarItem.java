package net.julian.tutorialmod.item.custom;


import net.julian.tutorialmod.sound.ModSounds;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PooRadarItem extends Item {
    public PooRadarItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                Block blockBelow = pContext.getLevel().getBlockState(positionClicked.below(i)).getBlock();

                if(isValuableBlock(blockBelow)) {
                    outputValuableCoordinates(positionClicked.below(i), player, blockBelow);
                    foundBlock = true;
                    pContext.getLevel().playSound(player, positionClicked, ModSounds.POO_RADAR_FOUND_ORE.get(), SoundSource.BLOCKS, 1f, 1f);
                    break;
                }
            }

            if(!foundBlock) {
                player.sendSystemMessage(Component.translatable("item.tutorialmod.poo_radar.no_valuables"));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(pContext);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.poo_radar.tooltip.shift"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.poo_radar.tooltip"));
        }
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block blockBelow){
        String blox = String.valueOf(blockBelow.getName());
        player.sendSystemMessage(Component.literal("Found "+blox.replace("translation{key='block.minecraft.", "").replace("', args=[]}", "")+" at ("+blockPos.getX()+", "+blockPos.getY()+", "+blockPos.getZ()+")"));
    }
    private boolean isValuableBlock(Block block){
        return block == Blocks.IRON_ORE || block == Blocks.DIAMOND_ORE || block == Blocks.GOLD_ORE || block == Blocks.EMERALD_ORE||block == Blocks.REDSTONE_ORE ||block == Blocks.LAPIS_ORE ;
    }
}
