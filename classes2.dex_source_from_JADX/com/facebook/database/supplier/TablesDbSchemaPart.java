package com.facebook.database.supplier;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.sqlite.SqlTable;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;

/* compiled from: visibility */
public class TablesDbSchemaPart extends SharedSQLiteSchemaPart {
    public final ImmutableList<SqlTable> f1010a;

    public TablesDbSchemaPart(String str, int i, ImmutableList<SqlTable> immutableList) {
        super(str, i);
        this.f1010a = immutableList;
    }

    @VisibleForTesting
    public final ImmutableList<SqlTable> m2046c() {
        return this.f1010a;
    }

    public void mo320a(SQLiteDatabase sQLiteDatabase) {
        int size = this.f1010a.size();
        for (int i = 0; i < size; i++) {
            ((SqlTable) this.f1010a.get(i)).mo1453a(sQLiteDatabase);
        }
    }

    protected void mo319a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int size = this.f1010a.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((SqlTable) this.f1010a.get(i3)).mo1454a(sQLiteDatabase, i, i2);
        }
    }

    protected final void mo321a(SQLiteDatabase sQLiteDatabase, Context context) {
        int size = this.f1010a.size();
        for (int i = 0; i < size; i++) {
            ((SqlTable) this.f1010a.get(i)).mo1479b(sQLiteDatabase);
        }
    }

    protected void mo323c(SQLiteDatabase sQLiteDatabase) {
        int size = this.f1010a.size();
        for (int i = 0; i < size; i++) {
            ((SqlTable) this.f1010a.get(i)).mo1455c(sQLiteDatabase);
        }
    }

    public void mo322b(SQLiteDatabase sQLiteDatabase) {
        int size = this.f1010a.size();
        for (int i = 0; i < size; i++) {
            ((SqlTable) this.f1010a.get(i)).m2087d(sQLiteDatabase);
        }
    }
}
