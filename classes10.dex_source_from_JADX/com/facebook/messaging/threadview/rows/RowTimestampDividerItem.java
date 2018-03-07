package com.facebook.messaging.threadview.rows;

/* compiled from: platform_webview_finished */
public class RowTimestampDividerItem implements RowItem {
    public final long f4773a;

    public RowTimestampDividerItem(long j) {
        this.f4773a = j;
    }

    public final RowType mo131b() {
        return RowType.TIMESTAMP_DIVIDER;
    }

    public final long m4329a() {
        return Long.MIN_VALUE;
    }

    public String toString() {
        return "RowTimestampDividerItem{timestamp=" + this.f4773a + '}';
    }
}
