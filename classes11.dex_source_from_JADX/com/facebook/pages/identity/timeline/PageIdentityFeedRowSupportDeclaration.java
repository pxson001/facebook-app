package com.facebook.pages.identity.timeline;

import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.pages.identity.cards.contextitems.PageContextRowsPlaceholderUnitComponentPartDefinition;

/* compiled from: page_photos_by_friends */
public class PageIdentityFeedRowSupportDeclaration implements FeedRowSupportDeclaration {
    public final void m5102a(ListItemRowController listItemRowController) {
        listItemRowController.a(PageIdentityPinnedPostHeaderPartDefinition.f4182a);
        listItemRowController.a(PageContextRowsPlaceholderUnitComponentPartDefinition.f3387a);
    }
}
