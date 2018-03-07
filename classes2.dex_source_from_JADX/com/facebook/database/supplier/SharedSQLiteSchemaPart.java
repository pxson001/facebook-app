package com.facebook.database.supplier;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.google.common.base.Preconditions;

/* compiled from: views */
public abstract class SharedSQLiteSchemaPart {
    public final String f1011a;
    private final int f1012b;

    protected abstract void mo320a(SQLiteDatabase sQLiteDatabase);

    protected abstract void mo319a(SQLiteDatabase sQLiteDatabase, int i, int i2);

    public abstract void mo322b(SQLiteDatabase sQLiteDatabase);

    protected SharedSQLiteSchemaPart(String str, int i) {
        Preconditions.checkArgument(i > 0, "Version must be positive");
        this.f1011a = str;
        this.f1012b = i;
    }

    public final String m2048a() {
        return this.f1011a;
    }

    public final int m2052b() {
        return this.f1012b;
    }

    protected void mo321a(SQLiteDatabase sQLiteDatabase, Context context) {
    }

    protected void mo323c(SQLiteDatabase sQLiteDatabase) {
    }
}
