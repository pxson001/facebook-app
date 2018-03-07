package com.facebook.negativefeedback.logging;

import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: notifications_empty_message */
public class NegativeFeedbackAnalyticsLogger {
    private final AnalyticsLogger f7974a;
    public final Map<String, Object> f7975b = new ArrayMap();

    /* compiled from: notifications_empty_message */
    public class ParamsBuilder {
        private Bundle f7972a;
        public Bundle f7973b;

        public ParamsBuilder() {
            this(new Bundle());
        }

        private ParamsBuilder(Bundle bundle) {
            this.f7973b = bundle;
            this.f7972a = new Bundle();
            this.f7973b.putBundle("analytics_params", this.f7972a);
        }

        public final ParamsBuilder m9593a(String str) {
            this.f7972a.putString("tracking_data", str);
            return this;
        }
    }

    @Inject
    public NegativeFeedbackAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f7974a = analyticsLogger;
    }

    private void m9594a(HoneyClientEvent honeyClientEvent, String str) {
        honeyClientEvent.b("graphql_token", str);
        honeyClientEvent.a(this.f7975b);
        this.f7974a.c(honeyClientEvent);
    }

    public final void m9596a(String str, String str2) {
        HoneyClientEventFast a = this.f7974a.a("negativefeedback_start_flow", false);
        this.f7975b.put("negative_feedback_location", str2);
        if (a.a()) {
            a.a("graphql_token", str);
            a.a(this.f7975b);
            a.b();
        }
    }

    public final void m9595a(String str) {
        m9594a(new HoneyClientEvent("negativefeedback_answer_question"), str);
    }

    public final void m9598b(String str) {
        m9594a(new HoneyClientEvent("negativefeedback_open_message_composer"), str);
    }

    public final void m9599c(String str) {
        m9594a(new HoneyClientEvent("negativefeedback_cancel_message_composer"), str);
    }

    public final void m9600d(String str) {
        m9594a(new HoneyClientEvent("negativefeedback_cancel_flow"), str);
    }

    public final void m9601e(String str) {
        m9594a(new HoneyClientEvent("negativefeedback_went_back"), str);
    }

    public final void m9602f(String str) {
        m9594a(new HoneyClientEvent("negativefeedback_redirect_action"), str);
    }

    public final void m9603g(String str) {
        m9594a(new HoneyClientEvent("negativefeedback_guided_action"), str);
    }

    public final void m9604h(String str) {
        m9594a(new HoneyClientEvent("negativefeedback_require_confirmation"), str);
    }

    public final void m9605i(String str) {
        m9594a(new HoneyClientEvent("negativefeedback_cancel_confirmation"), str);
    }

    public final void m9597a(String str, String str2, String str3) {
        HoneyClientEventFast a = this.f7974a.a("negativefeedback_message_action", false);
        if (a.a()) {
            a.a("graphql_token", str);
            a.a("message_body", str2);
            a.a("recipient_id", str3);
            a.a(this.f7975b);
            a.b();
        }
    }
}
