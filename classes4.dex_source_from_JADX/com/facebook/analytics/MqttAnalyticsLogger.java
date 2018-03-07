package com.facebook.analytics;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.util.LoggerMapUtils;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Strings;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mSyncOlderPhotos */
public class MqttAnalyticsLogger {
    private static final Class<?> f8542a = MqttAnalyticsLogger.class;
    private static volatile MqttAnalyticsLogger f8543j;
    public final AnalyticsLogger f8544b;
    public final FbNetworkManager f8545c;
    public final AppStateManager f8546d;
    private final LoggerMapUtils f8547e;
    private volatile boolean f8548f = true;
    private long f8549g = 0;
    private String f8550h = "";
    private long f8551i = 0;

    public static com.facebook.analytics.MqttAnalyticsLogger m8797a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8543j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.MqttAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f8543j;	 Catch:{ all -> 0x003a }
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
        r0 = m8799b(r0);	 Catch:{ all -> 0x0035 }
        f8543j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8543j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.MqttAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.analytics.MqttAnalyticsLogger");
    }

    private static MqttAnalyticsLogger m8799b(InjectorLike injectorLike) {
        return new MqttAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), FbNetworkManager.a(injectorLike), AppStateManager.a(injectorLike), LoggerMapUtils.m8803b(injectorLike));
    }

    @Inject
    public MqttAnalyticsLogger(AnalyticsLogger analyticsLogger, FbNetworkManager fbNetworkManager, AppStateManager appStateManager, LoggerMapUtils loggerMapUtils) {
        this.f8544b = analyticsLogger;
        this.f8545c = fbNetworkManager;
        this.f8546d = appStateManager;
        this.f8547e = loggerMapUtils;
    }

    public final void m8800a(String str, long j) {
        this.f8550h = str;
        this.f8549g = j;
        this.f8551i++;
    }

    public final void m8801a(boolean z, @Nullable String str) {
        Map a = LoggerMapUtils.m8802a("enabled", String.valueOf(z), "reason", Strings.nullToEmpty(str));
        a.put("network_session_id", Long.toString(this.f8545c.p));
        m8798a("mqtt_service_state", a);
    }

    private void m8798a(String str, @Nullable Map<String, String> map) {
        String str2;
        if (map != null) {
            this.f8547e.m8805a((Map) map);
        }
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(StringLocaleUtil.a(str));
        honeyClientEvent.c = "mqtt_client";
        HoneyClientEvent a = honeyClientEvent.a(map).b("service_name", "MQTT").a("inet_session_id", this.f8545c.o).a("app_session_id", this.f8546d.J);
        String str3 = "app_bg";
        if (this.f8546d.j()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        honeyClientEvent = a.b(str3, str2);
        honeyClientEvent.u();
        this.f8544b.a(honeyClientEvent);
    }
}
