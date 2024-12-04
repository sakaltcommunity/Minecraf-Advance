package com.sakalti.minecraftadvance.item;

import com.sakalti.minecraftadvance.MinecraftAdvance;
import com.sakalti.minecraftadvance.entity.ModEntities;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSpawnEggs {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MinecraftAdvance.MODID);

    // Atlandスポーンエッグ
    public static final RegistryObject<Item> ATLAND_SPAWN_EGG = ITEMS.register("atland_spawn_egg",
        () -> new SpawnEggItem(ModEntities.ATLAND.get(), 0x4caf50, 0x1565c0, // 緑と青
            new Item.Properties()));

    // FireSpiderスポーンエッグ
    public static final RegistryObject<Item> FIRE_SPIDER_SPAWN_EGG = ITEMS.register("fire_spider_spawn_egg",
        () -> new SpawnEggItem(ModEntities.FIRE_SPIDER.get(), 0xff4500, 0x8b0000, // オレンジと暗赤
            new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        eventBus.addListener(ModSpawnEggs::addCreativeItems);
    }

    private static void addCreativeItems(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ATLAND_SPAWN_EGG);
            event.accept(FIRE_SPIDER_SPAWN_EGG);
        }
    }
}
