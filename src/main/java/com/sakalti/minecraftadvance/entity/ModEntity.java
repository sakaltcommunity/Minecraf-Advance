package com.sakalti.minecraftadvance.entity;

import com.sakalti.minecraftadvance.MinecraftAdvance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MinecraftAdvance.MODID);

    // Atlandエンティティ
    public static final RegistryObject<EntityType<AtlandEntity>> ATLAND = ENTITY_TYPES.register("atland",
        () -> EntityType.Builder.of(AtlandEntity::new, MobCategory.MONSTER)
            .sized(1.0F, 1.0F) // サイズ（幅、高さ）
            .build(MinecraftAdvance.MODID + ":atland"));

    // FireSpiderエンティティ
    public static final RegistryObject<EntityType<FireSpiderEntity>> FIRE_SPIDER = ENTITY_TYPES.register("fire_spider",
        () -> EntityType.Builder.of(FireSpiderEntity::new, MobCategory.MONSTER)
            .sized(1.4F, 0.9F) // サイズ（幅、高さ）
            .build(MinecraftAdvance.MODID + ":fire_spider"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
        eventBus.addListener(ModEntities::onAttributeCreation);

        // スポーンルール登録
        AtlandSpawn.register(eventBus);
        FireSpiderSpawn.register(eventBus); // ファイアスパイダーのスポーン登録
    }

    @SubscribeEvent
    public static void onAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(ATLAND.get(), AtlandEntity.createAttributes().build());
        event.put(FIRE_SPIDER.get(), FireSpiderEntity.createAttributes().build()); // ファイアスパイダーの属性登録
    }
}
