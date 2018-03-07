package com.facebook.feed.ui;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;

/* compiled from: Trying to measure a view using measureLayout/measureLayoutRelativeToParent relative to an ancestor that requires custom layout for it's children ( */
public class FeedStoryPermalinkOnClickListenerProvider extends AbstractAssistedProvider<FeedStoryPermalinkOnClickListener> {
    public final FeedStoryPermalinkOnClickListener m24324a(FeedProps<GraphQLStory> feedProps) {
        return new FeedStoryPermalinkOnClickListener(NewsFeedAnalyticsEventBuilder.a(this), AnalyticsLoggerMethodAutoProvider.a(this), (PerformanceLogger) DelegatingPerformanceLogger.a(this), InteractionTTILogger.a(this), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), IdBasedProvider.a(this, 3991), feedProps);
    }
}
