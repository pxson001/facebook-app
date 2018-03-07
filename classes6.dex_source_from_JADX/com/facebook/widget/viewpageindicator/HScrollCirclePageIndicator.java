package com.facebook.widget.viewpageindicator;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import com.facebook.R;

/* compiled from: com.facebook.platform.extra.TITLE */
public class HScrollCirclePageIndicator extends View {
    public float f20179a;
    private final Paint f20180b;
    private final Paint f20181c;
    private final Paint f20182d;
    public final Paint f20183e;
    private int f20184f;
    private int f20185g;
    private float f20186h;
    private int f20187i;
    private boolean f20188j;
    private int f20189k;
    public int f20190l;
    private int f20191m;
    private boolean f20192n;
    private int f20193o;
    private int f20194p;
    public float f20195q;
    public float f20196r;
    public int f20197s;
    private int f20198t;
    private ValueAnimator f20199u;
    public ScrollState f20200v;

    /* compiled from: com.facebook.platform.extra.TITLE */
    class C15191 implements AnimatorUpdateListener {
        final /* synthetic */ HScrollCirclePageIndicator f20177a;

        C15191(HScrollCirclePageIndicator hScrollCirclePageIndicator) {
            this.f20177a = hScrollCirclePageIndicator;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f20177a.f20183e.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            this.f20177a.invalidate();
        }
    }

    /* compiled from: com.facebook.platform.extra.TITLE */
    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C15201();
        int f20178a;

        /* compiled from: com.facebook.platform.extra.TITLE */
        final class C15201 implements Creator<SavedState> {
            C15201() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f20178a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f20178a);
        }
    }

    /* compiled from: com.facebook.platform.extra.TITLE */
    public enum ScrollState {
        NotScrolled,
        Scrolled
    }

    public HScrollCirclePageIndicator(Context context) {
        this(context, null);
    }

    public HScrollCirclePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130773293);
    }

    public HScrollCirclePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20180b = new Paint(1);
        this.f20181c = new Paint(1);
        this.f20182d = new Paint(1);
        this.f20183e = new Paint(1);
        this.f20191m = 5;
        this.f20195q = 1.0f;
        this.f20196r = 3.0f;
        this.f20197s = 50;
        this.f20198t = -1;
        if (!isInEditMode()) {
            Resources resources = getResources();
            int color = resources.getColor(2131362737);
            int color2 = resources.getColor(2131362736);
            int integer = resources.getInteger(2131492888);
            int color3 = resources.getColor(2131362738);
            float dimension = resources.getDimension(2131428793);
            float dimension2 = resources.getDimension(2131428792);
            resources.getBoolean(2131296263);
            boolean z = resources.getBoolean(2131296264);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CirclePageIndicator, i, 0);
            this.f20187i = obtainStyledAttributes.getInt(1, integer);
            this.f20189k = obtainStyledAttributes.getInt(0, 17);
            this.f20180b.setStyle(Style.FILL);
            this.f20180b.setColor(obtainStyledAttributes.getColor(6, color));
            this.f20181c.setStyle(Style.FILL);
            this.f20181c.setColor(obtainStyledAttributes.getColor(5, color3));
            this.f20181c.setStrokeWidth(obtainStyledAttributes.getDimension(3, dimension));
            this.f20182d.setStyle(Style.FILL);
            this.f20182d.setColor(obtainStyledAttributes.getColor(4, color2));
            this.f20179a = obtainStyledAttributes.getDimension(7, dimension2);
            this.f20188j = obtainStyledAttributes.getBoolean(8, z);
            this.f20200v = ScrollState.NotScrolled;
            this.f20183e.setStyle(Style.STROKE);
            this.f20183e.setStrokeWidth(0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    public void setMaxCircles(int i) {
        this.f20191m = i;
    }

    public void setPageColor(int i) {
        this.f20180b.setColor(i);
        invalidate();
    }

    public float getCirclePadding() {
        return this.f20196r;
    }

    public void setCirclePaddingMult(float f) {
        this.f20196r = f;
    }

    public int getPageColor() {
        return this.f20180b.getColor();
    }

    public void setFillColor(int i) {
        this.f20182d.setColor(i);
        invalidate();
    }

    public void setArrowColor(int i) {
        this.f20183e.setColor(i);
        invalidate();
    }

    public void setArrowStrokeWidth(int i) {
        this.f20183e.setStrokeWidth((float) i);
        invalidate();
    }

    public void setArrowStrokeWidthMultiplier(float f) {
        this.f20195q = f;
    }

    public void setArrowPadding(int i) {
        this.f20197s = i;
    }

    public int getFillColor() {
        return this.f20182d.getColor();
    }

    public void setOrientation(int i) {
        switch (i) {
            case 0:
            case 1:
                this.f20187i = i;
                requestLayout();
                return;
            default:
                throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
        }
    }

    public int getOrientation() {
        return this.f20187i;
    }

    public void setStrokeColor(int i) {
        this.f20181c.setColor(i);
        invalidate();
    }

    public int getStrokeColor() {
        return this.f20181c.getColor();
    }

    public void setStrokeWidth(float f) {
        this.f20181c.setStrokeWidth(f);
        invalidate();
    }

    public Style getStrokeStyle() {
        return this.f20181c.getStyle();
    }

    public void setStrokeStyle(Style style) {
        this.f20181c.setStyle(style);
        invalidate();
    }

    public float getStrokeWidth() {
        return this.f20181c.getStrokeWidth();
    }

    public void setRadius(float f) {
        this.f20179a = f;
        invalidate();
    }

    public float getRadius() {
        return this.f20179a;
    }

    public void setSnap(boolean z) {
        this.f20188j = z;
        invalidate();
    }

    public int getCount() {
        return this.f20190l;
    }

    public void setCount(int i) {
        this.f20190l = i;
        invalidate();
    }

    public final void m28813a() {
        this.f20198t = -1;
        this.f20184f = 0;
        this.f20185g = 0;
        this.f20186h = 0.0f;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int circleCount = getCircleCount();
        if (circleCount != 0) {
            int width;
            int paddingLeft;
            int paddingRight;
            int paddingTop;
            float f;
            if (this.f20187i == 0) {
                width = getWidth();
                paddingLeft = getPaddingLeft();
                paddingRight = getPaddingRight();
                paddingTop = getPaddingTop();
            } else {
                width = getHeight();
                paddingLeft = getPaddingTop();
                paddingRight = getPaddingBottom();
                paddingTop = getPaddingLeft();
            }
            float f2 = this.f20179a * this.f20196r;
            float f3 = this.f20179a + ((float) paddingTop);
            if ((this.f20189k & 8388611) == 8388611 || (this.f20189k & 8388613) != 8388613) {
                f = ((float) paddingLeft) + this.f20179a;
            } else {
                f = ((float) (width - paddingRight)) - (((float) circleCount) * f2);
            }
            float f4 = ((((float) ((width - paddingLeft) - paddingRight)) / 2.0f) + f) - ((((float) this.f20191m) * f2) / 2.0f);
            float f5 = ((float) width) - f4;
            if ((this.f20189k & 17) == 17) {
                f += (((float) ((width - paddingLeft) - paddingRight)) / 2.0f) - ((((float) circleCount) * f2) / 2.0f);
            }
            float f6 = this.f20179a;
            if (this.f20181c.getStrokeWidth() > 0.0f) {
                f6 -= this.f20181c.getStrokeWidth() / 2.0f;
            }
            for (int i = 0; i < circleCount; i++) {
                float f7;
                float f8 = (((float) i) * f2) + f;
                if (this.f20187i == 0) {
                    f7 = f8;
                    f8 = f3;
                } else {
                    f7 = f3;
                }
                if (this.f20180b.getAlpha() > 0) {
                    canvas.drawCircle(f7, f8, f6, this.f20180b);
                }
                if (f6 != this.f20179a) {
                    canvas.drawCircle(f7, f8, this.f20179a, this.f20181c);
                }
            }
            f6 = ((float) this.f20198t) * f2;
            if (!this.f20188j) {
                f6 += this.f20186h * f2;
            }
            if (this.f20187i == 0) {
                f += f6;
            } else {
                float f9 = f + f6;
                f = f3;
                f3 = f9;
            }
            canvas.drawCircle(f, f3, this.f20179a, this.f20182d);
            m28812b(canvas, f5, f3);
            m28808a(canvas, f4, f3);
        }
    }

    private int getCircleCount() {
        return this.f20190l < this.f20191m ? this.f20190l : this.f20191m;
    }

    private void m28808a(Canvas canvas, float f, float f2) {
        float f3 = (f - ((float) this.f20197s)) - (this.f20179a * 2.0f);
        if (this.f20184f != 0 && this.f20198t == 0) {
            m28809a(canvas, f2, f3, false);
        }
    }

    private void m28812b(Canvas canvas, float f, float f2) {
        float f3 = ((float) this.f20197s) + f;
        if (this.f20184f < this.f20190l - 1 && this.f20198t == this.f20191m - 1) {
            m28809a(canvas, f2, f3, true);
        }
    }

    private void m28809a(Canvas canvas, float f, float f2, boolean z) {
        float f3 = this.f20195q * this.f20179a;
        Paint paint = new Paint(1);
        paint.setColor(this.f20183e.getColor());
        paint.setStrokeWidth(6.0f);
        paint.setPathEffect(new CornerPathEffect(3.0f));
        Path path = new Path();
        path.moveTo(f2, f - f3);
        path.lineTo(z ? (f3 * 1.86f) + f2 : f2 - (f3 * 1.86f), f);
        path.lineTo(f2, f + f3);
        path.lineTo(f2, f - f3);
        path.close();
        canvas.drawPath(path, paint);
    }

    public void setCurrentItem(int i) {
        this.f20198t = i;
        this.f20184f = i;
        this.f20185g = i;
        setIsLastSection(i);
        invalidate();
    }

    public void m28814a(int i, int i2, boolean z) {
        this.f20198t = i2;
        this.f20184f = i;
        this.f20185g = i;
        setIsLastSection(i);
        if (z) {
            m28811b();
        }
        invalidate();
    }

    @TargetApi(11)
    private void m28811b() {
        if (VERSION.SDK_INT >= 11) {
            if (this.f20199u == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.f20199u = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(-12762030), Integer.valueOf(this.f20180b.getColor())});
                this.f20199u.setDuration(300);
                this.f20199u.addUpdateListener(new C15191(this));
            }
            this.f20199u.start();
        }
    }

    private void setIsLastSection(int i) {
        int i2;
        boolean z = false;
        if (this.f20191m > 0) {
            i2 = i / this.f20191m;
        } else {
            i2 = 0;
        }
        this.f20193o = i2;
        if (this.f20191m > 0) {
            i2 = (this.f20190l - 1) / this.f20191m;
        } else {
            i2 = 0;
        }
        this.f20194p = i2;
        if (this.f20193o == this.f20194p) {
            z = true;
        }
        this.f20192n = z;
    }

    public int getCurrentItem() {
        return this.f20185g;
    }

    protected void onMeasure(int i, int i2) {
        if (this.f20187i == 0) {
            setMeasuredDimension(m28806a(i), m28810b(i2));
        } else {
            setMeasuredDimension(m28810b(i), m28806a(i2));
        }
    }

    private int m28806a(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int i2 = this.f20190l > this.f20191m ? this.f20191m : this.f20190l;
        i2 = (int) (((((float) (i2 - 1)) * this.f20179a) + (((float) (getPaddingLeft() + getPaddingRight())) + (((float) (i2 * 2)) * this.f20179a))) + 1.0f);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i2, size);
        }
        return i2;
    }

    private int m28810b(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (int) ((((2.0f * this.f20179a) + ((float) getPaddingTop())) + ((float) getPaddingBottom())) + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f20184f = savedState.f20178a;
        this.f20185g = savedState.f20178a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f20178a = this.f20184f;
        return savedState;
    }

    public void setScrollState(ScrollState scrollState) {
        this.f20200v = scrollState;
    }
}
