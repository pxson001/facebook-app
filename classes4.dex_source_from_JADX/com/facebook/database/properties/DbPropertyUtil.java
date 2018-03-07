package com.facebook.database.properties;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.typedkey.TypedKey;
import com.facebook.common.util.TriState;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.base.Supplier;
import javax.annotation.Nullable;

/* compiled from: maxDelayMs < 0 */
public abstract class DbPropertyUtil<T extends TypedKey> {
    public static final SqlColumn f8245a = new SqlColumn("key", "TEXT PRIMARY KEY");
    public static final SqlColumn f8246b = new SqlColumn("value", "TEXT");
    private static final String[] f8247e = new String[]{"value"};
    private final Supplier<SQLiteDatabase> f8248c;
    private final String f8249d;

    protected DbPropertyUtil(Supplier<SQLiteDatabase> supplier, String str) {
        this.f8248c = supplier;
        this.f8249d = str;
    }

    @Nullable
    public String m8551a(T t) {
        String str = null;
        Cursor query = ((SQLiteDatabase) this.f8248c.get()).query(this.f8249d, f8247e, "key = ?", new String[]{t.a()}, null, null, null);
        try {
            if (query.moveToNext()) {
                str = query.getString(0);
            } else {
                query.close();
            }
            return str;
        } finally {
            query.close();
        }
    }

    public final String m8552a(T t, String str) {
        String a = m8551a(t);
        return a == null ? str : a;
    }

    public final int m8549a(T t, int i) {
        String a = m8551a(t);
        if (a != null) {
            try {
                i = Integer.parseInt(a);
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    public final long m8550a(T t, long j) {
        String a = m8551a(t);
        if (a != null) {
            try {
                j = Long.parseLong(a);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    public final boolean m8554a(T t, boolean z) {
        String a = m8551a(t);
        if (a == null) {
            return z;
        }
        try {
            return Long.parseLong(a) != 0;
        } catch (NumberFormatException e) {
            return z;
        }
    }

    public final TriState m8555b(T t) {
        String a = m8551a(t);
        if (a == null) {
            return TriState.UNSET;
        }
        try {
            return TriState.fromDbValue(Integer.parseInt(a));
        } catch (NumberFormatException e) {
            return TriState.UNSET;
        }
    }

    public void m8558b(T t, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", t.a());
        contentValues.put("value", str);
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) this.f8248c.get();
        String str2 = this.f8249d;
        SQLiteDetour.a(354932196);
        sQLiteDatabase.replaceOrThrow(str2, null, contentValues);
        SQLiteDetour.a(-1318522462);
    }

    public final void m8557b(T t, long j) {
        m8558b((TypedKey) t, Long.toString(j));
    }

    public final void m8556b(T t, int i) {
        m8558b((TypedKey) t, Integer.toString(i));
    }

    public final void m8559b(T t, boolean z) {
        m8558b((TypedKey) t, z ? "1" : "0");
    }

    public final void m8553a(T t, TriState triState) {
        m8556b((TypedKey) t, triState.getDbValue());
    }
}
