package com.facebook.messaging.peopleyoumaymessage;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel.MessengerInboxUnitItemsModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;

/* compiled from: renderTimelineHeaderView */
public class InboxUnitPeopleYouMayMessageUserItem extends InboxUnitItem {
    public InboxUnitPeopleYouMayMessageUserItem(NodesModel nodesModel, MessengerInboxUnitItemsModel messengerInboxUnitItemsModel) {
        super(nodesModel, messengerInboxUnitItemsModel);
    }

    public final InboxItemType m3349a() {
        return InboxItemType.V2_PEOPLE_YOU_MAY_MESSAGE_USER;
    }

    public final InboxItemViewType m3350b() {
        return InboxItemViewType.V2_PEOPLE_YOU_MAY_MESSAGE_USER;
    }

    public final String m3351d() {
        return "tap_pymm";
    }

    public final boolean m3352e() {
        return false;
    }

    public final String m3353l() {
        return this.e.k().t().l().s_();
    }
}
