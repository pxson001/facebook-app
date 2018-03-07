package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import android.util.Pair;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zztc;
import com.google.android.gms.internal.zztd;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzd extends zzw {
    public static final Map<String, String> f225a;
    private final zza f226b = new zza(this, mo32i(), m416z(this));
    public final zzaa f227c = new zzaa(mo31h());

    class zza extends SQLiteOpenHelper {
        final /* synthetic */ zzd f233a;

        zza(zzd com_google_android_gms_measurement_internal_zzd, Context context, String str) {
            this.f233a = com_google_android_gms_measurement_internal_zzd;
            super(context, str, null, 1);
        }

        private void m453a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, Map<String, String> map) {
            if (!m455a(sQLiteDatabase, str)) {
                SQLiteDetour.a(-837780748);
                sQLiteDatabase.execSQL(str2);
                SQLiteDetour.a(1547762783);
            }
            try {
                m454a(sQLiteDatabase, str, str3, map);
            } catch (SQLiteException e) {
                this.f233a.mo35l().m335b().m356a("Failed to verify columns on table that was just created", str);
                throw e;
            }
        }

        private void m454a(SQLiteDatabase sQLiteDatabase, String str, String str2, Map<String, String> map) {
            Set b = m456b(sQLiteDatabase, str);
            String[] split = str2.split(",");
            int length = split.length;
            int i = 0;
            while (i < length) {
                String str3 = split[i];
                if (b.remove(str3)) {
                    i++;
                } else {
                    throw new SQLiteException("Database " + str + " is missing required column: " + str3);
                }
            }
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    if (!b.remove(entry.getKey())) {
                        String str4 = (String) entry.getValue();
                        SQLiteDetour.a(1130453999);
                        sQLiteDatabase.execSQL(str4);
                        SQLiteDetour.a(1296119877);
                    }
                }
            }
            if (!b.isEmpty()) {
                throw new SQLiteException("Database " + str + " table has extra columns");
            }
        }

        private boolean m455a(SQLiteDatabase sQLiteDatabase, String str) {
            Cursor query;
            Object e;
            Throwable th;
            Cursor cursor = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        this.f233a.mo35l().m348o().m357a("Error querying for table", str, e);
                        if (query != null) {
                            query.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                query = null;
                this.f233a.mo35l().m348o().m357a("Error querying for table", str, e);
                if (query != null) {
                    query.close();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        private static Set<String> m456b(SQLiteDatabase sQLiteDatabase, String str) {
            Set<String> hashSet = new HashSet();
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
            try {
                Collections.addAll(hashSet, rawQuery.getColumnNames());
                return hashSet;
            } finally {
                rawQuery.close();
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            if (this.f233a.f227c.m451a(zzc.m133t())) {
                SQLiteDatabase writableDatabase;
                try {
                    writableDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    this.f233a.f227c.m450a();
                    this.f233a.mo35l().m335b().m355a("Opening the database failed, dropping and recreating it");
                    this.f233a.mo32i().getDatabasePath(zzd.m416z(this.f233a)).delete();
                    try {
                        writableDatabase = super.getWritableDatabase();
                        this.f233a.f227c.m452b();
                    } catch (SQLiteException e2) {
                        this.f233a.mo35l().m335b().m356a("Failed to open freshly created database", e2);
                        throw e2;
                    }
                }
                return writableDatabase;
            }
            throw new SQLiteException("Database open failed");
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (VERSION.SDK_INT >= 9) {
                File file = new File(sQLiteDatabase.getPath());
                file.setReadable(false, false);
                file.setWritable(false, false);
                file.setReadable(true, true);
                file.setWritable(true, true);
            }
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            m453a(sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", null);
            m453a(sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", null);
            m453a(sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zzd.f225a);
            m453a(sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", null);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    static {
        ArrayMap arrayMap = new ArrayMap(5);
        f225a = arrayMap;
        arrayMap.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
        f225a.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
        f225a.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        f225a.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        f225a.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
    }

    public zzd(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
    }

    private void m410A() {
        mo28e();
        m303x();
        if (m411B()) {
            int delete = m415u().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(mo31h().mo11a()), String.valueOf(zzc.m124D())});
            if (delete > 0) {
                mo35l().f211m.m356a("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    private boolean m411B() {
        return mo32i().getDatabasePath(m416z(this)).exists();
    }

    private long m412a(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            cursor = m415u().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            mo35l().m335b().m357a("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private static void m413a(ContentValues contentValues, String str, Object obj) {
        zzx.m106a(str);
        zzx.m104a(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Float) {
            contentValues.put(str, (Float) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    private Object m414b(Cursor cursor, int i) {
        int type;
        if (VERSION.SDK_INT >= 11) {
            type = cursor.getType(i);
        } else {
            CursorWindow window = ((SQLiteCursor) cursor).getWindow();
            int position = cursor.getPosition();
            type = window.isNull(position, i) ? 0 : window.isLong(position, i) ? 1 : window.isFloat(position, i) ? 2 : window.isString(position, i) ? 3 : window.isBlob(position, i) ? 4 : -1;
        }
        int i2 = type;
        switch (i2) {
            case 0:
                mo35l().f203d.m355a("Loaded invalid null value from database");
                return null;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return Long.valueOf(cursor.getLong(i));
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return Float.valueOf(cursor.getFloat(i));
            case 3:
                return cursor.getString(i);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                mo35l().f203d.m355a("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                mo35l().f203d.m356a("Loaded invalid unknown value type, ignoring it", Integer.valueOf(i2));
                return null;
        }
    }

    private SQLiteDatabase m415u() {
        mo28e();
        try {
            return this.f226b.getWritableDatabase();
        } catch (SQLiteException e) {
            mo35l().m348o().m356a("Error opening database", e);
            throw e;
        }
    }

    public static String m416z(zzd com_google_android_gms_measurement_internal_zzd) {
        if (!com.google.android.gms.common.internal.zzd.f66a) {
            return "google_app_measurement.db";
        }
        if (com_google_android_gms_measurement_internal_zzd.mo37n().m135C()) {
            return "google_app_measurement.db";
        }
        com_google_android_gms_measurement_internal_zzd.mo35l().f207i.m355a("Using secondary database");
        return "google_app_measurement2.db";
    }

    public final zzh m417a(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        zzx.m106a(str);
        zzx.m106a(str2);
        mo28e();
        m303x();
        try {
            Cursor query = m415u().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    zzh com_google_android_gms_measurement_internal_zzh = new zzh(str, str2, query.getLong(0), query.getLong(1), query.getLong(2));
                    if (query.moveToNext()) {
                        mo35l().m335b().m355a("Got multiple records for event aggregates, expected one");
                    }
                    if (query == null) {
                        return com_google_android_gms_measurement_internal_zzh;
                    }
                    query.close();
                    return com_google_android_gms_measurement_internal_zzh;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    mo35l().m335b().m358a("Error querying events", str, str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            mo35l().m335b().m358a("Error querying events", str, str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final List<zzac> m418a(String str) {
        Cursor query;
        Object e;
        Cursor cursor;
        Throwable th;
        zzx.m106a(str);
        mo28e();
        m303x();
        List<zzac> arrayList = new ArrayList();
        try {
            query = m415u().query("user_attributes", new String[]{"name", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(zzc.m132s() + 1));
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(0);
                        long j = query.getLong(1);
                        Object b = m414b(query, 2);
                        if (b == null) {
                            mo35l().m335b().m355a("Read invalid user attribute value, ignoring it");
                        } else {
                            arrayList.add(new zzac(str, string, j, b));
                        }
                    } while (query.moveToNext());
                    if (arrayList.size() > zzc.m132s()) {
                        mo35l().m335b().m355a("Loaded too many user attributes");
                        arrayList.remove(zzc.m132s());
                    }
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    mo35l().m335b().m357a("Error querying user attributes", str, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    query = cursor;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            mo35l().m335b().m357a("Error querying user attributes", str, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final List<Pair<com.google.android.gms.internal.zzqq.zzd, Long>> m419a(String str, int i, int i2) {
        Cursor query;
        List<Pair<com.google.android.gms.internal.zzqq.zzd, Long>> arrayList;
        Object e;
        Cursor cursor;
        Throwable th;
        boolean z = true;
        mo28e();
        m303x();
        zzx.m112b(i > 0);
        if (i2 <= 0) {
            z = false;
        }
        zzx.m112b(z);
        zzx.m106a(str);
        try {
            query = m415u().query("queue", new String[]{"rowid", "data"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            try {
                if (query.moveToFirst()) {
                    arrayList = new ArrayList();
                    int i3 = 0;
                    while (true) {
                        long j = query.getLong(0);
                        int length;
                        try {
                            byte[] b = mo33j().m374b(query.getBlob(1));
                            if (!arrayList.isEmpty() && b.length + i3 > i2) {
                                break;
                            }
                            zztc a = zztc.a(b);
                            com.google.android.gms.internal.zzqq.zzd com_google_android_gms_internal_zzqq_zzd = new com.google.android.gms.internal.zzqq.zzd();
                            try {
                                com_google_android_gms_internal_zzqq_zzd.b(a);
                                length = b.length + i3;
                                arrayList.add(Pair.create(com_google_android_gms_internal_zzqq_zzd, Long.valueOf(j)));
                            } catch (IOException e2) {
                                mo35l().m335b().m357a("Failed to merge queued bundle", str, e2);
                                length = i3;
                            }
                            if (!query.moveToNext() || length > i2) {
                                break;
                            }
                            i3 = length;
                        } catch (IOException e22) {
                            mo35l().m335b().m357a("Failed to unzip queued bundle", str, e22);
                            length = i3;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } else {
                    arrayList = Collections.emptyList();
                    if (query != null) {
                        query.close();
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
                try {
                    mo35l().m335b().m357a("Error querying bundles", str, e);
                    arrayList = Collections.emptyList();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    query = cursor;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            mo35l().m335b().m357a("Error querying bundles", str, e);
            arrayList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    protected final void mo24a() {
    }

    public final void m421a(long j) {
        mo28e();
        m303x();
        if (m415u().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) != 1) {
            mo35l().f203d.m355a("Deleted fewer rows from queue than expected");
        }
    }

    public final void m422a(com.google.android.gms.internal.zzqq.zzd com_google_android_gms_internal_zzqq_zzd) {
        mo28e();
        m303x();
        zzx.m104a((Object) com_google_android_gms_internal_zzqq_zzd);
        zzx.m106a(com_google_android_gms_internal_zzqq_zzd.p);
        zzx.m104a(com_google_android_gms_internal_zzqq_zzd.g);
        m432r();
        long a = mo31h().mo11a();
        if (com_google_android_gms_internal_zzqq_zzd.g.longValue() < a - zzc.m124D() || com_google_android_gms_internal_zzqq_zzd.g.longValue() > zzc.m124D() + a) {
            mo35l().m348o().m357a("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(a), com_google_android_gms_internal_zzqq_zzd.g);
        }
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzqq_zzd.d()];
            zztd a2 = zztd.a(bArr);
            com_google_android_gms_internal_zzqq_zzd.a(a2);
            a2.a();
            bArr = mo33j().m371a(bArr);
            mo35l().m350t().m356a("Saving bundle, size", Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", com_google_android_gms_internal_zzqq_zzd.p);
            contentValues.put("bundle_end_timestamp", com_google_android_gms_internal_zzqq_zzd.g);
            contentValues.put("data", bArr);
            try {
                SQLiteDetour.a(1447424188);
                a = m415u().insert("queue", null, contentValues);
                SQLiteDetour.a(250804690);
                if (a == -1) {
                    mo35l().m335b().m355a("Failed to insert bundle (got -1)");
                }
            } catch (SQLiteException e) {
                mo35l().m335b().m356a("Error storing bundle", e);
            }
        } catch (IOException e2) {
            mo35l().m335b().m356a("Data loss. Failed to serialize bundle", e2);
        }
    }

    public final void m423a(zza com_google_android_gms_measurement_internal_zza) {
        zzx.m104a((Object) com_google_android_gms_measurement_internal_zza);
        mo28e();
        m303x();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_measurement_internal_zza.a);
        contentValues.put("app_instance_id", com_google_android_gms_measurement_internal_zza.b);
        contentValues.put("gmp_app_id", com_google_android_gms_measurement_internal_zza.c);
        contentValues.put("resettable_device_id_hash", com_google_android_gms_measurement_internal_zza.d);
        contentValues.put("last_bundle_index", Long.valueOf(com_google_android_gms_measurement_internal_zza.e));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(com_google_android_gms_measurement_internal_zza.f));
        contentValues.put("app_version", com_google_android_gms_measurement_internal_zza.g);
        contentValues.put("app_store", com_google_android_gms_measurement_internal_zza.h);
        contentValues.put("gmp_version", Long.valueOf(com_google_android_gms_measurement_internal_zza.i));
        contentValues.put("dev_cert_hash", Long.valueOf(com_google_android_gms_measurement_internal_zza.j));
        contentValues.put("measurement_enabled", Boolean.valueOf(com_google_android_gms_measurement_internal_zza.k));
        try {
            SQLiteDetour.a(29505527);
            long insertWithOnConflict = m415u().insertWithOnConflict("apps", null, contentValues, 5);
            SQLiteDetour.a(1646963694);
            if (insertWithOnConflict == -1) {
                mo35l().m335b().m355a("Failed to insert/update app (got -1)");
            }
        } catch (SQLiteException e) {
            mo35l().m335b().m356a("Error storing app", e);
        }
    }

    public final void m424a(zzac com_google_android_gms_measurement_internal_zzac) {
        zzx.m104a((Object) com_google_android_gms_measurement_internal_zzac);
        mo28e();
        m303x();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_measurement_internal_zzac.a);
        contentValues.put("name", com_google_android_gms_measurement_internal_zzac.b);
        contentValues.put("set_timestamp", Long.valueOf(com_google_android_gms_measurement_internal_zzac.c));
        m413a(contentValues, "value", com_google_android_gms_measurement_internal_zzac.d);
        try {
            SQLiteDetour.a(-190849667);
            long insertWithOnConflict = m415u().insertWithOnConflict("user_attributes", null, contentValues, 5);
            SQLiteDetour.a(794136801);
            if (insertWithOnConflict == -1) {
                mo35l().m335b().m355a("Failed to insert/update user attribute (got -1)");
            }
        } catch (SQLiteException e) {
            mo35l().m335b().m356a("Error storing user attribute", e);
        }
    }

    public final void m425a(zzh com_google_android_gms_measurement_internal_zzh) {
        zzx.m104a((Object) com_google_android_gms_measurement_internal_zzh);
        mo28e();
        m303x();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_measurement_internal_zzh.a);
        contentValues.put("name", com_google_android_gms_measurement_internal_zzh.b);
        contentValues.put("lifetime_count", Long.valueOf(com_google_android_gms_measurement_internal_zzh.c));
        contentValues.put("current_bundle_count", Long.valueOf(com_google_android_gms_measurement_internal_zzh.d));
        contentValues.put("last_fire_timestamp", Long.valueOf(com_google_android_gms_measurement_internal_zzh.e));
        try {
            SQLiteDetour.a(739108100);
            long insertWithOnConflict = m415u().insertWithOnConflict("events", null, contentValues, 5);
            SQLiteDetour.a(1043764071);
            if (insertWithOnConflict == -1) {
                mo35l().m335b().m355a("Failed to insert/update event aggregates (got -1)");
            }
        } catch (SQLiteException e) {
            mo35l().m335b().m356a("Error storing event aggregates", e);
        }
    }

    public final zza m426b(String str) {
        Object e;
        Cursor cursor;
        Throwable th;
        zzx.m106a(str);
        mo28e();
        m303x();
        Cursor cursor2 = null;
        try {
            Cursor query = m415u().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    zza com_google_android_gms_measurement_internal_zza = new zza(str, query.getString(0), query.getString(1), query.getString(2), query.getLong(3), query.getLong(4), query.getString(5), query.getString(6), query.getLong(7), query.getLong(8), (query.isNull(9) ? 1 : query.getInt(9)) != 0);
                    if (query.moveToNext()) {
                        mo35l().m335b().m355a("Got multiple records for app, expected one");
                    }
                    if (query == null) {
                        return com_google_android_gms_measurement_internal_zza;
                    }
                    query.close();
                    return com_google_android_gms_measurement_internal_zza;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    mo35l().m335b().m357a("Error querying app", str, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            mo35l().m335b().m357a("Error querying app", str, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final void m427b() {
        m303x();
        SQLiteDetour.a(m415u(), -829919966);
    }

    public final void m428b(String str, String str2) {
        zzx.m106a(str);
        zzx.m106a(str2);
        mo28e();
        m303x();
        try {
            mo35l().m350t().m356a("Deleted user attribute rows:", Integer.valueOf(m415u().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            mo35l().m335b().m358a("Error deleting user attribute", str, str2, e);
        }
    }

    public final void m429o() {
        m303x();
        m415u().setTransactionSuccessful();
    }

    public final void m430p() {
        m303x();
        SQLiteDetour.b(m415u(), 361949988);
    }

    public final String m431q() {
        Cursor rawQuery;
        Object e;
        Throwable th;
        String str = null;
        try {
            rawQuery = m415u().rawQuery("SELECT q.app_id FROM queue q JOIN apps a ON a.app_id=q.app_id WHERE a.measurement_enabled!=0 ORDER BY q.rowid LIMIT 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    mo35l().m335b().m356a("Database error getting next bundle app id", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
            mo35l().m335b().m356a("Database error getting next bundle app id", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = null;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    final void m432r() {
        mo28e();
        m303x();
        if (m411B()) {
            long a = mo36m().f154f.m326a();
            long b = mo31h().mo12b();
            if (Math.abs(b - a) > ((Long) zzk.f179l.m314a()).longValue()) {
                mo36m().f154f.m327a(b);
                m410A();
            }
        }
    }

    public final long m433s() {
        return m412a("select max(bundle_end_timestamp) from queue", null, 0);
    }
}
