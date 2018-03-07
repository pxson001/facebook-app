package com.facebook.feed.rows.sections.attachments.calltoaction;

import android.view.View;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feedplugins.links.LinkEventFactory;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;

/* compiled from: WEARABLE_DETAIL */
public class PageLikeAttachmentPartDefinition$2 implements LinkEventFactory<FeedProps<GraphQLStoryAttachment>> {
    final /* synthetic */ PageLikeAttachmentPartDefinition f20883a;

    public PageLikeAttachmentPartDefinition$2(PageLikeAttachmentPartDefinition pageLikeAttachmentPartDefinition) {
        this.f20883a = pageLikeAttachmentPartDefinition;
    }

    public final HoneyClientEvent m23813a(Object obj, View view) {
        FeedProps feedProps = (FeedProps) obj;
        view.setTag(Integer.valueOf(2131558518));
        FeedProps e = AttachmentProps.e(feedProps);
        if (e == null) {
            return null;
        }
        NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = this.f20883a.g;
        return NewsFeedAnalyticsEventBuilder.b(((GraphQLStory) e.a).u(), TrackableFeedProps.a(e));
    }
}
