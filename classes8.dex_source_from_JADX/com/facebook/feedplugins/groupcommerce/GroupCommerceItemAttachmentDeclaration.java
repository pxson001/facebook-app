package com.facebook.feedplugins.groupcommerce;

import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;

/* compiled from: geocode_address_data */
public class GroupCommerceItemAttachmentDeclaration implements FeedRowSupportDeclaration {
    public final void m14507a(ListItemRowController listItemRowController) {
        listItemRowController.a(GroupCommerceSellerActionsPartDefinition.f12788a);
        listItemRowController.a(GroupCommerceCompactItemPartDefinition.f12684a);
        listItemRowController.a(GroupCommerceItemAttachmentTitlePartDefinition.f12736a);
        listItemRowController.a(GroupCommerceItemAttachmentPriceAndPickupPartDefinition.f12727a);
        listItemRowController.a(GroupCommerceItemAttachmentDescriptionPartDefinition.f12710a);
    }
}
