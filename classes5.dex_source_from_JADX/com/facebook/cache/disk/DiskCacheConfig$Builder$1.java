package com.facebook.cache.disk;

import com.facebook.cache.disk.DiskCacheConfig.Builder;
import com.facebook.common.internal.Supplier;
import java.io.File;

/* compiled from: android.intent.action.SEND */
class DiskCacheConfig$Builder$1 implements Supplier<File> {
    final /* synthetic */ Builder f10776a;

    DiskCacheConfig$Builder$1(Builder builder) {
        this.f10776a = builder;
    }

    public final Object m18801a() {
        return this.f10776a.k.getApplicationContext().getCacheDir();
    }
}
