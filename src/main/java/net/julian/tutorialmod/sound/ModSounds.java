package net.julian.tutorialmod.sound;

import net.julian.tutorialmod.TutorialMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TutorialMod.MOD_ID);
    public static final RegistryObject<SoundEvent> TICKLER_ATTACK = registerSoundEvent("tickler_attack");
    public static final RegistryObject<SoundEvent> HISTORY_MYTH_REVIEWS = registerSoundEvent("history_myth_reviews");
    public static final RegistryObject<SoundEvent> MISHA_RAMBLES = registerSoundEvent("misha_rambles");
    public static final RegistryObject<SoundEvent> THE_GREAT_WAR = registerSoundEvent("the_great_war");
    public static final RegistryObject<SoundEvent> WAR_OF_WORLDS = registerSoundEvent("war_of_worlds");
    public static final RegistryObject<SoundEvent> SIDEWALK = registerSoundEvent("sidewalk");
    public static final RegistryObject<SoundEvent> GALLIMAUFRY = registerSoundEvent("gallimaufry");
    public static final RegistryObject<SoundEvent> NEYS = registerSoundEvent("neys");
    public static final RegistryObject<SoundEvent> MISHA_PIANO = registerSoundEvent("misha_piano");
    public static final RegistryObject<SoundEvent> RUSH_E = registerSoundEvent("rush_e");
    public static final RegistryObject<SoundEvent> LYRIC_ESSAY = registerSoundEvent("lyric_essay");
    public static final RegistryObject<SoundEvent> STILLNESS = registerSoundEvent("stillness");
    public static final RegistryObject<SoundEvent> WILDERNESS = registerSoundEvent("wilderness");
    public static final RegistryObject<SoundEvent> SLEEPING_GIANT = registerSoundEvent("sleeping_giant");
    public static final RegistryObject<SoundEvent> SOVIET_ANTHEM = registerSoundEvent("soviet_anthem");
    public static final RegistryObject<SoundEvent> POO_RADAR_FOUND_ORE = registerSoundEvent("poo_radar_found_ore");
    public static final RegistryObject<SoundEvent> BLOODTIDE_SUBWAY = registerSoundEvent("bloodtide_subway");
    private static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(TutorialMod.MOD_ID, name)));
    }
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
