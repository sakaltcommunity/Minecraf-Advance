package com.sakalti.minecraftadvance.entity;

import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.level.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.level.levelgen.placement.MobSpawnSettings;

public class FireSpiderSpawn {

    @SubscribeEvent
    public static void onBiomeLoading(BiomeLoadingEvent event) {
        if (event.getCategory() == Biome.BiomeCategory.NETHER) {  // ネザー全域
            event.getSpawns().addSpawn(MobCategory.MONSTER,
                    new MobSpawnSettings.SpawnerData(ModEntities.FIRE_SPIDER.get(), 100, 1, 3));
        }
    }

    public static void register(IEventBus eventBus) {
        eventBus.addListener(FireSpiderSpawn::onBiomeLoading);
    }
}
