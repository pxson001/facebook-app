package com.facebook.messaging.business.commerceui.views.xma;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import com.facebook.messaging.xma.StyleAssociation;
import javax.inject.Inject;

/* compiled from: no_promos */
public class CommerceBubbleTrackingEventDeliveredStyleAssociation extends StyleAssociation<CommerceBubbleShippingNotificationStyleRenderer, CommerceBubbleShipmentSnippetCreator> {
    @Inject
    public CommerceBubbleTrackingEventDeliveredStyleAssociation(Lazy<CommerceBubbleShippingNotificationStyleRenderer> lazy, Lazy<CommerceBubbleShipmentSnippetCreator> lazy2) {
        super(GraphQLStoryAttachmentStyle.RETAIL_SHIPMENT_TRACKING_EVENT_DELIVERED, lazy, lazy2);
    }
}
