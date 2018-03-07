package com.facebook.commerce.invoices.xma;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import com.facebook.messaging.xma.StyleAssociation;
import javax.inject.Inject;

/* compiled from: quick_promotion_phone_acquisition */
public class InvoicesStyleAssociation extends StyleAssociation<InvoicesStyleRenderer, InvoicesSnippetCreator> {
    @Inject
    public InvoicesStyleAssociation(Lazy<InvoicesStyleRenderer> lazy, Lazy<InvoicesSnippetCreator> lazy2) {
        super(GraphQLStoryAttachmentStyle.TRANSACTION_INVOICE, lazy, lazy2);
    }
}
