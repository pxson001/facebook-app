package com.facebook.friendsharing.gif.activity;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import javax.inject.Inject;

/* compiled from: SELECT */
public class GifPickerAnalyticsLogger {
    public final AnalyticsLogger f23884a;

    @Inject
    public GifPickerAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f23884a = analyticsLogger;
    }

    public final void m26013a(String str, String str2, int i) {
        this.f23884a.a(new HoneyClientEvent("gif_picker_search_returned").b("session_id", str).b("search_string", str2).a("no_of_items_returned", i));
    }

    public final void m26014d(String str) {
        this.f23884a.a(new HoneyClientEvent("gif_picker_trending_gifs_displayed").b("session_id", str));
    }

    public final void m26015e(String str) {
        this.f23884a.a(new HoneyClientEvent("gif_picker_giphy_returned_error").b("session_id", str));
    }
}
