package com.facebook.messaging.inbox2.announcements;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;

/* compiled from: set_theme */
public class InboxAnnouncementUnitItem extends InboxUnitItem {
    public final InboxAnnouncementData f2666f;

    public InboxAnnouncementUnitItem(NodesModel nodesModel, InboxAnnouncementData inboxAnnouncementData) {
        super(nodesModel);
        this.f2666f = inboxAnnouncementData;
    }

    public final InboxItemType m2631a() {
        return InboxItemType.V2_ANNOUNCEMENT;
    }

    public final InboxItemViewType m2632b() {
        return InboxItemViewType.V2_ANNOUNCEMENT;
    }

    public final String m2633d() {
        return "tap_inbox_announcement";
    }

    public final boolean m2634e() {
        return false;
    }
}
