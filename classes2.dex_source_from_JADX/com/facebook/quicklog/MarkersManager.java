package com.facebook.quicklog;

import android.util.SparseArray;
import com.facebook.base.lwperf.perfstats.BackgroundChecker;
import com.facebook.base.lwperf.perfstats.PerfStats;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.quicklog.driver.analytics1.DefaultStatsLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Provider;

/* compiled from: upload_queue */
class MarkersManager {
    private static final String f1624e = MarkersManager.class.getSimpleName();
    private final SparseArray<QuickEvent> f1625a = new SparseArray();
    private final ArrayList<String>[] f1626b;
    private final SparseArray<Collection<? extends Object>> f1627c = new SparseArray();
    private QuickEvent f1628d;
    private final Object f1629f = new Object();
    @GuardedBy("mGuessLock")
    private volatile Boolean f1630g;
    @GuardedBy("mLock")
    private final Object f1631h = new Object();
    private final Provider<StatsLogger> f1632i;
    private QuickEventListener[] f1633j;

    public MarkersManager(Provider<StatsLogger> provider, QuickEventListener[] quickEventListenerArr) {
        this.f1632i = provider;
        this.f1633j = quickEventListenerArr;
        this.f1626b = new ArrayList[167];
        this.f1630g = BackgroundChecker.b.e;
    }

    public final void m3271a(int i, int i2, Collection<? extends Object> collection) {
        synchronized (this.f1631h) {
            this.f1627c.put(m3262i(i, i2), collection);
        }
    }

    public final boolean m3276a(int i, int i2) {
        return m3246a(m3262i(i, i2)) != null;
    }

    public final String m3279b(int i, int i2) {
        QuickEvent a = m3246a(m3262i(i, i2));
        if (a != null) {
            return a.f469k;
        }
        return null;
    }

    public final void m3273a(QuickEvent quickEvent, TriState triState) {
        int i = m3262i(quickEvent.f465g, quickEvent.f461c);
        Poolable poolable = null;
        synchronized (this.f1631h) {
            int d;
            if (triState != null) {
                if (triState != TriState.UNSET) {
                    quickEvent.m1001a(triState, false);
                    this.f1628d = quickEvent;
                    d = m3257d(i);
                    if (d < 0) {
                        poolable = m3253c(d);
                        m3247a(d, quickEvent);
                    } else {
                        m3249b(i, quickEvent);
                    }
                    m3248a(quickEvent);
                }
            }
            quickEvent.m1006a(m3251b(), false);
            this.f1628d = quickEvent;
            d = m3257d(i);
            if (d < 0) {
                m3249b(i, quickEvent);
            } else {
                poolable = m3253c(d);
                m3247a(d, quickEvent);
            }
            m3248a(quickEvent);
        }
        if (poolable != null) {
            if (!(!BLog.b(3) || poolable.f469k == null || poolable.f469k.equals(quickEvent.f469k))) {
                String str = poolable.f469k;
                str = quickEvent.f469k;
            }
            QuickEvent.f459a.m4468a(poolable);
        }
    }

    public final void m3269a(int i, int i2, String str, long j, boolean z, boolean z2) {
        int i3 = m3262i(i, i2);
        synchronized (this.f1631h) {
            QuickEvent c;
            int d = m3257d(i3);
            if (d >= 0) {
                c = m3253c(d);
                c.f462d = j;
                c.f472n = z;
            } else {
                c = QuickEvent.m999a(i, i2, j, z, z2);
                m3249b(i3, c);
                c.f469k = str;
            }
            m3248a(c);
        }
    }

    public final boolean m3278a(int i, int i2, long j, boolean z, long j2, long j3, PerfStats perfStats, TriState triState, boolean z2) {
        int i3 = m3262i(i, i2);
        if (!m3252b(i3)) {
            return false;
        }
        synchronized (this.f1631h) {
            QuickEvent a = m3246a(i3);
            if (a == null || !a.f481w) {
                return false;
            }
            a.f462d = j;
            a.f472n = z;
            a.f479u = j;
            a.f464f = j2;
            a.f463e = j3;
            a.f478t = (short) 1;
            a.f470l = false;
            a.f476r = null;
            a.f477s = null;
            a.f473o = perfStats;
            a.f471m = z2;
            if (triState == null || triState == TriState.UNSET) {
                a.m1006a(m3251b(), true);
            } else {
                a.m1001a(triState, true);
            }
            m3250b(a);
            return true;
        }
    }

    public final void m3270a(int i, int i2, String str, String str2) {
        int i3 = m3262i(i, i2);
        if (m3252b(i3)) {
            synchronized (this.f1631h) {
                QuickEvent a = m3246a(i3);
                if (a != null && a.f481w) {
                    a.m1004a(str, str2);
                }
            }
        }
    }

    public final void m3272a(int i, int i2, Map<String, String> map) {
        int i3 = m3262i(i, i2);
        if (m3252b(i3)) {
            synchronized (this.f1631h) {
                QuickEvent a = m3246a(i3);
                if (a != null && a.f481w) {
                    for (Entry entry : map.entrySet()) {
                        a.m1004a((String) entry.getKey(), (String) entry.getValue());
                    }
                }
            }
        }
    }

    public final void m3268a(int i, int i2, String str) {
        int i3 = m3262i(i, i2);
        if (m3252b(i3)) {
            synchronized (this.f1631h) {
                QuickEvent a = m3246a(i3);
                if (a != null && a.f481w) {
                    a.m1003a(str);
                }
            }
        }
    }

    public final void m3275a(short s, String str) {
        synchronized (this.f1631h) {
            if (this.f1626b[s] == null) {
                this.f1626b[s] = new ArrayList();
            }
            this.f1626b[s].add(str);
        }
    }

    public final void m3274a(short s) {
        synchronized (this.f1631h) {
            this.f1626b[s].clear();
        }
    }

    public final boolean m3280c(int i, int i2) {
        QuickEvent a = m3246a(m3262i(i, i2));
        if (a != null) {
            return a.f470l;
        }
        return false;
    }

    public final boolean m3277a(int i, int i2, int i3) {
        boolean z = false;
        int i4 = m3262i(i, i2);
        if (m3252b(i4)) {
            synchronized (this.f1631h) {
                QuickEvent a = m3246a(i4);
                if (a != null && a.f481w && (a.f475q & i3) == 0) {
                    a.f475q |= i3;
                    z = true;
                }
            }
        }
        return z;
    }

    public final PerformanceLoggingEvent m3264a(int i, int i2, short s, long j, boolean z, long j2, String str, String str2) {
        int i3 = m3262i(i, i2);
        if (!m3252b(i3)) {
            return null;
        }
        synchronized (this.f1631h) {
            QuickEvent a = m3246a(i3);
            if (a != null) {
                if (a.f471m) {
                    ((DefaultStatsLogger) this.f1632i.get()).a(i, s, j - a.f462d);
                }
                if (a.f481w) {
                    if (str != null) {
                        a.m1004a(str, str2);
                    }
                    PerformanceLoggingEvent a2 = m3245a(a, j, j2, s, 2);
                    a.f479u = j;
                    a.f478t = s;
                    a.m1005a(z);
                    m3260e(a);
                    return a2;
                }
                return null;
            }
            return null;
        }
    }

    public final boolean m3281d(int i, int i2) {
        return m3252b(m3262i(i, i2));
    }

    public final long m3282e(int i, int i2) {
        QuickEvent a = m3246a(m3262i(i, i2));
        if (a != null) {
            return a.f462d;
        }
        return 0;
    }

    public final long m3283f(int i, int i2) {
        QuickEvent a = m3246a(m3262i(i, i2));
        if (a == null || !a.f481w) {
            a = m3246a(m3262i(i, 0));
            if (a == null || !a.f481w) {
                return 2147483647L;
            }
            return ((long) a.f466h) | (((long) a.f460b) << 32);
        }
        return ((long) a.f466h) | (((long) a.f460b) << 32);
    }

    public final PerformanceLoggingEvent m3263a(int i, int i2, short s, long j, boolean z, long j2, TriState triState) {
        PerformanceLoggingEvent a;
        int i3 = m3262i(i, i2);
        synchronized (this.f1631h) {
            QuickEvent a2 = m3246a(i3);
            if (a2 != null) {
                m3259e(i3);
                long j3 = j - a2.f462d;
                if (a2.f471m) {
                    ((DefaultStatsLogger) this.f1632i.get()).a(i, s, j3);
                }
                if (a2.f481w) {
                    a2.m1008f();
                    if (triState == null || triState == TriState.UNSET) {
                        a2.m1006a(m3251b(), false);
                    } else {
                        a2.m1001a(triState, false);
                    }
                    a = m3245a(a2, j, j2, s, 2);
                } else {
                    a = null;
                }
                a2.f479u = j;
                a2.f478t = s;
                a2.m1005a(z);
                m3255c(a2);
                QuickEvent.f459a.m4468a(a2);
            } else {
                a = null;
            }
        }
        return a;
    }

    final void m3284g(int i, int i2) {
        int i3 = m3262i(i, i2);
        synchronized (this.f1631h) {
            i3 = m3257d(i3);
            if (i3 >= 0) {
                QuickEvent c = m3253c(i3);
                m3258d(c);
                QuickEvent.f459a.m4468a(c);
                m3261f(i3);
            }
        }
    }

    final List<Long> m3267a(Object obj) {
        List<Long> arrayList = new ArrayList();
        synchronized (this.f1631h) {
            int i = 0;
            int d = m3256d();
            while (i < d) {
                QuickEvent c = m3253c(i);
                Collection collection = (Collection) this.f1627c.get(m3262i(c.f465g, c.f461c));
                if (collection == null || collection.contains(obj)) {
                    i++;
                } else {
                    arrayList.add(Long.valueOf(c.m1009g()));
                    m3261f(i);
                    m3258d(c);
                    QuickEvent.f459a.m4468a(c);
                    d--;
                }
            }
        }
        return arrayList;
    }

    final List<Integer> m3266a(int i, long j) {
        List<Integer> arrayList = new ArrayList();
        synchronized (this.f1631h) {
            int d = m3256d();
            for (int i2 = 0; i2 < d; i2++) {
                QuickEvent c = m3253c(i2);
                if (c.f465g == i && (j == -1 || c.f462d < j)) {
                    arrayList.add(Integer.valueOf(m3262i(c.f465g, c.f461c)));
                }
            }
        }
        return arrayList;
    }

    final void m3285h(int i, int i2) {
        synchronized (this.f1631h) {
            QuickEvent a = m3246a(i);
            if (a != null) {
                m3259e(i);
                a.f465g = i2;
                m3249b(i2, a);
            }
        }
    }

    final List<Long> m3265a() {
        List<Long> arrayList = new ArrayList();
        synchronized (this.f1631h) {
            int d = m3256d();
            for (int i = 0; i < d; i++) {
                QuickEvent c = m3253c(i);
                arrayList.add(Long.valueOf(c.m1009g()));
                m3258d(c);
                QuickEvent.f459a.m4468a(c);
            }
            this.f1625a.clear();
            this.f1627c.clear();
        }
        return arrayList;
    }

    private boolean m3251b() {
        boolean e = BackgroundChecker.a().e();
        if (this.f1630g == null || this.f1630g.booleanValue() != e) {
            synchronized (this.f1629f) {
                if (this.f1630g == null || this.f1630g.booleanValue() != e) {
                    this.f1630g = Boolean.valueOf(e);
                    if (this.f1630g.booleanValue()) {
                        m3254c();
                    }
                }
            }
        }
        return e;
    }

    private void m3254c() {
        synchronized (this.f1631h) {
            int d = m3256d();
            for (int i = 0; i < d; i++) {
                m3253c(i).m1006a(true, false);
            }
        }
    }

    private PerformanceLoggingEvent m3245a(QuickEvent quickEvent, long j, long j2, short s, int i) {
        PerformanceLoggingEvent performanceLoggingEvent = (PerformanceLoggingEvent) PerformanceLoggingEvent.f7929c.m4469b();
        performanceLoggingEvent.f7935i = (int) (j - quickEvent.f462d);
        performanceLoggingEvent.m12519a(quickEvent.f463e, j2);
        performanceLoggingEvent.m12522a((List) quickEvent.f476r);
        performanceLoggingEvent.m12524b(quickEvent.f477s);
        short s2 = (short) (quickEvent.f465g >> 16);
        if (s2 >= (short) 0 && s2 <= (short) 157) {
            performanceLoggingEvent.m12524b(this.f1626b[s2]);
        }
        performanceLoggingEvent.m12518a(i);
        performanceLoggingEvent.f7937k = quickEvent.f465g;
        performanceLoggingEvent.f7941o = s;
        performanceLoggingEvent.f7933g = quickEvent.f464f;
        performanceLoggingEvent.f7934h = quickEvent.f462d;
        performanceLoggingEvent.f7932f = quickEvent.f460b;
        performanceLoggingEvent.f7938l = quickEvent.f466h;
        performanceLoggingEvent.f7939m = quickEvent.f467i;
        performanceLoggingEvent.f7940n = quickEvent.f468j;
        performanceLoggingEvent.f7942p = quickEvent.f478t;
        performanceLoggingEvent.f7943q = (int) (j - quickEvent.f479u);
        performanceLoggingEvent.f7950x = quickEvent.f469k;
        performanceLoggingEvent.f7930d = quickEvent.f480v;
        performanceLoggingEvent.f7945s = quickEvent.f473o;
        performanceLoggingEvent.f7947u = quickEvent.f474p;
        return performanceLoggingEvent;
    }

    public static int m3262i(int i, int i2) {
        return (179426549 * i2) ^ i;
    }

    private QuickEvent m3246a(int i) {
        QuickEvent quickEvent;
        synchronized (this.f1625a) {
            quickEvent = (QuickEvent) this.f1625a.get(i);
        }
        return quickEvent;
    }

    private boolean m3252b(int i) {
        boolean z;
        synchronized (this.f1625a) {
            QuickEvent quickEvent = (QuickEvent) this.f1625a.get(i);
            z = quickEvent != null && quickEvent.f481w;
        }
        return z;
    }

    private QuickEvent m3253c(int i) {
        QuickEvent quickEvent;
        synchronized (this.f1625a) {
            quickEvent = (QuickEvent) this.f1625a.valueAt(i);
        }
        return quickEvent;
    }

    private int m3256d() {
        int size;
        synchronized (this.f1625a) {
            size = this.f1625a.size();
        }
        return size;
    }

    private void m3247a(int i, QuickEvent quickEvent) {
        synchronized (this.f1625a) {
            this.f1625a.setValueAt(i, quickEvent);
        }
    }

    private int m3257d(int i) {
        int indexOfKey;
        synchronized (this.f1625a) {
            indexOfKey = this.f1625a.indexOfKey(i);
        }
        return indexOfKey;
    }

    private void m3249b(int i, QuickEvent quickEvent) {
        synchronized (this.f1625a) {
            this.f1625a.put(i, quickEvent);
        }
    }

    private void m3259e(int i) {
        synchronized (this.f1625a) {
            this.f1625a.remove(i);
        }
    }

    private void m3261f(int i) {
        synchronized (this.f1625a) {
            this.f1625a.removeAt(i);
        }
    }

    private void m3248a(QuickEvent quickEvent) {
        if (this.f1633j != null) {
            for (QuickEventListener a : this.f1633j) {
                a.mo489a(quickEvent);
            }
        }
    }

    private void m3250b(QuickEvent quickEvent) {
        if (this.f1633j != null) {
            for (QuickEventListener b : this.f1633j) {
                b.mo490b(quickEvent);
            }
        }
    }

    private void m3255c(QuickEvent quickEvent) {
        if (this.f1633j != null) {
            for (QuickEventListener c : this.f1633j) {
                c.mo491c(quickEvent);
            }
        }
    }

    private void m3258d(QuickEvent quickEvent) {
        if (this.f1633j != null) {
            for (QuickEventListener d : this.f1633j) {
                d.mo492d(quickEvent);
            }
        }
    }

    private void m3260e(QuickEvent quickEvent) {
        if (this.f1633j != null) {
            for (QuickEventListener e : this.f1633j) {
                e.mo493e(quickEvent);
            }
        }
    }
}
