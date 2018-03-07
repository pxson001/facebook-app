package com.facebook.messaging.momentsinvite.ui;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import com.facebook.messaging.xma.StyleAssociation;
import javax.inject.Inject;

/* compiled from: itemDescription */
public class MomentsInviteStyleAssociation extends StyleAssociation<MomentsInviteStyleRenderer, MomentsInviteSnippetCreator> {
    @Inject
    public MomentsInviteStyleAssociation(Lazy<MomentsInviteStyleRenderer> lazy, Lazy<MomentsInviteSnippetCreator> lazy2) {
        super(GraphQLStoryAttachmentStyle.MOMENTS_APP_INVITATION, lazy, lazy2);
    }
}
