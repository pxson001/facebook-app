package com.facebook.fig.textinput;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.fig.common.ViewUtils;
import com.facebook.resources.ui.FbEditText;
import javax.annotation.Nullable;

/* compiled from: analog */
public class FigEditText extends FbEditText {
    @EditTextType
    private int f19900A;
    private boolean f19901B;
    private Drawable f19902b;
    private ColorStateList f19903c;
    private ColorStateList f19904d;
    private ColorStateList f19905e;
    private Drawable f19906f;
    private ColorStateList f19907g;
    private int f19908h;
    private int f19909i;
    private int f19910j;
    private int f19911k;
    private int f19912l;
    private int f19913m;
    private int f19914n;
    private int f19915o;
    private int f19916p;
    private int f19917q;
    private int f19918r;
    private float f19919s;
    private String f19920t;
    private Paint f19921u;
    private Rect f19922v;
    private ColorStateList f19923w;
    private ColorStateList f19924x;
    private ColorStateList f19925y;
    private int f19926z;

    /* compiled from: analog */
    public @interface EditTextType {
    }

    public FigEditText(Context context) {
        super(context);
        m20098a(null);
    }

    public FigEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20098a(attributeSet);
    }

    private void m20098a(@Nullable AttributeSet attributeSet) {
        this.f19901B = !RTLUtil.a(getContext());
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.FigEditText, 0, 0);
            try {
                setType(obtainStyledAttributes.getInt(1, 0));
                setCharCountLimit(obtainStyledAttributes.getInt(3, 0));
                setGlyph(obtainStyledAttributes.getDrawable(0));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    @EditTextType
    public int getType() {
        return this.f19900A;
    }

    public void setType(@EditTextType int i) {
        this.f19900A = i;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i == 1 ? 2131626556 : 2131626555, R.styleable.FigEditTextInternal);
        try {
            setTextSize(0, obtainStyledAttributes.getDimension(0, -1.0f));
            setTextColor(obtainStyledAttributes.getColorStateList(1));
            setHintTextColor(obtainStyledAttributes.getColorStateList(2));
            this.f19907g = obtainStyledAttributes.getColorStateList(7);
            this.f19908h = obtainStyledAttributes.getDimensionPixelSize(8, 0);
            this.f19909i = obtainStyledAttributes.getDimensionPixelSize(9, 0);
            this.f19910j = obtainStyledAttributes.getDimensionPixelSize(11, 0);
            this.f19911k = obtainStyledAttributes.getDimensionPixelSize(10, 0);
            this.f19916p = obtainStyledAttributes.getDimensionPixelSize(15, 0);
            this.f19917q = obtainStyledAttributes.getDimensionPixelSize(16, 0);
            this.f19919s = obtainStyledAttributes.getDimension(14, 0.0f);
            this.f19924x = obtainStyledAttributes.getColorStateList(17);
            this.f19925y = obtainStyledAttributes.getColorStateList(18);
            this.f19912l = obtainStyledAttributes.getDimensionPixelOffset(5, 0);
            this.f19914n = obtainStyledAttributes.getDimensionPixelOffset(3, 0);
            this.f19913m = obtainStyledAttributes.getDimensionPixelOffset(6, 0);
            this.f19915o = obtainStyledAttributes.getDimensionPixelOffset(4, 0);
            this.f19904d = obtainStyledAttributes.getColorStateList(12);
            this.f19905e = obtainStyledAttributes.getColorStateList(13);
            if (i == 1) {
                this.f19902b = null;
                ViewUtils.a(this, null);
                this.f19903c = null;
            } else {
                this.f19902b = ContextCompat.a(getContext(), 2130839838);
                this.f19902b = DrawableCompat.c(this.f19902b);
                m20102e();
            }
            obtainStyledAttributes.recycle();
            m20100c();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    public Drawable getGlyph() {
        return this.f19906f;
    }

    public void setGlyph(int i) {
        setGlyph(ContextCompat.a(getContext(), i));
    }

    public void setGlyph(Drawable drawable) {
        if (this.f19906f != null) {
            this.f19906f = null;
        }
        if (drawable != null) {
            this.f19906f = DrawableCompat.c(drawable);
            DrawableCompat.a(this.f19906f, this.f19907g);
            this.f19906f.setState(getDrawableState());
        }
        m20100c();
    }

    private int m20097a() {
        if (this.f19918r <= 0) {
            return this.f19915o;
        }
        Rect a = ViewUtils.a();
        this.f19921u.getTextBounds("1", 0, 1, a);
        return (a.height() + this.f19916p) + this.f19917q;
    }

    private int m20099b() {
        return this.f19906f == null ? this.f19912l : (this.f19909i + this.f19908h) + this.f19911k;
    }

    private void m20100c() {
        int i;
        int i2;
        int b = m20099b();
        int i3 = this.f19914n;
        int i4 = this.f19913m;
        int a = m20097a();
        if (this.f19902b != null) {
            int i5;
            int i6 = this.f19901B ? b : this.f19913m;
            if (this.f19901B) {
                i5 = this.f19913m;
            } else {
                i5 = b;
            }
            ViewUtils.a(this, new InsetDrawable(this.f19902b, i6, this.f19914n, i5, a));
            Rect rect = new Rect();
            this.f19902b.getPadding(rect);
            b += this.f19901B ? rect.left : rect.right;
            i = (this.f19901B ? rect.right : rect.left) + i4;
            i2 = rect.top + i3;
            a += rect.bottom;
        } else {
            i = i4;
            i2 = i3;
        }
        ViewCompat.b(this, b, i2, i, a);
    }

    public int getCharCountLimit() {
        return this.f19918r;
    }

    public void setCharCountLimit(int i) {
        if (this.f19918r != i) {
            if (i <= 0) {
                this.f19922v.setEmpty();
            } else if (this.f19921u == null) {
                this.f19921u = new Paint(1);
                this.f19921u.setTextAlign(Align.LEFT);
                this.f19921u.setStyle(Style.FILL);
                this.f19921u.setTextSize(this.f19919s);
                this.f19922v = new Rect();
            }
            this.f19918r = i;
            m20101d();
            m20100c();
        }
    }

    private void m20101d() {
        if (this.f19918r > 0) {
            int textLength = getTextLength();
            this.f19920t = textLength + "/" + this.f19918r;
            this.f19921u.getTextBounds(this.f19920t, 0, StringLengthHelper.a(this.f19920t), this.f19922v);
            this.f19923w = textLength > this.f19918r ? this.f19925y : this.f19924x;
            m20103f();
        }
        m20102e();
    }

    private void m20102e() {
        if (this.f19902b != null) {
            ColorStateList colorStateList = (this.f19918r <= 0 || getTextLength() <= this.f19918r) ? this.f19904d : this.f19905e;
            if (this.f19903c != colorStateList) {
                this.f19903c = colorStateList;
                DrawableCompat.a(this.f19902b, this.f19903c);
            }
        }
    }

    private void m20103f() {
        if (this.f19923w != null) {
            this.f19921u.setColor(this.f19923w.getColorForState(getDrawableState(), -1));
        }
    }

    private int getTextLength() {
        CharSequence text = getText();
        return text == null ? 0 : StringLengthHelper.a(text.toString());
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        m20103f();
        if (this.f19906f != null) {
            this.f19906f.setState(getDrawableState());
        }
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        m20101d();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f19906f != null) {
            int width = this.f19901B ? this.f19909i : (getWidth() - this.f19909i) - this.f19908h;
            this.f19906f.setBounds(width, this.f19910j, this.f19908h + width, this.f19910j + this.f19908h);
        }
        if (this.f19918r > 0) {
            this.f19926z = getMeasuredHeight() - this.f19917q;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f19906f != null) {
            this.f19906f.draw(canvas);
        }
        if (this.f19918r > 0) {
            canvas.drawText(this.f19920t, (float) (this.f19901B ? (getMeasuredWidth() - ViewCompat.o(this)) - this.f19922v.width() : ViewCompat.o(this)), (float) this.f19926z, this.f19921u);
        }
    }
}
