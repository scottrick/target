package com.hatfat.targeteer;

import com.hatfat.agl.component.AglComponent;
import com.hatfat.agl.util.Vec3;

public class SpawnComponent extends AglComponent {

    public float frequency = 0.3f;
    public float currentTimer = 0.0f;

    public Vec3 spawnVelocity;

    public SpawnComponent(Vec3 spawnVelocity) {
        super(TargetComponentType.SPAWNER);

        this.spawnVelocity = spawnVelocity;
    }
}
