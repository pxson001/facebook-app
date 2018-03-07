package com.facebook.debug.fps;

import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.Assisted;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: o.O */
public class TouchDelayLogger {
    public final ExecutorService f11661a;
    public final BaseAnalyticsConfig f11662b;
    public final AnalyticsLogger f11663c;
    public final String f11664d;
    public final Random f11665e;
    public int f11666f = 1;

    @Inject
    public TouchDelayLogger(BaseAnalyticsConfig baseAnalyticsConfig, AnalyticsLogger analyticsLogger, ExecutorService executorService, Random random, @Assisted String str) {
        this.f11664d = str;
        this.f11665e = random;
        this.f11663c = analyticsLogger;
        this.f11661a = executorService;
        this.f11662b = baseAnalyticsConfig;
    }
}
