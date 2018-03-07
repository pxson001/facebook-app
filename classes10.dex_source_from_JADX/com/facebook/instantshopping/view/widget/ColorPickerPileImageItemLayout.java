package com.facebook.instantshopping.view.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.facebook.common.callercontext.CallerContext;

/* compiled from: SINGLE_PICKER */
public class ColorPickerPileImageItemLayout extends FrameLayout {
    private static final CallerContext f23869a = CallerContext.a(ColorPickerImageItemLayout.class, "unknown");
    private PickerItemImageView f23870b;

    public ColorPickerPileImageItemLayout(Context context) {
        super(context);
    }

    public ColorPickerPileImageItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ColorPickerPileImageItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setImageUrl(String str) {
        this.f23870b.a(Uri.parse(str), f23869a);
    }

    public final void m25148a() {
        this.f23870b = (PickerItemImageView) findViewById(2131563235);
    }
}
