package com.facebook.messaging.inbox2.mrt;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;

/* compiled from: send_join_request_to_group */
public class MessageRequestThreadsInboxItem extends InboxUnitItem {
    private final InboxMessageRequestThreadsViewData f2855f;

    public MessageRequestThreadsInboxItem(NodesModel nodesModel, InboxMessageRequestThreadsViewData inboxMessageRequestThreadsViewData) {
        super(nodesModel);
        this.f2855f = inboxMessageRequestThreadsViewData;
    }

    public final InboxItemType m2812a() {
        return InboxItemType.V2_MESSAGE_REQUEST_THREADS;
    }

    public final InboxItemViewType m2813b() {
        return InboxItemViewType.V2_MESSAGE_REQUEST_THREADS;
    }

    public final String m2814d() {
        return "tap_mrt";
    }

    public final boolean m2815e() {
        return true;
    }
}
