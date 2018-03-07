package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v4.widget.ScrollerCompat;
import android.support.v7.widget.AdapterHelper.UpdateOp;
import android.support.v7.widget.ChildHelper.Callback;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.TraceCompatDetour;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: nux_admit_time_ms */
public class RecyclerView extends ViewGroup implements NestedScrollingChild, ScrollingView {
    public static final Interpolator an = new C04973();
    public static final boolean f11794h;
    private static final Class<?>[] f11795i = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    private boolean f11796A;
    private int f11797B;
    public boolean f11798C;
    public final boolean f11799D;
    private final AccessibilityManager f11800E;
    private List<OnChildAttachStateChangeListener> f11801F;
    public boolean f11802G;
    private int f11803H;
    private EdgeEffectCompat f11804I;
    private EdgeEffectCompat f11805J;
    private EdgeEffectCompat f11806K;
    private EdgeEffectCompat f11807L;
    public int f11808M;
    private int f11809N;
    private VelocityTracker f11810O;
    private int f11811P;
    private int f11812Q;
    private int f11813R;
    private int f11814S;
    private int f11815T;
    public final int f11816U;
    public final int f11817V;
    private float f11818W;
    final Recycler f11819a;
    public final ViewFlinger aa;
    private OnScrollListener ab;
    private List<OnScrollListener> ac;
    private ItemAnimatorListener ad;
    public boolean ae;
    public RecyclerViewAccessibilityDelegate af;
    private ChildDrawingOrderCallback ag;
    private final int[] ah;
    private final NestedScrollingChildHelper ai;
    private final int[] aj;
    private final int[] ak;
    private final int[] al;
    private Runnable am;
    AdapterHelper f11820b;
    ChildHelper f11821c;
    public ItemAnimator f11822d;
    final State f11823e;
    boolean f11824f;
    boolean f11825g;
    private final RecyclerViewDataObserver f11826j;
    private SavedState f11827k;
    public boolean f11828l;
    public final Runnable f11829m;
    private final Rect f11830n;
    public Adapter f11831o;
    public LayoutManager f11832p;
    public RecyclerListener f11833q;
    public final ArrayList<ItemDecoration> f11834r;
    private final ArrayList<OnItemTouchListener> f11835s;
    private OnItemTouchListener f11836t;
    public boolean f11837u;
    public boolean f11838v;
    public boolean f11839w;
    private boolean f11840x;
    public boolean f11841y;
    private boolean f11842z;

    /* compiled from: nux_admit_time_ms */
    public abstract class AdapterDataObserver {
        public void bb_() {
        }

        public void mo2217a(int i, int i2) {
        }

        public void mo2234a(int i, int i2, Object obj) {
            mo2217a(i, i2);
        }

        public void mo2210b(int i, int i2) {
        }

        public void mo2212c(int i, int i2) {
        }

        public void mo2218a(int i, int i2, int i3) {
        }
    }

    /* compiled from: nux_admit_time_ms */
    public interface OnItemTouchListener {
        void mo2213a(boolean z);

        boolean mo2214a(MotionEvent motionEvent);

        void mo2215b(MotionEvent motionEvent);
    }

    /* compiled from: nux_admit_time_ms */
    public abstract class OnScrollListener {
        public void mo2219a(RecyclerView recyclerView, int i) {
        }

        public void mo2220a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* compiled from: nux_admit_time_ms */
    public abstract class Adapter<VH extends ViewHolder> {
        private final AdapterDataObservable f11865a = new AdapterDataObservable();
        private boolean f11866b = false;

        public abstract VH mo2222a(ViewGroup viewGroup, int i);

        public abstract void mo2225a(VH vh, int i);

        public abstract int aZ_();

        private void m17215c(VH vh, int i) {
            mo2225a((ViewHolder) vh, i);
        }

        public final VH m17222b(ViewGroup viewGroup, int i) {
            TraceCompatDetour.a("RV CreateView", -1944962122);
            VH a = mo2222a(viewGroup, i);
            a.f14099e = i;
            TraceCompatDetour.a(-132146722);
            return a;
        }

        public final void m17225b(VH vh, int i) {
            vh.f14096b = i;
            if (en_()) {
                vh.f14098d = H_(i);
            }
            vh.m20395a(1, 519);
            TraceCompatDetour.a("RV OnBindView", -1695284597);
            vh.m20421t();
            mo2225a((ViewHolder) vh, i);
            vh.m20420s();
            TraceCompatDetour.a(1628917863);
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public void m17221a(boolean z) {
            if (iz_()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.f11866b = z;
        }

        public long H_(int i) {
            return -1;
        }

        public final boolean en_() {
            return this.f11866b;
        }

        public void mo2224a(VH vh) {
        }

        public boolean mo2228b(VH vh) {
            return false;
        }

        public void mo2229c(VH vh) {
        }

        public void mo2230d(VH vh) {
        }

        public final boolean iz_() {
            return this.f11865a.m18026a();
        }

        public void mo2223a(AdapterDataObserver adapterDataObserver) {
            this.f11865a.registerObserver(adapterDataObserver);
        }

        public void mo2227b(AdapterDataObserver adapterDataObserver) {
            this.f11865a.unregisterObserver(adapterDataObserver);
        }

        public void a_(RecyclerView recyclerView) {
        }

        public void m17226b(RecyclerView recyclerView) {
        }

        public final void notifyDataSetChanged() {
            this.f11865a.m18027b();
        }

        public final void j_(int i) {
            this.f11865a.m18025a(i, 1);
        }

        public final void m17217a(int i, int i2) {
            this.f11865a.m18025a(i, i2);
        }

        public final void k_(int i) {
            this.f11865a.m18028b(i, 1);
        }

        public final void m17223b(int i, int i2) {
            this.f11865a.m18030d(i, i2);
        }

        public final void m17228c(int i, int i2) {
            this.f11865a.m18028b(i, i2);
        }

        public final void l_(int i) {
            this.f11865a.m18029c(i, 1);
        }

        public final void m17230d(int i, int i2) {
            this.f11865a.m18029c(i, i2);
        }
    }

    /* compiled from: nux_admit_time_ms */
    public abstract class LayoutManager {
        public boolean f11872a = false;
        public boolean f11873b = false;
        ChildHelper f11874q;
        RecyclerView f11875r;
        @Nullable
        SmoothScroller f11876s;

        public abstract LayoutParams mo2301b();

        final void m17305a(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f11875r = null;
                this.f11874q = null;
                return;
            }
            this.f11875r = recyclerView;
            this.f11874q = recyclerView.f11821c;
        }

        public final void m17362p() {
            if (this.f11875r != null) {
                this.f11875r.requestLayout();
            }
        }

        public void mo2309a(String str) {
            if (this.f11875r != null) {
                this.f11875r.m17149a(str);
            }
        }

        public boolean mo2320e() {
            return false;
        }

        final void m17330b(RecyclerView recyclerView) {
            this.f11873b = true;
        }

        final void m17331b(RecyclerView recyclerView, Recycler recycler) {
            this.f11873b = false;
            mo2295a(recyclerView, recycler);
        }

        public final boolean m17363q() {
            return this.f11873b;
        }

        public final void m17317a(Runnable runnable) {
            if (this.f11875r != null) {
                ViewCompat.m10943a(this.f11875r, runnable);
            }
        }

        public final boolean m17335b(Runnable runnable) {
            if (this.f11875r != null) {
                return this.f11875r.removeCallbacks(runnable);
            }
            return false;
        }

        @CallSuper
        public void mo2295a(RecyclerView recyclerView, Recycler recycler) {
        }

        public final boolean m17364r() {
            return this.f11875r != null && this.f11875r.f11828l;
        }

        public void mo2314c(Recycler recycler, State state) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public boolean m17320a(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public LayoutParams m17294a(android.view.ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof MarginLayoutParams) {
                return new LayoutParams((MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public LayoutParams m17293a(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public int mo2305a(int i, Recycler recycler, State state) {
            return 0;
        }

        public int mo2300b(int i, Recycler recycler, State state) {
            return 0;
        }

        public boolean mo2324g() {
            return false;
        }

        public boolean mo2325h() {
            return false;
        }

        public void mo2319e(int i) {
        }

        public void mo2298a(RecyclerView recyclerView, State state, int i) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public final void m17304a(SmoothScroller smoothScroller) {
            if (!(this.f11876s == null || smoothScroller == this.f11876s || !this.f11876s.e)) {
                this.f11876s.e();
            }
            this.f11876s = smoothScroller;
            this.f11876s.a(this.f11875r, this);
        }

        public final boolean m17365s() {
            return this.f11876s != null && this.f11876s.e;
        }

        public final int m17366t() {
            return ViewCompat.m10967h(this.f11875r);
        }

        public final void m17309a(View view) {
            m17310a(view, -1);
        }

        public final void m17310a(View view, int i) {
            m17262a(view, i, true);
        }

        public void m17332b(View view) {
            mo2303b(view, -1);
        }

        public void mo2303b(View view, int i) {
            m17262a(view, i, false);
        }

        private void m17262a(View view, int i, boolean z) {
            ViewHolder b = RecyclerView.m17080b(view);
            if (z || b.m20418q()) {
                this.f11875r.f11823e.m17550b(view);
            } else {
                this.f11875r.f11823e.m17548a(view);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (b.m20411j() || b.m20409h()) {
                if (b.m20409h()) {
                    b.m20410i();
                } else {
                    b.m20412k();
                }
                this.f11874q.m17609a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f11875r) {
                int b2 = this.f11874q.m17612b(view);
                if (i == -1) {
                    i = this.f11874q.m17611b();
                }
                if (b2 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f11875r.indexOfChild(view));
                } else if (b2 != i) {
                    this.f11875r.f11832p.mo2317d(b2, i);
                }
            } else {
                this.f11874q.m17610a(view, i, false);
                layoutParams.f14112c = true;
                if (this.f11876s != null && this.f11876s.e) {
                    this.f11876s.a(view);
                }
            }
            if (layoutParams.f14113d) {
                b.f14095a.invalidate();
                layoutParams.f14113d = false;
            }
        }

        private void m17279l(View view) {
            this.f11874q.m17608a(view);
        }

        private void m17257a(int i) {
            if (m17351f(i) != null) {
                this.f11874q.m17607a(i);
            }
        }

        public static int m17284u() {
            return -1;
        }

        public static int m17269c(View view) {
            return ((LayoutParams) view.getLayoutParams()).m20426e();
        }

        public View mo2312c(int i) {
            int v = m17367v();
            for (int i2 = 0; i2 < v; i2++) {
                View f = m17351f(i2);
                ViewHolder b = RecyclerView.m17080b(f);
                if (b != null && b.m20405d() == i && !b.m20404c() && (this.f11875r.f11823e.f11944k || !b.m20418q())) {
                    return f;
                }
            }
            return null;
        }

        public final void m17343d(View view) {
            int b = this.f11874q.m17612b(view);
            if (b >= 0) {
                mo2316d(b);
            }
        }

        private void mo2302b(int i) {
            m17351f(i);
            mo2316d(i);
        }

        private void mo2316d(int i) {
            this.f11874q.m17617d(i);
        }

        private void m17261a(View view, int i, LayoutParams layoutParams) {
            ViewHolder b = RecyclerView.m17080b(view);
            if (b.m20418q()) {
                this.f11875r.f11823e.m17550b(view);
            } else {
                this.f11875r.f11823e.m17548a(view);
            }
            this.f11874q.m17609a(view, i, layoutParams, b.m20418q());
        }

        private void m17270c(View view, int i) {
            m17261a(view, i, (LayoutParams) view.getLayoutParams());
        }

        public final void m17347e(View view) {
            m17270c(view, -1);
        }

        private void mo2317d(int i, int i2) {
            View f = m17351f(i);
            if (f == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i);
            }
            mo2302b(i);
            m17270c(f, i2);
        }

        public void mo2296a(View view, Recycler recycler) {
            m17279l(view);
            recycler.m17427a(view);
        }

        public void mo2292a(int i, Recycler recycler) {
            View f = m17351f(i);
            m17257a(i);
            recycler.m17427a(f);
        }

        public final int m17367v() {
            return this.f11874q != null ? this.f11874q.m17611b() : 0;
        }

        public final View m17351f(int i) {
            return this.f11874q != null ? this.f11874q.m17613b(i) : null;
        }

        public final int m17368w() {
            return this.f11875r != null ? this.f11875r.getWidth() : 0;
        }

        public final int m17369x() {
            return this.f11875r != null ? this.f11875r.getHeight() : 0;
        }

        public final int m17370y() {
            return this.f11875r != null ? this.f11875r.getPaddingLeft() : 0;
        }

        public final int m17371z() {
            return this.f11875r != null ? this.f11875r.getPaddingTop() : 0;
        }

        public final int m17285A() {
            return this.f11875r != null ? this.f11875r.getPaddingRight() : 0;
        }

        public final int m17286B() {
            return this.f11875r != null ? this.f11875r.getPaddingBottom() : 0;
        }

        public final View m17287C() {
            if (this.f11875r == null) {
                return null;
            }
            View focusedChild = this.f11875r.getFocusedChild();
            if (focusedChild == null || this.f11874q.m17616c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public final int m17288D() {
            Adapter adapter;
            if (this.f11875r != null) {
                adapter = this.f11875r.f11831o;
            } else {
                adapter = null;
            }
            return adapter != null ? adapter.aZ_() : 0;
        }

        public void m17353g(int i) {
            if (this.f11875r != null) {
                this.f11875r.m17165e(i);
            }
        }

        public void m17356h(int i) {
            if (this.f11875r != null) {
                this.f11875r.mo2193d(i);
            }
        }

        public void mo2294a(Recycler recycler) {
            for (int v = m17367v() - 1; v >= 0; v--) {
                m17259a(recycler, v, m17351f(v));
            }
        }

        private void m17259a(Recycler recycler, int i, View view) {
            ViewHolder b = RecyclerView.m17080b(view);
            if (!b.m20404c()) {
                if (!b.m20414m() || b.m20418q() || b.m20416o() || this.f11875r.f11831o.en_()) {
                    mo2302b(i);
                    recycler.m17436c(view);
                    return;
                }
                m17257a(i);
                recycler.m17426a(b);
            }
        }

        final void m17329b(Recycler recycler) {
            int c = recycler.m17433c();
            for (int i = c - 1; i >= 0; i--) {
                View d = recycler.m17437d(i);
                ViewHolder b = RecyclerView.m17080b(d);
                if (!b.m20404c()) {
                    b.m20400a(false);
                    if (b.m20419r()) {
                        this.f11875r.removeDetachedView(d, false);
                    }
                    if (this.f11875r.f11822d != null) {
                        this.f11875r.f11822d.mo2242c(b);
                    }
                    b.m20400a(true);
                    recycler.m17432b(d);
                }
            }
            recycler.m17438d();
            if (c > 0) {
                this.f11875r.invalidate();
            }
        }

        public final void m17311a(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect g = this.f11875r.m17171g(view);
            view.measure(m17256a(m17368w(), ((g.left + g.right) + i) + (m17370y() + m17285A()), layoutParams.width, mo2324g()), m17256a(m17369x(), ((g.bottom + g.top) + i2) + (m17371z() + m17286B()), layoutParams.height, mo2325h()));
        }

        public void mo2304b(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect g = this.f11875r.m17171g(view);
            view.measure(m17256a(m17368w(), ((g.left + g.right) + i) + (((m17370y() + m17285A()) + layoutParams.leftMargin) + layoutParams.rightMargin), layoutParams.width, mo2324g()), m17256a(m17369x(), ((g.bottom + g.top) + i2) + (((m17371z() + m17286B()) + layoutParams.topMargin) + layoutParams.bottomMargin), layoutParams.height, mo2325h()));
        }

        private static int m17256a(int i, int i2, int i3, boolean z) {
            int i4 = 1073741824;
            int max = Math.max(0, i - i2);
            if (z) {
                if (i3 < 0) {
                    i4 = 0;
                    i3 = 0;
                }
            } else if (i3 < 0) {
                if (i3 == -1) {
                    i3 = max;
                } else if (i3 == -2) {
                    i4 = Integer.MIN_VALUE;
                    i3 = max;
                } else {
                    i4 = 0;
                    i3 = 0;
                }
            }
            return MeasureSpec.makeMeasureSpec(i3, i4);
        }

        public static int m17275f(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f14111b;
            return rect.right + (view.getMeasuredWidth() + rect.left);
        }

        public static int m17276g(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f14111b;
            return rect.bottom + (view.getMeasuredHeight() + rect.top);
        }

        public void mo2299a(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f14111b;
            view.layout(rect.left + i, rect.top + i2, i3 - rect.right, i4 - rect.bottom);
        }

        public final int m17355h(View view) {
            return view.getLeft() - m17282o(view);
        }

        public final int m17358i(View view) {
            return view.getTop() - m17280m(view);
        }

        public final int m17360j(View view) {
            return view.getRight() + m17283p(view);
        }

        public final int m17361k(View view) {
            return view.getBottom() + m17281n(view);
        }

        public final void m17313a(View view, Rect rect) {
            if (this.f11875r == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.f11875r.m17171g(view));
            }
        }

        private static int m17280m(View view) {
            return ((LayoutParams) view.getLayoutParams()).f14111b.top;
        }

        private static int m17281n(View view) {
            return ((LayoutParams) view.getLayoutParams()).f14111b.bottom;
        }

        private static int m17282o(View view) {
            return ((LayoutParams) view.getLayoutParams()).f14111b.left;
        }

        private static int m17283p(View view) {
            return ((LayoutParams) view.getLayoutParams()).f14111b.right;
        }

        @Nullable
        public View mo2313c(int i, Recycler recycler, State state) {
            return null;
        }

        public static View m17254E() {
            return null;
        }

        public final boolean m17321a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int y = m17370y();
            int z2 = m17371z();
            int w = m17368w() - m17285A();
            int x = m17369x() - m17286B();
            int left = view.getLeft() + rect.left;
            int top = view.getTop() + rect.top;
            int width = left + rect.width();
            int height = top + rect.height();
            int min = Math.min(0, left - y);
            int min2 = Math.min(0, top - z2);
            int max = Math.max(0, width - w);
            x = Math.max(0, height - x);
            if (m17366t() == 1) {
                if (max == 0) {
                    max = Math.max(min, width - w);
                }
                min = max;
            } else {
                min = min != 0 ? min : Math.min(left - y, max);
            }
            max = min2 != 0 ? min2 : Math.min(top - z2, x);
            if (min == 0 && max == 0) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(min, max);
            } else {
                recyclerView.m17142a(min, max);
            }
            return true;
        }

        @Deprecated
        private boolean m17271c(RecyclerView recyclerView) {
            return m17365s() || recyclerView.m17167e();
        }

        public final boolean m17322a(RecyclerView recyclerView, View view, View view2) {
            return m17271c(recyclerView);
        }

        public void mo2293a(Adapter adapter, Adapter adapter2) {
        }

        public static boolean m17255F() {
            return false;
        }

        public void m17295a() {
        }

        public void m17296a(int i, int i2) {
        }

        public void m17328b(int i, int i2) {
        }

        public void m17306a(RecyclerView recyclerView, int i, int i2) {
        }

        public void m17339c(int i, int i2) {
        }

        public int mo2315d(State state) {
            return 0;
        }

        public int mo2310b(State state) {
            return 0;
        }

        public int mo2321f(State state) {
            return 0;
        }

        public int mo2318e(State state) {
            return 0;
        }

        public int mo2311c(State state) {
            return 0;
        }

        public int mo2323g(State state) {
            return 0;
        }

        public void m17302a(Recycler recycler, State state, int i, int i2) {
            this.f11875r.m17102h(i, i2);
        }

        public final void m17346e(int i, int i2) {
            this.f11875r.setMeasuredDimension(i, i2);
        }

        public Parcelable mo2322f() {
            return null;
        }

        public void mo2306a(Parcelable parcelable) {
        }

        final void m17289G() {
            if (this.f11876s != null) {
                this.f11876s.e();
            }
        }

        public static void m17266b(LayoutManager layoutManager, SmoothScroller smoothScroller) {
            if (layoutManager.f11876s == smoothScroller) {
                layoutManager.f11876s = null;
            }
        }

        public void m17359i(int i) {
        }

        public final void m17340c(Recycler recycler) {
            for (int v = m17367v() - 1; v >= 0; v--) {
                if (!RecyclerView.m17080b(m17351f(v)).m20404c()) {
                    mo2292a(v, recycler);
                }
            }
        }

        final void m17299a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            m17260a(this.f11875r.f11819a, this.f11875r.f11823e, accessibilityNodeInfoCompat);
        }

        private void m17260a(Recycler recycler, State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (ViewCompat.m10953b(this.f11875r, -1) || ViewCompat.m10946a(this.f11875r, -1)) {
                accessibilityNodeInfoCompat.a(8192);
                accessibilityNodeInfoCompat.i(true);
            }
            if (ViewCompat.m10953b(this.f11875r, 1) || ViewCompat.m10946a(this.f11875r, 1)) {
                accessibilityNodeInfoCompat.a(4096);
                accessibilityNodeInfoCompat.i(true);
            }
            accessibilityNodeInfoCompat.a(new CollectionInfoCompat(AccessibilityNodeInfoCompat.a.a(m17292a(recycler, state), m17325b(recycler, state), false, 0)));
        }

        public void mo2308a(AccessibilityEvent accessibilityEvent) {
            Recycler recycler = this.f11875r.f11819a;
            State state = this.f11875r.f11823e;
            m17267b(accessibilityEvent);
        }

        private void m17267b(AccessibilityEvent accessibilityEvent) {
            boolean z = true;
            AccessibilityRecordCompat a = AccessibilityEventCompat.a(accessibilityEvent);
            if (this.f11875r != null && a != null) {
                if (!(ViewCompat.m10953b(this.f11875r, 1) || ViewCompat.m10953b(this.f11875r, -1) || ViewCompat.m10946a(this.f11875r, -1) || ViewCompat.m10946a(this.f11875r, 1))) {
                    z = false;
                }
                a.a(z);
                if (this.f11875r.f11831o != null) {
                    a.a(this.f11875r.f11831o.aZ_());
                }
            }
        }

        final void m17314a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder b = RecyclerView.m17080b(view);
            if (b != null && !b.m20418q() && !this.f11874q.m17616c(b.f14095a)) {
                m17303a(this.f11875r.f11819a, this.f11875r.f11823e, view, accessibilityNodeInfoCompat);
            }
        }

        public void m17303a(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int c;
            int c2 = mo2325h() ? m17269c(view) : 0;
            if (mo2324g()) {
                c = m17269c(view);
            } else {
                c = 0;
            }
            accessibilityNodeInfoCompat.b(CollectionItemInfoCompat.a(c2, 1, c, 1, false, false));
        }

        public final void m17290H() {
            this.f11872a = true;
        }

        private static int m17268c() {
            return 0;
        }

        public int m17292a(Recycler recycler, State state) {
            if (this.f11875r == null || this.f11875r.f11831o == null || !mo2325h()) {
                return 1;
            }
            return this.f11875r.f11831o.aZ_();
        }

        public int m17325b(Recycler recycler, State state) {
            if (this.f11875r == null || this.f11875r.f11831o == null || !mo2324g()) {
                return 1;
            }
            return this.f11875r.f11831o.aZ_();
        }

        private static boolean m17274d() {
            return false;
        }

        final boolean m17319a(int i, Bundle bundle) {
            Recycler recycler = this.f11875r.f11819a;
            State state = this.f11875r.f11823e;
            return m17278j(i);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean m17278j(int r7) {
            /*
            r6 = this;
            r4 = -1;
            r2 = 1;
            r1 = 0;
            r0 = r6.f11875r;
            if (r0 != 0) goto L_0x0008;
        L_0x0007:
            return r1;
        L_0x0008:
            switch(r7) {
                case 4096: goto L_0x004a;
                case 8192: goto L_0x0018;
                default: goto L_0x000b;
            };
        L_0x000b:
            r0 = r1;
            r3 = r1;
        L_0x000d:
            if (r3 != 0) goto L_0x0011;
        L_0x000f:
            if (r0 == 0) goto L_0x0007;
        L_0x0011:
            r1 = r6.f11875r;
            r1.scrollBy(r0, r3);
            r1 = r2;
            goto L_0x0007;
        L_0x0018:
            r0 = r6.f11875r;
            r0 = android.support.v4.view.ViewCompat.m10953b(r0, r4);
            if (r0 == 0) goto L_0x007f;
        L_0x0020:
            r0 = r6.m17369x();
            r3 = r6.m17371z();
            r0 = r0 - r3;
            r3 = r6.m17286B();
            r0 = r0 - r3;
            r0 = -r0;
        L_0x002f:
            r3 = r6.f11875r;
            r3 = android.support.v4.view.ViewCompat.m10946a(r3, r4);
            if (r3 == 0) goto L_0x007a;
        L_0x0037:
            r3 = r6.m17368w();
            r4 = r6.m17370y();
            r3 = r3 - r4;
            r4 = r6.m17285A();
            r3 = r3 - r4;
            r3 = -r3;
            r5 = r3;
            r3 = r0;
            r0 = r5;
            goto L_0x000d;
        L_0x004a:
            r0 = r6.f11875r;
            r0 = android.support.v4.view.ViewCompat.m10953b(r0, r2);
            if (r0 == 0) goto L_0x007d;
        L_0x0052:
            r0 = r6.m17369x();
            r3 = r6.m17371z();
            r0 = r0 - r3;
            r3 = r6.m17286B();
            r0 = r0 - r3;
        L_0x0060:
            r3 = r6.f11875r;
            r3 = android.support.v4.view.ViewCompat.m10946a(r3, r2);
            if (r3 == 0) goto L_0x007a;
        L_0x0068:
            r3 = r6.m17368w();
            r4 = r6.m17370y();
            r3 = r3 - r4;
            r4 = r6.m17285A();
            r3 = r3 - r4;
            r5 = r3;
            r3 = r0;
            r0 = r5;
            goto L_0x000d;
        L_0x007a:
            r3 = r0;
            r0 = r1;
            goto L_0x000d;
        L_0x007d:
            r0 = r1;
            goto L_0x0060;
        L_0x007f:
            r0 = r1;
            goto L_0x002f;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.LayoutManager.j(int):boolean");
        }

        final boolean m17323a(View view, int i, Bundle bundle) {
            Recycler recycler = this.f11875r.f11819a;
            State state = this.f11875r.f11823e;
            return false;
        }

        private static boolean mo2326i() {
            return false;
        }
    }

    /* compiled from: nux_admit_time_ms */
    public interface RecyclerListener {
        void mo2653a(ViewHolder viewHolder);
    }

    /* compiled from: nux_admit_time_ms */
    final class C04973 implements Interpolator {
        C04973() {
        }

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    /* compiled from: nux_admit_time_ms */
    class RecyclerViewDataObserver extends AdapterDataObserver {
        final /* synthetic */ RecyclerView f11897a;

        public RecyclerViewDataObserver(RecyclerView recyclerView) {
            this.f11897a = recyclerView;
        }

        public final void bb_() {
            this.f11897a.m17149a(null);
            if (this.f11897a.f11831o.en_()) {
                this.f11897a.f11823e.f11943j = true;
                RecyclerView.m17056H(this.f11897a);
            } else {
                this.f11897a.f11823e.f11943j = true;
                RecyclerView.m17056H(this.f11897a);
            }
            if (!this.f11897a.f11820b.m17579d()) {
                this.f11897a.requestLayout();
            }
        }

        public final void mo2234a(int i, int i2, Object obj) {
            this.f11897a.m17149a(null);
            AdapterHelper adapterHelper = this.f11897a.f11820b;
            Object obj2 = 1;
            adapterHelper.f11949a.add(adapterHelper.mo2260a(2, i, i2, obj));
            if (adapterHelper.f11949a.size() != 1) {
                obj2 = null;
            }
            if (obj2 != null) {
                m17401b();
            }
        }

        public final void mo2210b(int i, int i2) {
            this.f11897a.m17149a(null);
            AdapterHelper adapterHelper = this.f11897a.f11820b;
            int i3 = 1;
            adapterHelper.f11949a.add(adapterHelper.mo2260a(0, i, i2, null));
            if (adapterHelper.f11949a.size() != 1) {
                i3 = 0;
            }
            if (i3 != 0) {
                m17401b();
            }
        }

        public final void mo2212c(int i, int i2) {
            this.f11897a.m17149a(null);
            AdapterHelper adapterHelper = this.f11897a.f11820b;
            int i3 = 1;
            adapterHelper.f11949a.add(adapterHelper.mo2260a(1, i, i2, null));
            if (adapterHelper.f11949a.size() != 1) {
                i3 = 0;
            }
            if (i3 != 0) {
                m17401b();
            }
        }

        public final void mo2218a(int i, int i2, int i3) {
            this.f11897a.m17149a(null);
            if (this.f11897a.f11820b.m17576a(i, i2, i3)) {
                m17401b();
            }
        }

        private void m17401b() {
            if (this.f11897a.f11799D && this.f11897a.f11838v && this.f11897a.f11837u) {
                ViewCompat.m10943a(this.f11897a, this.f11897a.f11829m);
                return;
            }
            this.f11897a.f11798C = true;
            this.f11897a.requestLayout();
        }
    }

    /* compiled from: nux_admit_time_ms */
    public final class Recycler {
        final ArrayList<ViewHolder> f11898a = new ArrayList();
        final ArrayList<ViewHolder> f11899b = new ArrayList();
        final /* synthetic */ RecyclerView f11900c;
        public ArrayList<ViewHolder> f11901d = null;
        public final List<ViewHolder> f11902e = Collections.unmodifiableList(this.f11898a);
        private int f11903f = 2;
        private RecycledViewPool f11904g;
        public ViewCacheExtension f11905h;

        public Recycler(RecyclerView recyclerView) {
            this.f11900c = recyclerView;
        }

        public final void m17419a() {
            this.f11898a.clear();
            m17418j();
        }

        public final void m17420a(int i) {
            this.f11903f = i;
            for (int size = this.f11899b.size() - 1; size >= 0 && this.f11899b.size() > i; size--) {
                m17414e(size);
            }
        }

        public final List<ViewHolder> m17429b() {
            return this.f11902e;
        }

        private boolean m17411c(ViewHolder viewHolder) {
            if (viewHolder.m20418q()) {
                return true;
            }
            if (viewHolder.f14096b < 0 || viewHolder.f14096b >= this.f11900c.f11831o.aZ_()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + viewHolder);
            } else if (!this.f11900c.f11823e.f11944k && this.f11900c.f11831o.getItemViewType(viewHolder.f14096b) != viewHolder.f14099e) {
                return false;
            } else {
                if (!this.f11900c.f11831o.en_() || viewHolder.f14098d == this.f11900c.f11831o.H_(viewHolder.f14096b)) {
                    return true;
                }
                return false;
            }
        }

        public final int m17428b(int i) {
            if (i >= 0 && i < this.f11900c.f11823e.m17554e()) {
                return !this.f11900c.f11823e.f11944k ? i : this.f11900c.f11820b.m17572a(i);
            } else {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + this.f11900c.f11823e.m17554e());
            }
        }

        public final View m17434c(int i) {
            return m17407a(i, false);
        }

        private View m17407a(int i, boolean z) {
            boolean z2 = true;
            if (i < 0 || i >= this.f11900c.f11823e.m17554e()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + this.f11900c.f11823e.m17554e());
            }
            boolean z3;
            ViewHolder viewHolder;
            boolean z4;
            int a;
            ViewHolder b;
            boolean z5;
            int a2;
            android.view.ViewGroup.LayoutParams layoutParams;
            LayoutParams layoutParams2;
            if (this.f11900c.f11823e.f11944k) {
                ViewHolder f = m17416f(i);
                ViewHolder viewHolder2 = f;
                z3 = f != null;
                viewHolder = viewHolder2;
            } else {
                viewHolder = null;
                z3 = false;
            }
            if (viewHolder == null) {
                viewHolder = m17410b(i, -1, z);
                if (viewHolder != null) {
                    if (m17411c(viewHolder)) {
                        z4 = true;
                    } else {
                        if (!z) {
                            viewHolder.m20403b(4);
                            if (viewHolder.m20409h()) {
                                this.f11900c.removeDetachedView(viewHolder.f14095a, false);
                                viewHolder.m20410i();
                            } else if (viewHolder.m20411j()) {
                                viewHolder.m20412k();
                            }
                            m17426a(viewHolder);
                        }
                        viewHolder = null;
                        z4 = z3;
                    }
                    if (viewHolder == null) {
                        a = this.f11900c.f11820b.m17572a(i);
                        if (a >= 0 || a >= this.f11900c.f11831o.aZ_()) {
                            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + a + ").state:" + this.f11900c.f11823e.m17554e());
                        }
                        int itemViewType = this.f11900c.f11831o.getItemViewType(a);
                        if (this.f11900c.f11831o.en_()) {
                            viewHolder = m17406a(this.f11900c.f11831o.H_(a), itemViewType, z);
                            if (viewHolder != null) {
                                viewHolder.f14096b = a;
                                z4 = true;
                            }
                        }
                        if (viewHolder == null && this.f11905h != null) {
                            View a3 = this.f11905h.mo2338a(i, itemViewType);
                            if (a3 != null) {
                                viewHolder = this.f11900c.m17138a(a3);
                                if (viewHolder == null) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                                } else if (viewHolder.m20404c()) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                                }
                            }
                        }
                        if (viewHolder == null) {
                            viewHolder = m17439e().m20110a(itemViewType);
                            if (viewHolder != null) {
                                viewHolder.m20422u();
                                if (RecyclerView.f11794h) {
                                    m17412d(viewHolder);
                                }
                            }
                        }
                        if (viewHolder == null) {
                            z3 = z4;
                            b = this.f11900c.f11831o.m17222b(this.f11900c, itemViewType);
                            if (!this.f11900c.f11823e.f11944k && b.m20417p()) {
                                b.f14100f = i;
                                z5 = false;
                            } else if (b.m20417p() || b.m20415n() || b.m20414m()) {
                                a2 = this.f11900c.f11820b.m17572a(i);
                                b.f14105k = this.f11900c;
                                this.f11900c.f11831o.m17225b(b, a2);
                                m17413d(b.f14095a);
                                if (this.f11900c.f11823e.f11944k) {
                                    b.f14100f = i;
                                }
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            layoutParams = b.f14095a.getLayoutParams();
                            if (layoutParams != null) {
                                layoutParams2 = (LayoutParams) this.f11900c.generateDefaultLayoutParams();
                                b.f14095a.setLayoutParams(layoutParams2);
                            } else if (this.f11900c.checkLayoutParams(layoutParams)) {
                                layoutParams2 = (LayoutParams) layoutParams;
                            } else {
                                layoutParams2 = (LayoutParams) this.f11900c.generateLayoutParams(layoutParams);
                                b.f14095a.setLayoutParams(layoutParams2);
                            }
                            layoutParams2.f14110a = b;
                            if (!(z3 && r5)) {
                                z2 = false;
                            }
                            layoutParams2.f14113d = z2;
                            return b.f14095a;
                        }
                    }
                    z3 = z4;
                    b = viewHolder;
                    if (!this.f11900c.f11823e.f11944k) {
                    }
                    if (b.m20417p()) {
                    }
                    a2 = this.f11900c.f11820b.m17572a(i);
                    b.f14105k = this.f11900c;
                    this.f11900c.f11831o.m17225b(b, a2);
                    m17413d(b.f14095a);
                    if (this.f11900c.f11823e.f11944k) {
                        b.f14100f = i;
                    }
                    z5 = true;
                    layoutParams = b.f14095a.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams2 = (LayoutParams) this.f11900c.generateDefaultLayoutParams();
                        b.f14095a.setLayoutParams(layoutParams2);
                    } else if (this.f11900c.checkLayoutParams(layoutParams)) {
                        layoutParams2 = (LayoutParams) layoutParams;
                    } else {
                        layoutParams2 = (LayoutParams) this.f11900c.generateLayoutParams(layoutParams);
                        b.f14095a.setLayoutParams(layoutParams2);
                    }
                    layoutParams2.f14110a = b;
                    z2 = false;
                    layoutParams2.f14113d = z2;
                    return b.f14095a;
                }
            }
            z4 = z3;
            if (viewHolder == null) {
                a = this.f11900c.f11820b.m17572a(i);
                if (a >= 0) {
                }
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + a + ").state:" + this.f11900c.f11823e.m17554e());
            }
            z3 = z4;
            b = viewHolder;
            if (!this.f11900c.f11823e.f11944k) {
            }
            if (b.m20417p()) {
            }
            a2 = this.f11900c.f11820b.m17572a(i);
            b.f14105k = this.f11900c;
            this.f11900c.f11831o.m17225b(b, a2);
            m17413d(b.f14095a);
            if (this.f11900c.f11823e.f11944k) {
                b.f14100f = i;
            }
            z5 = true;
            layoutParams = b.f14095a.getLayoutParams();
            if (layoutParams != null) {
                layoutParams2 = (LayoutParams) this.f11900c.generateDefaultLayoutParams();
                b.f14095a.setLayoutParams(layoutParams2);
            } else if (this.f11900c.checkLayoutParams(layoutParams)) {
                layoutParams2 = (LayoutParams) this.f11900c.generateLayoutParams(layoutParams);
                b.f14095a.setLayoutParams(layoutParams2);
            } else {
                layoutParams2 = (LayoutParams) layoutParams;
            }
            layoutParams2.f14110a = b;
            z2 = false;
            layoutParams2.f14113d = z2;
            return b.f14095a;
        }

        private void m17413d(View view) {
            if (this.f11900c.m17164d()) {
                if (ViewCompat.m10959e(view) == 0) {
                    ViewCompat.m10958d(view, 1);
                }
                if (!ViewCompat.m10952b(view)) {
                    ViewCompat.m10939a(view, this.f11900c.af.f11965c);
                }
            }
        }

        private void m17412d(ViewHolder viewHolder) {
            if (viewHolder.f14095a instanceof ViewGroup) {
                m17409a((ViewGroup) viewHolder.f14095a, false);
            }
        }

        private void m17409a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m17409a((ViewGroup) childAt, true);
                }
            }
            if (!z) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
                return;
            }
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }

        public final void m17427a(View view) {
            ViewHolder b = RecyclerView.m17080b(view);
            if (b.m20419r()) {
                this.f11900c.removeDetachedView(view, false);
            }
            if (b.m20409h()) {
                b.m20410i();
            } else if (b.m20411j()) {
                b.m20412k();
            }
            m17426a(b);
        }

        private void m17418j() {
            for (int size = this.f11899b.size() - 1; size >= 0; size--) {
                m17414e(size);
            }
            this.f11899b.clear();
        }

        private void m17414e(int i) {
            m17415e((ViewHolder) this.f11899b.get(i));
            this.f11899b.remove(i);
        }

        final void m17426a(ViewHolder viewHolder) {
            boolean z = true;
            int i = 0;
            if (viewHolder.m20409h() || viewHolder.f14095a.getParent() != null) {
                StringBuilder append = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(viewHolder.m20409h()).append(" isAttached:");
                if (viewHolder.f14095a.getParent() == null) {
                    z = false;
                }
                throw new IllegalArgumentException(append.append(z).toString());
            } else if (viewHolder.m20419r()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + viewHolder);
            } else if (viewHolder.m20404c()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
            } else {
                int i2;
                boolean B = ViewHolder.m20383B(viewHolder);
                boolean z2 = this.f11900c.f11831o != null && B && this.f11900c.f11831o.mo2228b(viewHolder);
                if (z2 || viewHolder.m20423v()) {
                    if (!viewHolder.m20401a(78)) {
                        int size = this.f11899b.size();
                        if (size == this.f11903f && size > 0) {
                            m17414e(0);
                        }
                        if (size < this.f11903f) {
                            this.f11899b.add(viewHolder);
                            z2 = true;
                            if (z2) {
                                m17415e(viewHolder);
                                i = 1;
                                i2 = z2;
                            } else {
                                z = z2;
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                        z = z2;
                    } else {
                        m17415e(viewHolder);
                        i = 1;
                        i2 = z2;
                    }
                } else {
                    i2 = 0;
                }
                this.f11900c.f11823e.m17547a(viewHolder);
                if (i2 == 0 && r1 == 0 && B) {
                    viewHolder.f14105k = null;
                }
            }
        }

        private void m17415e(ViewHolder viewHolder) {
            ViewCompat.m10939a(viewHolder.f14095a, null);
            m17417f(viewHolder);
            viewHolder.f14105k = null;
            m17439e().m20114a(viewHolder);
        }

        final void m17432b(View view) {
            ViewHolder b = RecyclerView.m17080b(view);
            b.f14108o = null;
            b.m20412k();
            m17426a(b);
        }

        final void m17436c(View view) {
            ViewHolder b = RecyclerView.m17080b(view);
            b.f14108o = this;
            if (b.m20416o() && RecyclerView.m17049A(this.f11900c)) {
                if (this.f11901d == null) {
                    this.f11901d = new ArrayList();
                }
                this.f11901d.add(b);
            } else if (!b.m20414m() || b.m20418q() || this.f11900c.f11831o.en_()) {
                this.f11898a.add(b);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
            }
        }

        final void m17431b(ViewHolder viewHolder) {
            if (viewHolder.m20416o() && RecyclerView.m17049A(this.f11900c) && this.f11901d != null) {
                this.f11901d.remove(viewHolder);
            } else {
                this.f11898a.remove(viewHolder);
            }
            viewHolder.f14108o = null;
            viewHolder.m20412k();
        }

        final int m17433c() {
            return this.f11898a.size();
        }

        final View m17437d(int i) {
            return ((ViewHolder) this.f11898a.get(i)).f14095a;
        }

        final void m17438d() {
            this.f11898a.clear();
        }

        private ViewHolder m17416f(int i) {
            int i2 = 0;
            if (this.f11901d != null) {
                int size = this.f11901d.size();
                if (size != 0) {
                    ViewHolder viewHolder;
                    int i3 = 0;
                    while (i3 < size) {
                        viewHolder = (ViewHolder) this.f11901d.get(i3);
                        if (viewHolder.m20411j() || viewHolder.m20405d() != i) {
                            i3++;
                        } else {
                            viewHolder.m20403b(32);
                            return viewHolder;
                        }
                    }
                    if (this.f11900c.f11831o.en_()) {
                        int a = this.f11900c.f11820b.m17572a(i);
                        if (a > 0 && a < this.f11900c.f11831o.aZ_()) {
                            long H_ = this.f11900c.f11831o.H_(a);
                            while (i2 < size) {
                                viewHolder = (ViewHolder) this.f11901d.get(i2);
                                if (viewHolder.m20411j() || viewHolder.f14098d != H_) {
                                    i2++;
                                } else {
                                    viewHolder.m20403b(32);
                                    return viewHolder;
                                }
                            }
                        }
                    }
                    return null;
                }
            }
            return null;
        }

        private ViewHolder m17410b(int i, int i2, boolean z) {
            int size;
            int i3;
            int i4 = 0;
            int size2 = this.f11898a.size();
            int i5 = 0;
            while (i5 < size2) {
                ChildHelper childHelper;
                View view;
                View view2;
                ViewHolder viewHolder = (ViewHolder) this.f11898a.get(i5);
                if (viewHolder.m20411j() || viewHolder.m20405d() != i || viewHolder.m20414m() || (!this.f11900c.f11823e.f11944k && viewHolder.m20418q())) {
                    i5++;
                } else if (i2 == -1 || viewHolder.f14099e == i2) {
                    viewHolder.m20403b(32);
                    return viewHolder;
                } else {
                    Log.e("RecyclerView", "Scrap view for position " + i + " isn't dirty but has wrong view type! (found " + viewHolder.f14099e + " but expected " + i2 + ")");
                    if (!z) {
                        childHelper = this.f11900c.f11821c;
                        size = childHelper.f11960c.size();
                        for (i3 = 0; i3 < size; i3++) {
                            view = (View) childHelper.f11960c.get(i3);
                            ViewHolder b = childHelper.f11958a.mo2275b(view);
                            if (b.m20405d() == i && !b.m20414m() && (i2 == -1 || b.f14099e == i2)) {
                                break;
                            }
                        }
                        view = null;
                        view2 = view;
                        if (view2 != null) {
                            this.f11900c.f11822d.mo2242c(this.f11900c.m17138a(view2));
                        }
                    }
                    i5 = this.f11899b.size();
                    while (i4 < i5) {
                        viewHolder = (ViewHolder) this.f11899b.get(i4);
                        if (viewHolder.m20414m() || viewHolder.m20405d() != i) {
                            i4++;
                        } else if (z) {
                            return viewHolder;
                        } else {
                            this.f11899b.remove(i4);
                            return viewHolder;
                        }
                    }
                    return null;
                }
            }
            if (z) {
                childHelper = this.f11900c.f11821c;
                size = childHelper.f11960c.size();
                for (i3 = 0; i3 < size; i3++) {
                    view = (View) childHelper.f11960c.get(i3);
                    ViewHolder b2 = childHelper.f11958a.mo2275b(view);
                }
                view = null;
                view2 = view;
                if (view2 != null) {
                    this.f11900c.f11822d.mo2242c(this.f11900c.m17138a(view2));
                }
            }
            i5 = this.f11899b.size();
            while (i4 < i5) {
                viewHolder = (ViewHolder) this.f11899b.get(i4);
                if (viewHolder.m20414m()) {
                }
                i4++;
            }
            return null;
        }

        private ViewHolder m17406a(long j, int i, boolean z) {
            int size;
            for (size = this.f11898a.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = (ViewHolder) this.f11898a.get(size);
                if (viewHolder.f14098d == j && !viewHolder.m20411j()) {
                    if (i == viewHolder.f14099e) {
                        viewHolder.m20403b(32);
                        if (!viewHolder.m20418q() || this.f11900c.f11823e.f11944k) {
                            return viewHolder;
                        }
                        viewHolder.m20395a(2, 14);
                        return viewHolder;
                    } else if (!z) {
                        this.f11898a.remove(size);
                        this.f11900c.removeDetachedView(viewHolder.f14095a, false);
                        m17432b(viewHolder.f14095a);
                    }
                }
            }
            for (size = this.f11899b.size() - 1; size >= 0; size--) {
                viewHolder = (ViewHolder) this.f11899b.get(size);
                if (viewHolder.f14098d == j) {
                    if (i == viewHolder.f14099e) {
                        if (z) {
                            return viewHolder;
                        }
                        this.f11899b.remove(size);
                        return viewHolder;
                    } else if (!z) {
                        m17414e(size);
                    }
                }
            }
            return null;
        }

        private void m17417f(ViewHolder viewHolder) {
            if (this.f11900c.f11833q != null) {
                this.f11900c.f11833q.mo2653a(viewHolder);
            }
            if (this.f11900c.f11831o != null) {
                this.f11900c.f11831o.mo2224a(viewHolder);
            }
            if (this.f11900c.f11823e != null) {
                this.f11900c.f11823e.m17547a(viewHolder);
            }
        }

        final void m17423a(Adapter adapter, Adapter adapter2, boolean z) {
            m17419a();
            m17439e().m20113a(adapter, adapter2, z);
        }

        final void m17421a(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i3 = -1;
                i4 = i2;
                i5 = i;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.f11899b.size();
            for (int i6 = 0; i6 < size; i6++) {
                ViewHolder viewHolder = (ViewHolder) this.f11899b.get(i6);
                if (viewHolder != null && viewHolder.f14096b >= r3 && viewHolder.f14096b <= r2) {
                    if (viewHolder.f14096b == i) {
                        viewHolder.m20397a(i2 - i, false);
                    } else {
                        viewHolder.m20397a(i3, false);
                    }
                }
            }
        }

        final void m17430b(int i, int i2) {
            int size = this.f11899b.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewHolder viewHolder = (ViewHolder) this.f11899b.get(i3);
                if (viewHolder != null && viewHolder.m20405d() >= i) {
                    viewHolder.m20397a(i2, true);
                }
            }
        }

        final void m17422a(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f11899b.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = (ViewHolder) this.f11899b.get(size);
                if (viewHolder != null) {
                    if (viewHolder.m20405d() >= i3) {
                        viewHolder.m20397a(-i2, z);
                    } else if (viewHolder.m20405d() >= i) {
                        viewHolder.m20403b(8);
                        m17414e(size);
                    }
                }
            }
        }

        final void m17425a(ViewCacheExtension viewCacheExtension) {
            this.f11905h = viewCacheExtension;
        }

        final void m17424a(RecycledViewPool recycledViewPool) {
            if (this.f11904g != null) {
                this.f11904g.m20115b();
            }
            this.f11904g = recycledViewPool;
            if (recycledViewPool != null) {
                RecycledViewPool recycledViewPool2 = this.f11904g;
                Adapter adapter = this.f11900c.f11831o;
                recycledViewPool2.m20111a();
            }
        }

        final RecycledViewPool m17439e() {
            if (this.f11904g == null) {
                this.f11904g = new RecycledViewPool();
            }
            return this.f11904g;
        }

        final void m17435c(int i, int i2) {
            int i3 = i + i2;
            for (int size = this.f11899b.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = (ViewHolder) this.f11899b.get(size);
                if (viewHolder != null) {
                    int d = viewHolder.m20405d();
                    if (d >= i && d < i3) {
                        viewHolder.m20403b(2);
                        m17414e(size);
                    }
                }
            }
        }

        final void m17440f() {
            int size = this.f11899b.size();
            for (int i = 0; i < size; i++) {
                ViewHolder viewHolder = (ViewHolder) this.f11899b.get(i);
                if (viewHolder != null) {
                    viewHolder.m20403b(512);
                }
            }
        }

        final void m17441g() {
            if (this.f11900c.f11831o == null || !this.f11900c.f11831o.en_()) {
                m17418j();
                return;
            }
            int size = this.f11899b.size();
            for (int i = 0; i < size; i++) {
                ViewHolder viewHolder = (ViewHolder) this.f11899b.get(i);
                if (viewHolder != null) {
                    viewHolder.m20403b(6);
                    viewHolder.m20399a(null);
                }
            }
        }

        final void m17442h() {
            int i;
            int i2 = 0;
            int size = this.f11899b.size();
            for (i = 0; i < size; i++) {
                ((ViewHolder) this.f11899b.get(i)).m20394a();
            }
            size = this.f11898a.size();
            for (i = 0; i < size; i++) {
                ((ViewHolder) this.f11898a.get(i)).m20394a();
            }
            if (this.f11901d != null) {
                i = this.f11901d.size();
                while (i2 < i) {
                    ((ViewHolder) this.f11901d.get(i2)).m20394a();
                    i2++;
                }
            }
        }

        final void m17443i() {
            int size = this.f11899b.size();
            for (int i = 0; i < size; i++) {
                LayoutParams layoutParams = (LayoutParams) ((ViewHolder) this.f11899b.get(i)).f14095a.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.f14112c = true;
                }
            }
        }
    }

    /* compiled from: nux_admit_time_ms */
    class C04991 implements Runnable {
        final /* synthetic */ RecyclerView f11906a;

        C04991(RecyclerView recyclerView) {
            this.f11906a = recyclerView;
        }

        public void run() {
            if (!this.f11906a.f11839w) {
                return;
            }
            if (this.f11906a.f11802G) {
                TraceCompatDetour.a("RV FullInvalidate", 761089322);
                this.f11906a.m17169f();
                TraceCompatDetour.a(1463635848);
            } else if (this.f11906a.f11820b.m17579d()) {
                TraceCompatDetour.a("RV PartialInvalidate", 576469852);
                this.f11906a.m17151b();
                this.f11906a.f11820b.m17577b();
                if (!this.f11906a.f11841y) {
                    this.f11906a.m17172g();
                }
                this.f11906a.m17150a(true);
                TraceCompatDetour.a(1657657906);
            }
        }
    }

    /* compiled from: nux_admit_time_ms */
    public abstract class ItemAnimator {
        public ItemAnimatorListener f11918a = null;
        private ArrayList<ItemAnimatorFinishedListener> f11919b = new ArrayList();
        public long f11920c = 120;
        public long f11921d = 120;
        public long f11922e = 250;
        public long f11923f = 250;
        public boolean f11924g = true;

        /* compiled from: nux_admit_time_ms */
        interface ItemAnimatorListener {
            void mo2256a(ViewHolder viewHolder);

            void mo2257b(ViewHolder viewHolder);

            void mo2258c(ViewHolder viewHolder);

            void mo2259d(ViewHolder viewHolder);
        }

        public abstract void mo2235a();

        public abstract boolean mo2236a(ViewHolder viewHolder);

        public abstract boolean mo2237a(ViewHolder viewHolder, int i, int i2, int i3, int i4);

        public abstract boolean mo2238a(ViewHolder viewHolder, ViewHolder viewHolder2, int i, int i2, int i3, int i4);

        public abstract boolean mo2239b();

        public abstract boolean mo2240b(ViewHolder viewHolder);

        public abstract void mo2241c();

        public abstract void mo2242c(ViewHolder viewHolder);

        public final long m17473d() {
            return this.f11922e;
        }

        public final long m17475e() {
            return this.f11920c;
        }

        public final long m17477f() {
            return this.f11921d;
        }

        public final long m17479g() {
            return this.f11923f;
        }

        public final boolean m17480h() {
            return this.f11924g;
        }

        public final void m17464a(boolean z) {
            this.f11924g = z;
        }

        final void m17462a(ItemAnimatorListener itemAnimatorListener) {
            this.f11918a = itemAnimatorListener;
        }

        public final void m17474d(ViewHolder viewHolder) {
            if (this.f11918a != null) {
                this.f11918a.mo2256a(viewHolder);
            }
        }

        public final void m17476e(ViewHolder viewHolder) {
            if (this.f11918a != null) {
                this.f11918a.mo2258c(viewHolder);
            }
        }

        public final void m17478f(ViewHolder viewHolder) {
            if (this.f11918a != null) {
                this.f11918a.mo2257b(viewHolder);
            }
        }

        public final void m17463a(ViewHolder viewHolder, boolean z) {
            if (this.f11918a != null) {
                this.f11918a.mo2259d(viewHolder);
            }
        }

        public final boolean m17465a(ItemAnimatorFinishedListener itemAnimatorFinishedListener) {
            boolean b = mo2239b();
            if (itemAnimatorFinishedListener != null && b) {
                this.f11919b.add(itemAnimatorFinishedListener);
            }
            return b;
        }

        public final void m17481i() {
            int size = this.f11919b.size();
            for (int i = 0; i < size; i++) {
                this.f11919b.get(i);
            }
            this.f11919b.clear();
        }
    }

    /* compiled from: nux_admit_time_ms */
    class ViewFlinger implements Runnable {
        final /* synthetic */ RecyclerView f11925a;
        private int f11926b;
        private int f11927c;
        private ScrollerCompat f11928d;
        private Interpolator f11929e = RecyclerView.an;
        private boolean f11930f = false;
        private boolean f11931g = false;

        public ViewFlinger(RecyclerView recyclerView) {
            this.f11925a = recyclerView;
            this.f11928d = ScrollerCompat.m17494a(recyclerView.getContext(), RecyclerView.an);
        }

        public void run() {
            int a = Logger.a(8, EntryType.MARK_PUSH, 410397712);
            m17485c();
            this.f11925a.mo2198n();
            ScrollerCompat scrollerCompat = this.f11928d;
            SmoothScroller smoothScroller = this.f11925a.f11832p.f11876s;
            if (scrollerCompat.m17505g()) {
                int b;
                int i;
                int top;
                int i2;
                Object obj;
                Object obj2;
                int b2 = scrollerCompat.m17500b();
                int c = scrollerCompat.m17501c();
                int i3 = b2 - this.f11926b;
                int i4 = c - this.f11927c;
                int i5 = 0;
                int i6 = 0;
                this.f11926b = b2;
                this.f11927c = c;
                int i7 = 0;
                int i8 = 0;
                if (this.f11925a.f11831o != null) {
                    this.f11925a.m17151b();
                    RecyclerView.m17134x(this.f11925a);
                    TraceCompatDetour.a("RV Scroll", -1626714468);
                    if (i3 != 0) {
                        i5 = this.f11925a.f11832p.mo2305a(i3, this.f11925a.f11819a, this.f11925a.f11823e);
                        i7 = i3 - i5;
                    }
                    if (i4 != 0) {
                        i6 = this.f11925a.f11832p.mo2300b(i4, this.f11925a.f11819a, this.f11925a.f11823e);
                        i8 = i4 - i6;
                    }
                    TraceCompatDetour.a(-560168635);
                    if (RecyclerView.m17049A(this.f11925a)) {
                        b = this.f11925a.f11821c.m17611b();
                        for (i = 0; i < b; i++) {
                            View b3 = this.f11925a.f11821c.m17613b(i);
                            ViewHolder a2 = this.f11925a.m17138a(b3);
                            if (!(a2 == null || a2.f14102h == null)) {
                                View view = a2.f14102h.f14095a;
                                int left = b3.getLeft();
                                top = b3.getTop();
                                if (left != view.getLeft() || top != view.getTop()) {
                                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                                }
                            }
                        }
                    }
                    RecyclerView.m17135y(this.f11925a);
                    this.f11925a.m17150a(false);
                    if (!(smoothScroller == null || smoothScroller.f() || !smoothScroller.g())) {
                        i = this.f11925a.f11823e.m17554e();
                        if (i == 0) {
                            smoothScroller.e();
                            i2 = i7;
                            i7 = i6;
                            i6 = i2;
                            if (!this.f11925a.f11834r.isEmpty()) {
                                this.f11925a.invalidate();
                            }
                            if (ViewCompat.m10934a(this.f11925a) != 2) {
                                this.f11925a.mo2195g(i3, i4);
                            }
                            if (!(i6 == 0 && i8 == 0)) {
                                b = (int) scrollerCompat.m17504f();
                                if (i6 == b2) {
                                    i = i6 >= 0 ? -b : i6 <= 0 ? b : 0;
                                    top = i;
                                } else {
                                    top = 0;
                                }
                                if (i8 != c) {
                                    b = 0;
                                } else if (i8 < 0) {
                                    b = -b;
                                } else if (i8 <= 0) {
                                    b = 0;
                                }
                                if (ViewCompat.m10934a(this.f11925a) != 2) {
                                    this.f11925a.m17161c(top, b);
                                }
                                if ((top != 0 || i6 == b2 || scrollerCompat.m17502d() == 0) && (b != 0 || i8 == c || scrollerCompat.m17503e() == 0)) {
                                    scrollerCompat.m17506h();
                                }
                            }
                            if (!(i5 == 0 && i7 == 0)) {
                                this.f11925a.m17170f(i5, i7);
                            }
                            if (!this.f11925a.awakenScrollBars()) {
                                this.f11925a.invalidate();
                            }
                            obj = (i4 == 0 && this.f11925a.f11832p.mo2325h() && i7 == i4) ? 1 : null;
                            obj2 = (i3 == 0 && this.f11925a.f11832p.mo2324g() && i5 == i3) ? 1 : null;
                            obj2 = ((i3 == 0 || i4 != 0) && obj2 == null && obj == null) ? null : 1;
                            if (!scrollerCompat.m17499a() || obj2 == null) {
                                RecyclerView.setScrollState(this.f11925a, 0);
                            } else {
                                m17487a();
                            }
                        } else {
                            if (smoothScroller.h() >= i) {
                                smoothScroller.c(i - 1);
                            }
                            SmoothScroller.a(smoothScroller, i3 - i7, i4 - i8);
                        }
                    }
                }
                i2 = i7;
                i7 = i6;
                i6 = i2;
                if (this.f11925a.f11834r.isEmpty()) {
                    this.f11925a.invalidate();
                }
                if (ViewCompat.m10934a(this.f11925a) != 2) {
                    this.f11925a.mo2195g(i3, i4);
                }
                b = (int) scrollerCompat.m17504f();
                if (i6 == b2) {
                    top = 0;
                } else {
                    if (i6 >= 0) {
                        if (i6 <= 0) {
                        }
                    }
                    top = i;
                }
                if (i8 != c) {
                    b = 0;
                } else if (i8 < 0) {
                    b = -b;
                } else if (i8 <= 0) {
                    b = 0;
                }
                if (ViewCompat.m10934a(this.f11925a) != 2) {
                    this.f11925a.m17161c(top, b);
                }
                scrollerCompat.m17506h();
                this.f11925a.m17170f(i5, i7);
                if (this.f11925a.awakenScrollBars()) {
                    this.f11925a.invalidate();
                }
                if (i4 == 0) {
                }
                if (i3 == 0) {
                }
                if (i3 == 0) {
                }
                if (scrollerCompat.m17499a()) {
                }
                RecyclerView.setScrollState(this.f11925a, 0);
            }
            if (smoothScroller != null) {
                if (smoothScroller.f()) {
                    SmoothScroller.a(smoothScroller, 0, 0);
                }
                if (!this.f11931g) {
                    smoothScroller.e();
                }
            }
            m17486d();
            LogUtils.h(1149630859, a);
        }

        private void m17485c() {
            this.f11931g = false;
            this.f11930f = true;
        }

        private void m17486d() {
            this.f11930f = false;
            if (this.f11931g) {
                m17487a();
            }
        }

        final void m17487a() {
            if (this.f11930f) {
                this.f11931g = true;
                return;
            }
            this.f11925a.removeCallbacks(this);
            ViewCompat.m10943a(this.f11925a, (Runnable) this);
        }

        public final void m17488a(int i, int i2) {
            RecyclerView.setScrollState(this.f11925a, 2);
            this.f11927c = 0;
            this.f11926b = 0;
            this.f11928d.m17497a(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            m17487a();
        }

        public final void m17492b(int i, int i2) {
            m17483a(i, i2, 0, 0);
        }

        private void m17483a(int i, int i2, int i3, int i4) {
            m17489a(i, i2, m17484b(i, i2, i3, i4));
        }

        private static float m17482a(float f) {
            return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
        }

        private int m17484b(int i, int i2, int i3, int i4) {
            int round;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            Object obj = abs > abs2 ? 1 : null;
            int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = obj != null ? this.f11925a.getWidth() : this.f11925a.getHeight();
            int i5 = width / 2;
            float a = (m17482a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width))) * ((float) i5)) + ((float) i5);
            if (sqrt > 0) {
                round = Math.round(1000.0f * Math.abs(a / ((float) sqrt))) * 4;
            } else {
                if (obj != null) {
                    round = abs;
                } else {
                    round = abs2;
                }
                round = (int) (((((float) round) / ((float) width)) + 1.0f) * 300.0f);
            }
            return Math.min(round, 2000);
        }

        public final void m17489a(int i, int i2, int i3) {
            m17490a(i, i2, i3, RecyclerView.an);
        }

        public final void m17490a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.f11929e != interpolator) {
                this.f11929e = interpolator;
                this.f11928d = ScrollerCompat.m17494a(this.f11925a.getContext(), interpolator);
            }
            RecyclerView.setScrollState(this.f11925a, 2);
            this.f11927c = 0;
            this.f11926b = 0;
            this.f11928d.m17496a(0, 0, i, i2, i3);
            m17487a();
        }

        public final void m17491b() {
            this.f11925a.removeCallbacks(this);
            this.f11928d.m17506h();
        }
    }

    /* compiled from: nux_admit_time_ms */
    public class State {
        ArrayMap<ViewHolder, ItemHolderInfo> f11934a = new ArrayMap();
        ArrayMap<ViewHolder, ItemHolderInfo> f11935b = new ArrayMap();
        ArrayMap<Long, ViewHolder> f11936c = new ArrayMap();
        final List<View> f11937d = new ArrayList();
        int f11938e = 0;
        public int f11939f = -1;
        private SparseArray<Object> f11940g;
        public int f11941h = 0;
        public int f11942i = 0;
        public boolean f11943j = false;
        public boolean f11944k = false;
        public boolean f11945l = false;
        public boolean f11946m = false;

        static /* synthetic */ int m17534a(State state, int i) {
            int i2 = state.f11942i + i;
            state.f11942i = i2;
            return i2;
        }

        public final boolean m17549a() {
            return this.f11944k;
        }

        public final boolean m17551b() {
            return this.f11946m;
        }

        public final int m17552c() {
            return this.f11939f;
        }

        public final boolean m17553d() {
            return this.f11939f != -1;
        }

        public final int m17554e() {
            return this.f11944k ? this.f11941h - this.f11942i : this.f11938e;
        }

        final void m17547a(ViewHolder viewHolder) {
            this.f11934a.remove(viewHolder);
            this.f11935b.remove(viewHolder);
            if (this.f11936c != null) {
                m17535a(this.f11936c, viewHolder);
            }
            this.f11937d.remove(viewHolder.f14095a);
        }

        private static void m17535a(ArrayMap<Long, ViewHolder> arrayMap, ViewHolder viewHolder) {
            for (int size = arrayMap.size() - 1; size >= 0; size--) {
                if (viewHolder == arrayMap.c(size)) {
                    arrayMap.d(size);
                    return;
                }
            }
        }

        final void m17548a(View view) {
            this.f11937d.remove(view);
        }

        final void m17550b(View view) {
            if (!this.f11937d.contains(view)) {
                this.f11937d.add(view);
            }
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f11939f + ", mPreLayoutHolderMap=" + this.f11934a + ", mPostLayoutHolderMap=" + this.f11935b + ", mData=" + this.f11940g + ", mItemCount=" + this.f11938e + ", mPreviousLayoutItemCount=" + this.f11941h + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f11942i + ", mStructureChanged=" + this.f11943j + ", mInPreLayout=" + this.f11944k + ", mRunSimpleAnimations=" + this.f11945l + ", mRunPredictiveAnimations=" + this.f11946m + '}';
        }
    }

    /* compiled from: nux_admit_time_ms */
    class ItemAnimatorRestoreListener implements ItemAnimatorListener {
        final /* synthetic */ RecyclerView f11947a;

        public ItemAnimatorRestoreListener(RecyclerView recyclerView) {
            this.f11947a = recyclerView;
        }

        public final void mo2256a(ViewHolder viewHolder) {
            viewHolder.m20400a(true);
            if (!this.f11947a.m17104h(viewHolder.f14095a) && viewHolder.m20419r()) {
                this.f11947a.removeDetachedView(viewHolder.f14095a, false);
            }
        }

        public final void mo2257b(ViewHolder viewHolder) {
            viewHolder.m20400a(true);
            if (!viewHolder.m20382A()) {
                this.f11947a.m17104h(viewHolder.f14095a);
            }
        }

        public final void mo2258c(ViewHolder viewHolder) {
            viewHolder.m20400a(true);
            if (!viewHolder.m20382A()) {
                this.f11947a.m17104h(viewHolder.f14095a);
            }
        }

        public final void mo2259d(ViewHolder viewHolder) {
            viewHolder.m20400a(true);
            if (viewHolder.f14101g != null && viewHolder.f14102h == null) {
                viewHolder.f14101g = null;
                viewHolder.m20395a(-65, viewHolder.f14106l);
            }
            viewHolder.f14102h = null;
            if (!viewHolder.m20382A()) {
                this.f11947a.m17104h(viewHolder.f14095a);
            }
        }
    }

    /* compiled from: nux_admit_time_ms */
    class C05002 implements Runnable {
        final /* synthetic */ RecyclerView f11948a;

        C05002(RecyclerView recyclerView) {
            this.f11948a = recyclerView;
        }

        public void run() {
            if (this.f11948a.f11822d != null) {
                this.f11948a.f11822d.mo2235a();
            }
            this.f11948a.ae = false;
        }
    }

    /* compiled from: nux_admit_time_ms */
    class C05015 implements Callback {
        final /* synthetic */ RecyclerView f11956a;

        C05015(RecyclerView recyclerView) {
            this.f11956a = recyclerView;
        }

        public final ViewHolder mo2262a(int i) {
            ViewHolder a = this.f11956a.m17137a(i, true);
            if (a == null || this.f11956a.f11821c.m17616c(a.f14095a)) {
                return null;
            }
            return a;
        }

        public final void mo2263a(int i, int i2) {
            this.f11956a.m17144a(i, i2, true);
            this.f11956a.f11824f = true;
            State.m17534a(this.f11956a.f11823e, i2);
        }

        public final void mo2266b(int i, int i2) {
            this.f11956a.m17144a(i, i2, false);
            this.f11956a.f11824f = true;
        }

        public final void mo2264a(int i, int i2, Object obj) {
            this.f11956a.m17143a(i, i2, obj);
            this.f11956a.f11825g = true;
        }

        public final void mo2265a(UpdateOp updateOp) {
            m17583c(updateOp);
        }

        private void m17583c(UpdateOp updateOp) {
            switch (updateOp.f18985a) {
                case 0:
                    this.f11956a.f11832p.m17296a(updateOp.f18986b, updateOp.f18988d);
                    return;
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    this.f11956a.f11832p.m17328b(updateOp.f18986b, updateOp.f18988d);
                    return;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    this.f11956a.f11832p.m17306a(this.f11956a, updateOp.f18986b, updateOp.f18988d);
                    return;
                case 3:
                    this.f11956a.f11832p.m17339c(updateOp.f18986b, updateOp.f18988d);
                    return;
                default:
                    return;
            }
        }

        public final void mo2267b(UpdateOp updateOp) {
            m17583c(updateOp);
        }

        public final void mo2268c(int i, int i2) {
            this.f11956a.m17166e(i, i2);
            this.f11956a.f11824f = true;
        }

        public final void mo2269d(int i, int i2) {
            this.f11956a.m17163d(i, i2);
            this.f11956a.f11824f = true;
        }
    }

    /* compiled from: nux_admit_time_ms */
    class C05024 implements Callback {
        final /* synthetic */ RecyclerView f11961a;

        C05024(RecyclerView recyclerView) {
            this.f11961a = recyclerView;
        }

        public final int mo2270a() {
            return this.f11961a.getChildCount();
        }

        public final void mo2273a(View view, int i) {
            this.f11961a.addView(view, i);
            RecyclerView.m17110j(this.f11961a, view);
        }

        public final int mo2271a(View view) {
            return this.f11961a.indexOfChild(view);
        }

        public final void mo2272a(int i) {
            View childAt = this.f11961a.getChildAt(i);
            if (childAt != null) {
                RecyclerView.m17106i(this.f11961a, childAt);
            }
            this.f11961a.removeViewAt(i);
        }

        public final View mo2276b(int i) {
            return this.f11961a.getChildAt(i);
        }

        public final void mo2277b() {
            int a = mo2270a();
            for (int i = 0; i < a; i++) {
                RecyclerView.m17106i(this.f11961a, mo2276b(i));
            }
            this.f11961a.removeAllViews();
        }

        public final ViewHolder mo2275b(View view) {
            return RecyclerView.m17080b(view);
        }

        public final void mo2274a(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
            ViewHolder b = RecyclerView.m17080b(view);
            if (b != null) {
                if (b.m20419r() || b.m20404c()) {
                    b.m20413l();
                } else {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + b);
                }
            }
            this.f11961a.attachViewToParent(view, i, layoutParams);
        }

        public final void mo2278c(int i) {
            View b = mo2276b(i);
            if (b != null) {
                ViewHolder b2 = RecyclerView.m17080b(b);
                if (b2 != null) {
                    if (!b2.m20419r() || b2.m20404c()) {
                        b2.m20403b(256);
                    } else {
                        throw new IllegalArgumentException("called detach on an already detached child " + b2);
                    }
                }
            }
            this.f11961a.detachViewFromParent(i);
        }

        public final void mo2279c(View view) {
            ViewHolder b = RecyclerView.m17080b(view);
            if (b != null) {
                b.m20392y();
            }
        }

        public final void mo2280d(View view) {
            ViewHolder b = RecyclerView.m17080b(view);
            if (b != null) {
                b.m20393z();
            }
        }
    }

    /* compiled from: nux_admit_time_ms */
    class AdapterDataObservable extends Observable<AdapterDataObserver> {
        AdapterDataObservable() {
        }

        public final boolean m18026a() {
            return !this.mObservers.isEmpty();
        }

        public final void m18027b() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).bb_();
            }
        }

        public final void m18025a(int i, int i2) {
            m18024a(i, i2, null);
        }

        private void m18024a(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).mo2234a(i, i2, obj);
            }
        }

        public final void m18028b(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).mo2210b(i, i2);
            }
        }

        public final void m18029c(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).mo2212c(i, i2);
            }
        }

        public final void m18030d(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).mo2218a(i, i2, 1);
            }
        }
    }

    /* compiled from: nux_admit_time_ms */
    public abstract class ViewCacheExtension {
        public abstract View mo2338a(int i, int i2);
    }

    /* compiled from: nux_admit_time_ms */
    public abstract class ItemDecoration {
        public void mo2585a(Canvas canvas, RecyclerView recyclerView, State state) {
        }

        public void m19329b(Canvas canvas, RecyclerView recyclerView, State state) {
        }

        @Deprecated
        private static void m19326a(Rect rect) {
            rect.set(0, 0, 0, 0);
        }

        public void mo2586a(Rect rect, View view, RecyclerView recyclerView, State state) {
            ((LayoutParams) view.getLayoutParams()).m20426e();
            m19326a(rect);
        }
    }

    /* compiled from: nux_admit_time_ms */
    public class RecycledViewPool {
        private SparseArray<ArrayList<ViewHolder>> f13678a = new SparseArray();
        private SparseIntArray f13679b = new SparseIntArray();
        private int f13680c = 0;

        private void m20109c() {
            this.f13678a.clear();
        }

        public final void m20112a(int i, int i2) {
            this.f13679b.put(i, i2);
            ArrayList arrayList = (ArrayList) this.f13678a.get(i);
            if (arrayList != null) {
                while (arrayList.size() > i2) {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }

        public final ViewHolder m20110a(int i) {
            ArrayList arrayList = (ArrayList) this.f13678a.get(i);
            if (arrayList == null || arrayList.isEmpty()) {
                return null;
            }
            int size = arrayList.size() - 1;
            ViewHolder viewHolder = (ViewHolder) arrayList.get(size);
            arrayList.remove(size);
            return viewHolder;
        }

        final void m20111a() {
            this.f13680c++;
        }

        final void m20115b() {
            this.f13680c--;
        }

        final void m20113a(Adapter adapter, Adapter adapter2, boolean z) {
            if (adapter != null) {
                m20115b();
            }
            if (!z && this.f13680c == 0) {
                m20109c();
            }
            if (adapter2 != null) {
                m20111a();
            }
        }

        private ArrayList<ViewHolder> m20108b(int i) {
            ArrayList<ViewHolder> arrayList = (ArrayList) this.f13678a.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f13678a.put(i, arrayList);
                if (this.f13679b.indexOfKey(i) < 0) {
                    this.f13679b.put(i, 5);
                }
            }
            return arrayList;
        }

        public final void m20114a(ViewHolder viewHolder) {
            int i = viewHolder.f14099e;
            ArrayList b = m20108b(i);
            if (this.f13679b.get(i) > b.size()) {
                viewHolder.m20422u();
                b.add(viewHolder);
            }
        }
    }

    /* compiled from: nux_admit_time_ms */
    public abstract class ViewHolder {
        private static final List<Object> f14094m = Collections.EMPTY_LIST;
        public final View f14095a;
        int f14096b = -1;
        int f14097c = -1;
        public long f14098d = -1;
        public int f14099e = -1;
        int f14100f = -1;
        ViewHolder f14101g = null;
        ViewHolder f14102h = null;
        List<Object> f14103i = null;
        List<Object> f14104j = null;
        RecyclerView f14105k;
        public int f14106l;
        private int f14107n = 0;
        public Recycler f14108o = null;
        private int f14109p = 0;

        public ViewHolder(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f14095a = view;
        }

        final void m20396a(int i, int i2, boolean z) {
            m20403b(8);
            m20397a(i2, z);
            this.f14096b = i;
        }

        final void m20397a(int i, boolean z) {
            if (this.f14097c == -1) {
                this.f14097c = this.f14096b;
            }
            if (this.f14100f == -1) {
                this.f14100f = this.f14096b;
            }
            if (z) {
                this.f14100f += i;
            }
            this.f14096b += i;
            if (this.f14095a.getLayoutParams() != null) {
                ((LayoutParams) this.f14095a.getLayoutParams()).f14112c = true;
            }
        }

        final void m20394a() {
            this.f14097c = -1;
            this.f14100f = -1;
        }

        final void m20402b() {
            if (this.f14097c == -1) {
                this.f14097c = this.f14096b;
            }
        }

        final boolean m20404c() {
            return (this.f14106l & HTTPTransportCallback.BODY_BYTES_RECEIVED) != 0;
        }

        public final int m20405d() {
            return this.f14100f == -1 ? this.f14096b : this.f14100f;
        }

        public final int m20406e() {
            if (this.f14105k == null) {
                return -1;
            }
            return RecyclerView.m17087c(this.f14105k, this);
        }

        public final long m20407f() {
            return this.f14098d;
        }

        public final int m20408g() {
            return this.f14099e;
        }

        final boolean m20409h() {
            return this.f14108o != null;
        }

        final void m20410i() {
            this.f14108o.m17431b(this);
        }

        final boolean m20411j() {
            return (this.f14106l & 32) != 0;
        }

        final void m20412k() {
            this.f14106l &= -33;
        }

        final void m20413l() {
            this.f14106l &= -257;
        }

        final void m20398a(Recycler recycler) {
            this.f14108o = recycler;
        }

        public final boolean m20414m() {
            return (this.f14106l & 4) != 0;
        }

        final boolean m20415n() {
            return (this.f14106l & 2) != 0;
        }

        final boolean m20416o() {
            return (this.f14106l & 64) != 0;
        }

        final boolean m20417p() {
            return (this.f14106l & 1) != 0;
        }

        final boolean m20418q() {
            return (this.f14106l & 8) != 0;
        }

        final boolean m20401a(int i) {
            return (this.f14106l & i) != 0;
        }

        final boolean m20419r() {
            return (this.f14106l & 256) != 0;
        }

        private boolean m20390w() {
            return (this.f14106l & 512) != 0 || m20414m();
        }

        final void m20395a(int i, int i2) {
            this.f14106l = (this.f14106l & (i2 ^ -1)) | (i & i2);
        }

        final void m20403b(int i) {
            this.f14106l |= i;
        }

        final void m20399a(Object obj) {
            if (obj == null) {
                m20403b(1024);
            } else if ((this.f14106l & 1024) == 0) {
                m20391x();
                this.f14103i.add(obj);
            }
        }

        private void m20391x() {
            if (this.f14103i == null) {
                this.f14103i = new ArrayList();
                this.f14104j = Collections.unmodifiableList(this.f14103i);
            }
        }

        final void m20420s() {
            if (this.f14103i != null) {
                this.f14103i.clear();
            }
            this.f14106l &= -1025;
        }

        final List<Object> m20421t() {
            if ((this.f14106l & 1024) != 0) {
                return f14094m;
            }
            if (this.f14103i == null || this.f14103i.size() == 0) {
                return f14094m;
            }
            return this.f14104j;
        }

        final void m20422u() {
            this.f14106l = 0;
            this.f14096b = -1;
            this.f14097c = -1;
            this.f14098d = -1;
            this.f14100f = -1;
            this.f14107n = 0;
            this.f14101g = null;
            this.f14102h = null;
            m20420s();
            this.f14109p = 0;
        }

        private void m20392y() {
            this.f14109p = ViewCompat.m10959e(this.f14095a);
            ViewCompat.m10958d(this.f14095a, 4);
        }

        private void m20393z() {
            ViewCompat.m10958d(this.f14095a, this.f14109p);
            this.f14109p = 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.f14096b + " id=" + this.f14098d + ", oldPos=" + this.f14097c + ", pLpos:" + this.f14100f);
            if (m20409h()) {
                stringBuilder.append(" scrap");
            }
            if (m20414m()) {
                stringBuilder.append(" invalid");
            }
            if (!m20417p()) {
                stringBuilder.append(" unbound");
            }
            if (m20415n()) {
                stringBuilder.append(" update");
            }
            if (m20418q()) {
                stringBuilder.append(" removed");
            }
            if (m20404c()) {
                stringBuilder.append(" ignored");
            }
            if (m20416o()) {
                stringBuilder.append(" changed");
            }
            if (m20419r()) {
                stringBuilder.append(" tmpDetached");
            }
            if (!m20423v()) {
                stringBuilder.append(" not recyclable(" + this.f14107n + ")");
            }
            if (m20390w()) {
                stringBuilder.append("undefined adapter position");
            }
            if (this.f14095a.getParent() == null) {
                stringBuilder.append(" no parent");
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        public final void m20400a(boolean z) {
            this.f14107n = z ? this.f14107n - 1 : this.f14107n + 1;
            if (this.f14107n < 0) {
                this.f14107n = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && this.f14107n == 1) {
                this.f14106l |= 16;
            } else if (z && this.f14107n == 0) {
                this.f14106l &= -17;
            }
        }

        public final boolean m20423v() {
            return (this.f14106l & 16) == 0 && !ViewCompat.m10955c(this.f14095a);
        }

        private boolean m20382A() {
            return (this.f14106l & 16) != 0;
        }

        public static boolean m20383B(ViewHolder viewHolder) {
            return (viewHolder.f14106l & 16) == 0 && ViewCompat.m10955c(viewHolder.f14095a);
        }
    }

    /* compiled from: nux_admit_time_ms */
    public class LayoutParams extends MarginLayoutParams {
        ViewHolder f14110a;
        final Rect f14111b = new Rect();
        boolean f14112c = true;
        boolean f14113d = false;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public final boolean m20424c() {
            return this.f14110a.m20418q();
        }

        public final boolean m20425d() {
            return this.f14110a.m20416o();
        }

        public final int m20426e() {
            return this.f14110a.m20405d();
        }

        public final int m20427f() {
            return this.f14110a.m20406e();
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20) {
            z = true;
        } else {
            z = false;
        }
        f11794h = z;
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        boolean z;
        super(context, attributeSet, i);
        this.f11826j = new RecyclerViewDataObserver(this);
        this.f11819a = new Recycler(this);
        this.f11829m = new C04991(this);
        this.f11830n = new Rect();
        this.f11834r = new ArrayList();
        this.f11835s = new ArrayList();
        this.f11802G = false;
        this.f11803H = 0;
        this.f11822d = new DefaultItemAnimator();
        this.f11808M = 0;
        this.f11809N = -1;
        this.f11818W = Float.MIN_VALUE;
        this.aa = new ViewFlinger(this);
        this.f11823e = new State();
        this.f11824f = false;
        this.f11825g = false;
        this.ad = new ItemAnimatorRestoreListener(this);
        this.ae = false;
        this.ah = new int[2];
        this.aj = new int[2];
        this.ak = new int[2];
        this.al = new int[2];
        this.am = new C05002(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        this.f11799D = VERSION.SDK_INT >= 16;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f11815T = viewConfiguration.getScaledTouchSlop();
        this.f11816U = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f11817V = viewConfiguration.getScaledMaximumFlingVelocity();
        if (ViewCompat.m10934a(this) == 2) {
            z = true;
        } else {
            z = false;
        }
        setWillNotDraw(z);
        this.f11822d.f11918a = this.ad;
        mo2197m();
        mo2196l();
        if (ViewCompat.m10959e(this) == 0) {
            ViewCompat.m10958d((View) this, 1);
        }
        this.f11800E = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, i, 0);
            String string = obtainStyledAttributes.getString(1);
            obtainStyledAttributes.recycle();
            m17061a(context, string, attributeSet, i, 0);
        }
        this.ai = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.af;
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.af = recyclerViewAccessibilityDelegate;
        ViewCompat.m10939a((View) this, this.af);
    }

    private void m17061a(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        if (str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                String a = m17059a(context, trim);
                try {
                    ClassLoader classLoader;
                    Constructor constructor;
                    Object[] objArr;
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class asSubclass = classLoader.loadClass(a).asSubclass(LayoutManager.class);
                    try {
                        constructor = asSubclass.getConstructor(f11795i);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                    } catch (Throwable e) {
                        try {
                            constructor = asSubclass.getConstructor(new Class[0]);
                            objArr = null;
                        } catch (Throwable e2) {
                            e2.initCause(e);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + a, e2);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (Throwable e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + a, e3);
                } catch (Throwable e32) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a, e32);
                } catch (Throwable e322) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a, e322);
                } catch (Throwable e3222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + a, e3222);
                } catch (Throwable e32222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + a, e32222);
                }
            }
        }
    }

    private static String m17059a(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        return !str.contains(".") ? RecyclerView.class.getPackage().getName() + '.' + str : str;
    }

    private void mo2196l() {
        this.f11821c = new ChildHelper(new C05024(this));
    }

    private void mo2197m() {
        this.f11820b = new AdapterHelper(new C05015(this));
    }

    public void setHasFixedSize(boolean z) {
        this.f11838v = z;
    }

    public void setClipToPadding(boolean z) {
        if (z != this.f11828l) {
            m17131u();
        }
        this.f11828l = z;
        super.setClipToPadding(z);
        if (this.f11839w) {
            requestLayout();
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                this.f11815T = ViewConfigurationCompat.m10827a(viewConfiguration);
                return;
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        this.f11815T = viewConfiguration.getScaledTouchSlop();
    }

    public void setAdapter(Adapter adapter) {
        setLayoutFrozen(false);
        m17063a(adapter, false, true);
        requestLayout();
    }

    private void m17063a(Adapter adapter, boolean z, boolean z2) {
        if (this.f11831o != null) {
            this.f11831o.mo2227b(this.f11826j);
            this.f11831o.m17226b(this);
        }
        if (!z || z2) {
            if (this.f11822d != null) {
                this.f11822d.mo2241c();
            }
            if (this.f11832p != null) {
                this.f11832p.m17340c(this.f11819a);
                this.f11832p.m17329b(this.f11819a);
            }
            this.f11819a.m17419a();
        }
        this.f11820b.m17574a();
        Adapter adapter2 = this.f11831o;
        this.f11831o = adapter;
        if (adapter != null) {
            adapter.mo2223a(this.f11826j);
            adapter.a_(this);
        }
        if (this.f11832p != null) {
            this.f11832p.mo2293a(adapter2, this.f11831o);
        }
        this.f11819a.m17423a(adapter2, this.f11831o, z);
        this.f11823e.f11943j = true;
        m17057I();
    }

    public Adapter getAdapter() {
        return this.f11831o;
    }

    public void setRecyclerListener(RecyclerListener recyclerListener) {
        this.f11833q = recyclerListener;
    }

    public int getBaseline() {
        return this.f11832p != null ? -1 : super.getBaseline();
    }

    public final void m17146a(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.f11801F == null) {
            this.f11801F = new ArrayList();
        }
        this.f11801F.add(onChildAttachStateChangeListener);
    }

    public final void m17154b(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.f11801F != null) {
            this.f11801F.remove(onChildAttachStateChangeListener);
        }
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager != this.f11832p) {
            if (this.f11832p != null) {
                if (this.f11837u) {
                    this.f11832p.m17331b(this, this.f11819a);
                }
                this.f11832p.m17305a(null);
            }
            this.f11819a.m17419a();
            ChildHelper childHelper = this.f11821c;
            childHelper.f11959b.m17644a();
            for (int size = childHelper.f11960c.size() - 1; size >= 0; size--) {
                childHelper.f11958a.mo2280d((View) childHelper.f11960c.get(size));
                childHelper.f11960c.remove(size);
            }
            childHelper.f11958a.mo2277b();
            this.f11832p = layoutManager;
            if (layoutManager != null) {
                if (layoutManager.f11875r != null) {
                    throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView: " + layoutManager.f11875r);
                }
                this.f11832p.m17305a(this);
                if (this.f11837u) {
                    this.f11832p.m17330b(this);
                }
            }
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f11827k != null) {
            SavedState.a(savedState, this.f11827k);
        } else if (this.f11832p != null) {
            savedState.a = this.f11832p.mo2322f();
        } else {
            savedState.a = null;
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        this.f11827k = (SavedState) parcelable;
        super.onRestoreInstanceState(this.f11827k.getSuperState());
        if (this.f11832p != null && this.f11827k.a != null) {
            this.f11832p.mo2306a(this.f11827k.a);
        }
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void m17066a(ViewHolder viewHolder) {
        View view = viewHolder.f14095a;
        boolean z = view.getParent() == this;
        this.f11819a.m17431b(m17138a(view));
        if (viewHolder.m20419r()) {
            this.f11821c.m17609a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            this.f11821c.m17618d(view);
        } else {
            this.f11821c.m17610a(view, -1, true);
        }
    }

    private boolean m17104h(View view) {
        m17151b();
        boolean e = this.f11821c.m17619e(view);
        if (e) {
            ViewHolder b = m17080b(view);
            this.f11819a.m17431b(b);
            this.f11819a.m17426a(b);
        }
        m17150a(false);
        return e;
    }

    public LayoutManager getLayoutManager() {
        return this.f11832p;
    }

    public RecycledViewPool getRecycledViewPool() {
        return this.f11819a.m17439e();
    }

    public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
        this.f11819a.m17424a(recycledViewPool);
    }

    public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
        this.f11819a.f11905h = viewCacheExtension;
    }

    public void setItemViewCacheSize(int i) {
        this.f11819a.m17420a(i);
    }

    public int getScrollState() {
        return this.f11808M;
    }

    public static void setScrollState(RecyclerView recyclerView, int i) {
        if (i != recyclerView.f11808M) {
            recyclerView.f11808M = i;
            if (i != 2) {
                recyclerView.mo2187o();
            }
            recyclerView.m17099g(i);
        }
    }

    private void m17064a(ItemDecoration itemDecoration, int i) {
        if (this.f11832p != null) {
            this.f11832p.mo2309a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f11834r.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.f11834r.add(itemDecoration);
        } else {
            this.f11834r.add(i, itemDecoration);
        }
        m17053E();
        requestLayout();
    }

    public final void m17145a(ItemDecoration itemDecoration) {
        m17064a(itemDecoration, -1);
    }

    public final void m17153b(ItemDecoration itemDecoration) {
        if (this.f11832p != null) {
            this.f11832p.mo2309a("Cannot remove item decoration during a scroll  or layout");
        }
        this.f11834r.remove(itemDecoration);
        if (this.f11834r.isEmpty()) {
            setWillNotDraw(ViewCompat.m10934a(this) == 2);
        }
        m17053E();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childDrawingOrderCallback) {
        if (childDrawingOrderCallback != this.ag) {
            this.ag = childDrawingOrderCallback;
            setChildrenDrawingOrderEnabled(this.ag != null);
        }
    }

    @Deprecated
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.ab = onScrollListener;
    }

    public void mo2191a(OnScrollListener onScrollListener) {
        if (this.ac == null) {
            this.ac = new ArrayList();
        }
        this.ac.add(onScrollListener);
    }

    public void mo2192b(OnScrollListener onScrollListener) {
        if (this.ac != null) {
            this.ac.remove(onScrollListener);
        }
    }

    public final void m17140a() {
        if (this.ac != null) {
            this.ac.clear();
        }
    }

    public final void m17141a(int i) {
        if (!this.f11842z) {
            m17160c();
            if (this.f11832p == null) {
                Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            this.f11832p.mo2319e(i);
            awakenScrollBars();
        }
    }

    private void m17098f(int i) {
        if (this.f11832p != null) {
            this.f11832p.mo2319e(i);
            awakenScrollBars();
        }
    }

    public final void m17152b(int i) {
        if (!this.f11842z) {
            if (this.f11832p == null) {
                Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                this.f11832p.mo2298a(this, this.f11823e, i);
            }
        }
    }

    public void scrollTo(int i, int i2) {
        throw new UnsupportedOperationException("RecyclerView does not support scrolling to an absolute position.");
    }

    public void scrollBy(int i, int i2) {
        if (this.f11832p == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f11842z) {
            boolean g = this.f11832p.mo2324g();
            boolean h = this.f11832p.mo2325h();
            if (g || h) {
                if (!g) {
                    i = 0;
                }
                if (!h) {
                    i2 = 0;
                }
                m17074a(i, i2, null);
            }
        }
    }

    private void mo2198n() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -146665591);
        this.f11829m.run();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -927660301, a);
    }

    private boolean m17074a(int i, int i2, MotionEvent motionEvent) {
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        mo2198n();
        if (this.f11831o != null) {
            m17151b();
            m17134x(this);
            TraceCompatDetour.a("RV Scroll", 1192395540);
            if (i != 0) {
                i5 = this.f11832p.mo2305a(i, this.f11819a, this.f11823e);
                i3 = i - i5;
            }
            if (i2 != 0) {
                i6 = this.f11832p.mo2300b(i2, this.f11819a, this.f11823e);
                i4 = i2 - i6;
            }
            TraceCompatDetour.a(-2112098123);
            if (m17049A(this)) {
                int b = this.f11821c.m17611b();
                for (int i7 = 0; i7 < b; i7++) {
                    View b2 = this.f11821c.m17613b(i7);
                    ViewHolder a = m17138a(b2);
                    if (!(a == null || a.f14102h == null)) {
                        a = a.f14102h;
                        View view = a != null ? a.f14095a : null;
                        if (view != null) {
                            int left = b2.getLeft();
                            int top = b2.getTop();
                            if (left != view.getLeft() || top != view.getTop()) {
                                view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                            }
                        }
                    }
                }
            }
            m17135y(this);
            m17150a(false);
        }
        int i8 = i4;
        i4 = i5;
        i5 = i6;
        if (!this.f11834r.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i4, i5, i3, i8, this.aj)) {
            this.f11813R -= this.aj[0];
            this.f11814S -= this.aj[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.aj[0], (float) this.aj[1]);
            }
            int[] iArr = this.al;
            iArr[0] = iArr[0] + this.aj[0];
            iArr = this.al;
            iArr[1] = iArr[1] + this.aj[1];
        } else if (ViewCompat.m10934a(this) != 2) {
            if (motionEvent != null) {
                m17060a(motionEvent.getX(), (float) i3, motionEvent.getY(), (float) i8);
            }
            mo2195g(i, i2);
        }
        if (!(i4 == 0 && i5 == 0)) {
            m17170f(i4, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (i4 == 0 && i5 == 0) {
            return false;
        }
        return true;
    }

    public int computeHorizontalScrollOffset() {
        return this.f11832p.mo2324g() ? this.f11832p.mo2310b(this.f11823e) : 0;
    }

    public int computeHorizontalScrollExtent() {
        return this.f11832p.mo2324g() ? this.f11832p.mo2315d(this.f11823e) : 0;
    }

    public int computeHorizontalScrollRange() {
        return this.f11832p.mo2324g() ? this.f11832p.mo2321f(this.f11823e) : 0;
    }

    public int computeVerticalScrollOffset() {
        return this.f11832p.mo2325h() ? this.f11832p.mo2311c(this.f11823e) : 0;
    }

    public int computeVerticalScrollExtent() {
        return this.f11832p.mo2325h() ? this.f11832p.mo2318e(this.f11823e) : 0;
    }

    public int computeVerticalScrollRange() {
        return this.f11832p.mo2325h() ? this.f11832p.mo2323g(this.f11823e) : 0;
    }

    final void m17151b() {
        if (!this.f11840x) {
            this.f11840x = true;
            if (!this.f11842z) {
                this.f11841y = false;
            }
        }
    }

    final void m17150a(boolean z) {
        if (this.f11840x) {
            if (!(!z || !this.f11841y || this.f11842z || this.f11832p == null || this.f11831o == null)) {
                m17169f();
            }
            this.f11840x = false;
            if (!this.f11842z) {
                this.f11841y = false;
            }
        }
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.f11842z) {
            m17149a("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.f11842z = z;
                this.f11796A = true;
                m17160c();
                return;
            }
            this.f11842z = z;
            if (!(!this.f11841y || this.f11832p == null || this.f11831o == null)) {
                requestLayout();
            }
            this.f11841y = false;
        }
    }

    public final void m17142a(int i, int i2) {
        int i3 = 0;
        if (this.f11832p == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f11842z) {
            if (!this.f11832p.mo2324g()) {
                i = 0;
            }
            if (this.f11832p.mo2325h()) {
                i3 = i2;
            }
            if (i != 0 || i3 != 0) {
                this.aa.m17492b(i, i3);
            }
        }
    }

    public boolean m17157b(int i, int i2) {
        if (this.f11832p == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.f11842z) {
            return false;
        } else {
            boolean g = this.f11832p.mo2324g();
            boolean h = this.f11832p.mo2325h();
            if (!g || Math.abs(i) < this.f11816U) {
                i = 0;
            }
            if (!h || Math.abs(i2) < this.f11816U) {
                i2 = 0;
            }
            if ((i == 0 && i2 == 0) || dispatchNestedPreFling((float) i, (float) i2)) {
                return false;
            }
            g = g || h;
            dispatchNestedFling((float) i, (float) i2, g);
            if (!g) {
                return false;
            }
            this.aa.m17488a(Math.max(-this.f11817V, Math.min(i, this.f11817V)), Math.max(-this.f11817V, Math.min(i2, this.f11817V)));
            return true;
        }
    }

    public final void m17160c() {
        setScrollState(this, 0);
        mo2187o();
    }

    private void mo2187o() {
        this.aa.m17491b();
        if (this.f11832p != null) {
            this.f11832p.m17289G();
        }
    }

    public int getMinFlingVelocity() {
        return this.f11816U;
    }

    public int getMaxFlingVelocity() {
        return this.f11817V;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m17060a(float r8, float r9, float r10, float r11) {
        /*
        r7 = this;
        r6 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = 1;
        r5 = 0;
        r1 = 0;
        r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x0050;
    L_0x0009:
        r7.m17124q();
        r2 = r7.f11804I;
        r3 = -r9;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r3 = r3 / r4;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r4 = r10 / r4;
        r4 = r6 - r4;
        r2 = r2.m10839a(r3, r4);
        if (r2 == 0) goto L_0x0025;
    L_0x0024:
        r1 = r0;
    L_0x0025:
        r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x006f;
    L_0x0029:
        r7.m17127s();
        r2 = r7.f11805J;
        r3 = -r11;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r3 = r3 / r4;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r4 = r8 / r4;
        r2 = r2.m10839a(r3, r4);
        if (r2 == 0) goto L_0x008e;
    L_0x0042:
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r0 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r0 != 0) goto L_0x004c;
    L_0x0048:
        r0 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r0 == 0) goto L_0x004f;
    L_0x004c:
        android.support.v4.view.ViewCompat.m10956d(r7);
    L_0x004f:
        return;
    L_0x0050:
        r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r2 <= 0) goto L_0x0025;
    L_0x0054:
        r7.m17126r();
        r2 = r7.f11806K;
        r3 = r7.getWidth();
        r3 = (float) r3;
        r3 = r9 / r3;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r4 = r10 / r4;
        r2 = r2.m10839a(r3, r4);
        if (r2 == 0) goto L_0x0025;
    L_0x006d:
        r1 = r0;
        goto L_0x0025;
    L_0x006f:
        r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r2 <= 0) goto L_0x008e;
    L_0x0073:
        r7.m17130t();
        r2 = r7.f11807L;
        r3 = r7.getHeight();
        r3 = (float) r3;
        r3 = r11 / r3;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r4 = r8 / r4;
        r4 = r6 - r4;
        r2 = r2.m10839a(r3, r4);
        if (r2 != 0) goto L_0x0042;
    L_0x008e:
        r0 = r1;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.a(float, float, float, float):void");
    }

    private void m17122p() {
        int i = 0;
        if (this.f11804I != null) {
            i = this.f11804I.m10843c();
        }
        if (this.f11805J != null) {
            i |= this.f11805J.m10843c();
        }
        if (this.f11806K != null) {
            i |= this.f11806K.m10843c();
        }
        if (this.f11807L != null) {
            i |= this.f11807L.m10843c();
        }
        if (i != 0) {
            ViewCompat.m10956d(this);
        }
    }

    private void mo2195g(int i, int i2) {
        int i3 = 0;
        if (!(this.f11804I == null || this.f11804I.m10837a() || i <= 0)) {
            i3 = this.f11804I.m10843c();
        }
        if (!(this.f11806K == null || this.f11806K.m10837a() || i >= 0)) {
            i3 |= this.f11806K.m10843c();
        }
        if (!(this.f11805J == null || this.f11805J.m10837a() || i2 <= 0)) {
            i3 |= this.f11805J.m10843c();
        }
        if (!(this.f11807L == null || this.f11807L.m10837a() || i2 >= 0)) {
            i3 |= this.f11807L.m10843c();
        }
        if (i3 != 0) {
            ViewCompat.m10956d(this);
        }
    }

    final void m17161c(int i, int i2) {
        if (i < 0) {
            m17124q();
            this.f11804I.m10840a(-i);
        } else if (i > 0) {
            m17126r();
            this.f11806K.m10840a(i);
        }
        if (i2 < 0) {
            m17127s();
            this.f11805J.m10840a(-i2);
        } else if (i2 > 0) {
            m17130t();
            this.f11807L.m10840a(i2);
        }
        if (i != 0 || i2 != 0) {
            ViewCompat.m10956d(this);
        }
    }

    private void m17124q() {
        if (this.f11804I == null) {
            this.f11804I = new EdgeEffectCompat(getContext());
            if (this.f11828l) {
                this.f11804I.m10836a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.f11804I.m10836a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    private void m17126r() {
        if (this.f11806K == null) {
            this.f11806K = new EdgeEffectCompat(getContext());
            if (this.f11828l) {
                this.f11806K.m10836a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.f11806K.m10836a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    private void m17127s() {
        if (this.f11805J == null) {
            this.f11805J = new EdgeEffectCompat(getContext());
            if (this.f11828l) {
                this.f11805J.m10836a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.f11805J.m10836a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    private void m17130t() {
        if (this.f11807L == null) {
            this.f11807L = new EdgeEffectCompat(getContext());
            if (this.f11828l) {
                this.f11807L.m10836a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.f11807L.m10836a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    private void m17131u() {
        this.f11807L = null;
        this.f11805J = null;
        this.f11806K = null;
        this.f11804I = null;
    }

    public void requestChildFocus(View view, View view2) {
        if (!(this.f11832p.m17322a(this, view, view2) || view2 == null)) {
            Rect rect;
            boolean z;
            this.f11830n.set(0, 0, view2.getWidth(), view2.getHeight());
            android.view.ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                if (!layoutParams2.f14112c) {
                    Rect rect2 = layoutParams2.f14111b;
                    rect = this.f11830n;
                    rect.left -= rect2.left;
                    rect = this.f11830n;
                    rect.right += rect2.right;
                    rect = this.f11830n;
                    rect.top -= rect2.top;
                    rect = this.f11830n;
                    rect.bottom = rect2.bottom + rect.bottom;
                }
            }
            offsetDescendantRectToMyCoords(view2, this.f11830n);
            offsetRectIntoDescendantCoords(view, this.f11830n);
            rect = this.f11830n;
            if (this.f11839w) {
                z = false;
            } else {
                z = true;
            }
            requestChildRectangleOnScreen(view, rect, z);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.f11832p.m17321a(this, view, rect, z);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (this.f11832p == null || null == null) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -256248927);
        super.onAttachedToWindow();
        this.f11803H = 0;
        this.f11837u = true;
        this.f11839w = false;
        if (this.f11832p != null) {
            this.f11832p.m17330b(this);
        }
        this.ae = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1179269085, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -582769335);
        super.onDetachedFromWindow();
        if (this.f11822d != null) {
            this.f11822d.mo2241c();
        }
        this.f11839w = false;
        m17160c();
        this.f11837u = false;
        if (this.f11832p != null) {
            this.f11832p.m17331b(this, this.f11819a);
        }
        removeCallbacks(this.am);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1664462310, a);
    }

    public boolean isAttachedToWindow() {
        return this.f11837u;
    }

    final void m17149a(String str) {
        if (!m17167e()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
        }
        throw new IllegalStateException(str);
    }

    public final void m17147a(OnItemTouchListener onItemTouchListener) {
        this.f11835s.add(onItemTouchListener);
    }

    public final void m17155b(OnItemTouchListener onItemTouchListener) {
        this.f11835s.remove(onItemTouchListener);
        if (this.f11836t == onItemTouchListener) {
            this.f11836t = null;
        }
    }

    private boolean m17077a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.f11836t = null;
        }
        int size = this.f11835s.size();
        int i = 0;
        while (i < size) {
            OnItemTouchListener onItemTouchListener = (OnItemTouchListener) this.f11835s.get(i);
            if (!onItemTouchListener.mo2214a(motionEvent) || action == 3) {
                i++;
            } else {
                this.f11836t = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    private boolean m17086b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.f11836t != null) {
            if (action == 0) {
                this.f11836t = null;
            } else {
                this.f11836t.mo2215b(motionEvent);
                if (action == 3 || action == 1) {
                    this.f11836t = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.f11835s.size();
            for (int i = 0; i < size; i++) {
                OnItemTouchListener onItemTouchListener = (OnItemTouchListener) this.f11835s.get(i);
                if (onItemTouchListener.mo2214a(motionEvent)) {
                    this.f11836t = onItemTouchListener;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = -1;
        if (this.f11842z) {
            return false;
        }
        if (m17077a(motionEvent)) {
            m17133w();
            return true;
        } else if (this.f11832p == null) {
            return false;
        } else {
            boolean g = this.f11832p.mo2324g();
            boolean h = this.f11832p.mo2325h();
            if (this.f11810O == null) {
                this.f11810O = VelocityTracker.obtain();
            }
            this.f11810O.addMovement(motionEvent);
            int a = MotionEventCompat.a(motionEvent);
            int b = MotionEventCompat.b(motionEvent);
            int i2;
            switch (a) {
                case 0:
                    if (this.f11796A) {
                        this.f11796A = false;
                    }
                    this.f11809N = MotionEventCompat.b(motionEvent, 0);
                    i = (int) (motionEvent.getX() + 0.5f);
                    this.f11813R = i;
                    this.f11811P = i;
                    i = (int) (motionEvent.getY() + 0.5f);
                    this.f11814S = i;
                    this.f11812Q = i;
                    if (this.f11808M == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(this, 1);
                    }
                    if (g) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (h) {
                        i2 |= 2;
                    }
                    startNestedScroll(i2);
                    break;
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    this.f11810O.clear();
                    stopNestedScroll();
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    a = MotionEventCompat.a(motionEvent, this.f11809N);
                    if (a >= 0) {
                        b = (int) (MotionEventCompat.c(motionEvent, a) + 0.5f);
                        a = (int) (MotionEventCompat.d(motionEvent, a) + 0.5f);
                        if (this.f11808M != 1) {
                            b -= this.f11811P;
                            a -= this.f11812Q;
                            if (!g || Math.abs(b) <= this.f11815T) {
                                g = false;
                            } else {
                                this.f11813R = ((b < 0 ? -1 : 1) * this.f11815T) + this.f11811P;
                                g = true;
                            }
                            if (h && Math.abs(a) > this.f11815T) {
                                i2 = this.f11812Q;
                                int i3 = this.f11815T;
                                if (a >= 0) {
                                    i = 1;
                                }
                                this.f11814S = i2 + (i * i3);
                                g = true;
                            }
                            if (g) {
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                                setScrollState(this, 1);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f11809N + " not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    m17133w();
                    break;
                case 5:
                    this.f11809N = MotionEventCompat.b(motionEvent, b);
                    i2 = (int) (MotionEventCompat.c(motionEvent, b) + 0.5f);
                    this.f11813R = i2;
                    this.f11811P = i2;
                    i2 = (int) (MotionEventCompat.d(motionEvent, b) + 0.5f);
                    this.f11814S = i2;
                    this.f11812Q = i2;
                    break;
                case 6:
                    m17090c(motionEvent);
                    break;
            }
            if (this.f11808M != 1) {
                return false;
            }
            return true;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.f11835s.size();
        for (int i = 0; i < size; i++) {
            ((OnItemTouchListener) this.f11835s.get(i)).mo2213a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1208468912);
        if (this.f11842z || this.f11796A) {
            Logger.a(2, EntryType.UI_INPUT_END, -370241940, a);
            return false;
        } else if (m17086b(motionEvent)) {
            m17133w();
            LogUtils.a(200208549, a);
            return true;
        } else if (this.f11832p == null) {
            LogUtils.a(-1930549852, a);
            return false;
        } else {
            boolean g = this.f11832p.mo2324g();
            boolean h = this.f11832p.mo2325h();
            if (this.f11810O == null) {
                this.f11810O = VelocityTracker.obtain();
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int a2 = MotionEventCompat.a(motionEvent);
            int b = MotionEventCompat.b(motionEvent);
            if (a2 == 0) {
                int[] iArr = this.al;
                this.al[1] = 0;
                iArr[0] = 0;
            }
            obtain.offsetLocation((float) this.al[0], (float) this.al[1]);
            switch (a2) {
                case 0:
                    this.f11809N = MotionEventCompat.b(motionEvent, 0);
                    a2 = (int) (motionEvent.getX() + 0.5f);
                    this.f11813R = a2;
                    this.f11811P = a2;
                    a2 = (int) (motionEvent.getY() + 0.5f);
                    this.f11814S = a2;
                    this.f11812Q = a2;
                    if (g) {
                        a2 = 1;
                    } else {
                        a2 = 0;
                    }
                    if (h) {
                        a2 |= 2;
                    }
                    startNestedScroll(a2);
                    break;
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    this.f11810O.addMovement(obtain);
                    this.f11810O.computeCurrentVelocity(1000, (float) this.f11817V);
                    float f = g ? -VelocityTrackerCompat.a(this.f11810O, this.f11809N) : 0.0f;
                    float f2;
                    if (h) {
                        f2 = -VelocityTrackerCompat.b(this.f11810O, this.f11809N);
                    } else {
                        f2 = 0.0f;
                    }
                    if ((f == 0.0f && r0 == 0.0f) || !m17157b((int) f, (int) r0)) {
                        setScrollState(this, 0);
                    }
                    m17132v();
                    z = true;
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    a2 = MotionEventCompat.a(motionEvent, this.f11809N);
                    if (a2 >= 0) {
                        int c = (int) (MotionEventCompat.c(motionEvent, a2) + 0.5f);
                        int d = (int) (MotionEventCompat.d(motionEvent, a2) + 0.5f);
                        int i = this.f11813R - c;
                        a2 = this.f11814S - d;
                        if (dispatchNestedPreScroll(i, a2, this.ak, this.aj)) {
                            i -= this.ak[0];
                            a2 -= this.ak[1];
                            obtain.offsetLocation((float) this.aj[0], (float) this.aj[1]);
                            int[] iArr2 = this.al;
                            iArr2[0] = iArr2[0] + this.aj[0];
                            iArr2 = this.al;
                            iArr2[1] = iArr2[1] + this.aj[1];
                        }
                        if (this.f11808M != 1) {
                            boolean z2;
                            if (!g || Math.abs(i) <= this.f11815T) {
                                z2 = false;
                            } else {
                                if (i > 0) {
                                    i -= this.f11815T;
                                } else {
                                    i += this.f11815T;
                                }
                                z2 = true;
                            }
                            if (h && Math.abs(a2) > this.f11815T) {
                                if (a2 > 0) {
                                    a2 -= this.f11815T;
                                } else {
                                    a2 += this.f11815T;
                                }
                                z2 = true;
                            }
                            if (z2) {
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                                setScrollState(this, 1);
                            }
                        }
                        if (this.f11808M == 1) {
                            this.f11813R = c - this.aj[0];
                            this.f11814S = d - this.aj[1];
                            if (!g) {
                                i = 0;
                            }
                            if (!h) {
                                a2 = 0;
                            }
                            if (m17074a(i, a2, obtain)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f11809N + " not found. Did any MotionEvents get skipped?");
                    LogUtils.a(-1118324419, a);
                    return false;
                    break;
                case 3:
                    m17133w();
                    break;
                case 5:
                    this.f11809N = MotionEventCompat.b(motionEvent, b);
                    a2 = (int) (MotionEventCompat.c(motionEvent, b) + 0.5f);
                    this.f11813R = a2;
                    this.f11811P = a2;
                    a2 = (int) (MotionEventCompat.d(motionEvent, b) + 0.5f);
                    this.f11814S = a2;
                    this.f11812Q = a2;
                    break;
                case 6:
                    m17090c(motionEvent);
                    break;
            }
            if (!z) {
                this.f11810O.addMovement(obtain);
            }
            obtain.recycle();
            LogUtils.a(1027477279, a);
            return true;
        }
    }

    private void m17132v() {
        if (this.f11810O != null) {
            this.f11810O.clear();
        }
        stopNestedScroll();
        m17122p();
    }

    private void m17133w() {
        m17132v();
        setScrollState(this, 0);
    }

    private void m17090c(MotionEvent motionEvent) {
        int b = MotionEventCompat.b(motionEvent);
        if (MotionEventCompat.b(motionEvent, b) == this.f11809N) {
            b = b == 0 ? 1 : 0;
            this.f11809N = MotionEventCompat.b(motionEvent, b);
            int c = (int) (MotionEventCompat.c(motionEvent, b) + 0.5f);
            this.f11813R = c;
            this.f11811P = c;
            b = (int) (MotionEventCompat.d(motionEvent, b) + 0.5f);
            this.f11814S = b;
            this.f11812Q = b;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!(this.f11832p == null || this.f11842z || (MotionEventCompat.d(motionEvent) & 2) == 0 || motionEvent.getAction() != 8)) {
            float f;
            float e;
            if (this.f11832p.mo2325h()) {
                f = -MotionEventCompat.e(motionEvent, 9);
            } else {
                f = 0.0f;
            }
            if (this.f11832p.mo2324g()) {
                e = MotionEventCompat.e(motionEvent, 10);
            } else {
                e = 0.0f;
            }
            if (!(f == 0.0f && e == 0.0f)) {
                float scrollFactor = getScrollFactor();
                m17074a((int) (e * scrollFactor), (int) (f * scrollFactor), motionEvent);
            }
        }
        return false;
    }

    private float getScrollFactor() {
        if (this.f11818W == Float.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (!getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                return 0.0f;
            }
            this.f11818W = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
        }
        return this.f11818W;
    }

    protected void onMeasure(int i, int i2) {
        if (this.f11798C) {
            m17151b();
            m17052D();
            if (this.f11823e.f11946m) {
                this.f11823e.f11944k = true;
            } else {
                this.f11820b.m17580e();
                this.f11823e.f11944k = false;
            }
            this.f11798C = false;
            m17150a(false);
        }
        if (this.f11831o != null) {
            this.f11823e.f11938e = this.f11831o.aZ_();
        } else {
            this.f11823e.f11938e = 0;
        }
        if (this.f11832p == null) {
            m17102h(i, i2);
        } else {
            this.f11832p.m17302a(this.f11819a, this.f11823e, i, i2);
        }
        this.f11823e.f11944k = false;
    }

    private void m17102h(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                break;
            default:
                size = ViewCompat.m10974r(this);
                break;
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
            case 1073741824:
                break;
            default:
                size2 = ViewCompat.m10975s(this);
                break;
        }
        setMeasuredDimension(size, size2);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -619864568);
        super.onSizeChanged(i, i2, i3, i4);
        if (!(i == i3 && i2 == i4)) {
            m17131u();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1039808403, a);
    }

    public void setItemAnimator(ItemAnimator itemAnimator) {
        if (this.f11822d != null) {
            this.f11822d.mo2241c();
            this.f11822d.f11918a = null;
        }
        this.f11822d = itemAnimator;
        if (this.f11822d != null) {
            this.f11822d.f11918a = this.ad;
        }
    }

    public static void m17134x(RecyclerView recyclerView) {
        recyclerView.f11803H++;
    }

    public static void m17135y(RecyclerView recyclerView) {
        recyclerView.f11803H--;
        if (recyclerView.f11803H <= 0) {
            recyclerView.f11803H = 0;
            recyclerView.m17136z();
        }
    }

    final boolean m17164d() {
        return this.f11800E != null && this.f11800E.isEnabled();
    }

    private void m17136z() {
        int i = this.f11797B;
        this.f11797B = 0;
        if (i != 0 && m17164d()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            AccessibilityEventCompat.a.a(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    public final boolean m17167e() {
        return this.f11803H > 0;
    }

    private boolean m17078a(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (!m17167e()) {
            return false;
        }
        int a;
        if (accessibilityEvent != null) {
            a = AccessibilityEventCompat.a.a(accessibilityEvent);
        } else {
            a = 0;
        }
        if (a != 0) {
            i = a;
        }
        this.f11797B = i | this.f11797B;
        return true;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!m17078a(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public ItemAnimator getItemAnimator() {
        return this.f11822d;
    }

    public static boolean m17049A(RecyclerView recyclerView) {
        return recyclerView.f11822d != null && recyclerView.f11822d.f11924g;
    }

    private void m17050B() {
        if (!this.ae && this.f11837u) {
            ViewCompat.m10943a((View) this, this.am);
            this.ae = true;
        }
    }

    private boolean m17051C() {
        return this.f11822d != null && this.f11832p.mo2320e();
    }

    private void m17052D() {
        boolean z;
        boolean z2 = true;
        if (this.f11802G) {
            this.f11820b.m17574a();
            m17057I();
            this.f11832p.m17295a();
        }
        if (this.f11822d == null || !this.f11832p.mo2320e()) {
            this.f11820b.m17580e();
        } else {
            this.f11820b.m17577b();
        }
        boolean z3;
        if ((this.f11824f && !this.f11825g) || this.f11824f || (this.f11825g && m17049A(this))) {
            z3 = true;
        } else {
            z3 = false;
        }
        State state = this.f11823e;
        if (!this.f11839w || this.f11822d == null || (!(this.f11802G || r0 || this.f11832p.f11872a) || (this.f11802G && !this.f11831o.en_()))) {
            z = false;
        } else {
            z = true;
        }
        state.f11945l = z;
        State state2 = this.f11823e;
        if (!(this.f11823e.f11945l && r0 && !this.f11802G && m17051C())) {
            z2 = false;
        }
        state2.f11946m = z2;
    }

    final void m17169f() {
        if (this.f11831o == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.f11832p == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            int i;
            ViewHolder b;
            View view;
            int b2;
            int i2;
            boolean z;
            int i3;
            ArrayMap arrayMap;
            this.f11823e.f11937d.clear();
            m17151b();
            m17134x(this);
            m17052D();
            State state = this.f11823e;
            ArrayMap arrayMap2 = (this.f11823e.f11945l && this.f11825g && m17049A(this)) ? new ArrayMap() : null;
            state.f11936c = arrayMap2;
            this.f11825g = false;
            this.f11824f = false;
            this.f11823e.f11944k = this.f11823e.f11946m;
            this.f11823e.f11938e = this.f11831o.aZ_();
            m17073a(this.ah);
            if (this.f11823e.f11945l) {
                this.f11823e.f11934a.clear();
                this.f11823e.f11935b.clear();
                int b3 = this.f11821c.m17611b();
                for (i = 0; i < b3; i++) {
                    b = m17080b(this.f11821c.m17613b(i));
                    if (!b.m20404c() && (!b.m20414m() || this.f11831o.en_())) {
                        view = b.f14095a;
                        this.f11823e.f11934a.put(b, new ItemHolderInfo(b, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                    }
                }
            }
            ViewHolder b4;
            if (this.f11823e.f11946m) {
                m17054F();
                if (this.f11823e.f11936c != null) {
                    b2 = this.f11821c.m17611b();
                    for (i2 = 0; i2 < b2; i2++) {
                        b4 = m17080b(this.f11821c.m17613b(i2));
                        if (!(!b4.m20416o() || b4.m20418q() || b4.m20404c())) {
                            this.f11823e.f11936c.put(Long.valueOf(m17079b(b4)), b4);
                            this.f11823e.f11934a.remove(b4);
                        }
                    }
                }
                z = this.f11823e.f11943j;
                this.f11823e.f11943j = false;
                this.f11832p.mo2314c(this.f11819a, this.f11823e);
                this.f11823e.f11943j = z;
                ArrayMap arrayMap3 = new ArrayMap();
                for (b2 = 0; b2 < this.f11821c.m17611b(); b2++) {
                    View b5 = this.f11821c.m17613b(b2);
                    if (!m17080b(b5).m20404c()) {
                        for (i3 = 0; i3 < this.f11823e.f11934a.size(); i3++) {
                            if (((ViewHolder) this.f11823e.f11934a.b(i3)).f14095a == b5) {
                                i2 = 1;
                                break;
                            }
                        }
                        z = false;
                        if (i2 == 0) {
                            arrayMap3.put(b5, new Rect(b5.getLeft(), b5.getTop(), b5.getRight(), b5.getBottom()));
                        }
                    }
                }
                m17055G();
                this.f11820b.m17578c();
                arrayMap = arrayMap3;
            } else {
                m17055G();
                this.f11820b.m17580e();
                if (this.f11823e.f11936c != null) {
                    b2 = this.f11821c.m17611b();
                    for (i2 = 0; i2 < b2; i2++) {
                        b4 = m17080b(this.f11821c.m17613b(i2));
                        if (!(!b4.m20416o() || b4.m20418q() || b4.m20404c())) {
                            this.f11823e.f11936c.put(Long.valueOf(m17079b(b4)), b4);
                            this.f11823e.f11934a.remove(b4);
                        }
                    }
                }
                arrayMap = null;
            }
            this.f11823e.f11938e = this.f11831o.aZ_();
            this.f11823e.f11942i = 0;
            this.f11823e.f11944k = false;
            this.f11832p.mo2314c(this.f11819a, this.f11823e);
            this.f11823e.f11943j = false;
            this.f11827k = null;
            state = this.f11823e;
            if (!this.f11823e.f11945l || this.f11822d == null) {
                z = false;
            } else {
                z = true;
            }
            state.f11945l = z;
            if (this.f11823e.f11945l) {
                SimpleArrayMap arrayMap4;
                int i4;
                ViewHolder viewHolder;
                if (this.f11823e.f11936c != null) {
                    arrayMap4 = new ArrayMap();
                } else {
                    arrayMap4 = null;
                }
                int b6 = this.f11821c.m17611b();
                for (i4 = 0; i4 < b6; i4++) {
                    b = m17080b(this.f11821c.m17613b(i4));
                    if (!b.m20404c()) {
                        view = b.f14095a;
                        long b7 = m17079b(b);
                        if (arrayMap4 == null || this.f11823e.f11936c.get(Long.valueOf(b7)) == null) {
                            this.f11823e.f11935b.put(b, new ItemHolderInfo(b, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                        } else {
                            arrayMap4.put(Long.valueOf(b7), b);
                        }
                    }
                }
                m17062a(arrayMap);
                for (b2 = this.f11823e.f11934a.size() - 1; b2 >= 0; b2--) {
                    if (!this.f11823e.f11935b.containsKey((ViewHolder) this.f11823e.f11934a.b(b2))) {
                        ItemHolderInfo itemHolderInfo = (ItemHolderInfo) this.f11823e.f11934a.c(b2);
                        this.f11823e.f11934a.d(b2);
                        View view2 = itemHolderInfo.a.f14095a;
                        this.f11819a.m17431b(itemHolderInfo.a);
                        m17065a(itemHolderInfo);
                    }
                }
                i2 = this.f11823e.f11935b.size();
                if (i2 > 0) {
                    for (int i5 = i2 - 1; i5 >= 0; i5--) {
                        viewHolder = (ViewHolder) this.f11823e.f11935b.b(i5);
                        ItemHolderInfo itemHolderInfo2 = (ItemHolderInfo) this.f11823e.f11935b.c(i5);
                        if (this.f11823e.f11934a.isEmpty() || !this.f11823e.f11934a.containsKey(viewHolder)) {
                            Rect rect;
                            this.f11823e.f11935b.d(i5);
                            if (arrayMap != null) {
                                rect = (Rect) arrayMap.get(viewHolder.f14095a);
                            } else {
                                rect = null;
                            }
                            m17067a(viewHolder, rect, itemHolderInfo2.b, itemHolderInfo2.c);
                        }
                    }
                }
                i4 = this.f11823e.f11935b.size();
                for (i = 0; i < i4; i++) {
                    b = (ViewHolder) this.f11823e.f11935b.b(i);
                    ItemHolderInfo itemHolderInfo3 = (ItemHolderInfo) this.f11823e.f11935b.c(i);
                    ItemHolderInfo itemHolderInfo4 = (ItemHolderInfo) this.f11823e.f11934a.get(b);
                    if (!(itemHolderInfo4 == null || itemHolderInfo3 == null || (itemHolderInfo4.b == itemHolderInfo3.b && itemHolderInfo4.c == itemHolderInfo3.c))) {
                        b.m20400a(false);
                        if (this.f11822d.mo2237a(b, itemHolderInfo4.b, itemHolderInfo4.c, itemHolderInfo3.b, itemHolderInfo3.c)) {
                            m17050B();
                        }
                    }
                }
                if (this.f11823e.f11936c != null) {
                    i2 = this.f11823e.f11936c.size();
                } else {
                    i2 = 0;
                }
                for (i3 = i2 - 1; i3 >= 0; i3--) {
                    long longValue = ((Long) this.f11823e.f11936c.b(i3)).longValue();
                    viewHolder = (ViewHolder) this.f11823e.f11936c.get(Long.valueOf(longValue));
                    View view3 = viewHolder.f14095a;
                    if (!(viewHolder.m20404c() || this.f11819a.f11901d == null || !this.f11819a.f11901d.contains(viewHolder))) {
                        m17068a(viewHolder, (ViewHolder) arrayMap4.get(Long.valueOf(longValue)));
                    }
                }
            }
            m17150a(false);
            this.f11832p.m17329b(this.f11819a);
            this.f11823e.f11941h = this.f11823e.f11938e;
            this.f11802G = false;
            this.f11823e.f11945l = false;
            this.f11823e.f11946m = false;
            m17135y(this);
            this.f11832p.f11872a = false;
            if (this.f11819a.f11901d != null) {
                this.f11819a.f11901d.clear();
            }
            this.f11823e.f11936c = null;
            if (m17107i(this.ah[0], this.ah[1])) {
                m17170f(0, 0);
            }
        }
    }

    private void m17073a(int[] iArr) {
        int b = this.f11821c.m17611b();
        if (b == 0) {
            iArr[0] = 0;
            iArr[1] = 0;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        while (i3 < b) {
            int d;
            ViewHolder b2 = m17080b(this.f11821c.m17613b(i3));
            if (!b2.m20404c()) {
                d = b2.m20405d();
                if (d < i) {
                    i = d;
                }
                if (d > i2) {
                    i2 = i;
                    i3++;
                    i = i2;
                    i2 = d;
                }
            }
            d = i2;
            i2 = i;
            i3++;
            i = i2;
            i2 = d;
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private boolean m17107i(int i, int i2) {
        int b = this.f11821c.m17611b();
        if (b != 0) {
            for (int i3 = 0; i3 < b; i3++) {
                ViewHolder b2 = m17080b(this.f11821c.m17613b(i3));
                if (!b2.m20404c()) {
                    int d = b2.m20405d();
                    if (d < i || d > i2) {
                        return true;
                    }
                }
            }
            return false;
        } else if (i == 0 && i2 == 0) {
            return false;
        } else {
            return true;
        }
    }

    protected void removeDetachedView(View view, boolean z) {
        ViewHolder b = m17080b(view);
        if (b != null) {
            if (b.m20419r()) {
                b.m20413l();
            } else if (!b.m20404c()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + b);
            }
        }
        m17106i(this, view);
        super.removeDetachedView(view, z);
    }

    private long m17079b(ViewHolder viewHolder) {
        return this.f11831o.en_() ? viewHolder.f14098d : (long) viewHolder.f14096b;
    }

    private void m17062a(ArrayMap<View, Rect> arrayMap) {
        List list = this.f11823e.f11937d;
        for (int size = list.size() - 1; size >= 0; size--) {
            View view = (View) list.get(size);
            ViewHolder b = m17080b(view);
            ItemHolderInfo itemHolderInfo = (ItemHolderInfo) this.f11823e.f11934a.remove(b);
            if (!this.f11823e.f11944k) {
                this.f11823e.f11935b.remove(b);
            }
            if (arrayMap.remove(view) != null) {
                this.f11832p.mo2296a(view, this.f11819a);
            } else if (itemHolderInfo != null) {
                m17065a(itemHolderInfo);
            } else {
                m17065a(new ItemHolderInfo(b, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            }
        }
        list.clear();
    }

    private void m17067a(ViewHolder viewHolder, Rect rect, int i, int i2) {
        View view = viewHolder.f14095a;
        if (rect == null || (rect.left == i && rect.top == i2)) {
            viewHolder.m20400a(false);
            if (this.f11822d.mo2240b(viewHolder)) {
                m17050B();
                return;
            }
            return;
        }
        viewHolder.m20400a(false);
        if (this.f11822d.mo2237a(viewHolder, rect.left, rect.top, i, i2)) {
            m17050B();
        }
    }

    private void m17065a(ItemHolderInfo itemHolderInfo) {
        View view = itemHolderInfo.a.f14095a;
        m17066a(itemHolderInfo.a);
        int i = itemHolderInfo.b;
        int i2 = itemHolderInfo.c;
        int left = view.getLeft();
        int top = view.getTop();
        if (itemHolderInfo.a.m20418q() || (i == left && i2 == top)) {
            itemHolderInfo.a.m20400a(false);
            if (this.f11822d.mo2236a(itemHolderInfo.a)) {
                m17050B();
                return;
            }
            return;
        }
        itemHolderInfo.a.m20400a(false);
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        if (this.f11822d.mo2237a(itemHolderInfo.a, i, i2, left, top)) {
            m17050B();
        }
    }

    private void m17068a(ViewHolder viewHolder, ViewHolder viewHolder2) {
        int i;
        int i2;
        viewHolder.m20400a(false);
        m17066a(viewHolder);
        viewHolder.f14101g = viewHolder2;
        this.f11819a.m17431b(viewHolder);
        int left = viewHolder.f14095a.getLeft();
        int top = viewHolder.f14095a.getTop();
        if (viewHolder2 == null || viewHolder2.m20404c()) {
            i = top;
            i2 = left;
        } else {
            i2 = viewHolder2.f14095a.getLeft();
            i = viewHolder2.f14095a.getTop();
            viewHolder2.m20400a(false);
            viewHolder2.f14102h = viewHolder;
        }
        if (this.f11822d.mo2238a(viewHolder, viewHolder2, left, top, i2, i)) {
            m17050B();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        m17151b();
        TraceCompatDetour.a("RV OnLayout", 1748745052);
        m17169f();
        TraceCompatDetour.a(-175736619);
        m17150a(false);
        this.f11839w = true;
    }

    public void requestLayout() {
        if (this.f11840x || this.f11842z) {
            this.f11841y = true;
        } else {
            super.requestLayout();
        }
    }

    private void m17053E() {
        int c = this.f11821c.m17614c();
        for (int i = 0; i < c; i++) {
            ((LayoutParams) this.f11821c.m17615c(i).getLayoutParams()).f14112c = true;
        }
        this.f11819a.m17443i();
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = 1;
        int i4 = 0;
        super.draw(canvas);
        int size = this.f11834r.size();
        for (i = 0; i < size; i++) {
            ((ItemDecoration) this.f11834r.get(i)).m19329b(canvas, this, this.f11823e);
        }
        if (this.f11804I == null || this.f11804I.m10837a()) {
            i2 = 0;
        } else {
            i = canvas.save();
            i2 = this.f11828l ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) (i2 + (-getHeight())), 0.0f);
            if (this.f11804I == null || !this.f11804I.m10841a(canvas)) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            canvas.restoreToCount(i);
        }
        if (!(this.f11805J == null || this.f11805J.m10837a())) {
            size = canvas.save();
            if (this.f11828l) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            if (this.f11805J == null || !this.f11805J.m10841a(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.f11806K == null || this.f11806K.m10837a())) {
            size = canvas.save();
            int width = getWidth();
            if (this.f11828l) {
                i = getPaddingTop();
            } else {
                i = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate((float) (-i), (float) (-width));
            if (this.f11806K == null || !this.f11806K.m10841a(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.f11807L == null || this.f11807L.m10837a())) {
            i = canvas.save();
            canvas.rotate(180.0f);
            if (this.f11828l) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.f11807L != null && this.f11807L.m10841a(canvas)) {
                i4 = 1;
            }
            i2 |= i4;
            canvas.restoreToCount(i);
        }
        if (i2 != 0 || this.f11822d == null || this.f11834r.size() <= 0 || !this.f11822d.mo2239b()) {
            i3 = i2;
        }
        if (i3 != 0) {
            ViewCompat.m10956d(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f11834r.size();
        for (int i = 0; i < size; i++) {
            ((ItemDecoration) this.f11834r.get(i)).mo2585a(canvas, this, this.f11823e);
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.f11832p.m17320a((LayoutParams) layoutParams);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.f11832p != null) {
            return this.f11832p.mo2301b();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.f11832p != null) {
            return this.f11832p.m17293a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (this.f11832p != null) {
            return this.f11832p.m17294a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    private void m17054F() {
        int c = this.f11821c.m17614c();
        for (int i = 0; i < c; i++) {
            ViewHolder b = m17080b(this.f11821c.m17615c(i));
            if (!b.m20404c()) {
                b.m20402b();
            }
        }
    }

    private void m17055G() {
        int c = this.f11821c.m17614c();
        for (int i = 0; i < c; i++) {
            ViewHolder b = m17080b(this.f11821c.m17615c(i));
            if (!b.m20404c()) {
                b.m20394a();
            }
        }
        this.f11819a.m17442h();
    }

    final void m17163d(int i, int i2) {
        int i3;
        int c = this.f11821c.m17614c();
        int i4;
        int i5;
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        for (int i6 = 0; i6 < c; i6++) {
            ViewHolder b = m17080b(this.f11821c.m17615c(i6));
            if (b != null && b.f14096b >= r3 && b.f14096b <= r2) {
                if (b.f14096b == i) {
                    b.m20397a(i2 - i, false);
                } else {
                    b.m20397a(i3, false);
                }
                this.f11823e.f11943j = true;
            }
        }
        this.f11819a.m17421a(i, i2);
        requestLayout();
    }

    final void m17166e(int i, int i2) {
        int c = this.f11821c.m17614c();
        for (int i3 = 0; i3 < c; i3++) {
            ViewHolder b = m17080b(this.f11821c.m17615c(i3));
            if (!(b == null || b.m20404c() || b.f14096b < i)) {
                b.m20397a(i2, false);
                this.f11823e.f11943j = true;
            }
        }
        this.f11819a.m17430b(i, i2);
        requestLayout();
    }

    final void m17144a(int i, int i2, boolean z) {
        int i3 = i + i2;
        int c = this.f11821c.m17614c();
        for (int i4 = 0; i4 < c; i4++) {
            ViewHolder b = m17080b(this.f11821c.m17615c(i4));
            if (!(b == null || b.m20404c())) {
                if (b.f14096b >= i3) {
                    b.m20397a(-i2, z);
                    this.f11823e.f11943j = true;
                } else if (b.f14096b >= i) {
                    b.m20396a(i - 1, -i2, z);
                    this.f11823e.f11943j = true;
                }
            }
        }
        this.f11819a.m17422a(i, i2, z);
        requestLayout();
    }

    final void m17143a(int i, int i2, Object obj) {
        int c = this.f11821c.m17614c();
        int i3 = i + i2;
        for (int i4 = 0; i4 < c; i4++) {
            View c2 = this.f11821c.m17615c(i4);
            ViewHolder b = m17080b(c2);
            if (b != null && !b.m20404c() && b.f14096b >= i && b.f14096b < i3) {
                b.m20403b(2);
                b.m20399a(obj);
                if (m17049A(this)) {
                    b.m20403b(64);
                }
                ((LayoutParams) c2.getLayoutParams()).f14112c = true;
            }
        }
        this.f11819a.m17435c(i, i2);
    }

    final void m17172g() {
        int b = this.f11821c.m17611b();
        for (int i = 0; i < b; i++) {
            ViewHolder b2 = m17080b(this.f11821c.m17613b(i));
            if (!(b2 == null || b2.m20404c())) {
                if (b2.m20418q() || b2.m20414m()) {
                    requestLayout();
                } else if (b2.m20415n()) {
                    if (b2.f14099e != this.f11831o.getItemViewType(b2.f14096b)) {
                        requestLayout();
                        return;
                    } else if (b2.m20416o() && m17049A(this)) {
                        requestLayout();
                    } else {
                        this.f11831o.m17225b(b2, b2.f14096b);
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public static void m17056H(RecyclerView recyclerView) {
        if (!recyclerView.f11802G) {
            recyclerView.f11802G = true;
            int c = recyclerView.f11821c.m17614c();
            for (int i = 0; i < c; i++) {
                ViewHolder b = m17080b(recyclerView.f11821c.m17615c(i));
                if (!(b == null || b.m20404c())) {
                    b.m20403b(512);
                }
            }
            recyclerView.f11819a.m17440f();
        }
    }

    private void m17057I() {
        int c = this.f11821c.m17614c();
        for (int i = 0; i < c; i++) {
            ViewHolder b = m17080b(this.f11821c.m17615c(i));
            if (!(b == null || b.m20404c())) {
                b.m20403b(6);
            }
        }
        m17053E();
        this.f11819a.m17441g();
    }

    public final void m17173h() {
        if (this.f11834r.size() != 0) {
            if (this.f11832p != null) {
                this.f11832p.mo2309a("Cannot invalidate item decorations during a scroll or layout");
            }
            m17053E();
            requestLayout();
        }
    }

    public final ViewHolder m17138a(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return m17080b(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    static ViewHolder m17080b(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f14110a;
    }

    @Deprecated
    public final int m17158c(View view) {
        return m17093d(view);
    }

    public static int m17093d(View view) {
        ViewHolder b = m17080b(view);
        return b != null ? b.m20406e() : -1;
    }

    public static int m17095e(View view) {
        ViewHolder b = m17080b(view);
        return b != null ? b.m20405d() : -1;
    }

    public final long m17168f(View view) {
        if (this.f11831o == null || !this.f11831o.en_()) {
            return -1;
        }
        ViewHolder b = m17080b(view);
        if (b != null) {
            return b.f14098d;
        }
        return -1;
    }

    public final ViewHolder m17159c(int i) {
        if (this.f11802G) {
            return null;
        }
        int c = this.f11821c.m17614c();
        for (int i2 = 0; i2 < c; i2++) {
            ViewHolder b = m17080b(this.f11821c.m17615c(i2));
            if (b != null && !b.m20418q() && m17087c(this, b) == i) {
                return b;
            }
        }
        return null;
    }

    final ViewHolder m17137a(int i, boolean z) {
        int c = this.f11821c.m17614c();
        for (int i2 = 0; i2 < c; i2++) {
            ViewHolder b = m17080b(this.f11821c.m17615c(i2));
            if (!(b == null || b.m20418q())) {
                if (z) {
                    if (b.f14096b == i) {
                        return b;
                    }
                } else if (b.m20405d() == i) {
                    return b;
                }
            }
        }
        return null;
    }

    public final View m17139a(float f, float f2) {
        for (int b = this.f11821c.m17611b() - 1; b >= 0; b--) {
            View b2 = this.f11821c.m17613b(b);
            float p = ViewCompat.m10972p(b2);
            float q = ViewCompat.m10973q(b2);
            if (f >= ((float) b2.getLeft()) + p && f <= p + ((float) b2.getRight()) && f2 >= ((float) b2.getTop()) + q && f2 <= ((float) b2.getBottom()) + q) {
                return b2;
            }
        }
        return null;
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void mo2193d(int i) {
        int b = this.f11821c.m17611b();
        for (int i2 = 0; i2 < b; i2++) {
            this.f11821c.m17613b(i2).offsetTopAndBottom(i);
        }
    }

    public final void m17165e(int i) {
        int b = this.f11821c.m17611b();
        for (int i2 = 0; i2 < b; i2++) {
            this.f11821c.m17613b(i2).offsetLeftAndRight(i);
        }
    }

    final Rect m17171g(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f14112c) {
            return layoutParams.f14111b;
        }
        Rect rect = layoutParams.f14111b;
        rect.set(0, 0, 0, 0);
        int size = this.f11834r.size();
        for (int i = 0; i < size; i++) {
            this.f11830n.set(0, 0, 0, 0);
            ((ItemDecoration) this.f11834r.get(i)).mo2586a(this.f11830n, view, this, this.f11823e);
            rect.left += this.f11830n.left;
            rect.top += this.f11830n.top;
            rect.right += this.f11830n.right;
            rect.bottom += this.f11830n.bottom;
        }
        layoutParams.f14112c = false;
        return rect;
    }

    final void m17170f(int i, int i2) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        if (this.ab != null) {
            this.ab.mo2220a(this, i, i2);
        }
        if (this.ac != null) {
            for (scrollY = this.ac.size() - 1; scrollY >= 0; scrollY--) {
                ((OnScrollListener) this.ac.get(scrollY)).mo2220a(this, i, i2);
            }
        }
    }

    private void m17099g(int i) {
        if (this.f11832p != null) {
            this.f11832p.m17359i(i);
        }
        if (this.ab != null) {
            this.ab.mo2219a(this, i);
        }
        if (this.ac != null) {
            for (int size = this.ac.size() - 1; size >= 0; size--) {
                ((OnScrollListener) this.ac.get(size)).mo2219a(this, i);
            }
        }
    }

    public final boolean m17174i() {
        return !this.f11839w || this.f11802G || this.f11820b.m17579d();
    }

    public static void m17106i(RecyclerView recyclerView, View view) {
        ViewHolder b = m17080b(view);
        if (!(recyclerView.f11831o == null || b == null)) {
            recyclerView.f11831o.mo2230d(b);
        }
        if (recyclerView.f11801F != null) {
            for (int size = recyclerView.f11801F.size() - 1; size >= 0; size--) {
                ((OnChildAttachStateChangeListener) recyclerView.f11801F.get(size)).a(view);
            }
        }
    }

    public static void m17110j(RecyclerView recyclerView, View view) {
        ViewHolder b = m17080b(view);
        if (!(recyclerView.f11831o == null || b == null)) {
            recyclerView.f11831o.mo2229c(b);
        }
        if (recyclerView.f11801F != null) {
            for (int size = recyclerView.f11801F.size() - 1; size >= 0; size--) {
                recyclerView.f11801F.get(size);
            }
        }
    }

    public View focusSearch(View view, int i) {
        View view2 = null;
        if (view2 != null) {
            return view2;
        }
        view2 = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (!(view2 != null || this.f11831o == null || this.f11832p == null || m17167e() || this.f11842z)) {
            m17151b();
            view2 = this.f11832p.mo2313c(i, this.f11819a, this.f11823e);
            m17150a(false);
        }
        return view2 == null ? super.focusSearch(view, i) : view2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m17087c(android.support.v7.widget.RecyclerView r8, android.support.v7.widget.RecyclerView.ViewHolder r9) {
        /*
        r0 = 524; // 0x20c float:7.34E-43 double:2.59E-321;
        r0 = r9.m20401a(r0);
        if (r0 != 0) goto L_0x000e;
    L_0x0008:
        r0 = r9.m20417p();
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        r0 = -1;
    L_0x000f:
        return r0;
    L_0x0010:
        r0 = r8.f11820b;
        r1 = r9.f14096b;
        r2 = r0.f11949a;
        r5 = r2.size();
        r2 = 0;
        r4 = r2;
        r3 = r1;
    L_0x001d:
        if (r4 >= r5) goto L_0x0044;
    L_0x001f:
        r2 = r0.f11949a;
        r2 = r2.get(r4);
        r2 = (android.support.v7.widget.AdapterHelper.UpdateOp) r2;
        r6 = r2.f18985a;
        switch(r6) {
            case 0: goto L_0x0030;
            case 1: goto L_0x0038;
            case 2: goto L_0x002c;
            case 3: goto L_0x004a;
            default: goto L_0x002c;
        };
    L_0x002c:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x001d;
    L_0x0030:
        r6 = r2.f18986b;
        if (r6 > r3) goto L_0x002c;
    L_0x0034:
        r2 = r2.f18988d;
        r3 = r3 + r2;
        goto L_0x002c;
    L_0x0038:
        r6 = r2.f18986b;
        if (r6 > r3) goto L_0x002c;
    L_0x003c:
        r6 = r2.f18986b;
        r7 = r2.f18988d;
        r6 = r6 + r7;
        if (r6 <= r3) goto L_0x0046;
    L_0x0043:
        r3 = -1;
    L_0x0044:
        r0 = r3;
        goto L_0x000f;
    L_0x0046:
        r2 = r2.f18988d;
        r3 = r3 - r2;
        goto L_0x002c;
    L_0x004a:
        r6 = r2.f18986b;
        if (r6 != r3) goto L_0x0051;
    L_0x004e:
        r3 = r2.f18988d;
        goto L_0x002c;
    L_0x0051:
        r6 = r2.f18986b;
        if (r6 >= r3) goto L_0x0057;
    L_0x0055:
        r3 = r3 + -1;
    L_0x0057:
        r2 = r2.f18988d;
        if (r2 > r3) goto L_0x002c;
    L_0x005b:
        r3 = r3 + 1;
        goto L_0x002c;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.c(android.support.v7.widget.RecyclerView, android.support.v7.widget.RecyclerView$ViewHolder):int");
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.ai.m17658a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.ai.f11969c;
    }

    public boolean startNestedScroll(int i) {
        return this.ai.m17662a(i);
    }

    public void stopNestedScroll() {
        this.ai.m17666c();
    }

    public boolean hasNestedScrollingParent() {
        return this.ai.m17665b();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.ai.m17663a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.ai.m17664a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.ai.m17661a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.ai.m17660a(f, f2);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ag == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return this.ag.a(i, i2);
    }
}
