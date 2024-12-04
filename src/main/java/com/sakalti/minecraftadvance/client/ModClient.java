package com.sakalti.minecraftadvance.client;

import com.sakalti.minecraftadvance.client.renderer.AtlandRenderer;
import com.sakalti.minecraftadvance.client.renderer.FireSpiderRenderer;
import com.sakalti.minecraftadvance.entity.ModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;

@OnlyIn(Dist.CLIENT)
public class ModClient {

    public static void register(IEventBus modEventBus) {
        modEventBus.addListener(ModClient::registerRenderers);
    }

    private static void registerRenderers(RegisterRenderersEvent event) {
        event.registerEntityRenderer(ModEntities.ATLAND.get(), AtlandRenderer::new);
        event.registerEntityRenderer(ModEntities.FIRE_SPIDER.get(), FireSpiderRenderer::new); // ファイアスパイダー追加
    }
}
