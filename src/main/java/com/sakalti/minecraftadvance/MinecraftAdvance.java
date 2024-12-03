package com.sakalti.minecraftadvance;

import com.sakalti.minecraftadvance.entity.ModEntities;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MinecraftAdvance.MODID)
public class MinecraftAdvance {
    public static final String MODID = "minecraftadvance";

    public MinecraftAdvance() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModEntities.register(modEventBus); // エンティティ登録

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // 共通設定
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // サーバー起動時
    }
}
