package com.facebook.imagepipeline.cache;

import bolts.Task;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.NativePooledByteBuffer;
import com.facebook.imagepipeline.memory.NativePooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteStreams;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: option_name */
public class BufferedDiskCache {
    private static final Class<?> f10911a = BufferedDiskCache.class;
    private final DiskStorageCache f10912b;
    private final NativePooledByteBufferFactory f10913c;
    public final PooledByteStreams f10914d;
    private final Executor f10915e;
    private final Executor f10916f;
    public final StagingArea f10917g = new StagingArea();
    public final ImageCacheStatsTracker f10918h;

    public BufferedDiskCache(DiskStorageCache diskStorageCache, NativePooledByteBufferFactory nativePooledByteBufferFactory, PooledByteStreams pooledByteStreams, Executor executor, Executor executor2, ImageCacheStatsTracker imageCacheStatsTracker) {
        this.f10912b = diskStorageCache;
        this.f10913c = nativePooledByteBufferFactory;
        this.f10914d = pooledByteStreams;
        this.f10915e = executor;
        this.f10916f = executor2;
        this.f10918h = imageCacheStatsTracker;
    }

    public final boolean m16185a(CacheKey cacheKey) {
        return this.f10917g.m16350b(cacheKey) || this.f10912b.m16339c(cacheKey);
    }

    public final Task<Boolean> m16186b(CacheKey cacheKey) {
        if (m16185a(cacheKey)) {
            return Task.m21071a(Boolean.valueOf(true));
        }
        return m16179c(cacheKey);
    }

    private Task<Boolean> m16179c(CacheKey cacheKey) {
        try {
            return Task.m21072a(new 1(this, cacheKey), this.f10915e);
        } catch (Exception e) {
            FLog.a(f10911a, e, "Failed to schedule disk-cache read for %s", new Object[]{cacheKey.toString()});
            return Task.m21070a(e);
        }
    }

    public final Task<EncodedImage> m16183a(CacheKey cacheKey, AtomicBoolean atomicBoolean) {
        Object a = this.f10917g.m16348a(cacheKey);
        if (a == null) {
            return m16178b(cacheKey, atomicBoolean);
        }
        cacheKey.toString();
        this.f10918h.mo2049g();
        return Task.m21071a(a);
    }

    public static boolean m16181d(BufferedDiskCache bufferedDiskCache, CacheKey cacheKey) {
        EncodedImage a = bufferedDiskCache.f10917g.m16348a(cacheKey);
        if (a != null) {
            a.close();
            cacheKey.toString();
            bufferedDiskCache.f10918h.mo2049g();
            return true;
        }
        cacheKey.toString();
        bufferedDiskCache.f10918h.mo2050h();
        try {
            return bufferedDiskCache.f10912b.m16341d(cacheKey);
        } catch (Exception e) {
            return false;
        }
    }

    private Task<EncodedImage> m16178b(final CacheKey cacheKey, final AtomicBoolean atomicBoolean) {
        try {
            return Task.m21072a(new Callable<EncodedImage>(this) {
                final /* synthetic */ BufferedDiskCache f14655c;

                public Object call() {
                    if (atomicBoolean.get()) {
                        throw new CancellationException();
                    }
                    Object a = this.f14655c.f10917g.m16348a(cacheKey);
                    if (a != null) {
                        cacheKey.toString();
                        this.f14655c.f10918h.mo2049g();
                    } else {
                        cacheKey.toString();
                        this.f14655c.f10918h.mo2050h();
                        try {
                            CloseableReference a2 = CloseableReference.m15675a(BufferedDiskCache.m16182e(this.f14655c, cacheKey));
                            try {
                                a = new EncodedImage(a2);
                            } finally {
                                CloseableReference.m15681c(a2);
                            }
                        } catch (Exception e) {
                            return null;
                        }
                    }
                    if (!Thread.interrupted()) {
                        return a;
                    }
                    if (a != null) {
                        a.close();
                    }
                    throw new InterruptedException();
                }
            }, this.f10915e);
        } catch (Exception e) {
            FLog.a(f10911a, e, "Failed to schedule disk-cache read for %s", new Object[]{cacheKey.toString()});
            return Task.m21070a(e);
        }
    }

    public final void m16184a(CacheKey cacheKey, EncodedImage encodedImage) {
        Preconditions.a(cacheKey);
        Preconditions.a(EncodedImage.m15705e(encodedImage));
        this.f10917g.m16349a(cacheKey, encodedImage);
        EncodedImage a = EncodedImage.m15702a(encodedImage);
        try {
            ExecutorDetour.a(this.f10916f, new 3(this, cacheKey, a), -1105191477);
        } catch (Throwable e) {
            FLog.a(f10911a, e, "Failed to schedule disk-cache write for %s", new Object[]{cacheKey.toString()});
            this.f10917g.m16351b(cacheKey, encodedImage);
            EncodedImage.m15704d(a);
        }
    }

    public static NativePooledByteBuffer m16182e(BufferedDiskCache bufferedDiskCache, CacheKey cacheKey) {
        try {
            cacheKey.toString();
            BinaryResource a = bufferedDiskCache.f10912b.m16335a(cacheKey);
            if (a == null) {
                cacheKey.toString();
                bufferedDiskCache.f10918h.mo2052j();
                return null;
            }
            cacheKey.toString();
            bufferedDiskCache.f10918h.mo2051i();
            InputStream a2 = a.mo2976a();
            try {
                NativePooledByteBuffer a3 = bufferedDiskCache.f10913c.m15777a(a2, (int) a.mo2978c());
                cacheKey.toString();
                return a3;
            } finally {
                a2.close();
            }
        } catch (Throwable e) {
            FLog.a(f10911a, e, "Exception reading from cache for %s", new Object[]{cacheKey.toString()});
            bufferedDiskCache.f10918h.mo2053k();
            throw e;
        }
    }

    public static void m16180c(BufferedDiskCache bufferedDiskCache, CacheKey cacheKey, EncodedImage encodedImage) {
        cacheKey.toString();
        try {
            bufferedDiskCache.f10912b.m16336a(cacheKey, new 6(bufferedDiskCache, encodedImage));
            cacheKey.toString();
        } catch (Throwable e) {
            FLog.a(f10911a, e, "Failed to write to disk-cache for key %s", new Object[]{cacheKey.toString()});
        }
    }
}
