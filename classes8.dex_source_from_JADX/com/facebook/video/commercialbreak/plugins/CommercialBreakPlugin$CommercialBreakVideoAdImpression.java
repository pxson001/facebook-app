package com.facebook.video.commercialbreak.plugins;

import com.facebook.feed.logging.impression.FeedUnitImpression;
import com.facebook.feed.logging.impression.FeedUnitImpressionType;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.Impression.ImpressionType;

/* compiled from: location_trigger */
public class CommercialBreakPlugin$CommercialBreakVideoAdImpression extends FeedUnitImpression {
    public CommercialBreakPlugin$CommercialBreakVideoAdImpression(FeedProps<GraphQLStory> feedProps) {
        super(FeedUnitImpressionType.SPONSORED_IMPRESSION, feedProps.a, TrackableFeedProps.a(feedProps));
        this.c = ((GraphQLStory) feedProps.a).ab_();
        this.d = ImpressionType.ORIGINAL;
    }
}
