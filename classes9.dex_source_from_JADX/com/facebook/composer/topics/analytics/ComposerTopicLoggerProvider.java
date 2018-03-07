package com.facebook.composer.topics.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: Tried to add a query string to a session but no session is ongoing */
public class ComposerTopicLoggerProvider extends AbstractAssistedProvider<ComposerTopicLogger> {
    public final ComposerTopicLogger m25913a(String str) {
        return new ComposerTopicLogger(str, AnalyticsLoggerMethodAutoProvider.a(this), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(this));
    }
}
