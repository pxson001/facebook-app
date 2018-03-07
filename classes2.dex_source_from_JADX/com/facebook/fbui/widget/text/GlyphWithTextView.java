package com.facebook.fbui.widget.text;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.R;

/* compiled from: media_generic */
public class GlyphWithTextView extends ImageWithTextView {
    private static final int[] f14546a = new int[]{16842914};
    private boolean f14547b;
    private ColorStateList f14548c;

    public GlyphWithTextView(Context context) {
        this(context, null);
    }

    public GlyphWithTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GlyphWithTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GlyphColorizer, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            setGlyphColor(obtainStyledAttributes.getColorStateList(0));
        }
        obtainStyledAttributes.recycle();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f14549a != null) {
            if (this.f14548c != null) {
                this.f14549a.mutate().setColorFilter(new PorterDuffColorFilter(this.f14548c.getColorForState(getDrawableState(), 0), Mode.SRC_IN));
                return;
            }
            this.f14549a.mutate().setColorFilter(null);
        }
    }

    protected int[] onCreateDrawableState(int i) {
        if (!this.f14547b) {
            return super.onCreateDrawableState(i);
        }
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        View.mergeDrawableStates(onCreateDrawableState, f14546a);
        return onCreateDrawableState;
    }

    public void setGlyphColor(ColorStateList colorStateList) {
        this.f14548c = colorStateList;
        refreshDrawableState();
        invalidate();
    }

    public void setGlyphColor(int i) {
        setGlyphColor(ColorStateList.valueOf(i));
    }

    public void setActive(boolean z) {
        if (this.f14549a != null) {
            this.f14547b = z;
            refreshDrawableState();
            invalidate();
        }
    }
}
