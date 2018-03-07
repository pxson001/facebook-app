package com.facebook.fbui.glyph;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.R;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.FbImageView;
import javax.inject.Inject;

/* compiled from: resume_upload */
public class GlyphView extends FbImageView {
    @Inject
    GlyphColorizer f6742a;
    private ColorStateList f6743b;

    private static <T extends View> void m11483a(Class<T> cls, T t) {
        m11484a((Object) t, t.getContext());
    }

    private static void m11484a(Object obj, Context context) {
        ((GlyphView) obj).m11485a(GlyphColorizer.m11486a(FbInjector.get(context)));
    }

    public GlyphView(Context context) {
        this(context, null);
    }

    public GlyphView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GlyphView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        m11483a(GlyphView.class, (View) this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GlyphColorizer, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId > 0) {
            if (getDrawable() != null) {
                throw new RuntimeException("XML should not specify both android:src and fb:source. Please only use fb:source");
            }
            setImageDrawable(context.getResources().getDrawable(resourceId));
        }
        if (obtainStyledAttributes.hasValue(0)) {
            setGlyphColor(obtainStyledAttributes.getColorStateList(0));
        }
        obtainStyledAttributes.recycle();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f6743b != null) {
            setColorFilter(this.f6742a.m11488a(this.f6743b.getColorForState(getDrawableState(), 0)));
            return;
        }
        setColorFilter(null);
    }

    public ColorStateList getGlyphColor() {
        return this.f6743b;
    }

    public void setGlyphColor(int i) {
        setGlyphColor(ColorStateList.valueOf(i));
    }

    public void setGlyphColor(ColorStateList colorStateList) {
        this.f6743b = colorStateList;
        refreshDrawableState();
        invalidate();
    }

    void m11485a(GlyphColorizer glyphColorizer) {
        this.f6742a = glyphColorizer;
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setVisible(false, false);
        }
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setVisible(true, false);
        }
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1419832839);
        super.onDetachedFromWindow();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setVisible(false, false);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 154825012, a);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 867731516);
        super.onAttachedToWindow();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setVisible(true, false);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -622987359, a);
    }
}
