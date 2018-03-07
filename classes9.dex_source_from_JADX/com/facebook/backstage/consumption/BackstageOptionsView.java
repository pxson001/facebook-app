package com.facebook.backstage.consumption;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.fbui.glyph.GlyphView;

/* compiled from: savedTag */
public class BackstageOptionsView extends GlyphView {
    public BackstageOptionsView(Context context) {
        this(context, null);
    }

    public BackstageOptionsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BackstageOptionsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setGlyphColor(getResources().getColor(17170443));
    }
}
