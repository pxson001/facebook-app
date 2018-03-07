package com.facebook.messaging.business.commerceui.views.xma;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.xma.StyleAssociation;
import javax.inject.Inject;

/* compiled from: normalized_date */
public class CommerceBubbleShipmentTrackingStyleAssociation extends StyleAssociation<CommerceBubbleShippingNotificationStyleRenderer, CommerceBubbleShipmentTrackingSnippetCreator> {
    private static CommerceBubbleShipmentTrackingStyleAssociation m8871b(InjectorLike injectorLike) {
        return new CommerceBubbleShipmentTrackingStyleAssociation(IdBasedLazy.a(injectorLike, 7601), IdBasedLazy.a(injectorLike, 7599));
    }

    @Inject
    public CommerceBubbleShipmentTrackingStyleAssociation(Lazy<CommerceBubbleShippingNotificationStyleRenderer> lazy, Lazy<CommerceBubbleShipmentTrackingSnippetCreator> lazy2) {
        super(GraphQLStoryAttachmentStyle.RETAIL_SHIPMENT_TRACKING_EVENT, lazy, lazy2);
    }
}
