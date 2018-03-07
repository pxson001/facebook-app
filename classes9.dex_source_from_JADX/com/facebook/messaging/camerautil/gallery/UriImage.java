package com.facebook.messaging.camerautil.gallery;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.facebook.debug.log.BLog;
import com.facebook.messaging.camerautil.CameraUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: messenger_quickcam_save_enabled */
class UriImage implements IImage {
    private static final Class<?> f9733a = UriImage.class;
    private final Uri f9734b;
    private final IImageList f9735c;
    private final ContentResolver f9736d;

    UriImage(IImageList iImageList, ContentResolver contentResolver, Uri uri) {
        this.f9735c = iImageList;
        this.f9736d = contentResolver;
        this.f9734b = uri;
    }

    private int m10317c() {
        try {
            if (!this.f9734b.getScheme().equals("file")) {
                return 0;
            }
            int attributeInt = new ExifInterface(this.f9734b.getPath()).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt == 8) {
                return 270;
            }
            return 0;
        } catch (IOException e) {
            return 0;
        }
    }

    public final String mo390a() {
        return this.f9734b.getPath();
    }

    private ParcelFileDescriptor m10318e() {
        try {
            if (this.f9734b.getScheme().equals("file")) {
                return ParcelFileDescriptor.open(new File(this.f9734b.getPath()), 268435456);
            }
            return this.f9736d.openFileDescriptor(this.f9734b, "r");
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public final Bitmap mo389a(int i, int i2) {
        return m10316a(i, i2, true, false);
    }

    private Bitmap m10315a(int i, int i2, boolean z) {
        return m10316a(i, i2, z, false);
    }

    private Bitmap m10316a(int i, int i2, boolean z, boolean z2) {
        try {
            Bitmap a = CameraUtil.m10216a(i, i2, m10318e(), z2);
            if (a == null || !z) {
                return a;
            }
            return CameraUtil.m10217a(a, m10317c());
        } catch (Throwable e) {
            BLog.b(f9733a, "got exception decoding bitmap ", e);
            return null;
        }
    }

    public final String mo392d() {
        return this.f9734b.toString();
    }

    public final Bitmap mo393a(boolean z) {
        return m10315a(320, 196608, z);
    }

    public final long mo391b() {
        return 0;
    }
}
