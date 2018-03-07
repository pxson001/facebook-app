package com.facebook.messaging.business.commerceui.views.common;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import com.facebook.messaging.xma.StyleAssociation;
import javax.inject.Inject;

/* compiled from: null_state_module_suggestion */
public class RetailItemStyleAssociation extends StyleAssociation<RetailItemStyleRenderer, RetailItemSnippetCreator> {
    @Inject
    public RetailItemStyleAssociation(Lazy<RetailItemStyleRenderer> lazy, Lazy<RetailItemSnippetCreator> lazy2) {
        super(GraphQLStoryAttachmentStyle.RETAIL_ITEM, lazy, lazy2);
    }
}
