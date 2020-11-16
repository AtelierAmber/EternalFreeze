package com.github.atelieramber.registry;

import com.github.atelieramber.EternalFreeze;
import com.github.atelieramber.entities.SnowSwimmerEntity;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.NonNullFunction;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import java.util.function.Function;
import java.util.function.Supplier;

public class EntityRegistry {
    public static final class EntityEntry<T extends Entity> {
        private final RegistryObject<EntityType<T>> registry;
        private EntityEntry(final String name, final EntityType.IFactory<T> factory, final EntityClassification classification, final float width, final float height) {
            registry = Registry.ENTITY_TYPES.register(name, () -> EntityType.Builder.create(factory, classification).size(width, height).build(name));
        }
        private EntityEntry(final String name, final EntityType.Builder<T> builder){
            registry = Registry.ENTITY_TYPES.register(name, () -> builder.build(name));
        }

        public EntityType<T> get() {
            return registry.get();
        }
    }

    public static <T extends Entity> EntityEntry<T> makeRegistry(final String name, final EntityType.IFactory<T> constructor, EntityClassification classification, final float width, final float height) {
        return new EntityEntry<>(name, constructor, classification, width, height);
    }
    public static <T extends Entity> EntityEntry<T> makeRegistry(final String name, final EntityType.Builder<T> builder) {
        return new EntityEntry<>(name, builder);
    }

    public static final EntityEntry<SnowSwimmerEntity> SNOW_SWIMMER = makeRegistry("snow_swimmer", SnowSwimmerEntity::new, EntityClassification.MONSTER, 1.0f, 1.0f);

    protected static void init() { /* Dummy */ }

}
