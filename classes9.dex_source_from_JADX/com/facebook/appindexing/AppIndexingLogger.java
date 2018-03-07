package com.facebook.appindexing;

import com.facebook.analytics.logger.AnalyticsLogger;
import javax.inject.Inject;

/* compiled from: selected_address */
public class AppIndexingLogger {
    public final AnalyticsLogger f4197a;

    /* compiled from: selected_address */
    public enum EventType {
        APP_INDEXING_EVENT_TYPE("app_indexing_referrer");
        
        private final String mEventName;

        private EventType(String str) {
            this.mEventName = str;
        }

        public final String getEventName() {
            return this.mEventName;
        }
    }

    @Inject
    public AppIndexingLogger(AnalyticsLogger analyticsLogger) {
        this.f4197a = analyticsLogger;
    }
}
