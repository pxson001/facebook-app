package com.facebook.imagepipeline.module;

import android.content.Context;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.memory.MemoryManager;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.instrumentation.DefaultImageCacheStatsTracker;
import com.facebook.imagepipeline.internal.FbCacheKeyFactory;
import com.facebook.imagepipeline.internal.FbExecutorSupplier;
import com.facebook.imagepipeline.internal.FbImageNetworkFetcher;
import com.facebook.imagepipeline.listener.STATICDI_MULTIBIND_PROVIDER$RequestListener;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Provider;

/* compiled from: page_story_admin_attr_nux_history */
public class ImagePipelineFactoryMethodAutoProvider extends AbstractProvider<ImagePipelineFactory> {
    private static volatile ImagePipelineFactory f10474a;

    public static com.facebook.imagepipeline.core.ImagePipelineFactory m15549a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f10474a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.imagepipeline.module.ImagePipelineFactoryMethodAutoProvider.class;
        monitor-enter(r1);
        r0 = f10474a;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m15550b(r0);	 Catch:{ all -> 0x0035 }
        f10474a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10474a;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.module.ImagePipelineFactoryMethodAutoProvider.a(com.facebook.inject.InjectorLike):com.facebook.imagepipeline.core.ImagePipelineFactory");
    }

    public /* synthetic */ Object get() {
        return m15548a();
    }

    private ImagePipelineFactory m15548a() {
        AnimatedImageFactoryImpl a = AnimatedImageFactoryMethodAutoProvider.m15551a(this);
        DefaultCacheKeyFactory a2 = FbCacheKeyFactory.m15870a((InjectorLike) this);
        Context context = (Context) getInstance(Context.class);
        ExecutorSupplier a3 = FbExecutorSupplier.m15788a(this);
        ImageCacheStatsTracker a4 = DefaultImageCacheStatsTracker.m15878a((InjectorLike) this);
        ImageDecoder a5 = ImageDecoderMethodAutoProvider.m15912a(this);
        Provider a6 = IdBasedProvider.m1811a(this, 3959);
        Provider a7 = IdBasedProvider.m1811a(this, 4029);
        IdBasedProvider.m1811a(this, 4032);
        return ImagePipelineModule.m15570a(a, a2, context, a3, a4, a5, a6, a7, IdBasedProvider.m1811a(this, 4030), DiskCacheConfig_MainImageFileCacheMethodAutoProvider.m15939a(this), Integer_MaxSmallImageBytesMethodAutoProvider.m15974a(this), IdBasedSingletonScopeProvider.m1809a(this, 4031), MemoryManager.m9807a((InjectorLike) this), FbImageNetworkFetcher.m15978a((InjectorLike) this), PlatformBitmapFactoryMethodAutoProvider.m15555a(this), PoolFactoryMethodAutoProvider.m15557a(this), DiskCacheConfig_ProfileThumbnailImageFileCacheMethodAutoProvider.m16007a(this), ProgressiveJpegConfigMethodAutoProvider.m16010a(this), QeInternalImplMethodAutoProvider.m3744a(this), STATICDI_MULTIBIND_PROVIDER$RequestListener.m16017a(this), IdBasedSingletonScopeProvider.m1810b(this, 1009), IdBasedSingletonScopeProvider.m1810b(this, 1008), IdBasedSingletonScopeProvider.m1810b(this, 1007), IdBasedSingletonScopeProvider.m1810b(this, 1013), IdBasedProvider.m1811a(this, 2320), FbErrorReporterImpl.m2317a((InjectorLike) this));
    }

    private static ImagePipelineFactory m15550b(InjectorLike injectorLike) {
        AnimatedImageFactoryImpl a = AnimatedImageFactoryMethodAutoProvider.m15551a(injectorLike);
        DefaultCacheKeyFactory a2 = FbCacheKeyFactory.m15870a(injectorLike);
        Context context = (Context) injectorLike.getInstance(Context.class);
        ExecutorSupplier a3 = FbExecutorSupplier.m15788a(injectorLike);
        ImageCacheStatsTracker a4 = DefaultImageCacheStatsTracker.m15878a(injectorLike);
        ImageDecoder a5 = ImageDecoderMethodAutoProvider.m15912a(injectorLike);
        Provider a6 = IdBasedProvider.m1811a(injectorLike, 3959);
        Provider a7 = IdBasedProvider.m1811a(injectorLike, 4029);
        IdBasedProvider.m1811a(injectorLike, 4032);
        return ImagePipelineModule.m15570a(a, a2, context, a3, a4, a5, a6, a7, IdBasedProvider.m1811a(injectorLike, 4030), DiskCacheConfig_MainImageFileCacheMethodAutoProvider.m15939a(injectorLike), Integer_MaxSmallImageBytesMethodAutoProvider.m15974a(injectorLike), IdBasedSingletonScopeProvider.m1809a(injectorLike, 4031), MemoryManager.m9807a(injectorLike), FbImageNetworkFetcher.m15978a(injectorLike), PlatformBitmapFactoryMethodAutoProvider.m15555a(injectorLike), PoolFactoryMethodAutoProvider.m15557a(injectorLike), DiskCacheConfig_ProfileThumbnailImageFileCacheMethodAutoProvider.m16007a(injectorLike), ProgressiveJpegConfigMethodAutoProvider.m16010a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), STATICDI_MULTIBIND_PROVIDER$RequestListener.m16017a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1009), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1008), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1007), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1013), IdBasedProvider.m1811a(injectorLike, 2320), FbErrorReporterImpl.m2317a(injectorLike));
    }
}
