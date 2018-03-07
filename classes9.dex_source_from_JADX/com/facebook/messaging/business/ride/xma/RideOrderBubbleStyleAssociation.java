package com.facebook.messaging.business.ride.xma;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import com.facebook.messaging.xma.StyleAssociation;
import javax.inject.Inject;

/* compiled from: mmsc */
public class RideOrderBubbleStyleAssociation extends StyleAssociation<RideOrderBubbleStyleRenderer, RideOrderBubbleSnippetCreator> {
    @Inject
    public RideOrderBubbleStyleAssociation(Lazy<RideOrderBubbleStyleRenderer> lazy, Lazy<RideOrderBubbleSnippetCreator> lazy2) {
        super(GraphQLStoryAttachmentStyle.RIDE_ORDERED, lazy, lazy2);
    }
}
