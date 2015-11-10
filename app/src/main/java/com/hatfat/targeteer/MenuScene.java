package com.hatfat.targeteer;

import android.content.Context;

import com.hatfat.agl.AglScene;
import com.hatfat.agl.app.AglRenderer;
import com.hatfat.agl.component.RenderableComponent;
import com.hatfat.agl.component.transform.Transform;
import com.hatfat.agl.entity.AglEntity;
import com.hatfat.agl.mesh.TestRenderableFactory;
import com.hatfat.agl.render.AglRenderable;

public class MenuScene extends AglScene {

    public MenuScene(Context context) {
        super(context, true);
    }

    @Override protected void setupSceneGLWork(AglRenderer renderer) {
        super.setupSceneGLWork(renderer);

        AglRenderable titleRenderable = TestRenderableFactory.createTextureSquare(
                renderer.getTextureManager().getTexture("title"));

        RenderableComponent renderableComponent = new RenderableComponent(titleRenderable);
        Transform transformComponent = new Transform();

        AglEntity entity = new AglEntity("Title Entity");
        entity.addComponent(renderableComponent);
        entity.addComponent(transformComponent);

        addEntity(entity);
    }
}
