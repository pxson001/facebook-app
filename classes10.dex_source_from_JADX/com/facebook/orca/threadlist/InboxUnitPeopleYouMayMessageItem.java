package com.facebook.orca.threadlist;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxItem;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.facebook.messaging.peopleyoumaymessage.PeopleYouMayMessageViewData;

/* compiled from: ndt_no_thread_exists_locally */
public class InboxUnitPeopleYouMayMessageItem extends InboxUnitItem implements InboxItem {
    public final PeopleYouMayMessageViewData f6489f;

    InboxUnitPeopleYouMayMessageItem(NodesModel nodesModel, PeopleYouMayMessageViewData peopleYouMayMessageViewData) {
        super(nodesModel);
        this.f6489f = peopleYouMayMessageViewData;
    }

    public final InboxItemType m6185a() {
        return InboxItemType.V2_PEOPLE_YOU_MAY_MESSAGE;
    }

    public final InboxItemViewType m6186b() {
        return InboxItemViewType.V2_PEOPLE_YOU_MAY_MESSAGE;
    }

    public final String m6187d() {
        return "tap_pymm";
    }

    public final boolean m6188e() {
        return false;
    }
}
