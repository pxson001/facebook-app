package com.facebook.messaging.threadview.rows;

/* compiled from: platform_webview_method_refresh_succeeded */
public class RowSpacerItem implements RowItem {
    public final RowItem f4771a;

    public RowSpacerItem(RowItem rowItem) {
        this.f4771a = rowItem;
    }

    public final RowType mo131b() {
        return RowType.SPACER;
    }

    public final long m4325a() {
        return Long.MIN_VALUE;
    }

    public String toString() {
        return "RowSpacerItem";
    }
}
