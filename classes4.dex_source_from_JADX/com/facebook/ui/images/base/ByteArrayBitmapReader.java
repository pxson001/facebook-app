package com.facebook.ui.images.base;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.facebook.bitmaps.FbBitmapFactory;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imageutils.JfifUtil;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Deprecated
/* compiled from: end_call_summary */
public class ByteArrayBitmapReader extends BitmapReader {
    private final byte[] f13033a;

    public ByteArrayBitmapReader(byte[] bArr) {
        this.f13033a = bArr;
    }

    public final Options mo939a() {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        FbBitmapFactory.m13883a(this.f13033a, 0, this.f13033a.length, options);
        return options;
    }

    public final int mo940b() {
        InputStream byteArrayInputStream = new ByteArrayInputStream(this.f13033a);
        if (ImageFormatChecker.b(byteArrayInputStream) == ImageFormat.JPEG) {
            return JfifUtil.a(byteArrayInputStream);
        }
        return 0;
    }

    public final Bitmap mo938a(Options options) {
        return FbBitmapFactory.m13883a(this.f13033a, 0, this.f13033a.length, options);
    }
}
