package com.facebook.cache;

import com.facebook.analytics.cache.CacheCounterType;
import com.facebook.analytics.cache.CacheTracker;
import com.facebook.cache.common.CacheEventListener.EvictionReason;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.inject.Lazy;
import com.google.common.base.Preconditions;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: selfupdate_start_showing_activity */
public class TrackedLruCache<K, V> implements MemoryTrimmable {
    private final LinkedHashMap<K, V> f5709a;
    private int f5710b;
    private int f5711c;
    private int f5712d;
    private int f5713e;
    private int f5714f;
    private int f5715g;
    private int f5716h;
    private final int f5717i;
    private final int f5718j;
    private final CacheTracker f5719k;
    private final Lazy<FbErrorReporter> f5720l;
    public final LimitType f5721m;

    /* compiled from: selfupdate_start_showing_activity */
    public class Factory {
        private com.facebook.analytics.cache.CacheTracker.Factory f5703a;
        private Lazy<FbErrorReporter> f5704b;
        public MemoryTrimmableRegistry f5705c;

        public Factory(com.facebook.analytics.cache.CacheTracker.Factory factory, Lazy<FbErrorReporter> lazy, MemoryTrimmableRegistry memoryTrimmableRegistry) {
            this.f5703a = (com.facebook.analytics.cache.CacheTracker.Factory) Preconditions.checkNotNull(factory, "CacheTracker.Factory cannot be null");
            this.f5704b = (Lazy) Preconditions.checkNotNull(lazy, "FbErrorReporter cannot be null");
            this.f5705c = (MemoryTrimmableRegistry) Preconditions.checkNotNull(memoryTrimmableRegistry, "MemoryTrimmableRegistry cannot be null");
        }

        public final <K, V> TrackedLruCache<K, V> m9821a(int i, String str) {
            return new TrackedLruCache(i, this.f5703a.m9188a(str), this.f5704b, LimitType.COUNT);
        }

        public final <K, V> TrackedLruCache<K, V> m9822a(int i, String str, LruCacheListener<K, V> lruCacheListener) {
            return m9819a(i, Integer.MAX_VALUE, str, lruCacheListener, LimitType.COUNT);
        }

        private <K, V> TrackedLruCache<K, V> m9820d(int i, String str, LruCacheListener<K, V> lruCacheListener) {
            return m9819a(Integer.MAX_VALUE, i, str, lruCacheListener, LimitType.SIZE);
        }

        private <K, V> TrackedLruCache<K, V> m9819a(int i, int i2, String str, LruCacheListener<K, V> lruCacheListener, LimitType limitType) {
            Preconditions.checkNotNull(lruCacheListener);
            final LruCacheListener<K, V> lruCacheListener2 = lruCacheListener;
            return new TrackedLruCache<K, V>(this, i, i2, 0, this.f5703a.m9188a(str), this.f5704b, limitType) {
                final /* synthetic */ Factory f5708b;

                protected final int mo1394b(K k, V v) {
                    return lruCacheListener2.mo1392a(k, v);
                }

                public final void mo1393a(boolean z, K k, V v, @Nullable V v2) {
                    lruCacheListener2.mo1391a(z, k, v, v2);
                }
            };
        }

        public final <K, V> TrackedLruCache<K, V> m9823b(int i, String str) {
            Object a = m9821a(i, str);
            this.f5705c.mo1390a(a);
            return a;
        }

        public final <K, V> TrackedLruCache<K, V> m9824c(int i, String str, LruCacheListener<K, V> lruCacheListener) {
            Object d = m9820d(i, str, lruCacheListener);
            this.f5705c.mo1390a(d);
            return d;
        }
    }

    /* compiled from: selfupdate_start_showing_activity */
    public enum LimitType {
        COUNT,
        SIZE,
        COUNT_AND_SIZE
    }

    protected TrackedLruCache(int i, CacheTracker cacheTracker, Lazy<FbErrorReporter> lazy, LimitType limitType) {
        this(i, Integer.MAX_VALUE, cacheTracker, lazy, limitType);
    }

    private TrackedLruCache(int i, int i2, CacheTracker cacheTracker, Lazy<FbErrorReporter> lazy, LimitType limitType) {
        this(i, i2, 0, cacheTracker, lazy, limitType);
    }

    public TrackedLruCache(int i, int i2, int i3, CacheTracker cacheTracker, Lazy<FbErrorReporter> lazy, LimitType limitType) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i <= 0) {
            throw new IllegalArgumentException("maxEntries <= 0");
        } else {
            this.f5717i = i3;
            this.f5711c = i2;
            this.f5718j = i;
            this.f5709a = new LinkedHashMap(0, 0.75f, true);
            this.f5719k = cacheTracker;
            this.f5720l = lazy;
            this.f5721m = limitType;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V m9841a(K r5) {
        /*
        r4 = this;
        if (r5 != 0) goto L_0x000a;
    L_0x0002:
        r0 = new java.lang.NullPointerException;
        r1 = "key == null";
        r0.<init>(r1);
        throw r0;
    L_0x000a:
        monitor-enter(r4);
        r0 = r4.f5709a;	 Catch:{ all -> 0x0032 }
        r0 = r0.get(r5);	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x001f;
    L_0x0013:
        r1 = r4.f5715g;	 Catch:{ all -> 0x0032 }
        r1 = r1 + 1;
        r4.f5715g = r1;	 Catch:{ all -> 0x0032 }
        r1 = 1;
        r4.m9836c(r1);	 Catch:{ all -> 0x0032 }
        monitor-exit(r4);	 Catch:{ all -> 0x0032 }
    L_0x001e:
        return r0;
    L_0x001f:
        r0 = r4.f5716h;	 Catch:{ all -> 0x0032 }
        r0 = r0 + 1;
        r4.f5716h = r0;	 Catch:{ all -> 0x0032 }
        r0 = 1;
        r4.m9838d(r0);	 Catch:{ all -> 0x0032 }
        monitor-exit(r4);	 Catch:{ all -> 0x0032 }
        r1 = m9837d();
        if (r1 != 0) goto L_0x0035;
    L_0x0030:
        r0 = 0;
        goto L_0x001e;
    L_0x0032:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{  }
        throw r0;
    L_0x0035:
        monitor-enter(r4);
        r0 = r4.f5713e;	 Catch:{ all -> 0x0060 }
        r0 = r0 + 1;
        r4.f5713e = r0;	 Catch:{ all -> 0x0060 }
        r0 = r4.f5709a;	 Catch:{ all -> 0x0060 }
        r0 = r0.put(r5, r1);	 Catch:{ all -> 0x0060 }
        if (r0 == 0) goto L_0x0051;
    L_0x0044:
        r2 = r4.f5709a;	 Catch:{ all -> 0x0060 }
        r2.put(r5, r0);	 Catch:{ all -> 0x0060 }
    L_0x0049:
        monitor-exit(r4);	 Catch:{ all -> 0x0060 }
        if (r0 == 0) goto L_0x0063;
    L_0x004c:
        r2 = 0;
        r4.mo1393a(r2, r5, r1, r0);
        goto L_0x001e;
    L_0x0051:
        r2 = r4.f5710b;	 Catch:{  }
        r3 = r4.m9835c(r5, r1);	 Catch:{  }
        r2 = r2 + r3;
        r4.f5710b = r2;	 Catch:{  }
        r2 = r4.f5710b;	 Catch:{  }
        r4.m9840f(r2);	 Catch:{  }
        goto L_0x0049;
    L_0x0060:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{  }
        throw r0;
    L_0x0063:
        r0 = r4.f5711c;
        r4.m9832a(r0);
        r0 = r1;
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.cache.TrackedLruCache.a(java.lang.Object):V");
    }

    public final V m9842a(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        V put;
        synchronized (this) {
            this.f5712d++;
            this.f5710b += m9835c(k, v);
            put = this.f5709a.put(k, v);
            if (put != null) {
                this.f5710b -= m9835c(k, put);
            }
            m9840f(this.f5710b);
        }
        if (put != null) {
            mo1393a(false, k, put, v);
        }
        m9833a(this.f5711c, this.f5718j);
        return put;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m9832a(int r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.f5710b;	 Catch:{ all -> 0x003f }
        if (r0 > r6) goto L_0x0007;
    L_0x0005:
        monitor-exit(r5);	 Catch:{ all -> 0x003f }
    L_0x0006:
        return;
    L_0x0007:
        monitor-exit(r5);	 Catch:{ all -> 0x003f }
        r0 = 0;
        r1 = r0;
    L_0x000a:
        monitor-enter(r5);
        r0 = r5.f5710b;	 Catch:{ all -> 0x003c }
        if (r0 < 0) goto L_0x001b;
    L_0x000f:
        r0 = r5.f5709a;	 Catch:{ all -> 0x003c }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x003c }
        if (r0 == 0) goto L_0x0042;
    L_0x0017:
        r0 = r5.f5710b;	 Catch:{ all -> 0x003c }
        if (r0 == 0) goto L_0x0042;
    L_0x001b:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x003c }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x003c }
        r1.<init>();	 Catch:{ all -> 0x003c }
        r2 = r5.getClass();	 Catch:{ all -> 0x003c }
        r2 = r2.getName();	 Catch:{ all -> 0x003c }
        r1 = r1.append(r2);	 Catch:{ all -> 0x003c }
        r2 = ".sizeOf() is reporting inconsistent results!";
        r1 = r1.append(r2);	 Catch:{ all -> 0x003c }
        r1 = r1.toString();	 Catch:{ all -> 0x003c }
        r0.<init>(r1);	 Catch:{ all -> 0x003c }
        throw r0;	 Catch:{ all -> 0x003c }
    L_0x003c:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x003c }
        throw r0;
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{  }
        throw r0;
    L_0x0042:
        r0 = r5.f5717i;	 Catch:{  }
        if (r1 < r0) goto L_0x004a;
    L_0x0046:
        r0 = r5.f5710b;	 Catch:{  }
        if (r0 <= r6) goto L_0x0052;
    L_0x004a:
        r0 = r5.f5709a;	 Catch:{  }
        r0 = r0.isEmpty();	 Catch:{  }
        if (r0 == 0) goto L_0x0057;
    L_0x0052:
        monitor-exit(r5);	 Catch:{  }
        r5.m9839e(r1);
        goto L_0x0006;
    L_0x0057:
        r0 = r5.f5709a;	 Catch:{  }
        r0 = r0.entrySet();	 Catch:{  }
        r0 = r0.iterator();	 Catch:{  }
        r0 = r0.next();	 Catch:{  }
        r0 = (java.util.Map.Entry) r0;	 Catch:{  }
        r2 = r0.getKey();	 Catch:{  }
        r3 = r0.getValue();	 Catch:{  }
        r0 = r5.f5709a;	 Catch:{  }
        r0.remove(r2);	 Catch:{  }
        r0 = r5.f5710b;	 Catch:{  }
        r4 = r5.m9835c(r2, r3);	 Catch:{  }
        r0 = r0 - r4;
        r5.f5710b = r0;	 Catch:{  }
        r0 = r5.f5710b;	 Catch:{  }
        r5.m9840f(r0);	 Catch:{  }
        r0 = r5.f5714f;	 Catch:{  }
        r0 = r0 + 1;
        r5.f5714f = r0;	 Catch:{  }
        r0 = r1 + 1;
        monitor-exit(r5);	 Catch:{  }
        r1 = 1;
        r4 = 0;
        r5.mo1393a(r1, r2, r3, r4);
        r1 = r0;
        goto L_0x000a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.cache.TrackedLruCache.a(int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m9834b(int r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.f5709a;	 Catch:{ all -> 0x0028 }
        r0 = r0.size();	 Catch:{ all -> 0x0028 }
        if (r0 > r6) goto L_0x000b;
    L_0x0009:
        monitor-exit(r5);	 Catch:{ all -> 0x0028 }
    L_0x000a:
        return;
    L_0x000b:
        monitor-exit(r5);	 Catch:{ all -> 0x0028 }
        r0 = 0;
        r1 = r0;
    L_0x000e:
        monitor-enter(r5);
        r0 = r5.f5717i;	 Catch:{ all -> 0x0066 }
        if (r1 < r0) goto L_0x001b;
    L_0x0013:
        r0 = r5.f5709a;	 Catch:{ all -> 0x0066 }
        r0 = r0.size();	 Catch:{ all -> 0x0066 }
        if (r0 <= r6) goto L_0x0023;
    L_0x001b:
        r0 = r5.f5709a;	 Catch:{ all -> 0x0066 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0066 }
        if (r0 == 0) goto L_0x002b;
    L_0x0023:
        monitor-exit(r5);	 Catch:{ all -> 0x0066 }
        r5.m9839e(r1);
        goto L_0x000a;
    L_0x0028:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{  }
        throw r0;
    L_0x002b:
        r0 = r5.f5709a;	 Catch:{  }
        r0 = r0.entrySet();	 Catch:{  }
        r0 = r0.iterator();	 Catch:{  }
        r0 = r0.next();	 Catch:{  }
        r0 = (java.util.Map.Entry) r0;	 Catch:{  }
        r2 = r0.getKey();	 Catch:{  }
        r3 = r0.getValue();	 Catch:{  }
        r0 = r5.f5709a;	 Catch:{  }
        r0.remove(r2);	 Catch:{  }
        r0 = r5.f5710b;	 Catch:{  }
        r4 = r5.m9835c(r2, r3);	 Catch:{  }
        r0 = r0 - r4;
        r5.f5710b = r0;	 Catch:{  }
        r0 = r5.f5710b;	 Catch:{  }
        r5.m9840f(r0);	 Catch:{  }
        r0 = r5.f5714f;	 Catch:{  }
        r0 = r0 + 1;
        r5.f5714f = r0;	 Catch:{  }
        r0 = r1 + 1;
        monitor-exit(r5);	 Catch:{  }
        r1 = 1;
        r4 = 0;
        r5.mo1393a(r1, r2, r3, r4);
        r1 = r0;
        goto L_0x000e;
    L_0x0066:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{  }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.cache.TrackedLruCache.b(int):void");
    }

    private void m9833a(int i, int i2) {
        m9832a(i);
        m9834b(i2);
    }

    public final V m9848b(K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        V remove;
        synchronized (this) {
            remove = this.f5709a.remove(k);
            if (remove != null) {
                this.f5710b -= m9835c(k, remove);
                m9840f(this.f5710b);
            }
        }
        if (remove != null) {
            mo1393a(false, k, remove, null);
        }
        return remove;
    }

    protected void mo1393a(boolean z, K k, V v, V v2) {
    }

    private static V m9837d() {
        return null;
    }

    private int m9835c(K k, V v) {
        int b = mo1394b(k, v);
        if (b >= 0) {
            return b;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    protected int mo1394b(K k, V v) {
        return 1;
    }

    private void m9836c(int i) {
        this.f5719k.m9302a((long) i);
    }

    private void m9838d(int i) {
        this.f5719k.m9305b((long) i);
    }

    private void m9839e(int i) {
        this.f5719k.mo1344a(EvictionReason.CACHE_FULL, i, 0);
    }

    private void m9840f(int i) {
        this.f5719k.m9307c((long) i);
        this.f5719k.m9309d((long) m9846b());
        if (m9846b() > 0) {
            Object obj;
            if (this.f5721m.equals(LimitType.SIZE) || this.f5721m.equals(LimitType.COUNT_AND_SIZE)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                ((AbstractFbErrorReporter) this.f5720l.get()).mo345c(this.f5719k.m9300a(CacheCounterType.BYTES_COUNT), Integer.toString(i));
            }
            if (this.f5721m.equals(LimitType.COUNT) || this.f5721m.equals(LimitType.COUNT_AND_SIZE)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                ((AbstractFbErrorReporter) this.f5720l.get()).mo345c(this.f5719k.m9300a(CacheCounterType.ENTRIES_COUNT), Integer.toString(m9846b()));
                return;
            }
            return;
        }
        ((AbstractFbErrorReporter) this.f5720l.get()).mo337a(this.f5719k.m9300a(CacheCounterType.BYTES_COUNT));
        ((AbstractFbErrorReporter) this.f5720l.get()).mo337a(this.f5719k.m9300a(CacheCounterType.ENTRIES_COUNT));
    }

    public final void m9843a() {
        m9832a(-1);
    }

    public final synchronized int m9846b() {
        return this.f5709a.size();
    }

    public final synchronized Map<K, V> m9849c() {
        return new LinkedHashMap(this.f5709a);
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.f5715g + this.f5716h;
            if (i2 != 0) {
                i = (this.f5715g * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f5711c), Integer.valueOf(this.f5715g), Integer.valueOf(this.f5716h), Integer.valueOf(i)});
        }
        return format;
    }

    public final void mo1395a(MemoryTrimType memoryTrimType) {
        if (memoryTrimType != MemoryTrimType.OnAppBackgrounded) {
            m9833a(Integer.MAX_VALUE, (int) ((1.0d - memoryTrimType.getSuggestedTrimRatio()) * ((double) m9846b())));
        }
    }
}
