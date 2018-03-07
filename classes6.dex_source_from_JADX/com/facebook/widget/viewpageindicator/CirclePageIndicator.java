package com.facebook.widget.viewpageindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: com.facebook.platform.protocol.BRIDGE_ARGS */
public class CirclePageIndicator extends View implements PageIndicator {
    private float f20160a;
    private final Paint f20161b;
    private final Paint f20162c;
    private final Paint f20163d;
    private ViewPager f20164e;
    public OnPageChangeListener f20165f;
    private int f20166g;
    private int f20167h;
    private float f20168i;
    private int f20169j;
    private int f20170k;
    private boolean f20171l;
    private boolean f20172m;
    private int f20173n;
    private float f20174o;
    private int f20175p;
    private boolean f20176q;

    /* compiled from: com.facebook.platform.protocol.BRIDGE_ARGS */
    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C15181();
        int f20159a;

        /* compiled from: com.facebook.platform.protocol.BRIDGE_ARGS */
        final class C15181 implements Creator<SavedState> {
            C15181() {
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
            this.f20159a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f20159a);
        }
    }

    public CirclePageIndicator(Context context) {
        this(context, null);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130773293);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20161b = new Paint(1);
        this.f20162c = new Paint(1);
        this.f20163d = new Paint(1);
        this.f20174o = -1.0f;
        this.f20175p = -1;
        if (!isInEditMode()) {
            Resources resources = getResources();
            int color = resources.getColor(2131362737);
            int color2 = resources.getColor(2131362736);
            int integer = resources.getInteger(2131492888);
            int color3 = resources.getColor(2131362738);
            float dimension = resources.getDimension(2131428793);
            float dimension2 = resources.getDimension(2131428792);
            boolean z = resources.getBoolean(2131296263);
            boolean z2 = resources.getBoolean(2131296264);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CirclePageIndicator, i, 0);
            this.f20171l = obtainStyledAttributes.getBoolean(2, z);
            this.f20170k = obtainStyledAttributes.getInt(1, integer);
            this.f20161b.setStyle(Style.FILL);
            this.f20161b.setColor(obtainStyledAttributes.getColor(6, color));
            this.f20162c.setStyle(Style.FILL);
            this.f20162c.setColor(obtainStyledAttributes.getColor(5, color3));
            this.f20162c.setStrokeWidth(obtainStyledAttributes.getDimension(3, dimension));
            this.f20163d.setStyle(Style.FILL);
            this.f20163d.setColor(obtainStyledAttributes.getColor(4, color2));
            this.f20160a = obtainStyledAttributes.getDimension(7, dimension2);
            this.f20172m = obtainStyledAttributes.getBoolean(8, z2);
            obtainStyledAttributes.recycle();
            this.f20173n = ViewConfigurationCompat.a(ViewConfiguration.get(context));
        }
    }

    public void setPaintStrokeStyle(Style style) {
        this.f20162c.setStyle(style);
        invalidate();
    }

    public void setCentered(boolean z) {
        this.f20171l = z;
        invalidate();
    }

    public void setPageColor(int i) {
        this.f20161b.setColor(i);
        invalidate();
    }

    public int getPageColor() {
        return this.f20161b.getColor();
    }

    public void setFillColor(int i) {
        this.f20163d.setColor(i);
        invalidate();
    }

    public int getFillColor() {
        return this.f20163d.getColor();
    }

    public void setOrientation(int i) {
        switch (i) {
            case 0:
            case 1:
                this.f20170k = i;
                requestLayout();
                return;
            default:
                throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
        }
    }

    public int getOrientation() {
        return this.f20170k;
    }

    public void setStrokeColor(int i) {
        this.f20162c.setColor(i);
        invalidate();
    }

    public int getStrokeColor() {
        return this.f20162c.getColor();
    }

    public void setStrokeWidth(float f) {
        this.f20162c.setStrokeWidth(f);
        invalidate();
    }

    public float getStrokeWidth() {
        return this.f20162c.getStrokeWidth();
    }

    public void setRadius(float f) {
        this.f20160a = f;
        invalidate();
    }

    public float getRadius() {
        return this.f20160a;
    }

    public void setSnap(boolean z) {
        this.f20172m = z;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f20164e != null) {
            int b = this.f20164e.getAdapter().b();
            if (b == 0) {
                return;
            }
            if (this.f20166g >= b) {
                setCurrentItem(b - 1);
                return;
            }
            int width;
            int paddingLeft;
            int paddingRight;
            int paddingTop;
            if (this.f20170k == 0) {
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
            float f = this.f20160a * 3.0f;
            float f2 = this.f20160a + ((float) paddingTop);
            float f3 = ((float) paddingLeft) + this.f20160a;
            if (this.f20171l) {
                f3 += (((float) ((width - paddingLeft) - paddingRight)) / 2.0f) - ((((float) b) * f) / 2.0f);
            }
            float f4 = this.f20160a;
            if (this.f20162c.getStrokeWidth() > 0.0f) {
                f4 -= this.f20162c.getStrokeWidth() / 2.0f;
            }
            for (int i = 0; i < b; i++) {
                float f5;
                float f6 = (((float) i) * f) + f3;
                if (this.f20170k == 0) {
                    f5 = f6;
                    f6 = f2;
                } else {
                    f5 = f2;
                }
                if (this.f20161b.getAlpha() > 0) {
                    canvas.drawCircle(f5, f6, f4, this.f20161b);
                }
                if (f4 != this.f20160a) {
                    canvas.drawCircle(f5, f6, this.f20160a, this.f20162c);
                }
            }
            f4 = ((float) (this.f20172m ? this.f20167h : this.f20166g)) * f;
            if (!this.f20172m) {
                f4 += this.f20168i * f;
            }
            if (this.f20170k == 0) {
                f3 += f4;
            } else {
                float f7 = f3 + f4;
                f3 = f2;
                f2 = f7;
            }
            canvas.drawCircle(f3, f2, this.f20160a, this.f20163d);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        int a = Logger.a(2, EntryType.UI_INPUT_START, -93811567);
        if (super.onTouchEvent(motionEvent)) {
            Logger.a(2, EntryType.UI_INPUT_END, 534738376, a);
            return true;
        } else if (this.f20164e == null || this.f20164e.getAdapter().b() == 0) {
            LogUtils.a(157610003, a);
            return false;
        } else {
            int b;
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.f20175p = MotionEventCompat.b(motionEvent, 0);
                    this.f20174o = motionEvent.getX();
                    break;
                case 1:
                case 3:
                    if (!this.f20176q) {
                        b = this.f20164e.getAdapter().b();
                        int width = getWidth();
                        float f = ((float) width) / 2.0f;
                        float f2 = ((float) width) / 6.0f;
                        if (this.f20166g > 0 && motionEvent.getX() < f - f2) {
                            this.f20164e.setCurrentItem(this.f20166g - 1);
                            LogUtils.a(-1415262785, a);
                            return true;
                        } else if (this.f20166g < b - 1 && motionEvent.getX() > f2 + f) {
                            this.f20164e.setCurrentItem(this.f20166g + 1);
                            LogUtils.a(128280757, a);
                            return true;
                        }
                    }
                    this.f20176q = false;
                    this.f20175p = -1;
                    if (this.f20164e.S) {
                        this.f20164e.d();
                        break;
                    }
                    break;
                case 2:
                    float c = MotionEventCompat.c(motionEvent, MotionEventCompat.a(motionEvent, this.f20175p));
                    float f3 = c - this.f20174o;
                    if (!this.f20176q && Math.abs(f3) > ((float) this.f20173n)) {
                        this.f20176q = true;
                    }
                    if (this.f20176q) {
                        this.f20174o = c;
                        if (this.f20164e.S || this.f20164e.c()) {
                            this.f20164e.a(f3);
                            break;
                        }
                    }
                    break;
                case 5:
                    i = MotionEventCompat.b(motionEvent);
                    this.f20174o = MotionEventCompat.c(motionEvent, i);
                    this.f20175p = MotionEventCompat.b(motionEvent, i);
                    break;
                case 6:
                    b = MotionEventCompat.b(motionEvent);
                    if (MotionEventCompat.b(motionEvent, b) == this.f20175p) {
                        if (b == 0) {
                            i = 1;
                        }
                        this.f20175p = MotionEventCompat.b(motionEvent, i);
                    }
                    this.f20174o = MotionEventCompat.c(motionEvent, MotionEventCompat.a(motionEvent, this.f20175p));
                    break;
            }
            LogUtils.a(-468949983, a);
            return true;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.f20164e != viewPager) {
            if (this.f20164e != null) {
                this.f20164e.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.f20164e = viewPager;
            this.f20164e.setOnPageChangeListener(this);
            invalidate();
        }
    }

    public void setCurrentItem(int i) {
        if (this.f20164e == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.f20164e.setCurrentItem(i);
        this.f20166g = i;
        invalidate();
    }

    public final void m28805b(int i) {
        this.f20169j = i;
        if (this.f20165f != null) {
            this.f20165f.b(i);
        }
    }

    public final void m28804a(int i, float f, int i2) {
        this.f20166g = i;
        this.f20168i = f;
        invalidate();
        if (this.f20165f != null) {
            this.f20165f.a(i, f, i2);
        }
    }

    public final void e_(int i) {
        if (this.f20172m || this.f20169j == 0) {
            this.f20166g = i;
            this.f20167h = i;
            invalidate();
        }
        if (this.f20165f != null) {
            this.f20165f.e_(i);
        }
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f20165f = onPageChangeListener;
    }

    protected void onMeasure(int i, int i2) {
        if (this.f20170k == 0) {
            setMeasuredDimension(m28802c(i), m28803d(i2));
        } else {
            setMeasuredDimension(m28803d(i), m28802c(i2));
        }
    }

    private int m28802c(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824 || this.f20164e == null) {
            return size;
        }
        int b = this.f20164e.getAdapter().b();
        b = (int) (((((float) (b - 1)) * this.f20160a) + (((float) (getPaddingLeft() + getPaddingRight())) + (((float) (b * 2)) * this.f20160a))) + 1.0f);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(b, size);
        }
        return b;
    }

    private int m28803d(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (int) ((((2.0f * this.f20160a) + ((float) getPaddingTop())) + ((float) getPaddingBottom())) + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f20166g = savedState.f20159a;
        this.f20167h = savedState.f20159a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f20159a = this.f20166g;
        return savedState;
    }
}
