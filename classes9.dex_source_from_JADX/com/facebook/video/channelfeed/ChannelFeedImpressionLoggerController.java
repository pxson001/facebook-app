package com.facebook.video.channelfeed;

import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.feed.logging.impression.FeedUnitImpression;
import com.facebook.feed.logging.impression.FeedUnitImpressionType;
import com.facebook.feed.logging.impression.FeedUnitSponsoredImpressionLogger;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.Impression.ImpressionType;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: ta_provider */
public class ChannelFeedImpressionLoggerController extends VideoViewController<ChannelFeedVideoAttachmentView> {
    private final FeedUnitSponsoredImpressionLogger f2341a;
    private final FeedUnitImpression f2342b;

    /* compiled from: ta_provider */
    class ChannelFeedImpression extends FeedUnitImpression {
        public ChannelFeedImpression(FeedUnitImpressionType feedUnitImpressionType, FeedProps<GraphQLStory> feedProps) {
            super(feedUnitImpressionType, feedProps.a, TrackableFeedProps.a(feedProps));
            this.c = ((GraphQLStory) feedProps.a).ab_();
            this.d = ImpressionType.ORIGINAL;
        }
    }

    public final /* bridge */ /* synthetic */ void m2300a(Object obj) {
    }

    @Inject
    public ChannelFeedImpressionLoggerController(@Assisted String str, @Assisted FeedProps<GraphQLStory> feedProps, FeedUnitSponsoredImpressionLogger feedUnitSponsoredImpressionLogger) {
        super(str);
        this.f2342b = new ChannelFeedImpression(FeedUnitImpressionType.SPONSORED_IMPRESSION, feedProps);
        this.f2341a = feedUnitSponsoredImpressionLogger;
    }

    public final void m2301b(Object obj) {
        this.f2341a.a(this.f2342b);
    }
}
