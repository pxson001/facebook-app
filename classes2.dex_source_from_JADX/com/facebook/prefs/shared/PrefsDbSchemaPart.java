package com.facebook.prefs.shared;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferencesContract.PreferencesTable;
import com.facebook.prefs.shared.FbSharedPreferencesContract.PreferencesTable.Columns;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: visitor_class */
public class PrefsDbSchemaPart extends TablesDbSchemaPart {
    private static final Class<?> f1007a = PrefsDbSchemaPart.class;
    private static volatile PrefsDbSchemaPart f1008c;
    private PrefsMigrator f1009b;

    /* compiled from: visitor_class */
    public final class PrefTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f1015a = ImmutableList.of(Columns.f1019a, Columns.f1021c, Columns.f1020b);

        PrefTable() {
            super("preferences", f1015a);
        }
    }

    public static com.facebook.prefs.shared.PrefsDbSchemaPart m2036a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1008c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.prefs.shared.PrefsDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f1008c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m2038b(r0);	 Catch:{ all -> 0x0035 }
        f1008c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1008c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.prefs.shared.PrefsDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.prefs.shared.PrefsDbSchemaPart");
    }

    private static PrefsDbSchemaPart m2038b(InjectorLike injectorLike) {
        return new PrefsDbSchemaPart(new PrefsMigrator(IdBasedSingletonScopeProvider.m1810b(injectorLike, 572)));
    }

    @Inject
    public PrefsDbSchemaPart(PrefsMigrator prefsMigrator) {
        super("preferences", 2, ImmutableList.of(new PrefTable()));
        this.f1009b = prefsMigrator;
    }

    public final void mo319a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Integer.valueOf(i);
        Integer.valueOf(i2);
        if (i < 2 && 2 <= i2) {
            m2039d(sQLiteDatabase);
        }
        if (2 < i2) {
            throw new IllegalStateException(StringFormatUtil.a("You are upgrading to %d from %d and do not have update code. Write some damn upgrade code!!!1!", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }

    private void m2039d(SQLiteDatabase sQLiteDatabase) {
        TracerDetour.a("#maybeMigrate", 1944328856);
        try {
            SQLiteDetour.a(sQLiteDatabase, -635208200);
            try {
                Map e = m2040e(sQLiteDatabase);
                if (this.f1009b.m2068a(e)) {
                    m2037a(sQLiteDatabase, e);
                }
                sQLiteDatabase.setTransactionSuccessful();
                SQLiteDetour.b(sQLiteDatabase, e);
            } finally {
                SQLiteDetour.b(sQLiteDatabase, 1050182733);
            }
        } finally {
            TracerDetour.a(653018496);
        }
    }

    private void m2037a(SQLiteDatabase sQLiteDatabase, SortedMap<PrefKey, Object> sortedMap) {
        SortedMap a = this.f1009b.m2067a((SortedMap) sortedMap);
        TracerDetour.a("#migrate", 328736049);
        try {
            sQLiteDatabase.delete("preferences", null, null);
            ContentValues contentValues = new ContentValues();
            for (Entry entry : a.entrySet()) {
                FbSharedPreferencesContract.m4330a(contentValues, (PrefKey) entry.getKey(), entry.getValue());
                SQLiteDetour.a(-324312999);
                sQLiteDatabase.replaceOrThrow("preferences", null, contentValues);
                SQLiteDetour.a(-702140069);
            }
        } finally {
            TracerDetour.a(-1499020106);
        }
    }

    private static SortedMap<PrefKey, Object> m2040e(SQLiteDatabase sQLiteDatabase) {
        Object f = Maps.m844f();
        Cursor query = sQLiteDatabase.query("preferences", PreferencesTable.f2182a, null, null, null, null, null);
        try {
            FbSharedPreferencesContract.m4331a(query, f);
            return f;
        } finally {
            if (query != null) {
                query.close();
            }
        }
    }
}
