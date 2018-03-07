package com.facebook.commerce.core.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceEvent;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceModule;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceRefType;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: privacy option passed to upsell is missing name */
public class CommerceLoggerProvider extends AbstractAssistedProvider<CommerceLogger> {
    public final CommerceLogger m10507a(CommerceEvent commerceEvent, CommerceModule commerceModule, CommerceRefType commerceRefType, Long l) {
        return new CommerceLogger((MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(this), AnalyticsLoggerMethodAutoProvider.a(this), commerceEvent, commerceModule, commerceRefType, l);
    }
}
