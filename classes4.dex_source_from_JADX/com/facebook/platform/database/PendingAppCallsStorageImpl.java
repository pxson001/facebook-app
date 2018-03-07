package com.facebook.platform.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.inject.InjectorLike;
import com.facebook.platform.common.action.PlatformAppCall;
import com.facebook.platform.database.PendingAppCallsSchemaPart.PendingAppCallsTable.Columns;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: geomagnetic_rotation_vector */
public class PendingAppCallsStorageImpl {
    private static final String[] f11284a = new String[]{"pending_app_calls." + Columns.f11269a.d, Columns.f11270b.d, Columns.f11271c.d, Columns.f11272d.d, Columns.f11273e.d, Columns.f11274f.d, Columns.f11275g.d, Columns.f11276h.d, Columns.f11277i.d, Columns.f11278j.d};
    private static volatile PendingAppCallsStorageImpl f11285c;
    private final PlatformDatabaseSupplier f11286b;

    public static com.facebook.platform.database.PendingAppCallsStorageImpl m11684a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f11285c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.platform.database.PendingAppCallsStorageImpl.class;
        monitor-enter(r1);
        r0 = f11285c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m11685b(r0);	 Catch:{ all -> 0x0035 }
        f11285c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11285c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.platform.database.PendingAppCallsStorageImpl.a(com.facebook.inject.InjectorLike):com.facebook.platform.database.PendingAppCallsStorageImpl");
    }

    private static PendingAppCallsStorageImpl m11685b(InjectorLike injectorLike) {
        return new PendingAppCallsStorageImpl(PlatformDatabaseSupplier.m11676a(injectorLike));
    }

    @Inject
    public PendingAppCallsStorageImpl(PlatformDatabaseSupplier platformDatabaseSupplier) {
        this.f11286b = platformDatabaseSupplier;
    }

    public final PlatformAppCall m11687a(String str) {
        ImmutableList c = m11686c(str);
        if (c.isEmpty()) {
            return null;
        }
        return (PlatformAppCall) c.get(0);
    }

    private ImmutableList<PlatformAppCall> m11686c(String str) {
        Builder builder = new Builder();
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("pending_app_calls");
        String str2 = null;
        String[] strArr = null;
        if (str != null) {
            Expression a = SqlExpression.a(Columns.f11269a.a(), str);
            str2 = a.a();
            strArr = a.b();
        }
        Cursor query = sQLiteQueryBuilder.query(this.f11286b.a(), f11284a, str2, strArr, null, null, null);
        try {
            int a2 = Columns.f11269a.a(query);
            int a3 = Columns.f11270b.a(query);
            int a4 = Columns.f11271c.a(query);
            int a5 = Columns.f11272d.a(query);
            int a6 = Columns.f11273e.a(query);
            int a7 = Columns.f11274f.a(query);
            int a8 = Columns.f11275g.a(query);
            int a9 = Columns.f11276h.a(query);
            int a10 = Columns.f11277i.a(query);
            int a11 = Columns.f11278j.a(query);
            while (query.moveToNext()) {
                boolean z;
                String string = query.getString(a2);
                int i = query.getInt(a3);
                if (query.getInt(a4) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                builder.c(new PlatformAppCall(string, i, z, query.getString(a5), query.getString(a6), query.getString(a7), query.getString(a8), query.getString(a9), query.getString(a10), query.getString(a11)));
            }
            return builder.b();
        } finally {
            query.close();
        }
    }

    public final void m11688a(PlatformAppCall platformAppCall) {
        int i;
        SQLiteDatabase a = this.f11286b.a();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.f11269a.d, platformAppCall.a);
        contentValues.put(Columns.f11270b.d, Integer.valueOf(platformAppCall.b));
        String str = Columns.f11271c.d;
        if (platformAppCall.c) {
            i = 1;
        } else {
            i = 0;
        }
        contentValues.put(str, Integer.valueOf(i));
        contentValues.put(Columns.f11272d.d, platformAppCall.d);
        contentValues.put(Columns.f11273e.d, platformAppCall.e);
        contentValues.put(Columns.f11274f.d, platformAppCall.f);
        contentValues.put(Columns.f11275g.d, platformAppCall.g);
        contentValues.put(Columns.f11276h.d, platformAppCall.h);
        contentValues.put(Columns.f11277i.d, platformAppCall.i);
        contentValues.put(Columns.f11278j.d, platformAppCall.j);
        SQLiteDetour.a(-1956175589);
        a.insertOrThrow("pending_app_calls", null, contentValues);
        SQLiteDetour.a(-969821974);
    }

    public final void m11689b(String str) {
        Expression a = SqlExpression.a(Columns.f11269a.d, str);
        this.f11286b.a().delete("pending_app_calls", a.a(), a.b());
    }
}
