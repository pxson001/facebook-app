package com.facebook.sync.analytics;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.sync.model.IrisQueueTypes;
import javax.inject.Inject;

/* compiled from: feedback_threaded_comments */
public class MessageSyncAnalyticsLogger {
    public SyncAnalyticsLogger f14434a;

    public static MessageSyncAnalyticsLogger m18333b(InjectorLike injectorLike) {
        return new MessageSyncAnalyticsLogger(SyncAnalyticsLogger.m18336a(injectorLike));
    }

    @Inject
    public MessageSyncAnalyticsLogger(SyncAnalyticsLogger syncAnalyticsLogger) {
        this.f14434a = syncAnalyticsLogger;
    }

    public final void m18334a(int i, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("sync_delta_passed_over");
        honeyClientEvent.a("delta_type", i);
        honeyClientEvent.b("reason", str);
        this.f14434a.m18338a(honeyClientEvent, IrisQueueTypes.MESSAGES_QUEUE_TYPE);
    }

    public static MessageSyncAnalyticsLogger m18332a(InjectorLike injectorLike) {
        return m18333b(injectorLike);
    }

    public final void m18335a(String str, String str2, long j, long j2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("sync_bad_new_message_delta");
        honeyClientEvent.b("message_id", str);
        honeyClientEvent.b("thread_key", str2);
        honeyClientEvent.a("timestamp", j);
        honeyClientEvent.a("offlineThreadingId", j2);
        this.f14434a.m18338a(honeyClientEvent, IrisQueueTypes.MESSAGES_QUEUE_TYPE);
    }
}
