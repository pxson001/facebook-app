package com.facebook.video.server.prefetcher;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.eventbus.TypedEventBus;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.imagepipeline.memory.GenericByteArrayPool;
import com.facebook.imagepipeline.memory.NoOpPoolStatsTracker;
import com.facebook.imagepipeline.memory.PoolParams;
import com.facebook.inject.Lazy;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.media.cache.PartialFileStorage;
import com.facebook.video.abtest.VideoPrefetchExperimentHelper;
import com.facebook.video.abtest.VideoPrefetchExperimentHelper.BytesToPrefetch;
import com.facebook.video.analytics.VideoPerformanceTracking;
import com.facebook.video.exoserviceclient.ExoServiceClient;
import com.facebook.video.server.DefaultNetworkProcessor;
import com.facebook.video.server.InterceptedReader;
import com.facebook.video.server.NetworkProcessor;
import com.facebook.video.server.TimeoutStreamHelper;
import com.facebook.video.server.VideoCacheKey;
import com.facebook.video.server.VideoKeyCreator;
import com.facebook.video.server.VideoResourceMetadata;
import com.facebook.video.server.VideoResourceMetadata.VideoResourceType;
import com.facebook.video.server.VideoServerModule.C04751;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.InterruptedIOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Provider;

/* compiled from: offlineThreadingId */
public class VideoPrefetcher {
    public static final String f11424a = VideoPrefetcher.class.getSimpleName();
    public static long f11425b = 0;
    public static long f11426c = 0;
    @GuardedBy("this")
    private final Map<Uri, PrefetchItemTask> f11427A;
    @GuardedBy("this")
    private final Multiset<Uri> f11428B;
    @GuardedBy("mReentrantLock")
    private int f11429C;
    public final Runnable f11430D = new C04761(this);
    private final Runnable f11431E = new C04772(this);
    public final PartialFileStorage<VideoCacheKey> f11432d;
    public final VideoPrefetchModel f11433e;
    private final ListeningExecutorService f11434f;
    public final AbstractFbErrorReporter f11435g;
    private final DeviceConditionHelper f11436h;
    public final VideoPrefetchExperimentHelper f11437i;
    public final Provider<Boolean> f11438j;
    public final FbZeroFeatureVisibilityHelper f11439k;
    public final Handler f11440l;
    public final C04751 f11441m;
    public final Lazy<VideoPerformanceTracking> f11442n;
    public final DefaultNetworkProcessor f11443o;
    public final GenericByteArrayPool f11444p;
    public final TimeoutStreamHelper f11445q;
    public final ReentrantLock f11446r = new ReentrantLock(true);
    public final AtomicInteger f11447s;
    public final TypedEventBus f11448t;
    public final MonotonicClock f11449u;
    private final SequenceLogger f11450v;
    public final LoggedInUserSessionManager f11451w;
    public final ObjectMapper f11452x;
    public final ExoServiceClient f11453y;
    @Nullable
    private PrefetchItemSequenceLogger f11454z;

    /* compiled from: offlineThreadingId */
    class C04761 implements Runnable {
        final /* synthetic */ VideoPrefetcher f11456a;

        C04761(VideoPrefetcher videoPrefetcher) {
            this.f11456a = videoPrefetcher;
        }

        public void run() {
            VideoPrefetcher.m16726d(this.f11456a);
        }
    }

    /* compiled from: offlineThreadingId */
    class C04772 implements Runnable {
        final /* synthetic */ VideoPrefetcher f11457a;

        C04772(VideoPrefetcher videoPrefetcher) {
            this.f11457a = videoPrefetcher;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r3 = this;
            r0 = 0;
            r1 = r3.f11457a;	 Catch:{ InterruptedIOException -> 0x0012 }
            r0 = com.facebook.video.server.prefetcher.VideoPrefetcher.m16729g(r1);	 Catch:{ InterruptedIOException -> 0x0012 }
            r3.m16737a();	 Catch:{ InterruptedIOException -> 0x0012, all -> 0x002a }
            if (r0 == 0) goto L_0x0011;
        L_0x000c:
            r0 = r3.f11457a;
            com.facebook.video.server.prefetcher.VideoPrefetcher.m16730h(r0);
        L_0x0011:
            return;
        L_0x0012:
            r1 = move-exception;
            com.facebook.video.server.prefetcher.VideoPrefetcher.f11424a;	 Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x0011;
        L_0x0018:
            r0 = r3.f11457a;
            com.facebook.video.server.prefetcher.VideoPrefetcher.m16730h(r0);
            goto L_0x0011;
        L_0x001e:
            r1 = move-exception;
            r2 = r1;
            r1 = r0;
            r0 = r2;
        L_0x0022:
            if (r1 == 0) goto L_0x0029;
        L_0x0024:
            r1 = r3.f11457a;
            com.facebook.video.server.prefetcher.VideoPrefetcher.m16730h(r1);
        L_0x0029:
            throw r0;
        L_0x002a:
            r1 = move-exception;
            r2 = r1;
            r1 = r0;
            r0 = r2;
            goto L_0x0022;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.server.prefetcher.VideoPrefetcher.2.run():void");
        }

        @GuardedBy("mReentrantLock")
        private void m16737a() {
            VideoPrefetcher.m16727e(this.f11457a);
            VideoPrefetchItem b = this.f11457a.f11433e.m14821b();
            if (b != null) {
                try {
                    this.f11457a.f11433e.m14818a(b, m16738a(b));
                } catch (Throwable th) {
                    this.f11457a.f11433e.m14818a(b, false);
                }
            }
        }

        private boolean m16738a(VideoPrefetchItem videoPrefetchItem) {
            return new PrefetchItemTask(this.f11457a, this.f11457a.f11447s.getAndIncrement(), videoPrefetchItem).a();
        }
    }

    /* compiled from: offlineThreadingId */
    public class VideoPrefetcherCallback {
        final /* synthetic */ VideoPrefetcher f11458a;

        public VideoPrefetcherCallback(VideoPrefetcher videoPrefetcher) {
            this.f11458a = videoPrefetcher;
        }

        public final void m16739a() {
            HandlerDetour.a(this.f11458a.f11440l, this.f11458a.f11430D, -1424751444);
        }
    }

    public VideoPrefetcher(PartialFileStorage<VideoCacheKey> partialFileStorage, VideoPrefetchModel videoPrefetchModel, ListeningExecutorService listeningExecutorService, FbErrorReporter fbErrorReporter, DeviceConditionHelper deviceConditionHelper, VideoPrefetchExperimentHelper videoPrefetchExperimentHelper, Provider<Boolean> provider, FbZeroFeatureVisibilityHelper fbZeroFeatureVisibilityHelper, Handler handler, VideoKeyCreator videoKeyCreator, Lazy<VideoPerformanceTracking> lazy, NetworkProcessor networkProcessor, MonotonicClock monotonicClock, SequenceLogger sequenceLogger, LoggedInUserAuthDataStore loggedInUserAuthDataStore, ObjectMapper objectMapper, ExoServiceClient exoServiceClient, TimeoutStreamHelper timeoutStreamHelper) {
        this.f11432d = partialFileStorage;
        this.f11433e = videoPrefetchModel;
        this.f11434f = listeningExecutorService;
        this.f11435g = fbErrorReporter;
        this.f11436h = deviceConditionHelper;
        this.f11437i = videoPrefetchExperimentHelper;
        this.f11438j = provider;
        this.f11439k = fbZeroFeatureVisibilityHelper;
        this.f11440l = handler;
        this.f11441m = videoKeyCreator;
        this.f11433e.m14819a(new VideoPrefetcherCallback(this));
        this.f11429C = videoPrefetchExperimentHelper.f11401b;
        this.f11442n = lazy;
        this.f11443o = networkProcessor;
        this.f11450v = sequenceLogger;
        this.f11451w = loggedInUserAuthDataStore;
        this.f11452x = objectMapper;
        this.f11448t = new TypedEventBus();
        this.f11447s = new AtomicInteger(0);
        this.f11449u = monotonicClock;
        this.f11428B = HashMultiset.m16740g();
        this.f11427A = new HashMap();
        this.f11445q = timeoutStreamHelper;
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(204800, 1);
        this.f11444p = new GenericByteArrayPool(NoOpMemoryTrimmableRegistry.m16319a(), new PoolParams(204800, Integer.MAX_VALUE, sparseIntArray), NoOpPoolStatsTracker.m15750a());
        this.f11453y = exoServiceClient;
    }

    public static boolean m16725b(VideoPrefetcher videoPrefetcher, Uri uri) {
        return videoPrefetcher.f11433e.m14822b(uri);
    }

    public final synchronized InterceptedReader m16732a(Uri uri, boolean z) {
        InterceptedReader interceptedReader;
        this.f11428B.add(uri);
        Integer.valueOf(this.f11428B.mo2163a(uri));
        if (this.f11437i.f11405f) {
            this.f11433e.m14817a(uri);
        }
        PrefetchItemTask prefetchItemTask = (PrefetchItemTask) this.f11427A.remove(uri);
        if (prefetchItemTask == null) {
            interceptedReader = null;
        } else {
            try {
                interceptedReader = prefetchItemTask.a(z);
            } catch (Throwable e) {
                BLog.a(f11424a, e, "Error getting the intercepted reader", new Object[0]);
                interceptedReader = null;
            }
        }
        return interceptedReader;
    }

    public final synchronized void m16733a(Uri uri) {
        this.f11428B.remove(uri);
        Integer.valueOf(this.f11428B.mo2163a(uri));
    }

    public static synchronized boolean m16722a(VideoPrefetcher videoPrefetcher, PrefetchItemTask prefetchItemTask) {
        boolean z = false;
        synchronized (videoPrefetcher) {
            if (!(videoPrefetcher.f11427A.containsKey(prefetchItemTask.b) || videoPrefetcher.f11428B.contains(prefetchItemTask.b))) {
                videoPrefetcher.f11427A.put(prefetchItemTask.b, prefetchItemTask);
                z = true;
            }
        }
        return z;
    }

    public static synchronized void m16724b(VideoPrefetcher videoPrefetcher, PrefetchItemTask prefetchItemTask) {
        synchronized (videoPrefetcher) {
            videoPrefetcher.f11427A.remove(prefetchItemTask.b);
        }
    }

    public static long m16721a() {
        return f11426c;
    }

    public static synchronized void m16727e(VideoPrefetcher videoPrefetcher) {
        synchronized (videoPrefetcher) {
            if (videoPrefetcher.f11454z == null && videoPrefetcher.f11450v != null) {
                videoPrefetcher.f11454z = new PrefetchItemSequenceLogger(videoPrefetcher.f11450v);
                videoPrefetcher.f11454z.a(videoPrefetcher.f11448t);
            }
        }
    }

    private void m16728f() {
        try {
            Futures.m2458a(this.f11434f.mo270a(this.f11431E, null), new 3(this), this.f11434f);
        } catch (Throwable e) {
            this.f11435g.m2343a(f11424a, "Error while submitting prefetching task", e);
        }
    }

    public static boolean m16729g(VideoPrefetcher videoPrefetcher) {
        videoPrefetcher.f11446r.lock();
        try {
            if (videoPrefetcher.f11429C <= 0) {
                throw new InterruptedIOException("Prefetch interrupted in tryHoldThread(), idleThreads = " + videoPrefetcher.f11429C);
            }
            Long.valueOf(Thread.currentThread().getId());
            videoPrefetcher.f11429C--;
            return true;
        } finally {
            videoPrefetcher.f11446r.unlock();
        }
    }

    public static void m16730h(VideoPrefetcher videoPrefetcher) {
        videoPrefetcher.f11446r.lock();
        try {
            videoPrefetcher.f11429C++;
            Long.valueOf(Thread.currentThread().getId());
        } finally {
            videoPrefetcher.f11446r.unlock();
        }
    }

    public static void m16726d(VideoPrefetcher videoPrefetcher) {
        Object obj;
        if (!videoPrefetcher.f11437i.f11400a || ((Boolean) videoPrefetcher.f11438j.get()).booleanValue() || videoPrefetcher.f11439k.m7924a(ZeroFeatureKey.VIDEO_PLAY_INTERSTITIAL)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null && m16731j(videoPrefetcher)) {
            videoPrefetcher.m16728f();
        }
    }

    public static boolean m16731j(VideoPrefetcher videoPrefetcher) {
        videoPrefetcher.f11446r.lock();
        try {
            boolean z = videoPrefetcher.f11429C > 0 && videoPrefetcher.f11433e.m14820a();
            videoPrefetcher.f11446r.unlock();
            return z;
        } catch (Throwable th) {
            videoPrefetcher.f11446r.unlock();
        }
    }

    public static int m16720a(VideoPrefetcher videoPrefetcher, VideoPrefetchItem videoPrefetchItem) {
        boolean z;
        int i = 1;
        VideoResourceMetadata videoResourceMetadata = videoPrefetchItem.b;
        if (videoResourceMetadata.g == VideoResourceType.DASH) {
            z = true;
        } else {
            z = false;
        }
        BytesToPrefetch a = videoPrefetcher.f11437i.m16707a(videoPrefetcher.f11436h.m5534b(), z);
        if (!a.e && videoPrefetchItem.a) {
            return 0;
        }
        if (!a.c || a.d <= 0 || videoPrefetchItem.a) {
            i = 0;
        }
        if (i != 0) {
            return videoResourceMetadata.a((long) a.d, a.a, a.b);
        }
        return a.b;
    }
}
