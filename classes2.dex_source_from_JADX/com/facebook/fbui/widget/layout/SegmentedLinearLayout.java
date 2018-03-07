package com.facebook.fbui.widget.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: messenger_confidence_presence_badge_gk */
public class SegmentedLinearLayout extends CustomLinearLayout {
    private final Rect f14119a;
    private Drawable f14120b;
    private int f14121c;
    private int f14122d;
    private int f14123e;
    private int f14124f;
    private int f14125g;
    private int f14126h;

    public SegmentedLinearLayout(Context context) {
        this(context, null);
    }

    public SegmentedLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14119a = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SegmentedLinearLayout);
        setSegmentedDivider(obtainStyledAttributes.getDrawable(2));
        this.f14124f = obtainStyledAttributes.getInt(0, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (obtainStyledAttributes.hasValue(4)) {
            this.f14125g = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        } else {
            this.f14125g = dimensionPixelSize;
        }
        if (obtainStyledAttributes.hasValue(5)) {
            this.f14126h = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        } else {
            this.f14126h = dimensionPixelSize;
        }
        this.f14123e = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        obtainStyledAttributes.recycle();
    }

    protected void onDraw(Canvas canvas) {
        if (this.f14120b == null) {
            return;
        }
        if (getOrientation() == 1) {
            m20435a(canvas);
        } else {
            m20439b(canvas);
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            if (layoutParams2.weight > 0.0f) {
                int orientation = getOrientation();
                if (orientation == 0 && layoutParams2.width == 0) {
                    layoutParams2.width = 1;
                } else if (orientation == 1 && layoutParams2.height == 0) {
                    layoutParams2.height = 1;
                }
            }
            super.addView(view, i, layoutParams2);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1792174890);
        if (this.f14120b != null) {
            int indexOfChild = indexOfChild(view);
            int childCount = getChildCount();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            int segmentedDividerThickness = getSegmentedDividerThickness();
            if (getOrientation() == 1) {
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                if (m20442c(indexOfChild)) {
                    layoutParams.topMargin = segmentedDividerThickness;
                }
                if (indexOfChild == childCount - 1 && m20442c(childCount)) {
                    layoutParams.bottomMargin = segmentedDividerThickness;
                }
            } else {
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                if (mo2702a()) {
                    if (m20442c(indexOfChild)) {
                        layoutParams.leftMargin = segmentedDividerThickness;
                    }
                    if (indexOfChild == childCount - 1 && m20442c(childCount)) {
                        layoutParams.rightMargin = segmentedDividerThickness;
                    }
                } else {
                    if (m20442c(indexOfChild)) {
                        layoutParams.rightMargin = segmentedDividerThickness;
                    }
                    if (indexOfChild == childCount - 1 && m20442c(childCount)) {
                        layoutParams.leftMargin = segmentedDividerThickness;
                    }
                }
            }
        }
        super.measureChildWithMargins(view, i, i2, i3, i4);
        LogUtils.g(1233859154, a);
    }

    private void m20435a(Canvas canvas) {
        int childCount = getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (!(childAt == null || childAt.getVisibility() == 8 || !m20442c(i))) {
                m20436a(canvas, childAt.getTop() - ((LinearLayout.LayoutParams) childAt.getLayoutParams()).topMargin);
            }
            i++;
        }
        if (m20442c(childCount)) {
            int height;
            View childAt2 = getChildAt(childCount - 1);
            if (childAt2 == null) {
                height = (getHeight() - getPaddingBottom()) - getSegmentedDividerThickness();
            } else {
                height = childAt2.getBottom();
            }
            m20436a(canvas, height);
        }
    }

    private void m20439b(Canvas canvas) {
        int childCount = getChildCount();
        boolean a = mo2702a();
        int i = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (!(childAt == null || childAt.getVisibility() == 8 || !m20442c(i))) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                if (a) {
                    m20440b(canvas, childAt.getLeft() - layoutParams.leftMargin);
                } else {
                    m20440b(canvas, childAt.getRight());
                }
            }
            i++;
        }
        if (m20442c(childCount)) {
            View childAt2 = getChildAt(childCount - 1);
            int width;
            if (a) {
                if (childAt2 == null) {
                    width = (getWidth() - getPaddingRight()) - getSegmentedDividerThickness();
                } else {
                    width = childAt2.getRight();
                }
                m20440b(canvas, width);
                return;
            }
            if (childAt2 == null) {
                width = getPaddingLeft();
            } else {
                width = childAt2.getLeft();
            }
            m20440b(canvas, width);
        }
    }

    private void m20436a(Canvas canvas, int i) {
        if (mo2702a()) {
            this.f14119a.set(getPaddingLeft() + this.f14125g, i, (getWidth() - getPaddingRight()) - this.f14126h, getSegmentedDividerThickness() + i);
        } else {
            this.f14119a.set(getPaddingLeft() + this.f14126h, i, (getWidth() - getPaddingRight()) - this.f14125g, getSegmentedDividerThickness() + i);
        }
        m20437a(canvas, this.f14119a);
    }

    private void m20440b(Canvas canvas, int i) {
        this.f14119a.set(i, getPaddingTop() + this.f14125g, getSegmentedDividerThickness() + i, (getHeight() - getPaddingBottom()) - this.f14126h);
        m20437a(canvas, this.f14119a);
    }

    private void m20437a(Canvas canvas, Rect rect) {
        if (VERSION.SDK_INT >= 11 || !(this.f14120b instanceof ColorDrawable)) {
            this.f14120b.setBounds(rect);
            this.f14120b.draw(canvas);
            return;
        }
        canvas.save();
        canvas.clipRect(rect);
        this.f14120b.draw(canvas);
        canvas.restore();
    }

    private boolean mo2702a() {
        return ViewCompat.m10967h(this) == 0;
    }

    public final boolean m20442c(int i) {
        if (i == 0) {
            if ((this.f14124f & 1) != 0) {
                return true;
            }
            return false;
        } else if (i == getChildCount()) {
            if ((this.f14124f & 4) == 0) {
                return false;
            }
            return true;
        } else if ((this.f14124f & 2) == 0) {
            return false;
        } else {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    public void setSegmentedDividerThickness(int i) {
        if (this.f14123e != i) {
            this.f14123e = i;
            requestLayout();
            invalidate();
        }
    }

    public int getSegmentedDividerThickness() {
        return getOrientation() == 1 ? this.f14123e > 0 ? this.f14123e : this.f14122d : this.f14123e > 0 ? this.f14123e : this.f14121c;
    }

    public final void m20441a(int i, int i2) {
        if (this.f14125g != i) {
            this.f14125g = i;
            requestLayout();
            invalidate();
        }
        if (this.f14126h != i2) {
            this.f14126h = i2;
            requestLayout();
            invalidate();
        }
    }

    public void setSegmentedDividerPadding(int i) {
        if (this.f14125g != i || this.f14126h != i) {
            this.f14126h = i;
            this.f14125g = i;
            requestLayout();
            invalidate();
        }
    }

    public int getSegmentedDividerPadding() {
        return Math.max(this.f14125g, this.f14126h);
    }

    public void setSegmentedDivider(Drawable drawable) {
        boolean z = false;
        if (this.f14120b != drawable) {
            this.f14120b = drawable;
            if (this.f14120b != null) {
                this.f14121c = this.f14120b.getIntrinsicWidth();
                this.f14122d = this.f14120b.getIntrinsicHeight();
            } else {
                this.f14122d = 0;
                this.f14121c = 0;
            }
            if (this.f14120b == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
            invalidate();
        }
    }

    public Drawable getSegmentedDivider() {
        return this.f14120b;
    }

    public void setShowSegmentedDividers(int i) {
        if (this.f14124f != i) {
            this.f14124f = i;
            requestLayout();
            invalidate();
        }
    }

    public int getShowSegmentedDividers() {
        return this.f14124f;
    }
}
