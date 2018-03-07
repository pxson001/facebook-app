package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheEventListener.EvictionReason;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.MultiCacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DefaultDiskStorage.EntryImpl;
import com.facebook.cache.disk.DiskStorage.Entry;
import com.facebook.cache.disk.DiskStorage.Inserter;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import com.facebook.common.util.SecureHashUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: onthisday?source=%s&campaign_id=%s&story_id=%s */
public class DiskStorageCache implements DiskTrimmable {
    private static final Class<?> f11010b = DiskStorageCache.class;
    private static final long f11011c = TimeUnit.HOURS.toMillis(2);
    private static final long f11012d = TimeUnit.MINUTES.toMillis(30);
    @GuardedBy("mLock")
    @VisibleForTesting
    final Map<CacheKey, String> f11013a;
    private final long f11014e;
    private final long f11015f;
    private long f11016g;
    private final CacheEventListener f11017h;
    @GuardedBy("mLock")
    private long f11018i;
    private final long f11019j;
    private final StatFsHelper f11020k;
    private final DiskStorage f11021l;
    private final EntryEvictionComparatorSupplier f11022m;
    private final CacheErrorLogger f11023n;
    public final CacheStats f11024o;
    private final Clock f11025p;
    private final Object f11026q = new Object();

    /* compiled from: onthisday?source=%s&campaign_id=%s&story_id=%s */
    public class Params {
        public final long f11007a;
        public final long f11008b;
        public final long f11009c;

        public Params(long j, long j2, long j3) {
            this.f11007a = j;
            this.f11008b = j2;
            this.f11009c = j3;
        }
    }

    @VisibleForTesting
    /* compiled from: onthisday?source=%s&campaign_id=%s&story_id=%s */
    public class CacheStats {
        private boolean f11027a = false;
        private long f11028b = -1;
        private long f11029c = -1;

        CacheStats() {
        }

        public final synchronized boolean m16343a() {
            return this.f11027a;
        }

        public final synchronized void m16344b() {
            this.f11027a = false;
            this.f11029c = -1;
            this.f11028b = -1;
        }

        public final synchronized void m16342a(long j, long j2) {
            this.f11029c = j2;
            this.f11028b = j;
            this.f11027a = true;
        }

        public final synchronized void m16345b(long j, long j2) {
            if (this.f11027a) {
                this.f11028b += j;
                this.f11029c += j2;
            }
        }

        public final synchronized long m16346c() {
            return this.f11028b;
        }
    }

    public DiskStorageCache(DiskStorage diskStorage, EntryEvictionComparatorSupplier entryEvictionComparatorSupplier, Params params, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable DiskTrimmableRegistry diskTrimmableRegistry) {
        this.f11014e = params.f11008b;
        this.f11015f = params.f11009c;
        this.f11016g = params.f11009c;
        this.f11020k = StatFsHelper.m2310a();
        this.f11021l = diskStorage;
        this.f11022m = entryEvictionComparatorSupplier;
        this.f11018i = -1;
        this.f11017h = cacheEventListener;
        this.f11019j = params.f11007a;
        this.f11023n = cacheErrorLogger;
        this.f11024o = new CacheStats();
        if (diskTrimmableRegistry != null) {
            diskTrimmableRegistry.mo1325a(this);
        }
        this.f11025p = SystemClock.f762a;
        this.f11013a = new HashMap();
    }

    public final BinaryResource m16335a(CacheKey cacheKey) {
        try {
            BinaryResource binaryResource;
            synchronized (this.f11026q) {
                Object obj;
                String str;
                if (!this.f11013a.containsKey(cacheKey)) {
                    List e = m16327e(cacheKey);
                    int i = 0;
                    obj = null;
                    binaryResource = null;
                    while (i < e.size()) {
                        str = (String) e.get(i);
                        BinaryResource b = this.f11021l.mo2080b(str, cacheKey);
                        BinaryResource binaryResource2;
                        String str2;
                        if (b != null) {
                            binaryResource2 = b;
                            str2 = str;
                            binaryResource = binaryResource2;
                            break;
                        }
                        i++;
                        binaryResource2 = b;
                        str2 = str;
                        binaryResource = binaryResource2;
                    }
                } else {
                    str = (String) this.f11013a.get(cacheKey);
                    obj = str;
                    binaryResource = this.f11021l.mo2080b(str, cacheKey);
                }
                if (binaryResource == null) {
                    this.f11017h.mo1345b();
                    this.f11013a.remove(cacheKey);
                } else {
                    this.f11017h.mo1343a();
                    this.f11013a.put(cacheKey, obj);
                }
            }
            return binaryResource;
        } catch (Throwable e2) {
            this.f11023n.mo2056a(CacheErrorCategory.GENERIC_IO, f11010b, "getResource", e2);
            this.f11017h.mo1347d();
            return null;
        }
    }

    public final boolean m16338b(CacheKey cacheKey) {
        try {
            boolean z;
            synchronized (this.f11026q) {
                Object obj = null;
                String str;
                if (!this.f11013a.containsKey(cacheKey)) {
                    List e = m16327e(cacheKey);
                    int i = 0;
                    z = false;
                    while (i < e.size()) {
                        str = (String) e.get(i);
                        boolean d = this.f11021l.mo2084d(str, cacheKey);
                        boolean z2;
                        String str2;
                        if (d) {
                            z2 = d;
                            str2 = str;
                            z = z2;
                            break;
                        }
                        i++;
                        z2 = d;
                        str2 = str;
                        z = z2;
                    }
                } else {
                    str = (String) this.f11013a.get(cacheKey);
                    obj = str;
                    z = this.f11021l.mo2084d(str, cacheKey);
                }
                if (z) {
                    this.f11013a.put(cacheKey, obj);
                }
            }
            return z;
        } catch (IOException e2) {
            this.f11017h.mo1347d();
            return false;
        }
    }

    private Inserter m16322a(String str, CacheKey cacheKey) {
        m16328e();
        return this.f11021l.mo2078a(str, cacheKey);
    }

    private BinaryResource m16321a(Inserter inserter, CacheKey cacheKey, String str) {
        BinaryResource a;
        synchronized (this.f11026q) {
            a = inserter.a(cacheKey);
            this.f11024o.m16345b(a.mo2978c(), 1);
            this.f11013a.put(cacheKey, str);
        }
        return a;
    }

    public final BinaryResource m16336a(CacheKey cacheKey, WriterCallback writerCallback) {
        String str;
        this.f11017h.mo1346c();
        synchronized (this.f11026q) {
            if (this.f11013a.containsKey(cacheKey)) {
                str = (String) this.f11013a.get(cacheKey);
            } else {
                str = m16329f(cacheKey);
            }
        }
        try {
            Inserter a = m16322a(str, cacheKey);
            try {
                a.a(writerCallback, cacheKey);
                BinaryResource a2 = m16321a(a, cacheKey, str);
                return a2;
            } finally {
                if (!a.a()) {
                    FLog.a(f11010b, "Failed to delete temp file");
                }
            }
        } catch (Throwable e) {
            this.f11017h.mo1348e();
            FLog.a(f11010b, "Failed inserting a file into the cache", e);
            throw e;
        }
    }

    public final long m16334a(long j) {
        long j2;
        long j3 = 0;
        synchronized (this.f11026q) {
            try {
                long a = this.f11025p.mo211a();
                j2 = 0;
                j3 = 0;
                int i = 0;
                for (EntryImpl entryImpl : this.f11021l.mo2082c()) {
                    try {
                        long max = Math.max(1, Math.abs(a - entryImpl.b()));
                        if (max >= j) {
                            long j4;
                            int i2;
                            max = this.f11021l.mo2077a(entryImpl);
                            this.f11013a.values().remove(entryImpl.a());
                            if (max > 0) {
                                j4 = j3 + max;
                                i2 = i + 1;
                            } else {
                                long j5 = j3;
                                i2 = i;
                                j4 = j5;
                            }
                            i = i2;
                            j3 = j4;
                        } else {
                            j2 = Math.max(j2, max);
                        }
                    } catch (IOException e) {
                        Throwable e2 = e;
                        j3 = j2;
                    }
                }
                this.f11021l.mo2079a();
                if (i > 0) {
                    m16332g();
                    this.f11024o.m16345b(-j3, (long) (-i));
                    m16326a(EvictionReason.CONTENT_STALE, i, j3);
                }
            } catch (IOException e3) {
                e2 = e3;
                this.f11023n.mo2056a(CacheErrorCategory.EVICTION, f11010b, "clearOldEntries: " + e2.getMessage(), e2);
                j2 = j3;
                return j2;
            }
        }
        return j2;
    }

    private void m16326a(EvictionReason evictionReason, int i, long j) {
        this.f11017h.mo1344a(evictionReason, i, j);
    }

    private void m16328e() {
        synchronized (this.f11026q) {
            boolean g = m16332g();
            m16330f();
            long c = this.f11024o.m16346c();
            if (c > this.f11016g && !g) {
                this.f11024o.m16344b();
                m16332g();
            }
            if (c > this.f11016g) {
                m16325a((this.f11016g * 9) / 10, EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void m16325a(long j, EvictionReason evictionReason) {
        try {
            long c = this.f11024o.m16346c() - j;
            int i = 0;
            long j2 = 0;
            for (EntryImpl entryImpl : m16323a(this.f11021l.mo2082c())) {
                if (j2 > c) {
                    break;
                }
                long j3;
                int i2;
                long a = this.f11021l.mo2077a(entryImpl);
                this.f11013a.values().remove(entryImpl.a());
                if (a > 0) {
                    j3 = j2 + a;
                    i2 = i + 1;
                } else {
                    long j4 = j2;
                    i2 = i;
                    j3 = j4;
                }
                i = i2;
                j2 = j3;
            }
            this.f11024o.m16345b(-j2, (long) (-i));
            this.f11021l.mo2079a();
            m16326a(evictionReason, i, j2);
        } catch (Throwable e) {
            this.f11023n.mo2056a(CacheErrorCategory.EVICTION, f11010b, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<Entry> m16323a(Collection<Entry> collection) {
        long a = f11011c + this.f11025p.mo211a();
        Collection arrayList = new ArrayList(collection.size());
        Collection arrayList2 = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            EntryImpl entryImpl = (EntryImpl) it.next();
            if (entryImpl.b() > a) {
                arrayList.add(entryImpl);
            } else {
                arrayList2.add(entryImpl);
            }
        }
        Collections.sort(arrayList2, this.f11022m.mo2057a());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void m16330f() {
        if (this.f11020k.m2315a(StorageType.INTERNAL, this.f11015f - this.f11024o.m16346c())) {
            this.f11016g = this.f11014e;
        } else {
            this.f11016g = this.f11015f;
        }
    }

    public final void m16340d() {
        synchronized (this.f11026q) {
            try {
                this.f11021l.mo2081b();
                this.f11013a.clear();
            } catch (Throwable e) {
                this.f11023n.mo2056a(CacheErrorCategory.EVICTION, f11010b, "clearAll: " + e.getMessage(), e);
            }
            this.f11024o.m16344b();
        }
    }

    public final boolean m16339c(CacheKey cacheKey) {
        boolean containsKey;
        synchronized (this.f11026q) {
            containsKey = this.f11013a.containsKey(cacheKey);
        }
        return containsKey;
    }

    public final boolean m16341d(CacheKey cacheKey) {
        synchronized (this.f11026q) {
            if (m16339c(cacheKey)) {
                return true;
            }
            Object obj = null;
            try {
                boolean z;
                String str;
                if (!this.f11013a.containsKey(cacheKey)) {
                    List e = m16327e(cacheKey);
                    int i = 0;
                    z = false;
                    while (i < e.size()) {
                        str = (String) e.get(i);
                        boolean c = this.f11021l.mo2083c(str, cacheKey);
                        boolean z2;
                        String str2;
                        if (c) {
                            z2 = c;
                            str2 = str;
                            z = z2;
                            break;
                        }
                        i++;
                        z2 = c;
                        str2 = str;
                        z = z2;
                    }
                } else {
                    str = (String) this.f11013a.get(cacheKey);
                    obj = str;
                    z = this.f11021l.mo2083c(str, cacheKey);
                }
                if (z) {
                    this.f11013a.put(cacheKey, obj);
                } else {
                    this.f11013a.remove(cacheKey);
                }
                return z;
            } catch (IOException e2) {
                return false;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ai_() {
        /*
        r8 = this;
        r6 = 0;
        r1 = r8.f11026q;
        monitor-enter(r1);
        r8.m16332g();	 Catch:{ all -> 0x0038 }
        r0 = r8.f11024o;	 Catch:{ all -> 0x0038 }
        r2 = r0.m16346c();	 Catch:{ all -> 0x0038 }
        r4 = r8.f11019j;	 Catch:{ all -> 0x0038 }
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 <= 0) goto L_0x001e;
    L_0x0014:
        r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r0 <= 0) goto L_0x001e;
    L_0x0018:
        r4 = r8.f11019j;	 Catch:{ all -> 0x0038 }
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 >= 0) goto L_0x0020;
    L_0x001e:
        monitor-exit(r1);	 Catch:{ all -> 0x0038 }
    L_0x001f:
        return;
    L_0x0020:
        r4 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r6 = r8.f11019j;	 Catch:{ all -> 0x0038 }
        r6 = (double) r6;	 Catch:{ all -> 0x0038 }
        r2 = (double) r2;	 Catch:{ all -> 0x0038 }
        r2 = r6 / r2;
        r2 = r4 - r2;
        r4 = 4581421828931458171; // 0x3f947ae147ae147b float:89128.96 double:0.02;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x0036;
    L_0x0033:
        r8.m16324a(r2);	 Catch:{ all -> 0x0038 }
    L_0x0036:
        monitor-exit(r1);	 Catch:{ all -> 0x0038 }
        goto L_0x001f;
    L_0x0038:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0038 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.cache.disk.DiskStorageCache.ai_():void");
    }

    public final void mo1323b() {
        m16340d();
    }

    private void m16324a(double d) {
        synchronized (this.f11026q) {
            try {
                this.f11024o.m16344b();
                m16332g();
                long c = this.f11024o.m16346c();
                m16325a(c - ((long) (((double) c) * d)), EvictionReason.CACHE_MANAGER_TRIMMED);
            } catch (Throwable e) {
                this.f11023n.mo2056a(CacheErrorCategory.EVICTION, f11010b, "trimBy: " + e.getMessage(), e);
            }
        }
    }

    @GuardedBy("mLock")
    private boolean m16332g() {
        long a = this.f11025p.mo211a();
        if (this.f11024o.m16343a() && this.f11018i != -1 && a - this.f11018i <= f11012d) {
            return false;
        }
        m16333h();
        this.f11018i = a;
        return true;
    }

    @GuardedBy("mLock")
    private void m16333h() {
        Object obj = null;
        int i = 0;
        int i2 = 0;
        long j = -1;
        long a = this.f11025p.mo211a();
        long j2 = a + f11011c;
        try {
            long j3 = 0;
            int i3 = 0;
            for (EntryImpl entryImpl : this.f11021l.mo2082c()) {
                long max;
                int i4;
                int i5;
                Object obj2;
                int i6 = i3 + 1;
                j3 += entryImpl.d();
                if (entryImpl.b() > j2) {
                    int i7 = i + 1;
                    i = (int) (((long) i2) + entryImpl.d());
                    max = Math.max(entryImpl.b() - a, j);
                    i4 = i;
                    i5 = i7;
                    obj2 = 1;
                } else {
                    long j4 = j;
                    i4 = i2;
                    i5 = i;
                    max = j4;
                    obj2 = obj;
                }
                obj = obj2;
                i3 = i6;
                i = i5;
                i2 = i4;
                j = max;
            }
            if (obj != null) {
                this.f11023n.mo2056a(CacheErrorCategory.READ_INVALID_ENTRY, f11010b, "Future timestamp found in " + i + " files , with a total size of " + i2 + " bytes, and a maximum time delta of " + j + "ms", null);
            }
            this.f11024o.m16342a(j3, (long) i3);
        } catch (Throwable e) {
            this.f11023n.mo2056a(CacheErrorCategory.GENERIC_IO, f11010b, "calcFileCacheSize: " + e.getMessage(), e);
        }
    }

    private static List<String> m16327e(CacheKey cacheKey) {
        try {
            if (cacheKey instanceof MultiCacheKey) {
                List a = ((MultiCacheKey) cacheKey).m21105a();
                List<String> arrayList = new ArrayList(a.size());
                for (int i = 0; i < a.size(); i++) {
                    arrayList.add(m16331g((CacheKey) a.get(i)));
                }
                return arrayList;
            }
            List<String> arrayList2 = new ArrayList(1);
            arrayList2.add(m16331g(cacheKey));
            return arrayList2;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @VisibleForTesting
    private static String m16329f(CacheKey cacheKey) {
        try {
            if (cacheKey instanceof MultiCacheKey) {
                return m16331g((CacheKey) ((MultiCacheKey) cacheKey).m21105a().get(0));
            }
            return m16331g(cacheKey);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static String m16331g(CacheKey cacheKey) {
        return SecureHashUtil.a(cacheKey.toString().getBytes("UTF-8"));
    }
}
