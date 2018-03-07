package com.facebook.messaging.business.commerceui.views.xma;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import com.facebook.messaging.xma.StyleAssociation;
import javax.inject.Inject;

/* compiled from: node_scanner_enabled */
public class CommerceBubbleSubscriptionStyleAssociation extends StyleAssociation<CommerceBubbleSubscriptionStyleRenderer, CommerceBubbleSubscriptionSnippetCreator> {
    @Inject
    public CommerceBubbleSubscriptionStyleAssociation(Lazy<CommerceBubbleSubscriptionStyleRenderer> lazy, Lazy<CommerceBubbleSubscriptionSnippetCreator> lazy2) {
        super(GraphQLStoryAttachmentStyle.RETAIL_NOW_IN_STOCK, lazy, lazy2);
    }
}
