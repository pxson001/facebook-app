package com.facebook.facedetection.detector;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.facedetection.FaceDetectionAnalyticsLogger;
import com.facebook.facedetection.models.FaceDescriptor;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: numTopResultsToShow */
public class FaceDetectorCropUtil {
    private final PlatformBitmapFactory f9801a;
    private final FaceDetectionAnalyticsLogger f9802b;

    @Inject
    public FaceDetectorCropUtil(PlatformBitmapFactory platformBitmapFactory, FaceDetectionAnalyticsLogger faceDetectionAnalyticsLogger) {
        this.f9801a = platformBitmapFactory;
        this.f9802b = faceDetectionAnalyticsLogger;
    }

    @SuppressLint({"BadMethodUse-android.graphics.Bitmap.createScaledBitmap"})
    @Nullable
    public final byte[] m15547a(FaceDescriptor faceDescriptor, Bitmap bitmap) {
        Throwable th;
        Throwable th2;
        Rect a = m15546a(faceDescriptor, bitmap.getWidth(), bitmap.getHeight());
        try {
            CloseableReference a2 = this.f9801a.a(a.width(), a.height());
            try {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] toByteArray;
                if (Math.max(a.width(), a.height()) < 304) {
                    ((Bitmap) a2.a()).compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
                    toByteArray = byteArrayOutputStream.toByteArray();
                    if (a2 == null) {
                        return toByteArray;
                    }
                    a2.close();
                    return toByteArray;
                }
                Bitmap.createScaledBitmap((Bitmap) a2.a(), 304, 304, false).compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
                toByteArray = byteArrayOutputStream.toByteArray();
                if (a2 == null) {
                    return toByteArray;
                }
                a2.close();
                return toByteArray;
            } catch (Throwable th22) {
                Throwable th3 = th22;
                th22 = th;
                th = th3;
            }
            if (a2 != null) {
                if (th22 != null) {
                    try {
                        a2.close();
                    } catch (Throwable th4) {
                        AndroidCompat.addSuppressed(th22, th4);
                    }
                } else {
                    a2.close();
                }
            }
            throw th;
            throw th;
        } catch (OutOfMemoryError e) {
            this.f9802b.m15534a(StringLocaleUtil.a("OutOfMemory %0.3f %0.3f", new Object[]{Integer.valueOf(a.width()), Integer.valueOf(a.height())}));
            return null;
        }
    }

    private static Rect m15546a(FaceDescriptor faceDescriptor, int i, int i2) {
        float min = Math.min((faceDescriptor.m15578c() - faceDescriptor.m15576a()) * ((float) i), (faceDescriptor.m15579d() - faceDescriptor.m15577b()) * ((float) i2)) * 1.8f;
        float a = ((faceDescriptor.m15576a() + faceDescriptor.m15578c()) / 2.0f) * ((float) i);
        float max = Math.max(0.0f, a - (min / 2.0f));
        a = Math.min((float) i, a + (min / 2.0f));
        float b = ((faceDescriptor.m15577b() + faceDescriptor.m15579d()) / 2.0f) * ((float) i2);
        return new Rect((int) max, (int) Math.max(0.0f, b - (min / 2.0f)), (int) a, (int) Math.min((float) i2, (min / 2.0f) + b));
    }
}
