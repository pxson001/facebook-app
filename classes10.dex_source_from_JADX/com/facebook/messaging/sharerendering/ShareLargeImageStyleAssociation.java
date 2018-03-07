package com.facebook.messaging.sharerendering;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import com.facebook.messaging.xma.StyleAssociation;
import javax.inject.Inject;

/* compiled from: qrcode_vanity_created */
public class ShareLargeImageStyleAssociation extends StyleAssociation<ImageShareStyleRenderer, ImageShareSnippetCreator> {
    @Inject
    public ShareLargeImageStyleAssociation(Lazy<ImageShareStyleRenderer> lazy, Lazy<ImageShareSnippetCreator> lazy2) {
        super(GraphQLStoryAttachmentStyle.SHARE_LARGE_IMAGE, lazy, lazy2);
    }
}
