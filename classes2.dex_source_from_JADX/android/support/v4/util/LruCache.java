package android.support.v4.util;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: tree_diff_enabled */
public class LruCache<K, V> {
    private final LinkedHashMap<K, V> f2254a;
    private int f2255b;
    private int f2256c;
    private int f2257d;
    private int f2258e;
    private int f2259f;
    private int f2260g;
    private int f2261h;
    private final int f2262i;
    private final int f2263j;

    public LruCache(int i) {
        this(Integer.MAX_VALUE, i);
    }

    private LruCache(int i, int i2) {
        this(i, i2, 0);
    }

    private LruCache(int i, int i2, int i3) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("maxEntries <= 0");
        } else {
            this.f2262i = i3;
            this.f2256c = i;
            this.f2263j = i2;
            this.f2254a = new LinkedHashMap(0, 0.75f, true);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V m4432a(K r5) {
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
        r0 = r4.f2254a;	 Catch:{ all -> 0x002a }
        r0 = r0.get(r5);	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x001b;
    L_0x0013:
        r1 = r4.f2260g;	 Catch:{ all -> 0x002a }
        r1 = r1 + 1;
        r4.f2260g = r1;	 Catch:{ all -> 0x002a }
        monitor-exit(r4);	 Catch:{ all -> 0x002a }
    L_0x001a:
        return r0;
    L_0x001b:
        r0 = r4.f2261h;	 Catch:{ all -> 0x002a }
        r0 = r0 + 1;
        r4.f2261h = r0;	 Catch:{ all -> 0x002a }
        monitor-exit(r4);	 Catch:{ all -> 0x002a }
        r1 = m4431e();
        if (r1 != 0) goto L_0x002d;
    L_0x0028:
        r0 = 0;
        goto L_0x001a;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{  }
        throw r0;
    L_0x002d:
        monitor-enter(r4);
        r0 = r4.f2258e;	 Catch:{ all -> 0x0053 }
        r0 = r0 + 1;
        r4.f2258e = r0;	 Catch:{ all -> 0x0053 }
        r0 = r4.f2254a;	 Catch:{ all -> 0x0053 }
        r0 = r0.put(r5, r1);	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0049;
    L_0x003c:
        r2 = r4.f2254a;	 Catch:{ all -> 0x0053 }
        r2.put(r5, r0);	 Catch:{ all -> 0x0053 }
    L_0x0041:
        monitor-exit(r4);	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0056;
    L_0x0044:
        r2 = 0;
        r4.mo2670a(r2, r5, r1, r0);
        goto L_0x001a;
    L_0x0049:
        r2 = r4.f2255b;	 Catch:{  }
        r3 = r4.m4430c(r5, r1);	 Catch:{  }
        r2 = r2 + r3;
        r4.f2255b = r2;	 Catch:{  }
        goto L_0x0041;
    L_0x0053:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{  }
        throw r0;
    L_0x0056:
        r0 = r4.f2256c;
        r4.m4427a(r0);
        r0 = r1;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.LruCache.a(java.lang.Object):V");
    }

    public final V m4433a(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        V put;
        synchronized (this) {
            this.f2257d++;
            this.f2255b += m4430c(k, v);
            put = this.f2254a.put(k, v);
            if (put != null) {
                this.f2255b -= m4430c(k, put);
            }
        }
        if (put != null) {
            mo2670a(false, k, put, v);
        }
        m4428a(this.f2256c, this.f2263j);
        return put;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4427a(int r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.f2255b;	 Catch:{ all -> 0x003f }
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
        r0 = r5.f2255b;	 Catch:{ all -> 0x003c }
        if (r0 < 0) goto L_0x001b;
    L_0x000f:
        r0 = r5.f2254a;	 Catch:{ all -> 0x003c }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x003c }
        if (r0 == 0) goto L_0x0042;
    L_0x0017:
        r0 = r5.f2255b;	 Catch:{ all -> 0x003c }
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
        r0 = r5.f2262i;	 Catch:{  }
        if (r1 < r0) goto L_0x004a;
    L_0x0046:
        r0 = r5.f2255b;	 Catch:{  }
        if (r0 <= r6) goto L_0x0052;
    L_0x004a:
        r0 = r5.f2254a;	 Catch:{  }
        r0 = r0.isEmpty();	 Catch:{  }
        if (r0 == 0) goto L_0x0054;
    L_0x0052:
        monitor-exit(r5);	 Catch:{  }
        goto L_0x0006;
    L_0x0054:
        r0 = r5.f2254a;	 Catch:{  }
        r0 = r0.entrySet();	 Catch:{  }
        r0 = r0.iterator();	 Catch:{  }
        r0 = r0.next();	 Catch:{  }
        r0 = (java.util.Map.Entry) r0;	 Catch:{  }
        r2 = r0.getKey();	 Catch:{  }
        r3 = r0.getValue();	 Catch:{  }
        r0 = r5.f2254a;	 Catch:{  }
        r0.remove(r2);	 Catch:{  }
        r0 = r5.f2255b;	 Catch:{  }
        r4 = r5.m4430c(r2, r3);	 Catch:{  }
        r0 = r0 - r4;
        r5.f2255b = r0;	 Catch:{  }
        r0 = r5.f2259f;	 Catch:{  }
        r0 = r0 + 1;
        r5.f2259f = r0;	 Catch:{  }
        r0 = r1 + 1;
        monitor-exit(r5);	 Catch:{  }
        r1 = 1;
        r4 = 0;
        r5.mo2670a(r1, r2, r3, r4);
        r1 = r0;
        goto L_0x000a;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.LruCache.a(int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4429b(int r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.f2254a;	 Catch:{ all -> 0x0028 }
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
        r0 = r5.f2262i;	 Catch:{ all -> 0x0025 }
        if (r1 < r0) goto L_0x001b;
    L_0x0013:
        r0 = r5.f2254a;	 Catch:{ all -> 0x0025 }
        r0 = r0.size();	 Catch:{ all -> 0x0025 }
        if (r0 <= r6) goto L_0x0023;
    L_0x001b:
        r0 = r5.f2254a;	 Catch:{ all -> 0x0025 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0025 }
        if (r0 == 0) goto L_0x002b;
    L_0x0023:
        monitor-exit(r5);	 Catch:{ all -> 0x0025 }
        goto L_0x000a;
    L_0x0025:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0025 }
        throw r0;
    L_0x0028:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{  }
        throw r0;
    L_0x002b:
        r0 = r5.f2254a;	 Catch:{  }
        r0 = r0.entrySet();	 Catch:{  }
        r0 = r0.iterator();	 Catch:{  }
        r0 = r0.next();	 Catch:{  }
        r0 = (java.util.Map.Entry) r0;	 Catch:{  }
        r2 = r0.getKey();	 Catch:{  }
        r3 = r0.getValue();	 Catch:{  }
        r0 = r5.f2254a;	 Catch:{  }
        r0.remove(r2);	 Catch:{  }
        r0 = r5.f2255b;	 Catch:{  }
        r4 = r5.m4430c(r2, r3);	 Catch:{  }
        r0 = r0 - r4;
        r5.f2255b = r0;	 Catch:{  }
        r0 = r5.f2259f;	 Catch:{  }
        r0 = r0 + 1;
        r5.f2259f = r0;	 Catch:{  }
        r0 = r1 + 1;
        monitor-exit(r5);	 Catch:{  }
        r1 = 1;
        r4 = 0;
        r5.mo2670a(r1, r2, r3, r4);
        r1 = r0;
        goto L_0x000e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.LruCache.b(int):void");
    }

    private void m4428a(int i, int i2) {
        m4427a(i);
        m4429b(i2);
    }

    public final V m4438b(K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        V remove;
        synchronized (this) {
            remove = this.f2254a.remove(k);
            if (remove != null) {
                this.f2255b -= m4430c(k, remove);
            }
        }
        if (remove != null) {
            mo2670a(false, k, remove, null);
        }
        return remove;
    }

    protected void mo2670a(boolean z, K k, V v, V v2) {
    }

    private static V m4431e() {
        return null;
    }

    private int m4430c(K k, V v) {
        int b = mo3292b(k, v);
        if (b >= 0) {
            return b;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    protected int mo3292b(K k, V v) {
        return 1;
    }

    public final void m4434a() {
        m4427a(-1);
    }

    public final synchronized int m4436b() {
        return this.f2255b;
    }

    public final synchronized int m4439c() {
        return this.f2254a.size();
    }

    public final synchronized Map<K, V> m4440d() {
        return new LinkedHashMap(this.f2254a);
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.f2260g + this.f2261h;
            if (i2 != 0) {
                i = (this.f2260g * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f2256c), Integer.valueOf(this.f2260g), Integer.valueOf(this.f2261h), Integer.valueOf(i)});
        }
        return format;
    }
}
