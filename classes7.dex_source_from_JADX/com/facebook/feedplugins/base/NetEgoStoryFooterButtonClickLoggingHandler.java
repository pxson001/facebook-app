package com.facebook.feedplugins.base;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLGroupTopStoriesFeedUnit;
import com.facebook.graphql.model.GraphQLPageStoriesYouMissedFeedUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TDataProvider;ZZ */
public class NetEgoStoryFooterButtonClickLoggingHandler {
    public final AnalyticsLogger f22856a;
    private final NewsFeedAnalyticsEventBuilder f22857b;

    @Inject
    public NetEgoStoryFooterButtonClickLoggingHandler(AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder) {
        this.f22856a = analyticsLogger;
        this.f22857b = newsFeedAnalyticsEventBuilder;
    }

    @Nullable
    public static String m25408a(Flattenable flattenable) {
        if (flattenable instanceof GraphQLGroupTopStoriesFeedUnit) {
            return "gsym_click";
        }
        if (flattenable instanceof GraphQLPageStoriesYouMissedFeedUnit) {
            return "psym_click";
        }
        return null;
    }
}
