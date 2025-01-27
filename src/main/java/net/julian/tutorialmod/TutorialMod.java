package net.julian.tutorialmod;

import net.julian.tutorialmod.block.ModBlocks;
import net.julian.tutorialmod.item.ModCreativeModeTab;
import net.julian.tutorialmod.item.ModItems;
import net.julian.tutorialmod.networking.ModMessages;
import net.julian.tutorialmod.potion.ModPotions;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialMod.MOD_ID)
public class TutorialMod
{
    public static final String MOD_ID = "tutorialmod";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public TutorialMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        net.julian.tutorialmod.item.ModCreativeModeTab.register(eventBus);
        net.julian.tutorialmod.sound.ModSounds.register(eventBus);
        net.julian.tutorialmod.item.ModItems.register(eventBus);
        net.julian.tutorialmod.block.ModBlocks.register(eventBus);

        net.julian.tutorialmod.effect.ModEffects.register(eventBus);
        net.julian.tutorialmod.potion.ModPotions.register(eventBus);
        net.julian.tutorialmod.block.entity.ModBlockEntities.register(eventBus);
        net.julian.tutorialmod.screen.ModMenuTypes.register(eventBus);
        net.julian.tutorialmod.recipe.ModRecipes.register(eventBus);
        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::addCreative);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void clientSetup(final FMLClientSetupEvent event) {
        MenuScreens.register(net.julian.tutorialmod.screen.ModMenuTypes.TOILET_MENU.get(), net.julian.tutorialmod.screen.ToiletScreen::new);
        net.julian.tutorialmod.util.ModItemProperties.addCustomItemProperties();


    }
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey()== CreativeModeTabs.TOOLS_AND_UTILITIES){
            event.accept(ModItems.DICE);
            event.accept(ModBlocks.TOILET);
            event.accept(ModBlocks.BROWNISH_BLOCK);
            event.accept(ModBlocks.REDDISH_BLOCK);
            event.accept(ModBlocks.POO_BLOCK);
            event.accept(ModBlocks.WHITE_RICE_PLANT);
            event.accept(ModBlocks.LIGHT_GRAY_TRAPDOOR);
            event.accept(ModBlocks.LIME_TRAPDOOR);
            event.accept(ModBlocks.WHITE_TRAPDOOR);
            event.accept(ModBlocks.BLACK_TRAPDOOR);
            event.accept(ModBlocks.GREEN_TRAPDOOR);
            event.accept(ModBlocks.ORANGE_TRAPDOOR);
            event.accept(ModBlocks.YELLOW_TRAPDOOR);
            event.accept(ModBlocks.MAGENTA_TRAPDOOR);
            event.accept(ModBlocks.BROWN_TRAPDOOR);
            event.accept(ModBlocks.PURPLE_TRAPDOOR);
            event.accept(ModBlocks.PINK_TRAPDOOR);
            event.accept(ModBlocks.LIGHT_BLUE_TRAPDOOR);
            event.accept(ModBlocks.GRAY_TRAPDOOR);
            event.accept(ModBlocks.CYAN_TRAPDOOR);
            event.accept(ModBlocks.BLUE_TRAPDOOR);
            event.accept(ModBlocks.BLUE_STAIRS);
            event.accept(ModBlocks.RED_TRAPDOOR);
            event.accept(ModItems.GOLDEN_SKECHERS);
            event.accept(ModItems.POO);
            event.accept(ModItems.POO_RADAR);
            event.accept(ModItems.TICKLER);
            event.accept(ModItems.THOR_HAMMER);
            event.accept(ModItems.SCOPED_CROSSBOW);
            event.accept(ModItems.SIDEWALK_MUSIC_DISC);
            event.accept(ModItems.INVISABLE_ITEM_FRAME);
            event.accept(ModItems.SMOKE_BOMB);
            event.accept(ModItems.BOTTLE_OF_PEE);
            event.accept(ModItems.BOTTLE_OF_FART);
            event.accept(ModItems.STONE_LONGSWORD);
            event.accept(ModItems.IRON_LONGSWORD);
            event.accept(ModItems.GOLD_LONGSWORD);
            event.accept(ModItems.DIAMOND_LONGSWORD);
            event.accept(ModItems.NETHERITE_LONGSWORD);
            event.accept(ModItems.STONE_BATTLEAXE);
            event.accept(ModItems.IRON_BATTLEAXE);
            event.accept(ModItems.GOLD_BATTLEAXE);
            event.accept(ModItems.DIAMOND_BATTLEAXE);
            event.accept(ModItems.NETHERITE_BATTLEAXE);
            event.accept(ModItems.WHITE_RICE_CRUMBS);
            event.accept(ModItems.BOWL_OF_WHITE_RICE);
            event.accept(ModItems.ONIGIRI);
            event.accept(ModItems.EGG_SUSHI);
            event.accept(ModItems.FISH_SUSHI);
            event.accept(ModItems.FANCY_GOLDEN_APPLE_JUICE);
            event.accept(ModItems.ENCHANTED_GOLDEN_APPLE_JUICE);
            event.accept(ModItems.GOLDEN_APPLE_JUICE);
            event.accept(ModItems.GATORADE);
            event.accept(ModItems.WHITE_RICE_SEEDS);
            event.accept(ModItems.TOILET_PAPER);
            event.accept(ModItems.TICKLER_ATTACK_MUSIC_DISC);
            event.accept(ModItems.HISTORY_MYTH_REVIEWS_MUSIC_DISC);
            event.accept(ModItems.NEYS_MUSIC_DISC);
            event.accept(ModItems.SIDEWALK_MUSIC_DISC);
            event.accept(ModItems.WAR_OF_WORLDS_MUSIC_DISC);
            event.accept(ModItems.MISHA_PIANO_MUSIC_DISC);
            event.accept(ModItems.RUSH_E_MUSIC_DISC);
            event.accept(ModItems.MISHA_RAMBLES_MUSIC_DISC);
            event.accept(ModItems.THE_GREAT_WAR_MUSIC_DISC);
            event.accept(ModItems.LYRIC_ESSAY_MUSIC_DISC);
            event.accept(ModItems.STILLNESS_MUSIC_DISC);
            event.accept(ModItems.WILDERNESS_MUSIC_DISC);
            event.accept(ModItems.SLEEPING_GIANT_MUSIC_DISC);
            event.accept(ModItems.SOVIET_ANTHEM_MUSIC_DISC);
            event.accept(ModItems.GALLIMAUFRY_MUSIC_DISC);
            event.accept(ModItems.BLOODTIDE_SUBWAY_MUSIC_DISC);
            event.accept(ModItems.ICE_CREAM_MIXTURE);
            event.accept(ModItems.ICE_CREAM_BASE);
            event.accept(ModItems.ICE_CREAM);
            event.accept(ModItems.BLIZZARD);
            event.accept(ModItems.CHAINSAW);
            event.accept(ModItems.CANADA_ANTHEM_MUSIC_DISC);
            event.accept(ModItems.AMERICA_ANTHEM_MUSIC_DISC);
            event.accept(ModItems.JAPAN_ANTHEM_MUSIC_DISC);
            event.accept(ModItems.MONGOLIA_ANTHEM_MUSIC_DISC);
            event.accept(ModItems.RUSSIA_ANTHEM_MUSIC_DISC);
            event.accept(ModItems.FRANCE_ANTHEM_MUSIC_DISC);
            event.accept(ModItems.ROMANIA_ANTHEM_MUSIC_DISC);
            event.accept(ModItems.GERMANY_ANTHEM_MUSIC_DISC);
            event.accept(ModItems.TARHUN);
        }
    }
    private void setup(final FMLCommonSetupEvent event) {

        event.enqueueWork(() ->{

            BrewingRecipeRegistry.addRecipe(new net.julian.tutorialmod.util.BetterBrewingRecipe(Potions.AWKWARD, net.julian.tutorialmod.item.ModItems.POO.get(), ModPotions.FREEZE_POTION.get()));
        });
        ModMessages.register();
    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WHITE_RICE_PLANT.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CYAN_TRAPDOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.RED_TRAPDOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLUE_TRAPDOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GREEN_TRAPDOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHT_BLUE_TRAPDOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BROWN_TRAPDOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PURPLE_TRAPDOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ORANGE_TRAPDOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MAGENTA_TRAPDOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PINK_TRAPDOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.YELLOW_TRAPDOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ORANGE_TRAPDOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHT_GRAY_TRAPDOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIME_TRAPDOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLACK_TRAPDOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WHITE_TRAPDOOR.get(), RenderType.cutout());
        }
    }
}
