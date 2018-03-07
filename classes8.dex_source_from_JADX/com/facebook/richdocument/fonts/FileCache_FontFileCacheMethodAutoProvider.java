package com.facebook.richdocument.fonts;

import android.content.Context;
import com.facebook.analytics.cache.CacheTracker.Factory;
import com.facebook.cache.DiskCacheManager;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ui.media.cache.DefaultCacheErrorLogger;

/* compiled from: preliminary_entities */
public class FileCache_FontFileCacheMethodAutoProvider extends AbstractProvider<FileCache> {
    private static DiskStorageCache f5250a;
    private static final Object f5251b = new Object();

    private static DiskStorageCache m5177b(InjectorLike injectorLike) {
        return RichDocumentFontsModule.m5216a((Context) injectorLike.getInstance(Context.class), (CacheErrorLogger) DefaultCacheErrorLogger.a(injectorLike), Factory.a(injectorLike), DiskCacheManager.a(injectorLike));
    }

    public Object get() {
        return RichDocumentFontsModule.m5216a((Context) getInstance(Context.class), (CacheErrorLogger) DefaultCacheErrorLogger.a(this), Factory.a(this), DiskCacheManager.a(this));
    }

    public static DiskStorageCache m5176a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DiskStorageCache b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5251b) {
                DiskStorageCache diskStorageCache;
                if (a2 != null) {
                    diskStorageCache = (DiskStorageCache) a2.a(f5251b);
                } else {
                    diskStorageCache = f5250a;
                }
                if (diskStorageCache == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5177b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5251b, b3);
                        } else {
                            f5250a = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = diskStorageCache;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
