package com.facebook.analytics;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

/* compiled from: tokenId */
public abstract class SelfCensorshipTextWatcherEventBuilder {
    protected String f1848a;
    protected String f1849b;
    protected long f1850c;
    public long f1851d;

    public abstract HoneyClientEvent mo482a();

    public SelfCensorshipTextWatcherEventBuilder() {
        this("unknown", "", 0);
    }

    public SelfCensorshipTextWatcherEventBuilder(String str, String str2, long j) {
        this.f1848a = str;
        m2533a(str2);
        this.f1850c = j;
        this.f1851d = 0;
    }

    public void m2533a(String str) {
        if (str != null) {
            Iterable split = Splitter.on('_').split(str);
            if (Iterables.b(split) != 1) {
                str = (String) Iterables.g(split);
            }
            this.f1849b = str;
            return;
        }
        this.f1849b = "-1";
    }
}
