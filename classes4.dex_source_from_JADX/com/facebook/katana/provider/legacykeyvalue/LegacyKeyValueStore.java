package com.facebook.katana.provider.legacykeyvalue;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.google.common.annotations.VisibleForTesting;

@Deprecated
/* compiled from: get_robotext_preview */
public class LegacyKeyValueStore {
    public final ContentResolver f11063a;
    public final Uri f11064b;
    private final Uri f11065c;
    private final String f11066d;
    private final String f11067e;
    private final String[] f11068f = new String[]{this.f11067e};
    private final AbstractFbErrorReporter f11069g;

    public LegacyKeyValueStore(ContentResolver contentResolver, Uri uri, Uri uri2, String str, String str2, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f11063a = contentResolver;
        this.f11064b = uri;
        this.f11065c = uri2;
        this.f11066d = str;
        this.f11067e = str2;
        this.f11069g = abstractFbErrorReporter;
    }

    @VisibleForTesting
    final String m11496a(String str) {
        String str2 = null;
        Cursor query = this.f11063a.query(Uri.withAppendedPath(this.f11065c, str), this.f11068f, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    str2 = query.getString(0);
                }
                query.close();
            } catch (Throwable th) {
                query.close();
            }
        }
        return str2;
    }

    @VisibleForTesting
    final void m11497b(String str) {
        this.f11063a.delete(this.f11064b, this.f11066d + "=" + DatabaseUtils.sqlEscapeString(str), null);
    }
}
