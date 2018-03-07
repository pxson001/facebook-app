package com.facebook.timeline.profilevideo.mediastore;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.MediaStore.Files;
import android.support.annotation.Nullable;
import com.facebook.ipc.media.MediaCursorHelper;
import com.facebook.ipc.media.SupportedMediaType;
import com.google.common.base.Preconditions;

@TargetApi(11)
/* compiled from: mPageName */
public class ProfileVideoMediaStoreHelper {
    @Nullable
    public static String m11119a(ContentResolver contentResolver, SupportedMediaType supportedMediaType) {
        Throwable th;
        Cursor cursor = null;
        Preconditions.checkNotNull(contentResolver);
        try {
            Cursor query = contentResolver.query(Files.getContentUri("external"), new String[]{"_id", "_data", "datetaken"}, MediaCursorHelper.a(supportedMediaType), null, "date_modified DESC LIMIT 1");
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            try {
                if (query.moveToFirst()) {
                    String string = query.getString(1);
                    if (query == null) {
                        return string;
                    }
                    query.close();
                    return string;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
