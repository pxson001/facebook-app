package com.facebook.messaging.business.commerceui.views.xma;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.xma.StyleAssociation;
import javax.inject.Inject;

/* compiled from: normalized_date DESC LIMIT 1 */
public class CommerceBubbleShipmentStyleAssociation extends StyleAssociation<CommerceBubbleShippingNotificationStyleRenderer, CommerceBubbleShipmentSnippetCreator> {
    private static CommerceBubbleShipmentStyleAssociation m8869b(InjectorLike injectorLike) {
        return new CommerceBubbleShipmentStyleAssociation(IdBasedLazy.a(injectorLike, 7601), IdBasedLazy.a(injectorLike, 7597));
    }

    @Inject
    public CommerceBubbleShipmentStyleAssociation(Lazy<CommerceBubbleShippingNotificationStyleRenderer> lazy, Lazy<CommerceBubbleShipmentSnippetCreator> lazy2) {
        super(GraphQLStoryAttachmentStyle.RETAIL_SHIPMENT, lazy, lazy2);
    }
}
