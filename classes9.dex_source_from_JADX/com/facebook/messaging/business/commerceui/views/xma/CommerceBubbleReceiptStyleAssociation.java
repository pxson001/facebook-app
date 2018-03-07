package com.facebook.messaging.business.commerceui.views.xma;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import com.facebook.messaging.xma.StyleAssociation;
import javax.inject.Inject;

/* compiled from: not checking CURRENT */
public class CommerceBubbleReceiptStyleAssociation extends StyleAssociation<CommerceBubbleReceiptAndCancellationStyleRenderer, CommerceBubbleReceiptSnippetCreator> {
    @Inject
    public CommerceBubbleReceiptStyleAssociation(Lazy<CommerceBubbleReceiptAndCancellationStyleRenderer> lazy, Lazy<CommerceBubbleReceiptSnippetCreator> lazy2) {
        super(GraphQLStoryAttachmentStyle.RETAIL_RECEIPT, lazy, lazy2);
    }
}
