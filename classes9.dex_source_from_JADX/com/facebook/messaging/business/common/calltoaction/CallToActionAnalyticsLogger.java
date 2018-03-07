package com.facebook.messaging.business.common.calltoaction;

import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: newBuilderForField() called on a non-Message type. */
public class CallToActionAnalyticsLogger {
    private final AnalyticsLogger f8719a;

    @Inject
    public CallToActionAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f8719a = analyticsLogger;
    }

    public final void m8926a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z) {
        boolean z2 = !Strings.isNullOrEmpty(str);
        if (z) {
            m8925a(z2, str6, str7, str5);
            return;
        }
        HoneyClientEventFast a = this.f8719a.a("did_tap_call_to_action", false);
        if (a.a()) {
            a.a("messenger_commerce");
            a.a("message_id", str6).a("action_url", str4).a("action_target_id", str5).a("commerce_message_type", str8);
            if (z2) {
                a.a("action_id", str);
                a.a("action_title", str2);
                if (!Strings.isNullOrEmpty(str3)) {
                    a.a("action_type", str3);
                }
            }
            a.b();
        }
    }

    private void m8925a(boolean z, String str, String str2, String str3) {
        String str4;
        if (z) {
            str4 = "messenger_ads_link_click_cta";
        } else {
            str4 = "messenger_ads_link_click";
        }
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str4);
        honeyClientEvent.c = "messenger_ads";
        HoneyClientEvent honeyClientEvent2 = honeyClientEvent;
        honeyClientEvent2.b("message_id", str).b("page_id", str2).b("item_id", str3);
        this.f8719a.d(honeyClientEvent2);
    }
}
