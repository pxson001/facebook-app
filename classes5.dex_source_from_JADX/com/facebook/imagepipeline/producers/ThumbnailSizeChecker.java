package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;

/* compiled from: TOPIC_KITCHEN_SUPPLIES */
public final class ThumbnailSizeChecker {
    public static boolean m23220a(int i, int i2, ResizeOptions resizeOptions) {
        if (resizeOptions == null) {
            if (((float) m23219a(i)) < 2048.0f || m23219a(i2) < 2048) {
                return false;
            }
            return true;
        } else if (m23219a(i) < resizeOptions.a || m23219a(i2) < resizeOptions.b) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean m23221a(EncodedImage encodedImage, ResizeOptions resizeOptions) {
        if (encodedImage == null) {
            return false;
        }
        switch (encodedImage.d) {
            case 90:
            case 270:
                return m23220a(encodedImage.f, encodedImage.e, resizeOptions);
            default:
                return m23220a(encodedImage.e, encodedImage.f, resizeOptions);
        }
    }

    private static int m23219a(int i) {
        return (int) (((float) i) * 1.3333334f);
    }
}
