package com.facebook.places.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: inappropriate */
public class PlacesDbHelper extends SQLiteOpenHelper {
    private static volatile PlacesDbHelper f11138a;

    public static com.facebook.places.db.PlacesDbHelper m13071a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f11138a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.places.db.PlacesDbHelper.class;
        monitor-enter(r1);
        r0 = f11138a;	 Catch:{ all -> 0x003a }
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
        r0 = m13072b(r0);	 Catch:{ all -> 0x0035 }
        f11138a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11138a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.db.PlacesDbHelper.a(com.facebook.inject.InjectorLike):com.facebook.places.db.PlacesDbHelper");
    }

    private static PlacesDbHelper m13072b(InjectorLike injectorLike) {
        return new PlacesDbHelper((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public PlacesDbHelper(Context context) {
        super(context, "places.db", null, 5);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        String str = PlacesModelTable.f11139a;
        SQLiteDetour.a(1377768269);
        sQLiteDatabase.execSQL(str);
        SQLiteDetour.a(624178695);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 == 1) {
            SQLiteDetour.a(-1267684492);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS places_model");
            SQLiteDetour.a(-1755017319);
            String str = PlacesModelTable.f11139a;
            SQLiteDetour.a(-1076447950);
            sQLiteDatabase.execSQL(str);
            SQLiteDetour.a(203984785);
        }
    }
}
