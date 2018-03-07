package com.facebook.messaging.analytics.threads;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: p2p_edit_card_success */
public class FetchThreadLogger {
    private final AnalyticsLogger f7673a;

    /* compiled from: p2p_edit_card_success */
    public enum FetchLocation {
        UNKNOWN,
        THREAD_CACHE,
        THREAD_DB,
        LOCAL,
        SERVER
    }

    public static FetchThreadLogger m7977b(InjectorLike injectorLike) {
        return new FetchThreadLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FetchThreadLogger(AnalyticsLogger analyticsLogger) {
        this.f7673a = analyticsLogger;
    }

    public final void m7978a(Map<String, String> map) {
        this.f7673a.a("fetch_thread", map);
    }
}
