package com.facebook.orca.threadlist;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;

/* compiled from: nearbyFriends */
public class InboxUnitActiveNowLoadingItem extends InboxUnitItem {
    protected InboxUnitActiveNowLoadingItem(NodesModel nodesModel) {
        super(nodesModel);
    }

    public final InboxItemType m6167a() {
        return InboxItemType.V2_ACTIVE_NOW_LOADING;
    }

    public final InboxItemViewType m6168b() {
        return InboxItemViewType.V2_ACTIVE_NOW_LOADING;
    }

    public final String m6169d() {
        return null;
    }

    public final boolean m6170e() {
        return false;
    }
}
