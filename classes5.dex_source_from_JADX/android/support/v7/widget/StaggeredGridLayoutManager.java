package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: treehouse_name_hint */
public class StaggeredGridLayoutManager extends LayoutManager {
    private boolean f1490A = true;
    private final Runnable f1491B = new C00801(this);
    public OrientationHelper f1492a;
    OrientationHelper f1493b;
    public boolean f1494c = false;
    int f1495d = -1;
    int f1496e = Integer.MIN_VALUE;
    public LazySpanLookup f1497f = new LazySpanLookup();
    public int f1498g = -1;
    public Span[] f1499h;
    public int f1500i;
    private int f1501j;
    private LayoutState f1502k;
    public boolean f1503l = false;
    public BitSet f1504m;
    private int f1505n = 2;
    public boolean f1506o;
    private boolean f1507p;
    public SavedState f1508t;
    private int f1509u;
    private int f1510v;
    private int f1511w;
    private final Rect f1512x = new Rect();
    private final AnchorInfo f1513y = new AnchorInfo(this);
    private boolean f1514z = false;

    /* compiled from: treehouse_name_hint */
    class C00801 implements Runnable {
        final /* synthetic */ StaggeredGridLayoutManager f1459a;

        C00801(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.f1459a = staggeredGridLayoutManager;
        }

        public void run() {
            StaggeredGridLayoutManager.m2034d(this.f1459a);
        }
    }

    /* compiled from: treehouse_name_hint */
    public class AnchorInfo {
        public int f1461a;
        public int f1462b;
        public boolean f1463c;
        public boolean f1464d;
        public final /* synthetic */ StaggeredGridLayoutManager f1465e;

        public AnchorInfo(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.f1465e = staggeredGridLayoutManager;
        }

        final void m1976b() {
            this.f1462b = this.f1463c ? this.f1465e.f1492a.d() : this.f1465e.f1492a.c();
        }
    }

    /* compiled from: treehouse_name_hint */
    public class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        Span f1466e;
        boolean f1467f;

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

        public final int m1977a() {
            if (this.f1466e == null) {
                return -1;
            }
            return this.f1466e.f1487d;
        }
    }

    /* compiled from: treehouse_name_hint */
    public class LazySpanLookup {
        public int[] f1472a;
        public List<FullSpanItem> f1473b;

        /* compiled from: treehouse_name_hint */
        public class FullSpanItem implements Parcelable {
            public static final Creator<FullSpanItem> CREATOR = new C00821();
            public int f1468a;
            int f1469b;
            int[] f1470c;
            boolean f1471d;

            /* compiled from: treehouse_name_hint */
            final class C00821 implements Creator<FullSpanItem> {
                C00821() {
                }

                public final Object createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                public final Object[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            }

            public FullSpanItem(Parcel parcel) {
                boolean z = true;
                this.f1468a = parcel.readInt();
                this.f1469b = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                this.f1471d = z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.f1470c = new int[readInt];
                    parcel.readIntArray(this.f1470c);
                }
            }

            final int m1978a(int i) {
                return this.f1470c == null ? 0 : this.f1470c[i];
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f1468a);
                parcel.writeInt(this.f1469b);
                parcel.writeInt(this.f1471d ? 1 : 0);
                if (this.f1470c == null || this.f1470c.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.f1470c.length);
                parcel.writeIntArray(this.f1470c);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f1468a + ", mGapDir=" + this.f1469b + ", mHasUnwantedGapAfter=" + this.f1471d + ", mGapPerSpan=" + Arrays.toString(this.f1470c) + '}';
            }
        }

        LazySpanLookup() {
        }

        final int m1980a(int i) {
            if (this.f1473b != null) {
                for (int size = this.f1473b.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.f1473b.get(size)).f1468a >= i) {
                        this.f1473b.remove(size);
                    }
                }
            }
            return m1986b(i);
        }

        final int m1986b(int i) {
            if (this.f1472a == null || i >= this.f1472a.length) {
                return -1;
            }
            int i2;
            if (this.f1473b == null) {
                i2 = -1;
            } else {
                FullSpanItem d = m1989d(i);
                if (d != null) {
                    this.f1473b.remove(d);
                }
                int size = this.f1473b.size();
                int i3 = 0;
                while (i3 < size) {
                    if (((FullSpanItem) this.f1473b.get(i3)).f1468a >= i) {
                        break;
                    }
                    i3++;
                }
                i3 = -1;
                if (i3 != -1) {
                    d = (FullSpanItem) this.f1473b.get(i3);
                    this.f1473b.remove(i3);
                    i2 = d.f1468a;
                } else {
                    i2 = -1;
                }
            }
            int i4 = i2;
            if (i4 == -1) {
                Arrays.fill(this.f1472a, i, this.f1472a.length, -1);
                return this.f1472a.length;
            }
            Arrays.fill(this.f1472a, i, i4 + 1, -1);
            return i4 + 1;
        }

        final int m1988c(int i) {
            if (this.f1472a == null || i >= this.f1472a.length) {
                return -1;
            }
            return this.f1472a[i];
        }

        final void m1984a(int i, Span span) {
            m1979f(i);
            this.f1472a[i] = span.f1487d;
        }

        private void m1979f(int i) {
            if (this.f1472a == null) {
                this.f1472a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.f1472a, -1);
            } else if (i >= this.f1472a.length) {
                Object obj = this.f1472a;
                int length = this.f1472a.length;
                while (length <= i) {
                    length *= 2;
                }
                this.f1472a = new int[length];
                System.arraycopy(obj, 0, this.f1472a, 0, obj.length);
                Arrays.fill(this.f1472a, obj.length, this.f1472a.length, -1);
            }
        }

        public final void m1982a() {
            if (this.f1472a != null) {
                Arrays.fill(this.f1472a, -1);
            }
            this.f1473b = null;
        }

        final void m1983a(int i, int i2) {
            if (this.f1472a != null && i < this.f1472a.length) {
                m1979f(i + i2);
                System.arraycopy(this.f1472a, i + i2, this.f1472a, i, (this.f1472a.length - i) - i2);
                Arrays.fill(this.f1472a, this.f1472a.length - i2, this.f1472a.length, -1);
                if (this.f1473b != null) {
                    int i3 = i + i2;
                    for (int size = this.f1473b.size() - 1; size >= 0; size--) {
                        FullSpanItem fullSpanItem = (FullSpanItem) this.f1473b.get(size);
                        if (fullSpanItem.f1468a >= i) {
                            if (fullSpanItem.f1468a < i3) {
                                this.f1473b.remove(size);
                            } else {
                                fullSpanItem.f1468a -= i2;
                            }
                        }
                    }
                }
            }
        }

        final void m1987b(int i, int i2) {
            if (this.f1472a != null && i < this.f1472a.length) {
                m1979f(i + i2);
                System.arraycopy(this.f1472a, i, this.f1472a, i + i2, (this.f1472a.length - i) - i2);
                Arrays.fill(this.f1472a, i, i + i2, -1);
                if (this.f1473b != null) {
                    for (int size = this.f1473b.size() - 1; size >= 0; size--) {
                        FullSpanItem fullSpanItem = (FullSpanItem) this.f1473b.get(size);
                        if (fullSpanItem.f1468a >= i) {
                            fullSpanItem.f1468a += i2;
                        }
                    }
                }
            }
        }

        public final void m1985a(FullSpanItem fullSpanItem) {
            if (this.f1473b == null) {
                this.f1473b = new ArrayList();
            }
            int size = this.f1473b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.f1473b.get(i);
                if (fullSpanItem2.f1468a == fullSpanItem.f1468a) {
                    this.f1473b.remove(i);
                }
                if (fullSpanItem2.f1468a >= fullSpanItem.f1468a) {
                    this.f1473b.add(i, fullSpanItem);
                    return;
                }
            }
            this.f1473b.add(fullSpanItem);
        }

        public final FullSpanItem m1989d(int i) {
            if (this.f1473b == null) {
                return null;
            }
            for (int size = this.f1473b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f1473b.get(size);
                if (fullSpanItem.f1468a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public final FullSpanItem m1981a(int i, int i2, int i3, boolean z) {
            if (this.f1473b == null) {
                return null;
            }
            int size = this.f1473b.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.f1473b.get(i4);
                if (fullSpanItem.f1468a >= i2) {
                    return null;
                }
                if (fullSpanItem.f1468a >= i) {
                    if (i3 == 0 || fullSpanItem.f1469b == i3) {
                        return fullSpanItem;
                    }
                    if (z && fullSpanItem.f1471d) {
                        return fullSpanItem;
                    }
                }
            }
            return null;
        }
    }

    /* compiled from: treehouse_name_hint */
    public class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C00831();
        public int f1474a;
        public int f1475b;
        public int f1476c;
        public int[] f1477d;
        public int f1478e;
        public int[] f1479f;
        public List<FullSpanItem> f1480g;
        public boolean f1481h;
        boolean f1482i;
        boolean f1483j;

        /* compiled from: treehouse_name_hint */
        final class C00831 implements Creator<SavedState> {
            C00831() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.f1474a = parcel.readInt();
            this.f1475b = parcel.readInt();
            this.f1476c = parcel.readInt();
            if (this.f1476c > 0) {
                this.f1477d = new int[this.f1476c];
                parcel.readIntArray(this.f1477d);
            }
            this.f1478e = parcel.readInt();
            if (this.f1478e > 0) {
                this.f1479f = new int[this.f1478e];
                parcel.readIntArray(this.f1479f);
            }
            this.f1481h = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.f1482i = z;
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.f1483j = z2;
            this.f1480g = parcel.readArrayList(FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f1476c = savedState.f1476c;
            this.f1474a = savedState.f1474a;
            this.f1475b = savedState.f1475b;
            this.f1477d = savedState.f1477d;
            this.f1478e = savedState.f1478e;
            this.f1479f = savedState.f1479f;
            this.f1481h = savedState.f1481h;
            this.f1482i = savedState.f1482i;
            this.f1483j = savedState.f1483j;
            this.f1480g = savedState.f1480g;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            parcel.writeInt(this.f1474a);
            parcel.writeInt(this.f1475b);
            parcel.writeInt(this.f1476c);
            if (this.f1476c > 0) {
                parcel.writeIntArray(this.f1477d);
            }
            parcel.writeInt(this.f1478e);
            if (this.f1478e > 0) {
                parcel.writeIntArray(this.f1479f);
            }
            if (this.f1481h) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (this.f1482i) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (!this.f1483j) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeList(this.f1480g);
        }
    }

    /* compiled from: treehouse_name_hint */
    public class Span {
        public int f1484a = Integer.MIN_VALUE;
        public int f1485b = Integer.MIN_VALUE;
        public int f1486c = 0;
        final int f1487d;
        final /* synthetic */ StaggeredGridLayoutManager f1488e;
        public ArrayList<View> f1489f = new ArrayList();

        public Span(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
            this.f1488e = staggeredGridLayoutManager;
            this.f1487d = i;
        }

        public final int m1994a(int i) {
            if (this.f1484a != Integer.MIN_VALUE) {
                return this.f1484a;
            }
            if (this.f1489f.size() == 0) {
                return i;
            }
            m1991g();
            return this.f1484a;
        }

        private void m1991g() {
            View view = (View) this.f1489f.get(0);
            LayoutParams c = m1990c(view);
            this.f1484a = this.f1488e.f1492a.a(view);
            if (c.f1467f) {
                FullSpanItem d = this.f1488e.f1497f.m1989d(c.e());
                if (d != null && d.f1469b == -1) {
                    this.f1484a -= d.m1978a(this.f1487d);
                }
            }
        }

        public final int m1993a() {
            if (this.f1484a != Integer.MIN_VALUE) {
                return this.f1484a;
            }
            m1991g();
            return this.f1484a;
        }

        public final int m1998b(int i) {
            if (this.f1485b != Integer.MIN_VALUE) {
                return this.f1485b;
            }
            if (this.f1489f.size() == 0) {
                return i;
            }
            m1992h();
            return this.f1485b;
        }

        private void m1992h() {
            View view = (View) this.f1489f.get(this.f1489f.size() - 1);
            LayoutParams c = m1990c(view);
            this.f1485b = this.f1488e.f1492a.b(view);
            if (c.f1467f) {
                FullSpanItem d = this.f1488e.f1497f.m1989d(c.e());
                if (d != null && d.f1469b == 1) {
                    this.f1485b = d.m1978a(this.f1487d) + this.f1485b;
                }
            }
        }

        public final int m1997b() {
            if (this.f1485b != Integer.MIN_VALUE) {
                return this.f1485b;
            }
            m1992h();
            return this.f1485b;
        }

        public final void m1995a(View view) {
            LayoutParams c = m1990c(view);
            c.f1466e = this;
            this.f1489f.add(0, view);
            this.f1484a = Integer.MIN_VALUE;
            if (this.f1489f.size() == 1) {
                this.f1485b = Integer.MIN_VALUE;
            }
            if (c.c() || c.d()) {
                this.f1486c += this.f1488e.f1492a.c(view);
            }
        }

        public final void m1999b(View view) {
            LayoutParams c = m1990c(view);
            c.f1466e = this;
            this.f1489f.add(view);
            this.f1485b = Integer.MIN_VALUE;
            if (this.f1489f.size() == 1) {
                this.f1484a = Integer.MIN_VALUE;
            }
            if (c.c() || c.d()) {
                this.f1486c += this.f1488e.f1492a.c(view);
            }
        }

        final void m1996a(boolean z, int i) {
            int b;
            if (z) {
                b = m1998b(Integer.MIN_VALUE);
            } else {
                b = m1994a(Integer.MIN_VALUE);
            }
            m2000c();
            if (b != Integer.MIN_VALUE) {
                if (z && b < this.f1488e.f1492a.d()) {
                    return;
                }
                if (z || b <= this.f1488e.f1492a.c()) {
                    if (i != Integer.MIN_VALUE) {
                        b += i;
                    }
                    this.f1485b = b;
                    this.f1484a = b;
                }
            }
        }

        final void m2000c() {
            this.f1489f.clear();
            this.f1484a = Integer.MIN_VALUE;
            this.f1485b = Integer.MIN_VALUE;
            this.f1486c = 0;
        }

        final void m2001c(int i) {
            this.f1484a = i;
            this.f1485b = i;
        }

        final void m2002d() {
            int size = this.f1489f.size();
            View view = (View) this.f1489f.remove(size - 1);
            LayoutParams c = m1990c(view);
            c.f1466e = null;
            if (c.c() || c.d()) {
                this.f1486c -= this.f1488e.f1492a.c(view);
            }
            if (size == 1) {
                this.f1484a = Integer.MIN_VALUE;
            }
            this.f1485b = Integer.MIN_VALUE;
        }

        final void m2004e() {
            View view = (View) this.f1489f.remove(0);
            LayoutParams c = m1990c(view);
            c.f1466e = null;
            if (this.f1489f.size() == 0) {
                this.f1485b = Integer.MIN_VALUE;
            }
            if (c.c() || c.d()) {
                this.f1486c -= this.f1488e.f1492a.c(view);
            }
            this.f1484a = Integer.MIN_VALUE;
        }

        private static LayoutParams m1990c(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        final void m2003d(int i) {
            if (this.f1484a != Integer.MIN_VALUE) {
                this.f1484a += i;
            }
            if (this.f1485b != Integer.MIN_VALUE) {
                this.f1485b += i;
            }
        }
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        this.f1500i = i2;
        a(null);
        if (i != this.f1498g) {
            this.f1497f.m1982a();
            p();
            this.f1498g = i;
            this.f1504m = new BitSet(this.f1498g);
            this.f1499h = new Span[this.f1498g];
            for (int i3 = 0; i3 < this.f1498g; i3++) {
                this.f1499h[i3] = new Span(this, i3);
            }
            p();
        }
    }

    public static boolean m2034d(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        if (staggeredGridLayoutManager.v() == 0 || staggeredGridLayoutManager.f1505n == 0 || !staggeredGridLayoutManager.b) {
            return false;
        }
        int K;
        int L;
        if (staggeredGridLayoutManager.f1494c) {
            K = staggeredGridLayoutManager.m2007K();
            L = staggeredGridLayoutManager.m2008L();
        } else {
            K = staggeredGridLayoutManager.m2008L();
            L = staggeredGridLayoutManager.m2007K();
        }
        if (K == 0 && staggeredGridLayoutManager.m2038i() != null) {
            staggeredGridLayoutManager.f1497f.m1982a();
            staggeredGridLayoutManager.H();
            staggeredGridLayoutManager.p();
            return true;
        } else if (!staggeredGridLayoutManager.f1514z) {
            return false;
        } else {
            int i = staggeredGridLayoutManager.f1494c ? -1 : 1;
            FullSpanItem a = staggeredGridLayoutManager.f1497f.m1981a(K, L + 1, i, true);
            if (a == null) {
                staggeredGridLayoutManager.f1514z = false;
                staggeredGridLayoutManager.f1497f.m1980a(L + 1);
                return false;
            }
            FullSpanItem a2 = staggeredGridLayoutManager.f1497f.m1981a(K, a.f1468a, i * -1, true);
            if (a2 == null) {
                staggeredGridLayoutManager.f1497f.m1980a(a.f1468a);
            } else {
                staggeredGridLayoutManager.f1497f.m1980a(a2.f1468a + 1);
            }
            staggeredGridLayoutManager.H();
            staggeredGridLayoutManager.p();
            return true;
        }
    }

    public final void m2082i(int i) {
        if (i == 0) {
            m2034d(this);
        }
    }

    public final void m2058a(RecyclerView recyclerView, Recycler recycler) {
        b(this.f1491B);
        for (int i = 0; i < this.f1498g; i++) {
            this.f1499h[i].m2000c();
        }
    }

    private View m2038i() {
        int i;
        int i2;
        int v = v() - 1;
        BitSet bitSet = new BitSet(this.f1498g);
        bitSet.set(0, this.f1498g, true);
        boolean z = (this.f1500i == 1 && m2044m()) ? true : true;
        if (this.f1494c) {
            i = -1;
        } else {
            i = v + 1;
            v = 0;
        }
        if (v < i) {
            i2 = 1;
        } else {
            i2 = -1;
        }
        int i3 = v;
        while (i3 != i) {
            View f = f(i3);
            LayoutParams layoutParams = (LayoutParams) f.getLayoutParams();
            if (bitSet.get(layoutParams.f1466e.f1487d)) {
                Span span = layoutParams.f1466e;
                Object obj = 1;
                if (this.f1494c ? span.m1997b() < this.f1492a.d() : span.m1993a() > this.f1492a.c()) {
                    obj = null;
                }
                if (obj != null) {
                    return f;
                }
                bitSet.clear(layoutParams.f1466e.f1487d);
            }
            if (!(layoutParams.f1467f || i3 + i2 == i)) {
                boolean z2;
                View f2 = f(i3 + i2);
                int b;
                if (this.f1494c) {
                    v = this.f1492a.b(f);
                    b = this.f1492a.b(f2);
                    if (v < b) {
                        return f;
                    }
                    if (v == b) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    v = this.f1492a.a(f);
                    b = this.f1492a.a(f2);
                    if (v > b) {
                        return f;
                    }
                    if (v == b) {
                        z2 = true;
                    }
                    z2 = false;
                }
                if (z2) {
                    boolean z3;
                    if (layoutParams.f1466e.f1487d - ((LayoutParams) f2.getLayoutParams()).f1466e.f1487d < 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z >= false) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z2 != z3) {
                        return f;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    public final void m2061a(String str) {
        if (this.f1508t == null) {
            super.a(str);
        }
    }

    private void m2040k() {
        if (this.f1492a == null) {
            this.f1492a = OrientationHelper.a(this, this.f1500i);
            this.f1493b = OrientationHelper.a(this, 1 - this.f1500i);
            this.f1502k = new LayoutState();
        }
    }

    private void m2042l() {
        boolean z = true;
        if (this.f1500i == 1 || !m2044m()) {
            z = this.f1503l;
        } else if (this.f1503l) {
            z = false;
        }
        this.f1494c = z;
    }

    private boolean m2044m() {
        return t() == 1;
    }

    public final void m2070c(Recycler recycler, State state) {
        boolean z = false;
        m2040k();
        AnchorInfo anchorInfo = this.f1513y;
        anchorInfo.f1461a = -1;
        anchorInfo.f1462b = Integer.MIN_VALUE;
        anchorInfo.f1463c = false;
        anchorInfo.f1464d = false;
        if (!(this.f1508t == null && this.f1495d == -1) && state.e() == 0) {
            c(recycler);
            return;
        }
        if (this.f1508t != null) {
            m2019a(anchorInfo);
        } else {
            m2042l();
            anchorInfo.f1463c = this.f1494c;
        }
        m2018a(state, anchorInfo);
        if (this.f1508t == null && !(anchorInfo.f1463c == this.f1506o && m2044m() == this.f1507p)) {
            this.f1497f.m1982a();
            anchorInfo.f1464d = true;
        }
        if (v() > 0 && (this.f1508t == null || this.f1508t.f1476c <= 0)) {
            int i;
            if (anchorInfo.f1464d) {
                for (i = 0; i < this.f1498g; i++) {
                    this.f1499h[i].m2000c();
                    if (anchorInfo.f1462b != Integer.MIN_VALUE) {
                        this.f1499h[i].m2001c(anchorInfo.f1462b);
                    }
                }
            } else {
                for (i = 0; i < this.f1498g; i++) {
                    this.f1499h[i].m1996a(this.f1494c, anchorInfo.f1462b);
                }
            }
        }
        a(recycler);
        this.f1514z = false;
        m2045n();
        m2014a(anchorInfo.f1461a, state);
        if (anchorInfo.f1463c) {
            m2024b(-1);
            m2010a(recycler, this.f1502k, state);
            m2024b(1);
            this.f1502k.f1382b = anchorInfo.f1461a + this.f1502k.f1383c;
            m2010a(recycler, this.f1502k, state);
        } else {
            m2024b(1);
            m2010a(recycler, this.f1502k, state);
            m2024b(-1);
            this.f1502k.f1382b = anchorInfo.f1461a + this.f1502k.f1383c;
            m2010a(recycler, this.f1502k, state);
        }
        if (v() > 0) {
            if (this.f1494c) {
                m2017a(recycler, state, true);
                m2027b(recycler, state, false);
            } else {
                m2027b(recycler, state, true);
                m2017a(recycler, state, false);
            }
        }
        if (!state.k) {
            if (this.f1505n != 0 && v() > 0 && (this.f1514z || m2038i() != null)) {
                z = true;
            }
            if (z) {
                b(this.f1491B);
                a(this.f1491B);
            }
            this.f1495d = -1;
            this.f1496e = Integer.MIN_VALUE;
        }
        this.f1506o = anchorInfo.f1463c;
        this.f1507p = m2044m();
        this.f1508t = null;
    }

    private void m2019a(AnchorInfo anchorInfo) {
        if (this.f1508t.f1476c > 0) {
            if (this.f1508t.f1476c == this.f1498g) {
                for (int i = 0; i < this.f1498g; i++) {
                    this.f1499h[i].m2000c();
                    int i2 = this.f1508t.f1477d[i];
                    if (i2 != Integer.MIN_VALUE) {
                        if (this.f1508t.f1482i) {
                            i2 += this.f1492a.d();
                        } else {
                            i2 += this.f1492a.c();
                        }
                    }
                    this.f1499h[i].m2001c(i2);
                }
            } else {
                SavedState savedState = this.f1508t;
                savedState.f1477d = null;
                savedState.f1476c = 0;
                savedState.f1478e = 0;
                savedState.f1479f = null;
                savedState.f1480g = null;
                this.f1508t.f1474a = this.f1508t.f1475b;
            }
        }
        this.f1507p = this.f1508t.f1483j;
        boolean z = this.f1508t.f1481h;
        a(null);
        if (!(this.f1508t == null || this.f1508t.f1481h == z)) {
            this.f1508t.f1481h = z;
        }
        this.f1503l = z;
        p();
        m2042l();
        if (this.f1508t.f1474a != -1) {
            this.f1495d = this.f1508t.f1474a;
            anchorInfo.f1463c = this.f1508t.f1482i;
        } else {
            anchorInfo.f1463c = this.f1494c;
        }
        if (this.f1508t.f1478e > 1) {
            this.f1497f.f1472a = this.f1508t.f1479f;
            this.f1497f.f1473b = this.f1508t.f1480g;
        }
    }

    private void m2018a(State state, AnchorInfo anchorInfo) {
        if (!m2030c(state, anchorInfo)) {
            int e;
            int c;
            if (this.f1506o) {
                e = state.e();
                for (int v = v() - 1; v >= 0; v--) {
                    c = LayoutManager.c(f(v));
                    if (c >= 0 && c < e) {
                        break;
                    }
                }
                c = 0;
                e = c;
            } else {
                e = state.e();
                int v2 = v();
                for (int i = 0; i < v2; i++) {
                    c = LayoutManager.c(f(i));
                    if (c >= 0 && c < e) {
                        break;
                    }
                }
                c = 0;
                e = c;
            }
            anchorInfo.f1461a = e;
            anchorInfo.f1462b = Integer.MIN_VALUE;
            if (1 == 0) {
                anchorInfo.m1976b();
                anchorInfo.f1461a = 0;
            }
        }
    }

    private boolean m2030c(State state, AnchorInfo anchorInfo) {
        boolean z = false;
        if (state.k || this.f1495d == -1) {
            return false;
        }
        if (this.f1495d < 0 || this.f1495d >= state.e()) {
            this.f1495d = -1;
            this.f1496e = Integer.MIN_VALUE;
            return false;
        } else if (this.f1508t == null || this.f1508t.f1474a == -1 || this.f1508t.f1476c <= 0) {
            View c = c(this.f1495d);
            int a;
            if (c != null) {
                anchorInfo.f1461a = this.f1494c ? m2007K() : m2008L();
                if (this.f1496e != Integer.MIN_VALUE) {
                    if (anchorInfo.f1463c) {
                        anchorInfo.f1462b = (this.f1492a.d() - this.f1496e) - this.f1492a.b(c);
                        return true;
                    }
                    anchorInfo.f1462b = (this.f1492a.c() + this.f1496e) - this.f1492a.a(c);
                    return true;
                } else if (this.f1492a.c(c) > this.f1492a.f()) {
                    anchorInfo.f1462b = anchorInfo.f1463c ? this.f1492a.d() : this.f1492a.c();
                    return true;
                } else {
                    a = this.f1492a.a(c) - this.f1492a.c();
                    if (a < 0) {
                        anchorInfo.f1462b = -a;
                        return true;
                    }
                    a = this.f1492a.d() - this.f1492a.b(c);
                    if (a < 0) {
                        anchorInfo.f1462b = a;
                        return true;
                    }
                    anchorInfo.f1462b = Integer.MIN_VALUE;
                    return true;
                }
            }
            anchorInfo.f1461a = this.f1495d;
            if (this.f1496e == Integer.MIN_VALUE) {
                if (m2048p(this, anchorInfo.f1461a) == 1) {
                    z = true;
                }
                anchorInfo.f1463c = z;
                anchorInfo.m1976b();
            } else {
                a = this.f1496e;
                if (anchorInfo.f1463c) {
                    anchorInfo.f1462b = anchorInfo.f1465e.f1492a.d() - a;
                } else {
                    anchorInfo.f1462b = anchorInfo.f1465e.f1492a.c() + a;
                }
            }
            anchorInfo.f1464d = true;
            return true;
        } else {
            anchorInfo.f1462b = Integer.MIN_VALUE;
            anchorInfo.f1461a = this.f1495d;
            return true;
        }
    }

    private void m2045n() {
        this.f1501j = this.f1493b.f() / this.f1498g;
        this.f1509u = MeasureSpec.makeMeasureSpec(this.f1493b.f(), 1073741824);
        if (this.f1500i == 1) {
            this.f1510v = MeasureSpec.makeMeasureSpec(this.f1501j, 1073741824);
            this.f1511w = MeasureSpec.makeMeasureSpec(0, 0);
            return;
        }
        this.f1511w = MeasureSpec.makeMeasureSpec(this.f1501j, 1073741824);
        this.f1510v = MeasureSpec.makeMeasureSpec(0, 0);
    }

    public final boolean m2074e() {
        return this.f1508t == null;
    }

    public final int m2065b(State state) {
        return m2011a(state);
    }

    private int m2011a(State state) {
        boolean z = false;
        if (v() == 0) {
            return 0;
        }
        m2040k();
        OrientationHelper orientationHelper = this.f1492a;
        View a = m2013a(!this.f1490A, true);
        if (!this.f1490A) {
            z = true;
        }
        return ScrollbarHelper.m1962a(state, orientationHelper, a, m2023b(z, true), this, this.f1490A, this.f1494c);
    }

    public final int m2068c(State state) {
        return m2011a(state);
    }

    public final int m2071d(State state) {
        return m2036h(state);
    }

    private int m2036h(State state) {
        boolean z = false;
        if (v() == 0) {
            return 0;
        }
        m2040k();
        OrientationHelper orientationHelper = this.f1492a;
        View a = m2013a(!this.f1490A, true);
        if (!this.f1490A) {
            z = true;
        }
        return ScrollbarHelper.m1961a(state, orientationHelper, a, m2023b(z, true), this, this.f1490A);
    }

    public final int m2072e(State state) {
        return m2036h(state);
    }

    public final int m2075f(State state) {
        return m2037i(state);
    }

    private int m2037i(State state) {
        boolean z = false;
        if (v() == 0) {
            return 0;
        }
        m2040k();
        OrientationHelper orientationHelper = this.f1492a;
        View a = m2013a(!this.f1490A, true);
        if (!this.f1490A) {
            z = true;
        }
        return ScrollbarHelper.m1963b(state, orientationHelper, a, m2023b(z, true), this, this.f1490A);
    }

    public final int m2077g(State state) {
        return m2037i(state);
    }

    private void m2021a(View view, LayoutParams layoutParams) {
        if (layoutParams.f1467f) {
            if (this.f1500i == 1) {
                m2029c(view, this.f1509u, m2031d(layoutParams.height, this.f1511w));
            } else {
                m2029c(view, m2031d(layoutParams.width, this.f1510v), this.f1509u);
            }
        } else if (this.f1500i == 1) {
            m2029c(view, this.f1510v, m2031d(layoutParams.height, this.f1511w));
        } else {
            m2029c(view, m2031d(layoutParams.width, this.f1510v), this.f1511w);
        }
    }

    private static int m2031d(int i, int i2) {
        return i < 0 ? i2 : MeasureSpec.makeMeasureSpec(i, 1073741824);
    }

    private void m2029c(View view, int i, int i2) {
        a(view, this.f1512x);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        view.measure(m2009a(i, layoutParams.leftMargin + this.f1512x.left, layoutParams.rightMargin + this.f1512x.right), m2009a(i2, layoutParams.topMargin + this.f1512x.top, layoutParams.bottomMargin + this.f1512x.bottom));
    }

    private static int m2009a(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return MeasureSpec.makeMeasureSpec((MeasureSpec.getSize(i) - i2) - i3, mode);
        }
        return i;
    }

    public final void m2055a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f1508t = (SavedState) parcelable;
            p();
        }
    }

    public final Parcelable m2076f() {
        if (this.f1508t != null) {
            return new SavedState(this.f1508t);
        }
        SavedState savedState = new SavedState();
        savedState.f1481h = this.f1503l;
        savedState.f1482i = this.f1506o;
        savedState.f1483j = this.f1507p;
        if (this.f1497f == null || this.f1497f.f1472a == null) {
            savedState.f1478e = 0;
        } else {
            savedState.f1479f = this.f1497f.f1472a;
            savedState.f1478e = savedState.f1479f.length;
            savedState.f1480g = this.f1497f.f1473b;
        }
        if (v() > 0) {
            m2040k();
            savedState.f1474a = this.f1506o ? m2007K() : m2008L();
            savedState.f1475b = m2046o();
            savedState.f1476c = this.f1498g;
            savedState.f1477d = new int[this.f1498g];
            for (int i = 0; i < this.f1498g; i++) {
                int b;
                if (this.f1506o) {
                    b = this.f1499h[i].m1998b(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.f1492a.d();
                    }
                } else {
                    b = this.f1499h[i].m1994a(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.f1492a.c();
                    }
                }
                savedState.f1477d[i] = b;
            }
        } else {
            savedState.f1474a = -1;
            savedState.f1475b = -1;
            savedState.f1476c = 0;
        }
        return savedState;
    }

    public final void m2056a(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        int i = -1;
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            int i2;
            int a;
            int i3;
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (this.f1500i == 0) {
                i2 = layoutParams2.f1467f ? this.f1498g : 1;
                a = layoutParams2.m1977a();
                i3 = -1;
            } else {
                i3 = layoutParams2.m1977a();
                if (layoutParams2.f1467f) {
                    a = -1;
                    i = this.f1498g;
                    i2 = -1;
                } else {
                    a = -1;
                    i = 1;
                    i2 = -1;
                }
            }
            accessibilityNodeInfoCompat.m706b(CollectionItemInfoCompat.m696a(a, i2, i3, i, layoutParams2.f1467f, false));
            return;
        }
        super.a(view, accessibilityNodeInfoCompat);
    }

    public final void m2060a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (v() > 0) {
            AccessibilityRecordCompat a = AccessibilityEventCompat.m524a(accessibilityEvent);
            View a2 = m2013a(false, true);
            View b = m2023b(false, true);
            if (a2 != null && b != null) {
                int c = LayoutManager.c(a2);
                int c2 = LayoutManager.c(b);
                if (c < c2) {
                    a.m822b(c);
                    a.m823c(c2);
                    return;
                }
                a.m822b(c2);
                a.m823c(c);
            }
        }
    }

    private int m2046o() {
        View b = this.f1494c ? m2023b(true, true) : m2013a(true, true);
        return b == null ? -1 : LayoutManager.c(b);
    }

    public final int m2050a(Recycler recycler, State state) {
        if (this.f1500i == 0) {
            return this.f1498g;
        }
        return super.a(recycler, state);
    }

    public final int m2064b(Recycler recycler, State state) {
        if (this.f1500i == 1) {
            return this.f1498g;
        }
        return super.b(recycler, state);
    }

    private View m2013a(boolean z, boolean z2) {
        m2040k();
        int c = this.f1492a.c();
        int d = this.f1492a.d();
        int v = v();
        View view = null;
        int i = 0;
        while (i < v) {
            View f = f(i);
            int a = this.f1492a.a(f);
            if (this.f1492a.b(f) > c && a < d) {
                if (a >= c || !z) {
                    return f;
                }
                if (z2 && view == null) {
                    i++;
                    view = f;
                }
            }
            f = view;
            i++;
            view = f;
        }
        return view;
    }

    private View m2023b(boolean z, boolean z2) {
        m2040k();
        int c = this.f1492a.c();
        int d = this.f1492a.d();
        View view = null;
        int v = v() - 1;
        while (v >= 0) {
            View f = f(v);
            int a = this.f1492a.a(f);
            int b = this.f1492a.b(f);
            if (b > c && a < d) {
                if (b <= d || !z) {
                    return f;
                }
                if (z2 && view == null) {
                    v--;
                    view = f;
                }
            }
            f = view;
            v--;
            view = f;
        }
        return view;
    }

    private void m2017a(Recycler recycler, State state, boolean z) {
        int d = this.f1492a.d() - m2043m(this.f1492a.d());
        if (d > 0) {
            d -= -m2032d(-d, recycler, state);
            if (z && d > 0) {
                this.f1492a.a(d);
            }
        }
    }

    private void m2027b(Recycler recycler, State state, boolean z) {
        int l = m2041l(this.f1492a.c()) - this.f1492a.c();
        if (l > 0) {
            l -= m2032d(l, recycler, state);
            if (z && l > 0) {
                this.f1492a.a(-l);
            }
        }
    }

    private void m2014a(int i, State state) {
        int i2;
        int i3 = 0;
        this.f1502k.f1381a = 0;
        this.f1502k.f1382b = i;
        if (s()) {
            i2 = state.f;
            if (i2 != -1) {
                if (this.f1494c == (i2 < i)) {
                    i2 = this.f1492a.f();
                } else {
                    i3 = this.f1492a.f();
                    i2 = 0;
                }
                if (r()) {
                    this.f1502k.f1386f = i2 + this.f1492a.e();
                    this.f1502k.f1385e = -i3;
                    return;
                }
                this.f1502k.f1385e = this.f1492a.c() - i3;
                this.f1502k.f1386f = i2 + this.f1492a.d();
            }
        }
        i2 = 0;
        if (r()) {
            this.f1502k.f1386f = i2 + this.f1492a.e();
            this.f1502k.f1385e = -i3;
            return;
        }
        this.f1502k.f1385e = this.f1492a.c() - i3;
        this.f1502k.f1386f = i2 + this.f1492a.d();
    }

    private void m2024b(int i) {
        int i2 = 1;
        this.f1502k.f1384d = i;
        LayoutState layoutState = this.f1502k;
        if (this.f1494c != (i == -1)) {
            i2 = -1;
        }
        layoutState.f1383c = i2;
    }

    public final void m2078g(int i) {
        super.g(i);
        for (int i2 = 0; i2 < this.f1498g; i2++) {
            this.f1499h[i2].m2003d(i);
        }
    }

    public final void m2080h(int i) {
        super.h(i);
        for (int i2 = 0; i2 < this.f1498g; i2++) {
            this.f1499h[i2].m2003d(i);
        }
    }

    public final void m2067b(int i, int i2) {
        m2025b(i, i2, 1);
    }

    public final void m2054a(int i, int i2) {
        m2025b(i, i2, 0);
    }

    public final void m2053a() {
        this.f1497f.m1982a();
        p();
    }

    public final void m2069c(int i, int i2) {
        m2025b(i, i2, 3);
    }

    public final void m2057a(RecyclerView recyclerView, int i, int i2) {
        m2025b(i, i2, 2);
    }

    private void m2025b(int i, int i2, int i3) {
        int i4;
        int i5;
        int K = this.f1494c ? m2007K() : m2008L();
        if (i3 != 3) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + 1;
            i5 = i;
        } else {
            i4 = i + 1;
            i5 = i2;
        }
        this.f1497f.m1986b(i5);
        switch (i3) {
            case 0:
                this.f1497f.m1987b(i, i2);
                break;
            case 1:
                this.f1497f.m1983a(i, i2);
                break;
            case 3:
                this.f1497f.m1983a(i, 1);
                this.f1497f.m1987b(i2, 1);
                break;
        }
        if (i4 > K) {
            if (i5 <= (this.f1494c ? m2008L() : m2007K())) {
                p();
            }
        }
    }

    private int m2010a(Recycler recycler, LayoutState layoutState, State state) {
        int i;
        int m;
        this.f1504m.set(0, this.f1498g, true);
        if (layoutState.f1384d == 1) {
            i = layoutState.f1386f + layoutState.f1381a;
        } else {
            i = layoutState.f1385e - layoutState.f1381a;
        }
        m2035f(layoutState.f1384d, i);
        int d = this.f1494c ? this.f1492a.d() : this.f1492a.c();
        Object obj = null;
        while (layoutState.m1929a(state) && !this.f1504m.isEmpty()) {
            Span span;
            int c;
            View a = layoutState.m1928a(recycler);
            LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
            int e = layoutParams.e();
            int c2 = this.f1497f.m1988c(e);
            Object obj2 = c2 == -1 ? 1 : null;
            if (obj2 != null) {
                Span a2 = layoutParams.f1467f ? this.f1499h[0] : m2012a(layoutState);
                this.f1497f.m1984a(e, a2);
                span = a2;
            } else {
                span = this.f1499h[c2];
            }
            layoutParams.f1466e = span;
            if (layoutState.f1384d == 1) {
                b(a);
            } else {
                b(a, 0);
            }
            m2021a(a, layoutParams);
            if (layoutState.f1384d == 1) {
                if (layoutParams.f1467f) {
                    m = m2043m(d);
                } else {
                    m = span.m1998b(d);
                }
                c = m + this.f1492a.c(a);
                if (obj2 == null || !layoutParams.f1467f) {
                    c2 = m;
                } else {
                    FullSpanItem d2 = m2033d(m);
                    d2.f1469b = -1;
                    d2.f1468a = e;
                    this.f1497f.m1985a(d2);
                    c2 = m;
                }
            } else {
                if (layoutParams.f1467f) {
                    m = m2041l(d);
                } else {
                    m = span.m1994a(d);
                }
                c2 = m - this.f1492a.c(a);
                if (obj2 != null && layoutParams.f1467f) {
                    FullSpanItem j = m2039j(m);
                    j.f1469b = 1;
                    j.f1468a = e;
                    this.f1497f.m1985a(j);
                }
                c = m;
            }
            if (layoutParams.f1467f && layoutState.f1383c == -1) {
                if (obj2 == null) {
                    obj = layoutState.f1384d == 1 ? !m2005I() ? 1 : null : !m2006J() ? 1 : null;
                    if (obj != null) {
                        FullSpanItem d3 = this.f1497f.m1989d(e);
                        if (d3 != null) {
                            d3.f1471d = true;
                        }
                    }
                }
                this.f1514z = true;
            }
            m2022a(a, layoutParams, layoutState);
            int c3 = layoutParams.f1467f ? this.f1493b.c() : this.f1493b.c() + (span.f1487d * this.f1501j);
            e = c3 + this.f1493b.c(a);
            if (this.f1500i == 1) {
                m2028b(a, c3, c2, e, c);
            } else {
                m2028b(a, c2, c3, c, e);
            }
            if (layoutParams.f1467f) {
                m2035f(this.f1502k.f1384d, i);
            } else {
                m2020a(span, this.f1502k.f1384d, i);
            }
            m2016a(recycler, this.f1502k);
            obj = 1;
        }
        if (obj == null) {
            m2016a(recycler, this.f1502k);
        }
        if (this.f1502k.f1384d == -1) {
            m = this.f1492a.c() - m2041l(this.f1492a.c());
        } else {
            m = m2043m(this.f1492a.d()) - this.f1492a.d();
        }
        return m > 0 ? Math.min(layoutState.f1381a, m) : 0;
    }

    private FullSpanItem m2033d(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.f1470c = new int[this.f1498g];
        for (int i2 = 0; i2 < this.f1498g; i2++) {
            fullSpanItem.f1470c[i2] = i - this.f1499h[i2].m1998b(i);
        }
        return fullSpanItem;
    }

    private FullSpanItem m2039j(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.f1470c = new int[this.f1498g];
        for (int i2 = 0; i2 < this.f1498g; i2++) {
            fullSpanItem.f1470c[i2] = this.f1499h[i2].m1994a(i) - i;
        }
        return fullSpanItem;
    }

    private void m2022a(View view, LayoutParams layoutParams, LayoutState layoutState) {
        int i;
        if (layoutState.f1384d == 1) {
            if (layoutParams.f1467f) {
                for (i = this.f1498g - 1; i >= 0; i--) {
                    this.f1499h[i].m1999b(view);
                }
                return;
            }
            layoutParams.f1466e.m1999b(view);
        } else if (layoutParams.f1467f) {
            for (i = this.f1498g - 1; i >= 0; i--) {
                this.f1499h[i].m1995a(view);
            }
        } else {
            layoutParams.f1466e.m1995a(view);
        }
    }

    private void m2016a(Recycler recycler, LayoutState layoutState) {
        if (layoutState.f1381a == 0) {
            if (layoutState.f1384d == -1) {
                m2026b(recycler, layoutState.f1386f);
            } else {
                m2015a(recycler, layoutState.f1385e);
            }
        } else if (layoutState.f1384d == -1) {
            r0 = layoutState.f1385e;
            int i = layoutState.f1385e;
            r4 = this.f1499h[0].m1994a(i);
            for (r3 = 1; r3 < this.f1498g; r3++) {
                r5 = this.f1499h[r3].m1994a(i);
                if (r5 > r4) {
                    r4 = r5;
                }
            }
            r0 -= r4;
            if (r0 < 0) {
                r0 = layoutState.f1386f;
            } else {
                r0 = layoutState.f1386f - Math.min(r0, layoutState.f1381a);
            }
            m2026b(recycler, r0);
        } else {
            r0 = layoutState.f1386f;
            r4 = this.f1499h[0].m1998b(r0);
            for (r3 = 1; r3 < this.f1498g; r3++) {
                r5 = this.f1499h[r3].m1998b(r0);
                if (r5 < r4) {
                    r4 = r5;
                }
            }
            r0 = r4 - layoutState.f1386f;
            if (r0 < 0) {
                r0 = layoutState.f1385e;
            } else {
                r0 = Math.min(r0, layoutState.f1381a) + layoutState.f1385e;
            }
            m2015a(recycler, r0);
        }
    }

    private void m2028b(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        a(view, i + layoutParams.leftMargin, i2 + layoutParams.topMargin, i3 - layoutParams.rightMargin, i4 - layoutParams.bottomMargin);
    }

    private void m2035f(int i, int i2) {
        for (int i3 = 0; i3 < this.f1498g; i3++) {
            if (!this.f1499h[i3].f1489f.isEmpty()) {
                m2020a(this.f1499h[i3], i, i2);
            }
        }
    }

    private void m2020a(Span span, int i, int i2) {
        int i3 = span.f1486c;
        if (i == -1) {
            if (i3 + span.m1993a() <= i2) {
                this.f1504m.set(span.f1487d, false);
            }
        } else if (span.m1997b() - i3 >= i2) {
            this.f1504m.set(span.f1487d, false);
        }
    }

    private int m2041l(int i) {
        int a = this.f1499h[0].m1994a(i);
        for (int i2 = 1; i2 < this.f1498g; i2++) {
            int a2 = this.f1499h[i2].m1994a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    private boolean m2005I() {
        int b = this.f1499h[0].m1998b(Integer.MIN_VALUE);
        for (int i = 1; i < this.f1498g; i++) {
            if (this.f1499h[i].m1998b(Integer.MIN_VALUE) != b) {
                return false;
            }
        }
        return true;
    }

    private boolean m2006J() {
        int a = this.f1499h[0].m1994a(Integer.MIN_VALUE);
        for (int i = 1; i < this.f1498g; i++) {
            if (this.f1499h[i].m1994a(Integer.MIN_VALUE) != a) {
                return false;
            }
        }
        return true;
    }

    private int m2043m(int i) {
        int b = this.f1499h[0].m1998b(i);
        for (int i2 = 1; i2 < this.f1498g; i2++) {
            int b2 = this.f1499h[i2].m1998b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    private void m2015a(Recycler recycler, int i) {
        while (v() > 0) {
            View f = f(0);
            if (this.f1492a.b(f) <= i) {
                LayoutParams layoutParams = (LayoutParams) f.getLayoutParams();
                if (layoutParams.f1467f) {
                    int i2 = 0;
                    while (i2 < this.f1498g) {
                        if (this.f1499h[i2].f1489f.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.f1498g; i2++) {
                        this.f1499h[i2].m2004e();
                    }
                } else if (layoutParams.f1466e.f1489f.size() != 1) {
                    layoutParams.f1466e.m2004e();
                } else {
                    return;
                }
                a(f, recycler);
            } else {
                return;
            }
        }
    }

    private void m2026b(Recycler recycler, int i) {
        int v = v() - 1;
        while (v >= 0) {
            View f = f(v);
            if (this.f1492a.a(f) >= i) {
                LayoutParams layoutParams = (LayoutParams) f.getLayoutParams();
                if (layoutParams.f1467f) {
                    int i2 = 0;
                    while (i2 < this.f1498g) {
                        if (this.f1499h[i2].f1489f.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.f1498g; i2++) {
                        this.f1499h[i2].m2002d();
                    }
                } else if (layoutParams.f1466e.f1489f.size() != 1) {
                    layoutParams.f1466e.m2002d();
                } else {
                    return;
                }
                a(f, recycler);
                v--;
            } else {
                return;
            }
        }
    }

    private boolean m2047o(int i) {
        if (this.f1500i == 0) {
            boolean z;
            if (i == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z != this.f1494c) {
                return true;
            }
            return false;
        }
        if (((i == -1) == this.f1494c) != m2044m()) {
            return false;
        }
        return true;
    }

    private Span m2012a(LayoutState layoutState) {
        int i;
        int i2;
        Span span = null;
        int i3 = -1;
        if (m2047o(layoutState.f1384d)) {
            i = this.f1498g - 1;
            i2 = -1;
        } else {
            i = 0;
            i2 = this.f1498g;
            i3 = 1;
        }
        int c;
        int i4;
        Span span2;
        int b;
        Span span3;
        if (layoutState.f1384d == 1) {
            c = this.f1492a.c();
            i4 = i;
            i = Integer.MAX_VALUE;
            while (i4 != i2) {
                span2 = this.f1499h[i4];
                b = span2.m1998b(c);
                if (b < i) {
                    span3 = span2;
                } else {
                    b = i;
                    span3 = span;
                }
                i4 += i3;
                span = span3;
                i = b;
            }
        } else {
            c = this.f1492a.d();
            i4 = i;
            i = Integer.MIN_VALUE;
            while (i4 != i2) {
                span2 = this.f1499h[i4];
                b = span2.m1994a(c);
                if (b > i) {
                    span3 = span2;
                } else {
                    b = i;
                    span3 = span;
                }
                i4 += i3;
                span = span3;
                i = b;
            }
        }
        return span;
    }

    public final boolean m2081h() {
        return this.f1500i == 1;
    }

    public final boolean m2079g() {
        return this.f1500i == 0;
    }

    public final int m2049a(int i, Recycler recycler, State state) {
        return m2032d(i, recycler, state);
    }

    public final int m2063b(int i, Recycler recycler, State state) {
        return m2032d(i, recycler, state);
    }

    public static int m2048p(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
        if (staggeredGridLayoutManager.v() != 0) {
            if ((i < staggeredGridLayoutManager.m2008L()) != staggeredGridLayoutManager.f1494c) {
                return -1;
            }
            return 1;
        } else if (staggeredGridLayoutManager.f1494c) {
            return 1;
        } else {
            return -1;
        }
    }

    public final void m2059a(RecyclerView recyclerView, State state, int i) {
        C00812 c00812 = new LinearSmoothScroller(this, recyclerView.getContext()) {
            final /* synthetic */ StaggeredGridLayoutManager f1460a;

            public final PointF m1975a(int i) {
                int p = StaggeredGridLayoutManager.m2048p(this.f1460a, i);
                if (p == 0) {
                    return null;
                }
                if (this.f1460a.f1500i == 0) {
                    return new PointF((float) p, 0.0f);
                }
                return new PointF(0.0f, (float) p);
            }
        };
        c00812.a = i;
        a(c00812);
    }

    public final void m2073e(int i) {
        if (!(this.f1508t == null || this.f1508t.f1474a == i)) {
            SavedState savedState = this.f1508t;
            savedState.f1477d = null;
            savedState.f1476c = 0;
            savedState.f1474a = -1;
            savedState.f1475b = -1;
        }
        this.f1495d = i;
        this.f1496e = Integer.MIN_VALUE;
        p();
    }

    private int m2032d(int i, Recycler recycler, State state) {
        int i2;
        int K;
        m2040k();
        if (i > 0) {
            i2 = 1;
            K = m2007K();
        } else {
            i2 = -1;
            K = m2008L();
        }
        m2014a(K, state);
        m2024b(i2);
        this.f1502k.f1382b = K + this.f1502k.f1383c;
        i2 = Math.abs(i);
        this.f1502k.f1381a = i2;
        K = m2010a(recycler, this.f1502k, state);
        if (i2 >= K) {
            i = i < 0 ? -K : K;
        }
        this.f1492a.a(-i);
        this.f1506o = this.f1494c;
        return i;
    }

    private int m2007K() {
        int v = v();
        return v == 0 ? 0 : LayoutManager.c(f(v - 1));
    }

    private int m2008L() {
        if (v() == 0) {
            return 0;
        }
        return LayoutManager.c(f(0));
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams m2066b() {
        return new LayoutParams(-2, -2);
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams m2051a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public final android.support.v7.widget.RecyclerView.LayoutParams m2052a(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public final boolean m2062a(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }
}
