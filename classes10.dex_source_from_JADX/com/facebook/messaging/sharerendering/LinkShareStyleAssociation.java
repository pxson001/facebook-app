package com.facebook.messaging.sharerendering;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import com.facebook.messaging.xma.StyleAssociation;
import javax.inject.Inject;

/* compiled from: qrcode_vanity_exception */
public class LinkShareStyleAssociation extends StyleAssociation<ShareStyleRenderer, LinkShareSnippetCreator> {
    @Inject
    public LinkShareStyleAssociation(Lazy<ShareStyleRenderer> lazy, Lazy<LinkShareSnippetCreator> lazy2) {
        super(GraphQLStoryAttachmentStyle.SHARE, lazy, lazy2);
    }
}
