package com.facebook.database.supplier;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.facebook.common.dextricks.DexLibLoader;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;

/* compiled from: unsubscribe */
public final class SharedSQLiteDbHelper {
    private static volatile int f1860a = 0;
    private static volatile long f1861b = -1;
    private static final String[] f1862f = new String[]{"version"};
    public final ImmutableList<SharedSQLiteSchemaPart> f1863c;
    private final int f1864d;
    private final Context f1865e;

    public SharedSQLiteDbHelper(List<? extends SharedSQLiteSchemaPart> list, int i, Context context) {
        this.f1863c = ImmutableList.copyOf((Collection) list);
        this.f1864d = i;
        this.f1865e = context.getApplicationContext();
    }

    public final void m3770b(SQLiteDatabase sQLiteDatabase) {
        int i = 0;
        m3765c(sQLiteDatabase, this.f1864d);
        SQLiteDetour.a(sQLiteDatabase, -1954818821);
        try {
            int i2;
            boolean c = m3766c(sQLiteDatabase);
            int size = this.f1863c.size();
            for (i2 = 0; i2 < size; i2++) {
                SharedSQLiteSchemaPart sharedSQLiteSchemaPart = (SharedSQLiteSchemaPart) this.f1863c.get(i2);
                int b = m3762b(sQLiteDatabase, sharedSQLiteSchemaPart.m2048a());
                if (b == -1) {
                    if (sQLiteDatabase.isReadOnly()) {
                        throw new SQLiteException("Can't upgrade readonly database");
                    }
                    sharedSQLiteSchemaPart.mo320a(sQLiteDatabase);
                } else if (b < sharedSQLiteSchemaPart.m2052b()) {
                    if (sQLiteDatabase.isReadOnly()) {
                        throw new SQLiteException("Can't upgrade readonly database");
                    }
                    sharedSQLiteSchemaPart.mo319a(sQLiteDatabase, b, sharedSQLiteSchemaPart.m2052b());
                } else if (b > sharedSQLiteSchemaPart.m2052b()) {
                    throw new SQLiteException("Can't downgrade version for " + sharedSQLiteSchemaPart.m2048a());
                }
                if (c && b != -1) {
                    sharedSQLiteSchemaPart.mo321a(sQLiteDatabase, this.f1865e);
                }
                if (b != sharedSQLiteSchemaPart.m2052b()) {
                    m3760a(sQLiteDatabase, sharedSQLiteSchemaPart.m2048a(), sharedSQLiteSchemaPart.m2052b());
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
            i2 = this.f1863c.size();
            for (i = 
/*
Method generation error in method: com.facebook.database.supplier.SharedSQLiteDbHelper.b(android.database.sqlite.SQLiteDatabase):void
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r1_5 'i' int) = (r1_0 'i' int), (r1_4 'i' int) binds: {(r1_0 'i' int)=B:45:0x00a1, (r1_4 'i' int)=B:11:0x003b} in method: com.facebook.database.supplier.SharedSQLiteDbHelper.b(android.database.sqlite.SQLiteDatabase):void
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:277)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 20 more

*/

            private boolean m3766c(SQLiteDatabase sQLiteDatabase) {
                boolean z = false;
                int a = m3757a(this.f1865e);
                if (a != m3767d(sQLiteDatabase)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("name", "app_build_number");
                    contentValues.put("version", Integer.valueOf(a));
                    SQLiteDetour.a(-413138429);
                    sQLiteDatabase.replaceOrThrow("_shared_version", null, contentValues);
                    SQLiteDetour.a(-1344860925);
                    z = true;
                }
                long b = m3763b(this.f1865e);
                if (b != m3768e(sQLiteDatabase)) {
                    m3759a(sQLiteDatabase, b);
                    z = true;
                }
                b = DexLibLoader.getLastCompilationTime(this.f1865e);
                if (b == m3769f(sQLiteDatabase)) {
                    return z;
                }
                m3764b(sQLiteDatabase, b);
                return true;
            }

            public static void m3760a(SQLiteDatabase sQLiteDatabase, String str, int i) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", str);
                contentValues.put("version", Integer.valueOf(i));
                SQLiteDetour.a(-196916162);
                sQLiteDatabase.replaceOrThrow("_shared_version", null, contentValues);
                SQLiteDetour.a(-374338645);
            }

            private static void m3759a(SQLiteDatabase sQLiteDatabase, long j) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", "app_upgrade_time");
                contentValues.put("version", Long.valueOf(j));
                SQLiteDetour.a(995225640);
                sQLiteDatabase.replaceOrThrow("_shared_version", null, contentValues);
                SQLiteDetour.a(-209885610);
            }

            private static void m3764b(SQLiteDatabase sQLiteDatabase, long j) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", "dex_update_time");
                contentValues.put("version", Long.valueOf(j));
                SQLiteDetour.a(-1266403714);
                sQLiteDatabase.replaceOrThrow("_shared_version", null, contentValues);
                SQLiteDetour.a(-2025760095);
            }

            private static int m3762b(SQLiteDatabase sQLiteDatabase, String str) {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("_shared_version", f1862f, "name=?", new String[]{str}, null, null, null);
                try {
                    if (query.moveToNext()) {
                        int i = query.getInt(0);
                        return i;
                    }
                    query.close();
                    return -1;
                } finally {
                    query.close();
                }
            }

            private static int m3767d(SQLiteDatabase sQLiteDatabase) {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("_shared_version", f1862f, "name=?", new String[]{"app_build_number"}, null, null, null);
                try {
                    if (query.moveToNext()) {
                        int i = query.getInt(0);
                        return i;
                    }
                    query.close();
                    return -1;
                } finally {
                    query.close();
                }
            }

            private static int m3757a(Context context) {
                if (f1860a == 0) {
                    try {
                        f1860a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                    } catch (NameNotFoundException e) {
                    }
                }
                return f1860a;
            }

            private static long m3768e(SQLiteDatabase sQLiteDatabase) {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("_shared_version", f1862f, "name=?", new String[]{"app_upgrade_time"}, null, null, null);
                try {
                    if (query.moveToNext()) {
                        long j = query.getLong(0);
                        return j;
                    }
                    query.close();
                    return -1;
                } finally {
                    query.close();
                }
            }

            private static long m3763b(Context context) {
                if (f1861b == -1) {
                    try {
                        f1861b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
                    } catch (NameNotFoundException e) {
                    }
                }
                return f1861b;
            }

            private static long m3769f(SQLiteDatabase sQLiteDatabase) {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("_shared_version", f1862f, "name=?", new String[]{"dex_update_time"}, null, null, null);
                try {
                    if (query.moveToNext()) {
                        long j = query.getLong(0);
                        return j;
                    }
                    query.close();
                    return -1;
                } finally {
                    query.close();
                }
            }

            private static void m3765c(SQLiteDatabase sQLiteDatabase, int i) {
                m3761a(sQLiteDatabase, "wal_autocheckpoint", String.valueOf(Math.max(1, i / m3758a(sQLiteDatabase, "page_size"))));
                m3761a(sQLiteDatabase, "journal_size_limit", String.valueOf(i));
            }

            public static int m3758a(SQLiteDatabase sQLiteDatabase, String str) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA " + str, null);
                try {
                    rawQuery.moveToNext();
                    int i = rawQuery.getInt(0);
                    return i;
                } finally {
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
            }

            private static void m3761a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA " + str + "=" + str2, null);
                try {
                    rawQuery.moveToNext();
                } finally {
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
            }
        }
