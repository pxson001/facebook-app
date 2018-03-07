package com.facebook.imagepipeline.module;

import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.support.v4.util.Pools$SynchronizedPool;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.cache.CacheTracker.Factory;
import com.facebook.analytics.counter.CountersPrefWriter;
import com.facebook.cache.DiskCacheManager;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskCacheConfig.Builder;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.time.Clock;
import com.facebook.crypto.Crypto;
import com.facebook.crypto.module.LoggedInUserCrypto;
import com.facebook.debug.log.BLog;
import com.facebook.imagepipeline.abtest.ExperimentsForImagePipelineAbTestModule;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactoryImpl;
import com.facebook.imagepipeline.animated.factory.AnimatedFactoryImpl;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.DiskStorageCacheFactory;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig.DynamicValueConfig;
import com.facebook.imagepipeline.instrumentation.DefaultPoolStatsTracker;
import com.facebook.imagepipeline.instrumentation.FbPoolStatsTracker;
import com.facebook.imagepipeline.instrumentation.InstrumentationAwareDelegatingPoolStatsTracker;
import com.facebook.imagepipeline.instrumentation.PipelineInstrumentationStatus;
import com.facebook.imagepipeline.internal.ExperimentalCryptoConfig;
import com.facebook.imagepipeline.internal.FbEntryEvictionComparatorSupplier;
import com.facebook.imagepipeline.internal.FbImageNetworkFetcher;
import com.facebook.imagepipeline.internal.FbMarshmallowDecoder;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestLoggingListener;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imagepipeline.memory.DefaultFlexByteArrayPoolParams;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.memory.GenericByteArrayPool;
import com.facebook.imagepipeline.memory.NativeMemoryChunkPool;
import com.facebook.imagepipeline.memory.NativePooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PoolConfig;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.memory.PoolParams;
import com.facebook.imagepipeline.memory.PoolStatsTracker;
import com.facebook.imagepipeline.memory.PooledByteStreams;
import com.facebook.imagepipeline.memory.SharedByteArray;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.producers.BaseNetworkFetcher;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderMethod;
import com.facebook.qe.api.QeAccessor;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.collect.ImmutableList;
import java.io.File;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: page_load_time */
public class ImagePipelineModule extends AbstractLibraryModule {

    /* compiled from: page_load_time */
    class FbPoolStatsTrackerProvider {
        public static FbPoolStatsTracker m15601a(CountersPrefWriter countersPrefWriter, Clock clock, PipelineInstrumentationStatus pipelineInstrumentationStatus, String str) {
            return new InstrumentationAwareDelegatingPoolStatsTracker(pipelineInstrumentationStatus, new DefaultPoolStatsTracker(countersPrefWriter, clock, str));
        }
    }

    /* compiled from: page_load_time */
    final class C04591 implements Supplier<File> {
        final /* synthetic */ Context f10765a;

        C04591(Context context) {
            this.f10765a = context;
        }

        public final Object mo2058a() {
            return this.f10765a.getFilesDir();
        }
    }

    /* compiled from: page_load_time */
    final class C04603 implements DynamicValueConfig {
        final /* synthetic */ XConfigReader f10767a;
        private List<Integer> f10768b;
        private int f10769c;
        private boolean f10770d;

        C04603(XConfigReader xConfigReader) {
            this.f10767a = xConfigReader;
        }

        public final List<Integer> mo2065a() {
            if (this.f10768b == null) {
                this.f10768b = ImmutableList.of(Integer.valueOf(2), Integer.valueOf(mo2066b()));
            }
            return this.f10768b;
        }

        public final synchronized int mo2066b() {
            if (!this.f10770d) {
                this.f10769c = this.f10767a.m2683a(ProgressiveJpegXConfig.c, 5);
                this.f10770d = true;
            }
            return this.f10769c;
        }
    }

    /* compiled from: page_load_time */
    final class C04612 implements Supplier<Boolean> {
        final /* synthetic */ Provider f10773a;

        C04612(Provider provider) {
            this.f10773a = provider;
        }

        public final Object mo2058a() {
            return Boolean.valueOf(!((Boolean) this.f10773a.get()).booleanValue());
        }
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static SharedByteArray m15598g(PoolFactory poolFactory) {
        if (poolFactory.f10526g == null) {
            poolFactory.f10526g = new SharedByteArray(poolFactory.f10520a.f10506d, poolFactory.f10520a.f10505c);
        }
        return poolFactory.f10526g;
    }

    @ProviderMethod
    @Singleton
    @MainImageFileCache
    static DiskCacheConfig m15564a(Context context, Factory factory, CacheErrorLogger cacheErrorLogger, DiskCacheManager diskCacheManager, FbEntryEvictionComparatorSupplier fbEntryEvictionComparatorSupplier, QeAccessor qeAccessor, CacheDirExperimentMigrator cacheDirExperimentMigrator, CacheLocationDetails cacheLocationDetails) {
        CacheLocation a = cacheDirExperimentMigrator.m15960a(qeAccessor.mo596a(ExperimentsForImagePipelineAbTestModule.f10700m, false) ? CacheLocation.FILES : CacheLocation.CACHE);
        Builder a2 = DiskCacheConfig.m15968a(context);
        a2.f10721a = 1;
        a2 = a2;
        a2.f10722b = cacheLocationDetails.m15964b(a);
        a2 = a2;
        a2.f10723c = cacheLocationDetails.m15963a(a);
        Builder a3 = a2.m15972c(Long.valueOf(qeAccessor.mo575a(ExperimentsForImagePipelineAbTestModule.f10698k, 2097152)).longValue()).m15971b(m15590c(qeAccessor).longValue()).m15969a(m15585b(qeAccessor).longValue());
        a3.f10728h = cacheErrorLogger;
        a3 = a3;
        a3.f10729i = factory.m9188a("image_file");
        a3 = a3;
        a3.f10730j = diskCacheManager;
        a3 = a3;
        a3.f10727g = fbEntryEvictionComparatorSupplier;
        return a3.m15970a();
    }

    private static Long m15585b(QeAccessor qeAccessor) {
        return Long.valueOf(qeAccessor.mo575a(ExperimentsForImagePipelineAbTestModule.f10696i, 62914560));
    }

    private static Long m15590c(QeAccessor qeAccessor) {
        return Long.valueOf(qeAccessor.mo575a(ExperimentsForImagePipelineAbTestModule.f10697j, 15728640));
    }

    @ProviderMethod
    @Singleton
    @ProfileThumbnailImageFileCache
    static DiskCacheConfig m15563a(Context context, Factory factory, CacheErrorLogger cacheErrorLogger, DiskCacheManager diskCacheManager) {
        Builder a = DiskCacheConfig.m15968a(context);
        a.f10721a = 1;
        a = a;
        a.f10722b = "image";
        a = a;
        a.f10723c = new C04591(context);
        a = a;
        a.f10726f = 262144;
        a = a;
        a.f10725e = 4194304;
        a = a;
        a.f10724d = 4194304;
        a = a;
        a.f10728h = cacheErrorLogger;
        a = a;
        a.f10729i = factory.m9188a("profile_thumbnail_image_file");
        a = a;
        a.f10730j = diskCacheManager;
        return a.m15970a();
    }

    @ProviderMethod
    @Singleton
    static PoolFactory m15576a(PoolStatsTracker poolStatsTracker, PoolStatsTracker poolStatsTracker2, MemoryTrimmableRegistry memoryTrimmableRegistry, PoolStatsTracker poolStatsTracker3, PoolParams poolParams) {
        PoolConfig.Builder newBuilder = PoolConfig.newBuilder();
        newBuilder.f10512b = (PoolStatsTracker) Preconditions.a(poolStatsTracker);
        newBuilder = newBuilder;
        newBuilder.f10518h = (PoolStatsTracker) Preconditions.a(poolStatsTracker2);
        newBuilder = newBuilder;
        newBuilder.f10514d = memoryTrimmableRegistry;
        newBuilder = newBuilder;
        newBuilder.f10516f = (PoolStatsTracker) Preconditions.a(poolStatsTracker3);
        newBuilder = newBuilder;
        newBuilder.f10513c = poolParams;
        return new PoolFactory(newBuilder.m15635a());
    }

    @ProviderMethod
    @Singleton
    @MaxSmallImageBytes
    static Integer m15580a(QeAccessor qeAccessor, WindowManager windowManager) {
        if (!qeAccessor.mo596a(ExperimentsForImagePipelineAbTestModule.f10709v, false)) {
            return Integer.valueOf(-1);
        }
        Point point = new Point();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (defaultDisplay == null) {
            BLog.c("ImagePipelineModule", "Window manager passed down to Fresco has no display attached! Object of class %s", new Object[]{windowManager.getClass().getName()});
            point.set(480, 800);
        } else {
            defaultDisplay.getSize(point);
        }
        float a = qeAccessor.mo571a(ExperimentsForImagePipelineAbTestModule.f10707t, 0.0026624f);
        int a2 = qeAccessor.mo572a(ExperimentsForImagePipelineAbTestModule.f10708u, 1830);
        Integer.valueOf(a2);
        Float.valueOf(a);
        int i = (int) ((((float) (point.x * point.y)) * a) + ((float) a2));
        Integer.valueOf(i);
        return Integer.valueOf(i);
    }

    @ProviderMethod
    @Singleton
    @IsResizeAndRotateForNetworkImagesEnabled
    static Boolean m15579a() {
        return Boolean.valueOf(false);
    }

    @ProviderMethod
    @Singleton
    static ImagePipelineFactory m15570a(AnimatedImageFactory animatedImageFactory, CacheKeyFactory cacheKeyFactory, Context context, ExecutorSupplier executorSupplier, ImageCacheStatsTracker imageCacheStatsTracker, ImageDecoder imageDecoder, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, DiskCacheConfig diskCacheConfig, Integer num, Provider<Boolean> provider4, MemoryTrimmableRegistry memoryTrimmableRegistry, FbImageNetworkFetcher fbImageNetworkFetcher, PlatformBitmapFactory platformBitmapFactory, PoolFactory poolFactory, DiskCacheConfig diskCacheConfig2, ProgressiveJpegConfig progressiveJpegConfig, QeAccessor qeAccessor, Set<RequestListener> set, Lazy<Crypto> lazy, Lazy<Crypto> lazy2, Lazy<Crypto> lazy3, Lazy<LoggedInUserCrypto> lazy4, Provider<ExperimentalCryptoConfig> provider5, FbErrorReporter fbErrorReporter) {
        ImagePipelineFactory.m15649a(ImagePipelineConfig.m16019a(context).m16031a((AnimatedImageFactoryImpl) animatedImageFactory).m16033a((DefaultCacheKeyFactory) cacheKeyFactory).m16042a(((Boolean) provider3.get()).booleanValue()).m16044b(((Boolean) provider2.get()).booleanValue()).m16036a(executorSupplier).m16034a(imageCacheStatsTracker).m16037a(imageDecoder).m16029a(new C04612(provider)).m16028a(diskCacheConfig).m16030a(memoryTrimmableRegistry).m16040a((BaseNetworkFetcher) fbImageNetworkFetcher).m16032a(platformBitmapFactory).m16039a(poolFactory).m16038a((SimpleProgressiveJpegConfig) progressiveJpegConfig).m16041a((Set) set).m16046c(((Boolean) provider4.get()).booleanValue()).m16043b(diskCacheConfig2).m16035a(new DiskStorageCacheFactory(new ExperimentalCryptoStorageFactory(lazy, lazy2, lazy3, lazy4, provider5, fbErrorReporter))).m16045b().m16049a(qeAccessor.mo596a(ExperimentsForImagePipelineAbTestModule.f10688a, false)).m16045b().m16048a(num.intValue()).m16045b().m16050b(qeAccessor.mo596a(ExperimentsForImagePipelineAbTestModule.f10710w, false)).m16047c());
        return ImagePipelineFactory.m15647a();
    }

    @ProviderMethod
    @Singleton
    static BitmapPool m15575a(PoolFactory poolFactory) {
        return poolFactory.m15637a();
    }

    @ProviderMethod
    @Singleton
    static GenericByteArrayPool m15584b(PoolFactory poolFactory) {
        return poolFactory.m15643h();
    }

    @ProviderMethod
    @Singleton
    static PooledByteStreams m15589c(PoolFactory poolFactory) {
        return poolFactory.m15642f();
    }

    @ProviderMethod
    @Singleton
    static NativeMemoryChunkPool m15592d(PoolFactory poolFactory) {
        return poolFactory.m15640d();
    }

    @ProviderMethod
    @Singleton
    static NativePooledByteBufferFactory m15594e(PoolFactory poolFactory) {
        return poolFactory.m15641e();
    }

    @ProviderMethod
    @Singleton
    static FlexByteArrayPool m15596f(PoolFactory poolFactory) {
        return poolFactory.m15638b();
    }

    @ProviderMethod
    @Singleton
    @MainImageFileCache
    static DiskStorageCache m15565a(ImagePipelineFactory imagePipelineFactory) {
        return imagePipelineFactory.m15662g();
    }

    @ProviderMethod
    @Singleton
    @ProfileThumbnailImageFileCache
    static DiskStorageCache m15581b(ImagePipelineFactory imagePipelineFactory) {
        return imagePipelineFactory.m15664i();
    }

    @ProviderMethod
    @Singleton
    @FlexByteArrayPoolParams
    static PoolParams m15577a(WindowManager windowManager, Integer num) {
        int intValue = num.intValue();
        int i = 65536;
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (defaultDisplay == null) {
            BLog.c("FbFlexByteArrayPoolParams", "Window manager passed down to Fresco has no display attached! Object of class %s", new Object[]{windowManager.getClass().getName()});
        } else {
            Point point = new Point();
            defaultDisplay.getSize(point);
            int i2 = point.x * point.y;
            if (i2 >= 518400) {
                i = i2 < 1024000 ? 131072 : 262144;
            }
        }
        int i3 = i;
        return new PoolParams(4194304, intValue * 4194304, DefaultFlexByteArrayPoolParams.m15633a(i3, 4194304, intValue), i3, 4194304, intValue);
    }

    @ProviderMethod
    @Singleton
    @SimpleImageMemoryCache
    static CountingMemoryCache m15586c(ImagePipelineFactory imagePipelineFactory) {
        return imagePipelineFactory.m15660e();
    }

    @BitmapMemoryCache
    @ProviderMethod
    @Singleton
    static CountingMemoryCache m15591d(ImagePipelineFactory imagePipelineFactory) {
        return imagePipelineFactory.m15658c();
    }

    @ProviderMethod
    @Singleton
    @SimpleImageMemoryCache
    static MemoryCache m15593e(ImagePipelineFactory imagePipelineFactory) {
        return imagePipelineFactory.m15661f();
    }

    @BitmapMemoryCache
    @ProviderMethod
    @Singleton
    static MemoryCache m15595f(ImagePipelineFactory imagePipelineFactory) {
        return imagePipelineFactory.m15659d();
    }

    @ProviderMethod
    @Singleton
    static ImagePipeline m15597g(ImagePipelineFactory imagePipelineFactory) {
        return imagePipelineFactory.m15663h();
    }

    @ProviderMethod
    @Singleton
    @BitmapPoolStatsTracker
    static FbPoolStatsTracker m15572a(CountersPrefWriter countersPrefWriter, Clock clock, PipelineInstrumentationStatus pipelineInstrumentationStatus) {
        return FbPoolStatsTrackerProvider.m15601a(countersPrefWriter, clock, pipelineInstrumentationStatus, "bitmap_pool_stats_counters");
    }

    @SmallByteArrayPoolStatsTracker
    @ProviderMethod
    @Singleton
    static FbPoolStatsTracker m15583b(CountersPrefWriter countersPrefWriter, Clock clock, PipelineInstrumentationStatus pipelineInstrumentationStatus) {
        return FbPoolStatsTrackerProvider.m15601a(countersPrefWriter, clock, pipelineInstrumentationStatus, "common_byte_array_pool_stats_counters");
    }

    @ProviderMethod
    @Singleton
    @NativeMemoryChunkPoolStatsTracker
    static FbPoolStatsTracker m15587c(CountersPrefWriter countersPrefWriter, Clock clock, PipelineInstrumentationStatus pipelineInstrumentationStatus) {
        return FbPoolStatsTrackerProvider.m15601a(countersPrefWriter, clock, pipelineInstrumentationStatus, "native_memory_chunk_pool_stats_counters");
    }

    @ProviderMethod
    @Singleton
    static PipelineInstrumentationStatus m15573a(BaseAnalyticsConfig baseAnalyticsConfig, Clock clock) {
        return new PipelineInstrumentationStatus(baseAnalyticsConfig, clock);
    }

    @ProviderMethod
    @Singleton
    static SimpleProgressiveJpegConfig m15571a(XConfigReader xConfigReader) {
        return new SimpleProgressiveJpegConfig(new C04603(xConfigReader));
    }

    @ProviderMethod
    @Singleton
    static AnimatedDrawableFactoryImpl m15566a(Context context, AnimatedFactoryImpl animatedFactoryImpl) {
        return animatedFactoryImpl.m15818a(context);
    }

    @ProviderMethod
    @Singleton
    static AnimatedFactoryImpl m15567a(PlatformBitmapFactory platformBitmapFactory, ExecutorSupplier executorSupplier) {
        return new AnimatedFactoryImpl(platformBitmapFactory, executorSupplier);
    }

    @ProviderMethod
    @Singleton
    static AnimatedImageFactoryImpl m15568a(AnimatedFactoryImpl animatedFactoryImpl) {
        return animatedFactoryImpl.m15819a();
    }

    @ProviderMethod
    @Singleton
    static AnimatedDrawableBackendProvider m15569a(AnimatedDrawableUtil animatedDrawableUtil) {
        return new 4(animatedDrawableUtil);
    }

    @ProviderMethod
    @Singleton
    public static AnimatedDrawableUtil m15582b() {
        return new AnimatedDrawableUtil();
    }

    @ProviderMethod
    @Singleton
    static PlatformDecoder m15578a(PoolFactory poolFactory, Provider<Boolean> provider, Provider<Boolean> provider2, QeAccessor qeAccessor, Context context) {
        if (VERSION.SDK_INT < 23 || (context.getApplicationInfo().flags & 1048576) != 0 || !qeAccessor.mo596a(ExperimentsForImagePipelineAbTestModule.f10704q, false)) {
            return ImagePipelineFactory.m15648a(poolFactory, ((Boolean) provider.get()).booleanValue(), ((Boolean) provider2.get()).booleanValue());
        }
        int c = poolFactory.m15639c();
        return new FbMarshmallowDecoder(poolFactory.m15637a(), c, new Pools$SynchronizedPool(c));
    }

    @ProviderMethod
    @Singleton
    static RequestLoggingListener m15588c() {
        return new RequestLoggingListener();
    }

    @ProviderMethod
    public static ExperimentalCryptoConfig m15574a(QeAccessor qeAccessor) {
        boolean a = qeAccessor.mo596a(ExperimentsForImagePipelineAbTestModule.f10703p, false);
        boolean a2 = qeAccessor.mo596a(ExperimentsForImagePipelineAbTestModule.f10702o, false);
        if (!a) {
            return ExperimentalCryptoConfig.NONE;
        }
        if (a2) {
            return ExperimentalCryptoConfig.FIXED_KEY;
        }
        return ExperimentalCryptoConfig.ENCRYPTED;
    }
}
