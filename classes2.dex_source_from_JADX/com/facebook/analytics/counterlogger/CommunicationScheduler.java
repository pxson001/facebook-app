package com.facebook.analytics.counterlogger;

import android.content.Context;
import android.content.Intent;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.log.BLog;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.annotations.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: reaction_selected */
public class CommunicationScheduler {
    private static final String f8030a = CommunicationScheduler.class.getName();
    private final AnalyticsLogger f8031b;
    private final MonotonicClock f8032c;
    private final Object f8033d = new Object();
    @GuardedBy("mFlushSync")
    private final Map<String, Map<String, Logger>> f8034e = new HashMap();
    @GuardedBy("mFlushSync")
    private final Map<String, Map<String, Logger>> f8035f = new HashMap();
    private int f8036g = 0;
    @GuardedBy("mFlushSync")
    private long f8037h;

    /* compiled from: reaction_selected */
    public class C03412 implements ActionReceiver {
        final /* synthetic */ CommunicationScheduler f8038a;

        public C03412(CommunicationScheduler communicationScheduler) {
            this.f8038a = communicationScheduler;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = com.facebook.loom.logger.Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 845208714);
            CommunicationScheduler.m12620a(this.f8038a, false);
            com.facebook.loom.logger.Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -336971882, a);
        }
    }

    /* compiled from: reaction_selected */
    public class C03421 implements ActionReceiver {
        final /* synthetic */ CommunicationScheduler f8039a;

        public C03421(CommunicationScheduler communicationScheduler) {
            this.f8039a = communicationScheduler;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = com.facebook.loom.logger.Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -241026332);
            CommunicationScheduler.m12620a(this.f8039a, true);
            com.facebook.loom.logger.Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1123111339, a);
        }
    }

    /* compiled from: reaction_selected */
    public interface Logger {
        JsonNode mo1706a(boolean z, int i);
    }

    @VisibleForTesting
    /* compiled from: reaction_selected */
    class Session {
        final long f16204a;
        final long f16205b;
        final boolean f16206c;
        final int f16207d;

        Session(long j, long j2, boolean z, int i) {
            this.f16204a = j;
            this.f16205b = j2;
            this.f16206c = z;
            this.f16207d = i;
        }
    }

    public CommunicationScheduler(BaseFbBroadcastManager baseFbBroadcastManager, AnalyticsLogger analyticsLogger, MonotonicClock monotonicClock) {
        this.f8031b = analyticsLogger;
        this.f8032c = monotonicClock;
        this.f8037h = this.f8032c.now();
        baseFbBroadcastManager.m2951a().mo506a(AppStateManager.f1111c, new C03412(this)).mo506a(AppStateManager.f1110b, new C03421(this)).mo503a().m3296b();
    }

    public final CommunicationScheduler m12623a(String str, String str2, Logger logger) {
        synchronized (this.f8033d) {
            m12621a(this.f8034e, str, str2, logger);
        }
        return this;
    }

    private static void m12621a(Map<String, Map<String, Logger>> map, String str, String str2, Logger logger) {
        Map map2;
        Map map3 = (Map) map.get(str);
        if (map3 == null) {
            HashMap hashMap = new HashMap();
            map.put(str, hashMap);
            map2 = hashMap;
        } else {
            map2 = map3;
        }
        Logger logger2 = (Logger) map2.get(str2);
        if (logger2 == null || logger2 == logger) {
            map2.put(str2, logger);
        } else {
            BLog.c(f8030a, "Duplicate Logger Registration");
        }
    }

    public static void m12620a(CommunicationScheduler communicationScheduler, boolean z) {
        synchronized (communicationScheduler.f8033d) {
            communicationScheduler.m12618a(communicationScheduler.m12622b(z));
        }
    }

    private Session m12622b(boolean z) {
        Session session;
        synchronized (this.f8033d) {
            long now = this.f8032c.now();
            long j = this.f8037h;
            this.f8037h = now;
            int i = this.f8036g;
            this.f8036g = i + 1;
            session = new Session(j, now, z, i);
        }
        return session;
    }

    @VisibleForTesting
    private void m12618a(Session session) {
        synchronized (this.f8033d) {
            m12619a(session, this.f8034e, false);
            m12619a(session, this.f8035f, true);
        }
    }

    private void m12619a(Session session, Map<String, Map<String, Logger>> map, boolean z) {
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Map map2 = (Map) entry.getValue();
            HoneyClientEventFast a = this.f8031b.mo535a(str, z);
            boolean z2 = false;
            for (Entry entry2 : map2.entrySet()) {
                if (a.m17388a()) {
                    boolean z3;
                    JsonNode a2 = ((Logger) entry2.getValue()).mo1706a(true, this.f8036g);
                    if (a2 != null) {
                        a.m17383a((String) entry2.getKey(), a2);
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    z2 = z3;
                } else {
                    ((Logger) entry2.getValue()).mo1706a(false, this.f8036g);
                }
            }
            if (z2) {
                a.m17382a("period_start", session.f16204a);
                a.m17382a("period_end", session.f16205b);
                a.m17386a("is_background", session.f16206c);
                a.m17381a("session_count", session.f16207d);
                a.m17390b();
            }
        }
    }
}
