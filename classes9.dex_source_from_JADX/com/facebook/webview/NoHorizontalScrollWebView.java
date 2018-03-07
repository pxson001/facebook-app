package com.facebook.webview;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.fbui.draggable.Direction;
import com.facebook.fbui.draggable.HorizontalScrollAwareView;

/* compiled from: shipping_option_id */
public class NoHorizontalScrollWebView extends BasicWebView implements HorizontalScrollAwareView {
    public NoHorizontalScrollWebView(Context context) {
        this(context, null);
    }

    public NoHorizontalScrollWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoHorizontalScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final boolean m3328a(Direction direction, int i, int i2) {
        return false;
    }
}
