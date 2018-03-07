package com.facebook.fig.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.CallSuper;
import android.support.annotation.StyleRes;
import android.support.annotation.StyleableRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.SparseIntArray;
import android.view.View.MeasureSpec;
import com.facebook.R;
import com.facebook.fig.common.ViewUtils;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: mediaAttachmentIds */
public class FigToggleButton extends FigBaseToggleButton {
    private static SparseIntArray f10477a;
    private int f10478b;
    private int f10479c;
    private Drawable f10480d;
    private int f10481e;
    private ColorStateList f10482f;
    private int f10483g;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: mediaAttachmentIds */
    public @interface FigToggleButtonType {
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f10477a = sparseIntArray;
        sparseIntArray.append(1, 2131624573);
        f10477a.append(2, 2131624574);
        f10477a.append(4, 2131624575);
        f10477a.append(16, 2131624577);
        f10477a.append(32, 2131624578);
    }

    public FigToggleButton(Context context) {
        super(context);
        if (null != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.FigToggleButton, 0, 0);
            if (obtainStyledAttributes.hasValue(0)) {
                setGlyph(obtainStyledAttributes.getDrawable(0));
            }
            obtainStyledAttributes.recycle();
        }
    }

    public int getType() {
        return this.f10479c;
    }

    public void setType(int i) {
        this.f10458a = false;
        m16651b(i);
        this.f10479c = i;
        m16650a(f10477a.get(i & 15, -1), R.styleable.FigToggleButtonAttrs);
        m16650a(f10477a.get(i & 4080, -1), R.styleable.FigToggleButtonAttrs);
        invalidate();
        requestLayout();
        this.f10458a = true;
    }

    private void m16651b(int i) {
        Object obj;
        switch (i) {
            case 17:
            case 18:
            case 20:
            case 33:
                obj = 1;
                break;
            default:
                obj = null;
                break;
        }
        if (obj == null) {
            throw new IllegalStateException(String.format("%s doesn't support the supplied type: 0x%X", new Object[]{getClass().getSimpleName(), Integer.valueOf(i)}));
        }
    }

    @CallSuper
    private void m16650a(@StyleRes int i, @StyleableRes int[] iArr) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, iArr);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 3) {
                this.f10478b = obtainStyledAttributes.getDimensionPixelSize(index, -1);
            } else if (index == 0) {
                ViewUtils.m16664a(this, obtainStyledAttributes.getDrawable(index));
            } else if (index == 2) {
                this.f10481e = obtainStyledAttributes.getDimensionPixelSize(index, -1);
            } else if (index == 1) {
                this.f10482f = obtainStyledAttributes.getColorStateList(index);
            }
        }
        obtainStyledAttributes.recycle();
        this.f10483g = (this.f10478b - this.f10481e) >> 1;
    }

    public void setGlyph(int i) {
        setGlyph(ContextCompat.a(getContext(), i));
    }

    public void setGlyph(Drawable drawable) {
        this.f10480d = null;
        if (drawable != null) {
            this.f10480d = DrawableCompat.c(drawable.mutate());
            this.f10480d.setBounds(this.f10483g, this.f10483g, this.f10483g + this.f10481e, this.f10483g + this.f10481e);
            DrawableCompat.a(this.f10480d, this.f10482f);
            this.f10480d.setState(getDrawableState());
        }
    }

    protected void onMeasure(int i, int i2) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2034707551);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f10478b, 1073741824);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1863364067, a);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f10480d != null) {
            this.f10480d.draw(canvas);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f10480d != null) {
            this.f10480d.setState(getDrawableState());
        }
    }
}
