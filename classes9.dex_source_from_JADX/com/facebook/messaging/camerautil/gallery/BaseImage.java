package com.facebook.messaging.camerautil.gallery;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.messaging.camerautil.CameraUtil;

/* compiled from: messenger_save_photo_success */
public abstract class BaseImage implements IImage {
    private static final Class<?> f9688i = BaseImage.class;
    public ContentResolver f9689a;
    protected Uri f9690b;
    public long f9691c;
    protected String f9692d;
    protected long f9693e;
    protected final int f9694f;
    protected String f9695g;
    public BaseImageList f9696h;
    private final long f9697j;
    private String f9698k;
    private final String f9699l;
    private int f9700m = -1;
    private int f9701n = -1;

    protected BaseImage(BaseImageList baseImageList, ContentResolver contentResolver, long j, int i, Uri uri, String str, long j2, String str2, long j3, String str3, String str4) {
        this.f9696h = baseImageList;
        this.f9689a = contentResolver;
        this.f9691c = j;
        this.f9694f = i;
        this.f9690b = uri;
        this.f9692d = str;
        this.f9693e = j2;
        this.f9695g = str2;
        this.f9697j = j3;
        this.f9698k = str3;
        this.f9699l = str4;
    }

    public final String mo390a() {
        return this.f9692d;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Image)) {
            return false;
        }
        return this.f9690b.equals(((Image) obj).f9690b);
    }

    public int hashCode() {
        return this.f9690b.hashCode();
    }

    public final Bitmap mo389a(int i, int i2) {
        Bitmap bitmap;
        Uri a = this.f9696h.m10292a(this.f9691c);
        if (a == null) {
            bitmap = null;
        } else {
            bitmap = CameraUtil.m10215a(i, i2, a, this.f9689a, false);
            if (!(bitmap == null || 1 == 0)) {
                bitmap = CameraUtil.m10217a(bitmap, mo394c());
            }
        }
        return bitmap;
    }

    public final long mo391b() {
        return this.f9697j;
    }

    public int mo394c() {
        return 0;
    }

    public final String mo392d() {
        return this.f9698k;
    }

    public String toString() {
        return this.f9690b.toString();
    }
}
