package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: unknown_report_page */
public abstract class AdapterViewCompat<T extends Adapter> extends ViewGroup {
    int f949A;
    int f950B = -1;
    long f951C = Long.MIN_VALUE;
    boolean f952D = false;
    public int f953a;
    private View f954b;
    private boolean f955c;
    private boolean f956d;
    private SelectionNotifier f957e;
    @ExportedProperty(category = "scrolling")
    public int f958j = 0;
    public int f959k;
    public int f960l;
    public long f961m = Long.MIN_VALUE;
    public long f962n;
    public boolean f963o = false;
    public int f964p;
    boolean f965q = false;
    OnItemSelectedListener f966r;
    OnItemClickListener f967s;
    OnItemLongClickListener f968t;
    boolean f969u;
    @ExportedProperty(category = "list")
    public int f970v = -1;
    public long f971w = Long.MIN_VALUE;
    @ExportedProperty(category = "list")
    public int f972x = -1;
    long f973y = Long.MIN_VALUE;
    @ExportedProperty(category = "list")
    int f974z;

    /* compiled from: unknown_report_page */
    class AdapterDataSetObserver extends DataSetObserver {
        final /* synthetic */ AdapterViewCompat f1093a;
        private Parcelable f1094b = null;

        AdapterDataSetObserver(AdapterViewCompat adapterViewCompat) {
            this.f1093a = adapterViewCompat;
        }

        public void onChanged() {
            this.f1093a.f969u = true;
            this.f1093a.f949A = this.f1093a.f974z;
            this.f1093a.f974z = this.f1093a.getAdapter().getCount();
            if (!this.f1093a.getAdapter().hasStableIds() || this.f1094b == null || this.f1093a.f949A != 0 || this.f1093a.f974z <= 0) {
                AdapterViewCompat adapterViewCompat = this.f1093a;
                if (adapterViewCompat.getChildCount() > 0) {
                    adapterViewCompat.f963o = true;
                    adapterViewCompat.f962n = (long) adapterViewCompat.f953a;
                    View childAt;
                    if (adapterViewCompat.f972x >= 0) {
                        childAt = adapterViewCompat.getChildAt(adapterViewCompat.f972x - adapterViewCompat.f958j);
                        adapterViewCompat.f961m = adapterViewCompat.f971w;
                        adapterViewCompat.f960l = adapterViewCompat.f970v;
                        if (childAt != null) {
                            adapterViewCompat.f959k = childAt.getTop();
                        }
                        adapterViewCompat.f964p = 0;
                    } else {
                        childAt = adapterViewCompat.getChildAt(0);
                        Adapter adapter = adapterViewCompat.getAdapter();
                        if (adapterViewCompat.f958j < 0 || adapterViewCompat.f958j >= adapter.getCount()) {
                            adapterViewCompat.f961m = -1;
                        } else {
                            adapterViewCompat.f961m = adapter.getItemId(adapterViewCompat.f958j);
                        }
                        adapterViewCompat.f960l = adapterViewCompat.f958j;
                        if (childAt != null) {
                            adapterViewCompat.f959k = childAt.getTop();
                        }
                        adapterViewCompat.f964p = 1;
                    }
                }
            } else {
                this.f1093a.onRestoreInstanceState(this.f1094b);
                this.f1094b = null;
            }
            this.f1093a.m1505e();
            this.f1093a.requestLayout();
        }

        public void onInvalidated() {
            this.f1093a.f969u = true;
            if (this.f1093a.getAdapter().hasStableIds()) {
                this.f1094b = this.f1093a.onSaveInstanceState();
            }
            this.f1093a.f949A = this.f1093a.f974z;
            this.f1093a.f974z = 0;
            this.f1093a.f972x = -1;
            this.f1093a.f973y = Long.MIN_VALUE;
            this.f1093a.f970v = -1;
            this.f1093a.f971w = Long.MIN_VALUE;
            this.f1093a.f963o = false;
            this.f1093a.m1505e();
            this.f1093a.requestLayout();
        }
    }

    /* compiled from: unknown_report_page */
    public interface OnItemClickListener {
        void mo367a(View view);
    }

    /* compiled from: unknown_report_page */
    public interface OnItemLongClickListener {
    }

    /* compiled from: unknown_report_page */
    public interface OnItemSelectedListener {
    }

    /* compiled from: unknown_report_page */
    class SelectionNotifier implements Runnable {
        final /* synthetic */ AdapterViewCompat f1095a;

        public SelectionNotifier(AdapterViewCompat adapterViewCompat) {
            this.f1095a = adapterViewCompat;
        }

        public void run() {
            if (!this.f1095a.f969u) {
                this.f1095a.mo338c();
            } else if (this.f1095a.getAdapter() != null) {
                this.f1095a.post(this);
            }
        }
    }

    public abstract T getAdapter();

    public abstract View getSelectedView();

    public abstract void setAdapter(T t);

    public abstract void setSelection(int i);

    AdapterViewCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f967s = onItemClickListener;
    }

    public final OnItemClickListener getOnItemClickListener() {
        return this.f967s;
    }

    public final boolean m1504a(View view, int i, long j) {
        if (this.f967s == null) {
            return false;
        }
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        this.f967s.mo367a(view);
        return true;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.f968t = onItemLongClickListener;
    }

    public final OnItemLongClickListener getOnItemLongClickListener() {
        return this.f968t;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.f966r = onItemSelectedListener;
    }

    public final OnItemSelectedListener getOnItemSelectedListener() {
        return this.f966r;
    }

    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    public void addView(View view, int i) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    public void addView(View view, LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    public void removeViewAt(int i) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f953a = getHeight();
    }

    public Object getSelectedItem() {
        Adapter adapter = getAdapter();
        int i = this.f970v;
        if (adapter == null || adapter.getCount() <= 0 || i < 0) {
            return null;
        }
        return adapter.getItem(i);
    }

    @CapturedViewProperty
    public int getCount() {
        return this.f974z;
    }

    public int getFirstVisiblePosition() {
        return this.f958j;
    }

    public int getLastVisiblePosition() {
        return (this.f958j + getChildCount()) - 1;
    }

    public void setEmptyView(View view) {
        this.f954b = view;
        Adapter adapter = getAdapter();
        boolean z = adapter == null || adapter.isEmpty();
        m1499a(z);
    }

    public View getEmptyView() {
        return this.f954b;
    }

    public void setFocusable(boolean z) {
        boolean z2 = true;
        Adapter adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.f955c = z;
        if (!z) {
            this.f956d = false;
        }
        if (!z || (z3 && null == null)) {
            z2 = false;
        }
        super.setFocusable(z2);
    }

    public void setFocusableInTouchMode(boolean z) {
        boolean z2 = true;
        Adapter adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.f956d = z;
        if (z) {
            this.f955c = true;
        }
        if (!z || (z3 && null == null)) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    final void m1505e() {
        boolean z;
        boolean z2 = false;
        Adapter adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        if (z3 && null == null) {
            z = false;
        } else {
            z = true;
        }
        if (z && this.f956d) {
            z3 = true;
        } else {
            z3 = false;
        }
        super.setFocusableInTouchMode(z3);
        if (z && this.f955c) {
            z3 = true;
        } else {
            z3 = false;
        }
        super.setFocusable(z3);
        if (this.f954b != null) {
            if (adapter == null || adapter.isEmpty()) {
                z2 = true;
            }
            m1499a(z2);
        }
    }

    private void m1499a(boolean z) {
        if (null != null) {
            z = false;
        }
        if (z) {
            if (this.f954b != null) {
                this.f954b.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.f969u) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        if (this.f954b != null) {
            this.f954b.setVisibility(8);
        }
        setVisibility(0);
    }

    private long m1496a(int i) {
        Adapter adapter = getAdapter();
        return (adapter == null || i < 0) ? Long.MIN_VALUE : adapter.getItemId(i);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 349265289);
        super.onDetachedFromWindow();
        removeCallbacks(this.f957e);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1801435388, a);
    }

    private void m1500b() {
        if (this.f966r != null) {
            if (this.f965q || this.f952D) {
                if (this.f957e == null) {
                    this.f957e = new SelectionNotifier(this);
                }
                post(this.f957e);
            } else {
                mo338c();
            }
        }
        if (this.f972x != -1 && isShown() && !isInTouchMode()) {
            sendAccessibilityEvent(4);
        }
    }

    private void mo338c() {
        if (this.f966r != null) {
            int i = this.f970v;
            if (i >= 0) {
                getSelectedView();
                getAdapter().getItemId(i);
            }
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        View selectedView = getSelectedView();
        if (selectedView != null && selectedView.getVisibility() == 0 && selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
            return true;
        }
        return false;
    }

    protected boolean canAnimate() {
        return super.canAnimate() && this.f974z > 0;
    }

    final void m1506f() {
        boolean z;
        int i = this.f974z;
        if (i > 0) {
            int d;
            boolean z2;
            if (this.f963o) {
                this.f963o = false;
                d = m1503d();
                if (d >= 0 && d == d) {
                    setNextSelectedPositionInt(d);
                    z2 = true;
                    if (!z2) {
                        d = this.f970v;
                        if (d >= i) {
                            d = i - 1;
                        }
                        if (d < 0) {
                            d = 0;
                        }
                        i = d;
                        if (i >= 0) {
                            d = d;
                        } else {
                            d = i;
                        }
                        if (d >= 0) {
                            setNextSelectedPositionInt(d);
                            m1507g();
                            z = true;
                        }
                    }
                    z = z2;
                }
            }
            z2 = false;
            if (z2) {
                d = this.f970v;
                if (d >= i) {
                    d = i - 1;
                }
                if (d < 0) {
                    d = 0;
                }
                i = d;
                if (i >= 0) {
                    d = i;
                } else {
                    d = d;
                }
                if (d >= 0) {
                    setNextSelectedPositionInt(d);
                    m1507g();
                    z = true;
                }
            }
            z = z2;
        } else {
            z = false;
        }
        if (!z) {
            this.f972x = -1;
            this.f973y = Long.MIN_VALUE;
            this.f970v = -1;
            this.f971w = Long.MIN_VALUE;
            this.f963o = false;
            m1507g();
        }
    }

    final void m1507g() {
        if (this.f972x != this.f950B || this.f973y != this.f951C) {
            m1500b();
            this.f950B = this.f972x;
            this.f951C = this.f973y;
        }
    }

    private int m1503d() {
        int i = this.f974z;
        if (i == 0) {
            return -1;
        }
        long j = this.f961m;
        int i2 = this.f960l;
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(i - 1, Math.max(0, i2));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        Object obj = null;
        Adapter adapter = getAdapter();
        if (adapter == null) {
            return -1;
        }
        int i3 = min;
        int i4 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (adapter.getItemId(i4) != j) {
                Object obj2 = min == i + -1 ? 1 : null;
                Object obj3 = i3 == 0 ? 1 : null;
                if (obj2 != null && obj3 != null) {
                    break;
                } else if (obj3 != null || (r0 != null && obj2 == null)) {
                    min++;
                    obj = null;
                    i4 = min;
                } else if (obj2 != null || (r0 == null && obj3 == null)) {
                    i3--;
                    obj = 1;
                    i4 = i3;
                }
            } else {
                return i4;
            }
        }
        return -1;
    }

    void setSelectedPositionInt(int i) {
        this.f972x = i;
        this.f973y = m1496a(i);
    }

    void setNextSelectedPositionInt(int i) {
        this.f970v = i;
        this.f971w = m1496a(i);
        if (this.f963o && this.f964p == 0 && i >= 0) {
            this.f960l = i;
            this.f961m = this.f971w;
        }
    }
}
