package com.facebook.imagepipeline.cache;

import android.os.SystemClock;
import com.android.internal.util.Predicate;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: orca_message_notifications */
public class CountingMemoryCache<K, V> implements MemoryTrimmable, MemoryCache<K, V> {
    @VisibleForTesting
    static final long f10889a = TimeUnit.MINUTES.toMillis(5);
    @GuardedBy("this")
    @VisibleForTesting
    final CountingLruMap<K, Entry<K, V>> f10890b;
    @GuardedBy("this")
    @VisibleForTesting
    final CountingLruMap<K, Entry<K, V>> f10891c;
    @GuardedBy("this")
    protected MemoryCacheParams f10892d = ((MemoryCacheParams) this.f10895g.mo2058a());
    private final ValueDescriptor<V> f10893e;
    private final CacheTrimStrategy f10894f;
    private final Supplier<MemoryCacheParams> f10895g;
    @GuardedBy("this")
    private long f10896h = SystemClock.uptimeMillis();

    /* compiled from: orca_message_notifications */
    public interface CacheTrimStrategy {
        double mo2069a(MemoryTrimType memoryTrimType);
    }

    @VisibleForTesting
    /* compiled from: orca_message_notifications */
    class Entry<K, V> {
        public final K f17864a;
        public final CloseableReference<V> f17865b;
        public int f17866c = 0;
        public boolean f17867d = false;
        @Nullable
        public final EntryStateObserver<K> f17868e;

        private Entry(K k, CloseableReference<V> closeableReference, @Nullable EntryStateObserver<K> entryStateObserver) {
            this.f17864a = Preconditions.a(k);
            this.f17865b = (CloseableReference) Preconditions.a(CloseableReference.m15680b(closeableReference));
            this.f17868e = entryStateObserver;
        }

        @VisibleForTesting
        static <K, V> Entry<K, V> m25082a(K k, CloseableReference<V> closeableReference, @Nullable EntryStateObserver<K> entryStateObserver) {
            return new Entry(k, closeableReference, entryStateObserver);
        }
    }

    public CountingMemoryCache(ValueDescriptor<V> valueDescriptor, CacheTrimStrategy cacheTrimStrategy, Supplier<MemoryCacheParams> supplier) {
        this.f10893e = valueDescriptor;
        this.f10890b = new CountingLruMap(m16122a((ValueDescriptor) valueDescriptor));
        this.f10891c = new CountingLruMap(m16122a((ValueDescriptor) valueDescriptor));
        this.f10894f = cacheTrimStrategy;
        this.f10895g = supplier;
    }

    private ValueDescriptor<Entry<K, V>> m16122a(final ValueDescriptor<V> valueDescriptor) {
        return new ValueDescriptor<Entry<K, V>>(this) {
            final /* synthetic */ CountingMemoryCache f10901b;

            public final int mo2068a(Object obj) {
                return valueDescriptor.mo2068a(((Entry) obj).f17865b.m15682a());
            }
        };
    }

    public final CloseableReference<V> mo2072a(K k, CloseableReference<V> closeableReference) {
        return m16121a(k, closeableReference, null);
    }

    private CloseableReference<V> m16121a(K k, CloseableReference<V> closeableReference, EntryStateObserver<K> entryStateObserver) {
        CloseableReference g;
        CloseableReference<V> a;
        Preconditions.a(k);
        Preconditions.a(closeableReference);
        m16132f();
        synchronized (this) {
            this.f10890b.m16158b((Object) k);
            Entry entry = (Entry) this.f10891c.m16158b((Object) k);
            if (entry != null) {
                m16130d(entry);
                g = m16134g(entry);
            } else {
                g = null;
            }
            if (m16127b(closeableReference.m15682a())) {
                entry = Entry.m25082a(k, closeableReference, entryStateObserver);
                this.f10891c.m16155a(k, entry);
                a = m16120a(entry);
            } else {
                a = null;
            }
        }
        CloseableReference.m15681c(g);
        m16135g();
        return a;
    }

    private synchronized boolean m16127b(V v) {
        boolean z;
        int a = this.f10893e.mo2068a(v);
        z = a <= this.f10892d.f10906e && m16136h() <= this.f10892d.f10903b - 1 && m16137i() <= this.f10892d.f10902a - a;
        return z;
    }

    @Nullable
    public final CloseableReference<V> mo2071a(K k) {
        CloseableReference<V> a;
        Preconditions.a(k);
        synchronized (this) {
            this.f10890b.m16158b((Object) k);
            Entry entry = (Entry) this.f10891c.m16154a((Object) k);
            if (entry != null) {
                a = m16120a(entry);
            } else {
                a = null;
            }
        }
        m16132f();
        m16135g();
        return a;
    }

    private synchronized CloseableReference<V> m16120a(final Entry<K, V> entry) {
        m16131e(entry);
        return CloseableReference.m15676a(entry.f17865b.m15682a(), new ResourceReleaser<V>(this) {
            final /* synthetic */ CountingMemoryCache f17870b;

            public final void mo2019a(V v) {
                CountingMemoryCache.m16125b(this.f17870b, entry);
            }
        });
    }

    public static void m16125b(CountingMemoryCache countingMemoryCache, Entry entry) {
        CloseableReference g;
        Preconditions.a(entry);
        synchronized (countingMemoryCache) {
            countingMemoryCache.m16133f(entry);
            countingMemoryCache.m16129c(entry);
            g = countingMemoryCache.m16134g(entry);
        }
        CloseableReference.m15681c(g);
        countingMemoryCache.m16132f();
        countingMemoryCache.m16135g();
    }

    private synchronized boolean m16129c(Entry<K, V> entry) {
        boolean z;
        if (entry.f17867d || entry.f17866c != 0) {
            z = false;
        } else {
            this.f10890b.m16155a(entry.f17864a, entry);
            z = true;
        }
        return z;
    }

    public final int mo2070a(Predicate<K> predicate) {
        ArrayList b;
        ArrayList b2;
        synchronized (this) {
            b = this.f10890b.m16159b((Predicate) predicate);
            b2 = this.f10891c.m16159b((Predicate) predicate);
            m16128c(b2);
        }
        m16124a(b2);
        m16126b(b);
        m16132f();
        m16135g();
        return b2.size();
    }

    public final void m16141a() {
        ArrayList d;
        ArrayList d2;
        synchronized (this) {
            d = this.f10890b.m16161d();
            d2 = this.f10891c.m16161d();
            m16128c(d2);
        }
        m16124a(d2);
        m16126b(d);
        m16132f();
    }

    public final synchronized boolean mo2073b(Predicate<K> predicate) {
        return !this.f10891c.m16156a((Predicate) predicate).isEmpty();
    }

    public final void mo1395a(MemoryTrimType memoryTrimType) {
        ArrayList a;
        double a2 = this.f10894f.mo2069a(memoryTrimType);
        synchronized (this) {
            a = m16123a(Integer.MAX_VALUE, Math.max(0, ((int) ((1.0d - a2) * ((double) this.f10891c.m16157b()))) - m16137i()));
            m16128c(a);
        }
        m16124a(a);
        m16126b(a);
        m16132f();
        m16135g();
    }

    private synchronized void m16132f() {
        if (this.f10896h + f10889a <= SystemClock.uptimeMillis()) {
            this.f10896h = SystemClock.uptimeMillis();
            this.f10892d = (MemoryCacheParams) this.f10895g.mo2058a();
        }
    }

    private void m16135g() {
        ArrayList a;
        synchronized (this) {
            a = m16123a(Math.min(this.f10892d.f10905d, this.f10892d.f10903b - m16136h()), Math.min(this.f10892d.f10904c, this.f10892d.f10902a - m16137i()));
            m16128c(a);
        }
        m16124a(a);
        m16126b(a);
    }

    @Nullable
    private synchronized ArrayList<Entry<K, V>> m16123a(int i, int i2) {
        ArrayList<Entry<K, V>> arrayList;
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if (this.f10890b.m16153a() > max || this.f10890b.m16157b() > max2) {
            arrayList = new ArrayList();
            while (true) {
                if (this.f10890b.m16153a() <= max && this.f10890b.m16157b() <= max2) {
                    break;
                }
                Object c = this.f10890b.m16160c();
                this.f10890b.m16158b(c);
                arrayList.add(this.f10891c.m16158b(c));
            }
        } else {
            arrayList = null;
        }
        return arrayList;
    }

    private void m16124a(@Nullable ArrayList<Entry<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                CloseableReference.m15681c(m16134g((Entry) it.next()));
            }
        }
    }

    private static void m16126b(@Nullable ArrayList<Entry<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    private synchronized void m16128c(@Nullable ArrayList<Entry<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m16130d((Entry) it.next());
            }
        }
    }

    private synchronized void m16130d(Entry<K, V> entry) {
        boolean z = true;
        synchronized (this) {
            Preconditions.a(entry);
            if (entry.f17867d) {
                z = false;
            }
            Preconditions.b(z);
            entry.f17867d = true;
        }
    }

    private synchronized void m16131e(Entry<K, V> entry) {
        Preconditions.a(entry);
        Preconditions.b(!entry.f17867d);
        entry.f17866c++;
    }

    private synchronized void m16133f(Entry<K, V> entry) {
        Preconditions.a(entry);
        Preconditions.b(entry.f17866c > 0);
        entry.f17866c--;
    }

    @Nullable
    private synchronized CloseableReference<V> m16134g(Entry<K, V> entry) {
        CloseableReference<V> closeableReference;
        Preconditions.a(entry);
        closeableReference = (entry.f17867d && entry.f17866c == 0) ? entry.f17865b : null;
        return closeableReference;
    }

    public final synchronized int m16143b() {
        return this.f10891c.m16153a();
    }

    public final synchronized int m16145c() {
        return this.f10891c.m16157b();
    }

    private synchronized int m16136h() {
        return this.f10891c.m16153a() - this.f10890b.m16153a();
    }

    private synchronized int m16137i() {
        return this.f10891c.m16157b() - this.f10890b.m16157b();
    }

    public final synchronized int m16146d() {
        return this.f10890b.m16153a();
    }

    public final synchronized int m16147e() {
        return this.f10890b.m16157b();
    }
}
