package com.facebook.photos.creativeediting.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: mVideoBroadcastInitResponse is null Unable to send seal request  */
public class CreativeEditingUsageLoggerProvider extends AbstractAssistedProvider<CreativeEditingUsageLogger> {
    public final CreativeEditingUsageLogger m11493a(String str) {
        return new CreativeEditingUsageLogger(str, AnalyticsLoggerMethodAutoProvider.a(this));
    }
}
