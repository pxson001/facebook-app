package com.facebook.messaging.sharerendering;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import com.facebook.messaging.xma.StyleAssociation;
import javax.inject.Inject;

/* compiled from: quantity_button_tapped_count */
public class ImageShareStyleAssociation extends StyleAssociation<ImageShareStyleRenderer, ImageShareSnippetCreator> {
    @Inject
    public ImageShareStyleAssociation(Lazy<ImageShareStyleRenderer> lazy, Lazy<ImageShareSnippetCreator> lazy2) {
        super(GraphQLStoryAttachmentStyle.IMAGE_SHARE, lazy, lazy2);
    }
}
