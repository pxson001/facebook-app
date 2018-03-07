package com.facebook.messaging.business.commerceui.views.xma;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import com.facebook.messaging.xma.StyleAssociation;
import javax.inject.Inject;

/* compiled from: noFaceDetection */
public class CommerceBubbleTrackingEventInTransitStyleAssociation extends StyleAssociation<CommerceBubbleShippingNotificationStyleRenderer, CommerceBubbleShipmentSnippetCreator> {
    @Inject
    public CommerceBubbleTrackingEventInTransitStyleAssociation(Lazy<CommerceBubbleShippingNotificationStyleRenderer> lazy, Lazy<CommerceBubbleShipmentSnippetCreator> lazy2) {
        super(GraphQLStoryAttachmentStyle.RETAIL_SHIPMENT_TRACKING_EVENT_IN_TRANSIT, lazy, lazy2);
    }
}
