package com.facebook.katana.languages;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;

/* compiled from: write_privacy */
class Fb4aSupportedLanguages$1 implements Runnable {
    final /* synthetic */ Fb4aSupportedLanguages f73a;

    Fb4aSupportedLanguages$1(Fb4aSupportedLanguages fb4aSupportedLanguages) {
        this.f73a = fb4aSupportedLanguages;
    }

    public void run() {
        Fb4aSupportedLanguages fb4aSupportedLanguages = this.f73a;
        if (!fb4aSupportedLanguages.h) {
            fb4aSupportedLanguages.h = true;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fbresources_disabled_fb4a");
            honeyClientEvent.a("is_local_build", fb4aSupportedLanguages.c.d());
            ((AnalyticsLogger) fb4aSupportedLanguages.b.get()).a(honeyClientEvent);
        }
    }
}
