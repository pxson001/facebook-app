package com.facebook.messaging.inbox2.morefooter;

import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.facebook.messaging.inbox2.items.InboxUnitItem.SpecialItemType;
import com.facebook.messaging.inbox2.morefooter.InboxMoreItem.State;

/* compiled from: send_payment_message_via_graph */
public class InboxMoreThreadsItem extends InboxUnitItem implements InboxMoreItem {
    public final MoreThreadsType f2851f;
    public final String f2852g;

    /* compiled from: send_payment_message_via_graph */
    public enum MoreThreadsType {
        AUTO,
        LOAD_MORE,
        LOADING
    }

    public InboxMoreThreadsItem(NodesModel nodesModel, MoreThreadsType moreThreadsType, String str) {
        super(nodesModel, SpecialItemType.MORE_FOOTER);
        this.f2851f = moreThreadsType;
        this.f2852g = str;
    }

    public final InboxItemType m2805a() {
        return InboxItemType.V2_MORE_FOOTER;
    }

    public final InboxItemViewType m2806b() {
        return InboxItemViewType.V2_MORE_FOOTER;
    }

    public final String m2807d() {
        return "tap_load_more";
    }

    public final boolean m2808e() {
        return true;
    }

    public final State mo82m() {
        switch (this.f2851f) {
            case AUTO:
                return State.INVISIBLE;
            case LOADING:
                return State.LOADING;
            default:
                return State.LOAD_MORE;
        }
    }

    public final String mo83n() {
        return this.f2852g;
    }

    public final int mo84o() {
        return 2130841367;
    }
}
