package com.facebook.messaging.inbox2.bymm;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;

/* compiled from: set_phone */
public class BYMMInboxItem extends InboxUnitItem {
    public final InboxBYMMViewData f2674f;

    public BYMMInboxItem(NodesModel nodesModel, InboxBYMMViewData inboxBYMMViewData) {
        super(nodesModel);
        this.f2674f = inboxBYMMViewData;
    }

    public final InboxItemType m2637a() {
        return InboxItemType.V2_BYMM;
    }

    public final InboxItemViewType m2638b() {
        return InboxItemViewType.V2_BYMM_PAGE;
    }

    public final String m2639d() {
        return "tap_bymm";
    }

    public final boolean m2640e() {
        return false;
    }
}
