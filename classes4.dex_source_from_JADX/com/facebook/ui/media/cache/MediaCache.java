package com.facebook.ui.media.cache;

import android.net.Uri;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.cache.CacheCounterType;
import com.facebook.analytics.cache.CacheTracker;
import com.facebook.analytics.cache.CacheTracker.Factory;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.logger.IAnalyticsPeriodicEventReporter;
import com.facebook.analytics.webrequest.WebRequestCounters;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.common.WriterCallbacks.1;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.io.FbCloseables;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.time.Clock;
import com.facebook.debug.log.BLog;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: ephemeral */
public abstract class MediaCache<KEY extends MediaCacheKey, VALUE> implements IAnalyticsPeriodicEventReporter, IHaveUserData {
    private static final Class<?> f12871a = MediaCache.class;
    public final Clock f12872b;
    private final AbstractFbErrorReporter f12873c;
    @GuardedBy("mInMemoryWriteLock for writes to keep in sync with mBytesInMemory")
    private final ConcurrentMap<KEY, InMemoryCachedValue<KEY, VALUE>> f12874d;
    private final ConcurrentMap<KEY, VALUE> f12875e;
    private final MediaCacheParams f12876f;
    private final ConcurrentMap<KEY, Long> f12877g;
    public final Object f12878h = new Object();
    private final String f12879i;
    private final boolean f12880j;
    private int f12881k;
    private int f12882l;
    private final int f12883m;
    private final int f12884n;
    @GuardedBy("mInMemoryWriteLock")
    public int f12885o;
    private final CacheTracker f12886p;
    private final CacheTracker f12887q;
    private final CacheTracker f12888r;
    private final CacheTracker f12889s;
    private final CacheErrorLogger f12890t;
    private final WebRequestCounters f12891u;
    private final MemoryTrimmable f12892v;
    private final MemoryTrimmableRegistry f12893w;
    private final DiskStorageCache f12894x;
    private final ObjectEncoder<KEY, VALUE> f12895y;

    @VisibleForTesting
    /* compiled from: ephemeral */
    class MediaCacheMemoryTrimmable implements MemoryTrimmable {
        final /* synthetic */ MediaCache f12911a;

        MediaCacheMemoryTrimmable(MediaCache mediaCache) {
            this.f12911a = mediaCache;
        }

        public final void m13789a(MemoryTrimType memoryTrimType) {
            double suggestedTrimRatio = memoryTrimType.getSuggestedTrimRatio();
            synchronized (this.f12911a.f12878h) {
                this.f12911a.m13744a(this.f12911a.f12885o - ((int) (suggestedTrimRatio * ((double) this.f12911a.f12885o))), Integer.MAX_VALUE);
            }
        }
    }

    /* compiled from: ephemeral */
    public class InMemoryCachedValue<KEY extends MediaCacheKey, VALUE> {
        public final /* synthetic */ MediaCache f13040a;
        public final KEY f13041b;
        public final VALUE f13042c;
        public final int f13043d;
        public volatile long f13044e;
        public long f13045f;

        InMemoryCachedValue(MediaCache mediaCache, KEY key, VALUE value, int i) {
            this.f13040a = mediaCache;
            this.f13041b = key;
            this.f13042c = value;
            this.f13043d = i;
            this.f13044e = mediaCache.f12872b.a();
        }
    }

    protected abstract int mo931b(VALUE value);

    public final BinaryResource m13740a(KEY key, InputStream inputStream) {
        return m13739a((MediaCacheKey) key, (WriterCallback) new 1(inputStream));
    }

    protected MediaCache(Clock clock, Factory factory, WebRequestCounters webRequestCounters, FbErrorReporter fbErrorReporter, MediaCacheParams mediaCacheParams, @Nullable MemoryTrimmableRegistry memoryTrimmableRegistry, FileCache fileCache, ObjectEncoder<KEY, VALUE> objectEncoder, CacheErrorLogger cacheErrorLogger) {
        boolean z = false;
        this.f12872b = clock;
        this.f12873c = fbErrorReporter;
        this.f12879i = mediaCacheParams.m13783b();
        this.f12883m = mediaCacheParams.m13785d();
        this.f12884n = mediaCacheParams.m13786e();
        this.f12880j = mediaCacheParams.m13784c();
        this.f12877g = Maps.e();
        this.f12890t = cacheErrorLogger;
        this.f12894x = fileCache;
        this.f12895y = objectEncoder;
        this.f12876f = mediaCacheParams;
        this.f12886p = factory.a(mediaCacheParams.m13782a() + "_overall");
        this.f12889s = factory.a(mediaCacheParams.m13782a() + "_disk");
        if (this.f12880j) {
            this.f12874d = new MapMaker().a(128).c(4).l();
            this.f12887q = factory.a(mediaCacheParams.m13782a() + "_memory");
            this.f12875e = new MapMaker().a(128).c(4).g().l();
            this.f12888r = factory.a(mediaCacheParams.m13782a() + "_weakmem");
            this.f12881k = mediaCacheParams.m13788g();
            this.f12882l = mediaCacheParams.m13787f();
            if (this.f12882l <= this.f12881k) {
                z = true;
            }
            Preconditions.checkState(z);
            this.f12892v = new MediaCacheMemoryTrimmable(this);
        } else {
            this.f12874d = null;
            this.f12875e = null;
            this.f12887q = null;
            this.f12888r = null;
            this.f12892v = null;
            this.f12881k = 0;
            this.f12882l = 0;
        }
        this.f12891u = webRequestCounters;
        this.f12893w = memoryTrimmableRegistry;
        if (this.f12893w != null && this.f12880j) {
            this.f12893w.a(this.f12892v);
        }
    }

    public final HoneyAnalyticsEvent mo804a(long j, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("media_cache_size");
        honeyClientEvent.a(this.f12879i + "_memory_cache_size", m13727c());
        honeyClientEvent.a(this.f12879i + "_memory_cache_count", m13730e());
        honeyClientEvent.a(this.f12879i + "_file_cache_size", this.f12894x.o.c());
        return honeyClientEvent;
    }

    public final VALUE m13742a(KEY key) {
        Object j = m13736j(key);
        if (j != null) {
            mo931b(j);
        }
        return j;
    }

    public final boolean m13749b(KEY key) {
        return m13733g(key) || this.f12894x.d(key.b());
    }

    @VisibleForTesting
    private boolean m13733g(KEY key) {
        if (this.f12880j) {
            return this.f12874d.containsKey(key);
        }
        return false;
    }

    public final VALUE m13751c(KEY key) {
        this.f12886p.f();
        VALUE j = m13736j(key);
        if (j != null) {
            m13735i(key);
        } else {
            Object h = m13734h(key);
            if (h != null) {
                mo931b(h);
            }
        }
        if (j != null) {
            this.f12886p.a();
        } else {
            this.f12886p.b();
        }
        return j;
    }

    @VisibleForTesting
    private VALUE m13734h(KEY key) {
        this.f12889s.f();
        BinaryResource a = this.f12894x.a(key.b());
        if (a == null) {
            this.f12889s.b();
            return null;
        }
        VALUE a2;
        VALUE a3 = m13724a((MediaCacheKey) key, a);
        if (a3 == null) {
            try {
                a2 = this.f12895y.mo932a((MediaCacheKey) key, a);
            } catch (IOException e) {
                m13725a(e, CacheErrorCategory.READ_DECODE);
            }
            if (a2 == null) {
                this.f12889s.a();
                m13731e(key, a2);
                return a2;
            }
            this.f12889s.b();
            return a2;
        }
        a2 = a3;
        if (a2 == null) {
            this.f12889s.b();
            return a2;
        }
        this.f12889s.a();
        m13731e(key, a2);
        return a2;
    }

    private void m13725a(IOException iOException, CacheErrorCategory cacheErrorCategory) {
        if (iOException instanceof FileNotFoundException) {
            this.f12890t.a(CacheErrorCategory.READ_FILE_NOT_FOUND, f12871a, "getMedia", iOException);
        } else {
            this.f12890t.a(cacheErrorCategory, f12871a, "getMedia", iOException);
        }
    }

    private VALUE m13724a(KEY key, BinaryResource binaryResource) {
        VALUE value = null;
        try {
            try {
                value = this.f12895y.mo934a((MediaCacheKey) key, binaryResource.b());
            } catch (Throwable e) {
                this.f12890t.a(CacheErrorCategory.READ_DECODE, f12871a, "getMedia", e);
            }
            if (value == null) {
                BLog.a(f12871a, "Decode from memory failed. Reading from disk for key %s", new Object[]{key.toString()});
            }
        } catch (IOException e2) {
            m13725a(e2, CacheErrorCategory.READ_FILE);
        }
        return value;
    }

    public final BinaryResource m13752d(KEY key) {
        return this.f12894x.a(key.b());
    }

    @Deprecated
    public final Uri m13753e(KEY key) {
        FileBinaryResource fileBinaryResource = (FileBinaryResource) this.f12894x.a(key.b());
        return fileBinaryResource != null ? Uri.fromFile(fileBinaryResource.a) : null;
    }

    public final boolean m13754f(KEY key) {
        Long l = (Long) this.f12877g.get(key);
        if (l == null) {
            return false;
        }
        if (this.f12872b.a() < l.longValue()) {
            this.f12891u.e();
            return true;
        }
        this.f12877g.remove(key, l);
        return false;
    }

    public final BinaryResource m13741a(KEY key, VALUE value) {
        m13728c((Object) value);
        m13731e(key, value);
        return m13729d(key, value);
    }

    public final void m13748b(KEY key, VALUE value) {
        m13728c((Object) value);
        m13731e(key, value);
    }

    public final BinaryResource m13750c(KEY key, VALUE value) {
        m13728c((Object) value);
        return m13729d(key, value);
    }

    private BinaryResource m13729d(KEY key, VALUE value) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.f12895y.mo935a(key, value, byteArrayOutputStream);
            FbCloseables.a(byteArrayOutputStream);
            BinaryResource a = m13723a((MediaCacheKey) key, byteArrayOutputStream.toByteArray());
            if (a == null) {
                BLog.a(f12871a, "Disk cache (insert) failed for key: %s", new Object[]{key});
                m13737k(key);
            }
            return a;
        } catch (Throwable e) {
            this.f12890t.a(CacheErrorCategory.WRITE_ENCODE, f12871a, "insert: " + e.getMessage(), e);
            throw e;
        } catch (Throwable th) {
            FbCloseables.a(byteArrayOutputStream);
        }
    }

    private void m13728c(VALUE value) {
        if (!mo930a((Object) value)) {
            Throwable iOException = new IOException("Attempt made to cache invalid media");
            this.f12890t.a(CacheErrorCategory.WRITE_INVALID_ENTRY, f12871a, "insertCachedMedia", iOException);
            throw iOException;
        }
    }

    private BinaryResource m13723a(KEY key, byte[] bArr) {
        return this.f12894x.a(key.b(), new 1(this, bArr));
    }

    public final BinaryResource m13739a(KEY key, WriterCallback writerCallback) {
        return this.f12894x.a(key.b(), writerCallback);
    }

    public final void m13745a(KEY key, long j) {
        this.f12877g.put(key, Long.valueOf(this.f12872b.a() + j));
    }

    @VisibleForTesting
    private boolean m13735i(KEY key) {
        return this.f12894x.b(key.b());
    }

    private void m13726b() {
        if (this.f12880j) {
            synchronized (this.f12878h) {
                this.f12874d.clear();
                this.f12875e.clear();
                this.f12885o = 0;
            }
            m13732f();
        }
    }

    public final void m13743a() {
        m13726b();
        this.f12894x.d();
    }

    public void clearUserData() {
        m13743a();
    }

    protected boolean mo930a(VALUE value) {
        return true;
    }

    private VALUE m13736j(KEY key) {
        if (!this.f12880j) {
            return null;
        }
        this.f12887q.f();
        InMemoryCachedValue inMemoryCachedValue = (InMemoryCachedValue) this.f12874d.get(key);
        if (inMemoryCachedValue != null) {
            VALUE value = inMemoryCachedValue.f13042c;
            if (mo930a((Object) value)) {
                inMemoryCachedValue.f13044e = inMemoryCachedValue.f13040a.f12872b.a();
                this.f12887q.a();
                return value;
            }
            this.f12874d.remove(key, value);
            BLog.a(f12871a, "Invalid media found in cache for %s", new Object[]{key});
            this.f12890t.a(CacheErrorCategory.READ_INVALID_ENTRY, f12871a, "getCachedMediaFromStrongAndWeakCaches(" + key + ")", null);
        }
        this.f12887q.b();
        this.f12888r.f();
        Object obj = this.f12875e.get(key);
        if (obj != null) {
            if (mo930a(obj)) {
                m13731e(key, obj);
                this.f12888r.a();
                return obj;
            }
            this.f12875e.remove(key, obj);
        }
        this.f12888r.b();
        return null;
    }

    @VisibleForTesting
    private void m13737k(KEY key) {
        synchronized (this.f12878h) {
            InMemoryCachedValue inMemoryCachedValue = (InMemoryCachedValue) this.f12874d.get(key);
            if (inMemoryCachedValue != null) {
                this.f12874d.remove(inMemoryCachedValue.f13041b);
                this.f12885o -= inMemoryCachedValue.f13043d;
                this.f12875e.remove(inMemoryCachedValue.f13041b);
            }
        }
    }

    @VisibleForTesting
    final void m13744a(int i, int i2) {
        new StringBuilder("Cleaning out in memory cache: ").append(this.f12885o / 1024).append(" KB with ").append(this.f12874d.size()).append(" values");
        List<InMemoryCachedValue> a = Lists.a(this.f12874d.values());
        for (InMemoryCachedValue inMemoryCachedValue : a) {
            inMemoryCachedValue.f13045f = inMemoryCachedValue.f13044e;
        }
        Collections.sort(a, new ExpirationComparator(this));
        for (InMemoryCachedValue inMemoryCachedValue2 : a) {
            this.f12875e.put(inMemoryCachedValue2.f13041b, inMemoryCachedValue2.f13042c);
            this.f12874d.remove(inMemoryCachedValue2.f13041b);
            this.f12885o -= inMemoryCachedValue2.f13043d;
            if (this.f12885o < i && this.f12874d.size() <= i2) {
                break;
            }
        }
        new StringBuilder("Finished cleaning out in memory cache: ").append(this.f12885o / 1024).append(" KB with ").append(this.f12874d.size()).append(" values");
    }

    private void m13731e(KEY key, VALUE value) {
        if (this.f12880j) {
            int b = mo931b((Object) value);
            if (this.f12882l > 0) {
                synchronized (this.f12878h) {
                    InMemoryCachedValue inMemoryCachedValue = (InMemoryCachedValue) this.f12874d.put(key, new InMemoryCachedValue(this, key, value, b));
                    if (inMemoryCachedValue != null) {
                        this.f12885o -= inMemoryCachedValue.f13043d;
                    }
                    this.f12885o += b;
                    this.f12887q.e((long) b);
                    if (this.f12885o > this.f12881k || this.f12874d.size() > this.f12883m) {
                        m13744a(this.f12882l, this.f12884n);
                    }
                }
                m13732f();
            }
        }
    }

    private int m13727c() {
        int i;
        synchronized (this.f12878h) {
            i = this.f12885o;
        }
        return i;
    }

    @VisibleForTesting
    private int m13730e() {
        return this.f12874d == null ? 0 : this.f12874d.size();
    }

    private void m13732f() {
        Preconditions.checkArgument(this.f12880j);
        int c = m13727c();
        int e = m13730e();
        if (e > 0) {
            this.f12873c.c(this.f12887q.a(CacheCounterType.BYTES_COUNT), Integer.toString(c));
            this.f12873c.c(this.f12887q.a(CacheCounterType.ENTRIES_COUNT), Integer.toString(e));
            return;
        }
        this.f12873c.a(this.f12887q.a(CacheCounterType.BYTES_COUNT));
        this.f12873c.a(this.f12887q.a(CacheCounterType.ENTRIES_COUNT));
    }
}
