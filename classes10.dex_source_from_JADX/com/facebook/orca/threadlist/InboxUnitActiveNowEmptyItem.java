package com.facebook.orca.threadlist;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;

/* compiled from: nearby_friends_informational_back_out */
public class InboxUnitActiveNowEmptyItem extends InboxUnitItem {
    protected InboxUnitActiveNowEmptyItem(NodesModel nodesModel) {
        super(nodesModel);
    }

    public final InboxItemType m6157a() {
        return InboxItemType.V2_ACTIVE_NOW_EMPTY_ITEM;
    }

    public final InboxItemViewType m6158b() {
        return InboxItemViewType.V2_ACTIVE_NOW_EMPTY_ITEM;
    }

    public final String m6159d() {
        return null;
    }

    public final boolean m6160e() {
        return false;
    }
}
