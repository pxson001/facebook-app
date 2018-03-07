package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap.Config;
import com.facebook.common.internal.Closeables;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.GifFormatChecker;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.proxygen.HTTPTransportCallback;
import java.io.InputStream;

/* compiled from: overridden_viewer_context */
public class ImageDecoder {
    private final AnimatedImageFactoryImpl f10652a;
    private final Config f10653b;
    private final PlatformDecoder f10654c;

    /* compiled from: overridden_viewer_context */
    /* synthetic */ class C07231 {
        static final /* synthetic */ int[] f17883a = new int[ImageFormat.values().length];

        static {
            try {
                f17883a[ImageFormat.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17883a[ImageFormat.JPEG.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17883a[ImageFormat.GIF.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f17883a[ImageFormat.WEBP_ANIMATED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public ImageDecoder(AnimatedImageFactoryImpl animatedImageFactoryImpl, PlatformDecoder platformDecoder, Config config) {
        this.f10652a = animatedImageFactoryImpl;
        this.f10653b = config;
        this.f10654c = platformDecoder;
    }

    public CloseableImage mo2054a(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions) {
        InputStream b = encodedImage.m15711b();
        if (b == null) {
            return null;
        }
        try {
            CloseableImage a;
            if (imageDecodeOptions.f12735g || !GifFormatChecker.a(b)) {
                a = m15919a(encodedImage);
                Closeables.a(b);
                return a;
            }
            a = this.f10652a.m15827a(encodedImage, imageDecodeOptions, this.f10653b);
            return a;
        } finally {
            Closeables.a(b);
        }
    }

    private CloseableStaticBitmap m15919a(EncodedImage encodedImage) {
        CloseableReference a = this.f10654c.m15668a(encodedImage, this.f10653b);
        try {
            CloseableStaticBitmap closeableStaticBitmap = new CloseableStaticBitmap(a, ImmutableQualityInfo.f17879a, encodedImage.m15715d());
            return closeableStaticBitmap;
        } finally {
            a.close();
        }
    }

    private CloseableStaticBitmap m15920a(EncodedImage encodedImage, int i, ImmutableQualityInfo immutableQualityInfo) {
        CloseableReference a = this.f10654c.m15669a(encodedImage, this.f10653b, i);
        try {
            CloseableStaticBitmap closeableStaticBitmap = new CloseableStaticBitmap(a, immutableQualityInfo, encodedImage.m15715d());
            return closeableStaticBitmap;
        } finally {
            a.close();
        }
    }

    public CloseableImage mo2055b(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions) {
        return this.f10652a.m15828b(encodedImage, imageDecodeOptions, this.f10653b);
    }

    public final CloseableImage m15921a(EncodedImage encodedImage, int i, ImmutableQualityInfo immutableQualityInfo, ImageDecodeOptions imageDecodeOptions) {
        ImageFormat imageFormat = encodedImage.f10563c;
        if (imageFormat == null || imageFormat == ImageFormat.UNKNOWN) {
            imageFormat = ImageFormatChecker.m24998b(encodedImage.m15711b());
        }
        switch (C07231.f17883a[imageFormat.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                throw new IllegalArgumentException("unknown image format");
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return m15920a(encodedImage, i, immutableQualityInfo);
            case 3:
                return mo2054a(encodedImage, imageDecodeOptions);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return mo2055b(encodedImage, imageDecodeOptions);
            default:
                return m15919a(encodedImage);
        }
    }
}
