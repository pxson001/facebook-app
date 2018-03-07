package com.facebook.messaging.audio.playback;

import com.facebook.analytics.cache.CacheTracker.Factory;
import com.facebook.analytics.webrequest.WebRequestCounters;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.memory.MemoryManager;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StreamUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.media.cache.DefaultCacheErrorLogger;
import com.facebook.ui.media.cache.MediaCache;
import com.facebook.ui.media.cache.MediaCacheKey;
import com.facebook.ui.media.cache.MediaCacheParams;
import com.facebook.ui.media.cache.ObjectEncoder;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: originalDataFreshness */
public class AudioCache extends MediaCache<AudioCacheKey, byte[]> {
    private static volatile AudioCache f8031a;

    /* compiled from: originalDataFreshness */
    final class C08991 implements ObjectEncoder<AudioCacheKey, byte[]> {
        C08991() {
        }

        public final Object m8297a(MediaCacheKey mediaCacheKey, BinaryResource binaryResource) {
            AudioCacheKey audioCacheKey = (AudioCacheKey) mediaCacheKey;
            InputStream a = binaryResource.a();
            try {
                Object a2 = StreamUtil.a(a);
                return a2;
            } finally {
                a.close();
            }
        }

        public final void m8299a(MediaCacheKey mediaCacheKey, Object obj, OutputStream outputStream) {
            outputStream.write((byte[]) obj);
        }

        public final Object m8298a(MediaCacheKey mediaCacheKey, byte[] bArr) {
            return bArr;
        }
    }

    public static com.facebook.messaging.audio.playback.AudioCache m8300a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8031a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.audio.playback.AudioCache.class;
        monitor-enter(r1);
        r0 = f8031a;	 Catch:{ all -> 0x003a }
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
        r0 = m8302b(r0);	 Catch:{ all -> 0x0035 }
        f8031a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8031a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.audio.playback.AudioCache.a(com.facebook.inject.InjectorLike):com.facebook.messaging.audio.playback.AudioCache");
    }

    private static AudioCache m8302b(InjectorLike injectorLike) {
        return new AudioCache((Clock) SystemClockMethodAutoProvider.a(injectorLike), Factory.a(injectorLike), WebRequestCounters.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (MemoryTrimmableRegistry) MemoryManager.a(injectorLike), FileCache_AudioFileCacheMethodAutoProvider.m8342a(injectorLike), (CacheErrorLogger) DefaultCacheErrorLogger.a(injectorLike));
    }

    protected final int m8304b(Object obj) {
        return ((byte[]) obj).length;
    }

    @Inject
    public AudioCache(Clock clock, Factory factory, WebRequestCounters webRequestCounters, AbstractFbErrorReporter abstractFbErrorReporter, @Nullable MemoryTrimmableRegistry memoryTrimmableRegistry, DiskStorageCache diskStorageCache, CacheErrorLogger cacheErrorLogger) {
        super(clock, factory, webRequestCounters, abstractFbErrorReporter, m8301a("audio", "audio", false), memoryTrimmableRegistry, diskStorageCache, m8303b(), cacheErrorLogger);
    }

    private static ObjectEncoder<AudioCacheKey, byte[]> m8303b() {
        return new C08991();
    }

    private static MediaCacheParams m8301a(String str, String str2, boolean z) {
        MediaCacheParams mediaCacheParams = new MediaCacheParams();
        mediaCacheParams.a = str;
        mediaCacheParams = mediaCacheParams;
        mediaCacheParams.b = str2;
        mediaCacheParams = mediaCacheParams;
        mediaCacheParams.c = z;
        mediaCacheParams = mediaCacheParams;
        mediaCacheParams.f = Integer.MAX_VALUE;
        mediaCacheParams = mediaCacheParams;
        mediaCacheParams.g = Integer.MAX_VALUE;
        mediaCacheParams = mediaCacheParams;
        mediaCacheParams.d = 0;
        mediaCacheParams = mediaCacheParams;
        mediaCacheParams.e = 0;
        return mediaCacheParams;
    }
}
