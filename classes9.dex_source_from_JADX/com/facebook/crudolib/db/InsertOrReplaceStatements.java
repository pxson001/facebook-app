package com.facebook.crudolib.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.WorkerThread;
import android.util.SparseArray;
import java.util.WeakHashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@WorkerThread
@ThreadSafe
/* compiled from: TreehouseRNPreGallery */
public class InsertOrReplaceStatements {
    private final String f23982a;
    private final String[] f23983b;
    private final String[] f23984c;
    private final WeakHashMap<SQLiteDatabase, StatementsHolder> f23985d = new WeakHashMap(1);

    /* compiled from: TreehouseRNPreGallery */
    class StatementsHolder {
        public final SparseArray<String> f23979a = new SparseArray(3);
        @Nullable
        public SQLiteStatement f23980b;
        @Nullable
        public SQLiteStatement f23981c;

        StatementsHolder() {
        }
    }

    public InsertOrReplaceStatements(String str, String[] strArr, String[] strArr2) {
        this.f23982a = str;
        this.f23983b = strArr;
        this.f23984c = strArr2;
    }

    @Nonnull
    private StatementsHolder m25931c(SQLiteDatabase sQLiteDatabase) {
        StatementsHolder statementsHolder = (StatementsHolder) this.f23985d.get(sQLiteDatabase);
        if (statementsHolder != null) {
            return statementsHolder;
        }
        statementsHolder = new StatementsHolder();
        this.f23985d.put(sQLiteDatabase, statementsHolder);
        return statementsHolder;
    }

    @Nonnull
    public final synchronized String m25933a(SQLiteDatabase sQLiteDatabase, String[] strArr) {
        String str;
        StatementsHolder c = m25931c(sQLiteDatabase);
        int b = m25930b(strArr);
        str = (String) c.f23979a.get(b);
        if (str == null) {
            str = m25929a(this.f23982a, this.f23983b, strArr);
            c.f23979a.put(b, str);
        }
        return str;
    }

    private static int m25930b(String[] strArr) {
        int i = 0;
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (strArr[i2] == null) {
                i |= 1 << i2;
            }
        }
        return i;
    }

    private static String m25929a(String str, String[] strArr, String[] strArr2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT _id");
        stringBuilder.append(" FROM ").append(str);
        stringBuilder.append(" WHERE ");
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                stringBuilder.append(" AND ");
            }
            stringBuilder.append(strArr[i]);
            if (strArr2[i] == null) {
                stringBuilder.append(" IS NULL");
            } else {
                stringBuilder.append("=?");
            }
        }
        stringBuilder.append(" LIMIT 1");
        return stringBuilder.toString();
    }

    @Nonnull
    public final synchronized SQLiteStatement m25932a(SQLiteDatabase sQLiteDatabase) {
        StatementsHolder c;
        c = m25931c(sQLiteDatabase);
        if (c.f23980b == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("INSERT");
            stringBuilder.append(" INTO ");
            stringBuilder.append(this.f23982a);
            stringBuilder.append('(');
            int i = 0;
            while (i < this.f23984c.length) {
                stringBuilder.append(i > 0 ? "," : "");
                stringBuilder.append(this.f23984c[i]);
                i++;
            }
            stringBuilder.append(')');
            stringBuilder.append(" VALUES (");
            int i2 = 0;
            while (i2 < this.f23984c.length) {
                stringBuilder.append(i2 > 0 ? ",?" : "?");
                i2++;
            }
            stringBuilder.append(')');
            c.f23980b = sQLiteDatabase.compileStatement(stringBuilder.toString());
        }
        return c.f23980b;
    }

    @Nonnull
    public final synchronized SQLiteStatement m25934b(SQLiteDatabase sQLiteDatabase) {
        StatementsHolder c;
        c = m25931c(sQLiteDatabase);
        if (c.f23981c == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("UPDATE ");
            stringBuilder.append(this.f23982a);
            stringBuilder.append(" SET ");
            int i = 0;
            while (i < this.f23984c.length) {
                stringBuilder.append(i > 0 ? "," : "");
                stringBuilder.append(this.f23984c[i]);
                stringBuilder.append("=?");
                i++;
            }
            stringBuilder.append(" WHERE ");
            stringBuilder.append("_id");
            stringBuilder.append("=?");
            c.f23981c = sQLiteDatabase.compileStatement(stringBuilder.toString());
        }
        return c.f23981c;
    }
}
