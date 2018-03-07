package com.facebook.feed.analytics;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Date;
import java.util.Map;

/* compiled from: neko_di_app_already_installed */
class LongClickTracker$1 implements Runnable {
    final /* synthetic */ Date f10110a;
    final /* synthetic */ double f10111b;
    final /* synthetic */ double f10112c;
    final /* synthetic */ String f10113d;
    final /* synthetic */ JsonNode f10114e;
    final /* synthetic */ Map f10115f;
    final /* synthetic */ LongClickTracker f10116g;

    LongClickTracker$1(LongClickTracker longClickTracker, Date date, double d, double d2, String str, JsonNode jsonNode, Map map) {
        this.f10116g = longClickTracker;
        this.f10110a = date;
        this.f10111b = d;
        this.f10112c = d2;
        this.f10113d = str;
        this.f10114e = jsonNode;
        this.f10115f = map;
    }

    public void run() {
        if (this.f10110a != null || this.f10111b > 0.0d) {
            double d;
            if (this.f10111b > 0.0d) {
                d = this.f10111b / 1000.0d;
            } else {
                d = ((double) (new Date().getTime() - this.f10110a.getTime())) / 1000.0d;
            }
            this.f10116g.g.c(NewsFeedAnalyticsEventBuilder.a(d, this.f10112c, this.f10113d, this.f10114e, this.f10115f));
        }
    }
}
