package com.facebook.photos.base.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: intent_media */
public class PreFilledTagLogger {
    private final AnalyticsLogger f12642a;
    public String f12643b;

    /* compiled from: intent_media */
    enum Event {
        PREFILLED_TAG_CREATED("prefilled_tag_created"),
        PREFILLED_TAG_SKIPPED("prefilled_tag_skipped"),
        PREFILLED_TAG_DELETED("prefilled_tag_deleted");
        
        private final String name;

        private Event(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }
    }

    public static PreFilledTagLogger m19990b(InjectorLike injectorLike) {
        return new PreFilledTagLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PreFilledTagLogger(AnalyticsLogger analyticsLogger) {
        this.f12642a = analyticsLogger;
    }

    public final void m19991a() {
        m19989a(m19988a(Event.PREFILLED_TAG_CREATED));
    }

    public final void m19992b() {
        m19989a(m19988a(Event.PREFILLED_TAG_SKIPPED));
    }

    public final void m19993c() {
        m19989a(m19988a(Event.PREFILLED_TAG_DELETED));
    }

    private void m19989a(HoneyClientEvent honeyClientEvent) {
        honeyClientEvent.c = "composer";
        if (!StringUtil.a(this.f12643b)) {
            honeyClientEvent.f = this.f12643b;
        }
        this.f12642a.c(honeyClientEvent);
    }

    private static HoneyClientEvent m19988a(Event event) {
        return new HoneyClientEvent(event.toString());
    }
}
