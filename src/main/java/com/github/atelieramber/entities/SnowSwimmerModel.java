package com.github.atelieramber.entities;

import com.github.atelieramber.EternalFreeze;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SnowSwimmerModel extends AnimatedGeoModel<SnowSwimmerEntity> {

    @Override
    public ResourceLocation getModelLocation(SnowSwimmerEntity snowSwimmerEntity) {
        return new ResourceLocation(EternalFreeze.MODID, "geo/snow_swimmer.geo.json");
    }
    @Override
    public ResourceLocation getTextureLocation(SnowSwimmerEntity snowSwimmerEntity) {
        return new ResourceLocation(EternalFreeze.MODID, "textures/entity/snow_swimmer.json");
    }
    @Override
    public ResourceLocation getAnimationFileLocation(SnowSwimmerEntity snowSwimmerEntity) {
        return new ResourceLocation(EternalFreeze.MODID, "animations/snow_swimmer.anims.json");
    }
}
