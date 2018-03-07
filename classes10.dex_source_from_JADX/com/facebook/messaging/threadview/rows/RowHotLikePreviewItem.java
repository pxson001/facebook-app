package com.facebook.messaging.threadview.rows;

/* compiled from: pma_installed_old */
public class RowHotLikePreviewItem implements RowItem {
    public final String f4731a;

    public RowHotLikePreviewItem(String str) {
        this.f4731a = str;
    }

    public final RowType mo131b() {
        return RowType.HOT_LIKE_PREVIEW;
    }

    public final long m4295a() {
        return Long.MIN_VALUE;
    }

    public String toString() {
        return "RowHotLikePreviewItem{offlineThreadingId=" + this.f4731a + '}';
    }
}
