package com.facebook.groups.docsandfiles.utils;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import android.webkit.MimeTypeMap;
import com.google.common.base.Strings;
import java.io.File;

/* compiled from: Unknown item type for TimelineContextualInfoAdapter of type  */
public class FileUtils {
    private FileUtils() {
    }

    public static String m22521a(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            return str.substring(lastIndexOf);
        }
        return "";
    }

    public static String m22520a(File file) {
        String a = m22521a(file.getName());
        if (Strings.isNullOrEmpty(a)) {
            return "application/octet-stream";
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(a.substring(1));
    }

    private static String m22519a(Context context, Uri uri, String str, String[] strArr) {
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndexOrThrow("_data"));
                        if (query == null) {
                            return string;
                        }
                        query.close();
                        return string;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static String m22518a(Context context, Uri uri) {
        Uri uri2 = null;
        if (uri == null) {
            return null;
        }
        if ((VERSION.SDK_INT >= 19 ? 1 : 0) != 0 && DocumentsContract.isDocumentUri(context, uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            String[] split;
            if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
                split = documentId.split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
                return null;
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                return m22519a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(documentId)), null, null);
            } else {
                if (!"com.android.providers.media.documents".equals(uri.getAuthority())) {
                    return null;
                }
                Object obj = documentId.split(":")[0];
                if ("image".equals(obj)) {
                    uri2 = Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(obj)) {
                    uri2 = Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(obj)) {
                    uri2 = Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return m22519a(context, uri2, "_id=?", new String[]{split[1]});
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            if ("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
                return uri.getLastPathSegment();
            }
            return m22519a(context, uri, null, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        } else {
            return null;
        }
    }
}
