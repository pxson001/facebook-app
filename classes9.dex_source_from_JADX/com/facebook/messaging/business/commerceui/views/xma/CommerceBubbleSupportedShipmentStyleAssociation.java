package com.facebook.messaging.business.commerceui.views.xma;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import com.facebook.messaging.xma.StyleAssociation;
import javax.inject.Inject;

/* compiled from: no_video */
public class CommerceBubbleSupportedShipmentStyleAssociation extends StyleAssociation<CommerceBubbleShippingNotificationStyleRenderer, CommerceBubbleShipmentSnippetCreator> {
    @Inject
    public CommerceBubbleSupportedShipmentStyleAssociation(Lazy<CommerceBubbleShippingNotificationStyleRenderer> lazy, Lazy<CommerceBubbleShipmentSnippetCreator> lazy2) {
        super(GraphQLStoryAttachmentStyle.RETAIL_SHIPMENT_FOR_SUPPORTED_CARRIER, lazy, lazy2);
    }
}
