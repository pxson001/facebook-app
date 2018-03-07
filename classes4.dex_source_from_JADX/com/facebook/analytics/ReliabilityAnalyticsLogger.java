package com.facebook.analytics;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.util.LoggerMapUtils;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Joiner;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: fetchPinnedThreadsParams */
public class ReliabilityAnalyticsLogger {
    private static volatile ReliabilityAnalyticsLogger f11741d;
    private final Provider<Boolean> f11742a;
    private final LoggerMapUtils f11743b;
    private final AnalyticsLogger f11744c;

    public static com.facebook.analytics.ReliabilityAnalyticsLogger m12278a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11741d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.ReliabilityAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f11741d;	 Catch:{ all -> 0x003a }
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
        r0 = m12279b(r0);	 Catch:{ all -> 0x0035 }
        f11741d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11741d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.ReliabilityAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.analytics.ReliabilityAnalyticsLogger");
    }

    private static ReliabilityAnalyticsLogger m12279b(InjectorLike injectorLike) {
        return new ReliabilityAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3884), LoggerMapUtils.m8803b(injectorLike));
    }

    @Inject
    public ReliabilityAnalyticsLogger(AnalyticsLogger analyticsLogger, Provider<Boolean> provider, LoggerMapUtils loggerMapUtils) {
        this.f11744c = analyticsLogger;
        this.f11742a = provider;
        this.f11743b = loggerMapUtils;
    }

    public final void m12290a(String str, @Nullable String str2, @Nullable Map<String, String> map, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        if (((Boolean) this.f11742a.get()).booleanValue()) {
            m12294b(str, str2, map, str3, str4, str5);
            return;
        }
        this.f11744c.a(m12280c(str, str2, map, str3, str4, str5));
    }

    public final void m12289a(String str, @Nullable String str2, String str3, @Nullable Map<String, String> map, @Nullable String str4, @Nullable String str5) {
        Map a = this.f11743b.m8804a(map, new String[0]);
        if (str2 != null) {
            a.put("push_id", str2);
        }
        m12290a("messaging_push_notif_" + str, str3, a, str4, str5, null);
    }

    public final void m12288a(String str, String str2, String str3, String str4) {
        Map a = LoggerMapUtils.m8802a("type", str3);
        if (str2 != null) {
            a.put("push_id", str2);
        }
        m12290a("messaging_push_notif_" + str, str4, a, null, null, null);
    }

    public final void m12293b(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        Map a = LoggerMapUtils.m8802a("source", str2);
        if (str != null) {
            a.put("message_id", str);
        }
        if (str3 != null) {
            a.put("push_id", str3);
        }
        if (str4 != null) {
            a.put("type", str4);
        }
        m12290a("messaging_push_notif", "add_to_tray", a, null, null, null);
    }

    public final void m12285a(String str, String str2, Exception exception) {
        m12290a("messaging_push_notif", "parse_exception", LoggerMapUtils.m8802a("source", str, "push_id", str2, "exception", exception.toString()), null, null, null);
    }

    public final void m12291a(Map<String, String> map) {
        m12290a("gcm_empty_push_notification", null, (Map) map, null, null, null);
    }

    public final void m12284a(String str, String str2, int i, @Nullable String str3) {
        String str4 = "messaging_push_notif_" + str;
        Map a = LoggerMapUtils.m8802a("push_id", str2, "notif_time", String.valueOf(i));
        if (str3 != null) {
            a.put("push_extra", str3);
        }
        m12290a(str4, "ignore_duplicate", a, null, null, null);
    }

    public final void m12287a(String str, String str2, String str3, Exception exception) {
        m12290a("messaging_push_notif", "handler_exception", LoggerMapUtils.m8802a("source", str2, "push_id", str3, "handler", str, "exception", exception.toString()), null, null, null);
    }

    public final void m12286a(String str, String str2, String str3, int i, @Nullable String str4) {
        Map a = LoggerMapUtils.m8802a("push_id", str2, "source", str, "type", str3, "notif_time", String.valueOf(i));
        if (str4 != null) {
            a.put("push_extra", str4);
        }
        m12290a("messaging_push_notif", "received", a, null, null, null);
    }

    public final void m12292b(String str, String str2, String str3, int i, @Nullable String str4) {
        Map a = LoggerMapUtils.m8802a("push_id", str3, "source", str, "expected_source", str2, "notif_time", String.valueOf(i));
        if (str4 != null) {
            a.put("push_extra", str4);
        }
        m12290a("wrong_channel", "wrong_channel", a, null, null, null);
    }

    public final void m12282a(@Nullable String str, long j, @Nullable List<String> list, int i, long j2, List<Long> list2) {
        Map a = LoggerMapUtils.m8802a(new String[0]);
        if (str != null) {
            a.put("source", str);
        }
        a.put("watermark_timestamp", Long.toString(j));
        if (!(list == null || list.isEmpty())) {
            a.put("message_id", Joiner.on(",").join(list));
        }
        a.put("message_count", Integer.toString(i));
        a.put("batch_id", Long.toString(j2));
        if (!list2.isEmpty()) {
            a.put("failed_batch_ids", Joiner.on(",").join(list2));
        }
        m12290a("delivery_receipt_new_send_failure", null, a, null, null, null);
    }

    public final void m12283a(@Nullable String str, long j, @Nullable List<String> list, int i, long j2, List<Long> list2, int i2) {
        Map a = LoggerMapUtils.m8802a(new String[0]);
        if (str != null) {
            a.put("source", str);
        }
        a.put("watermark_timestamp", Long.toString(j));
        if (!(list == null || list.isEmpty())) {
            a.put("message_id", Joiner.on(",").join(list));
        }
        a.put("message_count", Integer.toString(i));
        a.put("batch_id", Long.toString(j2));
        if (!list2.isEmpty()) {
            a.put("failed_batch_ids", Joiner.on(",").join(list2));
        }
        if (i2 > 0) {
            a.put("failed_count", Integer.toString(i2));
        }
        m12290a("delivery_receipt_new_send_success", null, a, null, null, null);
    }

    public final void m12281a(@Nullable String str, long j, int i, long j2, @Nullable List<String> list, List<Long> list2, int i2) {
        Map a = LoggerMapUtils.m8802a(new String[0]);
        if (str != null) {
            a.put("source", str);
        }
        a.put("watermark_timestamp", Long.toString(j));
        a.put("message_count", Integer.toString(i));
        a.put("batch_id", Long.toString(j2));
        if (!(list == null || list.isEmpty())) {
            a.put("message_id", Joiner.on(",").join(list));
        }
        if (!list2.isEmpty()) {
            a.put("failed_batch_ids", Joiner.on(",").join(list2));
        }
        if (i2 > 0) {
            a.put("failed_count", Integer.toString(i2));
        }
        m12290a("delivery_receipt_new_send_attempt", null, a, null, null, null);
    }

    public final void m12294b(String str, @Nullable String str2, @Nullable Map<String, String> map, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.f11744c.c(m12280c(str, str2, map, str3, str4, str5));
    }

    private static HoneyClientEvent m12280c(String str, @Nullable String str2, @Nullable Map<String, String> map, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(StringLocaleUtil.a(str));
        if (str5 != null) {
            honeyClientEvent.c = str5;
        }
        if (str2 != null) {
            honeyClientEvent.b("status", StringLocaleUtil.a(str2));
        }
        if (str4 != null) {
            honeyClientEvent.e = str4;
        }
        if (str3 != null) {
            honeyClientEvent.d = str3;
        }
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                honeyClientEvent.b((String) entry.getKey(), (String) entry.getValue());
            }
        }
        Object[] objArr = new Object[]{str, str2, str3, str4, map};
        return honeyClientEvent;
    }
}
