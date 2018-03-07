package com.facebook.imagepipeline.core;

import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;

/* compiled from: TRANSPARENT */
class ImagePipeline$5 implements Continuation<Boolean, Task<Boolean>> {
    final /* synthetic */ CacheKey f13693a;
    final /* synthetic */ ImagePipeline f13694b;

    ImagePipeline$5(ImagePipeline imagePipeline, CacheKey cacheKey) {
        this.f13694b = imagePipeline;
        this.f13693a = cacheKey;
    }

    public final Object m23019a(Task task) {
        if (task.a() || task.b() || !((Boolean) task.c()).booleanValue()) {
            return this.f13694b.h.b(this.f13693a);
        }
        return Task.a(Boolean.valueOf(true));
    }
}
