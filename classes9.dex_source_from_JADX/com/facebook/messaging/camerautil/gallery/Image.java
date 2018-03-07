package com.facebook.messaging.camerautil.gallery;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import com.facebook.messaging.camerautil.CameraUtil;

/* compiled from: messenger_save_photo_fail */
public class Image extends BaseImage implements IImage {
    private static final Class<?> f9712i = Image.class;
    private static final String[] f9713k = new String[]{"_id"};
    private int f9714j;

    public Image(BaseImageList baseImageList, ContentResolver contentResolver, long j, int i, Uri uri, String str, long j2, String str2, long j3, String str3, String str4, int i2) {
        super(baseImageList, contentResolver, j, i, uri, str, j2, str2, j3, str3, str4);
        this.f9714j = i2;
    }

    public final int mo394c() {
        return this.f9714j;
    }

    public final Bitmap mo393a(boolean z) {
        Options options = new Options();
        options.inDither = false;
        options.inPreferredConfig = Config.ARGB_8888;
        Bitmap thumbnail = Thumbnails.getThumbnail(this.f9689a, this.f9691c, 1, options);
        if (thumbnail == null || !z) {
            return thumbnail;
        }
        return CameraUtil.m10217a(thumbnail, mo394c());
    }
}
