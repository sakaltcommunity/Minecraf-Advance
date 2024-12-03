package com.sakalti.minecraftadvance.client.renderer;

import com.sakalti.minecraftadvance.entity.AtlandEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SlimeOuterLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.SlimeModel;

public class AtlandRenderer extends MobRenderer<AtlandEntity, SlimeModel<AtlandEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("minecraftadvance:textures/entity/atland.png");

    public AtlandRenderer(EntityRendererProvider.Context context) {
        super(context, new SlimeModel<>(context.bakeLayer(SlimeModel.LAYER_LOCATION)), 0.25F);
        this.addLayer(new SlimeOuterLayer<>(this)); // 外装を追加（スライムのような外見）
    }

    @Override
    public ResourceLocation getTextureLocation(AtlandEntity entity) {
        return TEXTURE;
    }
}
