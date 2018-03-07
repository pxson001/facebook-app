package com.facebook.search.bootstrap.db.data;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Build.VERSION;
import com.facebook.common.util.Hex;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.search.bootstrap.db.data.BootstrapDbSchemaPart.EntitiesIndexTable.Columns;
import com.facebook.search.bootstrap.db.data.BootstrapDbSchemaPart.EntitiesPhoneticIndexTable;
import com.facebook.search.bootstrap.db.data.BootstrapDbSchemaPart.EntitiesTable;
import com.facebook.search.bootstrap.db.data.BootstrapDbSchemaPart.KeywordsIndexTable;
import com.facebook.search.bootstrap.db.data.BootstrapDbSchemaPart.KeywordsTable;
import com.facebook.search.bootstrap.model.BootstrapEntities;
import com.facebook.search.bootstrap.model.BootstrapEntity;
import com.facebook.search.bootstrap.model.BootstrapKeyword;
import com.facebook.search.bootstrap.model.BootstrapKeywords;
import com.facebook.search.prefs.GraphSearchPrefKeys;
import com.facebook.search.util.text.TextToPhoneticAndNormalizedTokensUtil;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: externalUrl */
public class BootstrapDbInsertHelper {
    private static volatile BootstrapDbInsertHelper f15661e;
    private final BootstrapDatabaseSupplier f15662a;
    private final BootstrapDbPropertyUtil f15663b;
    private final TextToPhoneticAndNormalizedTokensUtil f15664c;
    private final FbSharedPreferences f15665d;

    public static com.facebook.search.bootstrap.db.data.BootstrapDbInsertHelper m23393a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15661e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.bootstrap.db.data.BootstrapDbInsertHelper.class;
        monitor-enter(r1);
        r0 = f15661e;	 Catch:{ all -> 0x003a }
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
        r0 = m23400b(r0);	 Catch:{ all -> 0x0035 }
        f15661e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15661e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.bootstrap.db.data.BootstrapDbInsertHelper.a(com.facebook.inject.InjectorLike):com.facebook.search.bootstrap.db.data.BootstrapDbInsertHelper");
    }

    private static BootstrapDbInsertHelper m23400b(InjectorLike injectorLike) {
        return new BootstrapDbInsertHelper(BootstrapDatabaseSupplier.m23374a(injectorLike), BootstrapDbPropertyUtil.m23411b(injectorLike), TextToPhoneticAndNormalizedTokensUtil.m23593b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public BootstrapDbInsertHelper(BootstrapDatabaseSupplier bootstrapDatabaseSupplier, BootstrapDbPropertyUtil bootstrapDbPropertyUtil, TextToPhoneticAndNormalizedTokensUtil textToPhoneticAndNormalizedTokensUtil, FbSharedPreferences fbSharedPreferences) {
        this.f15662a = bootstrapDatabaseSupplier;
        this.f15663b = bootstrapDbPropertyUtil;
        this.f15664c = textToPhoneticAndNormalizedTokensUtil;
        this.f15665d = fbSharedPreferences;
    }

    public final void m23407a(BootstrapEntities bootstrapEntities) {
        SQLiteDatabase a = this.f15662a.a();
        SQLiteDetour.a(a, -73077783);
        try {
            a.delete("entities", null, null);
            a.delete("entities_data", null, null);
            a.delete("entities_phonetic_data", null, null);
            this.f15663b.b(BootstrapDbProperties.f15666a, VERSION.SDK_INT);
            m23390a(a, bootstrapEntities.m23436c(), false);
            a.setTransactionSuccessful();
            this.f15665d.edit().putBoolean(GraphSearchPrefKeys.f15922g, true).commit();
        } finally {
            SQLiteDetour.b(a, 1641282304);
        }
    }

    public final void m23408a(BootstrapKeywords bootstrapKeywords) {
        SQLiteDatabase a = this.f15662a.a();
        SQLiteDetour.a(a, 2025144442);
        try {
            a.delete("keywords", null, null);
            a.delete("keywords_data", null, null);
            this.f15663b.b(BootstrapDbProperties.f15666a, VERSION.SDK_INT);
            m23394a(a, bootstrapKeywords.m23443a());
            a.setTransactionSuccessful();
            this.f15665d.edit().putBoolean(GraphSearchPrefKeys.f15922g, true).commit();
        } finally {
            SQLiteDetour.b(a, -822106633);
        }
    }

    public final void m23409b(BootstrapEntities bootstrapEntities) {
        SQLiteDatabase a = this.f15662a.a();
        SQLiteDetour.a(a, 1204118987);
        try {
            m23390a(a, bootstrapEntities.m23436c(), true);
            ImmutableList d = bootstrapEntities.m23437d();
            int size = d.size();
            for (int i = 0; i < size; i++) {
                m23395a(a, (String) d.get(i));
            }
            a.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(a, -1049260263);
        }
    }

    public final int m23406a(ImmutableList<BootstrapEntity> immutableList) {
        SQLiteDatabase a = this.f15662a.a();
        SQLiteDetour.a(a, -269034705);
        try {
            int a2 = m23390a(a, (ImmutableList) immutableList, true);
            a.setTransactionSuccessful();
            return a2;
        } finally {
            SQLiteDetour.b(a, -1303404580);
        }
    }

    private int m23390a(SQLiteDatabase sQLiteDatabase, ImmutableList<BootstrapEntity> immutableList, boolean z) {
        SQLiteStatement d = z ? m23403d(sQLiteDatabase) : m23402c(sQLiteDatabase);
        SQLiteStatement a = m23392a(sQLiteDatabase);
        SQLiteStatement b = m23399b(sQLiteDatabase);
        try {
            int size = immutableList.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                BootstrapEntity bootstrapEntity = (BootstrapEntity) immutableList.get(i2);
                long a2 = m23391a(bootstrapEntity, d, z);
                if (a2 != -1) {
                    int i3 = i + 1;
                    m23397a(bootstrapEntity, a2, a, b);
                    i = i3;
                }
            }
            return i;
        } finally {
            a.close();
            d.close();
            b.close();
        }
    }

    private static void m23394a(SQLiteDatabase sQLiteDatabase, ImmutableList<BootstrapKeyword> immutableList) {
        SQLiteStatement e = m23404e(sQLiteDatabase);
        SQLiteStatement f = m23405f(sQLiteDatabase);
        try {
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                m23398a((BootstrapKeyword) immutableList.get(i), e, f);
            }
        } finally {
            e.close();
            f.close();
        }
    }

    private static long m23391a(BootstrapEntity bootstrapEntity, SQLiteStatement sQLiteStatement, boolean z) {
        long j;
        long j2 = 1;
        m23396a(sQLiteStatement, 1, bootstrapEntity.f15764a);
        m23396a(sQLiteStatement, 2, bootstrapEntity.f15765b);
        m23396a(sQLiteStatement, 3, bootstrapEntity.f15769f);
        m23396a(sQLiteStatement, 4, bootstrapEntity.f15768e);
        m23396a(sQLiteStatement, 5, bootstrapEntity.f15767d.toString());
        m23396a(sQLiteStatement, 6, bootstrapEntity.f15766c.e());
        if (bootstrapEntity.f15772i) {
            j = 1;
        } else {
            j = 0;
        }
        sQLiteStatement.bindLong(7, j);
        sQLiteStatement.bindDouble(8, bootstrapEntity.f15774k);
        if (!bootstrapEntity.f15770g) {
            j2 = 0;
        }
        sQLiteStatement.bindLong(9, j2);
        if (z) {
            m23396a(sQLiteStatement, 10, bootstrapEntity.f15764a);
        }
        SQLiteDetour.a(1562913283);
        j = sQLiteStatement.executeInsert();
        SQLiteDetour.a(813376495);
        return j;
    }

    private static void m23395a(SQLiteDatabase sQLiteDatabase, String str) {
        String str2 = "DELETE FROM entities_data WHERE " + Columns.f15671a + " IN (SELECT " + EntitiesTable.Columns.f15679a + " FROM entities" + " WHERE " + EntitiesTable.Columns.f15680b + " = ? )";
        String[] strArr = new String[]{str};
        SQLiteDetour.a(1748963272);
        sQLiteDatabase.execSQL(str2, strArr);
        SQLiteDetour.a(-915400195);
        str2 = "DELETE FROM entities WHERE " + EntitiesTable.Columns.f15680b + " = ? ";
        strArr = new String[]{str};
        SQLiteDetour.a(1978419601);
        sQLiteDatabase.execSQL(str2, strArr);
        SQLiteDetour.a(-1621483598);
    }

    private void m23397a(BootstrapEntity bootstrapEntity, long j, SQLiteStatement sQLiteStatement, SQLiteStatement sQLiteStatement2) {
        String str;
        int i = 0;
        ImmutableList immutableList = bootstrapEntity.f15773j;
        int size = immutableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            str = (String) immutableList.get(i2);
            sQLiteStatement.bindLong(1, j);
            m23401b(sQLiteStatement, 2, str);
            SQLiteDetour.a(-304172362);
            sQLiteStatement.executeInsert();
            SQLiteDetour.a(1243716442);
        }
        str = bootstrapEntity.f15765b;
        if (str != null) {
            ImmutableList a = this.f15664c.m23594a(str);
            int size2 = a.size();
            while (i < size2) {
                str = (String) a.get(i);
                if (str != null) {
                    sQLiteStatement2.bindLong(1, j);
                    m23396a(sQLiteStatement2, 2, str);
                    SQLiteDetour.a(-399639929);
                    sQLiteStatement2.executeInsert();
                    SQLiteDetour.a(-892312713);
                }
                i++;
            }
        }
    }

    private static void m23398a(BootstrapKeyword bootstrapKeyword, SQLiteStatement sQLiteStatement, SQLiteStatement sQLiteStatement2) {
        m23396a(sQLiteStatement, 1, bootstrapKeyword.f15783a);
        m23396a(sQLiteStatement, 2, bootstrapKeyword.f15784b);
        m23396a(sQLiteStatement, 3, bootstrapKeyword.f15785c);
        m23396a(sQLiteStatement, 4, bootstrapKeyword.f15786d);
        m23396a(sQLiteStatement, 5, bootstrapKeyword.f15787e);
        sQLiteStatement.bindDouble(6, bootstrapKeyword.f15789g);
        m23396a(sQLiteStatement, 7, bootstrapKeyword.f15790h);
        SQLiteDetour.a(-2136595524);
        long executeInsert = sQLiteStatement.executeInsert();
        SQLiteDetour.a(-1744807919);
        if (executeInsert != -1) {
            ImmutableList immutableList = bootstrapKeyword.f15788f;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                String str = (String) immutableList.get(i);
                sQLiteStatement2.bindLong(1, executeInsert);
                m23401b(sQLiteStatement2, 2, str);
                SQLiteDetour.a(-86006531);
                sQLiteStatement2.executeInsert();
                SQLiteDetour.a(-203006149);
            }
        }
    }

    private static SQLiteStatement m23392a(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase.compileStatement("INSERT INTO entities_data (" + Columns.f15671a + ", " + Columns.f15672b + ") VALUES (?, ?)");
    }

    private static SQLiteStatement m23399b(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase.compileStatement("INSERT INTO entities_phonetic_data (" + EntitiesPhoneticIndexTable.Columns.f15675a + ", " + EntitiesPhoneticIndexTable.Columns.f15676b + ") VALUES (?, ?)");
    }

    private static SQLiteStatement m23402c(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase.compileStatement("INSERT INTO entities (" + EntitiesTable.Columns.f15680b + ", " + EntitiesTable.Columns.f15681c + ", " + EntitiesTable.Columns.f15682d + ", " + EntitiesTable.Columns.f15683e + ", " + EntitiesTable.Columns.f15684f + ", " + EntitiesTable.Columns.f15685g + ", " + EntitiesTable.Columns.f15686h + ", " + EntitiesTable.Columns.f15687i + ", " + EntitiesTable.Columns.f15688j + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
    }

    private static SQLiteStatement m23403d(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase.compileStatement("INSERT INTO entities ( " + EntitiesTable.Columns.f15680b + ", " + EntitiesTable.Columns.f15681c + ", " + EntitiesTable.Columns.f15682d + ", " + EntitiesTable.Columns.f15683e + ", " + EntitiesTable.Columns.f15684f + ", " + EntitiesTable.Columns.f15685g + ", " + EntitiesTable.Columns.f15686h + ", " + EntitiesTable.Columns.f15687i + ", " + EntitiesTable.Columns.f15688j + " )  SELECT ?, ?, ?, ?, ?, ?, ?, ?, ? WHERE NOT EXISTS ( SELECT " + EntitiesTable.Columns.f15680b + " FROM entities" + " WHERE " + EntitiesTable.Columns.f15680b + " = ?) ");
    }

    private static SQLiteStatement m23404e(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase.compileStatement("INSERT INTO keywords (" + KeywordsTable.Columns.f15695b + ", " + KeywordsTable.Columns.f15696c + ", " + KeywordsTable.Columns.f15697d + ", " + KeywordsTable.Columns.f15698e + ", " + KeywordsTable.Columns.f15699f + ", " + KeywordsTable.Columns.f15700g + ", " + KeywordsTable.Columns.f15701h + ") VALUES (?, ?, ?, ?, ?, ?, ?)");
    }

    private static SQLiteStatement m23405f(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase.compileStatement("INSERT INTO keywords_data (" + KeywordsIndexTable.Columns.f15690a + ", " + KeywordsIndexTable.Columns.f15691b + ") VALUES (?, ?)");
    }

    private static void m23396a(SQLiteStatement sQLiteStatement, int i, @Nullable String str) {
        if (str == null) {
            sQLiteStatement.bindNull(i);
        } else {
            sQLiteStatement.bindString(i, str);
        }
    }

    private static void m23401b(SQLiteStatement sQLiteStatement, int i, @Nullable String str) {
        if (str == null) {
            sQLiteStatement.bindNull(i);
        } else {
            sQLiteStatement.bindBlob(i, Hex.a(str));
        }
    }
}
