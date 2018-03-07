package com.facebook.timeline.aboutpage.collection;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.aboutpage.CollectionsAnalyticsLogger;
import javax.inject.Inject;

/* compiled from: Must initialize section first */
public class CollectionsCollectionAnalyticsLogger extends CollectionsAnalyticsLogger {
    public static CollectionsCollectionAnalyticsLogger m13850a(InjectorLike injectorLike) {
        return new CollectionsCollectionAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public CollectionsCollectionAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        super(analyticsLogger);
    }

    protected final String mo370b() {
        return "collections_collection";
    }
}
