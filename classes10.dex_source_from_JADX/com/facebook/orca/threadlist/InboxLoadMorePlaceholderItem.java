package com.facebook.orca.threadlist;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxItem;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.facebook.messaging.inbox2.items.InboxUnitItem.SpecialItemType;

/* compiled from: nearby_friends_informational_impression */
public class InboxLoadMorePlaceholderItem extends InboxUnitItem implements InboxItem {
    public InboxLoadMorePlaceholderItem(NodesModel nodesModel) {
        super(nodesModel, SpecialItemType.MORE_FOOTER);
    }

    public final InboxItemType m6153a() {
        return InboxItemType.V2_LOAD_MORE_THREADS_PLACEHOLDER;
    }

    public final InboxItemViewType m6154b() {
        return InboxItemViewType.V2_LOAD_MORE_THREADS_PLACEHOLDER;
    }

    public final String m6155d() {
        return null;
    }

    public final boolean m6156e() {
        return true;
    }
}
