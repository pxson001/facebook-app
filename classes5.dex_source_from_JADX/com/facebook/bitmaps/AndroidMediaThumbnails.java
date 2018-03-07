package com.facebook.bitmaps;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video;

@Deprecated
/* compiled from: android_feather_post_compose */
public class AndroidMediaThumbnails {
    public static Bitmap m18439a(ContentResolver contentResolver, long j, int i, boolean z, Options options) {
        if (z) {
            return Thumbnails.getThumbnail(contentResolver, j, i, options);
        }
        return Video.Thumbnails.getThumbnail(contentResolver, j, i, options);
    }
}
