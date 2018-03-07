package com.facebook.richdocument.fonts;

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
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import java.io.File;

@InjectorModule
/* compiled from: pps */
public class RichDocumentFontsModule extends AbstractLibraryModule {

    /* compiled from: pps */
    final class C06921 implements Supplier<File> {
        final /* synthetic */ Context f5281a;

        C06921(Context context) {
            this.f5281a = context;
        }

        public final Object m5215a() {
            return this.f5281a.getCacheDir();
        }
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @ContextScoped
    @FontFileCache
    public static DiskStorageCache m5216a(Context context, CacheErrorLogger cacheErrorLogger, Factory factory, DiskCacheManager diskCacheManager) {
        return new DiskStorageCache(new DynamicDefaultDiskStorage(1, new C06921(context), "custom_fonts", cacheErrorLogger), new DefaultEntryEvictionComparatorSupplier(), new Params(262144, 5242880, 10485760), factory.a("custom_fonts_file"), cacheErrorLogger, diskCacheManager);
    }
}
