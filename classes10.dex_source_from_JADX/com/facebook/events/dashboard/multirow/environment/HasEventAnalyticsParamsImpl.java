package com.facebook.events.dashboard.multirow.environment;

import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: com.facebook.platform.status.ERROR_CODE */
public class HasEventAnalyticsParamsImpl implements HasEventAnalyticsParams {
    EventAnalyticsParams f17132a;

    @Inject
    public HasEventAnalyticsParamsImpl(@Assisted EventAnalyticsParams eventAnalyticsParams) {
        this.f17132a = eventAnalyticsParams;
    }

    public final EventAnalyticsParams mo794s() {
        return this.f17132a;
    }
}
