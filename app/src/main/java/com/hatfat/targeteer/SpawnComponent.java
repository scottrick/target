package com.hatfat.targeteer;

import com.hatfat.agl.component.AglComponent;
import com.hatfat.agl.util.Vec3;

import java.util.Random;

public class SpawnComponent extends AglComponent {

    public float frequency = 0.05f;
    public float currentTimer = 0.0f;

    private float range = 6.0f;
    private Random random = new Random();

    private Vec3 spawnVelocity;

    public SpawnComponent(Vec3 spawnVelocity) {
        super(TargetComponentType.SPAWNER);

        this.spawnVelocity = spawnVelocity;
    }

    public Vec3 getNewSpawnVelocity() {
        return new Vec3(spawnVelocity.x, random.nextFloat() * range * 2.0f - range, 0.0f);
    }
}
