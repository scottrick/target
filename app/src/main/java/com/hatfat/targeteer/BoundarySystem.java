package com.hatfat.targeteer;

import android.graphics.RectF;

import com.hatfat.agl.app.AglRenderer;
import com.hatfat.agl.base.AglSystem;
import com.hatfat.agl.component.ComponentType;
import com.hatfat.agl.component.transform.Transform;
import com.hatfat.agl.entity.AglEntity;

import java.util.Arrays;

/**
 * The BoundarySystem removes objects that have went way beyond the playing field.
 */
public class BoundarySystem extends AglSystem {

    private final RectF boundary;

    public BoundarySystem(RectF boundary) {
        super(Arrays.asList(ComponentType.TRANSFORM));

        this.boundary = boundary;
    }

    @Override public void prepareRenderables(AglRenderer aglRenderer) {

    }

    @Override public void updateEntity(AglEntity entity, float deltaTime) {
        Transform transform = entity.getComponentByType(ComponentType.TRANSFORM);

        /* remove entities that are outside our boundary! */
        if (transform.posQuat.pos.x < boundary.left ||
                transform.posQuat.pos.x > boundary.right ||
                transform.posQuat.pos.y > boundary.top ||
                transform.posQuat.pos.y < boundary.bottom) {
            getScene().removeEntity(entity);
        }
    }
}
