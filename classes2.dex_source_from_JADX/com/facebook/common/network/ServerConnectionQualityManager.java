package com.facebook.common.network;

import com.facebook.common.moving_average.MovingAverage;
import com.facebook.common.moving_average.NaiveExponentialWeightedAverage;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.http.observer.ConnectionQualityTraceLogger;
import com.facebook.http.observer.DataConnectionXConfig;
import com.facebook.inject.InjectorLike;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.HttpResponse;

@Singleton
/* compiled from: unregistered_reason */
public class ServerConnectionQualityManager {
    private static Pattern f2012h = Pattern.compile("(EXCELLENT|GOOD|MODERATE|POOR|UNKNOWN); q=(1|0|0.\\d), rtt=(\\d+)");
    private static volatile ServerConnectionQualityManager f2013l;
    public final XConfigReader f2014a;
    private final ConnectionQualityTraceLogger f2015b;
    private boolean f2016c = false;
    private int f2017d;
    private List<ServerConnectionQualityManagerStateChangeListener> f2018e = Lists.m1296a();
    private AtomicReference<ConnectionQuality> f2019f = new AtomicReference(ConnectionQuality.UNKNOWN);
    private AtomicReference<ConnectionQuality> f2020g;
    public double[] f2021i = new double[5];
    private volatile double f2022j = -1.0d;
    public MovingAverage f2023k;

    /* compiled from: unregistered_reason */
    public interface ServerConnectionQualityManagerStateChangeListener {
        void mo558b(ConnectionQuality connectionQuality);
    }

    public static com.facebook.common.network.ServerConnectionQualityManager m4095a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2013l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.network.ServerConnectionQualityManager.class;
        monitor-enter(r1);
        r0 = f2013l;	 Catch:{ all -> 0x003a }
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
        r0 = m4097b(r0);	 Catch:{ all -> 0x0035 }
        f2013l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2013l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.network.ServerConnectionQualityManager.a(com.facebook.inject.InjectorLike):com.facebook.common.network.ServerConnectionQualityManager");
    }

    private static ServerConnectionQualityManager m4097b(InjectorLike injectorLike) {
        return new ServerConnectionQualityManager(XConfigReader.m2681a(injectorLike), ConnectionQualityTraceLogger.m4087a(injectorLike));
    }

    @Inject
    public ServerConnectionQualityManager(XConfigReader xConfigReader, ConnectionQualityTraceLogger connectionQualityTraceLogger) {
        this.f2014a = xConfigReader;
        this.f2015b = connectionQualityTraceLogger;
    }

    private synchronized void m4096a(double d) {
        this.f2015b.m4091a(d);
        if (this.f2023k == null) {
            this.f2023k = new NaiveExponentialWeightedAverage(m4100e());
        }
        this.f2023k.mo2838a(d);
        if (this.f2016c) {
            this.f2017d++;
            if (m4099d() != this.f2020g.get()) {
                this.f2016c = false;
                this.f2017d = 1;
            }
            if (this.f2017d >= m4103i()) {
                this.f2016c = false;
                this.f2017d = 1;
                this.f2019f.set(this.f2020g.get());
                m4098c();
            }
        } else if (this.f2019f.get() != m4099d()) {
            this.f2016c = true;
            this.f2020g = new AtomicReference(m4099d());
        }
    }

    public final synchronized void m4106a(HttpResponse httpResponse) {
        if (httpResponse.containsHeader("X-FB-Connection-Quality")) {
            Matcher matcher = f2012h.matcher(httpResponse.getFirstHeader("X-FB-Connection-Quality").getValue());
            if (matcher.find()) {
                double parseDouble = Double.parseDouble(matcher.group(3));
                if (parseDouble > 1.0d) {
                    this.f2022j = Double.parseDouble(matcher.group(2));
                    m4096a(parseDouble);
                }
            }
        }
    }

    public final synchronized void m4105a() {
        if (this.f2023k != null) {
            this.f2023k.mo2839b();
        }
        this.f2019f.set(ConnectionQuality.UNKNOWN);
    }

    public final ConnectionQuality m4104a(ServerConnectionQualityManagerStateChangeListener serverConnectionQualityManagerStateChangeListener) {
        this.f2018e.add(serverConnectionQualityManagerStateChangeListener);
        return (ConnectionQuality) this.f2019f.get();
    }

    private void m4098c() {
        for (ServerConnectionQualityManagerStateChangeListener b : this.f2018e) {
            b.mo558b((ConnectionQuality) this.f2019f.get());
        }
    }

    private ConnectionQuality m4099d() {
        if (this.f2023k == null) {
            return ConnectionQuality.UNKNOWN;
        }
        double a = this.f2023k.mo2837a();
        if (this.f2021i[0] == 0.0d) {
            this.f2021i[0] = (double) this.f2014a.m2684a(DataConnectionXConfig.f15131m, 1000);
        }
        if (a > this.f2021i[0]) {
            return ConnectionQuality.POOR;
        }
        if (this.f2023k.mo2837a() > m4101g()) {
            return ConnectionQuality.MODERATE;
        }
        if (this.f2023k.mo2837a() > m4102h()) {
            return ConnectionQuality.GOOD;
        }
        if (this.f2023k.mo2837a() > 0.0d) {
            return ConnectionQuality.EXCELLENT;
        }
        return ConnectionQuality.UNKNOWN;
    }

    private double m4100e() {
        if (this.f2021i[3] == 0.0d) {
            this.f2021i[3] = 0.01d * ((double) this.f2014a.m2684a(DataConnectionXConfig.f15127i, 0));
        }
        return this.f2021i[3];
    }

    private double m4101g() {
        if (this.f2021i[1] == 0.0d) {
            this.f2021i[1] = (double) this.f2014a.m2684a(DataConnectionXConfig.f15132n, 500);
        }
        return this.f2021i[1];
    }

    private double m4102h() {
        if (this.f2021i[2] == 0.0d) {
            this.f2021i[2] = (double) this.f2014a.m2684a(DataConnectionXConfig.f15133o, 250);
        }
        return this.f2021i[2];
    }

    private int m4103i() {
        if (this.f2021i[4] == 0.0d) {
            this.f2021i[4] = (double) this.f2014a.m2684a(DataConnectionXConfig.f15125g, 15);
        }
        return (int) this.f2021i[4];
    }
}
