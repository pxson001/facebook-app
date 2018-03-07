package com.facebook.greetingcards.render;

import android.content.Context;
import com.facebook.analytics.cache.CacheTracker.Factory;
import com.facebook.cache.DiskCacheManager;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.DefaultEntryEvictionComparatorSupplier;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.DiskStorageCache.Params;
import com.facebook.cache.disk.DynamicDefaultDiskStorage;
import com.facebook.common.internal.Supplier;
import com.facebook.greetingcards.render.templatefetch.TemplateFileCache;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import java.io.File;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: xswght */
public class RenderCardModule extends AbstractLibraryModule {

    /* compiled from: xswght */
    final class C00391 implements Supplier<File> {
        final /* synthetic */ Context f220a;

        C00391(Context context) {
            this.f220a = context;
        }

        public final Object m264a() {
            return this.f220a.getCacheDir();
        }
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    @TemplateFileCache
    public static DiskStorageCache m265a(Context context, CacheErrorLogger cacheErrorLogger, Factory factory, DiskCacheManager diskCacheManager) {
        return new DiskStorageCache(new DynamicDefaultDiskStorage(1, new C00391(context), "template", cacheErrorLogger), new DefaultEntryEvictionComparatorSupplier(), new Params(10240, 102400, 1048576), factory.a("template_file"), cacheErrorLogger, diskCacheManager);
    }
}
