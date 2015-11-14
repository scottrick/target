package com.hatfat.targeteer;

import com.hatfat.agl.app.AglRenderer;
import com.hatfat.agl.base.AglSystem;
import com.hatfat.agl.component.ComponentType;
import com.hatfat.agl.component.MovementComponent;
import com.hatfat.agl.component.RenderableComponent;
import com.hatfat.agl.component.transform.Transform;
import com.hatfat.agl.entity.AglEntity;
import com.hatfat.agl.mesh.TestRenderableFactory;
import com.hatfat.agl.render.AglRenderable;
import com.hatfat.agl.textures.AglTextureManager;
import com.hatfat.agl.util.Vec3;

import java.util.Arrays;

public class SpawnSystem extends AglSystem {

    private AglRenderable testRenderable;

    public SpawnSystem() {
        super(Arrays.asList(TargetComponentType.SPAWNER, ComponentType.TRANSFORM));
    }

    @Override
    public void prepareRenderables(AglRenderer renderer) {
        AglTextureManager tm = renderer.getTextureManager();
        testRenderable = TestRenderableFactory.createNormalMappedTextureCube(
                tm.getDefaultTexture(),
                tm.getDefaultNormapMapTexture(),
                tm.getDefaultNormapMapTexture());
    }

    @Override
    public void updateEntity(AglEntity aglEntity, float deltaTime) {
        SpawnComponent spawnComponent = aglEntity.getComponentByType(TargetComponentType.SPAWNER);
        Transform transform = aglEntity.getComponentByType(ComponentType.TRANSFORM);

        spawnComponent.currentTimer += deltaTime;

        if (spawnComponent.currentTimer >= spawnComponent.frequency) {
            /* spawn! */
            spawnComponent.currentTimer -= spawnComponent.frequency;

            AglEntity newEntity = new AglEntity("spawned entity");

            newEntity.addComponent(new Transform(transform.posQuat.pos));
            newEntity.addComponent(new MovementComponent(spawnComponent.spawnVelocity, new Vec3()));
            newEntity.addComponent(new RenderableComponent(testRenderable));

            getScene().addEntity(newEntity);
        }
    }
}
