package com.facebook.fig.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.CallSuper;
import android.support.annotation.StyleRes;
import android.support.annotation.StyleableRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.SparseIntArray;
import android.widget.TextView.BufferType;
import com.facebook.R;
import com.facebook.fig.common.ViewUtils;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: mediaItems metadata needs to of same length as mediaItems */
public class FigGlyphButton extends FigBaseButton {
    private static SparseIntArray f10472a;
    private int f10473b;
    private int f10474c;
    private int f10475d;
    private ColorStateList f10476e;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: mediaItems metadata needs to of same length as mediaItems */
    public @interface FigGlyphButtonType {
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f10472a = sparseIntArray;
        sparseIntArray.append(2, 2131624569);
        f10472a.append(32, 2131624571);
    }

    public int getType() {
        return this.f10473b;
    }

    public void setType(int i) {
        this.f10457a = false;
        m16647b(i);
        this.f10473b = i;
        m16646a(f10472a.get(i & 15, -1), R.styleable.FigGlyphButtonAttrs);
        m16646a(f10472a.get(i & 4080, -1), R.styleable.FigGlyphButtonAttrs);
        int i2 = (this.f10474c - this.f10475d) >> 1;
        setPadding(i2, i2, i2, i2);
        this.f10457a = true;
    }

    private void m16647b(int i) {
        Object obj;
        if (i == 34) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            throw new IllegalStateException(String.format("%s doesn't support the supplied type: 0x%X", new Object[]{getClass().getSimpleName(), Integer.valueOf(i)}));
        }
    }

    @CallSuper
    private void m16646a(@StyleRes int i, @StyleableRes int[] iArr) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, iArr);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 3) {
                this.f10474c = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == 0) {
                ViewUtils.m16664a(this, obtainStyledAttributes.getDrawable(index));
            } else if (index == 2) {
                this.f10475d = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == 1) {
                this.f10476e = obtainStyledAttributes.getColorStateList(index);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public void setGlyph(int i) {
        setGlyph(ContextCompat.a(getContext(), i));
    }

    public void setGlyph(Drawable drawable) {
        this.f10457a = false;
        if (drawable != null) {
            drawable = DrawableCompat.c(drawable.mutate());
            drawable.setBounds(0, 0, this.f10475d, this.f10475d);
            DrawableCompat.a(drawable, this.f10476e);
            drawable.setState(getDrawableState());
        }
        setCompoundDrawables(drawable, null, null, null);
        this.f10457a = true;
    }

    private boolean m16648b() {
        return getGlyph() != null;
    }

    private Drawable getGlyph() {
        return getCompoundDrawables()[0];
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText("", bufferType);
    }

    protected void onMeasure(int i, int i2) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1171233151);
        super.onMeasure(i, i2);
        setMeasuredDimension(this.f10474c, this.f10474c);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -582658726, a);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (m16648b()) {
            getGlyph().setState(getDrawableState());
        }
    }

    final boolean mo1047a() {
        return false;
    }
}
