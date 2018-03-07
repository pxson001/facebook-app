package com.facebook.drawee.instrumentation;

import android.graphics.drawable.Animatable;
import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.drawee.callercontext.FbDraweeCallerContext;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbAnalyticsConfig;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: memory_cache_size */
public class PerfLoggingListener extends BaseControllerListener {
    private static final ControllerSequence f14410f = new ControllerSequence();
    private static volatile PerfLoggingListener f14411g;
    private final SequenceLogger f14412a;
    private final MonotonicClock f14413b;
    private final PerfTestConfig f14414c;
    private final BaseAnalyticsConfig f14415d;
    private final FbNetworkManager f14416e;

    /* compiled from: memory_cache_size */
    class ControllerSequence extends AbstractSequenceDefinition {
        public ControllerSequence() {
            super(983041, "DraweeControllerSequence");
        }
    }

    public static com.facebook.drawee.instrumentation.PerfLoggingListener m20778a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14411g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.drawee.instrumentation.PerfLoggingListener.class;
        monitor-enter(r1);
        r0 = f14411g;	 Catch:{ all -> 0x003a }
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
        r0 = m20779b(r0);	 Catch:{ all -> 0x0035 }
        f14411g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14411g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.instrumentation.PerfLoggingListener.a(com.facebook.inject.InjectorLike):com.facebook.drawee.instrumentation.PerfLoggingListener");
    }

    private static PerfLoggingListener m20779b(InjectorLike injectorLike) {
        return new PerfLoggingListener(SequenceLoggerImpl.m3464a(injectorLike), PerfTestConfig.m2936a(injectorLike), FbAnalyticsConfig.m3559a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), FbNetworkManager.m3811a(injectorLike));
    }

    public final void mo2603a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        if (m20780c(str)) {
            Sequence b = this.f14412a.mo517b(f14410f, str);
            if (b != null) {
                SequenceLoggerDetour.b(b, "wait_time", null, null, this.f14413b.now(), 119237309);
                SequenceLoggerDetour.b(b, "good_enough_wait_time", null, null, this.f14413b.now(), 1113659755);
                SequenceLoggerDetour.b(b, "preview_wait_time", null, null, this.f14413b.now(), -327583096);
            }
        }
    }

    public final void mo2607b(String str, @Nullable Object obj) {
        CloseableImage closeableImage = (CloseableImage) obj;
        if (m20780c(str)) {
            Sequence b = this.f14412a.mo517b(f14410f, str);
            if (b != null && closeableImage != null) {
                SequenceLoggerDetour.b(b, "preview_wait_time", null, null, this.f14413b.now(), -2030142542);
                if (closeableImage.mo2983d().f17881c) {
                    SequenceLoggerDetour.b(b, "good_enough_wait_time", null, null, this.f14413b.now(), 66309052);
                }
            }
        }
    }

    @Inject
    public PerfLoggingListener(SequenceLogger sequenceLogger, PerfTestConfig perfTestConfig, BaseAnalyticsConfig baseAnalyticsConfig, MonotonicClock monotonicClock, FbNetworkManager fbNetworkManager) {
        this.f14412a = sequenceLogger;
        this.f14414c = perfTestConfig;
        this.f14415d = baseAnalyticsConfig;
        this.f14413b = monotonicClock;
        this.f14416e = fbNetworkManager;
    }

    public final void mo2605a(String str, Object obj) {
        if (m20780c(str)) {
            Sequence b = this.f14412a.mo517b(f14410f, str);
            if (b == null) {
                ImmutableMap immutableMap;
                if (PerfTestConfigBase.m2938a() || !(obj instanceof FbDraweeCallerContext)) {
                    immutableMap = null;
                } else {
                    FbDraweeCallerContext fbDraweeCallerContext = (FbDraweeCallerContext) obj;
                    CallerContext callerContext = fbDraweeCallerContext.f14346b;
                    immutableMap = ImmutableMap.builder().m609b("callerContextClass", callerContext.f5181b).m609b("callerContextTag", callerContext.m9067b()).m609b("analyticsTag", callerContext.m9068c().toString()).m609b("moduleAnalyticsTag", callerContext.m9069d().toString()).m609b("network_type", this.f14416e.m3835k()).m609b("network_subtype", this.f14416e.m3836l()).m609b("ttl_enabled", String.valueOf(fbDraweeCallerContext.f14347c)).m610b();
                }
                b = this.f14412a.mo513a(f14410f, str, immutableMap, this.f14413b.now());
            }
            SequenceLoggerDetour.a(b, "wait_time", null, null, this.f14413b.now(), -2110941646);
            SequenceLoggerDetour.a(b, "good_enough_wait_time", null, null, this.f14413b.now(), -495159972);
            SequenceLoggerDetour.a(b, "preview_wait_time", null, null, this.f14413b.now(), -1338534177);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m20780c(java.lang.String r3) {
        /*
        r2 = this;
        r1 = com.facebook.common.perftest.base.PerfTestConfigBase.f1518m;
        r0 = r1;
        if (r0 != 0) goto L_0x0019;
    L_0x0005:
        r0 = r2.f14415d;
        r0 = r0.m3566c();
        if (r0 == 0) goto L_0x001b;
    L_0x000d:
        r1 = com.facebook.common.util.HashCodeUtil.m20813a(r3);
        r1 = r1 % 10;
        if (r1 != 0) goto L_0x001d;
    L_0x0015:
        r1 = 1;
    L_0x0016:
        r0 = r1;
        if (r0 == 0) goto L_0x001b;
    L_0x0019:
        r0 = 1;
    L_0x001a:
        return r0;
    L_0x001b:
        r0 = 0;
        goto L_0x001a;
    L_0x001d:
        r1 = 0;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.instrumentation.PerfLoggingListener.c(java.lang.String):boolean");
    }

    public final void mo2606a(String str, Throwable th) {
    }

    public final void mo2608b(String str, Throwable th) {
        if (m20780c(str)) {
            Sequence b = this.f14412a.mo517b(f14410f, str);
            if (b != null) {
                SequenceLoggerDetour.c(b, "wait_time", null, null, this.f14413b.now(), -756017364);
                SequenceLoggerDetour.c(b, "good_enough_wait_time", null, null, this.f14413b.now(), 305769883);
                SequenceLoggerDetour.c(b, "preview_wait_time", null, null, this.f14413b.now(), -1926973873);
            }
        }
    }

    public final void mo2604a(String str) {
        if (m20780c(str)) {
            Sequence b = this.f14412a.mo517b(f14410f, str);
            if (b != null) {
                ImmutableMap immutableMap;
                if (PerfTestConfigBase.m2938a()) {
                    immutableMap = null;
                } else {
                    immutableMap = ImmutableBiMap.m978b("cancelled", Boolean.toString(true));
                }
                SequenceLoggerDetour.b(b, "wait_time", null, immutableMap, this.f14413b.now(), 107858497);
                SequenceLoggerDetour.b(b, "good_enough_wait_time", null, immutableMap, this.f14413b.now(), -1141966462);
                SequenceLoggerDetour.b(b, "preview_wait_time", null, immutableMap, this.f14413b.now(), -1144936395);
                this.f14412a.mo521b(f14410f, str, null, this.f14413b.now());
            }
        }
    }
}
