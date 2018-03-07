package com.facebook.ui.media.cache;

import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.util.SecureHashUtil;
import com.facebook.debug.log.BLog;
import com.facebook.ui.media.cache.PartialFileStorage.PartialFile;
import com.facebook.video.server.VideoCacheSizePolicy;
import com.google.common.collect.Lists;
import com.google.common.primitives.Longs;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: offline_mode_operation_expired */
public class PartialFileCache<Key extends MediaCacheKey> implements DiskTrimmable, PartialFileStorage<Key> {
    private static final Class<?> f11392a = PartialFileCache.class;
    private static final Comparator<RemoveCandidate> f11393e = new C04741();
    @GuardedBy("this")
    private final PartialFileStorage<String> f11394b;
    private final VideoCacheSizePolicy f11395c;
    @GuardedBy("this")
    private long f11396d = -1;

    /* compiled from: offline_mode_operation_expired */
    final class C04741 implements Comparator<RemoveCandidate> {
        C04741() {
        }

        public final int compare(Object obj, Object obj2) {
            return Longs.a(((RemoveCandidate) obj).c, ((RemoveCandidate) obj2).c);
        }
    }

    public final PartialFile mo2147a(Object obj, FileMetadata fileMetadata) {
        PartialFile b;
        MediaCacheKey mediaCacheKey = (MediaCacheKey) obj;
        synchronized (this) {
            b = m16687b(mediaCacheKey, fileMetadata);
        }
        return b;
    }

    public final void mo2149a(Object obj) {
        MediaCacheKey mediaCacheKey = (MediaCacheKey) obj;
        synchronized (this) {
            this.f11394b.mo2149a(m16689c(mediaCacheKey));
        }
    }

    public final PartialFile mo2150b(Object obj) {
        PartialFile cachedFile;
        MediaCacheKey mediaCacheKey = (MediaCacheKey) obj;
        synchronized (this) {
            PartialFile b = this.f11394b.mo2150b(m16689c(mediaCacheKey));
            cachedFile = b == null ? null : new CachedFile(this, mediaCacheKey, b);
        }
        return cachedFile;
    }

    public PartialFileCache(PartialFileStorage<String> partialFileStorage, SizePolicy sizePolicy) {
        this.f11394b = partialFileStorage;
        this.f11395c = sizePolicy;
    }

    public final List<Key> mo2148a() {
        throw new UnsupportedOperationException("Cannot rehydrate VideoCacheKey's");
    }

    private synchronized PartialFile m16687b(Key key, FileMetadata fileMetadata) {
        PartialFile a;
        m16690c(this);
        a = this.f11394b.mo2147a(m16689c((MediaCacheKey) key), fileMetadata);
        m16686a(this, a.b());
        return new CachedFile(this, key, a);
    }

    public static synchronized void m16690c(PartialFileCache partialFileCache) {
        synchronized (partialFileCache) {
            if (partialFileCache.f11396d < 0) {
                partialFileCache.f11396d = 0;
                for (String b : partialFileCache.f11394b.mo2148a()) {
                    PartialFile b2 = partialFileCache.f11394b.mo2150b(b);
                    if (b2 != null) {
                        partialFileCache.f11396d += b2.b();
                    }
                }
            }
        }
    }

    private static String m16689c(Key key) {
        try {
            return SecureHashUtil.a(key.b().toString().getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not available, world as we know it is not more");
        }
    }

    public static synchronized void m16686a(PartialFileCache partialFileCache, long j) {
        synchronized (partialFileCache) {
            partialFileCache.f11396d += j;
            long a = partialFileCache.f11395c.m16697a(partialFileCache.f11396d);
            if (partialFileCache.f11396d > a) {
                partialFileCache.m16688b(a);
            }
        }
    }

    private List<RemoveCandidate> m16691d() {
        List<String> a = this.f11394b.mo2148a();
        List<RemoveCandidate> a2 = Lists.m1297a(a.size());
        for (String b : a) {
            PartialFile b2 = this.f11394b.mo2150b(b);
            if (b2 != null) {
                a2.add(new RemoveCandidate(b2));
            }
        }
        Collections.sort(a2, f11393e);
        return a2;
    }

    private synchronized void m16688b(long j) {
        try {
            m16690c(this);
            for (RemoveCandidate removeCandidate : m16691d()) {
                if (this.f11396d <= j) {
                    break;
                }
                this.f11394b.mo2149a(removeCandidate.a);
                this.f11396d -= removeCandidate.b;
            }
        } catch (Throwable e) {
            BLog.b(f11392a, "Error on trimming", e);
        }
        return;
    }

    public final synchronized void ai_() {
        try {
            List<RemoveCandidate> d = m16691d();
            if (!d.isEmpty()) {
                d.remove(d.size() - 1);
                for (RemoveCandidate removeCandidate : d) {
                    this.f11394b.mo2149a(removeCandidate.a);
                    this.f11396d -= removeCandidate.b;
                }
            }
        } catch (Throwable e) {
            BLog.b(f11392a, "Error on trimming", e);
        }
    }

    public final synchronized void mo1323b() {
        m16688b(0);
    }
}
