package com.facebook.imagepipeline.nativecode;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.imageutils.BitmapUtil;
import java.nio.ByteBuffer;

@DoNotStrip
/* compiled from: page/%s/videolist?page_id=%s&source=%s */
public class Bitmaps {
    @DoNotStrip
    private static native void nativeCopyBitmap(Bitmap bitmap, int i, Bitmap bitmap2, int i2, int i3);

    @DoNotStrip
    private static native ByteBuffer nativeGetByteBuffer(Bitmap bitmap, long j, long j2);

    @DoNotStrip
    private static native void nativePinBitmap(Bitmap bitmap);

    @DoNotStrip
    private static native void nativeReleaseByteBuffer(Bitmap bitmap);

    static {
        ImagePipelineNativeLoader.m22611a();
    }

    public static void m15694a(Bitmap bitmap) {
        Preconditions.a(bitmap);
        nativePinBitmap(bitmap);
    }

    public static ByteBuffer m15693a(Bitmap bitmap, long j, long j2) {
        Preconditions.a(bitmap);
        return nativeGetByteBuffer(bitmap, j, j2);
    }

    public static void m15697b(Bitmap bitmap) {
        Preconditions.a(bitmap);
        nativeReleaseByteBuffer(bitmap);
    }

    public static void m15696a(Bitmap bitmap, Bitmap bitmap2) {
        boolean z;
        boolean z2 = true;
        Preconditions.a(bitmap2.getConfig() == bitmap.getConfig());
        Preconditions.a(bitmap.isMutable());
        if (bitmap.getWidth() == bitmap2.getWidth()) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.a(z);
        if (bitmap.getHeight() != bitmap2.getHeight()) {
            z2 = false;
        }
        Preconditions.a(z2);
        nativeCopyBitmap(bitmap, bitmap.getRowBytes(), bitmap2, bitmap2.getRowBytes(), bitmap.getHeight());
    }

    @TargetApi(19)
    public static void m15695a(Bitmap bitmap, int i, int i2, Config config) {
        Preconditions.a(bitmap.getAllocationByteCount() >= (i * i2) * BitmapUtil.m25067a(config));
        bitmap.reconfigure(i, i2, config);
    }
}
