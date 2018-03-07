package com.facebook.messaging.threadview.rows;

import com.facebook.messaging.model.messages.Message;

/* compiled from: pma_not_installed */
public class RowGroupCreatedItem implements RowItem {
    public final Message f4730a;

    public RowGroupCreatedItem(Message message) {
        this.f4730a = message;
    }

    public final RowType mo131b() {
        return RowType.GROUP_CREATED;
    }

    public final long m4293a() {
        return Long.MIN_VALUE;
    }
}
