package com.facebook.messaging.inbox2.morefooter;

import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxItemViewType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.facebook.messaging.inbox2.morefooter.InboxMoreItem.State;

/* compiled from: sender_ids */
public class InboxGenericMoreItem extends InboxUnitItem implements InboxMoreItem {
    public final String f2844f;

    public final InboxItemType m2797a() {
        return InboxItemType.V2_MORE_FOOTER;
    }

    public final InboxItemViewType m2798b() {
        return InboxItemViewType.V2_MORE_FOOTER;
    }

    public final String m2799d() {
        return "tap_load_more";
    }

    public final boolean m2800e() {
        return true;
    }

    public final State mo82m() {
        return State.LOAD_MORE;
    }

    public final String mo83n() {
        return this.f2844f;
    }

    public final int mo84o() {
        return 2130841333;
    }
}
