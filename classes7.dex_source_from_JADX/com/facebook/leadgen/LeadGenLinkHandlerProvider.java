package com.facebook.leadgen;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.feed.analytics.LongClickTracker;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.links.AttachmentLinkInspector;
import com.facebook.links.AttachmentLinkLauncher;

/* compiled from: place_info_blurb_page */
public class LeadGenLinkHandlerProvider extends AbstractAssistedProvider<LeadGenLinkHandler> {
    public final LeadGenLinkHandler m8133a(FeedProps<GraphQLStoryAttachment> feedProps) {
        return new LeadGenLinkHandler(AttachmentLinkInspector.a(this), AttachmentLinkLauncher.a(this), AnalyticsLoggerMethodAutoProvider.a(this), LongClickTracker.a(this), FeedEventBus.a(this), CommonEventsBuilder.b(this), NewsFeedAnalyticsEventBuilder.a(this), LeadGenUtil.a(this), feedProps);
    }
}
