package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcelable;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper$ViewDropHandler;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.List;

/* compiled from: not a valid double value */
public class LinearLayoutManager extends LayoutManager implements ItemTouchHelper$ViewDropHandler {
    private LayoutState f12191a;
    private boolean f12192b;
    public boolean f12193c;
    private boolean f12194d;
    private boolean f12195e;
    private boolean f12196f;
    public int f12197j;
    public OrientationHelper f12198k;
    public boolean f12199l;
    public int f12200m;
    public int f12201n;
    public SavedState f12202o;
    final AnchorInfo f12203p;

    /* compiled from: not a valid double value */
    public class AnchorInfo {
        public int f12204a;
        public int f12205b;
        public boolean f12206c;
        final /* synthetic */ LinearLayoutManager f12207d;

        AnchorInfo(LinearLayoutManager linearLayoutManager) {
            this.f12207d = linearLayoutManager;
        }

        public final void m17995b() {
            this.f12205b = this.f12206c ? this.f12207d.f12198k.mo2332d() : this.f12207d.f12198k.mo2330c();
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f12204a + ", mCoordinate=" + this.f12205b + ", mLayoutFromEnd=" + this.f12206c + '}';
        }

        public final void m17994a(View view) {
            int b = this.f12207d.f12198k.m18003b();
            if (b >= 0) {
                m17996b(view);
                return;
            }
            this.f12204a = LayoutManager.m17269c(view);
            int c;
            if (this.f12206c) {
                b = (this.f12207d.f12198k.mo2332d() - b) - this.f12207d.f12198k.mo2329b(view);
                this.f12205b = this.f12207d.f12198k.mo2332d() - b;
                if (b > 0) {
                    c = this.f12205b - this.f12207d.f12198k.mo2331c(view);
                    int c2 = this.f12207d.f12198k.mo2330c();
                    c -= c2 + Math.min(this.f12207d.f12198k.mo2327a(view) - c2, 0);
                    if (c < 0) {
                        this.f12205b = Math.min(b, -c) + this.f12205b;
                        return;
                    }
                    return;
                }
                return;
            }
            c = this.f12207d.f12198k.mo2327a(view);
            c2 = c - this.f12207d.f12198k.mo2330c();
            this.f12205b = c;
            if (c2 > 0) {
                b = (this.f12207d.f12198k.mo2332d() - Math.min(0, (this.f12207d.f12198k.mo2332d() - b) - this.f12207d.f12198k.mo2329b(view))) - (c + this.f12207d.f12198k.mo2331c(view));
                if (b < 0) {
                    this.f12205b -= Math.min(c2, -b);
                }
            }
        }

        public final void m17996b(View view) {
            if (this.f12206c) {
                this.f12205b = this.f12207d.f12198k.mo2329b(view) + this.f12207d.f12198k.m18003b();
            } else {
                this.f12205b = this.f12207d.f12198k.mo2327a(view);
            }
            this.f12204a = LayoutManager.m17269c(view);
        }
    }

    /* compiled from: not a valid double value */
    public class LayoutState {
        boolean f13918a = true;
        int f13919b;
        int f13920c;
        public int f13921d;
        public int f13922e;
        int f13923f;
        int f13924g;
        int f13925h = 0;
        boolean f13926i = false;
        int f13927j;
        public List<ViewHolder> f13928k = null;

        final boolean m20268a(State state) {
            return this.f13921d >= 0 && this.f13921d < state.m17554e();
        }

        final View m20266a(Recycler recycler) {
            if (this.f13928k != null) {
                return m20265b();
            }
            View c = recycler.m17434c(this.f13921d);
            this.f13921d += this.f13922e;
            return c;
        }

        private View m20265b() {
            int size = this.f13928k.size();
            int i = 0;
            while (i < size) {
                View view = ((ViewHolder) this.f13928k.get(i)).f14095a;
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams.m20424c() || this.f13921d != layoutParams.m20426e()) {
                    i++;
                } else {
                    m20264a(view);
                    return view;
                }
            }
            return null;
        }

        public final void m20267a() {
            m20264a(null);
        }

        private void m20264a(View view) {
            View view2;
            int size = this.f13928k.size();
            View view3 = null;
            int i = Integer.MAX_VALUE;
            int i2 = 0;
            while (i2 < size) {
                int e;
                View view4;
                view2 = ((ViewHolder) this.f13928k.get(i2)).f14095a;
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                if (!(view2 == view || layoutParams.m20424c())) {
                    e = (layoutParams.m20426e() - this.f13921d) * this.f13922e;
                    if (e >= 0 && e < i) {
                        if (e == 0) {
                            break;
                        }
                        view4 = view2;
                        i2++;
                        view3 = view4;
                        i = e;
                    }
                }
                e = i;
                view4 = view3;
                i2++;
                view3 = view4;
                i = e;
            }
            view2 = view3;
            View view5 = view2;
            if (view5 == null) {
                this.f13921d = -1;
            } else {
                this.f13921d = ((LayoutParams) view5.getLayoutParams()).m20426e();
            }
        }
    }

    /* compiled from: not a valid double value */
    public class LayoutChunkResult {
        public int f14089a;
        public boolean f14090b;
        public boolean f14091c;
        public boolean f14092d;

        protected LayoutChunkResult() {
        }
    }

    public LinearLayoutManager(Context context) {
        this(1, false);
    }

    public LinearLayoutManager(int i, boolean z) {
        this.f12193c = false;
        this.f12199l = false;
        this.f12194d = false;
        this.f12195e = true;
        this.f12200m = -1;
        this.f12201n = Integer.MIN_VALUE;
        this.f12202o = null;
        this.f12203p = new AnchorInfo(this);
        mo2302b(i);
        mo2309a(null);
        if (z != this.f12193c) {
            this.f12193c = z;
            m17362p();
        }
    }

    public LayoutParams mo2301b() {
        return new LayoutParams(-2, -2);
    }

    public void mo2295a(RecyclerView recyclerView, Recycler recycler) {
        super.mo2295a(recyclerView, recycler);
        if (this.f12196f) {
            m17340c(recycler);
            recycler.m17419a();
        }
    }

    public final void mo2308a(AccessibilityEvent accessibilityEvent) {
        super.mo2308a(accessibilityEvent);
        if (m17367v() > 0) {
            AccessibilityRecordCompat a = AccessibilityEventCompat.a(accessibilityEvent);
            a.b(m17989l());
            a.c(m17991n());
        }
    }

    public final Parcelable mo2322f() {
        if (this.f12202o != null) {
            return new SavedState(this.f12202o);
        }
        Parcelable savedState = new SavedState();
        if (m17367v() > 0) {
            m17988k();
            boolean z = this.f12192b ^ this.f12199l;
            savedState.c = z;
            View J;
            if (z) {
                J = m17927J();
                savedState.b = this.f12198k.mo2332d() - this.f12198k.mo2329b(J);
                savedState.a = LayoutManager.m17269c(J);
                return savedState;
            }
            J = mo2297I();
            savedState.a = LayoutManager.m17269c(J);
            savedState.b = this.f12198k.mo2327a(J) - this.f12198k.mo2330c();
            return savedState;
        }
        savedState.b();
        return savedState;
    }

    public final void mo2306a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f12202o = (SavedState) parcelable;
            m17362p();
        }
    }

    public final boolean mo2324g() {
        return this.f12197j == 0;
    }

    public boolean mo2325h() {
        return this.f12197j == 1;
    }

    public void m17966a(boolean z) {
        mo2309a(null);
        if (this.f12194d != z) {
            this.f12194d = z;
            m17362p();
        }
    }

    public final int mo2326i() {
        return this.f12197j;
    }

    public void mo2302b(int i) {
        if (i == 0 || i == 1) {
            mo2309a(null);
            if (i != this.f12197j) {
                this.f12197j = i;
                this.f12198k = null;
                m17362p();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    private void m17943c() {
        boolean z = true;
        if (this.f12197j == 1 || !m17987j()) {
            z = this.f12193c;
        } else if (this.f12193c) {
            z = false;
        }
        this.f12199l = z;
    }

    public final View mo2312c(int i) {
        int v = m17367v();
        if (v == 0) {
            return null;
        }
        int c = i - LayoutManager.m17269c(m17351f(0));
        if (c >= 0 && c < v) {
            View f = m17351f(c);
            if (LayoutManager.m17269c(f) == i) {
                return f;
            }
        }
        return super.mo2312c(i);
    }

    protected int m17956a(State state) {
        if (state.m17553d()) {
            return this.f12198k.mo2335f();
        }
        return 0;
    }

    public void mo2298a(RecyclerView recyclerView, State state, int i) {
        SmoothScroller 1 = new 1(this, recyclerView.getContext());
        1.a = i;
        m17304a(1);
    }

    public final PointF mo2316d(int i) {
        int i2 = 1;
        boolean z = false;
        if (m17367v() == 0) {
            return null;
        }
        if (i < LayoutManager.m17269c(m17351f(0))) {
            z = true;
        }
        if (z != this.f12199l) {
            i2 = -1;
        }
        if (this.f12197j == 0) {
            return new PointF((float) i2, 0.0f);
        }
        return new PointF(0.0f, (float) i2);
    }

    public void mo2314c(Recycler recycler, State state) {
        if (!(this.f12202o == null && this.f12200m == -1) && state.m17554e() == 0) {
            m17340c(recycler);
            return;
        }
        int i;
        int d;
        if (this.f12202o != null && this.f12202o.a()) {
            this.f12200m = this.f12202o.a;
        }
        m17988k();
        this.f12191a.f13918a = false;
        m17943c();
        AnchorInfo anchorInfo = this.f12203p;
        anchorInfo.f12204a = -1;
        anchorInfo.f12205b = Integer.MIN_VALUE;
        anchorInfo.f12206c = false;
        this.f12203p.f12206c = this.f12199l ^ this.f12194d;
        m17942b(recycler, state, this.f12203p);
        int a = m17956a(state);
        if (this.f12191a.f13927j >= 0) {
            i = a;
            a = 0;
        } else {
            i = 0;
        }
        a += this.f12198k.mo2330c();
        i += this.f12198k.mo2336g();
        if (!(!state.f11944k || this.f12200m == -1 || this.f12201n == Integer.MIN_VALUE)) {
            View c = mo2312c(this.f12200m);
            if (c != null) {
                if (this.f12199l) {
                    d = (this.f12198k.mo2332d() - this.f12198k.mo2329b(c)) - this.f12201n;
                } else {
                    d = this.f12201n - (this.f12198k.mo2327a(c) - this.f12198k.mo2330c());
                }
                if (d > 0) {
                    a += d;
                } else {
                    i -= d;
                }
            }
        }
        m17959a(recycler, state, this.f12203p);
        mo2294a(recycler);
        this.f12191a.f13926i = state.f11944k;
        int i2;
        if (this.f12203p.f12206c) {
            m17939b(this.f12203p);
            this.f12191a.f13925h = a;
            m17929a(recycler, this.f12191a, state, false);
            a = this.f12191a.f13919b;
            d = this.f12191a.f13921d;
            if (this.f12191a.f13920c > 0) {
                i += this.f12191a.f13920c;
            }
            m17933a(this.f12203p);
            this.f12191a.f13925h = i;
            LayoutState layoutState = this.f12191a;
            layoutState.f13921d += this.f12191a.f13922e;
            m17929a(recycler, this.f12191a, state, false);
            i = this.f12191a.f13919b;
            if (this.f12191a.f13920c > 0) {
                i2 = this.f12191a.f13920c;
                m17951g(d, a);
                this.f12191a.f13925h = i2;
                m17929a(recycler, this.f12191a, state, false);
                a = this.f12191a.f13919b;
            }
            int i3 = i;
            i = a;
            a = i3;
        } else {
            m17933a(this.f12203p);
            this.f12191a.f13925h = i;
            m17929a(recycler, this.f12191a, state, false);
            i = this.f12191a.f13919b;
            i2 = this.f12191a.f13921d;
            if (this.f12191a.f13920c > 0) {
                a += this.f12191a.f13920c;
            }
            m17939b(this.f12203p);
            this.f12191a.f13925h = a;
            LayoutState layoutState2 = this.f12191a;
            layoutState2.f13921d += this.f12191a.f13922e;
            m17929a(recycler, this.f12191a, state, false);
            d = this.f12191a.f13919b;
            if (this.f12191a.f13920c > 0) {
                a = this.f12191a.f13920c;
                m17949f(i2, i);
                this.f12191a.f13925h = a;
                m17929a(recycler, this.f12191a, state, false);
                a = this.f12191a.f13919b;
                i = d;
            } else {
                a = i;
                i = d;
            }
        }
        if (m17367v() > 0) {
            int b;
            if ((this.f12199l ^ this.f12194d) != 0) {
                d = m17928a(a, recycler, state, true);
                i += d;
                a += d;
                b = m17937b(i, recycler, state, false);
                i += b;
                a += b;
            } else {
                d = m17937b(i, recycler, state, true);
                i += d;
                a += d;
                b = m17928a(a, recycler, state, false);
                i += b;
                a += b;
            }
        }
        m17941b(recycler, state, i, a);
        if (!state.f11944k) {
            this.f12200m = -1;
            this.f12201n = Integer.MIN_VALUE;
            OrientationHelper orientationHelper = this.f12198k;
            orientationHelper.f12212b = orientationHelper.mo2335f();
        }
        this.f12192b = this.f12194d;
        this.f12202o = null;
    }

    void m17959a(Recycler recycler, State state, AnchorInfo anchorInfo) {
    }

    private void m17942b(Recycler recycler, State state, AnchorInfo anchorInfo) {
        boolean z = false;
        boolean z2 = true;
        if (state.f11944k || this.f12200m == -1) {
            z2 = false;
        } else if (this.f12200m < 0 || this.f12200m >= state.m17554e()) {
            this.f12200m = -1;
            this.f12201n = Integer.MIN_VALUE;
            z2 = false;
        } else {
            anchorInfo.f12204a = this.f12200m;
            if (this.f12202o != null && this.f12202o.a()) {
                anchorInfo.f12206c = this.f12202o.c;
                if (anchorInfo.f12206c) {
                    anchorInfo.f12205b = this.f12198k.mo2332d() - this.f12202o.b;
                } else {
                    anchorInfo.f12205b = this.f12198k.mo2330c() + this.f12202o.b;
                }
            } else if (this.f12201n == Integer.MIN_VALUE) {
                View c = mo2312c(this.f12200m);
                if (c == null) {
                    if (m17367v() > 0) {
                        boolean z3;
                        if (this.f12200m < LayoutManager.m17269c(m17351f(0))) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3 == this.f12199l) {
                            z = true;
                        }
                        anchorInfo.f12206c = z;
                    }
                    anchorInfo.m17995b();
                } else if (this.f12198k.mo2331c(c) > this.f12198k.mo2335f()) {
                    anchorInfo.m17995b();
                } else if (this.f12198k.mo2327a(c) - this.f12198k.mo2330c() < 0) {
                    anchorInfo.f12205b = this.f12198k.mo2330c();
                    anchorInfo.f12206c = false;
                } else if (this.f12198k.mo2332d() - this.f12198k.mo2329b(c) < 0) {
                    anchorInfo.f12205b = this.f12198k.mo2332d();
                    anchorInfo.f12206c = true;
                } else {
                    anchorInfo.f12205b = anchorInfo.f12206c ? this.f12198k.mo2329b(c) + this.f12198k.m18003b() : this.f12198k.mo2327a(c);
                }
            } else {
                anchorInfo.f12206c = this.f12199l;
                if (this.f12199l) {
                    anchorInfo.f12205b = this.f12198k.mo2332d() - this.f12201n;
                } else {
                    anchorInfo.f12205b = this.f12198k.mo2330c() + this.f12201n;
                }
            }
        }
        if (!z2 && !m17944c(recycler, state, anchorInfo)) {
            anchorInfo.m17995b();
            anchorInfo.f12204a = this.f12194d ? state.m17554e() - 1 : 0;
        }
    }

    private boolean m17944c(Recycler recycler, State state, AnchorInfo anchorInfo) {
        boolean z = false;
        if (m17367v() == 0) {
            return false;
        }
        View C = m17287C();
        if (C != null) {
            Object obj;
            LayoutParams layoutParams = (LayoutParams) C.getLayoutParams();
            if (layoutParams.m20424c() || layoutParams.m20426e() < 0 || layoutParams.m20426e() >= state.m17554e()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                anchorInfo.m17994a(C);
                return true;
            }
        }
        if (this.f12192b != this.f12194d) {
            return false;
        }
        C = anchorInfo.f12206c ? m17946d(recycler, state) : m17947e(recycler, state);
        if (C == null) {
            return false;
        }
        anchorInfo.m17996b(C);
        if (!state.f11944k && mo2320e()) {
            if (this.f12198k.mo2327a(C) >= this.f12198k.mo2332d() || this.f12198k.mo2329b(C) < this.f12198k.mo2330c()) {
                z = true;
            }
            if (z) {
                anchorInfo.f12205b = anchorInfo.f12206c ? this.f12198k.mo2332d() : this.f12198k.mo2330c();
            }
        }
        return true;
    }

    private int m17928a(int i, Recycler recycler, State state, boolean z) {
        int d = this.f12198k.mo2332d() - i;
        if (d <= 0) {
            return 0;
        }
        d = -m17945d(-d, recycler, state);
        int i2 = i + d;
        if (!z) {
            return d;
        }
        i2 = this.f12198k.mo2332d() - i2;
        if (i2 <= 0) {
            return d;
        }
        this.f12198k.mo2328a(i2);
        return d + i2;
    }

    private int m17937b(int i, Recycler recycler, State state, boolean z) {
        int c = i - this.f12198k.mo2330c();
        if (c <= 0) {
            return 0;
        }
        c = -m17945d(c, recycler, state);
        int i2 = i + c;
        if (!z) {
            return c;
        }
        i2 -= this.f12198k.mo2330c();
        if (i2 <= 0) {
            return c;
        }
        this.f12198k.mo2328a(-i2);
        return c - i2;
    }

    private void m17933a(AnchorInfo anchorInfo) {
        m17949f(anchorInfo.f12204a, anchorInfo.f12205b);
    }

    private void m17949f(int i, int i2) {
        this.f12191a.f13920c = this.f12198k.mo2332d() - i2;
        this.f12191a.f13922e = this.f12199l ? -1 : 1;
        this.f12191a.f13921d = i;
        this.f12191a.f13923f = 1;
        this.f12191a.f13919b = i2;
        this.f12191a.f13924g = Integer.MIN_VALUE;
    }

    private void m17939b(AnchorInfo anchorInfo) {
        m17951g(anchorInfo.f12204a, anchorInfo.f12205b);
    }

    private void m17951g(int i, int i2) {
        this.f12191a.f13920c = i2 - this.f12198k.mo2330c();
        this.f12191a.f13921d = i;
        this.f12191a.f13922e = this.f12199l ? 1 : -1;
        this.f12191a.f13923f = -1;
        this.f12191a.f13919b = i2;
        this.f12191a.f13924g = Integer.MIN_VALUE;
    }

    protected final boolean m17987j() {
        return m17366t() == 1;
    }

    final void m17988k() {
        if (this.f12191a == null) {
            this.f12191a = new LayoutState();
        }
        if (this.f12198k == null) {
            this.f12198k = OrientationHelper.m18000a(this, this.f12197j);
        }
    }

    public void mo2319e(int i) {
        this.f12200m = i;
        this.f12201n = Integer.MIN_VALUE;
        if (this.f12202o != null) {
            this.f12202o.b();
        }
        m17362p();
    }

    public final void mo2317d(int i, int i2) {
        this.f12200m = i;
        this.f12201n = i2;
        if (this.f12202o != null) {
            this.f12202o.b();
        }
        m17362p();
    }

    public final int mo2305a(int i, Recycler recycler, State state) {
        if (this.f12197j == 1) {
            return 0;
        }
        return m17945d(i, recycler, state);
    }

    public int mo2300b(int i, Recycler recycler, State state) {
        if (this.f12197j == 0) {
            return 0;
        }
        return m17945d(i, recycler, state);
    }

    public final int mo2310b(State state) {
        return m17952h(state);
    }

    public int mo2311c(State state) {
        return m17952h(state);
    }

    public final int mo2315d(State state) {
        return m17953i(state);
    }

    public int mo2318e(State state) {
        return m17953i(state);
    }

    public final int mo2321f(State state) {
        return m17954j(state);
    }

    public int mo2323g(State state) {
        return m17954j(state);
    }

    private int m17952h(State state) {
        boolean z = false;
        if (m17367v() == 0) {
            return 0;
        }
        m17988k();
        OrientationHelper orientationHelper = this.f12198k;
        View a = m17931a(!this.f12195e, true);
        if (!this.f12195e) {
            z = true;
        }
        return ScrollbarHelper.a(state, orientationHelper, a, m17938b(z, true), this, this.f12195e, this.f12199l);
    }

    private int m17953i(State state) {
        boolean z = false;
        if (m17367v() == 0) {
            return 0;
        }
        m17988k();
        OrientationHelper orientationHelper = this.f12198k;
        View a = m17931a(!this.f12195e, true);
        if (!this.f12195e) {
            z = true;
        }
        return ScrollbarHelper.a(state, orientationHelper, a, m17938b(z, true), this, this.f12195e);
    }

    private int m17954j(State state) {
        boolean z = false;
        if (m17367v() == 0) {
            return 0;
        }
        m17988k();
        OrientationHelper orientationHelper = this.f12198k;
        View a = m17931a(!this.f12195e, true);
        if (!this.f12195e) {
            z = true;
        }
        return ScrollbarHelper.b(state, orientationHelper, a, m17938b(z, true), this, this.f12195e);
    }

    private void m17932a(int i, int i2, boolean z, State state) {
        int i3 = -1;
        int i4 = 1;
        this.f12191a.f13925h = m17956a(state);
        this.f12191a.f13923f = i;
        View J;
        LayoutState layoutState;
        if (i == 1) {
            LayoutState layoutState2 = this.f12191a;
            layoutState2.f13925h += this.f12198k.mo2336g();
            J = m17927J();
            layoutState = this.f12191a;
            if (!this.f12199l) {
                i3 = 1;
            }
            layoutState.f13922e = i3;
            this.f12191a.f13921d = LayoutManager.m17269c(J) + this.f12191a.f13922e;
            this.f12191a.f13919b = this.f12198k.mo2329b(J);
            i3 = this.f12198k.mo2329b(J) - this.f12198k.mo2332d();
        } else {
            J = mo2297I();
            layoutState = this.f12191a;
            layoutState.f13925h += this.f12198k.mo2330c();
            layoutState = this.f12191a;
            if (!this.f12199l) {
                i4 = -1;
            }
            layoutState.f13922e = i4;
            this.f12191a.f13921d = LayoutManager.m17269c(J) + this.f12191a.f13922e;
            this.f12191a.f13919b = this.f12198k.mo2327a(J);
            i3 = (-this.f12198k.mo2327a(J)) + this.f12198k.mo2330c();
        }
        this.f12191a.f13920c = i2;
        if (z) {
            LayoutState layoutState3 = this.f12191a;
            layoutState3.f13920c -= i3;
        }
        this.f12191a.f13924g = i3;
    }

    private int m17945d(int i, Recycler recycler, State state) {
        if (m17367v() == 0 || i == 0) {
            return 0;
        }
        this.f12191a.f13918a = true;
        m17988k();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        m17932a(i2, abs, true, state);
        int a = this.f12191a.f13924g + m17929a(recycler, this.f12191a, state, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.f12198k.mo2328a(-i);
        this.f12191a.f13927j = i;
        return i;
    }

    public final void mo2309a(String str) {
        if (this.f12202o == null) {
            super.mo2309a(str);
        }
    }

    private void m17935a(Recycler recycler, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    mo2292a(i3, recycler);
                }
                return;
            }
            while (i > i2) {
                mo2292a(i, recycler);
                i--;
            }
        }
    }

    private void m17934a(Recycler recycler, int i) {
        if (i >= 0) {
            int v = m17367v();
            int i2;
            if (this.f12199l) {
                for (i2 = v - 1; i2 >= 0; i2--) {
                    if (this.f12198k.mo2329b(m17351f(i2)) > i) {
                        m17935a(recycler, v - 1, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = 0; i2 < v; i2++) {
                if (this.f12198k.mo2329b(m17351f(i2)) > i) {
                    m17935a(recycler, 0, i2);
                    return;
                }
            }
        }
    }

    private void m17940b(Recycler recycler, int i) {
        int v = m17367v();
        if (i >= 0) {
            int e = this.f12198k.mo2334e() - i;
            int i2;
            if (this.f12199l) {
                for (i2 = 0; i2 < v; i2++) {
                    if (this.f12198k.mo2327a(m17351f(i2)) < e) {
                        m17935a(recycler, 0, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = v - 1; i2 >= 0; i2--) {
                if (this.f12198k.mo2327a(m17351f(i2)) < e) {
                    m17935a(recycler, v - 1, i2);
                    return;
                }
            }
        }
    }

    private void m17936a(Recycler recycler, LayoutState layoutState) {
        if (!layoutState.f13918a) {
            return;
        }
        if (layoutState.f13923f == -1) {
            m17940b(recycler, layoutState.f13924g);
        } else {
            m17934a(recycler, layoutState.f13924g);
        }
    }

    private int m17929a(Recycler recycler, LayoutState layoutState, State state, boolean z) {
        int i = layoutState.f13920c;
        if (layoutState.f13924g != Integer.MIN_VALUE) {
            if (layoutState.f13920c < 0) {
                layoutState.f13924g += layoutState.f13920c;
            }
            m17936a(recycler, layoutState);
        }
        int i2 = layoutState.f13920c + layoutState.f13925h;
        LayoutChunkResult layoutChunkResult = new LayoutChunkResult();
        while (i2 > 0 && layoutState.m20268a(state)) {
            layoutChunkResult.f14089a = 0;
            layoutChunkResult.f14090b = false;
            layoutChunkResult.f14091c = false;
            layoutChunkResult.f14092d = false;
            m17960a(recycler, state, layoutState, layoutChunkResult);
            if (!layoutChunkResult.f14090b) {
                layoutState.f13919b += layoutChunkResult.f14089a * layoutState.f13923f;
                if (!(layoutChunkResult.f14091c && this.f12191a.f13928k == null && state.f11944k)) {
                    layoutState.f13920c -= layoutChunkResult.f14089a;
                    i2 -= layoutChunkResult.f14089a;
                }
                if (layoutState.f13924g != Integer.MIN_VALUE) {
                    layoutState.f13924g += layoutChunkResult.f14089a;
                    if (layoutState.f13920c < 0) {
                        layoutState.f13924g += layoutState.f13920c;
                    }
                    m17936a(recycler, layoutState);
                }
                if (z && layoutChunkResult.f14092d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - layoutState.f13920c;
    }

    void m17960a(Recycler recycler, State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        View a = layoutState.m20266a(recycler);
        if (a == null) {
            layoutChunkResult.f14090b = true;
            return;
        }
        int w;
        int d;
        int i;
        int i2;
        LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
        if (layoutState.f13928k == null) {
            if (this.f12199l == (layoutState.f13923f == -1)) {
                m17332b(a);
            } else {
                mo2303b(a, 0);
            }
        } else {
            boolean z;
            boolean z2 = this.f12199l;
            if (layoutState.f13923f == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z2 == z) {
                m17309a(a);
            } else {
                m17310a(a, 0);
            }
        }
        mo2304b(a, 0, 0);
        layoutChunkResult.f14089a = this.f12198k.mo2331c(a);
        if (this.f12197j == 1) {
            if (m17987j()) {
                w = m17368w() - m17285A();
                d = w - this.f12198k.mo2333d(a);
            } else {
                d = m17370y();
                w = this.f12198k.mo2333d(a) + d;
            }
            if (layoutState.f13923f == -1) {
                i = layoutState.f13919b;
                i2 = w;
                w = d;
                d = layoutState.f13919b - layoutChunkResult.f14089a;
            } else {
                i = layoutState.f13919b + layoutChunkResult.f14089a;
                i2 = w;
                w = d;
                d = layoutState.f13919b;
            }
        } else {
            d = m17371z();
            w = this.f12198k.mo2333d(a) + d;
            if (layoutState.f13923f == -1) {
                i2 = layoutState.f13919b;
                i = w;
                w = layoutState.f13919b - layoutChunkResult.f14089a;
            } else {
                i2 = layoutState.f13919b + layoutChunkResult.f14089a;
                i = w;
                w = layoutState.f13919b;
            }
        }
        mo2299a(a, w + layoutParams.leftMargin, layoutParams.topMargin + d, i2 - layoutParams.rightMargin, i - layoutParams.bottomMargin);
        if (layoutParams.m20424c() || layoutParams.m20425d()) {
            layoutChunkResult.f14091c = true;
        }
        layoutChunkResult.f14092d = a.isFocusable();
    }

    private View mo2297I() {
        return m17351f(this.f12199l ? m17367v() - 1 : 0);
    }

    private View m17927J() {
        return m17351f(this.f12199l ? 0 : m17367v() - 1);
    }

    private View m17931a(boolean z, boolean z2) {
        if (this.f12199l) {
            return m17930a(m17367v() - 1, -1, z, z2);
        }
        return m17930a(0, m17367v(), z, z2);
    }

    private View m17938b(boolean z, boolean z2) {
        if (this.f12199l) {
            return m17930a(0, m17367v(), z, z2);
        }
        return m17930a(m17367v() - 1, -1, z, z2);
    }

    private View m17946d(Recycler recycler, State state) {
        return this.f12199l ? m17948f(recycler, state) : m17950g(recycler, state);
    }

    private View m17947e(Recycler recycler, State state) {
        return this.f12199l ? m17950g(recycler, state) : m17948f(recycler, state);
    }

    private View m17948f(Recycler recycler, State state) {
        return m17957a(recycler, state, 0, m17367v(), state.m17554e());
    }

    private View m17950g(Recycler recycler, State state) {
        return m17957a(recycler, state, m17367v() - 1, -1, state.m17554e());
    }

    View m17957a(Recycler recycler, State state, int i, int i2, int i3) {
        View view = null;
        m17988k();
        int c = this.f12198k.mo2330c();
        int d = this.f12198k.mo2332d();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View f = m17351f(i);
            int c2 = LayoutManager.m17269c(f);
            if (c2 >= 0 && c2 < i3) {
                if (((LayoutParams) f.getLayoutParams()).m20424c()) {
                    if (view2 == null) {
                        view3 = view;
                        i += i4;
                        view = view3;
                        view2 = f;
                    }
                } else if (this.f12198k.mo2327a(f) < d && this.f12198k.mo2329b(f) >= c) {
                    return f;
                } else {
                    if (view == null) {
                        view3 = f;
                        f = view2;
                        i += i4;
                        view = view3;
                        view2 = f;
                    }
                }
            }
            view3 = view;
            f = view2;
            i += i4;
            view = view3;
            view2 = f;
        }
        return view != null ? view : view2;
    }

    public final int m17989l() {
        View a = m17930a(0, m17367v(), false, true);
        return a == null ? -1 : LayoutManager.m17269c(a);
    }

    public final int m17990m() {
        View a = m17930a(0, m17367v(), true, false);
        return a == null ? -1 : LayoutManager.m17269c(a);
    }

    public final int m17991n() {
        View a = m17930a(m17367v() - 1, -1, false, true);
        if (a == null) {
            return -1;
        }
        return LayoutManager.m17269c(a);
    }

    public final int m17992o() {
        View a = m17930a(m17367v() - 1, -1, true, false);
        if (a == null) {
            return -1;
        }
        return LayoutManager.m17269c(a);
    }

    private View m17930a(int i, int i2, boolean z, boolean z2) {
        m17988k();
        int c = this.f12198k.mo2330c();
        int d = this.f12198k.mo2332d();
        int i3 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View f = m17351f(i);
            int a = this.f12198k.mo2327a(f);
            int b = this.f12198k.mo2329b(f);
            if (a < d && b > c) {
                if (!z) {
                    return f;
                }
                if (a >= c && b <= d) {
                    return f;
                }
                if (z2 && view == null) {
                    i += i3;
                    view = f;
                }
            }
            f = view;
            i += i3;
            view = f;
        }
        return view;
    }

    public final View mo2313c(int i, Recycler recycler, State state) {
        m17943c();
        if (m17367v() == 0) {
            return null;
        }
        int i2 = -1;
        switch (i) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                i2 = 1;
                break;
            case 17:
                if (this.f12197j != 0) {
                    i2 = Integer.MIN_VALUE;
                    break;
                }
                break;
            case 33:
                if (this.f12197j != 1) {
                    i2 = Integer.MIN_VALUE;
                    break;
                }
                break;
            case 66:
                if (this.f12197j != 0) {
                    i2 = Integer.MIN_VALUE;
                    break;
                }
                i2 = 1;
                break;
            case 130:
                if (this.f12197j != 1) {
                    i2 = Integer.MIN_VALUE;
                    break;
                }
                i2 = 1;
                break;
            default:
                i2 = Integer.MIN_VALUE;
                break;
        }
        int i3 = i2;
        if (i3 == Integer.MIN_VALUE) {
            return null;
        }
        View e;
        m17988k();
        if (i3 == -1) {
            e = m17947e(recycler, state);
        } else {
            e = m17946d(recycler, state);
        }
        if (e == null) {
            return null;
        }
        View I;
        m17988k();
        m17932a(i3, (int) (0.33f * ((float) this.f12198k.mo2335f())), false, state);
        this.f12191a.f13924g = Integer.MIN_VALUE;
        this.f12191a.f13918a = false;
        m17929a(recycler, this.f12191a, state, true);
        if (i3 == -1) {
            I = mo2297I();
        } else {
            I = m17927J();
        }
        if (I == e || !I.isFocusable()) {
            return null;
        }
        return I;
    }

    public boolean mo2320e() {
        return this.f12202o == null && this.f12192b == this.f12194d;
    }

    public final void mo2307a(View view, View view2) {
        mo2309a("Cannot drop a view during a scroll or layout calculation");
        m17988k();
        m17943c();
        int c = LayoutManager.m17269c(view);
        int c2 = LayoutManager.m17269c(view2);
        if (c < c2) {
            Object obj = 1;
        } else {
            c = -1;
        }
        if (this.f12199l) {
            if (obj == 1) {
                mo2317d(c2, this.f12198k.mo2332d() - (this.f12198k.mo2327a(view2) + this.f12198k.mo2331c(view)));
            } else {
                mo2317d(c2, this.f12198k.mo2332d() - this.f12198k.mo2329b(view2));
            }
        } else if (obj == -1) {
            mo2317d(c2, this.f12198k.mo2327a(view2));
        } else {
            mo2317d(c2, this.f12198k.mo2329b(view2) - this.f12198k.mo2331c(view));
        }
    }

    private void m17941b(Recycler recycler, State state, int i, int i2) {
        if (state.f11946m && m17367v() != 0 && !state.f11944k && mo2320e()) {
            int i3 = 0;
            int i4 = 0;
            List list = recycler.f11902e;
            int size = list.size();
            int c = LayoutManager.m17269c(m17351f(0));
            int i5 = 0;
            while (i5 < size) {
                int i6;
                int i7;
                ViewHolder viewHolder = (ViewHolder) list.get(i5);
                if (viewHolder.m20418q()) {
                    i6 = i4;
                    i7 = i3;
                } else {
                    if (((viewHolder.m20405d() < c) != this.f12199l ? -1 : 1) == -1) {
                        i7 = this.f12198k.mo2331c(viewHolder.f14095a) + i3;
                        i6 = i4;
                    } else {
                        i6 = this.f12198k.mo2331c(viewHolder.f14095a) + i4;
                        i7 = i3;
                    }
                }
                i5++;
                i3 = i7;
                i4 = i6;
            }
            this.f12191a.f13928k = list;
            if (i3 > 0) {
                m17951g(LayoutManager.m17269c(mo2297I()), i);
                this.f12191a.f13925h = i3;
                this.f12191a.f13920c = 0;
                this.f12191a.m20267a();
                m17929a(recycler, this.f12191a, state, false);
            }
            if (i4 > 0) {
                m17949f(LayoutManager.m17269c(m17927J()), i2);
                this.f12191a.f13925h = i4;
                this.f12191a.f13920c = 0;
                this.f12191a.m20267a();
                m17929a(recycler, this.f12191a, state, false);
            }
            this.f12191a.f13928k = null;
        }
    }
}
