package com.facebook.messaging.threadview.rows;

import com.facebook.messaging.model.threadkey.ThreadKey;

/* compiled from: popout chathead */
public class RowEmojilikePickerItem implements RowItem {
    public final ThreadKey f4727a;

    public RowEmojilikePickerItem(ThreadKey threadKey) {
        this.f4727a = threadKey;
    }

    public final RowType mo131b() {
        return RowType.EMOJILIKE_PICKER;
    }

    public final long m4289a() {
        return Long.MIN_VALUE;
    }
}
