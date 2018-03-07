package com.facebook.messaging.threadview.rows;

import com.facebook.messaging.model.threadkey.ThreadKey;

/* compiled from: platform_webview_manifest_refresh_succeeded */
public class RowThemePickerItem implements RowItem {
    public final ThreadKey f4772a;

    public RowThemePickerItem(ThreadKey threadKey) {
        this.f4772a = threadKey;
    }

    public final RowType mo131b() {
        return RowType.THEME_PICKER;
    }

    public final long m4327a() {
        return Long.MIN_VALUE;
    }
}
