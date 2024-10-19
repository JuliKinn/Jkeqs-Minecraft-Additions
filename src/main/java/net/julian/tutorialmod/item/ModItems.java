package net.julian.tutorialmod.item;

import net.julian.tutorialmod.TutorialMod;
import net.julian.tutorialmod.block.ModBlocks;

import net.julian.tutorialmod.item.custom.*;
import net.julian.tutorialmod.sound.ModSounds;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);
    public static final RegistryObject<Item> POO = ITEMS.register("poo",
            () -> new Item(new Item.Properties().food(ModFoods.POO)));
    public static final RegistryObject<Item> TICKLER = ITEMS.register("tickler",
            () -> new TicklerHoeItem(Tiers.IRON, 0, 0f, new Item.Properties()));
    public static final RegistryObject<Item> STONE_LONGSWORD = ITEMS.register("stone_longsword",
            () -> new SwordItem(Tiers.STONE, 6, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> IRON_LONGSWORD = ITEMS.register("iron_longsword",
            () -> new SwordItem(Tiers.IRON, 6, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> GOLD_LONGSWORD = ITEMS.register("gold_longsword",
            () -> new SwordItem(Tiers.GOLD, 6, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_LONGSWORD = ITEMS.register("diamond_longsword",
            () -> new SwordItem(Tiers.DIAMOND, 6, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_LONGSWORD = ITEMS.register("netherite_longsword",
            () -> new SwordItem(Tiers.NETHERITE, 6, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_BATTLEAXE = ITEMS.register("netherite_battleaxe",
            () -> new AxeItem(Tiers.NETHERITE, 8, -3.3f, new Item.Properties()));
    public static final RegistryObject<Item> STONE_BATTLEAXE = ITEMS.register("stone_battleaxe",
            () -> new AxeItem(Tiers.STONE, 8, -3.3f, new Item.Properties()));
    public static final RegistryObject<Item> IRON_BATTLEAXE = ITEMS.register("iron_battleaxe",
            () -> new AxeItem(Tiers.IRON, 8, -3.3f, new Item.Properties()));
    public static final RegistryObject<Item> GOLD_BATTLEAXE = ITEMS.register("gold_battleaxe",
            () -> new AxeItem(Tiers.GOLD, 8, -3.3f, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_BATTLEAXE = ITEMS.register("diamond_battleaxe",
            () -> new AxeItem(Tiers.DIAMOND, 8, -3.3f, new Item.Properties()));
    public static final RegistryObject<Item> SCOPED_CROSSBOW = ITEMS.register("scoped_crossbow",
            () -> new CrossbowItem(new Item.Properties().durability(500)));
    public static final RegistryObject<Item> INVISABLE_ITEM_FRAME = ITEMS.register("invisable_item_frame",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SMOKE_BOMB = ITEMS.register("smoke_bomb",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BOTTLE_OF_FART = ITEMS.register("bottle_of_fart",
            () -> new HoneyBottleItem(new Item.Properties().food(ModFoods.BOTTLE_OF_FART).stacksTo(16)));
    public static final RegistryObject<Item> BOTTLE_OF_PEE = ITEMS.register("bottle_of_pee",
            () -> new HoneyBottleItem(new Item.Properties().food(ModFoods.BOTTLE_OF_PEE).stacksTo(16)));

    public static final RegistryObject<Item> GOLDEN_APPLE_JUICE = ITEMS.register("golden_apple_juice",
            () -> new HoneyBottleItem(new Item.Properties().food(ModFoods.GOLDEN_APPLE_JUICE).stacksTo(16)));
    public static final RegistryObject<Item> FANCY_GOLDEN_APPLE_JUICE = ITEMS.register("fancy_golden_apple_juice",
            () -> new HoneyBottleItem(new Item.Properties().food(ModFoods.FANCY_GOLDEN_APPLE_JUICE).stacksTo(16)));
    public static final RegistryObject<Item> ENCHANTED_GOLDEN_APPLE_JUICE = ITEMS.register("enchanted_golden_apple_juice",
            () -> new HoneyBottleItem(new Item.Properties().food(ModFoods.ENCHANTED_GOLDEN_APPLE_JUICE).stacksTo(16)));
    public static final RegistryObject<Item> GATORADE = ITEMS.register("gatorade",
            () -> new HoneyBottleItem(new Item.Properties().food(ModFoods.GATORADE).stacksTo(16)));

    public static final RegistryObject<Item> WHITE_RICE_CRUMBS = ITEMS.register("white_rice_crumbs",
            () -> new Item(new Item.Properties().food(ModFoods.WHITE_RICE_CRUMBS)));
    public static final RegistryObject<Item> BOWL_OF_WHITE_RICE = ITEMS.register("bowl_of_white_rice",
            () -> new BowlFoodItem(new Item.Properties().food(ModFoods.ONIGIRI).stacksTo(1)));
    public static final RegistryObject<Item> ONIGIRI = ITEMS.register("onigiri",
            () -> new Item(new Item.Properties().food(ModFoods.ONIGIRI)));
    public static final RegistryObject<Item> FISH_SUSHI = ITEMS.register("fish_sushi",
            () -> new Item(new Item.Properties().food(ModFoods.SUSHI)));
    public static final RegistryObject<Item> EGG_SUSHI = ITEMS.register("egg_sushi",
            () -> new Item(new Item.Properties().food(ModFoods.SUSHI)));
    public static final RegistryObject<Item> WHITE_RICE_SEEDS = ITEMS.register("white_rice_seeds",
            () -> new ItemNameBlockItem(ModBlocks.WHITE_RICE_PLANT.get(), new Item.Properties()));

    public static final RegistryObject<Item> BLIZZARD = ITEMS.register("blizzard",
            () -> new BowlFoodItem(new Item.Properties().food(ModFoods.ICE_CREAM).stacksTo(16)));
    public static final RegistryObject<Item> ICE_CREAM = ITEMS.register("ice_cream",
            () -> new Item(new Item.Properties().food(ModFoods.ICE_CREAM)));
    public static final RegistryObject<Item> ICE_CREAM_MIXTURE = ITEMS.register("ice_cream_mixture",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ICE_CREAM_BASE = ITEMS.register("ice_cream_base",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TOILET_PAPER = ITEMS.register("toilet_paper",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TICKLER_ATTACK_MUSIC_DISC = ITEMS.register("tickler_attack_music_disc",
            ()->new RecordItem(15, ModSounds.TICKLER_ATTACK, new Item.Properties().stacksTo(1), 6000));
    public static final RegistryObject<Item> HISTORY_MYTH_REVIEWS_MUSIC_DISC = ITEMS.register("history_myth_reviews_music_disc",
            () -> new RecordItem(14, ModSounds.HISTORY_MYTH_REVIEWS, new Item.Properties().stacksTo(1), 6000));
    public static final RegistryObject<Item> MISHA_RAMBLES_MUSIC_DISC = ITEMS.register("misha_rambles_music_disc",
            () -> new RecordItem(13, ModSounds.MISHA_RAMBLES, new Item.Properties().stacksTo(1), 6000));
    public static final RegistryObject<Item> THE_GREAT_WAR_MUSIC_DISC = ITEMS.register("the_great_war_music_disc",
            () -> new RecordItem(12, ModSounds.THE_GREAT_WAR, new Item.Properties().stacksTo(1), 6000));
    public static final RegistryObject<Item> WAR_OF_WORLDS_MUSIC_DISC = ITEMS.register("war_of_worlds_music_disc",
            () -> new RecordItem(11, ModSounds.WAR_OF_WORLDS, new Item.Properties().stacksTo(1), 6000));
    public static final RegistryObject<Item> SIDEWALK_MUSIC_DISC = ITEMS.register("sidewalk_music_disc",
            () -> new RecordItem(10, ModSounds.SIDEWALK, new Item.Properties().stacksTo(1), 6000));
    public static final RegistryObject<Item> MISHA_PIANO_MUSIC_DISC = ITEMS.register("misha_piano_music_disc",
            () -> new RecordItem(9, ModSounds.MISHA_PIANO, new Item.Properties().stacksTo(1), 6000));
    public static final RegistryObject<Item> RUSH_E_MUSIC_DISC = ITEMS.register("rush_e_music_disc",
            () -> new RecordItem(8, ModSounds.RUSH_E, new Item.Properties().stacksTo(1), 6000));
    public static final RegistryObject<Item> LYRIC_ESSAY_MUSIC_DISC = ITEMS.register("lyric_essay_music_disc",
            () -> new RecordItem(7, ModSounds.LYRIC_ESSAY, new Item.Properties().stacksTo(1), 6000));
    public static final RegistryObject<Item> STILLNESS_MUSIC_DISC = ITEMS.register("stillness_music_disc",
            () -> new RecordItem(6, ModSounds.STILLNESS, new Item.Properties().stacksTo(1), 6000));
    public static final RegistryObject<Item> WILDERNESS_MUSIC_DISC = ITEMS.register("wilderness_music_disc",
            () -> new RecordItem(5, ModSounds.WILDERNESS, new Item.Properties().stacksTo(1), 6000));

    public static final RegistryObject<Item> SLEEPING_GIANT_MUSIC_DISC = ITEMS.register("sleeping_giant_music_disc",
            () -> new RecordItem(4, ModSounds.SLEEPING_GIANT, new Item.Properties().stacksTo(1), 6000));
    public static final RegistryObject<Item> NEYS_MUSIC_DISC = ITEMS.register("neys_music_disc",
            () -> new RecordItem(3, ModSounds.NEYS, new Item.Properties().stacksTo(1), 6600));
    public static final RegistryObject<Item> GALLIMAUFRY_MUSIC_DISC = ITEMS.register("gallimaufry_music_disc",
            () -> new RecordItem(2, ModSounds.GALLIMAUFRY, new Item.Properties().stacksTo(1), 7200));
    public static final RegistryObject<Item> SOVIET_ANTHEM_MUSIC_DISC = ITEMS.register("soviet_anthem_music_disc",
            () -> new RecordItem(1, ModSounds.SOVIET_ANTHEM, new Item.Properties().stacksTo(1), 6600));
    public static final RegistryObject<Item> BLOODTIDE_SUBWAY_MUSIC_DISC = ITEMS.register("bloodtide_subway_music_disc",
            () -> new RecordItem(1, ModSounds.BLOODTIDE_SUBWAY, new Item.Properties().stacksTo(1), 2400));

    public static final RegistryObject<Item> POO_RADAR = ITEMS.register("poo_radar",
            () -> new PooRadarItem(new Item.Properties().durability(32)));
    public static final RegistryObject<Item> THOR_HAMMER = ITEMS.register("thor_hammer",
            () -> new ThorHammerItem(ModTiers.THOR, 3, -2f, new Item.Properties()));




    public static final RegistryObject<Item> GOLDEN_SKECHERS = ITEMS.register("golden_skechers",
            () -> new ModArmorItem(ModArmorMaterials.POO, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> DICE = ITEMS.register("dice", ()->new DiceItem(new Item.Properties().stacksTo(1)));




    public static void register(IEventBus eventbus){
        ITEMS.register(eventbus);
    }
}
