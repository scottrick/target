package com.hatfat.targeteer;

import android.content.Context;

import com.hatfat.agl.app.AglRenderer;
import com.hatfat.agl.base.AglScene;
import com.hatfat.agl.base.systems.MovementSystem;
import com.hatfat.agl.component.RenderableComponent;
import com.hatfat.agl.component.camera.OrthographicCameraComponent;
import com.hatfat.agl.component.transform.Transform;
import com.hatfat.agl.entity.AglEntity;
import com.hatfat.agl.mesh.TestRenderableFactory;
import com.hatfat.agl.render.AglRenderable;
import com.hatfat.agl.util.Vec2;
import com.hatfat.agl.util.Vec3;

public class TargetScene extends AglScene {

    private Vec2 fieldDimensions = new Vec2();

    public TargetScene(Context context) {
        super(context, true);

        addSystem(new SpawnSystem());
        addSystem(new MovementSystem());

        //Vec3 eye, Vec3 center, Vec3 up, float width, float near, float far
        AglEntity cameraEntity = new AglEntity("Targeteer! Menu Orthographic Camera");
        cameraEntity.addComponent(new OrthographicCameraComponent(
                new Vec3(0.0f, 0.0f, 2.0f),
                new Vec3(0.0f, 0.0f, 0.0f),
                new Vec3(0.0f, 1.0f, 0.0f),
                100.0f, 0.1f, 20.0f));

        addCameraEntity(cameraEntity);
    }

    @Override protected void setupSceneGLWork(AglRenderer renderer) {
        super.setupSceneGLWork(renderer);

        fieldDimensions.x = ((OrthographicCameraComponent) getCamera()).getWidth();
        fieldDimensions.y = ((OrthographicCameraComponent) getCamera()).getHeight();

        AglRenderable titleRenderable = TestRenderableFactory.createTextureSquare(
                renderer.getTextureManager().getTexture("title"));

        RenderableComponent renderableComponent = new RenderableComponent(titleRenderable);
        Transform transformComponent = new Transform(new Vec3(-50.0f, 0.0f, 0.0f));
        transformComponent.setScale(new Vec3(5f, 5f, 5f));

        AglEntity spawnEntity = new AglEntity("Test Spawner");
        spawnEntity.addComponent(renderableComponent);
        spawnEntity.addComponent(transformComponent);
        spawnEntity.addComponent(new SpawnComponent(new Vec3(20.0f, 0.0f, 0.0f)));
        addEntity(spawnEntity);

//        AglEntity titleEntity = new AglEntity("Test Entity");
//        titleEntity.addComponent(renderableComponent);
//        titleEntity.addComponent(transformComponent);
//        titleEntity.addComponent(new MovementComponent(new Vec3(0.0f, 0.0f, 0.0f), new Vec3(25.0f, 0.0f, 0.0f)));
//        addEntity(titleEntity);
    }
}
