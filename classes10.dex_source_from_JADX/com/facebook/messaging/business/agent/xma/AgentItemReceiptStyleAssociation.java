package com.facebook.messaging.business.agent.xma;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import com.facebook.messaging.xma.StyleAssociation;
import javax.inject.Inject;

/* compiled from: thread_settings */
public class AgentItemReceiptStyleAssociation extends StyleAssociation<AgentItemReceiptStyleRenderer, AgentItemReceiptSnippetCreator> {
    @Inject
    public AgentItemReceiptStyleAssociation(Lazy<AgentItemReceiptStyleRenderer> lazy, Lazy<AgentItemReceiptSnippetCreator> lazy2) {
        super(GraphQLStoryAttachmentStyle.RETAIL_AGENT_ITEM_RECEIPT, lazy, lazy2);
    }
}
