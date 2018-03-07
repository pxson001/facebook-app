package it.sephiroth.android.library.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import android.widget.Adapter;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativeediting.stickers.stickers.StickerPicker.C07843;

/* compiled from: viewed_photo */
public abstract class AdapterView<T extends Adapter> extends ViewGroup {
    @ExportedProperty(category = "scrolling")
    public int f416V = 0;
    protected int f417W;
    private int f418a;
    protected int aa;
    protected long ab = Long.MIN_VALUE;
    protected long ac;
    protected boolean ad = false;
    int ae;
    protected boolean af = false;
    OnItemSelectedListener ag;
    public C07843 ah;
    OnItemLongClickListener ai;
    public boolean aj;
    @ExportedProperty(category = "list")
    public int ak = -1;
    protected long al = Long.MIN_VALUE;
    @ExportedProperty(category = "list")
    protected int am = -1;
    protected long an = Long.MIN_VALUE;
    @ExportedProperty(category = "list")
    public int ao;
    protected int ap;
    AccessibilityManager aq;
    protected int ar = -1;
    protected long as = Long.MIN_VALUE;
    protected boolean at = false;
    private View f419b;
    private boolean f420c;
    private boolean f421d;
    private SelectionNotifier f422e;

    /* compiled from: viewed_photo */
    class AdapterDataSetObserver extends DataSetObserver {
        private Parcelable f375a = null;
        final /* synthetic */ AdapterView f376b;

        AdapterDataSetObserver(AdapterView adapterView) {
            this.f376b = adapterView;
        }

        public void onChanged() {
            this.f376b.aj = true;
            this.f376b.ap = this.f376b.ao;
            this.f376b.ao = this.f376b.getAdapter().getCount();
            if (!this.f376b.getAdapter().hasStableIds() || this.f375a == null || this.f376b.ap != 0 || this.f376b.ao <= 0) {
                this.f376b.m406o();
            } else {
                this.f376b.onRestoreInstanceState(this.f375a);
                this.f375a = null;
            }
            this.f376b.m403l();
            this.f376b.requestLayout();
        }

        public void onInvalidated() {
            this.f376b.aj = true;
            if (this.f376b.getAdapter().hasStableIds()) {
                this.f375a = this.f376b.onSaveInstanceState();
            }
            this.f376b.ap = this.f376b.ao;
            this.f376b.ao = 0;
            this.f376b.am = -1;
            this.f376b.an = Long.MIN_VALUE;
            this.f376b.ak = -1;
            this.f376b.al = Long.MIN_VALUE;
            this.f376b.ad = false;
            this.f376b.m403l();
            this.f376b.requestLayout();
        }
    }

    /* compiled from: viewed_photo */
    public class AdapterContextMenuInfo implements ContextMenuInfo {
        public View f470a;
        public int f471b;
        public long f472c;

        public AdapterContextMenuInfo(View view, int i, long j) {
            this.f470a = view;
            this.f471b = i;
            this.f472c = j;
        }
    }

    /* compiled from: viewed_photo */
    public interface OnItemLongClickListener {
        boolean m467a();
    }

    /* compiled from: viewed_photo */
    public interface OnItemSelectedListener {
    }

    /* compiled from: viewed_photo */
    class SelectionNotifier implements Runnable {
        final /* synthetic */ AdapterView f473a;

        public SelectionNotifier(AdapterView adapterView) {
            this.f473a = adapterView;
        }

        public void run() {
            if (!this.f473a.aj) {
                this.f473a.mo10c();
                this.f473a.mo11d();
            } else if (this.f473a.getAdapter() != null) {
                this.f473a.post(this);
            }
        }
    }

    public abstract T getAdapter();

    public abstract View getSelectedView();

    public abstract void setAdapter(T t);

    public abstract void setSelection(int i);

    public AdapterView(Context context) {
        super(context);
    }

    public AdapterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @TargetApi(16)
    public AdapterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (VERSION.SDK_INT >= 16 && getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        if (!isInEditMode()) {
            this.aq = (AccessibilityManager) getContext().getSystemService("accessibility");
        }
    }

    public final C07843 getOnItemClickListener() {
        return this.ah;
    }

    public boolean mo8a(View view, int i, long j) {
        if (this.ah == null) {
            return false;
        }
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        this.ah.m11548a(i);
        return true;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.ai = onItemLongClickListener;
    }

    public final OnItemLongClickListener getOnItemLongClickListener() {
        return this.ai;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.ag = onItemSelectedListener;
    }

    public final OnItemSelectedListener getOnItemSelectedListener() {
        return this.ag;
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
        this.f418a = getWidth();
    }

    @CapturedViewProperty
    public int getSelectedItemPosition() {
        return this.ak;
    }

    @CapturedViewProperty
    public long getSelectedItemId() {
        return this.al;
    }

    public Object getSelectedItem() {
        Adapter adapter = getAdapter();
        int i = this.ak;
        if (adapter == null || adapter.getCount() <= 0 || i < 0) {
            return null;
        }
        return adapter.getItem(i);
    }

    public final int m399a(View view) {
        while (true) {
            try {
                View view2 = (View) view.getParent();
                if (view2.equals(this)) {
                    break;
                }
                view = view2;
            } catch (ClassCastException e) {
                return -1;
            }
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).equals(view)) {
                return i + this.f416V;
            }
        }
        return -1;
    }

    public int getLastVisiblePosition() {
        return (this.f416V + getChildCount()) - 1;
    }

    @TargetApi(16)
    public void setEmptyView(View view) {
        boolean z = true;
        this.f419b = view;
        if (VERSION.SDK_INT >= 16 && view != null && view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        Adapter adapter = getAdapter();
        if (!(adapter == null || adapter.isEmpty())) {
            z = false;
        }
        mo7a(z);
    }

    public View getEmptyView() {
        return this.f419b;
    }

    public void setFocusable(boolean z) {
        boolean z2 = true;
        Adapter adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.f420c = z;
        if (!z) {
            this.f421d = false;
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
        this.f421d = z;
        if (z) {
            this.f420c = true;
        }
        if (!z || (z3 && null == null)) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    protected final void m403l() {
        boolean z;
        boolean z2 = false;
        Adapter adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        if (z3 && null == null) {
            z = false;
        } else {
            z = true;
        }
        if (z && this.f421d) {
            z3 = true;
        } else {
            z3 = false;
        }
        super.setFocusableInTouchMode(z3);
        if (z && this.f420c) {
            z3 = true;
        } else {
            z3 = false;
        }
        super.setFocusable(z3);
        if (this.f419b != null) {
            if (adapter == null || adapter.isEmpty()) {
                z2 = true;
            }
            mo7a(z2);
        }
    }

    @SuppressLint({"WrongCall"})
    private void mo7a(boolean z) {
        if (null != null) {
            z = false;
        }
        if (z) {
            if (this.f419b != null) {
                this.f419b.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.aj) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        if (this.f419b != null) {
            this.f419b.setVisibility(8);
        }
        setVisibility(0);
    }

    public final long m401d(int i) {
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
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2073138099);
        super.onDetachedFromWindow();
        removeCallbacks(this.f422e);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -568600485, a);
    }

    private void mo9b() {
        if (this.ag == null && !this.aq.isEnabled()) {
            return;
        }
        if (this.af || this.at) {
            if (this.f422e == null) {
                this.f422e = new SelectionNotifier(this);
            }
            post(this.f422e);
            return;
        }
        mo10c();
        mo11d();
    }

    private void mo10c() {
        if (this.ag != null) {
            int i = this.ak;
            if (i >= 0) {
                getSelectedView();
                getAdapter().getItemId(i);
            }
        }
    }

    private void mo11d() {
        if (this.aq.isEnabled() && this.ak >= 0) {
            sendAccessibilityEvent(4);
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        View selectedView = getSelectedView();
        if (selectedView != null && selectedView.getVisibility() == 0 && selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
            return true;
        }
        return false;
    }

    @TargetApi(14)
    public boolean onRequestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        if (!super.onRequestSendAccessibilityEvent(view, accessibilityEvent)) {
            return false;
        }
        AccessibilityRecord obtain = AccessibilityEvent.obtain();
        onInitializeAccessibilityEvent(obtain);
        view.dispatchPopulateAccessibilityEvent(obtain);
        accessibilityEvent.appendRecord(obtain);
        return true;
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AdapterView.class.getName());
        accessibilityNodeInfo.setScrollable(mo12e());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(AdapterView.class.getName());
        accessibilityEvent.setScrollable(mo12e());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityEvent.setEnabled(selectedView.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(this.ak);
        accessibilityEvent.setFromIndex(this.f416V);
        accessibilityEvent.setToIndex(getLastVisiblePosition());
        accessibilityEvent.setItemCount(this.ao);
    }

    private boolean mo12e() {
        Adapter adapter = getAdapter();
        if (adapter == null) {
            return false;
        }
        int count = adapter.getCount();
        if (count <= 0) {
            return false;
        }
        if (this.f416V > 0 || getLastVisiblePosition() < count - 1) {
            return true;
        }
        return false;
    }

    protected boolean canAnimate() {
        return super.canAnimate() && this.ao > 0;
    }

    void mo14k() {
        boolean z;
        int i = this.ao;
        if (i > 0) {
            int n;
            boolean z2;
            if (this.ad) {
                this.ad = false;
                n = m405n();
                if (n >= 0 && mo20a(n, true) == n) {
                    setNextSelectedPositionInt(n);
                    z2 = true;
                    if (!z2) {
                        n = this.ak;
                        if (n >= i) {
                            n = i - 1;
                        }
                        if (n < 0) {
                            n = 0;
                        }
                        i = mo20a(n, true);
                        if (i >= 0) {
                            n = mo20a(n, false);
                        } else {
                            n = i;
                        }
                        if (n >= 0) {
                            setNextSelectedPositionInt(n);
                            m404m();
                            z = true;
                        }
                    }
                    z = z2;
                }
            }
            z2 = false;
            if (z2) {
                n = this.ak;
                if (n >= i) {
                    n = i - 1;
                }
                if (n < 0) {
                    n = 0;
                }
                i = mo20a(n, true);
                if (i >= 0) {
                    n = i;
                } else {
                    n = mo20a(n, false);
                }
                if (n >= 0) {
                    setNextSelectedPositionInt(n);
                    m404m();
                    z = true;
                }
            }
            z = z2;
        } else {
            z = false;
        }
        if (!z) {
            this.am = -1;
            this.an = Long.MIN_VALUE;
            this.ak = -1;
            this.al = Long.MIN_VALUE;
            this.ad = false;
            m404m();
        }
    }

    protected final void m404m() {
        if (this.am != this.ar || this.an != this.as) {
            mo9b();
            this.ar = this.am;
            this.as = this.an;
        }
    }

    final int m405n() {
        int i = this.ao;
        if (i == 0) {
            return -1;
        }
        long j = this.ab;
        int i2 = this.aa;
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

    protected int mo20a(int i, boolean z) {
        return i;
    }

    protected void setSelectedPositionInt(int i) {
        this.am = i;
        this.an = m401d(i);
    }

    protected void setNextSelectedPositionInt(int i) {
        this.ak = i;
        this.al = m401d(i);
        if (this.ad && this.ae == 0 && i >= 0) {
            this.aa = i;
            this.ab = this.al;
        }
    }

    public final void m406o() {
        if (getChildCount() > 0) {
            this.ad = true;
            this.ac = (long) this.f418a;
            View childAt;
            if (this.am >= 0) {
                childAt = getChildAt(this.am - this.f416V);
                this.ab = this.al;
                this.aa = this.ak;
                if (childAt != null) {
                    this.f417W = childAt.getLeft();
                }
                this.ae = 0;
                return;
            }
            childAt = getChildAt(0);
            Adapter adapter = getAdapter();
            if (this.f416V < 0 || this.f416V >= adapter.getCount()) {
                this.ab = -1;
            } else {
                this.ab = adapter.getItemId(this.f416V);
            }
            this.aa = this.f416V;
            if (childAt != null) {
                this.f417W = childAt.getLeft();
            }
            this.ae = 1;
        }
    }
}
