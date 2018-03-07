package com.facebook.imagepipeline.instrumentation;

import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbAnalyticsConfig;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.AtomicLongMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: only remove and update ops can be dispatched in first pass */
public class RequestPerfLoggingListener implements RequestListener {
    private static final ImmutableMap<String, String> f11033b = ImmutableBiMap.m978b("cancelled", "true");
    private static final ImmutableMap<String, String> f11034c = ImmutableBiMap.m978b("failed", "false");
    private static final RequestSequence f11035d = new RequestSequence();
    private static volatile RequestPerfLoggingListener f11036k;
    @VisibleForTesting
    final AtomicLongMap<String> f11037a = new AtomicLongMap(new ConcurrentHashMap());
    private final SequenceLogger f11038e;
    private final MonotonicClock f11039f;
    private final PerfTestConfig f11040g;
    public final BaseAnalyticsConfig f11041h;
    private final FbNetworkManager f11042i;
    public final int f11043j;

    /* compiled from: only remove and update ops can be dispatched in first pass */
    class RequestSequence extends AbstractSequenceDefinition {
        public RequestSequence() {
            super(1179650, "ImagePipelineStreamedRequestSequence");
        }
    }

    public static com.facebook.imagepipeline.instrumentation.RequestPerfLoggingListener m16373a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11036k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.imagepipeline.instrumentation.RequestPerfLoggingListener.class;
        monitor-enter(r1);
        r0 = f11036k;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m16376b(r0);	 Catch:{ all -> 0x0035 }
        f11036k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11036k;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.instrumentation.RequestPerfLoggingListener.a(com.facebook.inject.InjectorLike):com.facebook.imagepipeline.instrumentation.RequestPerfLoggingListener");
    }

    private static RequestPerfLoggingListener m16376b(InjectorLike injectorLike) {
        return new RequestPerfLoggingListener(SequenceLoggerImpl.m3464a(injectorLike), PerfTestConfig.m2936a(injectorLike), FbAnalyticsConfig.m3559a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), XConfigReader.m2681a(injectorLike), FbNetworkManager.m3811a(injectorLike));
    }

    @Inject
    public RequestPerfLoggingListener(SequenceLogger sequenceLogger, PerfTestConfig perfTestConfig, BaseAnalyticsConfig baseAnalyticsConfig, MonotonicClock monotonicClock, XConfigReader xConfigReader, FbNetworkManager fbNetworkManager) {
        this.f11038e = sequenceLogger;
        this.f11040g = perfTestConfig;
        this.f11041h = baseAnalyticsConfig;
        this.f11039f = monotonicClock;
        this.f11042i = fbNetworkManager;
        this.f11043j = xConfigReader.m2683a(ImagePipelineLoggingXConfig.f11045c, 15);
    }

    public final void mo2103a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        if (m16377c(str)) {
            ImmutableMap immutableMap;
            if (PerfTestConfigBase.m2938a()) {
                immutableMap = null;
            } else {
                obj = obj instanceof CallerContext ? (CallerContext) obj : CallerContext.f5180a;
                immutableMap = ImmutableMap.builder().m609b("analyticsTag", String.valueOf(obj.m9068c())).m609b("callerContextClass", obj.f5181b).m609b("callerContextTag", obj.m9067b()).m609b("isPrefetch", Boolean.toString(z)).m609b("networkType", this.f11042i.m3835k()).m609b("networkSubtype", this.f11042i.m3836l()).m609b("moduleAnalyticsTag", String.valueOf(obj.m9069d())).m610b();
            }
            Sequence a = this.f11038e.mo513a(f11035d, str, immutableMap, this.f11039f.now());
            SequenceLoggerDetour.a(a, "request_lifetime", null, null, this.f11039f.now(), -446093726);
            if (!z) {
                SequenceLoggerDetour.a(a, "grey_box_time", null, null, this.f11039f.now(), 237416282);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m16377c(java.lang.String r4) {
        /*
        r3 = this;
        r1 = com.facebook.common.perftest.base.PerfTestConfigBase.f1519n;
        r0 = r1;
        if (r0 != 0) goto L_0x001b;
    L_0x0005:
        r1 = r3.f11041h;
        r1 = r1.m3566c();
        r0 = r1;
        if (r0 == 0) goto L_0x001d;
    L_0x000e:
        r1 = java.lang.System.identityHashCode(r4);
        r2 = r3.f11043j;
        r1 = r1 % r2;
        if (r1 != 0) goto L_0x001f;
    L_0x0017:
        r1 = 1;
    L_0x0018:
        r0 = r1;
        if (r0 == 0) goto L_0x001d;
    L_0x001b:
        r0 = 1;
    L_0x001c:
        return r0;
    L_0x001d:
        r0 = 0;
        goto L_0x001c;
    L_0x001f:
        r1 = 0;
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.instrumentation.RequestPerfLoggingListener.c(java.lang.String):boolean");
    }

    public final void mo2106a(String str, String str2) {
        Sequence b = this.f11038e.mo517b(f11035d, str);
        if (b != null) {
            SequenceLoggerDetour.a(b, str2, null, null, this.f11039f.now(), 1128856158);
            this.f11037a.m16389b(str);
        }
    }

    public final void mo2109a(String str, String str2, @Nullable Map<String, String> map) {
        Sequence b = this.f11038e.mo517b(f11035d, str);
        if (b != null) {
            SequenceLoggerDetour.b(b, str2, null, m16374a((Map) map), this.f11039f.now(), 1692147298);
            this.f11037a.m16390c(str);
            m16375a(b, str);
        }
    }

    public final void mo2108a(String str, String str2, Throwable th, @Nullable Map<String, String> map) {
        Sequence b = this.f11038e.mo517b(f11035d, str);
        if (b != null) {
            ImmutableMap b2 = !PerfTestConfigBase.m2938a() ? map == null ? ImmutableBiMap.m978b("cause", th.toString()) : ImmutableMap.builder().m608a((Map) map).m609b("cause", th.toString()).m610b() : null;
            SequenceLoggerDetour.c(b, str2, null, b2, this.f11039f.now(), 1033826400);
            this.f11037a.m16390c(str);
            m16375a(b, str);
        }
    }

    public final void mo2112b(String str, String str2, @Nullable Map<String, String> map) {
        Sequence b = this.f11038e.mo517b(f11035d, str);
        if (b != null) {
            SequenceLoggerDetour.b(b, str2, null, m16374a((Map) map), this.f11039f.now(), -1026228159);
            this.f11037a.m16390c(str);
            m16375a(b, str);
        }
    }

    public final void mo2107a(String str, String str2, String str3) {
        Sequence b = this.f11038e.mo517b(f11035d, str);
        if (b != null) {
            StringBuilder stringBuilder = new StringBuilder((str2.length() + 1) + str3.length());
            stringBuilder.append(str2).append("_").append(str3);
            SequenceLoggerDetour.e(b, stringBuilder.toString(), 1029159626);
        }
    }

    public final void mo2105a(ImageRequest imageRequest, String str, boolean z) {
        Sequence b = this.f11038e.mo517b(f11035d, str);
        if (b != null) {
            if (b.mo631f("grey_box_time")) {
                SequenceLoggerDetour.b(b, "grey_box_time", -262625253);
            }
            SequenceLoggerDetour.b(b, "request_lifetime", null, f11034c, this.f11039f.now(), 1580758615);
            m16375a(b, str);
        }
    }

    public final void mo2104a(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        Sequence b = this.f11038e.mo517b(f11035d, str);
        if (b != null) {
            ImmutableMap immutableMap;
            if (b.mo631f("grey_box_time")) {
                SequenceLoggerDetour.b(b, "grey_box_time", -1047881063);
            }
            if (PerfTestConfigBase.m2938a()) {
                immutableMap = null;
            } else {
                immutableMap = ImmutableMap.of("failed", "true", "exception", th.getClass().getName(), "cause", th.toString());
            }
            Sequence sequence = b;
            SequenceLoggerDetour.c(sequence, "request_lifetime", null, immutableMap, this.f11039f.now(), -716306400);
            m16375a(b, str);
        }
    }

    public final void mo2111b(String str) {
        Sequence b = this.f11038e.mo517b(f11035d, str);
        if (b != null) {
            if (b.mo631f("grey_box_time")) {
                SequenceLoggerDetour.b(b, "grey_box_time", 315961911);
            }
            SequenceLoggerDetour.b(b, "request_lifetime", null, f11033b, this.f11039f.now(), 748850326);
            m16375a(b, str);
        }
    }

    private void m16375a(Sequence sequence, String str) {
        if (!sequence.mo631f("request_lifetime")) {
            long j;
            AtomicLong atomicLong = (AtomicLong) this.f11037a.f11044a.get(str);
            if (atomicLong == null) {
                j = 0;
            } else {
                j = atomicLong.get();
            }
            if (j == 0) {
                this.f11037a.m16391d(str);
                this.f11038e.mo521b(f11035d, str, null, this.f11039f.now());
            }
        }
    }

    public final boolean mo2110a(String str) {
        return !PerfTestConfigBase.m2938a() && m16377c(str);
    }

    private ImmutableMap<String, String> m16374a(Map<String, String> map) {
        return (map == null || PerfTestConfigBase.m2938a()) ? null : ImmutableMap.copyOf((Map) map);
    }
}
