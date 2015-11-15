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
import com.hatfat.agl.util.Vec3;

import java.util.Arrays;
import java.util.Random;

public class SpawnSystem extends AglSystem {

    private Random random = new Random();
    private AglRenderable[] testRenderables = new AglRenderable[1];

    public SpawnSystem() {
        super(Arrays.asList(TargetComponentType.SPAWNER, ComponentType.TRANSFORM));
    }

    @Override
    public void prepareRenderables(AglRenderer renderer) {
//        AglTextureManager tm = renderer.getTextureManager();
//        testRenderable = TestRenderableFactory.createNormalMappedTextureCube(
//                tm.getDefaultTexture(),
//                tm.getDefaultNormapMapTexture(),
//                tm.getDefaultNormapMapTexture());

        testRenderables[0] = TestRenderableFactory.createIcosahedron();
    }

    @Override
    public void updateEntity(AglEntity aglEntity, float deltaTime) {
        SpawnComponent spawnComponent = aglEntity.getComponentByType(TargetComponentType.SPAWNER);
        Transform transform = aglEntity.getComponentByType(ComponentType.TRANSFORM);

        spawnComponent.currentTimer += deltaTime;

        while (spawnComponent.currentTimer >= spawnComponent.frequency) {
            /* spawn! */
            spawnComponent.currentTimer -= spawnComponent.frequency;

            AglEntity newEntity = new AglEntity("Spawned Entity");

            Transform newTransform = new Transform(transform.posQuat.pos);
            newTransform.setScale(new Vec3(2.0f, 2.0f, 2.0f));

            newEntity.addComponent(newTransform);
            newEntity.addComponent(new MovementComponent(spawnComponent.getNewSpawnVelocity(), new Vec3()));
            newEntity.addComponent(new RenderableComponent(testRenderables[random.nextInt(testRenderables.length)]));

            getScene().addEntity(newEntity);
        }
    }
}
