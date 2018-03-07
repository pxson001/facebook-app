package com.facebook.messaging.inbox2.announcements;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel.MessengerInboxUnitItemsModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;

/* compiled from: settings/tor */
public class InboxAnnouncementItem extends InboxUnitItem {
    public InboxAnnouncementItem(NodesModel nodesModel, MessengerInboxUnitItemsModel messengerInboxUnitItemsModel) {
        super(nodesModel, messengerInboxUnitItemsModel);
    }

    public final InboxItemType m2627a() {
        return InboxItemType.V2_ANNOUNCEMENT;
    }

    public final InboxItemViewType m2628b() {
        return InboxItemViewType.V2_ANNOUNCEMENT;
    }

    public final String m2629d() {
        return "tap_inbox_announcement";
    }

    public final boolean m2630e() {
        return false;
    }
}
