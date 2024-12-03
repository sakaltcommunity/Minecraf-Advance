package com.sakalti.minecraftadvance.client;

import com.sakalti.minecraftadvance.client.renderer.AtlandRenderer;
import com.sakalti.minecraftadvance.entity.ModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.ModEventBus;
import net.minecraftforge.client.event.RegisterRenderersEvent;
import net.minecraftforge.client.Minecraft;

@OnlyIn(Dist.CLIENT)
public class ModClient {

    public static void register(IEventBus modEventBus) {
        modEventBus.addListener(ModClient::registerRenderers);
    }

    private static void registerRenderers(RegisterRenderersEvent event) {
        event.registerEntityRenderer(ModEntities.ATLAND.get(), AtlandRenderer::new);
    }
}
