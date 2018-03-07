package com.facebook.imagepipeline.core;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap.Config;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultEncodedMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.memory.PoolConfig;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.producers.BaseNetworkFetcher;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: org.iii.romulus.meridian.metachanged */
public class ImagePipelineConfig {
    @Nullable
    private final AnimatedImageFactoryImpl f10774a;
    public final Config f10775b;
    public final Supplier<MemoryCacheParams> f10776c;
    public final DefaultCacheKeyFactory f10777d;
    private final Context f10778e;
    public final boolean f10779f;
    public final boolean f10780g;
    public final DiskStorageCacheFactory f10781h;
    public final Supplier<MemoryCacheParams> f10782i;
    public final ExecutorSupplier f10783j;
    public final ImageCacheStatsTracker f10784k;
    @Nullable
    public final ImageDecoder f10785l;
    public final Supplier<Boolean> f10786m;
    public final DiskCacheConfig f10787n;
    public final MemoryTrimmableRegistry f10788o;
    public final BaseNetworkFetcher f10789p;
    @Nullable
    private final PlatformBitmapFactory f10790q;
    public final PoolFactory f10791r;
    private final SimpleProgressiveJpegConfig f10792s;
    public final Set<RequestListener> f10793t;
    public final boolean f10794u;
    public final DiskCacheConfig f10795v;
    public final ImagePipelineExperiments f10796w;

    /* compiled from: org.iii.romulus.meridian.metachanged */
    public class Builder {
        public AnimatedImageFactoryImpl f10797a;
        public Config f10798b;
        public Supplier<MemoryCacheParams> f10799c;
        public DefaultCacheKeyFactory f10800d;
        public final Context f10801e;
        public boolean f10802f = false;
        public boolean f10803g;
        public Supplier<MemoryCacheParams> f10804h;
        public ExecutorSupplier f10805i;
        public ImageCacheStatsTracker f10806j;
        public ImageDecoder f10807k;
        public Supplier<Boolean> f10808l;
        public DiskCacheConfig f10809m;
        public MemoryTrimmableRegistry f10810n;
        public BaseNetworkFetcher f10811o;
        public PlatformBitmapFactory f10812p;
        public PoolFactory f10813q;
        public SimpleProgressiveJpegConfig f10814r;
        public Set<RequestListener> f10815s;
        public boolean f10816t = true;
        public DiskCacheConfig f10817u;
        public DiskStorageCacheFactory f10818v;
        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder f10819w = new com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder(this);

        public Builder(Context context) {
            this.f10801e = (Context) Preconditions.a(context);
        }

        public final Builder m16031a(AnimatedImageFactoryImpl animatedImageFactoryImpl) {
            this.f10797a = animatedImageFactoryImpl;
            return this;
        }

        public final Builder m16033a(DefaultCacheKeyFactory defaultCacheKeyFactory) {
            this.f10800d = defaultCacheKeyFactory;
            return this;
        }

        public final Builder m16042a(boolean z) {
            this.f10803g = z;
            return this;
        }

        public final Builder m16035a(DiskStorageCacheFactory diskStorageCacheFactory) {
            this.f10818v = diskStorageCacheFactory;
            return this;
        }

        public final Builder m16044b(boolean z) {
            this.f10802f = z;
            return this;
        }

        public final Builder m16036a(ExecutorSupplier executorSupplier) {
            this.f10805i = executorSupplier;
            return this;
        }

        public final Builder m16034a(ImageCacheStatsTracker imageCacheStatsTracker) {
            this.f10806j = imageCacheStatsTracker;
            return this;
        }

        public final Builder m16037a(ImageDecoder imageDecoder) {
            this.f10807k = imageDecoder;
            return this;
        }

        public final Builder m16029a(Supplier<Boolean> supplier) {
            this.f10808l = supplier;
            return this;
        }

        public final Builder m16028a(DiskCacheConfig diskCacheConfig) {
            this.f10809m = diskCacheConfig;
            return this;
        }

        public final Builder m16030a(MemoryTrimmableRegistry memoryTrimmableRegistry) {
            this.f10810n = memoryTrimmableRegistry;
            return this;
        }

        public final Builder m16040a(BaseNetworkFetcher baseNetworkFetcher) {
            this.f10811o = baseNetworkFetcher;
            return this;
        }

        public final Builder m16032a(PlatformBitmapFactory platformBitmapFactory) {
            this.f10812p = platformBitmapFactory;
            return this;
        }

        public final Builder m16039a(PoolFactory poolFactory) {
            this.f10813q = poolFactory;
            return this;
        }

        public final Builder m16038a(SimpleProgressiveJpegConfig simpleProgressiveJpegConfig) {
            this.f10814r = simpleProgressiveJpegConfig;
            return this;
        }

        public final Builder m16041a(Set<RequestListener> set) {
            this.f10815s = set;
            return this;
        }

        public final Builder m16046c(boolean z) {
            this.f10816t = z;
            return this;
        }

        public final Builder m16043b(DiskCacheConfig diskCacheConfig) {
            this.f10817u = diskCacheConfig;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder m16045b() {
            return this.f10819w;
        }

        public final ImagePipelineConfig m16047c() {
            return new ImagePipelineConfig(this);
        }
    }

    public ImagePipelineConfig(Builder builder) {
        DiskCacheConfig a;
        this.f10774a = builder.f10797a;
        this.f10776c = builder.f10799c == null ? new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) builder.f10801e.getSystemService("activity")) : builder.f10799c;
        this.f10775b = builder.f10798b == null ? Config.ARGB_8888 : builder.f10798b;
        this.f10777d = builder.f10800d == null ? DefaultCacheKeyFactory.m15873a() : builder.f10800d;
        this.f10778e = (Context) Preconditions.a(builder.f10801e);
        this.f10780g = builder.f10803g;
        this.f10781h = builder.f10818v == null ? new DiskStorageCacheFactory(new DynamicDefaultDiskStorageFactory()) : builder.f10818v;
        this.f10779f = builder.f10802f;
        this.f10782i = builder.f10804h == null ? new DefaultEncodedMemoryCacheParamsSupplier() : builder.f10804h;
        this.f10784k = builder.f10806j == null ? NoOpImageCacheStatsTracker.l() : builder.f10806j;
        this.f10785l = builder.f10807k;
        this.f10786m = builder.f10808l == null ? new 1(this) : builder.f10808l;
        if (builder.f10809m == null) {
            a = DiskCacheConfig.m15968a(builder.f10801e).m15970a();
        } else {
            a = builder.f10809m;
        }
        this.f10787n = a;
        this.f10788o = builder.f10810n == null ? NoOpMemoryTrimmableRegistry.m16319a() : builder.f10810n;
        this.f10789p = builder.f10811o == null ? new HttpUrlConnectionNetworkFetcher() : builder.f10811o;
        this.f10790q = builder.f10812p;
        this.f10791r = builder.f10813q == null ? new PoolFactory(PoolConfig.newBuilder().m15635a()) : builder.f10813q;
        this.f10792s = builder.f10814r == null ? new SimpleProgressiveJpegConfig() : builder.f10814r;
        this.f10793t = builder.f10815s == null ? new HashSet() : builder.f10815s;
        this.f10794u = builder.f10816t;
        this.f10795v = builder.f10817u == null ? this.f10787n : builder.f10817u;
        this.f10783j = builder.f10805i == null ? new DefaultExecutorSupplier(this.f10791r.m15639c()) : builder.f10805i;
        com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder builder2 = builder.f10819w;
        this.f10796w = new ImagePipelineExperiments(builder2, builder2.f10820a);
    }

    public final DefaultCacheKeyFactory m16020c() {
        return this.f10777d;
    }

    public final Context m16021d() {
        return this.f10778e;
    }

    public final boolean m16022g() {
        return this.f10779f;
    }

    public final ExecutorSupplier m16023i() {
        return this.f10783j;
    }

    public final PoolFactory m16024p() {
        return this.f10791r;
    }

    public final SimpleProgressiveJpegConfig m16025q() {
        return this.f10792s;
    }

    public final boolean m16026s() {
        return this.f10794u;
    }

    public final ImagePipelineExperiments m16027u() {
        return this.f10796w;
    }

    public static Builder m16019a(Context context) {
        return new Builder(context);
    }
}
