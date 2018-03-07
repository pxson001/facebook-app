package com.facebook.common.perftest;

import android.annotation.TargetApi;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.inject.InjectorLike;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.choreographer.ChoreographerWrapper;
import com.facebook.ui.choreographer.DefaultChoreographerWrapper;
import com.facebook.ui.choreographer.FrameCallbackWrapper;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONArray;
import org.json.JSONObject;

@DoNotStrip
@Singleton
@TargetApi(16)
/* compiled from: psr_cancelled */
public class DrawFrameLogger {
    private static final long[] f4047a = new long[6000];
    private static final long[] f4048b = new long[6000];
    private static final long[] f4049c = new long[6000];
    private static int f4050d;
    private static boolean f4051e;
    private static long f4052f = -1;
    private static volatile DrawFrameLogger f4053l;
    private final PerfTestConfig f4054g;
    public ChoreographerWrapper f4055h;
    public FrameCallbackWrapper f4056i;
    public long f4057j = -1;
    private boolean f4058k = false;

    /* compiled from: psr_cancelled */
    class C01921 extends FrameCallbackWrapper {
        final /* synthetic */ DrawFrameLogger f4059a;

        C01921(DrawFrameLogger drawFrameLogger) {
            this.f4059a = drawFrameLogger;
        }

        public final void m4592a(long j) {
            long j2 = j / 1000000;
            if (this.f4059a.f4057j == -1) {
                this.f4059a.f4057j = j2;
                this.f4059a.f4055h.a(this.f4059a.f4056i);
                return;
            }
            long j3 = j2 - this.f4059a.f4057j;
            this.f4059a.f4057j = j2;
            DrawFrameLogger.m4588b(j2, j3);
            this.f4059a.f4055h.a(this.f4059a.f4056i);
        }
    }

    public static com.facebook.common.perftest.DrawFrameLogger m4585a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4053l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.perftest.DrawFrameLogger.class;
        monitor-enter(r1);
        r0 = f4053l;	 Catch:{ all -> 0x003a }
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
        r0 = m4587b(r0);	 Catch:{ all -> 0x0035 }
        f4053l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4053l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.perftest.DrawFrameLogger.a(com.facebook.inject.InjectorLike):com.facebook.common.perftest.DrawFrameLogger");
    }

    private static DrawFrameLogger m4587b(InjectorLike injectorLike) {
        return new DrawFrameLogger(PerfTestConfig.a(injectorLike), (ChoreographerWrapper) DefaultChoreographerWrapper.a(injectorLike));
    }

    @Inject
    public DrawFrameLogger(PerfTestConfig perfTestConfig, ChoreographerWrapper choreographerWrapper) {
        Preconditions.checkArgument(PerfTestConfigBase.a());
        this.f4054g = perfTestConfig;
        this.f4055h = choreographerWrapper;
        this.f4056i = new C01921(this);
        clearFrameRateLog();
    }

    public final void m4590a() {
        if (!this.f4058k && PerfTestConfigBase.a()) {
            m4586a(true);
            this.f4055h.a(this.f4056i);
        }
    }

    public final void m4591b() {
        if (PerfTestConfigBase.a()) {
            m4586a(false);
            this.f4055h.b(this.f4056i);
        }
    }

    private void m4586a(boolean z) {
        if (z && !this.f4058k) {
            this.f4057j = -1;
        }
        this.f4058k = z;
    }

    public static void m4588b(long j, long j2) {
        TracerDetour.a("BullyDrawFrameLogger.logFrameTime", -680087538);
        try {
            if (f4050d < 6000) {
                f4047a[f4050d] = j;
                f4049c[f4050d] = j2;
                f4048b[f4050d] = System.currentTimeMillis();
                if (f4049c[f4050d] > 34 && !f4051e) {
                    m4589c();
                    f4052f = (System.nanoTime() / 1000000) - j;
                    f4051e = true;
                }
                f4050d++;
                TracerDetour.a(2140380998);
            }
        } finally {
            TracerDetour.a(-1319962434);
        }
    }

    @DoNotStrip
    @VisibleForTesting
    public static JSONObject getFrameRateLogJSON() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("markerLag", f4052f);
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        int i = 0;
        while (i < 6000 && f4047a[i] != 0) {
            jSONArray.put(i, f4047a[i]);
            jSONArray2.put(i, f4048b[i]);
            jSONArray3.put(i, f4049c[i]);
            i++;
        }
        jSONObject.put("frameTimestampBuffer", jSONArray);
        jSONObject.put("frameSystemTimeBuffer", jSONArray2);
        jSONObject.put("frameElapsedMsBuffer", jSONArray3);
        return jSONObject;
    }

    @DoNotStrip
    @VisibleForTesting
    public static void clearFrameRateLog() {
        f4050d = 0;
        for (int i = 0; i < 6000; i++) {
            f4047a[i] = 0;
            f4048b[i] = 0;
            f4049c[i] = 0;
        }
        f4051e = false;
        f4052f = -1;
    }

    private static void m4589c() {
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
        }
    }
}
