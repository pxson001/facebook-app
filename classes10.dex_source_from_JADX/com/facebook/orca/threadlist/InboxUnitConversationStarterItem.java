package com.facebook.orca.threadlist;

import com.facebook.messaging.conversationstarters.graphql.ConversationStartersQueryInterfaces.ConversationStartersFields;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel.MessengerInboxUnitItemsModel;
import com.facebook.messaging.inbox2.items.InboxItem;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;

/* compiled from: ndt_push_process_immediate */
public class InboxUnitConversationStarterItem extends InboxUnitItem implements InboxItem {
    public final ConversationStartersFields f6486f;

    InboxUnitConversationStarterItem(NodesModel nodesModel, MessengerInboxUnitItemsModel messengerInboxUnitItemsModel, ConversationStartersFields conversationStartersFields) {
        super(nodesModel, messengerInboxUnitItemsModel);
        this.f6486f = conversationStartersFields;
    }

    public final InboxItemType m6172a() {
        return InboxItemType.V2_CONVERSATION_STARTER;
    }

    public final InboxItemViewType m6173b() {
        return InboxItemViewType.V2_CONVERSATION_STARTER;
    }

    public final String m6174d() {
        return "tap_conversation_starter";
    }

    public final String m6176l() {
        return this.f6486f.lK_().a();
    }

    public final boolean m6175e() {
        return true;
    }
}
