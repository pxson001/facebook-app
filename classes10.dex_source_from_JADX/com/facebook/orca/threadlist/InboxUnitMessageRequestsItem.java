package com.facebook.orca.threadlist;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.facebook.messaging.messagerequests.snippet.MessageRequestsSnippet;

/* compiled from: ndt_push_process_delayed */
public class InboxUnitMessageRequestsItem extends InboxUnitItem {
    public final MessageRequestsSnippet f6487f;

    public InboxUnitMessageRequestsItem(NodesModel nodesModel, MessageRequestsSnippet messageRequestsSnippet) {
        super(nodesModel);
        this.f6487f = messageRequestsSnippet;
    }

    public final InboxItemType m6177a() {
        return InboxItemType.V2_MESSAGE_REQUEST_HEADER;
    }

    public final InboxItemViewType m6178b() {
        return InboxItemViewType.V2_MESSAGE_REQUEST_HEADER;
    }

    public final String m6179d() {
        return "tap_message_request";
    }

    public final boolean m6180e() {
        return true;
    }
}
