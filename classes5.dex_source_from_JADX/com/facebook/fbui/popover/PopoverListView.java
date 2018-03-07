package com.facebook.fbui.popover;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.facebook.R;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.resources.ui.FbTextView;

/* compiled from: You need to use a Theme.AppCompat theme (or descendant) with this activity. */
public class PopoverListView extends ListView {
    private static final int[] f12154a = new int[]{16842916, 16842918};
    private static final int[] f12155b = new int[]{16842916};
    private static final int[] f12156c = new int[]{16842918};
    private float f12157d;
    public int f12158e;
    private int f12159f;
    private int f12160g;
    private int f12161h;
    private int f12162i;
    private boolean f12163j;
    private boolean f12164k;
    private FbTextView f12165l;
    private View f12166m;

    public PopoverListView(Context context) {
        this(context, null);
    }

    private PopoverListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772487);
    }

    private PopoverListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12163j = false;
        this.f12164k = true;
        this.f12160g = getResources().getDimensionPixelSize(2131428374);
        this.f12158e = getResources().getDimensionPixelSize(2131428375);
        this.f12157d = 5.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PopoverListView, i, 2131624375);
        this.f12160g = obtainStyledAttributes.getDimensionPixelSize(0, this.f12160g);
        this.f12158e = obtainStyledAttributes.getDimensionPixelSize(1, this.f12158e);
        this.f12157d = obtainStyledAttributes.getFloat(2, this.f12157d);
        obtainStyledAttributes.recycle();
        this.f12165l = (FbTextView) LayoutInflater.from(context).inflate(2130904268, this, false);
    }

    protected void onMeasure(int i, int i2) {
        ListAdapter wrappedAdapter;
        int measuredHeight;
        float f;
        int i3;
        Resources resources = getResources();
        if (this.f12164k) {
            i = MeasureSpec.makeMeasureSpec(resources.getDisplayMetrics().widthPixels, 1073741824);
            super.onMeasure(i, i2);
        }
        ListAdapter adapter = getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            wrappedAdapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            if (this.f12166m != null) {
                this.f12166m.measure(i, MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE));
                measuredHeight = this.f12166m.getMeasuredHeight();
            } else {
                measuredHeight = resources.getDimensionPixelSize(2131428378);
            }
        } else {
            wrappedAdapter = adapter;
            measuredHeight = 0;
        }
        if (wrappedAdapter instanceof PopoverMenu) {
            ((PopoverMenu) wrappedAdapter).m20169a(this.f12163j);
        }
        if (wrappedAdapter == null) {
            f = 0.0f;
        } else {
            f = (float) wrappedAdapter.getCount();
        }
        if (measuredHeight > 0) {
            f += 1.0f;
        }
        if (f > this.f12157d) {
            f = this.f12157d - 0.5f;
        }
        if (measuredHeight > 0) {
            f -= 1.0f;
        }
        int size = MeasureSpec.getSize(i2);
        measuredHeight += getPaddingTop() + getPaddingBottom();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(size, 0);
        int count = adapter.getCount();
        int i4 = resources.getDisplayMetrics().widthPixels;
        int i5 = 0;
        int dividerHeight = getDividerHeight();
        if (this.f12163j || !this.f12164k) {
            i3 = measuredHeight;
            View view = null;
            int i6 = 0;
            while (i6 < count) {
                View view2 = wrappedAdapter.getView(i6, view, this);
                view2.measure(makeMeasureSpec, makeMeasureSpec2);
                this.f12158e = view2.getMeasuredHeight();
                if (this.f12163j && ((float) i6) < f) {
                    i3 += view2.getMeasuredHeight();
                    if (i6 > 0) {
                        i3 += dividerHeight;
                    }
                }
                measuredHeight = view2.getMeasuredWidth();
                if (!(this.f12160g == 0 || measuredHeight % this.f12160g == 0)) {
                    measuredHeight = ((measuredHeight / this.f12160g) + 1) * this.f12160g;
                }
                if (measuredHeight >= i4) {
                    if (((float) i6) >= f) {
                        break;
                    }
                    measuredHeight = i4;
                } else if (measuredHeight <= i5) {
                    measuredHeight = i5;
                }
                i6++;
                i5 = measuredHeight;
                view = view2;
            }
            i4 = i5;
        } else {
            i4 = 0;
            i3 = measuredHeight;
        }
        if (!this.f12163j) {
            i3 += (int) (((f - 1.0f) * ((float) dividerHeight)) + (((float) this.f12158e) * f));
        }
        i3 = Math.min(i3, size);
        int max = Math.max(i4, getSuggestedMinimumWidth());
        if (this.f12159f > 0) {
            if (this.f12164k) {
                max = Math.min(this.f12159f, getMeasuredWidth());
            } else {
                max = Math.min(this.f12159f, max);
            }
        } else if (this.f12164k) {
            max = getMeasuredWidth();
        }
        if (!this.f12164k) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(max, 1073741824), MeasureSpec.makeMeasureSpec(i3, 1073741824));
        }
        setMeasuredDimension(max, i3);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.f12161h = (int) motionEvent.getX();
            this.f12162i = (int) motionEvent.getY();
        } else {
            this.f12161h = -1;
            this.f12162i = -1;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    protected int[] onCreateDrawableState(int i) {
        if (!isPressed()) {
            return super.onCreateDrawableState(i);
        }
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        int childCount = getChildCount();
        int pointToPosition = pointToPosition(this.f12161h, this.f12162i) - getFirstVisiblePosition();
        if (pointToPosition == 0 && pointToPosition == childCount - 1) {
            View.mergeDrawableStates(onCreateDrawableState, f12154a);
            return onCreateDrawableState;
        } else if (pointToPosition == 0) {
            View.mergeDrawableStates(onCreateDrawableState, f12155b);
            return onCreateDrawableState;
        } else if (pointToPosition != childCount - 1) {
            return onCreateDrawableState;
        } else {
            View.mergeDrawableStates(onCreateDrawableState, f12156c);
            return onCreateDrawableState;
        }
    }

    public final void m20176a(boolean z) {
        if (this.f12163j != z) {
            this.f12163j = z;
            requestLayout();
            invalidate();
        }
    }

    public void setShowFullWidth(boolean z) {
        if (this.f12164k != z) {
            this.f12164k = z;
            requestLayout();
            invalidate();
        }
    }

    public void setMaxRows(float f) {
        if (this.f12157d != f) {
            this.f12157d = f;
            requestLayout();
            invalidate();
        }
    }

    public void setMaxWidth(int i) {
        if (this.f12159f != i) {
            this.f12159f = i;
            requestLayout();
            invalidate();
        }
    }

    public void setTitle(CharSequence charSequence) {
        ListAdapter adapter = getAdapter();
        setAdapter(null);
        if (!TextUtils.isEmpty(charSequence)) {
            setTitleView(this.f12165l);
            this.f12165l.setText(charSequence);
        } else if (getHeaderViewsCount() == 1) {
            m20175a();
        }
        setAdapter(adapter);
    }

    public void setCustomTitleView(View view) {
        ListAdapter adapter = getAdapter();
        setAdapter(null);
        setTitleView(view);
        this.f12166m = view;
        setAdapter(adapter);
    }

    private void setTitleView(View view) {
        if (getHeaderViewsCount() == 1) {
            m20175a();
        }
        addHeaderView(view, null, false);
    }

    private void m20175a() {
        View view = this.f12166m != null ? this.f12166m : this.f12165l;
        this.f12166m = null;
        removeHeaderView(view);
    }
}
