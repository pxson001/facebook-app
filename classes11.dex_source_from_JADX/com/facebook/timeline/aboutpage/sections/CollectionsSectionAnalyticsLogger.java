package com.facebook.timeline.aboutpage.sections;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.timeline.aboutpage.CollectionsAnalyticsLogger;
import javax.inject.Inject;

/* compiled from: MINUTIAE_ID */
public class CollectionsSectionAnalyticsLogger extends CollectionsAnalyticsLogger {
    @Inject
    public CollectionsSectionAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        super(analyticsLogger);
    }

    protected final String mo370b() {
        return "collections_section";
    }
}
