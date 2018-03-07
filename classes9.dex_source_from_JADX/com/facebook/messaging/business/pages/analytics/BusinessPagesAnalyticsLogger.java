package com.facebook.messaging.business.pages.analytics;

import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: msg_from */
public class BusinessPagesAnalyticsLogger {
    private final AnalyticsLogger f9029a;

    /* compiled from: msg_from */
    public enum SuggestedPageProduct {
        SEARCH_NULL_STATE("search_null_state");
        
        private String value;

        private SuggestedPageProduct(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* compiled from: msg_from */
    public enum SuggestedPageType {
        BOTS("mm_bots_impressions", "mm_bots_clicks"),
        BUSINESSES("mm_bymm_impressions", "mm_bymm_clicks");
        
        public String clickLoggingEventName;
        public String impressionLoggingEventName;

        private SuggestedPageType(String str, String str2) {
            this.impressionLoggingEventName = str;
            this.clickLoggingEventName = str2;
        }
    }

    @Inject
    public BusinessPagesAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f9029a = analyticsLogger;
    }

    public final void m9288a(String str, int i, int i2, int i3, SuggestedPageProduct suggestedPageProduct, @Nullable SuggestedPageType suggestedPageType) {
        if (suggestedPageType != null) {
            HoneyClientEventFast a = this.f9029a.a(suggestedPageType.impressionLoggingEventName, false);
            if (a.a()) {
                a.a("page_id", str);
                a.a("abs_pos", i);
                a.a("rel_pos", i2);
                a.a("total", i3);
                a.a("product", suggestedPageProduct.getValue());
                a.b();
            }
        }
    }
}
