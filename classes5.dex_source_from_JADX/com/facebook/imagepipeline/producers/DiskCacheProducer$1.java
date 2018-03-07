package com.facebook.imagepipeline.producers;

import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TOPIC_PYML */
class DiskCacheProducer$1 implements Continuation<EncodedImage, Task<EncodedImage>> {
    final /* synthetic */ BufferedDiskCache f13756a;
    final /* synthetic */ CacheKey f13757b;
    final /* synthetic */ AtomicBoolean f13758c;
    final /* synthetic */ DiskCacheProducer f13759d;

    DiskCacheProducer$1(DiskCacheProducer diskCacheProducer, BufferedDiskCache bufferedDiskCache, CacheKey cacheKey, AtomicBoolean atomicBoolean) {
        this.f13759d = diskCacheProducer;
        this.f13756a = bufferedDiskCache;
        this.f13757b = cacheKey;
        this.f13758c = atomicBoolean;
    }

    public final Object m23112a(Task task) {
        if (DiskCacheProducer.b(task)) {
            return task;
        }
        return (task.b() || task.c() == null) ? this.f13756a.a(this.f13757b, this.f13758c) : task;
    }
}
