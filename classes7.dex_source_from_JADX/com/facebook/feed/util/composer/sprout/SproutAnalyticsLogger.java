package com.facebook.feed.util.composer.sprout;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.inject.Assisted;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TURN_OFF_CCU_AFTER_EXCEPTION */
public class SproutAnalyticsLogger {
    private final AnalyticsLogger f22426a;
    private final FbDataConnectionManager f22427b;
    private final SproutSource f22428c;
    private final String f22429d;

    /* compiled from: TURN_OFF_CCU_AFTER_EXCEPTION */
    public enum SproutSource {
        FEED,
        FRIENDS_TAB,
        TIMELINE,
        REDSPACE,
        GROUPS
    }

    @Inject
    public SproutAnalyticsLogger(AnalyticsLogger analyticsLogger, FbDataConnectionManager fbDataConnectionManager, @Assisted SproutSource sproutSource, @Assisted String str) {
        this.f22426a = analyticsLogger;
        this.f22427b = fbDataConnectionManager;
        this.f22428c = sproutSource;
        this.f22429d = str;
    }

    public final void m25025a() {
        this.f22426a.a(m25024c("music_sprout_shown_with_song"));
    }

    public final void m25027b() {
        this.f22426a.a(m25024c("music_sprout_clicked_with_song"));
    }

    public final void m25029c() {
        this.f22426a.a(m25024c("sprout_open").b("connection_class", this.f22427b.c().name()));
    }

    public final void m25026a(String str) {
        this.f22426a.a(m25024c("sprout_button_clicked").b("sprout_button_name", str));
    }

    public final void m25028b(@Nullable String str) {
        this.f22426a.a(m25024c("sprout_cancel").b("sprout_cancel_reason", Strings.nullToEmpty(str)));
    }

    private HoneyClientEvent m25024c(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "sprout";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.f = this.f22429d;
        return honeyClientEvent.b("sprout_source", this.f22428c.name());
    }
}
