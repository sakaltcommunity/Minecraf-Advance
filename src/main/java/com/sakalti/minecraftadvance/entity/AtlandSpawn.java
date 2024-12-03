package com.sakalti.minecraftadvance.entity;

import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.level.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.level.levelgen.placement.MobSpawnSettings;

public class AtlandSpawn {

    // ビーチバイオームにAtlandEntityをスポーンさせるルール
    @SubscribeEvent
    public static void onBiomeLoading(BiomeLoadingEvent event) {
        if (event.getCategory() == Biome.BiomeCategory.BEACH) {  // ビーチバイオームに限定
            event.getSpawns().addSpawn(MobSpawnSettings.SpawnerData(
                    ModEntities.ATLAND.get(), // エンティティ
                    10,  // 最大数
                    1,  // 最小数
                    3   // スポーン間隔（ビーチバイオーム内でスポーン）
            ));
        }
    }

    public static void register(IEventBus eventBus) {
        eventBus.addListener(AtlandSpawn::onBiomeLoading);
    }
}
