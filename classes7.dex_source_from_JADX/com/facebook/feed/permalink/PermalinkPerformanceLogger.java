package com.facebook.feed.permalink;

import com.facebook.inject.InjectorLike;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;

/* compiled from: after */
public class PermalinkPerformanceLogger {
    public static final List<MarkerConfig> f19634a = Arrays.asList(new MarkerConfig[]{new MarkerConfig(655368, "NNF_PermalinkFromFeedLoad"), new MarkerConfig(655408, "NNF_PermalinkNotificationLoad"), new MarkerConfig(655370, "PermalinkFromOnCreateToLoad"), new MarkerConfig(655407, "PermalinkFromOnCreateToLoadIfNoNavigationalMetrics"), new MarkerConfig(655412, "NNF_PermalinkFromAndroidNotificationColdLoad"), new MarkerConfig(3473416, "NotifPermalinkRefreshStoryTime")});
    public static final List<MarkerConfig> f19635b = Arrays.asList(new MarkerConfig[]{new MarkerConfig(655368, "NNF_PermalinkFromFeedLoad"), new MarkerConfig(655408, "NNF_PermalinkNotificationLoad"), new MarkerConfig(655370, "PermalinkFromOnCreateToLoad"), new MarkerConfig(655407, "PermalinkFromOnCreateToLoadIfNoNavigationalMetrics"), new MarkerConfig(655412, "NNF_PermalinkFromAndroidNotificationColdLoad"), new MarkerConfig(655409, "NNF_PermalinkFromAndroidNotificationWarmLoad"), new MarkerConfig(3473415, "NotifLockscreenPermalinkLoadTime"), new MarkerConfig(3473416, "NotifPermalinkRefreshStoryTime")});
    public final PerformanceLogger f19636c;
    private final QuickPerformanceLogger f19637d;
    public final InteractionTTILogger f19638e;

    /* compiled from: after */
    public class C16981 implements OnDrawListener {
        final /* synthetic */ PermalinkPerformanceLogger f19633a;

        public C16981(PermalinkPerformanceLogger permalinkPerformanceLogger) {
            this.f19633a = permalinkPerformanceLogger;
        }

        public final boolean gD_() {
            for (MarkerConfig b : PermalinkPerformanceLogger.f19635b) {
                this.f19633a.f19636c.b(b);
            }
            this.f19633a.f19638e.b("LoadPermalink");
            return true;
        }
    }

    public static PermalinkPerformanceLogger m22905a(InjectorLike injectorLike) {
        return new PermalinkPerformanceLogger((PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), InteractionTTILogger.a(injectorLike));
    }

    @Inject
    public PermalinkPerformanceLogger(PerformanceLogger performanceLogger, QuickPerformanceLogger quickPerformanceLogger, InteractionTTILogger interactionTTILogger) {
        this.f19636c = performanceLogger;
        this.f19637d = quickPerformanceLogger;
        this.f19638e = interactionTTILogger;
    }

    public final void m22906c() {
        for (MarkerConfig d : f19635b) {
            this.f19636c.d(d);
        }
        this.f19638e.b();
    }
}
