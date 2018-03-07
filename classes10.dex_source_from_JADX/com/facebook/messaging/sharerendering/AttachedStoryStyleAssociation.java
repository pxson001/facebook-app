package com.facebook.messaging.sharerendering;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import com.facebook.messaging.xma.StyleAssociation;
import javax.inject.Inject;

/* compiled from: query_string_extra */
public class AttachedStoryStyleAssociation extends StyleAssociation {
    @Inject
    public AttachedStoryStyleAssociation(Lazy<ShareStyleRenderer> lazy, Lazy<LinkShareSnippetCreator> lazy2) {
        super(GraphQLStoryAttachmentStyle.ATTACHED_STORY, lazy, lazy2);
    }
}
