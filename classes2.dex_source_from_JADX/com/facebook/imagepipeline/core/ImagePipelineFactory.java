package com.facebook.imagepipeline.core;

import android.os.Build.VERSION;
import android.support.v4.util.Pools$SynchronizedPool;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.animated.factory.AnimatedFactoryImpl;
import com.facebook.imagepipeline.animated.factory.AnimatedFactoryProvider;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl;
import com.facebook.imagepipeline.bitmaps.ArtBitmapFactory;
import com.facebook.imagepipeline.bitmaps.EmptyJpegGenerator;
import com.facebook.imagepipeline.bitmaps.GingerbreadBitmapFactory;
import com.facebook.imagepipeline.bitmaps.HoneycombBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapCountingMemoryCacheFactory$1;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory$1;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory$1;
import com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory$1;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.cache.NativeMemoryCacheTrimStrategy;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.platform.ArtDecoder;
import com.facebook.imagepipeline.platform.GingerbreadPurgeableDecoder;
import com.facebook.imagepipeline.platform.KitKatPurgeableDecoder;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import java.util.Collections;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: page/view_album/%s */
public class ImagePipelineFactory {
    private static ImagePipelineFactory f10529a = null;
    private final ThreadHandoffProducerQueue f10530b;
    private final ImagePipelineConfig f10531c;
    private CountingMemoryCache<CacheKey, CloseableImage> f10532d;
    private MemoryCache<CacheKey, CloseableImage> f10533e;
    private CountingMemoryCache<CacheKey, PooledByteBuffer> f10534f;
    private MemoryCache<CacheKey, PooledByteBuffer> f10535g;
    private BufferedDiskCache f10536h;
    private DiskStorageCache f10537i;
    private ImageDecoder f10538j;
    private ImagePipeline f10539k;
    private ProducerFactory f10540l;
    private ProducerSequenceFactory f10541m;
    private BufferedDiskCache f10542n;
    private DiskStorageCache f10543o;
    private PlatformBitmapFactory f10544p;
    private PlatformDecoder f10545q;
    private AnimatedFactoryImpl f10546r;

    public static ImagePipelineFactory m15647a() {
        return (ImagePipelineFactory) Preconditions.a(f10529a, "ImagePipelineFactory was not initialized!");
    }

    public static void m15649a(ImagePipelineConfig imagePipelineConfig) {
        f10529a = new ImagePipelineFactory(imagePipelineConfig);
    }

    private ImagePipelineFactory(ImagePipelineConfig imagePipelineConfig) {
        this.f10531c = (ImagePipelineConfig) Preconditions.a(imagePipelineConfig);
        this.f10530b = new ThreadHandoffProducerQueue(imagePipelineConfig.f10783j.mo2026e());
    }

    public final AnimatedFactoryImpl m15657b() {
        if (this.f10546r == null) {
            this.f10546r = AnimatedFactoryProvider.a(m15652l(), this.f10531c.f10783j);
        }
        return this.f10546r;
    }

    public final CountingMemoryCache<CacheKey, CloseableImage> m15658c() {
        if (this.f10532d == null) {
            Supplier supplier = this.f10531c.f10776c;
            MemoryTrimmableRegistry memoryTrimmableRegistry = this.f10531c.f10788o;
            MemoryTrimmable countingMemoryCache = new CountingMemoryCache(new BitmapCountingMemoryCacheFactory$1(), new BitmapMemoryCacheTrimStrategy(), supplier);
            memoryTrimmableRegistry.mo1390a(countingMemoryCache);
            this.f10532d = countingMemoryCache;
        }
        return this.f10532d;
    }

    public final MemoryCache<CacheKey, CloseableImage> m15659d() {
        if (this.f10533e == null) {
            MemoryCache c = m15658c();
            ImageCacheStatsTracker imageCacheStatsTracker = this.f10531c.f10784k;
            imageCacheStatsTracker.mo2042a(c);
            this.f10533e = new InstrumentedMemoryCache(c, new BitmapMemoryCacheFactory$1(imageCacheStatsTracker));
        }
        return this.f10533e;
    }

    public final CountingMemoryCache<CacheKey, PooledByteBuffer> m15660e() {
        if (this.f10534f == null) {
            Supplier supplier = this.f10531c.f10782i;
            MemoryTrimmableRegistry memoryTrimmableRegistry = this.f10531c.f10788o;
            MemoryTrimmable countingMemoryCache = new CountingMemoryCache(new EncodedCountingMemoryCacheFactory$1(), new NativeMemoryCacheTrimStrategy(), supplier);
            memoryTrimmableRegistry.mo1390a(countingMemoryCache);
            this.f10534f = countingMemoryCache;
        }
        return this.f10534f;
    }

    public final MemoryCache<CacheKey, PooledByteBuffer> m15661f() {
        if (this.f10535g == null) {
            MemoryCache e = m15660e();
            ImageCacheStatsTracker imageCacheStatsTracker = this.f10531c.f10784k;
            imageCacheStatsTracker.mo2044b(e);
            this.f10535g = new InstrumentedMemoryCache(e, new EncodedMemoryCacheFactory$1(imageCacheStatsTracker));
        }
        return this.f10535g;
    }

    private ImageDecoder m15650j() {
        if (this.f10538j == null) {
            if (this.f10531c.f10785l != null) {
                this.f10538j = this.f10531c.f10785l;
            } else {
                AnimatedImageFactoryImpl a;
                if (m15657b() != null) {
                    a = m15657b().m15819a();
                } else {
                    a = null;
                }
                this.f10538j = new ImageDecoder(a, m15653m(), this.f10531c.f10775b);
            }
        }
        return this.f10538j;
    }

    private BufferedDiskCache m15651k() {
        if (this.f10536h == null) {
            this.f10536h = new BufferedDiskCache(m15662g(), this.f10531c.f10791r.m15641e(), this.f10531c.f10791r.m15642f(), this.f10531c.f10783j.mo2022a(), this.f10531c.f10783j.mo2023b(), this.f10531c.f10784k);
        }
        return this.f10536h;
    }

    public final DiskStorageCache m15662g() {
        if (this.f10537i == null) {
            this.f10537i = this.f10531c.f10781h.m16052a(this.f10531c.f10787n);
        }
        return this.f10537i;
    }

    public final ImagePipeline m15663h() {
        if (this.f10539k == null) {
            this.f10539k = new ImagePipeline(m15655o(), Collections.unmodifiableSet(this.f10531c.f10793t), this.f10531c.f10786m, m15659d(), m15661f(), m15651k(), m15656p(), this.f10531c.f10777d, this.f10530b);
        }
        return this.f10539k;
    }

    public static PlatformBitmapFactory m15646a(PoolFactory poolFactory, PlatformDecoder platformDecoder) {
        if (VERSION.SDK_INT >= 21) {
            return new ArtBitmapFactory(poolFactory.m15637a());
        }
        if (VERSION.SDK_INT >= 11) {
            return new HoneycombBitmapFactory(new EmptyJpegGenerator(poolFactory.m15641e()), platformDecoder);
        }
        return new GingerbreadBitmapFactory();
    }

    private PlatformBitmapFactory m15652l() {
        if (this.f10544p == null) {
            this.f10544p = m15646a(this.f10531c.f10791r, m15653m());
        }
        return this.f10544p;
    }

    public static PlatformDecoder m15648a(PoolFactory poolFactory, boolean z, boolean z2) {
        if (VERSION.SDK_INT >= 21) {
            int c = poolFactory.m15639c();
            return new ArtDecoder(poolFactory.m15637a(), c, new Pools$SynchronizedPool(c));
        } else if (!z || VERSION.SDK_INT >= 19) {
            return new KitKatPurgeableDecoder(poolFactory.m15638b());
        } else {
            return new GingerbreadPurgeableDecoder(z2);
        }
    }

    private PlatformDecoder m15653m() {
        if (this.f10545q == null) {
            this.f10545q = m15648a(this.f10531c.f10791r, this.f10531c.f10780g, this.f10531c.f10796w.f10834b);
        }
        return this.f10545q;
    }

    private ProducerFactory m15654n() {
        if (this.f10540l == null) {
            this.f10540l = new ProducerFactory(this.f10531c.m16021d(), this.f10531c.m16024p().m15643h(), m15650j(), this.f10531c.m16025q(), this.f10531c.m16022g(), this.f10531c.m16026s(), this.f10531c.m16023i(), this.f10531c.m16024p().m15641e(), m15659d(), m15661f(), m15651k(), m15656p(), this.f10531c.m16020c(), m15652l(), this.f10531c.m16027u().m16057a(), this.f10531c.m16027u().m16058b());
        }
        return this.f10540l;
    }

    private ProducerSequenceFactory m15655o() {
        if (this.f10541m == null) {
            this.f10541m = new ProducerSequenceFactory(m15654n(), this.f10531c.f10789p, this.f10531c.f10794u, this.f10531c.f10779f, this.f10531c.f10796w.f10834b, this.f10530b);
        }
        return this.f10541m;
    }

    public final DiskStorageCache m15664i() {
        if (this.f10543o == null) {
            this.f10543o = this.f10531c.f10781h.m16052a(this.f10531c.f10795v);
        }
        return this.f10543o;
    }

    private BufferedDiskCache m15656p() {
        if (this.f10542n == null) {
            this.f10542n = new BufferedDiskCache(m15664i(), this.f10531c.f10791r.m15641e(), this.f10531c.f10791r.m15642f(), this.f10531c.f10783j.mo2022a(), this.f10531c.f10783j.mo2023b(), this.f10531c.f10784k);
        }
        return this.f10542n;
    }
}
