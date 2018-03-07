package com.facebook.analytics.db;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: thread_id_group */
public class AnalyticsSessionManager {
    private static final Class<?> f1174a = AnalyticsSessionManager.class;
    private static volatile AnalyticsSessionManager f1175l;
    public String f1176b;
    @Nullable
    public String f1177c;
    private String f1178d;
    public int f1179e = -1;
    public int f1180f = -1;
    public long f1181g = -1;
    public long f1182h = 0;
    public final AnalyticsPropertyUtil f1183i;
    public final Clock f1184j;
    private final AbstractFbErrorReporter f1185k;

    public static com.facebook.analytics.db.AnalyticsSessionManager m1434a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1175l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.db.AnalyticsSessionManager.class;
        monitor-enter(r1);
        r0 = f1175l;	 Catch:{ all -> 0x003a }
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
        r0 = m1435b(r0);	 Catch:{ all -> 0x0035 }
        f1175l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1175l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.db.AnalyticsSessionManager.a(com.facebook.inject.InjectorLike):com.facebook.analytics.db.AnalyticsSessionManager");
    }

    private static AnalyticsSessionManager m1435b(InjectorLike injectorLike) {
        return new AnalyticsSessionManager(AnalyticsPropertyUtil.m1290b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public AnalyticsSessionManager(AnalyticsPropertyUtil analyticsPropertyUtil, Clock clock, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f1183i = analyticsPropertyUtil;
        this.f1184j = clock;
        this.f1185k = abstractFbErrorReporter;
    }

    public final String m1441a() {
        if (this.f1176b == null) {
            this.f1176b = this.f1183i.m8551a(AnalyticsDbProperties.f1033c);
            if (this.f1176b == null) {
                m1437e();
            }
        }
        return this.f1176b;
    }

    private void m1437e() {
        String uuid = SafeUUIDGenerator.a().toString();
        Preconditions.checkNotNull(uuid);
        this.f1183i.m8558b(AnalyticsDbProperties.f1033c, uuid);
        this.f1176b = uuid;
        m1440h();
    }

    public final String m1444b() {
        if (this.f1177c == null) {
            this.f1177c = this.f1183i.m8551a(AnalyticsDbProperties.f1034d);
        }
        return this.f1177c;
    }

    private String m1438f() {
        if (this.f1178d == null) {
            this.f1178d = this.f1183i.m8551a(AnalyticsDbProperties.f1035e);
        }
        return this.f1178d;
    }

    public final void m1443a(String str) {
        Preconditions.checkNotNull(str);
        if (!str.equals(m1438f())) {
            m1438f();
            this.f1183i.m8558b(AnalyticsDbProperties.f1035e, str);
            this.f1178d = str;
            this.f1183i.m8556b(AnalyticsDbProperties.f1036f, 0);
            this.f1179e = 0;
        }
    }

    public final int m1445c() {
        if (this.f1179e == -1) {
            this.f1179e = this.f1183i.m8549a(AnalyticsDbProperties.f1036f, 0);
        }
        return this.f1179e;
    }

    private long m1439g() {
        if (this.f1181g == -1) {
            this.f1181g = this.f1183i.m8550a(AnalyticsDbProperties.f1032b, 0);
        }
        return this.f1181g;
    }

    public final void m1442a(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        if (m1436b(honeyAnalyticsEvent)) {
            m1437e();
        }
        long j = honeyAnalyticsEvent.e;
        this.f1181g = j;
        if (this.f1184j.a() - this.f1182h > 30000) {
            this.f1183i.m8557b(AnalyticsDbProperties.f1032b, j);
            this.f1182h = this.f1184j.a();
        }
    }

    private boolean m1436b(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        if (m1439g() > 0 && this.f1184j.a() - m1439g() > 3600000) {
            return true;
        }
        if (!Objects.equal(honeyAnalyticsEvent.f, m1444b())) {
            String str = honeyAnalyticsEvent.f;
            if (!Objects.equal(str, this.f1177c)) {
                this.f1183i.m8558b(AnalyticsDbProperties.f1034d, str);
                this.f1177c = str;
            }
            return true;
        } else if (honeyAnalyticsEvent.b("new_session")) {
            if (!BLog.b(2)) {
                return true;
            }
            honeyAnalyticsEvent.d();
            return true;
        } else if (!honeyAnalyticsEvent.b("session_timeout")) {
            return false;
        } else {
            if (!BLog.b(2)) {
                return true;
            }
            honeyAnalyticsEvent.d();
            return true;
        }
    }

    private synchronized void m1440h() {
        this.f1185k.c("marauder_session_id", m1441a());
    }
}
