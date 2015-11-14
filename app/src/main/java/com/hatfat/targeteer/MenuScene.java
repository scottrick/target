package com.hatfat.targeteer;

import android.content.Context;

import com.hatfat.agl.app.AglRenderer;
import com.hatfat.agl.base.AglScene;
import com.hatfat.agl.component.RenderableComponent;
import com.hatfat.agl.component.camera.OrthographicCameraComponent;
import com.hatfat.agl.component.transform.Transform;
import com.hatfat.agl.entity.AglEntity;
import com.hatfat.agl.mesh.TestRenderableFactory;
import com.hatfat.agl.render.AglRenderable;
import com.hatfat.agl.util.Vec3;

public class MenuScene extends AglScene {

    public MenuScene(Context context) {
        super(context, false);

        //Vec3 eye, Vec3 center, Vec3 up, float width, float near, float far
        AglEntity cameraEntity = new AglEntity("Targeteer! Menu Orthographic Camera");
        cameraEntity.addComponent(new OrthographicCameraComponent(
                new Vec3(0.0f, 0.0f, 2.0f),
                new Vec3(0.0f, 0.0f, 0.0f),
                new Vec3(0.0f, 1.0f, 0.0f),
                1.0f, 0.1f, 20.0f));

        addCameraEntity(cameraEntity);

//        AglEntity cameraEntity = new AglEntity("Targeteer! Menu Perspective Camera");
//        cameraEntity.addComponent(new PerspectiveCameraComponent(
//                new Vec3(0.0f, 0.0f, 2.0f),
//                new Vec3(0.0f, 0.0f, 0.0f),
//                new Vec3(0.0f, 1.0f, 0.0f),
//                60.0f, 1.0f, 0.1f, 1000.0f));
//
//        addCameraEntity(cameraEntity);
    }

    @Override protected void setupSceneGLWork(AglRenderer renderer) {
        super.setupSceneGLWork(renderer);

        AglRenderable titleRenderable = TestRenderableFactory.createTextureSquare(
                renderer.getTextureManager().getTexture("title"));

        RenderableComponent renderableComponent = new RenderableComponent(titleRenderable);
        Transform transformComponent = new Transform();
//        transformComponent.setScale(new Vec3(4.5f, 4.5f, 4.5f));

        AglEntity titleEntity = new AglEntity("Title Entity");
        titleEntity.addComponent(renderableComponent);
        titleEntity.addComponent(transformComponent);
        addEntity(titleEntity);

//        /* origin entity */
//        AglRenderable originRenderable = TestRenderableFactory.createOrigin();
//        RenderableComponent originRenderableComponent = new RenderableComponent(originRenderable);
//        Transform originTransform = new Transform();
//
//        AglEntity originEntity = new AglEntity("Origin Entity");
//        originEntity.addComponent(originRenderableComponent);
//        originEntity.addComponent(originTransform);
//        addEntity(originEntity);
    }
}
