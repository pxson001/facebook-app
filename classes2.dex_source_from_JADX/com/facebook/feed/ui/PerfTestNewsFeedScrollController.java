package com.facebook.feed.ui;

import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.widget.listview.ScrollPerfHelper;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.controllercallbacks.ScrollCallback;
import javax.inject.Inject;

/* compiled from: platform_launch_extras */
public class PerfTestNewsFeedScrollController implements ScrollCallback {
    private PerfTestConfig f9662a;
    private final Lazy<ScrollPerfHelper> f9663b;
    private final QuickPerformanceLogger f9664c;
    private boolean f9665d = false;

    public static PerfTestNewsFeedScrollController m14668a(InjectorLike injectorLike) {
        return new PerfTestNewsFeedScrollController(PerfTestConfig.m2936a(injectorLike), IdBasedLazy.m1808a(injectorLike, 3731), QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike));
    }

    @Inject
    public PerfTestNewsFeedScrollController(PerfTestConfig perfTestConfig, Lazy<ScrollPerfHelper> lazy, QuickPerformanceLogger quickPerformanceLogger) {
        this.f9662a = perfTestConfig;
        this.f9663b = lazy;
        this.f9664c = quickPerformanceLogger;
    }

    public final void mo1262a(ScrollingViewProxy scrollingViewProxy, int i) {
        ((ScrollPerfHelper) this.f9663b.get()).a(i);
        switch (i) {
            case 0:
                if (this.f9665d) {
                    this.f9664c.mo468b(655510, (short) 2);
                    this.f9665d = false;
                    return;
                }
                return;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                if (!this.f9665d) {
                    this.f9664c.mo462b(655510);
                    this.f9665d = true;
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
    }
}
