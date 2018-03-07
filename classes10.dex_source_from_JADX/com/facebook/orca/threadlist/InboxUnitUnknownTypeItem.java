package com.facebook.orca.threadlist;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;

/* compiled from: nativethirdparty */
public class InboxUnitUnknownTypeItem extends InboxUnitItem {
    public final NodesModel f6492f;

    public final InboxItemType m6196a() {
        return InboxItemType.V2_UNKNOWN_TYPE;
    }

    public final InboxItemViewType m6197b() {
        return InboxItemViewType.V2_UNKNOWN_TYPE;
    }

    public final String m6198d() {
        return null;
    }

    public final boolean m6199e() {
        return false;
    }
}
