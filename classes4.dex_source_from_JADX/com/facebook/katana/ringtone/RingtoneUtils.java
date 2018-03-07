package com.facebook.katana.ringtone;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Audio.Media;
import com.facebook.common.file.MoreFileUtils;
import java.io.File;

/* compiled from: mUploadMaxBytes */
public class RingtoneUtils {
    public Context f8459a;
    private ContentResolver f8460b;
    public AssetManager f8461c;
    public MoreFileUtils f8462d;
    public File f8463e;

    public RingtoneUtils(Context context, ContentResolver contentResolver, AssetManager assetManager, MoreFileUtils moreFileUtils) {
        this.f8459a = context;
        this.f8460b = contentResolver;
        this.f8461c = assetManager;
        this.f8462d = moreFileUtils;
    }

    public final String m8708a() {
        this.f8463e = MoreFileUtils.a("/system/media/audio/notifications/facebook_ringtone_pop.m4a");
        if (!this.f8463e.exists() || this.f8463e.length() == 0) {
            MoreFileUtils.a("/sdcard/media/audio/notifications").mkdirs();
            this.f8463e = MoreFileUtils.a("/sdcard/media/audio/notifications/facebook_ringtone_pop.m4a");
        }
        if (!this.f8463e.exists()) {
            this.f8462d.a(this.f8461c.open("pop.m4a"), this.f8463e);
        }
        String e = m8707e();
        if (e == null) {
            e = m8706d();
            if (e == null) {
                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent.setData(Uri.fromFile(this.f8463e));
                this.f8459a.sendBroadcast(intent);
            }
        }
        return e;
    }

    private String m8706d() {
        return m8705a(Media.EXTERNAL_CONTENT_URI);
    }

    private String m8707e() {
        return m8705a(Media.INTERNAL_CONTENT_URI);
    }

    private String m8705a(Uri uri) {
        if (this.f8459a.checkCallingOrSelfUriPermission(uri, 1) != 0) {
            return null;
        }
        Uri withAppendedPath;
        Uri uri2 = uri;
        Cursor query = this.f8460b.query(uri2, new String[]{"_id", "title", "_data"}, "title=?", new String[]{"Facebook Pop"}, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    int columnIndexOrThrow = query.getColumnIndexOrThrow("_id");
                    do {
                        withAppendedPath = Uri.withAppendedPath(uri, query.getInt(columnIndexOrThrow));
                        if (withAppendedPath != null) {
                            break;
                        }
                    } while (query.moveToNext());
                } else {
                    withAppendedPath = null;
                }
                query.close();
            } catch (Throwable th) {
                query.close();
            }
        } else {
            withAppendedPath = null;
        }
        if (withAppendedPath != null) {
            return withAppendedPath.toString();
        }
        return null;
    }
}
