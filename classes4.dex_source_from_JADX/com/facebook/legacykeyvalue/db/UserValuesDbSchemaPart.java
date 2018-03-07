package com.facebook.legacykeyvalue.db;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.supplier.SharedSQLiteSchemaPart;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import javax.inject.Inject;

/* compiled from: time_user_entered */
public class UserValuesDbSchemaPart extends SharedSQLiteSchemaPart {
    private static final Class<?> f1014a = UserValuesDbSchemaPart.class;
    private static volatile UserValuesDbSchemaPart f1015b;

    public static com.facebook.legacykeyvalue.db.UserValuesDbSchemaPart m1330a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f1015b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.legacykeyvalue.db.UserValuesDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f1015b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m1331c();	 Catch:{ all -> 0x0034 }
        f1015b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f1015b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.legacykeyvalue.db.UserValuesDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.legacykeyvalue.db.UserValuesDbSchemaPart");
    }

    private static UserValuesDbSchemaPart m1331c() {
        return new UserValuesDbSchemaPart();
    }

    @Inject
    public UserValuesDbSchemaPart() {
        super("legacy_user_values", 1);
    }

    protected final void m1332a(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-17699457);
        sQLiteDatabase.execSQL("CREATE TABLE user_values (_id INTEGER PRIMARY KEY,name TEXT,value TEXT);");
        SQLiteDetour.a(-146046269);
    }

    protected final void m1333a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        SQLiteDetour.a(1243458320);
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS user_values");
        SQLiteDetour.a(-1001293297);
        m1332a(sQLiteDatabase);
    }

    public final void m1334b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.delete("user_values", null, null);
    }
}
