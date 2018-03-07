package com.facebook.database.properties;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.common.typedkey.TypedKey;
import javax.annotation.Nullable;

/* compiled from: secondary_button_override_back_only */
public abstract class DbPropertyUtilForOtherContentProvider<T extends TypedKey> {
    private static final String[] f2862c = new String[]{"value"};
    private final ContentResolver f2863a;
    private final Uri f2864b;

    protected DbPropertyUtilForOtherContentProvider(ContentResolver contentResolver, Uri uri) {
        this.f2863a = contentResolver;
        this.f2864b = uri;
    }

    @Nullable
    public final String m3992a(T t) {
        String str = null;
        Cursor query = this.f2863a.query(this.f2864b, f2862c, "key=?", new String[]{t.a()}, null);
        if (query != null) {
            try {
                if (query.moveToNext()) {
                    str = query.getString(0);
                    return str;
                }
            } finally {
                if (query != null) {
                    query.close();
                }
            }
        }
        if (query != null) {
            query.close();
        }
        return str;
    }

    public final String m3993a(T t, String str) {
        String a = m3992a(t);
        return a == null ? str : a;
    }

    public final long m3991a(T t, long j) {
        String a = m3992a(t);
        if (a != null) {
            try {
                j = Long.parseLong(a);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    public final boolean m3995a(T t, boolean z) {
        String a = m3992a(t);
        if (a == null) {
            return z;
        }
        try {
            return Long.parseLong(a) != 0;
        } catch (NumberFormatException e) {
            return z;
        }
    }

    public final void m3997b(T t, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", t.a());
        contentValues.put("value", str);
        this.f2863a.insert(this.f2864b, contentValues);
    }

    public final void m3996b(T t, long j) {
        m3997b((TypedKey) t, Long.toString(j));
    }

    public final void m3994a(T t, int i) {
        m3997b((TypedKey) t, Integer.toString(i));
    }

    public final void m3998b(T t, boolean z) {
        m3997b((TypedKey) t, z ? "1" : "0");
    }
}
