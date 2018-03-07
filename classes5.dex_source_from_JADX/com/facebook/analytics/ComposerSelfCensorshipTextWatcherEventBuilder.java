package com.facebook.analytics;

import com.facebook.analytics.logger.HoneyClientEvent;

/* compiled from: tokenDetails */
public class ComposerSelfCensorshipTextWatcherEventBuilder extends SelfCensorshipTextWatcherEventBuilder {
    private final String f1852e;

    public ComposerSelfCensorshipTextWatcherEventBuilder(String str, String str2, String str3, long j) {
        super(str, str3, j);
        this.f1852e = str2;
    }

    public final HoneyClientEvent mo482a() {
        this.f1851d = System.nanoTime();
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("composer_written");
        honeyClientEvent.c = this.f1848a;
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.f = this.f1852e;
        return honeyClientEvent.a("written_time", this.f1851d).a("loaded_time", this.f1850c).b("publish_target", this.f1849b);
    }
}
