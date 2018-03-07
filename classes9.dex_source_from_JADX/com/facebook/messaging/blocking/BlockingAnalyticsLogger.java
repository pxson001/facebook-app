package com.facebook.messaging.blocking;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: onSuccess */
public class BlockingAnalyticsLogger {
    public final AnalyticsLogger f8249a;

    public static BlockingAnalyticsLogger m8498b(InjectorLike injectorLike) {
        return new BlockingAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BlockingAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f8249a = analyticsLogger;
    }

    private void m8497a(HoneyClientEvent honeyClientEvent, String str) {
        honeyClientEvent.b("target", str);
        this.f8249a.a(honeyClientEvent);
    }

    public final void m8499a(String str) {
        m8497a(new HoneyClientEvent("message_block_tap_block_from_thread_action_menu"), str);
    }

    public static BlockingAnalyticsLogger m8496a(InjectorLike injectorLike) {
        return m8498b(injectorLike);
    }

    public final void m8500b(String str) {
        m8497a(new HoneyClientEvent("message_block_tap_unblock_on_facebook"), str);
    }

    public final void m8501c(String str) {
        m8497a(new HoneyClientEvent("message_block_toggle_block_messages_off"), str);
    }

    public final void m8502d(String str) {
        m8497a(new HoneyClientEvent("message_block_toggle_block_messages_on"), str);
    }
}
