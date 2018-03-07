package com.facebook.richdocument.fonts;

import android.content.Context;
import android.net.Uri;
import com.facebook.analytics.cache.CacheTracker.Factory;
import com.facebook.analytics.webrequest.WebRequestCounters;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.memory.MemoryManager;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StreamUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ui.media.cache.DefaultCacheErrorLogger;
import com.facebook.ui.media.cache.MediaCache;
import com.facebook.ui.media.cache.MediaCacheKey;
import com.facebook.ui.media.cache.MediaCacheParams;
import com.facebook.ui.media.cache.ObjectEncoder;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: prefetch_show_start */
public class FontCache extends MediaCache<FontCacheKey, byte[]> {
    private static FontCache f5252a;
    private static final Object f5253b = new Object();

    /* compiled from: prefetch_show_start */
    final class C06901 implements ObjectEncoder<FontCacheKey, byte[]> {
        C06901() {
        }

        public final Object m5178a(MediaCacheKey mediaCacheKey, BinaryResource binaryResource) {
            FontCacheKey fontCacheKey = (FontCacheKey) mediaCacheKey;
            InputStream a = binaryResource.a();
            try {
                Object a2 = StreamUtil.a(a);
                return a2;
            } finally {
                a.close();
            }
        }

        public final void m5180a(MediaCacheKey mediaCacheKey, Object obj, OutputStream outputStream) {
            outputStream.write((byte[]) obj);
        }

        public final Object m5179a(MediaCacheKey mediaCacheKey, byte[] bArr) {
            return bArr;
        }
    }

    private static FontCache m5182b(InjectorLike injectorLike) {
        return new FontCache((Clock) SystemClockMethodAutoProvider.a(injectorLike), Factory.a(injectorLike), WebRequestCounters.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (MemoryTrimmableRegistry) MemoryManager.a(injectorLike), FileCache_FontFileCacheMethodAutoProvider.m5176a(injectorLike), (CacheErrorLogger) DefaultCacheErrorLogger.a(injectorLike));
    }

    protected final int m5186b(Object obj) {
        return ((byte[]) obj).length;
    }

    @Inject
    public FontCache(Clock clock, Factory factory, WebRequestCounters webRequestCounters, AbstractFbErrorReporter abstractFbErrorReporter, @Nullable MemoryTrimmableRegistry memoryTrimmableRegistry, DiskStorageCache diskStorageCache, CacheErrorLogger cacheErrorLogger) {
        super(clock, factory, webRequestCounters, abstractFbErrorReporter, m5184c(), memoryTrimmableRegistry, diskStorageCache, m5183b(), cacheErrorLogger);
    }

    public static FontCache m5181a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FontCache b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5253b) {
                FontCache fontCache;
                if (a2 != null) {
                    fontCache = (FontCache) a2.a(f5253b);
                } else {
                    fontCache = f5252a;
                }
                if (fontCache == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5182b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5253b, b3);
                        } else {
                            f5252a = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = fontCache;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Map<FontCacheKey, Uri> m5185a(Set<FontCacheKey> set) {
        Map<FontCacheKey, Uri> hashMap = new HashMap();
        for (FontCacheKey fontCacheKey : set) {
            if (b(fontCacheKey)) {
                FileBinaryResource fileBinaryResource = (FileBinaryResource) d(fontCacheKey);
                if (fileBinaryResource != null) {
                    File file = fileBinaryResource.a;
                    if (file != null && file.exists()) {
                        hashMap.put(fontCacheKey, Uri.fromFile(file));
                    }
                }
            }
        }
        return hashMap;
    }

    private static ObjectEncoder<FontCacheKey, byte[]> m5183b() {
        return new C06901();
    }

    private static MediaCacheParams m5184c() {
        MediaCacheParams mediaCacheParams = new MediaCacheParams();
        mediaCacheParams.a = "custom_fonts";
        mediaCacheParams = mediaCacheParams;
        mediaCacheParams.b = "custom_fonts";
        mediaCacheParams = mediaCacheParams;
        mediaCacheParams.c = false;
        mediaCacheParams = mediaCacheParams;
        mediaCacheParams.f = 100;
        mediaCacheParams = mediaCacheParams;
        mediaCacheParams.d = 0;
        mediaCacheParams = mediaCacheParams;
        mediaCacheParams.e = 0;
        return mediaCacheParams;
    }
}
