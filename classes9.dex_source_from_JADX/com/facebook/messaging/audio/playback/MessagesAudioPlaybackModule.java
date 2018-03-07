package com.facebook.messaging.audio.playback;

import android.content.Context;
import com.facebook.analytics.cache.CacheTracker.Factory;
import com.facebook.cache.DiskCacheManager;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.DefaultEntryEvictionComparatorSupplier;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.DiskStorageCache.Params;
import com.facebook.cache.disk.DynamicDefaultDiskStorage;
import com.facebook.common.internal.Supplier;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import java.io.File;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: orca-video- */
public class MessagesAudioPlaybackModule extends AbstractLibraryModule {

    /* compiled from: orca-video- */
    final class C09101 implements Supplier<File> {
        final /* synthetic */ Context f8091a;

        C09101(Context context) {
            this.f8091a = context;
        }

        public final Object m8344a() {
            return this.f8091a.getCacheDir();
        }
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    @AudioFileCache
    public static DiskStorageCache m8345a(Context context, CacheErrorLogger cacheErrorLogger, Factory factory, DiskCacheManager diskCacheManager) {
        return new DiskStorageCache(new DynamicDefaultDiskStorage(1, new C09101(context), "audio", cacheErrorLogger), new DefaultEntryEvictionComparatorSupplier(), new Params(262144, 5242880, 10485760), factory.a("audio_file"), cacheErrorLogger, diskCacheManager);
    }
}
