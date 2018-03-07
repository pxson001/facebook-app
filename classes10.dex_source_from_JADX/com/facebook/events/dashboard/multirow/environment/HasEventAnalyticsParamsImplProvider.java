package com.facebook.events.dashboard.multirow.environment;

import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: com.facebook.platform.extra.WEB_SHARE_NATIVE_TREATMENT */
public class HasEventAnalyticsParamsImplProvider extends AbstractAssistedProvider<HasEventAnalyticsParamsImpl> {
    public static HasEventAnalyticsParamsImpl m17474a(EventAnalyticsParams eventAnalyticsParams) {
        return new HasEventAnalyticsParamsImpl(eventAnalyticsParams);
    }
}
