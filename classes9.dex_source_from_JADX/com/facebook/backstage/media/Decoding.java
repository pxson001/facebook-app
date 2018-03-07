package com.facebook.backstage.media;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/* compiled from: request_tag */
public class Decoding {

    /* compiled from: request_tag */
    public class PhotoSpec {
        public final int f5381a;
        public final int f5382b;
        public final int f5383c;

        public PhotoSpec(int i, int i2, int i3) {
            this.f5381a = i;
            this.f5382b = i2;
            this.f5383c = i3;
        }
    }

    public static Bitmap m5617a(Bitmap bitmap, int i, boolean z, PhotoSpec photoSpec, int i2, float f) {
        if (Math.abs(f - 1.0f) < 1.0E-5f) {
            f = 1.0f;
        }
        int a = m5615a(photoSpec.f5381a, photoSpec.f5382b, i);
        int b = m5620b(photoSpec.f5381a, photoSpec.f5382b, i);
        if (f == 1.0f) {
            if (b < a) {
                a = b;
            } else {
                b = a;
            }
        } else if (a <= b) {
            if (f > ((float) (b / a))) {
                a = (int) ((1.0f / f) * ((float) b));
            } else {
                b = (int) (((float) a) * f);
            }
        } else if (f > ((float) (a / b))) {
            b = (int) ((1.0f / f) * ((float) a));
        } else {
            a = (int) (((float) b) * f);
        }
        return m5616a(bitmap, a, b, z ? i - i2 : i + i2, z);
    }

    public static int m5615a(int i, int i2, int i3) {
        return (i3 == 90 || i3 == 270) ? i2 : i;
    }

    public static int m5620b(int i, int i2, int i3) {
        return (i3 == 90 || i3 == 270) ? i : i2;
    }

    private static Matrix m5618a(int i, int i2, int i3, boolean z) {
        Matrix matrix = new Matrix();
        if (i3 != 0) {
            matrix.postRotate((float) i3, (float) (i / 2), (float) (i2 / 2));
        }
        if (z) {
            matrix.postScale(-1.0f, 1.0f);
        }
        return matrix;
    }

    private static Bitmap m5616a(Bitmap bitmap, int i, int i2, int i3, boolean z) {
        int width;
        int i4;
        int height;
        int i5;
        float f = ((float) i) / ((float) i2);
        int round;
        if (((float) bitmap.getWidth()) / ((float) bitmap.getHeight()) > f) {
            round = Math.round(((float) bitmap.getHeight()) * f);
            width = (bitmap.getWidth() - round) / 2;
            i4 = 0;
            height = bitmap.getHeight();
            i5 = round;
        } else {
            round = bitmap.getWidth();
            int round2 = Math.round(((float) bitmap.getWidth()) / f);
            width = 0;
            i4 = (bitmap.getHeight() - round2) / 2;
            height = round2;
            i5 = round;
        }
        Matrix a = m5618a(i5, height, i3, z);
        a.postScale(((float) i) / ((float) i5), ((float) i2) / ((float) height));
        int i6 = 0;
        Bitmap bitmap2 = null;
        while (bitmap2 == null && i6 != 5) {
            try {
                bitmap2 = Bitmap.createBitmap(bitmap, width, i4, (int) (((double) i5) / Math.pow(2.0d, (double) i6)), (int) (((double) height) / Math.pow(2.0d, (double) i6)), a, true);
            } catch (OutOfMemoryError e) {
                i6++;
            }
        }
        if (bitmap2 != null) {
            return bitmap2;
        }
        throw new OutOfMemoryError();
    }

    public static byte[] m5619a(Bitmap bitmap, int i) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, i, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
