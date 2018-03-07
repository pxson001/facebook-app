package com.facebook.appupdate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: ranking_config */
public class AppUpdatePersistence {
    private final Context f8285a;
    private SQLiteDatabase f8286b;

    @Inject
    public AppUpdatePersistence(Context context) {
        this.f8285a = context;
    }

    public final long m12802a(byte[] bArr) {
        if (this.f8286b == null) {
            this.f8286b = new DbHelper(this.f8285a).getWritableDatabase();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", bArr);
        SQLiteDetour.a(1957104899);
        long insert = this.f8286b.insert("app_updates", null, contentValues);
        SQLiteDetour.a(-1365783038);
        return insert;
    }

    public final void m12805a(long j, byte[] bArr) {
        if (this.f8286b == null) {
            this.f8286b = new DbHelper(this.f8285a).getWritableDatabase();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(j));
        contentValues.put("data", bArr);
        SQLiteDetour.a(this.f8286b, -1302973955);
        try {
            this.f8286b.delete("app_updates", "id = ?", new String[]{String.valueOf(j)});
            SQLiteDetour.a(-1945763053);
            this.f8286b.insert("app_updates", null, contentValues);
            SQLiteDetour.a(170249287);
            this.f8286b.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(this.f8286b, -880813214);
        }
    }

    public final void m12804a(long j) {
        if (this.f8286b == null) {
            this.f8286b = new DbHelper(this.f8285a).getWritableDatabase();
        }
        this.f8286b.delete("app_updates", "id = ?", new String[]{String.valueOf(j)});
    }

    public final List<Pair<Long, byte[]>> m12803a() {
        Cursor query;
        Throwable th;
        if (this.f8286b == null) {
            this.f8286b = new DbHelper(this.f8285a).getWritableDatabase();
        }
        List<Pair<Long, byte[]>> arrayList = new ArrayList();
        try {
            query = this.f8286b.query("app_updates", null, null, null, null, null, null);
            try {
                int columnIndex = query.getColumnIndex("id");
                int columnIndex2 = query.getColumnIndex("data");
                while (query.moveToNext()) {
                    arrayList.add(new Pair(Long.valueOf(query.getLong(columnIndex)), query.getBlob(columnIndex2)));
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }
}
