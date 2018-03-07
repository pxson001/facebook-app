package com.facebook.react.modules.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import javax.annotation.Nullable;

/* compiled from: friendsSelectorSelected */
public class ReactDatabaseSupplier extends SQLiteOpenHelper {
    @Nullable
    private static ReactDatabaseSupplier f11698a;
    private Context f11699b;
    @Nullable
    private SQLiteDatabase f11700c;
    private long f11701d = 6291456;

    private ReactDatabaseSupplier(Context context) {
        super(context, "RKStorage", null, 1);
        this.f11699b = context;
    }

    public static ReactDatabaseSupplier m13767a(Context context) {
        if (f11698a == null) {
            f11698a = new ReactDatabaseSupplier(context.getApplicationContext());
        }
        return f11698a;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-1610147586);
        sQLiteDatabase.execSQL("CREATE TABLE catalystLocalStorage (key TEXT PRIMARY KEY, value TEXT NOT NULL)");
        SQLiteDetour.a(2092128257);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i != i2) {
            m13768e();
            onCreate(sQLiteDatabase);
        }
    }

    final synchronized boolean m13770a() {
        if (this.f11700c == null || !this.f11700c.isOpen()) {
            SQLiteException sQLiteException = null;
            int i = 0;
            while (i < 2) {
                if (i > 0) {
                    try {
                        m13768e();
                    } catch (SQLiteException e) {
                        sQLiteException = e;
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e2) {
                            Thread.currentThread().interrupt();
                        }
                        i++;
                    }
                }
                this.f11700c = getWritableDatabase();
            }
            if (this.f11700c == null) {
                throw sQLiteException;
            }
            this.f11700c.setMaximumSize(this.f11701d);
        }
        return true;
    }

    final synchronized SQLiteDatabase m13771b() {
        m13770a();
        return this.f11700c;
    }

    public final synchronized void m13772c() {
        try {
            m13773d();
            m13769f();
        } catch (Exception e) {
            if (!m13768e()) {
                throw new RuntimeException("Clearing and deleting database RKStorage failed");
            }
        }
    }

    final synchronized void m13773d() {
        m13771b().delete("catalystLocalStorage", null, null);
    }

    private synchronized boolean m13768e() {
        m13769f();
        return this.f11699b.deleteDatabase("RKStorage");
    }

    private synchronized void m13769f() {
        if (this.f11700c != null && this.f11700c.isOpen()) {
            this.f11700c.close();
            this.f11700c = null;
        }
    }
}
