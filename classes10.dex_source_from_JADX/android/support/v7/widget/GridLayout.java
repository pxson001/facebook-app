package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.util.AttributeSet;
import android.util.LogPrinter;
import android.util.Pair;
import android.util.Printer;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.R;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: event_category_groups */
public class GridLayout extends ViewGroup {
    private static final int f13675A = 6;
    private static final Alignment f13676B = new C18553();
    private static final Alignment f13677C = new C18564();
    static final Printer f13678a = new LogPrinter(3, GridLayout.class.getName());
    static final Printer f13679b = new C18531();
    static final Alignment f13680k = new C18542();
    public static final Alignment f13681l = f13676B;
    public static final Alignment f13682m = f13677C;
    public static final Alignment f13683n = f13676B;
    public static final Alignment f13684o = f13677C;
    public static final Alignment f13685p = m13973a(f13683n, f13684o);
    public static final Alignment f13686q = m13973a(f13684o, f13683n);
    public static final Alignment f13687r = new C18586();
    public static final Alignment f13688s = new C18607();
    public static final Alignment f13689t = new C18618();
    private static final int f13690u = 0;
    private static final int f13691v = 1;
    private static final int f13692w = 2;
    private static final int f13693x = 3;
    private static final int f13694y = 4;
    private static final int f13695z = 5;
    final Axis f13696c;
    final Axis f13697d;
    int f13698e;
    boolean f13699f;
    int f13700g;
    int f13701h;
    int f13702i;
    Printer f13703j;

    /* compiled from: event_category_groups */
    final class C18531 implements Printer {
        C18531() {
        }

        public final void println(String str) {
        }
    }

    /* compiled from: event_category_groups */
    public abstract class Alignment {
        abstract int mo685a(View view, int i);

        abstract int mo686a(View view, int i, int i2);

        Alignment() {
        }

        int mo692a(int i, int i2) {
            return i;
        }

        Bounds mo691a() {
            return new Bounds();
        }
    }

    /* compiled from: event_category_groups */
    final class C18542 extends Alignment {
        C18542() {
        }

        final int mo685a(View view, int i) {
            return Integer.MIN_VALUE;
        }

        public final int mo686a(View view, int i, int i2) {
            return Integer.MIN_VALUE;
        }
    }

    /* compiled from: event_category_groups */
    final class C18553 extends Alignment {
        C18553() {
        }

        final int mo685a(View view, int i) {
            return 0;
        }

        public final int mo686a(View view, int i, int i2) {
            return 0;
        }
    }

    /* compiled from: event_category_groups */
    final class C18564 extends Alignment {
        C18564() {
        }

        final int mo685a(View view, int i) {
            return i;
        }

        public final int mo686a(View view, int i, int i2) {
            return i;
        }
    }

    /* compiled from: event_category_groups */
    final class C18575 extends Alignment {
        final /* synthetic */ Alignment f13605a;
        final /* synthetic */ Alignment f13606b;

        C18575(Alignment alignment, Alignment alignment2) {
            this.f13605a = alignment;
            this.f13606b = alignment2;
        }

        final int mo685a(View view, int i) {
            Object obj = 1;
            if (ViewCompat.h(view) != 1) {
                obj = null;
            }
            return (obj == null ? this.f13605a : this.f13606b).mo685a(view, i);
        }

        public final int mo686a(View view, int i, int i2) {
            Object obj = 1;
            if (ViewCompat.h(view) != 1) {
                obj = null;
            }
            return (obj == null ? this.f13605a : this.f13606b).mo686a(view, i, i2);
        }
    }

    /* compiled from: event_category_groups */
    final class C18586 extends Alignment {
        C18586() {
        }

        final int mo685a(View view, int i) {
            return i >> 1;
        }

        public final int mo686a(View view, int i, int i2) {
            return i >> 1;
        }
    }

    /* compiled from: event_category_groups */
    class Bounds {
        public int f13607b;
        public int f13608c;
        public int f13609d;

        public Bounds() {
            mo689a();
        }

        protected void mo689a() {
            this.f13607b = Integer.MIN_VALUE;
            this.f13608c = Integer.MIN_VALUE;
            this.f13609d = 2;
        }

        protected void mo690a(int i, int i2) {
            this.f13607b = Math.max(this.f13607b, i);
            this.f13608c = Math.max(this.f13608c, i2);
        }

        protected int mo688a(boolean z) {
            if (z || !GridLayout.m13994b(this.f13609d)) {
                return this.f13607b + this.f13608c;
            }
            return 100000;
        }

        protected int mo687a(GridLayout gridLayout, View view, Alignment alignment, int i, boolean z) {
            return this.f13607b - alignment.mo686a(view, i, ViewGroupCompat.a(gridLayout));
        }

        protected final void m13892a(GridLayout gridLayout, View view, Spec spec, Axis axis, int i) {
            this.f13609d &= spec.m13965a();
            int a = GridLayout.m13974a(spec.f13673d, axis.f13623a).mo686a(view, i, ViewGroupCompat.a(gridLayout));
            mo690a(a, i - a);
        }

        public String toString() {
            return "Bounds{before=" + this.f13607b + ", after=" + this.f13608c + '}';
        }
    }

    /* compiled from: event_category_groups */
    final class C18607 extends Alignment {

        /* compiled from: event_category_groups */
        class C18591 extends Bounds {
            final /* synthetic */ C18607 f13610a;
            private int f13611e;

            C18591(C18607 c18607) {
                this.f13610a = c18607;
            }

            protected final void mo689a() {
                super.mo689a();
                this.f13611e = Integer.MIN_VALUE;
            }

            protected final void mo690a(int i, int i2) {
                super.mo690a(i, i2);
                this.f13611e = Math.max(this.f13611e, i + i2);
            }

            protected final int mo688a(boolean z) {
                return Math.max(super.mo688a(z), this.f13611e);
            }

            protected final int mo687a(GridLayout gridLayout, View view, Alignment alignment, int i, boolean z) {
                return Math.max(0, super.mo687a(gridLayout, view, alignment, i, z));
            }
        }

        C18607() {
        }

        final int mo685a(View view, int i) {
            return 0;
        }

        public final int mo686a(View view, int i, int i2) {
            if (view.getVisibility() == 8) {
                return 0;
            }
            int baseline = view.getBaseline();
            return baseline == -1 ? Integer.MIN_VALUE : baseline;
        }

        public final Bounds mo691a() {
            return new C18591(this);
        }
    }

    /* compiled from: event_category_groups */
    final class C18618 extends Alignment {
        C18618() {
        }

        final int mo685a(View view, int i) {
            return 0;
        }

        public final int mo686a(View view, int i, int i2) {
            return Integer.MIN_VALUE;
        }

        public final int mo692a(int i, int i2) {
            return i2;
        }
    }

    /* compiled from: event_category_groups */
    final class Arc {
        public final Interval f13612a;
        public final MutableInt f13613b;
        public boolean f13614c = true;

        public Arc(Interval interval, MutableInt mutableInt) {
            this.f13612a = interval;
            this.f13613b = mutableInt;
        }

        public final String toString() {
            return this.f13612a + " " + (!this.f13614c ? "+>" : "->") + " " + this.f13613b;
        }
    }

    /* compiled from: event_category_groups */
    final class Assoc<K, V> extends ArrayList<Pair<K, V>> {
        private final Class<K> keyType;
        private final Class<V> valueType;

        private Assoc(Class<K> cls, Class<V> cls2) {
            this.keyType = cls;
            this.valueType = cls2;
        }

        public static <K, V> Assoc<K, V> m13903a(Class<K> cls, Class<V> cls2) {
            return new Assoc(cls, cls2);
        }

        public final void m13905a(K k, V v) {
            add(Pair.create(k, v));
        }

        public final PackedMap<K, V> m13904a() {
            int size = size();
            Object[] objArr = (Object[]) Array.newInstance(this.keyType, size);
            Object[] objArr2 = (Object[]) Array.newInstance(this.valueType, size);
            for (int i = 0; i < size; i++) {
                objArr[i] = ((Pair) get(i)).first;
                objArr2[i] = ((Pair) get(i)).second;
            }
            return new PackedMap(objArr, objArr2);
        }
    }

    /* compiled from: event_category_groups */
    final class Axis {
        static final /* synthetic */ boolean f13622v = (!GridLayout.class.desiredAssertionStatus());
        public final boolean f13623a;
        public int f13624b;
        PackedMap<Spec, Bounds> f13625c;
        public boolean f13626d;
        PackedMap<Interval, MutableInt> f13627e;
        public boolean f13628f;
        PackedMap<Interval, MutableInt> f13629g;
        public boolean f13630h;
        public int[] f13631i;
        public boolean f13632j;
        public int[] f13633k;
        public boolean f13634l;
        public Arc[] f13635m;
        public boolean f13636n;
        public int[] f13637o;
        public boolean f13638p;
        public boolean f13639q;
        public boolean f13640r;
        public int[] f13641s;
        public int[] f13642t;
        boolean f13643u;
        final /* synthetic */ GridLayout f13644w;
        private int f13645x;
        private MutableInt f13646y;
        private MutableInt f13647z;

        public Axis(GridLayout gridLayout, boolean z) {
            this.f13644w = gridLayout;
            this.f13624b = Integer.MIN_VALUE;
            this.f13645x = Integer.MIN_VALUE;
            this.f13626d = false;
            this.f13628f = false;
            this.f13630h = false;
            this.f13632j = false;
            this.f13634l = false;
            this.f13636n = false;
            this.f13638p = false;
            this.f13640r = false;
            this.f13643u = true;
            this.f13646y = new MutableInt(0);
            this.f13647z = new MutableInt(-100000);
            this.f13623a = z;
        }

        private int m13929h() {
            int childCount = this.f13644w.getChildCount();
            int i = -1;
            for (int i2 = 0; i2 < childCount; i2++) {
                LayoutParams a = GridLayout.m13975a(this.f13644w.getChildAt(i2));
                Interval interval = (this.f13623a ? a.f13665b : a.f13664a).f13672c;
                i = Math.max(Math.max(Math.max(i, interval.f13648a), interval.f13649b), interval.m13955a());
            }
            return i == -1 ? Integer.MIN_VALUE : i;
        }

        private int m13930i() {
            if (this.f13645x == Integer.MIN_VALUE) {
                this.f13645x = Math.max(0, m13929h());
            }
            return this.f13645x;
        }

        public final int m13943a() {
            return Math.max(this.f13624b, m13930i());
        }

        public final void m13944a(int i) {
            if (i != Integer.MIN_VALUE && i < m13930i()) {
                GridLayout.m13992b((this.f13623a ? "column" : "row") + "Count must be greater than or equal to the maximum of all grid indices (and spans) defined in the LayoutParams of each child");
            }
            this.f13624b = i;
        }

        public final void m13945a(boolean z) {
            this.f13643u = z;
            m13953f();
        }

        private PackedMap<Spec, Bounds> m13931j() {
            Assoc a = Assoc.m13903a(Spec.class, Bounds.class);
            int childCount = this.f13644w.getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams a2 = GridLayout.m13975a(this.f13644w.getChildAt(i));
                Object obj = this.f13623a ? a2.f13665b : a2.f13664a;
                a.m13905a(obj, GridLayout.m13974a(obj.f13673d, this.f13623a).mo691a());
            }
            return a.m13904a();
        }

        private void m13932k() {
            Bounds[] boundsArr = (Bounds[]) this.f13625c.f13669c;
            for (Bounds a : boundsArr) {
                a.mo689a();
            }
            int childCount = this.f13644w.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f13644w.getChildAt(i);
                LayoutParams a2 = GridLayout.m13975a(childAt);
                Spec spec = this.f13623a ? a2.f13665b : a2.f13664a;
                ((Bounds) this.f13625c.m13964a(i)).m13892a(this.f13644w, childAt, spec, this, spec.f13674e == 0.0f ? this.f13644w.m14001a(childAt, this.f13623a) : m13940s()[i] + m13941t()[i]);
            }
        }

        public final PackedMap<Spec, Bounds> m13948b() {
            if (this.f13625c == null) {
                this.f13625c = m13931j();
            }
            if (!this.f13626d) {
                m13932k();
                this.f13626d = true;
            }
            return this.f13625c;
        }

        private PackedMap<Interval, MutableInt> m13920b(boolean z) {
            Assoc a = Assoc.m13903a(Interval.class, MutableInt.class);
            Spec[] specArr = (Spec[]) m13948b().f13668b;
            int length = specArr.length;
            for (int i = 0; i < length; i++) {
                a.m13905a(z ? specArr[i].f13672c : specArr[i].f13672c.m13956b(), new MutableInt());
            }
            return a.m13904a();
        }

        private void m13910a(PackedMap<Interval, MutableInt> packedMap, boolean z) {
            int i = 0;
            MutableInt[] mutableIntArr = (MutableInt[]) packedMap.f13669c;
            for (MutableInt a : mutableIntArr) {
                a.m13961a();
            }
            Bounds[] boundsArr = (Bounds[]) m13948b().f13669c;
            while (i < boundsArr.length) {
                int a2 = boundsArr[i].mo688a(z);
                MutableInt mutableInt = (MutableInt) packedMap.m13964a(i);
                int i2 = mutableInt.f13666a;
                if (!z) {
                    a2 = -a2;
                }
                mutableInt.f13666a = Math.max(i2, a2);
                i++;
            }
        }

        private PackedMap<Interval, MutableInt> m13933l() {
            if (this.f13627e == null) {
                this.f13627e = m13920b(true);
            }
            if (!this.f13628f) {
                m13910a(this.f13627e, true);
                this.f13628f = true;
            }
            return this.f13627e;
        }

        private PackedMap<Interval, MutableInt> m13934m() {
            if (this.f13629g == null) {
                this.f13629g = m13920b(false);
            }
            if (!this.f13630h) {
                m13910a(this.f13629g, false);
                this.f13630h = true;
            }
            return this.f13629g;
        }

        private static void m13913a(List<Arc> list, Interval interval, MutableInt mutableInt, boolean z) {
            if (interval.m13955a() != 0) {
                if (z) {
                    for (Arc arc : list) {
                        if (arc.f13612a.equals(interval)) {
                            return;
                        }
                    }
                }
                list.add(new Arc(interval, mutableInt));
            }
        }

        private void m13912a(List<Arc> list, Interval interval, MutableInt mutableInt) {
            m13913a(list, interval, mutableInt, true);
        }

        final Arc[][] m13946a(Arc[] arcArr) {
            int i;
            int i2;
            int i3 = 0;
            int a = m13943a() + 1;
            Arc[][] arcArr2 = new Arc[a][];
            int[] iArr = new int[a];
            for (Arc arc : arcArr) {
                int i4 = arc.f13612a.f13648a;
                iArr[i4] = iArr[i4] + 1;
            }
            for (i = 0; i < a; i++) {
                arcArr2[i] = new Arc[iArr[i]];
            }
            Arrays.fill(iArr, 0);
            i = arcArr.length;
            while (i3 < i) {
                Arc arc2 = arcArr[i3];
                i2 = arc2.f13612a.f13648a;
                Arc[] arcArr3 = arcArr2[i2];
                int i5 = iArr[i2];
                iArr[i2] = i5 + 1;
                arcArr3[i5] = arc2;
                i3++;
            }
            return arcArr2;
        }

        private Arc[] m13923b(final Arc[] arcArr) {
            return new Object(this) {
                static final /* synthetic */ boolean f13615e = (!GridLayout.class.desiredAssertionStatus());
                Arc[] f13616a = new Arc[arcArr.length];
                int f13617b = (this.f13616a.length - 1);
                Arc[][] f13618c = this.f13621g.m13946a(arcArr);
                int[] f13619d = new int[(this.f13621g.m13943a() + 1)];
                final /* synthetic */ Axis f13621g;

                private void m13906a(int i) {
                    switch (this.f13619d[i]) {
                        case 0:
                            this.f13619d[i] = 1;
                            for (Arc arc : this.f13618c[i]) {
                                m13906a(arc.f13612a.f13649b);
                                Arc[] arcArr = this.f13616a;
                                int i2 = this.f13617b;
                                this.f13617b = i2 - 1;
                                arcArr[i2] = arc;
                            }
                            this.f13619d[i] = 2;
                            return;
                        case 1:
                            if (!f13615e) {
                                throw new AssertionError();
                            }
                            return;
                        default:
                            return;
                    }
                }

                final Arc[] m13907a() {
                    int length = this.f13618c.length;
                    for (int i = 0; i < length; i++) {
                        m13906a(i);
                    }
                    if (f13615e || this.f13617b == -1) {
                        return this.f13616a;
                    }
                    throw new AssertionError();
                }
            }.m13907a();
        }

        private Arc[] m13918a(List<Arc> list) {
            return m13923b((Arc[]) list.toArray(new Arc[list.size()]));
        }

        private void m13914a(List<Arc> list, PackedMap<Interval, MutableInt> packedMap) {
            for (int i = 0; i < ((Interval[]) packedMap.f13668b).length; i++) {
                m13913a(list, ((Interval[]) packedMap.f13668b)[i], ((MutableInt[]) packedMap.f13669c)[i], false);
            }
        }

        private Arc[] m13935n() {
            int i;
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            m13914a(arrayList, m13933l());
            m13914a(arrayList2, m13934m());
            if (this.f13643u) {
                for (i = 0; i < m13943a(); i++) {
                    m13912a(arrayList, new Interval(i, i + 1), new MutableInt(0));
                }
            }
            i = m13943a();
            m13913a(arrayList, new Interval(0, i), this.f13646y, false);
            m13913a(arrayList2, new Interval(i, 0), this.f13647z, false);
            return (Arc[]) GridLayout.m13986a(m13918a(arrayList), m13918a(arrayList2));
        }

        private void m13936o() {
            m13933l();
            m13934m();
        }

        private Arc[] m13937p() {
            if (this.f13635m == null) {
                this.f13635m = m13935n();
            }
            if (!this.f13636n) {
                m13936o();
                this.f13636n = true;
            }
            return this.f13635m;
        }

        private static boolean m13917a(int[] iArr, Arc arc) {
            if (!arc.f13614c) {
                return false;
            }
            Interval interval = arc.f13612a;
            int i = interval.f13648a;
            int i2 = interval.f13649b;
            i = iArr[i] + arc.f13613b.f13666a;
            if (i <= iArr[i2]) {
                return false;
            }
            iArr[i2] = i;
            return true;
        }

        private static void m13915a(int[] iArr) {
            Arrays.fill(iArr, 0);
        }

        private String m13921b(List<Arc> list) {
            String str = this.f13623a ? "x" : "y";
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = stringBuilder;
            Object obj = 1;
            for (Arc arc : list) {
                String str2;
                if (obj != null) {
                    obj = null;
                } else {
                    stringBuilder2 = stringBuilder2.append(", ");
                }
                int i = arc.f13612a.f13648a;
                int i2 = arc.f13612a.f13649b;
                int i3 = arc.f13613b.f13666a;
                if (i < i2) {
                    str2 = str + i2 + "-" + str + i + ">=" + i3;
                } else {
                    str2 = str + i + "-" + str + i2 + "<=" + (-i3);
                }
                stringBuilder2.append(str2);
            }
            return stringBuilder2.toString();
        }

        private void m13911a(String str, Arc[] arcArr, boolean[] zArr) {
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            for (int i = 0; i < arcArr.length; i++) {
                Arc arc = arcArr[i];
                if (zArr[i]) {
                    arrayList.add(arc);
                }
                if (!arc.f13614c) {
                    arrayList2.add(arc);
                }
            }
            this.f13644w.f13703j.println(str + " constraints: " + m13921b(arrayList) + " are inconsistent; permanently removing: " + m13921b(arrayList2) + ". ");
        }

        private void m13916a(Arc[] arcArr, int[] iArr) {
            String str = this.f13623a ? "horizontal" : "vertical";
            int a = m13943a() + 1;
            boolean[] zArr = null;
            for (int i = 0; i < arcArr.length; i++) {
                m13915a(iArr);
                int i2 = 0;
                while (i2 < a) {
                    int i3 = 0;
                    for (Arc a2 : arcArr) {
                        i3 |= m13917a(iArr, a2);
                    }
                    if (i3 != 0) {
                        i2++;
                    } else if (zArr != null) {
                        m13911a(str, arcArr, zArr);
                        return;
                    } else {
                        return;
                    }
                }
                boolean[] zArr2 = new boolean[arcArr.length];
                for (i2 = 0; i2 < a; i2++) {
                    int length = arcArr.length;
                    for (i3 = 0; i3 < length; i3++) {
                        zArr2[i3] = zArr2[i3] | m13917a(iArr, arcArr[i3]);
                    }
                }
                if (i == 0) {
                    zArr = zArr2;
                }
                for (i3 = 0; i3 < arcArr.length; i3++) {
                    if (zArr2[i3]) {
                        Arc arc = arcArr[i3];
                        if (arc.f13612a.f13648a >= arc.f13612a.f13649b) {
                            arc.f13614c = false;
                            break;
                        }
                    }
                }
            }
        }

        private void m13924c(boolean z) {
            int[] iArr = z ? this.f13631i : this.f13633k;
            int childCount = this.f13644w.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f13644w.getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    LayoutParams a = GridLayout.m13975a(childAt);
                    Interval interval = (this.f13623a ? a.f13665b : a.f13664a).f13672c;
                    int i2 = z ? interval.f13648a : interval.f13649b;
                    iArr[i2] = Math.max(iArr[i2], this.f13644w.m14002a(childAt, this.f13623a, z));
                }
            }
        }

        public final int[] m13950c() {
            if (this.f13631i == null) {
                this.f13631i = new int[(m13943a() + 1)];
            }
            if (!this.f13632j) {
                m13924c(true);
                this.f13632j = true;
            }
            return this.f13631i;
        }

        public final int[] m13951d() {
            if (this.f13633k == null) {
                this.f13633k = new int[(m13943a() + 1)];
            }
            if (!this.f13634l) {
                m13924c(false);
                this.f13634l = true;
            }
            return this.f13633k;
        }

        private void m13922b(int[] iArr) {
            m13916a(m13937p(), iArr);
        }

        private boolean m13938q() {
            int childCount = this.f13644w.getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams a = GridLayout.m13975a(this.f13644w.getChildAt(i));
                if ((this.f13623a ? a.f13665b : a.f13664a).f13674e != 0.0f) {
                    return true;
                }
            }
            return false;
        }

        private boolean m13939r() {
            if (!this.f13640r) {
                this.f13639q = m13938q();
                this.f13640r = true;
            }
            return this.f13639q;
        }

        private int[] m13940s() {
            if (this.f13641s == null) {
                this.f13641s = new int[this.f13644w.getChildCount()];
            }
            return this.f13641s;
        }

        public static void m13926d(Axis axis, int i) {
            if (axis.m13939r()) {
                axis.m13940s()[i] = axis.f13644w.m14001a(axis.f13644w.getChildAt(i), axis.f13623a);
            }
        }

        private int[] m13941t() {
            if (this.f13642t == null) {
                this.f13642t = new int[this.f13644w.getChildCount()];
            }
            return this.f13642t;
        }

        private void m13942u() {
            int i = 0;
            int childCount = this.f13644w.getChildCount();
            int i2 = 0;
            float f = 0.0f;
            int i3 = 0;
            while (i2 < childCount) {
                int a;
                View childAt = this.f13644w.getChildAt(i2);
                LayoutParams a2 = GridLayout.m13975a(childAt);
                float f2 = (this.f13623a ? a2.f13665b : a2.f13664a).f13674e;
                if (f2 != 0.0f) {
                    f2 += f;
                    a = i3 + (GridLayout.m13995c(childAt, this.f13623a) - m13940s()[i2]);
                } else {
                    f2 = f;
                    a = i3;
                }
                i2++;
                i3 = a;
                f = f2;
            }
            i2 = this.f13644w.getChildCount();
            while (i < i2) {
                a2 = GridLayout.m13975a(this.f13644w.getChildAt(i));
                f2 = (this.f13623a ? a2.f13665b : a2.f13664a).f13674e;
                if (f2 != 0.0f) {
                    childCount = Math.round((((float) i3) * f2) / f);
                    this.f13642t[i] = childCount;
                    f2 = f - f2;
                    a = i3 - childCount;
                } else {
                    f2 = f;
                    a = i3;
                }
                i++;
                i3 = a;
                f = f2;
            }
        }

        private void m13925c(int[] iArr) {
            Arrays.fill(m13941t(), 0);
            m13922b(iArr);
            m13942u();
            this.f13636n = false;
            this.f13628f = false;
            this.f13630h = false;
            this.f13626d = false;
            m13922b(iArr);
        }

        private void m13927d(int[] iArr) {
            int i = 0;
            if (m13939r()) {
                m13925c(iArr);
            } else {
                m13922b(iArr);
            }
            if (!this.f13643u) {
                int i2 = iArr[0];
                int length = iArr.length;
                while (i < length) {
                    iArr[i] = iArr[i] - i2;
                    i++;
                }
            }
        }

        public final int[] m13952e() {
            if (this.f13637o == null) {
                this.f13637o = new int[(m13943a() + 1)];
            }
            if (!this.f13638p) {
                m13927d(this.f13637o);
                this.f13638p = true;
            }
            return this.f13637o;
        }

        private int m13928e(int[] iArr) {
            return iArr[m13943a()];
        }

        private void m13908a(int i, int i2) {
            this.f13646y.f13666a = i;
            this.f13647z.f13666a = -i2;
            this.f13638p = false;
        }

        private int m13919b(int i, int i2) {
            m13908a(i, i2);
            return m13928e(m13952e());
        }

        public final int m13947b(int i) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            switch (mode) {
                case Integer.MIN_VALUE:
                    return m13919b(0, size);
                case 0:
                    return m13919b(0, 100000);
                case 1073741824:
                    return m13919b(size, size);
                default:
                    if (f13622v) {
                        return 0;
                    }
                    throw new AssertionError();
            }
        }

        public final void m13949c(int i) {
            m13908a(i, i);
            m13952e();
        }

        public final void m13953f() {
            this.f13645x = Integer.MIN_VALUE;
            this.f13625c = null;
            this.f13627e = null;
            this.f13629g = null;
            this.f13631i = null;
            this.f13633k = null;
            this.f13635m = null;
            this.f13637o = null;
            this.f13641s = null;
            this.f13642t = null;
            this.f13640r = false;
            m13954g();
        }

        public final void m13954g() {
            this.f13626d = false;
            this.f13628f = false;
            this.f13630h = false;
            this.f13632j = false;
            this.f13634l = false;
            this.f13636n = false;
            this.f13638p = false;
        }
    }

    /* compiled from: event_category_groups */
    final class Interval {
        public final int f13648a;
        public final int f13649b;

        public Interval(int i, int i2) {
            this.f13648a = i;
            this.f13649b = i2;
        }

        final int m13955a() {
            return this.f13649b - this.f13648a;
        }

        final Interval m13956b() {
            return new Interval(this.f13649b, this.f13648a);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Interval interval = (Interval) obj;
            if (this.f13649b != interval.f13649b) {
                return false;
            }
            if (this.f13648a != interval.f13648a) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return (this.f13648a * 31) + this.f13649b;
        }

        public final String toString() {
            return "[" + this.f13648a + ", " + this.f13649b + "]";
        }
    }

    /* compiled from: event_category_groups */
    public class LayoutParams extends MarginLayoutParams {
        private static final Interval f13650c;
        private static final int f13651d;
        private static final int f13652e = 2;
        private static final int f13653f = 3;
        private static final int f13654g = 4;
        private static final int f13655h = 5;
        private static final int f13656i = 6;
        private static final int f13657j = 10;
        private static final int f13658k = 11;
        private static final int f13659l = 12;
        private static final int f13660m = 7;
        private static final int f13661n = 8;
        private static final int f13662o = 9;
        private static final int f13663p = 13;
        public Spec f13664a;
        public Spec f13665b;

        static {
            Interval interval = new Interval(Integer.MIN_VALUE, -2147483647);
            f13650c = interval;
            f13651d = interval.m13955a();
        }

        private LayoutParams(int i, int i2, int i3, int i4, int i5, int i6, Spec spec, Spec spec2) {
            super(i, i2);
            this.f13664a = Spec.f13670a;
            this.f13665b = Spec.f13670a;
            setMargins(i3, i4, i5, i6);
            this.f13664a = spec;
            this.f13665b = spec2;
        }

        private LayoutParams(Spec spec, Spec spec2) {
            this(-2, -2, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, spec, spec2);
        }

        public LayoutParams() {
            this(Spec.f13670a, Spec.f13670a);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f13664a = Spec.f13670a;
            this.f13665b = Spec.f13670a;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f13664a = Spec.f13670a;
            this.f13665b = Spec.f13670a;
            m13957a(context, attributeSet);
            m13958b(context, attributeSet);
        }

        private void m13957a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridLayout_Layout);
            try {
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(f13652e, Integer.MIN_VALUE);
                this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(f13653f, dimensionPixelSize);
                this.topMargin = obtainStyledAttributes.getDimensionPixelSize(f13654g, dimensionPixelSize);
                this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(f13655h, dimensionPixelSize);
                this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(f13656i, dimensionPixelSize);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        private void m13958b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridLayout_Layout);
            try {
                int i = obtainStyledAttributes.getInt(f13663p, 0);
                this.f13665b = GridLayout.m13978a(obtainStyledAttributes.getInt(f13657j, Integer.MIN_VALUE), obtainStyledAttributes.getInt(f13658k, f13651d), GridLayout.m13972a(i, true), obtainStyledAttributes.getFloat(f13659l, 0.0f));
                this.f13664a = GridLayout.m13978a(obtainStyledAttributes.getInt(f13660m, Integer.MIN_VALUE), obtainStyledAttributes.getInt(f13661n, f13651d), GridLayout.m13972a(i, false), obtainStyledAttributes.getFloat(f13662o, 0.0f));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        protected void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            this.width = typedArray.getLayoutDimension(i, -2);
            this.height = typedArray.getLayoutDimension(i2, -2);
        }

        final void m13959a(Interval interval) {
            this.f13664a = this.f13664a.m13966a(interval);
        }

        final void m13960b(Interval interval) {
            this.f13665b = this.f13665b.m13966a(interval);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            LayoutParams layoutParams = (LayoutParams) obj;
            if (!this.f13665b.equals(layoutParams.f13665b)) {
                return false;
            }
            if (this.f13664a.equals(layoutParams.f13664a)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f13664a.hashCode() * 31) + this.f13665b.hashCode();
        }
    }

    /* compiled from: event_category_groups */
    final class MutableInt {
        public int f13666a;

        public MutableInt() {
            m13961a();
        }

        public MutableInt(int i) {
            this.f13666a = i;
        }

        public final void m13961a() {
            this.f13666a = Integer.MIN_VALUE;
        }

        public final String toString() {
            return Integer.toString(this.f13666a);
        }
    }

    /* compiled from: event_category_groups */
    final class PackedMap<K, V> {
        public final int[] f13667a;
        public final K[] f13668b;
        public final V[] f13669c;

        public PackedMap(K[] kArr, V[] vArr) {
            this.f13667a = m13962a((Object[]) kArr);
            this.f13668b = m13963a(kArr, this.f13667a);
            this.f13669c = m13963a(vArr, this.f13667a);
        }

        public final V m13964a(int i) {
            return this.f13669c[this.f13667a[i]];
        }

        private static <K> int[] m13962a(K[] kArr) {
            int length = kArr.length;
            int[] iArr = new int[length];
            Map hashMap = new HashMap();
            for (int i = 0; i < length; i++) {
                Object obj = kArr[i];
                Integer num = (Integer) hashMap.get(obj);
                if (num == null) {
                    num = Integer.valueOf(hashMap.size());
                    hashMap.put(obj, num);
                }
                iArr[i] = num.intValue();
            }
            return iArr;
        }

        private static <K> K[] m13963a(K[] kArr, int[] iArr) {
            int length = kArr.length;
            Object[] objArr = (Object[]) Array.newInstance(kArr.getClass().getComponentType(), GridLayout.m13971a(iArr, -1) + 1);
            for (int i = 0; i < length; i++) {
                objArr[iArr[i]] = kArr[i];
            }
            return objArr;
        }
    }

    /* compiled from: event_category_groups */
    public class Spec {
        static final Spec f13670a = GridLayout.m13976a(Integer.MIN_VALUE);
        final boolean f13671b;
        final Interval f13672c;
        final Alignment f13673d;
        final float f13674e;

        private Spec(boolean z, Interval interval, Alignment alignment, float f) {
            this.f13671b = z;
            this.f13672c = interval;
            this.f13673d = alignment;
            this.f13674e = f;
        }

        private Spec(boolean z, int i, int i2, Alignment alignment, float f) {
            this(z, new Interval(i, i + i2), alignment, f);
        }

        final Spec m13966a(Interval interval) {
            return new Spec(this.f13671b, interval, this.f13673d, this.f13674e);
        }

        final int m13965a() {
            return (this.f13673d == GridLayout.f13680k && this.f13674e == 0.0f) ? 0 : 2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Spec spec = (Spec) obj;
            if (!this.f13673d.equals(spec.f13673d)) {
                return false;
            }
            if (this.f13672c.equals(spec.f13672c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f13672c.hashCode() * 31) + this.f13673d.hashCode();
        }
    }

    public GridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13696c = new Axis(this, true);
        this.f13697d = new Axis(this, false);
        this.f13698e = 0;
        this.f13699f = false;
        this.f13700g = 1;
        this.f13702i = 0;
        this.f13703j = f13678a;
        this.f13701h = context.getResources().getDimensionPixelOffset(2131432068);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridLayout);
        try {
            setRowCount(obtainStyledAttributes.getInt(f13691v, Integer.MIN_VALUE));
            setColumnCount(obtainStyledAttributes.getInt(f13692w, Integer.MIN_VALUE));
            setOrientation(obtainStyledAttributes.getInt(f13690u, 0));
            setUseDefaultMargins(obtainStyledAttributes.getBoolean(f13693x, false));
            setAlignmentMode(obtainStyledAttributes.getInt(f13694y, 1));
            setRowOrderPreserved(obtainStyledAttributes.getBoolean(f13695z, true));
            setColumnOrderPreserved(obtainStyledAttributes.getBoolean(f13675A, true));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public GridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GridLayout(Context context) {
        this(context, null);
    }

    public int getOrientation() {
        return this.f13698e;
    }

    public void setOrientation(int i) {
        if (this.f13698e != i) {
            this.f13698e = i;
            m13997c();
            requestLayout();
        }
    }

    public int getRowCount() {
        return this.f13697d.m13943a();
    }

    public void setRowCount(int i) {
        this.f13697d.m13944a(i);
        m13997c();
        requestLayout();
    }

    public int getColumnCount() {
        return this.f13696c.m13943a();
    }

    public void setColumnCount(int i) {
        this.f13696c.m13944a(i);
        m13997c();
        requestLayout();
    }

    public boolean getUseDefaultMargins() {
        return this.f13699f;
    }

    public void setUseDefaultMargins(boolean z) {
        this.f13699f = z;
        requestLayout();
    }

    public int getAlignmentMode() {
        return this.f13700g;
    }

    public void setAlignmentMode(int i) {
        this.f13700g = i;
        requestLayout();
    }

    public void setRowOrderPreserved(boolean z) {
        this.f13697d.m13945a(z);
        m13997c();
        requestLayout();
    }

    public void setColumnOrderPreserved(boolean z) {
        this.f13696c.m13945a(z);
        m13997c();
        requestLayout();
    }

    public Printer getPrinter() {
        return this.f13703j;
    }

    public void setPrinter(Printer printer) {
        if (printer == null) {
            printer = f13679b;
        }
        this.f13703j = printer;
    }

    static int m13971a(int[] iArr, int i) {
        for (int max : iArr) {
            i = Math.max(i, max);
        }
        return i;
    }

    static <T> T[] m13986a(T[] tArr, T[] tArr2) {
        Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), tArr.length + tArr2.length);
        System.arraycopy(tArr, 0, objArr, 0, tArr.length);
        System.arraycopy(tArr2, 0, objArr, tArr.length, tArr2.length);
        return objArr;
    }

    static Alignment m13972a(int i, boolean z) {
        switch (((z ? 7 : 112) & i) >> (z ? 0 : 4)) {
            case 1:
                return f13687r;
            case 3:
                return z ? f13685p : f13681l;
            case 5:
                return z ? f13686q : f13682m;
            case 7:
                return f13689t;
            case 8388611:
                return f13683n;
            case 8388613:
                return f13684o;
            default:
                return f13680k;
        }
    }

    private int m13987b(View view) {
        if (view.getClass() == Space.class) {
            return 0;
        }
        return this.f13701h / 2;
    }

    private int m13989b(View view, boolean z, boolean z2) {
        return m13987b(view);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m13970a(android.view.View r5, android.support.v7.widget.GridLayout.LayoutParams r6, boolean r7, boolean r8) {
        /*
        r4 = this;
        r1 = 0;
        r0 = r4.f13699f;
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        r0 = r1;
    L_0x0006:
        return r0;
    L_0x0007:
        if (r7 == 0) goto L_0x0028;
    L_0x0009:
        r0 = r6.f13665b;
        r2 = r0;
    L_0x000c:
        if (r7 == 0) goto L_0x002c;
    L_0x000e:
        r0 = r4.f13696c;
    L_0x0010:
        r2 = r2.f13672c;
        if (r7 == 0) goto L_0x002f;
    L_0x0014:
        r3 = r4.m13984a();
        if (r3 == 0) goto L_0x002f;
    L_0x001a:
        if (r8 != 0) goto L_0x001d;
    L_0x001c:
        r1 = 1;
    L_0x001d:
        if (r1 == 0) goto L_0x0031;
    L_0x001f:
        r0 = r2.f13648a;
        if (r0 == 0) goto L_0x0023;
    L_0x0023:
        r0 = r4.m13989b(r5, r7, r8);
        goto L_0x0006;
    L_0x0028:
        r0 = r6.f13664a;
        r2 = r0;
        goto L_0x000c;
    L_0x002c:
        r0 = r4.f13697d;
        goto L_0x0010;
    L_0x002f:
        r1 = r8;
        goto L_0x001d;
    L_0x0031:
        r0.m13943a();
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.GridLayout.a(android.view.View, android.support.v7.widget.GridLayout$LayoutParams, boolean, boolean):int");
    }

    final int m14002a(View view, boolean z, boolean z2) {
        LayoutParams a = m13975a(view);
        int i = z ? z2 ? a.leftMargin : a.rightMargin : z2 ? a.topMargin : a.bottomMargin;
        return i == Integer.MIN_VALUE ? m13970a(view, a, z, z2) : i;
    }

    private boolean m13984a() {
        return ViewCompat.h(this) == 1;
    }

    private int m13996c(View view, boolean z, boolean z2) {
        if (this.f13700g == 1) {
            return m14002a(view, z, z2);
        }
        Axis axis = z ? this.f13696c : this.f13697d;
        int[] c = z2 ? axis.m13950c() : axis.m13951d();
        LayoutParams a = m13975a(view);
        Spec spec = z ? a.f13665b : a.f13664a;
        return c[z2 ? spec.f13672c.f13648a : spec.f13672c.f13649b];
    }

    private int m13988b(View view, boolean z) {
        return m13996c(view, z, true) + m13996c(view, z, false);
    }

    private static boolean m13985a(int[] iArr, int i, int i2, int i3) {
        if (i3 > iArr.length) {
            return false;
        }
        while (i2 < i3) {
            if (iArr[i2] > i) {
                return false;
            }
            i2++;
        }
        return true;
    }

    private static void m13993b(int[] iArr, int i, int i2, int i3) {
        int length = iArr.length;
        Arrays.fill(iArr, Math.min(i, length), Math.min(i2, length), i3);
    }

    private static void m13980a(LayoutParams layoutParams, int i, int i2, int i3, int i4) {
        layoutParams.m13959a(new Interval(i, i + i2));
        layoutParams.m13960b(new Interval(i3, i3 + i4));
    }

    private static int m13968a(Interval interval, boolean z, int i) {
        int a = interval.m13955a();
        if (i == 0) {
            return a;
        }
        return Math.min(a, i - (z ? Math.min(interval.f13648a, i) : 0));
    }

    private void m13991b() {
        int i;
        Object obj = this.f13698e == 0 ? 1 : null;
        Axis axis = obj != null ? this.f13696c : this.f13697d;
        if (axis.f13624b != Integer.MIN_VALUE) {
            i = axis.f13624b;
        } else {
            i = 0;
        }
        int[] iArr = new int[i];
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            int i5;
            LayoutParams layoutParams = (LayoutParams) getChildAt(i4).getLayoutParams();
            Spec spec = obj != null ? layoutParams.f13664a : layoutParams.f13665b;
            Interval interval = spec.f13672c;
            boolean z = spec.f13671b;
            int a = interval.m13955a();
            if (z) {
                i3 = interval.f13648a;
            }
            spec = obj != null ? layoutParams.f13665b : layoutParams.f13664a;
            interval = spec.f13672c;
            boolean z2 = spec.f13671b;
            int a2 = m13968a(interval, z2, i);
            if (z2) {
                i5 = interval.f13648a;
            } else {
                i5 = i2;
            }
            if (i != 0) {
                if (!(z && z2)) {
                    while (!m13985a(iArr, i3, i5, i5 + a2)) {
                        if (z2) {
                            i3++;
                        } else if (i5 + a2 <= i) {
                            i5++;
                        } else {
                            i3++;
                            i5 = 0;
                        }
                    }
                }
                m13993b(iArr, i5, i5 + a2, i3 + a);
            }
            if (obj != null) {
                m13980a(layoutParams, i3, a, i5, a2);
            } else {
                m13980a(layoutParams, i5, a2, i3, a);
            }
            i2 = i5 + a2;
        }
    }

    private void m13997c() {
        this.f13702i = 0;
        if (this.f13696c != null) {
            this.f13696c.m13953f();
        }
        if (this.f13697d != null) {
            this.f13697d.m13953f();
        }
        m13998d();
    }

    private void m13998d() {
        if (this.f13696c != null && this.f13697d != null) {
            this.f13696c.m13954g();
            this.f13697d.m13954g();
        }
    }

    static LayoutParams m13975a(View view) {
        return (LayoutParams) view.getLayoutParams();
    }

    public static void m13992b(String str) {
        throw new IllegalArgumentException(str + ". ");
    }

    private void m13981a(LayoutParams layoutParams, boolean z) {
        String str = z ? "column" : "row";
        Interval interval = (z ? layoutParams.f13665b : layoutParams.f13664a).f13672c;
        if (interval.f13648a != Integer.MIN_VALUE && interval.f13648a < 0) {
            m13992b(str + " indices must be positive");
        }
        int i = (z ? this.f13696c : this.f13697d).f13624b;
        if (i != Integer.MIN_VALUE) {
            if (interval.f13649b > i) {
                m13992b(str + " indices (start + span) mustn't exceed the " + str + " count");
            }
            if (interval.m13955a() > i) {
                m13992b(str + " span mustn't exceed the " + str + " count");
            }
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams)) {
            return false;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        m13981a(layoutParams2, true);
        m13981a(layoutParams2, false);
        return true;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    private int m13999f() {
        int i = 1;
        int childCount = getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            int hashCode;
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                hashCode = ((LayoutParams) childAt.getLayoutParams()).hashCode() + (i * 31);
            } else {
                hashCode = i;
            }
            i2++;
            i = hashCode;
        }
        return i;
    }

    private void m14000g() {
        if (this.f13702i == 0) {
            m13991b();
            this.f13702i = m13999f();
        } else if (this.f13702i != m13999f()) {
            this.f13703j.println("The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
            m13997c();
            m14000g();
        }
    }

    private void m13982a(View view, int i, int i2, int i3, int i4) {
        view.measure(getChildMeasureSpec(i, m13988b(view, true), i3), getChildMeasureSpec(i2, m13988b(view, false), i4));
    }

    private void m13979a(int i, int i2, boolean z) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                android.view.ViewGroup.LayoutParams a = m13975a(childAt);
                if (z) {
                    m13982a(childAt, i, i2, a.width, a.height);
                    Axis.m13926d(this.f13696c, i3);
                    Axis.m13926d(this.f13697d, i3);
                } else {
                    boolean z2 = this.f13698e == 0;
                    Spec spec = z2 ? a.f13665b : a.f13664a;
                    if (spec.f13673d == f13689t) {
                        Interval interval = spec.f13672c;
                        int[] e = (z2 ? this.f13696c : this.f13697d).m13952e();
                        int b = (e[interval.f13649b] - e[interval.f13648a]) - m13988b(childAt, z2);
                        if (z2) {
                            m13982a(childAt, i, i2, b, a.height);
                        } else {
                            m13982a(childAt, i, i2, a.width, b);
                        }
                    }
                }
            }
        }
    }

    private static int m13967a(int i, int i2) {
        return MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i + i2), MeasureSpec.getMode(i));
    }

    protected void onMeasure(int i, int i2) {
        int b;
        int b2;
        m14000g();
        m13998d();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int a = m13967a(i, -paddingLeft);
        int a2 = m13967a(i2, -paddingTop);
        m13979a(a, a2, true);
        if (this.f13698e == 0) {
            b = this.f13696c.m13947b(a);
            m13979a(a, a2, false);
            b2 = this.f13697d.m13947b(a2);
        } else {
            b2 = this.f13697d.m13947b(a2);
            m13979a(a, a2, false);
            b = this.f13696c.m13947b(a);
        }
        setMeasuredDimension(ViewCompat.a(Math.max(b + paddingLeft, getSuggestedMinimumWidth()), i, 0), ViewCompat.a(Math.max(b2 + paddingTop, getSuggestedMinimumHeight()), i2, 0));
    }

    private static int m13995c(View view, boolean z) {
        return z ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    final int m14001a(View view, boolean z) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return m13995c(view, z) + m13988b(view, z);
    }

    public void requestLayout() {
        super.requestLayout();
        m13997c();
    }

    static Alignment m13974a(Alignment alignment, boolean z) {
        if (alignment != f13680k) {
            return alignment;
        }
        return z ? f13683n : f13688s;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        m14000g();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        this.f13696c.m13949c((i5 - paddingLeft) - paddingRight);
        this.f13697d.m13949c((i6 - paddingTop) - paddingBottom);
        int[] e = this.f13696c.m13952e();
        int[] e2 = this.f13697d.m13952e();
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams a = m13975a(childAt);
                Spec spec = a.f13665b;
                Spec spec2 = a.f13664a;
                Interval interval = spec.f13672c;
                Interval interval2 = spec2.f13672c;
                int i8 = e[interval.f13648a];
                int i9 = e2[interval2.f13648a];
                int i10 = e[interval.f13649b] - i8;
                int i11 = e2[interval2.f13649b] - i9;
                int c = m13995c(childAt, true);
                int c2 = m13995c(childAt, false);
                Alignment a2 = m13974a(spec.f13673d, true);
                Alignment a3 = m13974a(spec2.f13673d, false);
                Bounds bounds = (Bounds) this.f13696c.m13948b().m13964a(i7);
                Bounds bounds2 = (Bounds) this.f13697d.m13948b().m13964a(i7);
                int a4 = a2.mo685a(childAt, i10 - bounds.mo688a(true));
                int a5 = a3.mo685a(childAt, i11 - bounds2.mo688a(true));
                int c3 = m13996c(childAt, true, true);
                int c4 = m13996c(childAt, false, true);
                int c5 = m13996c(childAt, true, false);
                int i12 = c3 + c5;
                int c6 = c4 + m13996c(childAt, false, false);
                i6 = bounds.mo687a(this, childAt, a2, c + i12, true);
                paddingBottom = bounds2.mo687a(this, childAt, a3, c2 + c6, false);
                int a6 = a2.mo692a(c, i10 - i12);
                int a7 = a3.mo692a(c2, i11 - c6);
                i6 += i8 + a4;
                i6 = !m13984a() ? i6 + (paddingLeft + c3) : (((i5 - a6) - paddingRight) - c5) - i6;
                paddingBottom = (paddingBottom + ((paddingTop + i9) + a5)) + c4;
                if (!(a6 == childAt.getMeasuredWidth() && a7 == childAt.getMeasuredHeight())) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(a6, 1073741824), MeasureSpec.makeMeasureSpec(a7, 1073741824));
                }
                childAt.layout(i6, paddingBottom, a6 + i6, a7 + paddingBottom);
            }
        }
    }

    public static Spec m13978a(int i, int i2, Alignment alignment, float f) {
        return new Spec(i != Integer.MIN_VALUE, i, i2, alignment, f);
    }

    private static Spec m13977a(int i, int i2, Alignment alignment) {
        return m13978a(i, i2, alignment, 0.0f);
    }

    private static Spec m13990b(int i, int i2) {
        return m13977a(i, i2, f13680k);
    }

    public static Spec m13976a(int i) {
        return m13990b(i, 1);
    }

    private static Alignment m13973a(Alignment alignment, Alignment alignment2) {
        return new C18575(alignment, alignment2);
    }

    static boolean m13994b(int i) {
        return (i & 2) != 0;
    }
}
