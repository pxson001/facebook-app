package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;

/* compiled from: TOPIC_PUBLISHER */
public class DownsampleUtil {
    private DownsampleUtil() {
    }

    @VisibleForTesting
    public static float m23114b(ImageRequest imageRequest, EncodedImage encodedImage) {
        Preconditions.a(EncodedImage.c(encodedImage));
        ResizeOptions resizeOptions = imageRequest.a;
        if (resizeOptions == null || resizeOptions.b <= 0 || resizeOptions.a <= 0 || encodedImage.e == 0 || encodedImage.f == 0) {
            return 1.0f;
        }
        int i;
        int c = m23116c(imageRequest, encodedImage);
        int i2 = (c == 90 || c == 270) ? 1 : 0;
        if (i2 != 0) {
            i = encodedImage.f;
        } else {
            i = encodedImage.e;
        }
        if (i2 != 0) {
            c = encodedImage.e;
        } else {
            c = encodedImage.f;
        }
        Object[] objArr = new Object[]{Integer.valueOf(resizeOptions.a), Integer.valueOf(resizeOptions.b), Integer.valueOf(i), Integer.valueOf(c), Float.valueOf(((float) resizeOptions.a) / ((float) i)), Float.valueOf(((float) resizeOptions.b) / ((float) c)), Float.valueOf(Math.max(((float) resizeOptions.a) / ((float) i), ((float) resizeOptions.b) / ((float) c))), imageRequest.c.toString()};
        return Math.max(((float) resizeOptions.a) / ((float) i), ((float) resizeOptions.b) / ((float) c));
    }

    @VisibleForTesting
    public static int m23113a(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (true) {
            if (((1.0d / (Math.pow((double) i, 2.0d) - ((double) i))) * 0.3333333432674408d) + (1.0d / ((double) i)) <= ((double) f)) {
                return i - 1;
            }
            i++;
        }
    }

    @VisibleForTesting
    public static int m23115b(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (true) {
            if (((1.0d / ((double) (i * 2))) * 0.3333333432674408d) + (1.0d / ((double) (i * 2))) <= ((double) f)) {
                return i;
            }
            i *= 2;
        }
    }

    private static int m23116c(ImageRequest imageRequest, EncodedImage encodedImage) {
        boolean z = false;
        if (!imageRequest.h) {
            return 0;
        }
        int i = encodedImage.d;
        if (i == 0 || i == 90 || i == 180 || i == 270) {
            z = true;
        }
        Preconditions.a(z);
        return i;
    }
}
