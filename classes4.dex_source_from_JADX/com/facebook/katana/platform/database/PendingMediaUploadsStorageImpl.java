package com.facebook.katana.platform.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.platform.PendingMediaUpload;
import com.facebook.katana.platform.database.PendingMediaUploadsSchemaPart.PendingMediaUploadsTable.Columns;
import com.facebook.platform.database.PlatformDatabaseSupplier;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: getAbsolutePlaybackPosition */
public class PendingMediaUploadsStorageImpl {
    private static final String[] f11252a = new String[]{"pending_media_uploads." + Columns.f11255a.d, Columns.f11256b.d};
    private static volatile PendingMediaUploadsStorageImpl f11253c;
    private final PlatformDatabaseSupplier f11254b;

    public static com.facebook.katana.platform.database.PendingMediaUploadsStorageImpl m11670a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11253c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.platform.database.PendingMediaUploadsStorageImpl.class;
        monitor-enter(r1);
        r0 = f11253c;	 Catch:{ all -> 0x003a }
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
        r0 = m11671b(r0);	 Catch:{ all -> 0x0035 }
        f11253c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11253c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.platform.database.PendingMediaUploadsStorageImpl.a(com.facebook.inject.InjectorLike):com.facebook.katana.platform.database.PendingMediaUploadsStorageImpl");
    }

    private static PendingMediaUploadsStorageImpl m11671b(InjectorLike injectorLike) {
        return new PendingMediaUploadsStorageImpl(PlatformDatabaseSupplier.m11676a(injectorLike));
    }

    @Inject
    public PendingMediaUploadsStorageImpl(PlatformDatabaseSupplier platformDatabaseSupplier) {
        this.f11254b = platformDatabaseSupplier;
    }

    public final PendingMediaUpload m11673a(String str) {
        ImmutableList c = m11672c(str);
        if (c.isEmpty()) {
            return null;
        }
        return (PendingMediaUpload) c.get(0);
    }

    private ImmutableList<PendingMediaUpload> m11672c(String str) {
        String a;
        String[] b;
        Builder builder = new Builder();
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("pending_media_uploads");
        if (str != null) {
            Expression a2 = SqlExpression.a(Columns.f11255a.a(), str);
            a = a2.a();
            b = a2.b();
        } else {
            b = null;
            a = null;
        }
        Cursor query = sQLiteQueryBuilder.query(this.f11254b.a(), f11252a, a, b, null, null, null);
        try {
            int a3 = Columns.f11255a.a(query);
            int a4 = Columns.f11256b.a(query);
            while (query.moveToNext()) {
                builder.c(new PendingMediaUpload(query.getString(a3), query.getString(a4)));
            }
            return builder.b();
        } finally {
            query.close();
        }
    }

    public final void m11674a(PendingMediaUpload pendingMediaUpload) {
        SQLiteDatabase a = this.f11254b.a();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.f11255a.d, pendingMediaUpload.a);
        contentValues.put(Columns.f11256b.d, pendingMediaUpload.b);
        SQLiteDetour.a(794916018);
        a.insertOrThrow("pending_media_uploads", null, contentValues);
        SQLiteDetour.a(1666791541);
    }

    public final void m11675b(String str) {
        Expression a = SqlExpression.a(Columns.f11255a.d, str);
        this.f11254b.a().delete("pending_media_uploads", a.a(), a.b());
    }
}
