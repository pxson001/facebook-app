package com.facebook.feed.util.composer.sprout;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.feed.util.composer.sprout.SproutAnalyticsLogger.SproutSource;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: TTML */
public class SproutAnalyticsLoggerProvider extends AbstractAssistedProvider<SproutAnalyticsLogger> {
    public final SproutAnalyticsLogger m25030a(SproutSource sproutSource, String str) {
        return new SproutAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(this), FbDataConnectionManager.a(this), sproutSource, str);
    }
}
