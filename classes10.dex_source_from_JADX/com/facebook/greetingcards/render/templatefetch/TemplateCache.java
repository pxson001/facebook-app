package com.facebook.greetingcards.render.templatefetch;

import com.facebook.analytics.cache.CacheTracker.Factory;
import com.facebook.analytics.webrequest.WebRequestCounters;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.common.memory.MemoryManager;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.greetingcards.render.FileCache_TemplateFileCacheMethodAutoProvider;
import com.facebook.greetingcards.verve.model.VMDeck;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.media.cache.DefaultCacheErrorLogger;
import com.facebook.ui.media.cache.MediaCache;
import com.facebook.ui.media.cache.MediaCacheKey;
import com.facebook.ui.media.cache.MediaCacheParams;
import com.facebook.ui.media.cache.ObjectEncoder;
import com.fasterxml.jackson.core.JsonFactory;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: xma_action_view_boarding_pass */
public class TemplateCache extends MediaCache<UriCacheKey, VMDeck> {
    private static volatile TemplateCache f241a;

    /* compiled from: xma_action_view_boarding_pass */
    class TemplateEncoder implements ObjectEncoder<UriCacheKey, VMDeck> {
        private final JsonFactory f240a;

        public final Object m283a(MediaCacheKey mediaCacheKey, BinaryResource binaryResource) {
            UriCacheKey uriCacheKey = (UriCacheKey) mediaCacheKey;
            InputStream a = binaryResource.a();
            try {
                Object a2 = m282a(a);
                return a2;
            } finally {
                a.close();
            }
        }

        public final void m285a(MediaCacheKey mediaCacheKey, Object obj, OutputStream outputStream) {
            this.f240a.b(outputStream).a((VMDeck) obj);
        }

        public TemplateEncoder(JsonFactory jsonFactory) {
            this.f240a = jsonFactory;
        }

        public final Object m284a(MediaCacheKey mediaCacheKey, byte[] bArr) {
            return (VMDeck) this.f240a.a(bArr).a(VMDeck.class);
        }

        private VMDeck m282a(InputStream inputStream) {
            return (VMDeck) this.f240a.a(inputStream).a(VMDeck.class);
        }
    }

    public static com.facebook.greetingcards.render.templatefetch.TemplateCache m286a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f241a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.greetingcards.render.templatefetch.TemplateCache.class;
        monitor-enter(r1);
        r0 = f241a;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m289b(r0);	 Catch:{ all -> 0x0035 }
        f241a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f241a;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.greetingcards.render.templatefetch.TemplateCache.a(com.facebook.inject.InjectorLike):com.facebook.greetingcards.render.templatefetch.TemplateCache");
    }

    private static TemplateCache m289b(InjectorLike injectorLike) {
        return new TemplateCache((Clock) SystemClockMethodAutoProvider.a(injectorLike), Factory.a(injectorLike), WebRequestCounters.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (MemoryTrimmableRegistry) MemoryManager.a(injectorLike), FileCache_TemplateFileCacheMethodAutoProvider.m191a(injectorLike), (CacheErrorLogger) DefaultCacheErrorLogger.a(injectorLike), JsonFactoryMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TemplateCache(Clock clock, Factory factory, WebRequestCounters webRequestCounters, AbstractFbErrorReporter abstractFbErrorReporter, @Nullable MemoryTrimmableRegistry memoryTrimmableRegistry, DiskStorageCache diskStorageCache, CacheErrorLogger cacheErrorLogger, JsonFactory jsonFactory) {
        super(clock, factory, webRequestCounters, abstractFbErrorReporter, m287a("template", "template", true), memoryTrimmableRegistry, diskStorageCache, m288a(jsonFactory), cacheErrorLogger);
    }

    private static ObjectEncoder<UriCacheKey, VMDeck> m288a(JsonFactory jsonFactory) {
        return new TemplateEncoder(jsonFactory);
    }

    protected final int m290b(Object obj) {
        return 51200;
    }

    private static MediaCacheParams m287a(String str, String str2, boolean z) {
        MediaCacheParams mediaCacheParams = new MediaCacheParams();
        mediaCacheParams.a = str;
        mediaCacheParams = mediaCacheParams;
        mediaCacheParams.b = str2;
        mediaCacheParams = mediaCacheParams;
        mediaCacheParams.c = z;
        mediaCacheParams = mediaCacheParams;
        mediaCacheParams.f = 4;
        mediaCacheParams = mediaCacheParams;
        mediaCacheParams.g = 4;
        mediaCacheParams = mediaCacheParams;
        mediaCacheParams.d = 0;
        mediaCacheParams = mediaCacheParams;
        mediaCacheParams.e = 0;
        return mediaCacheParams;
    }
}
