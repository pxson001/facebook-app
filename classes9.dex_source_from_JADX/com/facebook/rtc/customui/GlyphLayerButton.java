package com.facebook.rtc.customui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.facebook.R;

/* compiled from: audio/x-mpg */
public class GlyphLayerButton extends ImageButton {
    ColorStateList f19307a;
    ColorStateList f19308b;
    Drawable f19309c;
    Drawable f19310d;

    public GlyphLayerButton(Context context) {
        this(context, null);
    }

    public GlyphLayerButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GlyphLayerButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GlyphLayerButton);
        this.f19307a = obtainStyledAttributes.getColorStateList(2);
        this.f19308b = obtainStyledAttributes.getColorStateList(3);
        this.f19309c = obtainStyledAttributes.getDrawable(0);
        this.f19310d = obtainStyledAttributes.getDrawable(1);
        setImageDrawable(new GlyphLayerDrawable(new Drawable[]{this.f19310d, this.f19309c}, new ColorStateList[]{this.f19308b, this.f19307a}));
        obtainStyledAttributes.recycle();
    }
}
