package com.facebook.messaging.business.common.analytics;

import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threads.ThreadSummary;
import javax.inject.Inject;

/* compiled from: newStatus */
public class DefaultBusinessMessageImpressionLogger implements BusinessMessageImpressionLogger {
    public final AnalyticsLogger f8702a;

    @Inject
    public DefaultBusinessMessageImpressionLogger(AnalyticsLogger analyticsLogger) {
        this.f8702a = analyticsLogger;
    }

    public final void mo317a(ThreadSummary threadSummary) {
        m8909a("mn_platform_msg_thread_imp", threadSummary);
    }

    public final void mo318b(ThreadSummary threadSummary) {
        m8909a("mn_platform_msg_request_imp", threadSummary);
    }

    public final void mo316a(Message message) {
        String str = "mn_platform_msg_imp";
        if (message.N != null) {
            HoneyClientEventFast a = this.f8702a.a(str, false);
            if (a.a()) {
                a.a("messenger_commerce");
                a.a("message_id", message.a).a("page_id", message.b.i()).a("commerce_message_type", message.N);
                a.b();
            }
        }
    }

    private void m8909a(String str, ThreadSummary threadSummary) {
        if (threadSummary.O != null) {
            HoneyClientEventFast a = this.f8702a.a(str, false);
            if (a.a()) {
                a.a("messenger_commerce");
                a.a("timestamp", threadSummary.k).a("page_id", threadSummary.a.i()).a("commerce_message_type", threadSummary.O);
                a.b();
            }
        }
    }
}
