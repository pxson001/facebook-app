package com.facebook.messaging.tabbedpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.R;
import com.facebook.widget.viewpageindicator.PageIndicator;

/* compiled from: isVerified */
public class TabbedPageIndicator extends View implements PageIndicator {
    private final Paint f12124a = new Paint(1);
    public RecyclerView f12125b;
    private ViewPager f12126c;
    public OnPageChangeListener f12127d;
    private int f12128e;
    private int f12129f;
    private int f12130g;
    private int f12131h;
    private float f12132i;

    public TabbedPageIndicator(Context context) {
        super(context);
        m19063a(context, null);
    }

    public TabbedPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19063a(context, attributeSet);
    }

    public TabbedPageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19063a(context, attributeSet);
    }

    private void m19063a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EmojiCategoryPageIndicator);
        this.f12128e = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f12129f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f12130g = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        int color = obtainStyledAttributes.getColor(3, getResources().getColor(2131362336));
        int color2 = obtainStyledAttributes.getColor(4, getResources().getColor(2131362337));
        obtainStyledAttributes.recycle();
        setBackgroundDrawable(new ColorDrawable(color));
        this.f12124a.setStyle(Style.FILL_AND_STROKE);
        this.f12124a.setColor(color2);
    }

    public final void m19065b(int i) {
        if (this.f12127d != null) {
            this.f12127d.b(i);
        }
    }

    public final void m19064a(int i, float f, int i2) {
        invalidate();
        this.f12131h = i;
        this.f12132i = f;
        if (this.f12127d != null) {
            this.f12127d.a(i, f, i2);
        }
    }

    public final void e_(int i) {
        if (this.f12127d != null) {
            this.f12127d.e_(i);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.f12126c != viewPager) {
            if (this.f12126c != null) {
                this.f12126c.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.f12126c = viewPager;
            this.f12126c.setOnPageChangeListener(this);
            invalidate();
        }
    }

    public void setTabRecyclerView(RecyclerView recyclerView) {
        this.f12125b = recyclerView;
    }

    public void setCurrentItem(int i) {
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f12127d = onPageChangeListener;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f12126c != null) {
            canvas.drawRect(getIndicatorLeft(), 0.0f, getIndicatorRight(), (float) getMeasuredHeight(), this.f12124a);
        }
    }

    public int getLeftTrackPadding() {
        return this.f12129f;
    }

    public int getRightTrackPadding() {
        return this.f12130g;
    }

    protected void setLeftTrackPadding(int i) {
        this.f12129f = i;
        invalidate();
    }

    protected void setRightTrackPadding(int i) {
        this.f12130g = i;
        invalidate();
    }

    public float getIndicatorWidth() {
        int b = this.f12126c.getAdapter().b();
        if (b == 0) {
            return 0.0f;
        }
        float f = (float) this.f12128e;
        if (f == 0.0f) {
            return (float) (((getMeasuredWidth() - this.f12129f) - this.f12130g) / b);
        }
        return f;
    }

    private float getIndicatorLeft() {
        return Math.max(((getIndicatorWidth() * (getScrollPosition() + ((float) this.f12131h))) + ((float) this.f12129f)) - m19062a(), (float) this.f12129f);
    }

    private float getIndicatorRight() {
        return Math.min(((getIndicatorWidth() * ((getScrollPosition() + 1.0f) + ((float) this.f12131h))) + ((float) this.f12129f)) - m19062a(), (float) (getMeasuredWidth() - this.f12130g));
    }

    private float m19062a() {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f12125b.getLayoutManager();
        View childAt = this.f12125b.getChildAt(0);
        if (childAt == null) {
            return 0.0f;
        }
        return (float) ((linearLayoutManager.l() * childAt.getWidth()) - childAt.getLeft());
    }

    private float getScrollPosition() {
        if (this.f12126c == null || this.f12126c.getAdapter() == null || this.f12126c.getAdapter().b() == 0) {
            return 0.0f;
        }
        return this.f12132i;
    }
}
