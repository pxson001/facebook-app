package com.facebook.fbui.popover;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: You are browsing for free courtesy of [carrier] */
public class PopoverSpinner extends AdapterView<ListAdapter> {
    private int f12184a;
    private int f12185b;
    private View f12186c;
    public ListAdapter f12187d;
    public int f12188e;
    private PopoverListViewWindow f12189f;
    public boolean f12190g;

    /* compiled from: You are browsing for free courtesy of [carrier] */
    class C11251 implements OnItemClickListener {
        final /* synthetic */ PopoverSpinner f12182a;

        C11251(PopoverSpinner popoverSpinner) {
            this.f12182a = popoverSpinner;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            OnItemSelectedListener onItemSelectedListener = this.f12182a.getOnItemSelectedListener();
            if (!(this.f12182a.f12188e == i || onItemSelectedListener == null)) {
                onItemSelectedListener.onItemSelected(adapterView, view, i, j);
                this.f12182a.f12190g = true;
            }
            this.f12182a.setSelection(i);
        }
    }

    /* compiled from: You are browsing for free courtesy of [carrier] */
    class C11262 implements OnDismissListener {
        final /* synthetic */ PopoverSpinner f12183a;

        C11262(PopoverSpinner popoverSpinner) {
            this.f12183a = popoverSpinner;
        }

        public final boolean m20194a(PopoverWindow popoverWindow) {
            OnItemSelectedListener onItemSelectedListener = this.f12183a.getOnItemSelectedListener();
            if (this.f12183a.f12190g || onItemSelectedListener == null) {
                this.f12183a.f12190g = false;
            } else {
                onItemSelectedListener.onNothingSelected(this.f12183a);
            }
            return true;
        }
    }

    public PopoverSpinner(Context context) {
        this(context, null);
    }

    public PopoverSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772489);
    }

    public PopoverSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setFocusable(true);
        setClickable(true);
        this.f12186c = null;
        this.f12190g = false;
        this.f12189f = new PopoverListViewWindow(context);
        this.f12189f.e(true);
        this.f12189f.f12180p = new C11251(this);
        this.f12189f.H = new C11262(this);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1189761656);
        super.onDetachedFromWindow();
        if (this.f12189f.r) {
            this.f12189f.l();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 122019761, a);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        int selection = getSelection();
        if (selection >= 0 && this.f12187d != null && selection < this.f12187d.getCount()) {
            View view = this.f12187d.getView(selection, null, this);
            if (view != null) {
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(generateDefaultLayoutParams());
                }
                measureChild(view, i, i2);
                selection = view.getMeasuredHeight();
                i3 = view.getMeasuredWidth();
                i3 += getPaddingLeft() + getPaddingRight();
                setMeasuredDimension(Math.max(i3, getSuggestedMinimumWidth()), Math.max(selection + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()));
                this.f12184a = i;
                this.f12185b = i2;
            }
        }
        selection = 0;
        i3 += getPaddingLeft() + getPaddingRight();
        setMeasuredDimension(Math.max(i3, getSuggestedMinimumWidth()), Math.max(selection + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()));
        this.f12184a = i;
        this.f12185b = i2;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f12187d == null || this.f12187d.getCount() == 0) {
            this.f12186c = null;
            removeAllViewsInLayout();
            return;
        }
        this.f12186c = this.f12187d.getView(getSelection(), this.f12186c, this);
        LayoutParams layoutParams = this.f12186c.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        detachAllViewsFromParent();
        this.f12186c.setSelected(hasFocus());
        this.f12186c.measure(ViewGroup.getChildMeasureSpec(this.f12184a, getPaddingLeft() + getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(this.f12185b, getPaddingTop() + getPaddingBottom(), layoutParams.height));
        addViewInLayout(this.f12186c, 0, layoutParams);
        int measuredWidth = this.f12186c.getMeasuredWidth();
        int measuredHeight = this.f12186c.getMeasuredHeight();
        int paddingTop = getPaddingTop();
        paddingTop += (((getMeasuredHeight() - measuredHeight) - paddingTop) - getPaddingBottom()) / 2;
        measuredHeight += paddingTop;
        int paddingLeft = getPaddingLeft();
        this.f12186c.layout(paddingLeft, paddingTop, measuredWidth + paddingLeft, measuredHeight);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public ListAdapter getAdapter() {
        return this.f12187d;
    }

    public void setAdapter(ListAdapter listAdapter) {
        this.f12187d = listAdapter;
        this.f12189f.f12177m = listAdapter;
        requestLayout();
        invalidate();
    }

    public View getSelectedView() {
        int selection = getSelection();
        if (selection == -1 || selection >= this.f12187d.getCount()) {
            return null;
        }
        return this.f12187d.getView(selection, null, this);
    }

    public int getSelection() {
        if (this.f12187d == null || this.f12187d.getCount() == 0) {
            return -1;
        }
        return this.f12188e;
    }

    public void setSelection(int i) {
        if (this.f12188e != i) {
            this.f12188e = i;
            requestLayout();
            invalidate();
        }
    }

    public int getSelectedItemPosition() {
        return getSelection();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }

    public boolean performClick() {
        if (!this.f12189f.r) {
            this.f12189f.f(this);
        }
        return true;
    }

    public void setMaxRows(float f) {
        this.f12189f.f12179o = f;
    }

    public void setPopoverDimAmount(float f) {
        this.f12189f.b(f);
    }
}
