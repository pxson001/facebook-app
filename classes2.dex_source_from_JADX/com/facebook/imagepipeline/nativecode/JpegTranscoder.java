package com.facebook.imagepipeline.nativecode;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import java.io.InputStream;
import java.io.OutputStream;

@DoNotStrip
/* compiled from: link_hide_photo */
public class JpegTranscoder {
    @DoNotStrip
    private static native void nativeTranscodeJpeg(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3);

    static {
        ImagePipelineNativeLoader.m22611a();
    }

    private static boolean m24527a(int i) {
        return i >= 0 && i <= 270 && i % 90 == 0;
    }

    public static void m24526a(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) {
        boolean z;
        boolean z2 = false;
        Preconditions.a(i2 > 0);
        if (i2 <= 16) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.a(z);
        if (i3 >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.a(z);
        if (i3 <= 100) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.a(z);
        Preconditions.a(m24527a(i));
        if (!(i2 == 8 && i == 0)) {
            z2 = true;
        }
        Preconditions.a(z2, "no transformation requested");
        nativeTranscodeJpeg((InputStream) Preconditions.a(inputStream), (OutputStream) Preconditions.a(outputStream), i, i2, i3);
    }
}
