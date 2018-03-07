package com.facebook.imagepipeline.nativecode;

import android.os.Build.VERSION;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.soloader.SoLoaderShim;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imageformat.ImageFormat;
import com.facebook.proxygen.HTTPTransportCallback;
import java.io.InputStream;
import java.io.OutputStream;

@DoNotStrip
/* compiled from: last_upload */
public class WebpTranscoderImpl {
    @DoNotStrip
    private static native void nativeTranscodeWebpToJpeg(InputStream inputStream, OutputStream outputStream, int i);

    @DoNotStrip
    private static native void nativeTranscodeWebpToPng(InputStream inputStream, OutputStream outputStream);

    static {
        SoLoaderShim.a("static-webp");
    }

    public final boolean m25065a(ImageFormat imageFormat) {
        switch (1.a[imageFormat.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                if (VERSION.SDK_INT >= 14) {
                    return true;
                }
                return false;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return WebpSupportStatus.f17780c;
            case 5:
                return false;
            default:
                Preconditions.a(false);
                return false;
        }
    }

    public final void m25064a(InputStream inputStream, OutputStream outputStream, int i) {
        nativeTranscodeWebpToJpeg((InputStream) Preconditions.a(inputStream), (OutputStream) Preconditions.a(outputStream), i);
    }

    public final void m25063a(InputStream inputStream, OutputStream outputStream) {
        nativeTranscodeWebpToPng((InputStream) Preconditions.a(inputStream), (OutputStream) Preconditions.a(outputStream));
    }
}
