package com.facebook.abtest.qe.bootstrap.quicker_experiment;

import android.content.res.Resources;
import com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.api.manager.Authority;
import com.facebook.qe.api.manager.QeManager;
import com.facebook.qe.api.manager.SyncedExperimentData;
import java.util.Collections;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: tr_start_date */
public class QeBootstrapImpl implements QeAccessor, QeManager {
    private static volatile QeBootstrapImpl f1713a;

    public static com.facebook.abtest.qe.bootstrap.quicker_experiment.QeBootstrapImpl m2318a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f1713a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.abtest.qe.bootstrap.quicker_experiment.QeBootstrapImpl.class;
        monitor-enter(r1);
        r0 = f1713a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m2319g();	 Catch:{ all -> 0x0034 }
        f1713a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f1713a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.abtest.qe.bootstrap.quicker_experiment.QeBootstrapImpl.a(com.facebook.inject.InjectorLike):com.facebook.abtest.qe.bootstrap.quicker_experiment.QeBootstrapImpl");
    }

    private static QeBootstrapImpl m2319g() {
        return new QeBootstrapImpl();
    }

    public final void m2335a() {
    }

    public final boolean m2348b(String str) {
        return false;
    }

    public final Iterable<String> m2349c() {
        return Collections.emptyList();
    }

    public final Iterable<String> m2352d() {
        return Collections.emptyList();
    }

    public final Iterable<String> m2355e() {
        return Collections.emptyList();
    }

    public final String m2330a(char c, String str) {
        return str;
    }

    public final String m2329a(char c, int i, Resources resources) {
        return resources.getString(i);
    }

    public final int m2321a(int i, int i2) {
        return i2;
    }

    public final long m2324a(long j, long j2) {
        return j2;
    }

    public final float m2320a(float f, float f2) {
        return f2;
    }

    public final <T extends Enum> T m2327a(double d, Class<T> cls, T t) {
        return t;
    }

    public final boolean m2345a(short s, boolean z) {
        return z;
    }

    public final String m2332a(Liveness liveness, char c, String str) {
        return str;
    }

    public final String m2331a(Liveness liveness, char c, int i, Resources resources) {
        return resources.getString(i);
    }

    public final int m2322a(Liveness liveness, int i, int i2) {
        return i2;
    }

    public final long m2325a(Liveness liveness, long j, long j2) {
        return j2;
    }

    public final boolean m2343a(Liveness liveness, short s, boolean z) {
        return z;
    }

    public final String m2334a(Liveness liveness, ExposureLogging exposureLogging, char c, String str) {
        return str;
    }

    public final String m2333a(Liveness liveness, ExposureLogging exposureLogging, char c, int i, Resources resources) {
        return resources.getString(i);
    }

    public final int m2323a(Liveness liveness, ExposureLogging exposureLogging, int i, int i2) {
        return i2;
    }

    public final long m2326a(Liveness liveness, ExposureLogging exposureLogging, long j, long j2) {
        return j2;
    }

    public final <T extends Enum> T m2328a(Liveness liveness, ExposureLogging exposureLogging, double d, Class<T> cls, T t) {
        return t;
    }

    public final boolean m2342a(Liveness liveness, ExposureLogging exposureLogging, short s, boolean z) {
        return z;
    }

    public final boolean m2344a(Authority authority, String str) {
        return false;
    }

    @Nullable
    public final String m2346b(Authority authority, String str) {
        return null;
    }

    @Nullable
    public final String m2350c(Authority authority, String str) {
        return null;
    }

    @Nullable
    public final Map<String, String> m2353d(Authority authority, String str) {
        return null;
    }

    public final boolean m2351c(String str) {
        return false;
    }

    public final void m2354d(String str) {
    }

    public final void m2356e(String str) {
    }

    public final void m2336a(QuickExperimentInfo quickExperimentInfo) {
    }

    public final void m2340a(String str) {
    }

    public final void m2347b() {
    }

    public final void m2341a(Map<String, SyncedExperimentData> map, boolean z) {
    }

    public final void m2337a(Liveness liveness, char c) {
    }

    public final void m2338a(Liveness liveness, int i) {
    }

    public final void m2339a(Liveness liveness, short s) {
    }

    public final boolean m2357f() {
        return false;
    }
}
