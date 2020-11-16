package com.github.atelieramber.entities.renderers;

import com.github.atelieramber.entities.SnowSwimmerEntity;
import com.github.atelieramber.entities.SnowSwimmerModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SnowSwimmerRenderer extends GeoEntityRenderer<SnowSwimmerEntity> {

    public SnowSwimmerRenderer(EntityRendererManager renderManager) {
        super(renderManager, new SnowSwimmerModel());
    }
}
