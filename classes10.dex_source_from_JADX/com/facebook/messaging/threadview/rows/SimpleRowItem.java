package com.facebook.messaging.threadview.rows;

/* compiled from: platform_share_finished_publish */
public final class SimpleRowItem implements RowItem {
    private final RowType f4777a;
    public final RowViewType f4778b;

    public SimpleRowItem(RowType rowType, RowViewType rowViewType) {
        this.f4777a = rowType;
        this.f4778b = rowViewType;
    }

    public final RowType mo131b() {
        return this.f4777a;
    }

    public final long m4333a() {
        return Long.MIN_VALUE;
    }

    public final String toString() {
        return "SimpleRowItem{msgType=" + this.f4778b.ordinal() + '}';
    }
}
