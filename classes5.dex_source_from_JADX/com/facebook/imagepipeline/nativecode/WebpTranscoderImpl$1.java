package com.facebook.imagepipeline.nativecode;

import com.facebook.imageformat.ImageFormat;

/* compiled from: TOPIC_TOURS_SIGHTSEEING */
/* synthetic */ class WebpTranscoderImpl$1 {
    static final /* synthetic */ int[] f13745a = new int[ImageFormat.values().length];

    static {
        try {
            f13745a[ImageFormat.WEBP_SIMPLE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f13745a[ImageFormat.WEBP_LOSSLESS.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f13745a[ImageFormat.WEBP_EXTENDED.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f13745a[ImageFormat.WEBP_EXTENDED_WITH_ALPHA.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f13745a[ImageFormat.WEBP_ANIMATED.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
