package com.facebook.ui.images.base;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import com.facebook.bitmaps.FbBitmapFactory;
import com.google.common.io.Closeables;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Deprecated
/* compiled from: seekTo ( */
public class FileBitmapReader extends BitmapReader {
    private final File f5097a;

    public FileBitmapReader(File file) {
        this.f5097a = file;
    }

    public final Options m7853a() {
        InputStream fileInputStream = new FileInputStream(this.f5097a);
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            FbBitmapFactory.a(fileInputStream.getFD(), null, options);
            return options;
        } finally {
            Closeables.a(fileInputStream);
        }
    }

    public final int m7854b() {
        return new ExifInterface(this.f5097a.getPath()).getAttributeInt("Orientation", 1);
    }

    public final Bitmap m7852a(Options options) {
        InputStream fileInputStream = new FileInputStream(this.f5097a);
        try {
            Bitmap a = FbBitmapFactory.a(fileInputStream.getFD(), null, options);
            return a;
        } finally {
            Closeables.a(fileInputStream);
        }
    }
}
