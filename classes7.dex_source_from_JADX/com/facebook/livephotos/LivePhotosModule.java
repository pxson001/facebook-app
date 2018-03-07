package com.facebook.livephotos;

import android.content.Context;
import com.facebook.analytics.cache.CacheTracker.Factory;
import com.facebook.cache.DiskCacheManager;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskCacheConfig.Builder;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.DiskStorageCache.Params;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.core.DynamicDefaultDiskStorageFactory;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.livephotos.downloader.LivePhotosFileCache;
import java.io.File;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: permalink_set_notify_me */
public class LivePhotosModule extends AbstractLibraryModule {

    /* compiled from: permalink_set_notify_me */
    final class C06051 implements Supplier<File> {
        final /* synthetic */ Context f6632a;

        C06051(Context context) {
            this.f6632a = context;
        }

        public final Object m8545a() {
            return this.f6632a.getCacheDir();
        }
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @LivePhotosFileCache
    @Singleton
    static DiskCacheConfig m8546a(Context context, Factory factory, DiskCacheManager diskCacheManager) {
        Builder a = DiskCacheConfig.a(context);
        a.a = 1;
        a = a;
        a.b = "LivePhotos";
        a = a;
        a.c = new C06051(context);
        a = a;
        a.f = 4194304;
        a = a;
        a.e = 10485760;
        a = a;
        a.d = 15728640;
        a = a;
        a.i = factory.a("LivePhotos_file");
        a = a;
        a.j = diskCacheManager;
        return a.a();
    }

    @ProviderMethod
    @LivePhotosFileCache
    @Singleton
    public static DiskStorageCache m8547a(DiskCacheConfig diskCacheConfig) {
        DiskStorage a = new DynamicDefaultDiskStorageFactory().a(diskCacheConfig);
        return new DiskStorageCache(a, diskCacheConfig.g, new Params(diskCacheConfig.f, diskCacheConfig.e, diskCacheConfig.d), diskCacheConfig.i, diskCacheConfig.h, diskCacheConfig.j);
    }
}
