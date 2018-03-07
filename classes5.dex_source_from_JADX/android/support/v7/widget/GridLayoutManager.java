package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.support.v7.widget.LinearLayoutManager.AnchorInfo;
import android.support.v7.widget.LinearLayoutManager.LayoutChunkResult;
import android.support.v7.widget.LinearLayoutManager.LayoutState;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

/* compiled from: trying check  */
public class GridLayoutManager extends LinearLayoutManager {
    static final int f1372a = MeasureSpec.makeMeasureSpec(0, 0);
    boolean f1373b = false;
    public int f1374c = -1;
    int[] f1375d;
    View[] f1376e;
    final SparseIntArray f1377f = new SparseIntArray();
    final SparseIntArray f1378g = new SparseIntArray();
    public SpanSizeLookup f1379h = new DefaultSpanSizeLookup();
    final Rect f1380i = new Rect();

    /* compiled from: trying check  */
    public abstract class SpanSizeLookup {
        final SparseIntArray f1368a = new SparseIntArray();
        public boolean f1369b = false;

        public abstract int mo447a(int i);

        public final void m1883a(boolean z) {
            this.f1369b = z;
        }

        public final void m1882a() {
            this.f1368a.clear();
        }

        final int m1884b(int i, int i2) {
            if (!this.f1369b) {
                return mo448a(i, i2);
            }
            int i3 = this.f1368a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            i3 = mo448a(i, i2);
            this.f1368a.put(i, i3);
            return i3;
        }

        public int mo448a(int i, int i2) {
            int a = mo447a(i);
            if (a == i2) {
                return 0;
            }
            int b;
            int a2;
            int i3;
            if (this.f1369b && this.f1368a.size() > 0) {
                b = m1879b(i);
                if (b >= 0) {
                    a2 = this.f1368a.get(b) + mo447a(b);
                    b++;
                    i3 = b;
                    while (i3 < i) {
                        b = mo447a(i3);
                        a2 += b;
                        if (a2 == i2) {
                            b = 0;
                        } else if (a2 <= i2) {
                            b = a2;
                        }
                        i3++;
                        a2 = b;
                    }
                    if (a2 + a > i2) {
                        return a2;
                    }
                    return 0;
                }
            }
            b = 0;
            a2 = 0;
            i3 = b;
            while (i3 < i) {
                b = mo447a(i3);
                a2 += b;
                if (a2 == i2) {
                    b = 0;
                } else if (a2 <= i2) {
                    b = a2;
                }
                i3++;
                a2 = b;
            }
            if (a2 + a > i2) {
                return 0;
            }
            return a2;
        }

        private int m1879b(int i) {
            int i2 = 0;
            int size = this.f1368a.size() - 1;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.f1368a.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            size = i2 - 1;
            if (size < 0 || size >= this.f1368a.size()) {
                return -1;
            }
            return this.f1368a.keyAt(size);
        }

        public final int m1885c(int i, int i2) {
            int a = mo447a(i);
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i) {
                int a2 = mo447a(i3);
                i5 += a2;
                if (i5 == i2) {
                    i4++;
                    a2 = 0;
                } else if (i5 > i2) {
                    i4++;
                } else {
                    a2 = i5;
                }
                i3++;
                i5 = a2;
            }
            if (i5 + a > i2) {
                return i4 + 1;
            }
            return i4;
        }
    }

    /* compiled from: trying check  */
    public final class DefaultSpanSizeLookup extends SpanSizeLookup {
        public final int mo447a(int i) {
            return 1;
        }

        public final int mo448a(int i, int i2) {
            return i % i2;
        }
    }

    /* compiled from: trying check  */
    public class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        public int f1370e = -1;
        public int f1371f = 0;

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

        public final int m1892a() {
            return this.f1370e;
        }

        public final int m1893b() {
            return this.f1371f;
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        m1911a(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(i2, z);
        m1911a(i);
    }

    public final void m1918a(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.a(false);
    }

    public final int m1906a(Recycler recycler, State state) {
        if (this.j == 0) {
            return this.f1374c;
        }
        if (state.e() <= 0) {
            return 0;
        }
        return m1898a(recycler, state, state.e() - 1);
    }

    public final int m1920b(Recycler recycler, State state) {
        if (this.j == 1) {
            return this.f1374c;
        }
        if (state.e() <= 0) {
            return 0;
        }
        return m1898a(recycler, state, state.e() - 1);
    }

    public final void m1916a(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            int a = m1898a(recycler, state, layoutParams2.e());
            if (this.j == 0) {
                int i = layoutParams2.f1370e;
                int i2 = layoutParams2.f1371f;
                boolean z = this.f1374c > 1 && layoutParams2.f1371f == this.f1374c;
                accessibilityNodeInfoCompat.m706b(CollectionItemInfoCompat.m696a(i, i2, a, 1, z, false));
                return;
            }
            int i3 = layoutParams2.f1370e;
            int i4 = layoutParams2.f1371f;
            boolean z2 = this.f1374c > 1 && layoutParams2.f1371f == this.f1374c;
            accessibilityNodeInfoCompat.m706b(CollectionItemInfoCompat.m696a(a, 1, i3, i4, z2, false));
            return;
        }
        super.a(view, accessibilityNodeInfoCompat);
    }

    private void m1894I() {
        this.f1377f.clear();
        this.f1378g.clear();
    }

    private void m1895J() {
        int v = v();
        for (int i = 0; i < v; i++) {
            LayoutParams layoutParams = (LayoutParams) f(i).getLayoutParams();
            int e = layoutParams.e();
            this.f1377f.put(e, layoutParams.f1371f);
            this.f1378g.put(e, layoutParams.f1370e);
        }
    }

    public final void m1912a(int i, int i2) {
        this.f1379h.m1882a();
    }

    public final void m1910a() {
        this.f1379h.m1882a();
    }

    public final void m1922b(int i, int i2) {
        this.f1379h.m1882a();
    }

    public final void m1917a(RecyclerView recyclerView, int i, int i2) {
        this.f1379h.m1882a();
    }

    public final void m1924c(int i, int i2) {
        this.f1379h.m1882a();
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams m1921b() {
        return new LayoutParams(-2, -2);
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams m1907a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams m1908a(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public final boolean m1919a(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void m1913a(SpanSizeLookup spanSizeLookup) {
        this.f1379h = spanSizeLookup;
    }

    public final SpanSizeLookup m1923c() {
        return this.f1379h;
    }

    private void m1904j(int i) {
        int i2 = 0;
        if (!(this.f1375d != null && this.f1375d.length == this.f1374c + 1 && this.f1375d[this.f1375d.length - 1] == i)) {
            this.f1375d = new int[(this.f1374c + 1)];
        }
        this.f1375d[0] = 0;
        int i3 = i / this.f1374c;
        int i4 = i % this.f1374c;
        int i5 = 0;
        for (int i6 = 1; i6 <= this.f1374c; i6++) {
            int i7 = i2 + i4;
            if (i7 <= 0 || this.f1374c - i7 >= i4) {
                i2 = i7;
                i7 = i3;
            } else {
                int i8 = i3 + 1;
                i2 = i7 - this.f1374c;
                i7 = i8;
            }
            i5 += i7;
            this.f1375d[i6] = i5;
        }
    }

    final void m1914a(Recycler recycler, State state, AnchorInfo anchorInfo) {
        super.a(recycler, state, anchorInfo);
        m1896K();
        if (state.e() > 0 && !state.k) {
            m1902b(recycler, state, anchorInfo);
        }
        if (this.f1376e == null || this.f1376e.length != this.f1374c) {
            this.f1376e = new View[this.f1374c];
        }
    }

    private void m1896K() {
        int w;
        if (this.j == 1) {
            w = (w() - A()) - y();
        } else {
            w = (x() - B()) - z();
        }
        m1904j(w);
    }

    private void m1902b(Recycler recycler, State state, AnchorInfo anchorInfo) {
        int b = m1901b(recycler, state, anchorInfo.a);
        while (b > 0 && anchorInfo.a > 0) {
            anchorInfo.a--;
            b = m1901b(recycler, state, anchorInfo.a);
        }
    }

    final View m1909a(Recycler recycler, State state, int i, int i2, int i3) {
        int i4;
        View view = null;
        k();
        int c = this.k.c();
        int d = this.k.d();
        if (i2 > i) {
            i4 = 1;
        } else {
            i4 = -1;
        }
        View view2 = null;
        while (i != i2) {
            View view3;
            View f = f(i);
            int c2 = LayoutManager.c(f);
            if (c2 >= 0 && c2 < i3 && m1901b(recycler, state, c2) == 0) {
                if (((android.support.v7.widget.RecyclerView.LayoutParams) f.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view3 = view;
                        i += i4;
                        view = view3;
                        view2 = f;
                    }
                } else if (this.k.a(f) < d && this.k.b(f) >= c) {
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

    private int m1901b(Recycler recycler, State state, int i) {
        if (!state.k) {
            return this.f1379h.m1884b(i, this.f1374c);
        }
        int i2 = this.f1378g.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = recycler.b(i);
        if (i2 != -1) {
            return this.f1379h.m1884b(i2, this.f1374c);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private int m1903c(Recycler recycler, State state, int i) {
        if (!state.k) {
            return this.f1379h.mo447a(i);
        }
        int i2 = this.f1377f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = recycler.b(i);
        if (i2 != -1) {
            return this.f1379h.mo447a(i2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    final void m1915a(Recycler recycler, State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        boolean z;
        int i;
        if (layoutState.e == 1) {
            z = true;
        } else {
            z = false;
        }
        int i2 = this.f1374c;
        if (z) {
            i = 0;
        } else {
            i2 = m1901b(recycler, state, layoutState.d) + m1903c(recycler, state, layoutState.d);
            i = 0;
        }
        while (i < this.f1374c && layoutState.a(state) && i2 > 0) {
            int i3 = layoutState.d;
            int c = m1903c(recycler, state, i3);
            if (c <= this.f1374c) {
                i2 -= c;
                if (i2 < 0) {
                    break;
                }
                View a = layoutState.a(recycler);
                if (a == null) {
                    break;
                }
                this.f1376e[i] = a;
                i++;
            } else {
                throw new IllegalArgumentException("Item at position " + i3 + " requires " + c + " spans but GridLayoutManager has only " + this.f1374c + " spans.");
            }
        }
        if (i == 0) {
            layoutChunkResult.b = true;
            return;
        }
        int makeMeasureSpec;
        int i4;
        i3 = 0;
        m1899a(recycler, state, i, z);
        c = 0;
        while (c < i) {
            View view = this.f1376e[c];
            if (layoutState.k == null) {
                if (z) {
                    b(view);
                } else {
                    b(view, 0);
                }
            } else if (z) {
                a(view);
            } else {
                a(view, 0);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1375d[layoutParams.f1370e + layoutParams.f1371f] - this.f1375d[layoutParams.f1370e], 1073741824);
            if (this.j == 1) {
                m1900a(view, makeMeasureSpec, m1905k(layoutParams.height), false);
            } else {
                m1900a(view, m1905k(layoutParams.width), makeMeasureSpec, false);
            }
            i2 = this.k.c(view);
            if (i2 <= i3) {
                i2 = i3;
            }
            c++;
            i3 = i2;
        }
        c = m1905k(i3);
        for (i4 = 0; i4 < i; i4++) {
            view = this.f1376e[i4];
            if (this.k.c(view) != i3) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                i2 = MeasureSpec.makeMeasureSpec(this.f1375d[layoutParams.f1370e + layoutParams.f1371f] - this.f1375d[layoutParams.f1370e], 1073741824);
                if (this.j == 1) {
                    m1900a(view, i2, c, true);
                } else {
                    m1900a(view, c, i2, true);
                }
            }
        }
        layoutChunkResult.a = i3;
        i4 = 0;
        i2 = 0;
        if (this.j == 1) {
            if (layoutState.f == -1) {
                i2 = layoutState.b;
                i4 = i2 - i3;
                i3 = 0;
                c = 0;
            } else {
                i4 = layoutState.b;
                i2 = i4 + i3;
                i3 = 0;
                c = 0;
            }
        } else if (layoutState.f == -1) {
            c = layoutState.b;
            int i5 = c;
            c -= i3;
            i3 = i5;
        } else {
            c = layoutState.b;
            i3 += c;
        }
        int i6 = 0;
        makeMeasureSpec = c;
        c = i4;
        int i7 = i3;
        i3 = i2;
        while (i6 < i) {
            int i8;
            int i9;
            int d;
            int i10;
            View view2 = this.f1376e[i6];
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            if (this.j == 1) {
                i7 = this.f1375d[layoutParams2.f1370e] + y();
                i8 = i3;
                i9 = c;
                d = this.k.d(view2) + i7;
                i10 = i7;
            } else {
                i3 = this.f1375d[layoutParams2.f1370e] + z();
                i8 = this.k.d(view2) + i3;
                i9 = i3;
                d = i7;
                i10 = makeMeasureSpec;
            }
            a(view2, i10 + layoutParams2.leftMargin, i9 + layoutParams2.topMargin, d - layoutParams2.rightMargin, i8 - layoutParams2.bottomMargin);
            if (layoutParams2.c() || layoutParams2.d()) {
                layoutChunkResult.c = true;
            }
            layoutChunkResult.d |= view2.isFocusable();
            i6++;
            i3 = i8;
            c = i9;
            i7 = d;
            makeMeasureSpec = i10;
        }
        Arrays.fill(this.f1376e, null);
    }

    private static int m1905k(int i) {
        if (i < 0) {
            return f1372a;
        }
        return MeasureSpec.makeMeasureSpec(i, 1073741824);
    }

    private void m1900a(View view, int i, int i2, boolean z) {
        a(view, this.f1380i);
        android.support.v7.widget.RecyclerView.LayoutParams layoutParams = (android.support.v7.widget.RecyclerView.LayoutParams) view.getLayoutParams();
        if (z || this.j == 1) {
            i = m1897a(i, layoutParams.leftMargin + this.f1380i.left, layoutParams.rightMargin + this.f1380i.right);
        }
        if (z || this.j == 0) {
            i2 = m1897a(i2, layoutParams.topMargin + this.f1380i.top, layoutParams.bottomMargin + this.f1380i.bottom);
        }
        view.measure(i, i2);
    }

    private static int m1897a(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return MeasureSpec.makeMeasureSpec((MeasureSpec.getSize(i) - i2) - i3, mode);
        }
        return i;
    }

    private void m1899a(Recycler recycler, State state, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (z) {
            i2 = 1;
            i3 = 0;
        } else {
            i3 = i - 1;
            i2 = -1;
            i = -1;
        }
        if (this.j == 1 && j()) {
            i4 = this.f1374c - 1;
            i5 = -1;
        } else {
            i4 = 0;
            i5 = 1;
        }
        int i6 = i4;
        for (i4 = i3; i4 != i; i4 += i2) {
            View view = this.f1376e[i4];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f1371f = m1903c(recycler, state, LayoutManager.c(view));
            if (i5 != -1 || layoutParams.f1371f <= 1) {
                layoutParams.f1370e = i6;
            } else {
                layoutParams.f1370e = i6 - (layoutParams.f1371f - 1);
            }
            i6 += layoutParams.f1371f * i5;
        }
    }

    public final int m1926d() {
        return this.f1374c;
    }

    public final void m1911a(int i) {
        if (i != this.f1374c) {
            this.f1373b = true;
            if (i <= 0) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.f1374c = i;
            this.f1379h.m1882a();
        }
    }

    public final boolean m1927e() {
        return this.o == null && !this.f1373b;
    }

    private int m1898a(Recycler recycler, State state, int i) {
        if (!state.k) {
            return this.f1379h.m1885c(i, this.f1374c);
        }
        int b = recycler.b(i);
        if (b != -1) {
            return this.f1379h.m1885c(b, this.f1374c);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    public void m1925c(Recycler recycler, State state) {
        if (state.k) {
            m1895J();
        }
        super.c(recycler, state);
        m1894I();
        if (!state.k) {
            this.f1373b = false;
        }
    }
}
