package com.facebook.messaging.camerautil.gallery;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;

/* compiled from: messenger_record_stop */
public class ImageList extends BaseImageList implements IImageList {
    static final String[] f9715h = new String[]{"_id", "_data", "datetaken", "mini_thumb_magic", "orientation", "title", "mime_type", "date_modified"};
    private static final Class<?> f9716i = ImageList.class;
    public static final String[] f9717j = new String[]{"image/jpeg", "image/png", "image/gif"};

    public ImageList(ContentResolver contentResolver, Uri uri, Uri uri2, int i, String str) {
        super(contentResolver, uri, i, str);
        this.f = uri2;
    }

    protected final Cursor mo397d() {
        String str;
        Object obj;
        ContentResolver contentResolver = this.f9704a;
        Uri uri = this.f9706c;
        String[] strArr = f9715h;
        if (this.f9708e == null) {
            str = "(mime_type in (?, ?, ?))";
        } else {
            str = "(mime_type in (?, ?, ?)) AND bucket_id = ?";
        }
        String str2 = str;
        if (this.f9708e != null) {
            int length = f9717j.length;
            obj = new String[(length + 1)];
            System.arraycopy(f9717j, 0, obj, 0, length);
            obj[length] = this.f9708e;
        } else {
            obj = f9717j;
        }
        Object obj2 = obj;
        str = this.f9705b == 1 ? " ASC" : " DESC";
        return Media.query(contentResolver, uri, strArr, str2, obj2, "case ifnull(datetaken,0) when 0 then date_modified*1000 else datetaken end" + str + ", _id" + str);
    }

    protected final long mo396b(Cursor cursor) {
        return cursor.getLong(0);
    }

    protected final BaseImage mo395a(Cursor cursor) {
        long j = cursor.getLong(0);
        String string = cursor.getString(1);
        long j2 = cursor.getLong(2);
        if (j2 == 0) {
            j2 = cursor.getLong(7) * 1000;
        }
        long j3 = cursor.getLong(3);
        int i = cursor.getInt(4);
        String string2 = cursor.getString(5);
        String string3 = cursor.getString(6);
        if (string2 == null || string2.length() == 0) {
            string2 = string;
        }
        return new Image(this, this.f9704a, j, cursor.getPosition(), m10292a(j), string, j3, string3, j2, string2, string2, i);
    }
}
