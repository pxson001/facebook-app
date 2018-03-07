package com.facebook.today.analytics;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.Assisted;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger;
import javax.inject.Inject;

/* compiled from: ui_init */
public class TodayAnalyticsLogger {
    public final AnalyticsLogger f1163a;
    public final ReactionAnalyticsLogger f1164b;
    public final ReactionSession f1165c;
    public boolean f1166d = true;

    /* compiled from: ui_init */
    public enum Event {
        NOTIFICATION_PILL_CLICK("today_notification_pill_clicked");
        
        public final String name;

        private Event(String str) {
            this.name = str;
        }
    }

    @Inject
    public TodayAnalyticsLogger(@Assisted ReactionSession reactionSession, AnalyticsLogger analyticsLogger, ReactionAnalyticsLogger reactionAnalyticsLogger) {
        this.f1165c = reactionSession;
        this.f1163a = analyticsLogger;
        this.f1164b = reactionAnalyticsLogger;
    }
}
