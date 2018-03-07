package com.facebook.messaging.inbox2.bymm;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel.MessengerInboxUnitItemsModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;

/* compiled from: set_notif */
public class BYMMInboxUserItem extends InboxUnitItem {
    public BYMMInboxUserItem(NodesModel nodesModel, MessengerInboxUnitItemsModel messengerInboxUnitItemsModel) {
        super(nodesModel, messengerInboxUnitItemsModel);
    }

    public final InboxItemType m2641a() {
        return InboxItemType.V2_BYMM;
    }

    public final InboxItemViewType m2642b() {
        return InboxItemViewType.V2_BYMM_PAGE;
    }

    public final String m2643d() {
        return "tap_bymm";
    }

    public final boolean m2644e() {
        return false;
    }
}
