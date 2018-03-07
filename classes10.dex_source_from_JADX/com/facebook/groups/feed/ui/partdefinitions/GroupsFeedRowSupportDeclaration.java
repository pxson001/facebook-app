package com.facebook.groups.feed.ui.partdefinitions;

import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.groups.feed.rows.partdefinitions.ApprovalBarPartDefinition;
import com.facebook.multirow.api.ViewType;
import com.google.common.collect.ImmutableList;

/* compiled from: ThreadViewAudioAttachmentView */
public class GroupsFeedRowSupportDeclaration implements FeedRowSupportDeclaration {
    public final void m23524a(ListItemRowController listItemRowController) {
        ImmutableList of = ImmutableList.of(SeenByBlingBarPartDefinition.f22532a, ApprovalBarPartDefinition.a);
        int size = of.size();
        for (int i = 0; i < size; i++) {
            listItemRowController.a((ViewType) of.get(i));
        }
    }
}
