package com.facebook.reportaproblem.fb;

import android.graphics.Bitmap;
import com.facebook.bitmaps.ImageResizer;
import com.facebook.bitmaps.ImageResizer.ImageResizingException;
import com.facebook.debug.log.BLog;
import java.io.File;
import javax.inject.Inject;

/* compiled from: setPluginConfig */
public class FbBitmapDecoder {
    private final ImageResizer f4604a;

    @Inject
    public FbBitmapDecoder(ImageResizer imageResizer) {
        this.f4604a = imageResizer;
    }

    public final Bitmap m7115a(File file, int i, int i2) {
        try {
            return this.f4604a.a(file.getAbsolutePath(), 0, i, i2, false);
        } catch (ImageResizingException e) {
            BLog.b("FbBitmapDecoder", "Failed to decode image", e);
            return null;
        }
    }
}
