package com.hatfat.targeteer;

import com.hatfat.agl.component.ComponentType;

public class TargetComponentType extends ComponentType {

    public static final TargetComponentType SPAWNER = new TargetComponentType(1);

    protected TargetComponentType(int typeId) {
        super(typeId);
    }
}
