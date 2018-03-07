package com.facebook.device;

import android.annotation.SuppressLint;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.DeadObjectException;
import android.os.Process;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.device.QTagUidStatsParser.QTagUidStatsParserException;
import com.facebook.device.resourcemonitor.DataUsageBytes;
import com.facebook.inject.InjectorLike;
import com.google.common.annotations.VisibleForTesting;
import java.lang.reflect.Method;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: setContentView(%s) */
public class FbTrafficStats {
    private static volatile FbTrafficStats f5365d;
    public final boolean f5366a;
    private TriState f5367b;
    private TriState f5368c;

    public static com.facebook.device.FbTrafficStats m9228a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5365d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.device.FbTrafficStats.class;
        monitor-enter(r1);
        r0 = f5365d;	 Catch:{ all -> 0x003a }
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
        r0 = m9233b(r0);	 Catch:{ all -> 0x0035 }
        f5365d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5365d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device.FbTrafficStats.a(com.facebook.inject.InjectorLike):com.facebook.device.FbTrafficStats");
    }

    private static FbTrafficStats m9233b(InjectorLike injectorLike) {
        return new FbTrafficStats((AbstractFbErrorReporter) FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public FbTrafficStats(AbstractFbErrorReporter abstractFbErrorReporter) {
        this(m9231a(abstractFbErrorReporter));
    }

    @VisibleForTesting
    private FbTrafficStats(boolean z) {
        this.f5367b = TriState.UNSET;
        this.f5368c = TriState.UNSET;
        this.f5366a = z;
    }

    @SuppressLint({"RethrownThrowableArgument"})
    private static void m9230a(RuntimeException runtimeException) {
        if (runtimeException.getCause() instanceof DeadObjectException) {
            BLog.a("FbTrafficStats", runtimeException, "netstats connection lost", new Object[0]);
            return;
        }
        throw runtimeException;
    }

    public final DataUsageBytes m9239a(int i, int i2) {
        if (m9238f()) {
            try {
                return QTagUidStatsParser.m9243a(i, i2);
            } catch (QTagUidStatsParserException e) {
                return new DataUsageBytes(0, 0);
            }
        }
        try {
            return new DataUsageBytes(TrafficStats.getUidRxBytes(i), TrafficStats.getUidTxBytes(i));
        } catch (RuntimeException e2) {
            m9230a(e2);
            return new DataUsageBytes(0, 0);
        }
    }

    public final DataUsageBytes m9240b(int i, int i2) {
        if (m9238f()) {
            try {
                return QTagUidStatsParser.m9244a(i, i2, 1);
            } catch (QTagUidStatsParserException e) {
                BLog.b("FbTrafficStats", "Unable to parse data usage from system file", e);
            }
        }
        return DataUsageBytes.f5369a;
    }

    public final DataUsageBytes m9241c(int i, int i2) {
        if (m9238f()) {
            try {
                return QTagUidStatsParser.m9244a(i, i2, 0);
            } catch (QTagUidStatsParserException e) {
                BLog.b("FbTrafficStats", "Unable to parse data usage from system file", e);
            }
        }
        return DataUsageBytes.f5369a;
    }

    public static long m9232b() {
        try {
            return TrafficStats.getTotalRxBytes();
        } catch (RuntimeException e) {
            m9230a(e);
            return 0;
        }
    }

    public static long m9235c() {
        try {
            return TrafficStats.getTotalTxBytes();
        } catch (RuntimeException e) {
            m9230a(e);
            return 0;
        }
    }

    public static long m9236d() {
        try {
            return TrafficStats.getMobileRxBytes();
        } catch (RuntimeException e) {
            m9230a(e);
            return 0;
        }
    }

    public static long m9237e() {
        try {
            return TrafficStats.getMobileTxBytes();
        } catch (RuntimeException e) {
            m9230a(e);
            return 0;
        }
    }

    private boolean m9238f() {
        if (this.f5368c == TriState.UNSET) {
            this.f5368c = QTagUidStatsParser.m9247a() ? TriState.YES : TriState.NO;
        }
        return this.f5368c == TriState.YES;
    }

    private static boolean m9231a(AbstractFbErrorReporter abstractFbErrorReporter) {
        try {
            if (!m9234b(abstractFbErrorReporter) || TrafficStats.getTotalRxBytes() == -1 || TrafficStats.getTotalTxBytes() == -1 || TrafficStats.getMobileRxBytes() == -1 || TrafficStats.getMobileTxBytes() == -1) {
                return false;
            }
            int myUid = Process.myUid();
            if (TrafficStats.getUidRxBytes(myUid) == -1 || TrafficStats.getUidTxBytes(myUid) == -1) {
                return false;
            }
            return true;
        } catch (RuntimeException e) {
            m9230a(e);
            return false;
        }
    }

    private static boolean m9234b(AbstractFbErrorReporter abstractFbErrorReporter) {
        try {
            if (VERSION.SDK_INT < 16) {
                return true;
            }
            Method a = m9229a(abstractFbErrorReporter, TrafficStats.class, "getStatsService");
            if (a == null) {
                return true;
            }
            Object invoke = a.invoke(null, new Object[0]);
            if (invoke == null) {
                return false;
            }
            Method a2 = m9229a(abstractFbErrorReporter, invoke.getClass(), "getMobileIfaces");
            if (a2 == null) {
                return true;
            }
            String[] strArr = (String[]) a2.invoke(invoke, new Object[0]);
            return (strArr == null || Arrays.asList(strArr).contains(null)) ? false : true;
        } catch (Throwable th) {
            abstractFbErrorReporter.m2340a("FbTrafficStats_exception_" + th.getClass().getSimpleName(), "Exception in trustTrafficStatsToNotCrash.");
            return false;
        }
    }

    @Nullable
    private static Method m9229a(AbstractFbErrorReporter abstractFbErrorReporter, Class cls, String str) {
        Method declaredMethod;
        try {
            declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
        } catch (NoSuchMethodException e) {
            declaredMethod = null;
        }
        if (declaredMethod == null) {
            abstractFbErrorReporter.m2340a("FbTrafficStats_missingMethod_" + str, "Method not found.");
            return null;
        }
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
