package com.facebook.imagepipeline.animated.factory;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.NativePooledByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: p2p_android_settings */
public class AnimatedImageFactoryImpl {
    static AnimatedImageDecoder f10630a;
    static AnimatedImageDecoder f10631b;
    private final AnimatedDrawableBackendProvider f10632c;
    private final PlatformBitmapFactory f10633d;

    static {
        f10630a = null;
        f10631b = null;
        f10630a = m15824a("com.facebook.animated.gif.GifImage");
        f10631b = m15824a("com.facebook.animated.webp.WebPImage");
    }

    private static AnimatedImageDecoder m15824a(String str) {
        try {
            return (AnimatedImageDecoder) Class.forName(str).newInstance();
        } catch (Throwable th) {
            return null;
        }
    }

    public AnimatedImageFactoryImpl(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, PlatformBitmapFactory platformBitmapFactory) {
        this.f10632c = animatedDrawableBackendProvider;
        this.f10633d = platformBitmapFactory;
    }

    public final CloseableImage m15827a(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions, Config config) {
        if (f10630a == null) {
            throw new UnsupportedOperationException("To encode animated gif please add the dependency to the animated-gif module");
        }
        CloseableReference a = encodedImage.m15708a();
        Preconditions.a(a);
        try {
            Preconditions.b(!imageDecodeOptions.f12731c);
            NativePooledByteBuffer nativePooledByteBuffer = (NativePooledByteBuffer) a.m15682a();
            CloseableImage a2 = m15825a(imageDecodeOptions, f10630a.mo2030a(nativePooledByteBuffer.m15691b(), nativePooledByteBuffer.m15689a()), config);
            return a2;
        } finally {
            CloseableReference.m15681c(a);
        }
    }

    public final CloseableImage m15828b(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions, Config config) {
        if (f10631b == null) {
            throw new UnsupportedOperationException("To encode animated webp please add the dependency to the animated-webp module");
        }
        CloseableReference a = encodedImage.m15708a();
        Preconditions.a(a);
        try {
            Preconditions.a(!imageDecodeOptions.f12731c);
            NativePooledByteBuffer nativePooledByteBuffer = (NativePooledByteBuffer) a.m15682a();
            CloseableImage a2 = m15825a(imageDecodeOptions, f10631b.mo2030a(nativePooledByteBuffer.m15691b(), nativePooledByteBuffer.m15689a()), config);
            return a2;
        } finally {
            CloseableReference.m15681c(a);
        }
    }

    private CloseableAnimatedImage m15825a(ImageDecodeOptions imageDecodeOptions, AnimatedImage animatedImage, Config config) {
        Throwable th;
        CloseableReference closeableReference = null;
        Iterable a;
        try {
            int c;
            if (imageDecodeOptions.f12733e) {
                c = animatedImage.mo2034c() - 1;
            } else {
                c = 0;
            }
            if (imageDecodeOptions.f12734f) {
                a = m15826a(animatedImage, config);
                try {
                    closeableReference = CloseableReference.m15680b((CloseableReference) a.get(c));
                } catch (Throwable th2) {
                    th = th2;
                    CloseableReference.m15681c(null);
                    CloseableReference.m15678a(a);
                    throw th;
                }
            }
            a = null;
            if (imageDecodeOptions.f12732d && r1 == null) {
                closeableReference = m15823a(animatedImage, config, c);
            }
            CloseableAnimatedImage closeableAnimatedImage = new CloseableAnimatedImage(AnimatedImageResult.b(animatedImage).a(closeableReference).a(c).a(a).e());
            CloseableReference.m15681c(closeableReference);
            CloseableReference.m15678a(a);
            return closeableAnimatedImage;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            CloseableReference.m15681c(null);
            CloseableReference.m15678a(a);
            throw th;
        }
    }

    private CloseableReference<Bitmap> m15823a(AnimatedImage animatedImage, Config config, int i) {
        CloseableReference<Bitmap> a = m15822a(animatedImage.mo2029a(), animatedImage.mo2032b(), config);
        new AnimatedImageCompositor(this.f10632c.mo2028a(AnimatedImageResult.a(animatedImage), null), new 1(this)).a(i, (Bitmap) a.m15682a());
        return a;
    }

    private List<CloseableReference<Bitmap>> m15826a(AnimatedImage animatedImage, Config config) {
        List<CloseableReference<Bitmap>> arrayList = new ArrayList();
        AnimatedDrawableBackend a = this.f10632c.mo2028a(AnimatedImageResult.a(animatedImage), null);
        AnimatedImageCompositor animatedImageCompositor = new AnimatedImageCompositor(a, new 2(this, arrayList));
        for (int i = 0; i < a.c(); i++) {
            CloseableReference a2 = m15822a(a.e(), a.f(), config);
            animatedImageCompositor.a(i, (Bitmap) a2.m15682a());
            arrayList.add(a2);
        }
        return arrayList;
    }

    @SuppressLint({"NewApi"})
    private CloseableReference<Bitmap> m15822a(int i, int i2, Config config) {
        CloseableReference<Bitmap> a = this.f10633d.mo2020a(i, i2, config);
        ((Bitmap) a.m15682a()).eraseColor(0);
        if (VERSION.SDK_INT >= 12) {
            ((Bitmap) a.m15682a()).setHasAlpha(true);
        }
        return a;
    }
}
