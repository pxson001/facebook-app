package com.facebook.messaging.business.commerceui.views.xma;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import com.facebook.messaging.xma.StyleAssociation;
import javax.inject.Inject;

/* compiled from: no allowed characters specified */
public class RetailPromotionStyleAssociation extends StyleAssociation<RetailPromotionStyleRenderer, RetailPromotionSnippetCreator> {
    @Inject
    public RetailPromotionStyleAssociation(Lazy<RetailPromotionStyleRenderer> lazy, Lazy<RetailPromotionSnippetCreator> lazy2) {
        super(GraphQLStoryAttachmentStyle.RETAIL_PROMOTION, lazy, lazy2);
    }
}
