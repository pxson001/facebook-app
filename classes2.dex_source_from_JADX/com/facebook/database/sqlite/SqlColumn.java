package com.facebook.database.sqlite;

import android.database.Cursor;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: viewer_subscription_level */
public class SqlColumn {
    public static final SqlColumn f1022a = new SqlColumn("rowid", "INTEGER");
    public static final Function<SqlColumn, String> f1023b = new C00581();
    public static final Function<SqlColumn, String> f1024c = new C00592();
    public final String f1025d;
    public final String f1026e;

    /* compiled from: viewer_subscription_level */
    final class C00581 implements Function<SqlColumn, String> {
        C00581() {
        }

        public final Object apply(@Nullable Object obj) {
            SqlColumn sqlColumn = (SqlColumn) obj;
            return sqlColumn.f1025d + " " + sqlColumn.f1026e;
        }
    }

    /* compiled from: viewer_subscription_level */
    final class C00592 implements Function<SqlColumn, String> {
        C00592() {
        }

        public final Object apply(@Nullable Object obj) {
            return ((SqlColumn) obj).f1025d;
        }
    }

    public SqlColumn(String str, String str2) {
        this.f1025d = str;
        this.f1026e = str2;
    }

    public String toString() {
        return this.f1025d;
    }

    public final String m2091a() {
        return this.f1025d;
    }

    public final Expression m2090a(String str) {
        return SqlExpression.m10727a(this.f1025d, str);
    }

    public final Expression m2092b(String str) {
        return SqlExpression.m10733b(this.f1025d, str);
    }

    public final Expression m2095c(String str) {
        return SqlExpression.m10736c(this.f1025d, str);
    }

    public final Expression m2097d(String str) {
        return SqlExpression.m10738e(this.f1025d, str);
    }

    public final Expression m2099e(String str) {
        return SqlExpression.m10739f(this.f1025d, str);
    }

    public final String m2098d() {
        return this.f1025d + " ASC";
    }

    public final String m2100e() {
        return this.f1025d + " DESC";
    }

    public final int m2089a(Cursor cursor) {
        return cursor.getColumnIndexOrThrow(this.f1025d);
    }

    public final String m2093b(Cursor cursor) {
        return cursor.getString(m2089a(cursor));
    }

    public final long m2094c(Cursor cursor) {
        return cursor.getLong(m2089a(cursor));
    }

    public final int m2096d(Cursor cursor) {
        return cursor.getInt(m2089a(cursor));
    }

    public final byte[] m2101e(Cursor cursor) {
        return cursor.getBlob(m2089a(cursor));
    }

    public static final Function<SqlColumn, String> m2088f(String str) {
        return new 3(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SqlColumn sqlColumn = (SqlColumn) obj;
        if (this.f1025d == null ? sqlColumn.f1025d != null : !this.f1025d.equals(sqlColumn.f1025d)) {
            return false;
        }
        if (this.f1026e != null) {
            if (this.f1026e.equals(sqlColumn.f1026e)) {
                return true;
            }
        } else if (sqlColumn.f1026e == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.f1025d != null) {
            hashCode = this.f1025d.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode *= 31;
        if (this.f1026e != null) {
            i = this.f1026e.hashCode();
        }
        return hashCode + i;
    }
}
