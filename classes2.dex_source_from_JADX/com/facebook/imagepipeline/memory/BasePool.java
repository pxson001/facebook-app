package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;

/* compiled from: page/%s/residence */
public abstract class BasePool<V> implements Pool<V> {
    final MemoryTrimmableRegistry f10572a;
    final PoolParams f10573b;
    @VisibleForTesting
    final SparseArray<Bucket<V>> f10574c;
    @VisibleForTesting
    final Set<V> f10575d;
    @GuardedBy("this")
    @VisibleForTesting
    final Counter f10576e;
    @GuardedBy("this")
    @VisibleForTesting
    final Counter f10577f;
    private final Class<?> f10578g = getClass();
    private boolean f10579h;
    private final PoolStatsTracker f10580i;

    @VisibleForTesting
    @NotThreadSafe
    /* compiled from: page/%s/residence */
    class Counter {
        int f10586a;
        int f10587b;

        Counter() {
        }

        public final void m15767a(int i) {
            this.f10586a++;
            this.f10587b += i;
        }

        public final void m15768b(int i) {
            if (this.f10587b < i || this.f10586a <= 0) {
                FLog.b("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.f10587b), Integer.valueOf(this.f10586a)});
                return;
            }
            this.f10586a--;
            this.f10587b -= i;
        }

        public final void m15766a() {
            this.f10586a = 0;
            this.f10587b = 0;
        }
    }

    protected abstract V mo2013b(int i);

    @VisibleForTesting
    protected abstract void mo2014b(V v);

    protected abstract int mo2015c(int i);

    protected abstract int mo2016c(V v);

    protected abstract int mo2017d(int i);

    public BasePool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        this.f10572a = (MemoryTrimmableRegistry) Preconditions.a(memoryTrimmableRegistry);
        this.f10573b = (PoolParams) Preconditions.a(poolParams);
        this.f10580i = (PoolStatsTracker) Preconditions.a(poolStatsTracker);
        this.f10574c = new SparseArray();
        m15727a(new SparseIntArray(0));
        this.f10575d = Collections.newSetFromMap(new IdentityHashMap());
        this.f10577f = new Counter();
        this.f10576e = new Counter();
    }

    protected final void m15737a() {
        this.f10572a.mo1390a(this);
        this.f10580i.mo2006a(this);
    }

    public final V mo2018a(int i) {
        V c;
        m15728c();
        int c2 = mo2015c(i);
        synchronized (this) {
            Bucket g = m15733g(c2);
            if (g != null) {
                c = g.m15761c();
                if (c != null) {
                    Preconditions.b(this.f10575d.add(c));
                    c2 = mo2016c((Object) c);
                    int d = mo2017d(c2);
                    this.f10576e.m15767a(d);
                    this.f10577f.m15768b(d);
                    this.f10580i.mo2004a(d);
                    m15734g();
                    if (FLog.a(2)) {
                        Integer.valueOf(System.identityHashCode(c));
                        Integer.valueOf(c2);
                    }
                }
            }
            int d2 = mo2017d(c2);
            if (m15735h(d2)) {
                this.f10576e.m15767a(d2);
                if (g != null) {
                    g.m15763e();
                }
                c = null;
                try {
                    c = mo2013b(c2);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f10576e.m15768b(d2);
                        Bucket g2 = m15733g(c2);
                        if (g2 != null) {
                            g2.m15764f();
                        }
                        Throwables.m15698a(th);
                    }
                    return c;
                }
                synchronized (this) {
                    Preconditions.b(this.f10575d.add(c));
                    m15730e();
                    this.f10580i.mo2009b(d2);
                    m15734g();
                    if (FLog.a(2)) {
                        Integer.valueOf(System.identityHashCode(c));
                        Integer.valueOf(c2);
                    }
                }
            } else {
                throw new PoolSizeViolationException(this.f10573b.f10497a, this.f10576e.f10587b, this.f10577f.f10587b, d2);
            }
        }
        return c;
    }

    public final void mo2019a(V v) {
        Preconditions.a(v);
        int c = mo2016c((Object) v);
        int d = mo2017d(c);
        synchronized (this) {
            Bucket g = m15733g(c);
            if (!this.f10575d.remove(v)) {
                FLog.b(this.f10578g, "release (free, value unrecognized) (object, size) = (%x, %s)", new Object[]{Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(c)});
                mo2014b((Object) v);
                this.f10580i.mo2010c(d);
            } else if (g == null || g.m15758a() || m15732f() || !mo2021d((Object) v)) {
                if (g != null) {
                    g.m15764f();
                }
                if (FLog.a(2)) {
                    Integer.valueOf(System.identityHashCode(v));
                    Integer.valueOf(c);
                }
                mo2014b((Object) v);
                this.f10576e.m15768b(d);
                this.f10580i.mo2010c(d);
            } else {
                g.m15757a(v);
                this.f10577f.m15767a(d);
                this.f10576e.m15768b(d);
                this.f10580i.mo2011d(d);
                if (FLog.a(2)) {
                    Integer.valueOf(System.identityHashCode(v));
                    Integer.valueOf(c);
                }
            }
            m15734g();
        }
    }

    public final void mo1395a(MemoryTrimType memoryTrimType) {
        m15729d();
    }

    protected boolean mo2021d(V v) {
        Preconditions.a(v);
        return true;
    }

    private synchronized void m15728c() {
        boolean z = !m15732f() || this.f10577f.f10587b == 0;
        Preconditions.b(z);
    }

    private synchronized void m15727a(SparseIntArray sparseIntArray) {
        synchronized (this) {
            Preconditions.a(sparseIntArray);
            this.f10574c.clear();
            SparseIntArray sparseIntArray2 = this.f10573b.f10499c;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.f10574c.put(keyAt, new Bucket(mo2017d(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0)));
                }
                this.f10579h = false;
            } else {
                this.f10579h = true;
            }
        }
    }

    @VisibleForTesting
    private void m15729d() {
        int i = 0;
        List arrayList = new ArrayList(this.f10574c.size());
        SparseIntArray sparseIntArray = new SparseIntArray();
        synchronized (this) {
            for (int i2 = 0; i2 < this.f10574c.size(); i2++) {
                Bucket bucket = (Bucket) this.f10574c.valueAt(i2);
                if (bucket.m15759b() > 0) {
                    arrayList.add(bucket);
                }
                sparseIntArray.put(this.f10574c.keyAt(i2), bucket.m15765g());
            }
            m15727a(sparseIntArray);
            this.f10577f.m15766a();
            m15734g();
        }
        while (i < arrayList.size()) {
            bucket = (Bucket) arrayList.get(i);
            while (true) {
                Object d = bucket.m15762d();
                if (d == null) {
                    break;
                }
                mo2014b(d);
            }
            i++;
        }
    }

    @VisibleForTesting
    private synchronized void m15730e() {
        if (m15732f()) {
            m15731f(this.f10573b.f10498b);
        }
    }

    @VisibleForTesting
    private synchronized void m15731f(int i) {
        int min = Math.min((this.f10576e.f10587b + this.f10577f.f10587b) - i, this.f10577f.f10587b);
        if (min > 0) {
            if (FLog.a(2)) {
                Integer.valueOf(i);
                Integer.valueOf(this.f10576e.f10587b + this.f10577f.f10587b);
                Integer.valueOf(min);
            }
            m15734g();
            for (int i2 = 0; i2 < this.f10574c.size() && r1 > 0; i2++) {
                Bucket bucket = (Bucket) this.f10574c.valueAt(i2);
                while (min > 0) {
                    Object d = bucket.m15762d();
                    if (d == null) {
                        break;
                    }
                    mo2014b(d);
                    min -= bucket.f10582a;
                    this.f10577f.m15768b(bucket.f10582a);
                }
            }
            m15734g();
            if (FLog.a(2)) {
                Integer.valueOf(i);
                Integer.valueOf(this.f10576e.f10587b + this.f10577f.f10587b);
            }
        }
    }

    @VisibleForTesting
    private synchronized Bucket<V> m15733g(int i) {
        Bucket<V> bucket;
        bucket = (Bucket) this.f10574c.get(i);
        if (bucket == null && this.f10579h) {
            if (FLog.a(2)) {
                Integer.valueOf(i);
            }
            bucket = mo2012e(i);
            this.f10574c.put(i, bucket);
        }
        return bucket;
    }

    Bucket<V> mo2012e(int i) {
        return new Bucket(mo2017d(i), Integer.MAX_VALUE, 0);
    }

    @VisibleForTesting
    private synchronized boolean m15732f() {
        boolean z;
        z = this.f10576e.f10587b + this.f10577f.f10587b > this.f10573b.f10498b;
        if (z) {
            this.f10580i.mo2008b();
        }
        return z;
    }

    @VisibleForTesting
    private synchronized boolean m15735h(int i) {
        boolean z = false;
        synchronized (this) {
            int i2 = this.f10573b.f10497a;
            if (i > i2 - this.f10576e.f10587b) {
                this.f10580i.ak_();
            } else {
                int i3 = this.f10573b.f10498b;
                if (i > i3 - (this.f10576e.f10587b + this.f10577f.f10587b)) {
                    m15731f(i3 - i);
                }
                if (i > i2 - (this.f10576e.f10587b + this.f10577f.f10587b)) {
                    this.f10580i.ak_();
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void m15734g() {
        if (FLog.a(2)) {
            Integer.valueOf(this.f10576e.f10586a);
            Integer.valueOf(this.f10576e.f10587b);
            Integer.valueOf(this.f10577f.f10586a);
            Integer.valueOf(this.f10577f.f10587b);
        }
    }

    public final synchronized Map<String, Integer> m15741b() {
        Map<String, Integer> hashMap;
        hashMap = new HashMap();
        for (int i = 0; i < this.f10574c.size(); i++) {
            hashMap.put("buckets_used_" + mo2017d(this.f10574c.keyAt(i)), Integer.valueOf(((Bucket) this.f10574c.valueAt(i)).m15765g()));
        }
        hashMap.put("soft_cap", Integer.valueOf(this.f10573b.f10498b));
        hashMap.put("hard_cap", Integer.valueOf(this.f10573b.f10497a));
        hashMap.put("used_count", Integer.valueOf(this.f10576e.f10586a));
        hashMap.put("used_bytes", Integer.valueOf(this.f10576e.f10587b));
        hashMap.put("free_count", Integer.valueOf(this.f10577f.f10586a));
        hashMap.put("free_bytes", Integer.valueOf(this.f10577f.f10587b));
        return hashMap;
    }
}
