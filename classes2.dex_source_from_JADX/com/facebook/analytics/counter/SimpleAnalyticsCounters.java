package com.facebook.analytics.counter;

import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: overscroll_glow */
public class SimpleAnalyticsCounters extends AnalyticsCounters {
    private final String f10645b;

    @Inject
    public SimpleAnalyticsCounters(CountersPrefWriter countersPrefWriter, @Assisted String str) {
        super(countersPrefWriter);
        this.f10645b = str;
    }

    protected final String mo360a() {
        return this.f10645b;
    }
}
