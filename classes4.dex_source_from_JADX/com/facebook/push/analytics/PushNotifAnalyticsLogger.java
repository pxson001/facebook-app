package com.facebook.push.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.ReliabilityAnalyticsClientEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.push.registration.Registrar.TokenStatus;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: indexed_data */
public class PushNotifAnalyticsLogger {
    private static final Class<?> f10350a = PushNotifAnalyticsLogger.class;
    private static volatile PushNotifAnalyticsLogger f10351c;
    private final AnalyticsLogger f10352b;

    public static com.facebook.push.analytics.PushNotifAnalyticsLogger m10876a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10351c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.analytics.PushNotifAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f10351c;	 Catch:{ all -> 0x003a }
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
        r0 = m10878b(r0);	 Catch:{ all -> 0x0035 }
        f10351c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10351c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.analytics.PushNotifAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.push.analytics.PushNotifAnalyticsLogger");
    }

    private static PushNotifAnalyticsLogger m10878b(InjectorLike injectorLike) {
        return new PushNotifAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PushNotifAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f10352b = analyticsLogger;
    }

    @Deprecated
    public final void m10884a(String str, String str2, Map<String, String> map) {
        m10877a(ReliabilityAnalyticsClientEvent.m11015a("push_reg_gcm_initial_status", str.toLowerCase(Locale.US), map, "registration_id", str2));
    }

    @Deprecated
    public final void m10879a(String str, String str2) {
        m10877a(ReliabilityAnalyticsClientEvent.m11015a("push_unreg_c2dm", str, null, "registration_id", str2));
    }

    public final void m10880a(String str, String str2, String str3) {
        if (!TokenStatus.CURRENT.name().equals(str2)) {
            Map c = Maps.c();
            c.put("push_source", str.toLowerCase(Locale.US));
            m10877a(ReliabilityAnalyticsClientEvent.m11015a("push_reg_initial_status", str2.toLowerCase(Locale.US), c, "registration_id", str3));
        }
    }

    public final void m10886b(String str, String str2, String str3) {
        Map c = Maps.c();
        c.put("service_type", str);
        c.put("action", Strings.nullToEmpty(str3));
        m10877a(ReliabilityAnalyticsClientEvent.m11015a("push_reg_status", str2, c, null, null));
    }

    public final void m10882a(String str, String str2, String str3, String str4, @Nullable String str5) {
        Map c = Maps.c();
        c.put("backoff", str4);
        c.put("service_type", str);
        if (str5 != null) {
            c.put("reason", str5);
        }
        m10877a(ReliabilityAnalyticsClientEvent.m11015a("push_reg_status", str2, c, "registration_id", str3));
    }

    public final void m10881a(String str, String str2, String str3, String str4) {
        Map c = Maps.c();
        c.put("push_source", str.toLowerCase(Locale.US));
        if (str4 != null) {
            c.put("reason", str4);
        }
        m10877a(ReliabilityAnalyticsClientEvent.m11015a("push_unreg_status", str2, c, "registration_id", str3));
    }

    public final void m10883a(String str, String str2, String str3, boolean z) {
        Map c = Maps.c();
        c.put("service_type", str3);
        if (z) {
            c.put("pre_log", "true");
        }
        m10877a(ReliabilityAnalyticsClientEvent.m11015a("push_reg_server_initial_status", str.toLowerCase(Locale.US), null, "registration_id", str2));
    }

    public final void m10887b(String str, String str2, String str3, boolean z) {
        Map c = Maps.c();
        c.put("service_type", str3);
        if (z) {
            c.put("pre_log", "true");
        }
        m10877a(ReliabilityAnalyticsClientEvent.m11015a("push_reg_server", str.toLowerCase(Locale.US), c, "registration_id", str2));
    }

    public final void m10885b(String str, String str2) {
        m10877a(ReliabilityAnalyticsClientEvent.m11015a("push_unreg_server", str.toLowerCase(Locale.US), null, "registration_id", str2));
    }

    public final void m10888c(String str, String str2, String str3) {
        Map c = Maps.c();
        c.put("detection", str3);
        c.put("rm_pkg", str);
        m10877a(ReliabilityAnalyticsClientEvent.m11015a("push_messenger_fbns_unreg", str2.toLowerCase(Locale.US), c, null, null));
    }

    private void m10877a(HoneyClientEvent honeyClientEvent) {
        if (BLog.b(2)) {
            String str = honeyClientEvent.d;
            str = honeyClientEvent.e;
            honeyClientEvent.u();
        }
        this.f10352b.c(honeyClientEvent);
    }
}
