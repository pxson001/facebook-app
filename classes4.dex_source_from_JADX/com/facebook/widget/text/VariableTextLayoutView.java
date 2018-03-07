package com.facebook.widget.text;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.typeface.TypefaceUtil;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: temperature */
public abstract class VariableTextLayoutView<T> extends View {
    private static final Class<?> f1248a = VariableTextLayoutView.class;
    private LruCache<Integer, Layout> f1249b;
    public T f1250c;
    private ColorStateList f1251d;
    public int f1252e;
    public int f1253f;
    public Typeface f1254g;
    public int f1255h;
    private Alignment f1256i;
    public CenterAlignmentFavoredEdge f1257j;
    private int f1258k;
    public float f1259l;
    public float f1260m;
    public float f1261n;
    public int f1262o;
    public List<TextPaint> f1263p;
    public Layout f1264q;
    private Drawable f1265r;
    private Drawable f1266s;
    private Rect f1267t;
    public int f1268u;
    public OnPreDrawListener f1269v;

    @Nullable
    protected abstract CharSequence m1509a(T t);

    protected abstract VariableTextLayoutComputer<T> getVariableTextLayoutComputer();

    public VariableTextLayoutView(Context context) {
        this(context, null, 0);
    }

    public VariableTextLayoutView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VariableTextLayoutView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1249b = new LruCache(3);
        this.f1254g = Typeface.SANS_SERIF;
        this.f1255h = 1;
        this.f1268u = 0;
        this.f1269v = new 1(this);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VariableTextLayoutView);
        this.f1251d = obtainStyledAttributes.getColorStateList(1);
        if (this.f1251d == null) {
            this.f1251d = ColorStateList.valueOf(Color.rgb(0, 0, 0));
        }
        this.f1252e = obtainStyledAttributes.getInteger(5, 14);
        this.f1253f = obtainStyledAttributes.getInteger(6, 18);
        this.f1256i = m1500a(obtainStyledAttributes.getInteger(7, 2));
        this.f1257j = m1502b(obtainStyledAttributes.getInteger(8, 0));
        this.f1258k = obtainStyledAttributes.getInteger(2, 2);
        int integer = obtainStyledAttributes.getInteger(4, 0);
        Typeface typeface = null;
        switch (obtainStyledAttributes.getInt(3, -1)) {
            case 1:
                typeface = Typeface.SANS_SERIF;
                break;
            case 2:
                typeface = Typeface.SERIF;
                break;
            case 3:
                typeface = Typeface.MONOSPACE;
                break;
        }
        m1510a(typeface, integer);
        Typeface typeface2 = this.f1254g;
        Typeface a = CustomFontHelper.a(context, FontFamily.fromIndex(obtainStyledAttributes.getInt(0, 0)), FontWeight.BUILTIN, typeface2);
        if (typeface2 != a) {
            m1510a(a, 0);
        }
        obtainStyledAttributes.recycle();
        if (this.f1253f < this.f1252e) {
            throw new IllegalArgumentException("Invalid text sizes");
        }
    }

    private static Alignment m1500a(int i) {
        switch (i) {
            case 0:
                return Alignment.ALIGN_NORMAL;
            case 1:
                return Alignment.ALIGN_OPPOSITE;
            case 2:
                return Alignment.ALIGN_CENTER;
            default:
                throw new IllegalArgumentException("Invalid alignment: " + i);
        }
    }

    private static CenterAlignmentFavoredEdge m1502b(int i) {
        switch (i) {
            case 0:
                return CenterAlignmentFavoredEdge.LEADING;
            case 1:
                return CenterAlignmentFavoredEdge.TRAILING;
            default:
                throw new IllegalArgumentException("Invalid alignment: " + i);
        }
    }

    public int getTextColor() {
        return this.f1251d.getColorForState(getDrawableState(), this.f1251d.getDefaultColor());
    }

    public void setTextColor(int i) {
        setTextColor(ColorStateList.valueOf(i));
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f1251d = colorStateList;
        m1503c();
    }

    public float getMinScaledTextSize() {
        return (float) this.f1252e;
    }

    public float getMaxScaledTextSize() {
        return (float) this.f1253f;
    }

    public final void m1510a(@Nullable Typeface typeface, int i) {
        this.f1254g = TypefaceUtil.a(typeface, i);
        this.f1255h = i;
        m1504d();
        invalidate();
    }

    public void setData(T t) {
        this.f1250c = t;
        if (t != null) {
            setContentDescription(m1509a((Object) t));
        } else {
            setContentDescription(null);
        }
        m1504d();
        invalidate();
    }

    public Alignment getAlignment() {
        return this.f1256i;
    }

    public void setAlignment(Alignment alignment) {
        this.f1256i = alignment;
        m1504d();
        invalidate();
    }

    public int getBaseline() {
        if (this.f1264q == null) {
            return super.getBaseline();
        }
        return getPaddingTop() + this.f1264q.getLineBaseline(0);
    }

    public int getMaxLines() {
        return this.f1258k;
    }

    public void setMaxLines(int i) {
        this.f1258k = i;
        m1504d();
        invalidate();
    }

    public void setRightDrawable(Drawable drawable) {
        if (this.f1266s != drawable) {
            this.f1266s = drawable;
            requestLayout();
        }
    }

    public void setLeftDrawable(Drawable drawable) {
        if (this.f1265r != drawable) {
            this.f1265r = drawable;
            requestLayout();
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 493725013);
        super.onSizeChanged(i, i2, i3, i4);
        m1504d();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1185364960, a);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1251d != null) {
            m1503c();
        }
    }

    private void m1503c() {
        if (this.f1263p != null) {
            int textColor = getTextColor();
            for (TextPaint textPaint : this.f1263p) {
                if (textColor != textPaint.getColor()) {
                    textPaint.setColor(textColor);
                    invalidate();
                }
            }
        }
    }

    private void m1504d() {
        this.f1263p = null;
        this.f1264q = null;
        this.f1249b.a();
        requestLayout();
        invalidate();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null) {
            if (this.f1268u == 0) {
                viewTreeObserver.addOnPreDrawListener(this.f1269v);
                this.f1268u = 1;
            } else if (this.f1268u == 2) {
                this.f1268u = 1;
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        TracerDetour.a("VariableTextLayoutView.onMeasure", 415908016);
        try {
            m1508i();
            int defaultSize = View.getDefaultSize(16384, i);
            Layout layout = (Layout) this.f1249b.a(Integer.valueOf(defaultSize));
            if (layout == null) {
                layout = m1505e(((defaultSize - (getPaddingLeft() + getPaddingRight())) - m1498a(this.f1265r)) - m1498a(this.f1266s));
                this.f1249b.a(Integer.valueOf(defaultSize), layout);
            }
            defaultSize = m1499a(layout, i);
            int b = m1501b(layout, i2);
            this.f1264q = layout;
            if (this.f1265r != null) {
                if (this.f1267t == null) {
                    this.f1267t = new Rect();
                }
                this.f1265r.copyBounds(this.f1267t);
                this.f1267t.offsetTo(getPaddingLeft(), getBaseline() - this.f1267t.height());
                this.f1265r.setBounds(this.f1267t);
            }
            if (this.f1266s != null) {
                if (this.f1267t == null) {
                    this.f1267t = new Rect();
                }
                this.f1266s.copyBounds(this.f1267t);
                this.f1267t.offsetTo(m1498a(this.f1265r) + (getPaddingLeft() + ((int) Math.ceil((double) this.f1264q.getLineWidth(0)))), getBaseline() - this.f1267t.height());
                this.f1266s.setBounds(this.f1267t);
            }
            setMeasuredDimension(defaultSize, b);
        } finally {
            TracerDetour.a(-234341326);
        }
    }

    private int m1499a(Layout layout, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < layout.getLineCount()) {
            i3 = Math.max(i3, (int) Math.ceil((double) layout.getLineWidth(i2)));
            i2++;
        }
        i2 = Math.max((((getPaddingLeft() + getPaddingRight()) + m1498a(this.f1265r)) + m1498a(this.f1266s)) + i3, getSuggestedMinimumWidth());
        int mode = MeasureSpec.getMode(i);
        i3 = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i2, i3);
            case 0:
                return i2;
            default:
                return i3;
        }
    }

    private int m1501b(Layout layout, int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int max = Math.max(getSuggestedMinimumHeight(), (layout.getHeight() + getPaddingBottom()) + getPaddingTop());
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(max, size);
            case 0:
                return max;
            default:
                return size;
        }
    }

    private Layout m1505e(int i) {
        return getVariableTextLayoutComputer().a(this.f1250c, this.f1263p, i, this.f1256i, this.f1258k, -1);
    }

    protected void onDraw(Canvas canvas) {
        float max;
        super.onDraw(canvas);
        m1508i();
        m1507h();
        canvas.save();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int height = (getHeight() - paddingBottom) - paddingTop;
        int height2 = this.f1264q.getHeight() - height;
        float paddingLeft = (float) (getPaddingLeft() + scrollX);
        float f = scrollY == 0 ? 0.0f : (float) (paddingTop + scrollY);
        float width = (float) ((getWidth() - paddingRight) + scrollX);
        scrollX = getHeight() + scrollY;
        if (scrollY == height2) {
            paddingBottom = 0;
        }
        float f2 = (float) (scrollX - paddingBottom);
        if (this.f1259l != 0.0f) {
            float min = Math.min(0.0f, this.f1260m - this.f1259l) + paddingLeft;
            paddingLeft = Math.min(0.0f, this.f1261n - this.f1259l) + f;
            f = Math.max(0.0f, this.f1261n + this.f1259l) + f2;
            max = width + Math.max(0.0f, this.f1260m + this.f1259l);
            f2 = paddingLeft;
            width = min;
        } else {
            max = width;
            width = paddingLeft;
            float f3 = f;
            f = f2;
            f2 = f3;
        }
        canvas.clipRect(width, f2, max, f);
        canvas.translate((float) (getPaddingLeft() + m1498a(this.f1265r)), (float) ((Math.max(0, height - this.f1264q.getHeight()) / 2) + paddingTop));
        this.f1264q.draw(canvas);
        canvas.restore();
        if (this.f1265r != null) {
            this.f1265r.draw(canvas);
        }
        if (this.f1266s != null) {
            this.f1266s.draw(canvas);
        }
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 17822568);
        super.onDetachedFromWindow();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!(viewTreeObserver == null || this.f1268u == 0)) {
            viewTreeObserver.removeOnPreDrawListener(this.f1269v);
            this.f1268u = 0;
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1061128508, a);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m1506f(com.facebook.widget.text.VariableTextLayoutView r10) {
        /*
        r0 = 1;
        r1 = r10.f1268u;
        if (r1 == r0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        r10.m1508i();
        r10.m1507h();
        r4 = 0;
        r3 = r10.f1264q;
        r3 = r3.getParagraphAlignment(r4);
        r5 = r10.f1264q;
        r5 = r5.getParagraphDirection(r4);
        r6 = r10.getWidth();
        r7 = r10.getPaddingLeft();
        r8 = r10.getPaddingRight();
        r7 = r7 + r8;
        r6 = r6 - r7;
        r7 = android.text.Layout.Alignment.ALIGN_CENTER;
        if (r3 != r7) goto L_0x0071;
    L_0x002b:
        r3 = r10.f1264q;
        r3 = r3.getLineLeft(r4);
        r7 = (double) r3;
        r7 = java.lang.Math.floor(r7);
        r3 = (int) r7;
        r7 = r10.f1264q;
        r7 = r7.getLineRight(r4);
        r7 = (double) r7;
        r7 = java.lang.Math.ceil(r7);
        r7 = (int) r7;
        r8 = r7 - r3;
        if (r8 >= r6) goto L_0x0063;
    L_0x0047:
        r3 = r3 + r7;
        r3 = r3 / 2;
        r5 = r6 / 2;
        r3 = r3 - r5;
    L_0x004d:
        r5 = r10.getScrollX();
        if (r3 == r5) goto L_0x00a1;
    L_0x0053:
        r4 = r10.getScrollY();
        r10.scrollTo(r3, r4);
        r3 = 1;
    L_0x005b:
        r1 = r3;
        r2 = 2;
        r10.f1268u = r2;
        if (r1 == 0) goto L_0x0005;
    L_0x0061:
        r0 = 0;
        goto L_0x0005;
    L_0x0063:
        r8 = r10.f1257j;
        r9 = com.facebook.widget.text.VariableTextLayoutView.CenterAlignmentFavoredEdge.LEADING;
        if (r8 != r9) goto L_0x006e;
    L_0x0069:
        if (r5 >= 0) goto L_0x004d;
    L_0x006b:
        r3 = r7 - r6;
        goto L_0x004d;
    L_0x006e:
        if (r5 >= 0) goto L_0x006b;
    L_0x0070:
        goto L_0x004d;
    L_0x0071:
        r7 = android.text.Layout.Alignment.ALIGN_NORMAL;
        if (r3 != r7) goto L_0x0084;
    L_0x0075:
        if (r5 < 0) goto L_0x0093;
    L_0x0077:
        r3 = r10.f1264q;
        r3 = r3.getLineLeft(r4);
        r5 = (double) r3;
        r5 = java.lang.Math.floor(r5);
        r3 = (int) r5;
        goto L_0x004d;
    L_0x0084:
        if (r5 >= 0) goto L_0x0093;
    L_0x0086:
        r3 = r10.f1264q;
        r3 = r3.getLineLeft(r4);
        r5 = (double) r3;
        r5 = java.lang.Math.floor(r5);
        r3 = (int) r5;
        goto L_0x004d;
    L_0x0093:
        r3 = r10.f1264q;
        r3 = r3.getLineRight(r4);
        r7 = (double) r3;
        r7 = java.lang.Math.ceil(r7);
        r3 = (int) r7;
        r3 = r3 - r6;
        goto L_0x004d;
    L_0x00a1:
        r3 = r4;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.widget.text.VariableTextLayoutView.f(com.facebook.widget.text.VariableTextLayoutView):boolean");
    }

    protected boolean isPaddingOffsetRequired() {
        return this.f1259l != 0.0f;
    }

    protected int getLeftPaddingOffset() {
        return (int) Math.min(0.0f, this.f1260m - this.f1259l);
    }

    protected int getTopPaddingOffset() {
        return (int) Math.min(0.0f, this.f1261n - this.f1259l);
    }

    protected int getBottomPaddingOffset() {
        return (int) Math.max(0.0f, this.f1261n + this.f1259l);
    }

    protected int getRightPaddingOffset() {
        return (int) Math.max(0.0f, this.f1260m + this.f1259l);
    }

    private void m1507h() {
        if (this.f1264q == null) {
            this.f1264q = getVariableTextLayoutComputer().a(this.f1250c, this.f1263p, (((getWidth() - getPaddingLeft()) - getPaddingRight()) - m1498a(this.f1265r)) - m1498a(this.f1266s), this.f1256i, this.f1258k, getHeight());
        }
    }

    private static int m1498a(@Nullable Drawable drawable) {
        return drawable == null ? 0 : drawable.getBounds().width();
    }

    private void m1508i() {
        if (this.f1263p == null) {
            this.f1263p = Lists.a();
            for (int i = this.f1253f; i >= this.f1252e; i--) {
                float f;
                List list = this.f1263p;
                TextPaint textPaint = new TextPaint(1);
                textPaint.density = getResources().getDisplayMetrics().density;
                if (i == -1) {
                    f = -1.0f;
                } else {
                    f = TypedValue.applyDimension(2, (float) i, getResources().getDisplayMetrics());
                }
                textPaint.setTextSize(f);
                textPaint.setColor(getTextColor());
                if (this.f1259l != 0.0f) {
                    textPaint.setShadowLayer(this.f1259l, this.f1260m, this.f1261n, this.f1262o);
                }
                TypefaceUtil.a(textPaint, this.f1254g, this.f1255h);
                list.add(textPaint);
            }
        }
    }

    public CharSequence getContentDescription() {
        if (this.f1264q == null || this.f1264q.getText() == null || this.f1264q.getText().length() <= 0) {
            return super.getContentDescription();
        }
        return this.f1264q.getText();
    }
}
