package com.facebook.messaging.threadview.rows;

import com.facebook.messaging.model.messages.Message;

/* compiled from: pma_version */
public class RowGloballyDeletedMessagePlaceholderItem implements RowItem {
    public final Message f4728a;
    public final RowItemGrouping f4729b;

    public RowGloballyDeletedMessagePlaceholderItem(Message message, RowItemGrouping rowItemGrouping) {
        this.f4728a = message;
        this.f4729b = rowItemGrouping;
    }

    public final RowType mo131b() {
        return RowType.GLOBALLY_DELETED_MESSAGE_PLACEHOLDER;
    }

    public final long m4291a() {
        return Long.MIN_VALUE;
    }
}
