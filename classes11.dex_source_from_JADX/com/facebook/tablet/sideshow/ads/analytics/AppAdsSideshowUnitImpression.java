package com.facebook.tablet.sideshow.ads.analytics;

import com.facebook.feed.logging.impression.FeedUnitImpression;
import com.facebook.feed.logging.impression.FeedUnitImpressionType;
import com.facebook.graphql.model.Impression.ImpressionType;
import com.facebook.graphql.model.Sponsorable;
import com.fasterxml.jackson.databind.node.ArrayNode;

/* compiled from: on_composer_post_published */
public class AppAdsSideshowUnitImpression extends FeedUnitImpression {
    public AppAdsSideshowUnitImpression(FeedUnitImpressionType feedUnitImpressionType, Sponsorable sponsorable, ArrayNode arrayNode) {
        super(feedUnitImpressionType, sponsorable, arrayNode);
        this.c = sponsorable.ab_();
        this.d = ImpressionType.ORIGINAL;
    }
}
