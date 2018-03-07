package com.facebook.messaging.momentsinvite.ui;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import com.facebook.messaging.xma.StyleAssociation;
import javax.inject.Inject;

/* compiled from: iso-8859-7 */
public class MomentsPhotoRequestStyleAssociation extends StyleAssociation<MomentsInviteStyleRenderer, MomentsInviteSnippetCreator> {
    @Inject
    public MomentsPhotoRequestStyleAssociation(Lazy<MomentsInviteStyleRenderer> lazy, Lazy<MomentsInviteSnippetCreator> lazy2) {
        super(GraphQLStoryAttachmentStyle.MOMENTS_APP_PHOTO_REQUEST, lazy, lazy2);
    }
}
