package com.facebook.messaging.business.commerceui.views.xma;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import com.facebook.messaging.xma.StyleAssociation;
import javax.inject.Inject;

/* compiled from: notification_expanded */
public class CommerceBubbleCancellationStyleAssociation extends StyleAssociation<CommerceBubbleReceiptAndCancellationStyleRenderer, CommerceBubbleCancellationSnippetCreator> {
    @Inject
    public CommerceBubbleCancellationStyleAssociation(Lazy<CommerceBubbleReceiptAndCancellationStyleRenderer> lazy, Lazy<CommerceBubbleCancellationSnippetCreator> lazy2) {
        super(GraphQLStoryAttachmentStyle.RETAIL_CANCELLATION, lazy, lazy2);
    }
}
