package com.facebook.fbui.glyph;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import com.facebook.R;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: ZIP */
public class GlyphButton extends ImageButton {
    @Inject
    public GlyphColorizer f12095a;
    private ColorStateList f12096b;

    private static <T extends View> void m20126a(Class<T> cls, T t) {
        m20127a((Object) t, t.getContext());
    }

    private static void m20127a(Object obj, Context context) {
        ((GlyphButton) obj).f12095a = GlyphColorizer.a(FbInjector.get(context));
    }

    public GlyphButton(Context context) {
        this(context, null);
    }

    public GlyphButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GlyphButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20126a(GlyphButton.class, (View) this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GlyphColorizer, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            setGlyphColor(obtainStyledAttributes.getColorStateList(0));
        }
        obtainStyledAttributes.recycle();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f12096b != null) {
            setColorFilter(this.f12095a.a(this.f12096b.getColorForState(getDrawableState(), 0)));
            return;
        }
        setColorFilter(null);
    }

    public ColorStateList getGlyphColor() {
        return this.f12096b;
    }

    public void setGlyphColor(int i) {
        setGlyphColor(ColorStateList.valueOf(i));
    }

    public void setGlyphColor(ColorStateList colorStateList) {
        this.f12096b = colorStateList;
        refreshDrawableState();
        invalidate();
    }

    private void m20125a(GlyphColorizer glyphColorizer) {
        this.f12095a = glyphColorizer;
    }
}
