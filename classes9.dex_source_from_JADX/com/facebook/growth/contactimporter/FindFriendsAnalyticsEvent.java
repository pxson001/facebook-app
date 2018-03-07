package com.facebook.growth.contactimporter;

import com.facebook.analytics.logger.HoneyClientEvent;

/* compiled from: paymentTransactionId */
public final class FindFriendsAnalyticsEvent extends HoneyClientEvent {
    public FindFriendsAnalyticsEvent(String str) {
        super("flow");
        b("flow_name", "contact_importer");
        b("step_name", str);
    }

    public final FindFriendsAnalyticsEvent m7380a(int i) {
        a("invite_candidates_count", i);
        return this;
    }

    public final FindFriendsAnalyticsEvent m7381o(String str) {
        b("step_phase", str);
        return this;
    }
}
