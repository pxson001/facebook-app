package com.facebook.http.observer;

import com.facebook.common.moving_average.ExponentialGeometricAverage;
import com.facebook.common.moving_average.MovingAverage;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: unregister_push */
public class DownloadBandwidthManager {
    private static volatile DownloadBandwidthManager f1996j;
    private final XConfigReader f1997a;
    private final ConnectionQualityTraceLogger f1998b;
    @Nullable
    public MovingAverage f1999c;
    private volatile boolean f2000d = false;
    public AtomicReference<ConnectionQuality> f2001e = new AtomicReference(ConnectionQuality.UNKNOWN);
    private AtomicReference<ConnectionQuality> f2002f;
    private List<DownloadBandwidthManagerStateChangeListener> f2003g = Lists.m1296a();
    private int f2004h;
    private final double[] f2005i = new double[7];

    /* compiled from: unregister_push */
    public interface DownloadBandwidthManagerStateChangeListener {
        void mo557a(ConnectionQuality connectionQuality);
    }

    public static com.facebook.http.observer.DownloadBandwidthManager m4071a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1996j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.observer.DownloadBandwidthManager.class;
        monitor-enter(r1);
        r0 = f1996j;	 Catch:{ all -> 0x003a }
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
        r0 = m4072b(r0);	 Catch:{ all -> 0x0035 }
        f1996j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1996j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.observer.DownloadBandwidthManager.a(com.facebook.inject.InjectorLike):com.facebook.http.observer.DownloadBandwidthManager");
    }

    private static DownloadBandwidthManager m4072b(InjectorLike injectorLike) {
        return new DownloadBandwidthManager(XConfigReader.m2681a(injectorLike), ConnectionQualityTraceLogger.m4087a(injectorLike));
    }

    @Inject
    public DownloadBandwidthManager(XConfigReader xConfigReader, ConnectionQualityTraceLogger connectionQualityTraceLogger) {
        this.f1997a = xConfigReader;
        this.f1998b = connectionQualityTraceLogger;
    }

    public final synchronized void m4085a(long j, long j2) {
        this.f1998b.m4093a(j, j2);
        double d = ((((double) j) * 1.0d) / ((double) j2)) * 8.0d;
        if (this.f1999c == null) {
            this.f1999c = new ExponentialGeometricAverage(m4076f());
        }
        this.f1999c.mo2838a(d);
        if (this.f2000d) {
            this.f2004h++;
            if (m4074d() != this.f2002f.get()) {
                this.f2000d = false;
                this.f2004h = 1;
            }
            if (this.f2004h >= m4080j() && m4073c()) {
                this.f2000d = false;
                this.f2004h = 1;
                this.f2001e.set(this.f2002f.get());
                m4075e();
            }
        } else if (this.f2001e.get() != m4074d()) {
            this.f2000d = true;
            this.f2002f = new AtomicReference(m4074d());
        }
    }

    private boolean m4073c() {
        if (this.f1999c == null) {
            return false;
        }
        double d;
        double g;
        switch (1.a[((ConnectionQuality) this.f2001e.get()).ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                d = 0.0d;
                g = m4077g();
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                d = m4077g();
                g = m4078h();
                break;
            case 3:
                d = m4078h();
                g = m4079i();
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                d = m4079i();
                g = 3.4028234663852886E38d;
                break;
            default:
                return true;
        }
        double a = this.f1999c.mo2837a();
        if (a > g) {
            if (a > g * m4081k()) {
                return true;
            }
        } else if (a < m4082l() * d) {
            return true;
        }
        return false;
    }

    private synchronized ConnectionQuality m4074d() {
        ConnectionQuality connectionQuality;
        if (this.f1999c == null) {
            connectionQuality = ConnectionQuality.UNKNOWN;
        } else {
            connectionQuality = m4070a(this.f1999c.mo2837a());
        }
        return connectionQuality;
    }

    private ConnectionQuality m4070a(double d) {
        if (d < 0.0d) {
            return ConnectionQuality.UNKNOWN;
        }
        if (d < m4077g()) {
            return ConnectionQuality.POOR;
        }
        if (d < m4078h()) {
            return ConnectionQuality.MODERATE;
        }
        if (d < m4079i()) {
            return ConnectionQuality.GOOD;
        }
        return ConnectionQuality.EXCELLENT;
    }

    public final synchronized double m4086b() {
        return this.f1999c == null ? -1.0d : this.f1999c.mo2837a();
    }

    public final ConnectionQuality m4084a(DownloadBandwidthManagerStateChangeListener downloadBandwidthManagerStateChangeListener) {
        this.f2003g.add(downloadBandwidthManagerStateChangeListener);
        return (ConnectionQuality) this.f2001e.get();
    }

    private void m4075e() {
        for (DownloadBandwidthManagerStateChangeListener a : this.f2003g) {
            a.mo557a((ConnectionQuality) this.f2001e.get());
        }
    }

    private double m4076f() {
        if (this.f2005i[3] == 0.0d) {
            this.f2005i[3] = 0.01d * ((double) this.f1997a.m2684a(DataConnectionXConfig.f15126h, 0));
        }
        return this.f2005i[3];
    }

    private double m4077g() {
        if (this.f2005i[0] == 0.0d) {
            this.f2005i[0] = (double) this.f1997a.m2684a(DataConnectionXConfig.f15128j, 150);
        }
        return this.f2005i[0];
    }

    private double m4078h() {
        if (this.f2005i[1] == 0.0d) {
            this.f2005i[1] = (double) this.f1997a.m2684a(DataConnectionXConfig.f15129k, 550);
        }
        return this.f2005i[1];
    }

    private double m4079i() {
        if (this.f2005i[2] == 0.0d) {
            this.f2005i[2] = (double) this.f1997a.m2684a(DataConnectionXConfig.f15130l, 2000);
        }
        return this.f2005i[2];
    }

    private int m4080j() {
        if (this.f2005i[4] == 0.0d) {
            this.f2005i[4] = (double) this.f1997a.m2684a(DataConnectionXConfig.f15124f, 5);
        }
        return (int) this.f2005i[4];
    }

    private double m4081k() {
        if (this.f2005i[5] == 0.0d) {
            this.f2005i[5] = 100.0d / (100.0d - ((double) m4083m()));
        }
        return this.f2005i[5];
    }

    private double m4082l() {
        if (this.f2005i[6] == 0.0d) {
            this.f2005i[6] = (100.0d - ((double) m4083m())) / 100.0d;
        }
        return this.f2005i[6];
    }

    private long m4083m() {
        long a = this.f1997a.m2684a(DataConnectionXConfig.f15134p, 20);
        if (a < 0) {
            return 0;
        }
        if (a > 99) {
            return 99;
        }
        return a;
    }
}
