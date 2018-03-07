package com.facebook.video.engine.texview;

import com.facebook.common.memory.MemoryTrimType;

/* compiled from: composer_step_exposed */
class SurfaceTexturePool$1 implements Runnable {
    final /* synthetic */ MemoryTrimType f18851a;
    final /* synthetic */ SurfaceTexturePool f18852b;

    SurfaceTexturePool$1(SurfaceTexturePool surfaceTexturePool, MemoryTrimType memoryTrimType) {
        this.f18852b = surfaceTexturePool;
        this.f18851a = memoryTrimType;
    }

    public void run() {
        SurfaceTexturePool.b(this.f18852b, this.f18851a);
    }
}
