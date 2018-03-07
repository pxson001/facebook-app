package com.facebook.messaging.business.commerceui.views.xma;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import com.facebook.messaging.xma.StyleAssociation;
import com.facebook.messaging.xma.StyleRenderer;

/* compiled from: notification_placeholder_token */
public abstract class CommerceBubbleAgentItemSuggestionStyleAssociation<SR extends StyleRenderer> extends StyleAssociation<SR, CommerceBubbleAgentItemSuggestionSnippetCreator> {
    public CommerceBubbleAgentItemSuggestionStyleAssociation(Lazy<SR> lazy, Lazy<CommerceBubbleAgentItemSuggestionSnippetCreator> lazy2) {
        super(GraphQLStoryAttachmentStyle.RETAIL_AGENT_ITEM_SUGGESTION, lazy, lazy2);
    }
}
