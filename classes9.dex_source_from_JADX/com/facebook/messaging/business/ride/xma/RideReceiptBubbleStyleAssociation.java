package com.facebook.messaging.business.ride.xma;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import com.facebook.messaging.xma.StyleAssociation;
import javax.inject.Inject;

/* compiled from: mms_config */
public class RideReceiptBubbleStyleAssociation extends StyleAssociation<RideReceiptBubbleStyleRenderer, RideReceiptBubbleSnippetCreator> {
    @Inject
    public RideReceiptBubbleStyleAssociation(Lazy<RideReceiptBubbleStyleRenderer> lazy, Lazy<RideReceiptBubbleSnippetCreator> lazy2) {
        super(GraphQLStoryAttachmentStyle.RIDE_RECEIPT, lazy, lazy2);
    }
}
