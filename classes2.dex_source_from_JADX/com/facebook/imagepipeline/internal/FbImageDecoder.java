package com.facebook.imagepipeline.internal;

import android.graphics.Bitmap.Config;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactory;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.image.CloseableAnimatedBitmap;
import com.facebook.imagepipeline.image.CloseableGIFImageOld;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapCounterProvider;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.memory.NativePooledByteBuffer;
import com.facebook.imagepipeline.module.AnimatedImageFactoryMethodAutoProvider;
import com.facebook.imagepipeline.module.FlexByteArrayPoolMethodAutoProvider;
import com.facebook.imagepipeline.module.PlatformDecoderMethodAutoProvider;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.images.webp.AnimatedImage;
import com.facebook.ui.images.webp.AnimatedImageDecoder;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: overrideNectarLogging */
public class FbImageDecoder extends ImageDecoder {
    private static volatile FbImageDecoder f10647e;
    private final AnimatedImageDecoder f10648a;
    private final Provider<Boolean> f10649b;
    private final Provider<Boolean> f10650c;
    private final FlexByteArrayPool f10651d;

    public static com.facebook.imagepipeline.internal.FbImageDecoder m15914a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10647e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.imagepipeline.internal.FbImageDecoder.class;
        monitor-enter(r1);
        r0 = f10647e;	 Catch:{ all -> 0x003a }
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
        r0 = m15915b(r0);	 Catch:{ all -> 0x0035 }
        f10647e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10647e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.internal.FbImageDecoder.a(com.facebook.inject.InjectorLike):com.facebook.imagepipeline.internal.FbImageDecoder");
    }

    private static FbImageDecoder m15915b(InjectorLike injectorLike) {
        return new FbImageDecoder(AnimatedImageFactoryMethodAutoProvider.m15551a(injectorLike), PlatformDecoderMethodAutoProvider.m15644a(injectorLike), AnimatedImageDecoder.m15924a(injectorLike), FlexByteArrayPoolMethodAutoProvider.m15937a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4359), IdBasedProvider.m1811a(injectorLike, 4358));
    }

    @Inject
    public FbImageDecoder(AnimatedImageFactory animatedImageFactory, PlatformDecoder platformDecoder, AnimatedImageDecoder animatedImageDecoder, FlexByteArrayPool flexByteArrayPool, Provider<Boolean> provider, Provider<Boolean> provider2) {
        super(animatedImageFactory, platformDecoder, Config.ARGB_8888);
        this.f10648a = animatedImageDecoder;
        this.f10649b = provider;
        this.f10650c = provider2;
        this.f10651d = flexByteArrayPool;
    }

    public final CloseableImage mo2054a(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions) {
        if (!((Boolean) this.f10650c.get()).booleanValue() || imageDecodeOptions.f12731c) {
            return new CloseableGIFImageOld(encodedImage);
        }
        return super.mo2054a(encodedImage, imageDecodeOptions);
    }

    public final CloseableImage mo2055b(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions) {
        if (!((Boolean) this.f10649b.get()).booleanValue() || imageDecodeOptions.f12731c) {
            return m15916c(encodedImage, imageDecodeOptions);
        }
        return super.mo2055b(encodedImage, imageDecodeOptions);
    }

    private CloseableAnimatedBitmap m15916c(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions) {
        Throwable th;
        CloseableReference closeableReference;
        CloseableAnimatedBitmap closeableAnimatedBitmap = null;
        try {
            CloseableReference a = encodedImage.m15708a();
            if (a == null) {
                CloseableReference.m15681c(a);
            } else {
                try {
                    NativePooledByteBuffer nativePooledByteBuffer = (NativePooledByteBuffer) a.m15682a();
                    CloseableReference a2 = this.f10651d.m15720a(nativePooledByteBuffer.m15689a());
                    try {
                        byte[] bArr = (byte[]) a2.m15682a();
                        nativePooledByteBuffer.m15690a(0, bArr, 0, nativePooledByteBuffer.m15689a());
                        AnimatedImage a3 = this.f10648a.m15931a(bArr, imageDecodeOptions.f12730b, 0, 0);
                        Iterable a4 = BitmapCounterProvider.m15670a().m15672a(a3.d());
                        try {
                            closeableAnimatedBitmap = new CloseableAnimatedBitmap(a4, a3.e());
                            CloseableReference.m15681c(a);
                        } finally {
                            CloseableReference.m15678a(a4);
                        }
                    } finally {
                        a2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeableReference = a;
                    CloseableReference.m15681c(closeableReference);
                    throw th;
                }
            }
            return closeableAnimatedBitmap;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            closeableReference = null;
            th = th4;
            CloseableReference.m15681c(closeableReference);
            throw th;
        }
    }
}
