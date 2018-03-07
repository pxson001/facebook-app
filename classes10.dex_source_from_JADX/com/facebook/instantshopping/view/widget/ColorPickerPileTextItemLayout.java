package com.facebook.instantshopping.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

/* compiled from: SHRUNK */
public class ColorPickerPileTextItemLayout extends FrameLayout {
    private TextView f23871a;

    public ColorPickerPileTextItemLayout(Context context) {
        super(context);
    }

    public ColorPickerPileTextItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ColorPickerPileTextItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void m25149a() {
        this.f23871a = (TextView) findViewById(2131563237);
    }

    public void setMoreText(String str) {
        this.f23871a.setText(str);
    }
}
