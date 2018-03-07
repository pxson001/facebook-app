package com.facebook.timeline.aboutpage.summary;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionItemType;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.aboutpage.CollectionsAnalyticsLogger;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: M-SEARCH * HTTP/1.1 */
public class CollectionsSummaryAnalyticsLogger extends CollectionsAnalyticsLogger {
    public final Set<GraphQLTimelineAppCollectionItemType> f13595b = Sets.a();

    public static CollectionsSummaryAnalyticsLogger m14799b(InjectorLike injectorLike) {
        return new CollectionsSummaryAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public CollectionsSummaryAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        super(analyticsLogger);
    }

    public final String mo370b() {
        return "collections_overview";
    }
}
