package com.facebook.feed.analytics;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.analytics.MultiRowPerfLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.proguard.annotations.DoNotStrip;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONArray;
import org.json.JSONObject;

@Singleton
@NotThreadSafe
/* compiled from: video_send_start_bitrate_kbps */
public class MultiRowPerfLoggerForTesting implements MultiRowPerfLogger {
    private static int[] f236a = new int[8];
    private static long[] f237b = new long[8];
    private static int f238c = 0;
    private static volatile MultiRowPerfLoggerForTesting f239f;
    private final long[] f240d = new long[8];
    private MonotonicClock f241e;

    public static com.facebook.feed.analytics.MultiRowPerfLoggerForTesting m268a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f239f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.analytics.MultiRowPerfLoggerForTesting.class;
        monitor-enter(r1);
        r0 = f239f;	 Catch:{ all -> 0x003a }
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
        r0 = m269b(r0);	 Catch:{ all -> 0x0035 }
        f239f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f239f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.analytics.MultiRowPerfLoggerForTesting.a(com.facebook.inject.InjectorLike):com.facebook.feed.analytics.MultiRowPerfLoggerForTesting");
    }

    private static MultiRowPerfLoggerForTesting m269b(InjectorLike injectorLike) {
        return new MultiRowPerfLoggerForTesting((MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MultiRowPerfLoggerForTesting(MonotonicClock monotonicClock) {
        this.f241e = monotonicClock;
    }

    public final void m273a(MultiRowPartWithIsNeeded multiRowPartWithIsNeeded, int i) {
        boolean z = i < 8 && i >= 0;
        Preconditions.checkArgument(z);
        int[] iArr = f236a;
        iArr[i] = iArr[i] + 1;
        this.f240d[i] = this.f241e.now();
    }

    public final void m270a(int i) {
        boolean z = i < 8 && i >= 0;
        Preconditions.checkArgument(z);
        long[] jArr = f237b;
        jArr[i] = jArr[i] + (this.f241e.now() - this.f240d[i]);
        this.f240d[i] = Long.MAX_VALUE;
    }

    public final void m271a(int i, AnyEnvironment anyEnvironment) {
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        if ((anyEnvironment instanceof HasIsAsync) && ((HasIsAsync) anyEnvironment).hM_()) {
            f238c++;
        }
    }

    public final void m272a(int i, Callable<List<String>> callable) {
    }

    @DoNotStrip
    @VisibleForTesting
    public static JSONObject getMultiRowPerfLoggerStats() {
        int i = 0;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (int put : f236a) {
            jSONArray.put(put);
        }
        while (i < f237b.length) {
            jSONArray2.put(f237b[i]);
            i++;
        }
        jSONObject.put("markerIdCount", jSONArray);
        jSONObject.put("asyncSinglePrepareCount", f238c);
        jSONObject.put("totalTimes", jSONArray2);
        return jSONObject;
    }

    @DoNotStrip
    @VisibleForTesting
    public static void resetMultiRowPerfLoggerStats() {
        f236a = new int[8];
        f238c = 0;
        f237b = new long[8];
    }
}
