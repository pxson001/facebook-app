package com.facebook.events.permalink.multirow;

import com.facebook.events.permalink.reactioncomponents.EventDetailsUnitComponentPartDefinition;
import com.facebook.events.permalink.reactioncomponents.EventGuestHScrollFacepileUnitComponentDefinition;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;

/* compiled from: bb62c80dff8544b6a03e1d38c4bd3fda */
public class EventsPermalinkRowSupportDeclaration implements FeedRowSupportDeclaration {
    public final void m19003a(ListItemRowController listItemRowController) {
        listItemRowController.a(EventDetailsUnitComponentPartDefinition.f18810a);
        listItemRowController.a(EventFeedComposerRootPartDefinition.f18701b);
        listItemRowController.a(EventGuestHScrollFacepileUnitComponentDefinition.f18818a);
        listItemRowController.a(PostingStoryProgressBarRootPartDefinition.f18715a);
    }
}
