package com.facebook.orca.threadlist;

import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.google.common.base.Charsets;
import com.google.common.hash.Hasher;

/* compiled from: nearby_friends_contacts_set_item */
public class InboxUnitActiveNowItem extends InboxUnitItem {
    public final ContactPickerUserRow f6483f;

    protected InboxUnitActiveNowItem(NodesModel nodesModel, ContactPickerUserRow contactPickerUserRow) {
        super(nodesModel);
        this.f6483f = contactPickerUserRow;
    }

    public final InboxItemType m6161a() {
        return InboxItemType.V2_ACTIVE_NOW;
    }

    public final InboxItemViewType m6162b() {
        return InboxItemViewType.V2_ACTIVE_NOW;
    }

    public final String m6163d() {
        return "tap_active_now";
    }

    protected final long m6165h() {
        Hasher a = InboxUnitItem.a.a();
        a.a(this.d.j(), Charsets.UTF_8);
        a.a(this.f6483f.a.a, Charsets.UTF_8);
        return a.a().c();
    }

    protected final String m6166j() {
        return this.d.j() + ":" + this.f6483f.a.a;
    }

    public final boolean m6164e() {
        return true;
    }
}
