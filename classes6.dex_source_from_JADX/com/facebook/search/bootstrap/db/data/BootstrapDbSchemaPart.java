package com.facebook.search.bootstrap.db.data;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.properties.DbPropertyUtil;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlKeys.ForeignKey;
import com.facebook.database.sqlite.SqlKeys.SqlKey;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.search.prefs.GraphSearchPrefKeys;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: exposure */
public class BootstrapDbSchemaPart extends TablesDbSchemaPart {
    private static volatile BootstrapDbSchemaPart f15703b;
    private final FbSharedPreferences f15704a;

    /* compiled from: exposure */
    public final class BootstrapPropertiesTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f15670a = ImmutableList.of(DbPropertyUtil.a, DbPropertyUtil.b);

        public BootstrapPropertiesTable() {
            super("bootstrap_db_properties", f15670a);
        }
    }

    /* compiled from: exposure */
    public final class EntitiesIndexTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f15673a = ImmutableList.of(Columns.f15671a, Columns.f15672b);
        private static final ImmutableList<SqlKey> f15674b = ImmutableList.of(new ForeignKey(ImmutableList.of(Columns.f15671a), "entities", ImmutableList.of(Columns.f15679a)));

        /* compiled from: exposure */
        public class Columns {
            public static final SqlColumn f15671a = new SqlColumn("entity_internal_id", "INTEGER NOT NULL");
            public static final SqlColumn f15672b = new SqlColumn("indexed_data", "BLOB NOT NULL");
        }

        public EntitiesIndexTable() {
            super("entities_data", f15673a, f15674b);
        }

        public final void m23414a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String a = SqlTable.a("entities_data", "ENTITIES_DATA_INDEX", ImmutableList.of(Columns.f15672b, Columns.f15671a));
            SQLiteDetour.a(-688560897);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(1454756199);
        }
    }

    /* compiled from: exposure */
    public final class EntitiesPhoneticIndexTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f15677a = ImmutableList.of(Columns.f15675a, Columns.f15676b);
        private static final ImmutableList<SqlKey> f15678b = ImmutableList.of(new ForeignKey(ImmutableList.of(Columns.f15675a), "entities", ImmutableList.of(Columns.f15679a)));

        /* compiled from: exposure */
        public class Columns {
            public static final SqlColumn f15675a = new SqlColumn("entity_internal_id", "INTEGER NOT NULL");
            public static final SqlColumn f15676b = new SqlColumn("indexed_data", "TEXT NOT NULL");
        }

        public EntitiesPhoneticIndexTable() {
            super("entities_phonetic_data", f15677a, f15678b);
        }

        public final void m23415a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String a = SqlTable.a("entities_phonetic_data", "ENTITIES_PHONETIC_DATA_INDEX", ImmutableList.of(Columns.f15676b, Columns.f15675a));
            SQLiteDetour.a(371830280);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(24516280);
        }
    }

    /* compiled from: exposure */
    public final class EntitiesTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f15689a = ImmutableList.of(Columns.f15679a, Columns.f15680b, Columns.f15681c, Columns.f15682d, Columns.f15683e, Columns.f15684f, Columns.f15685g, Columns.f15686h, Columns.f15687i, Columns.f15688j);

        /* compiled from: exposure */
        public class Columns {
            public static final SqlColumn f15679a = new SqlColumn("internal_id", "INTEGER PRIMARY KEY AUTOINCREMENT");
            public static final SqlColumn f15680b = new SqlColumn("fbid", "TEXT UNIQUE");
            public static final SqlColumn f15681c = new SqlColumn("name", "TEXT NOT NULL");
            public static final SqlColumn f15682d = new SqlColumn("category", "TEXT");
            public static final SqlColumn f15683e = new SqlColumn("subtext", "TEXT");
            public static final SqlColumn f15684f = new SqlColumn("profile_picture_uri", "TEXT NOT NULL");
            public static final SqlColumn f15685g = new SqlColumn("type", "TEXT NOT NULL");
            public static final SqlColumn f15686h = new SqlColumn("is_connected", "INTEGER NOT NULL");
            public static final SqlColumn f15687i = new SqlColumn("cost", "DOUBLE NOT NULL");
            public static final SqlColumn f15688j = new SqlColumn("is_verified", "INTEGER NOT NULL");
        }

        public EntitiesTable() {
            super("entities", f15689a);
        }
    }

    /* compiled from: exposure */
    public final class KeywordsIndexTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f15692a = ImmutableList.of(Columns.f15690a, Columns.f15691b);
        private static final ImmutableList<SqlKey> f15693b = ImmutableList.of(new ForeignKey(ImmutableList.of(Columns.f15690a), "keywords", ImmutableList.of(Columns.f15694a)));

        /* compiled from: exposure */
        public class Columns {
            public static final SqlColumn f15690a = new SqlColumn("keyword_internal_id", "INTEGER NOT NULL");
            public static final SqlColumn f15691b = new SqlColumn("indexed_data", "BLOB NOT NULL");
        }

        public KeywordsIndexTable() {
            super("keywords_data", f15692a, f15693b);
        }

        public final void m23416a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String a = SqlTable.a("keywords_data", "KEYWORDS_DATA_INDEX", ImmutableList.of(Columns.f15691b, Columns.f15690a));
            SQLiteDetour.a(-1404572267);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(616602519);
        }
    }

    /* compiled from: exposure */
    public final class KeywordsTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f15702a = ImmutableList.of(Columns.f15694a, Columns.f15695b, Columns.f15696c, Columns.f15697d, Columns.f15698e, Columns.f15699f, Columns.f15700g, Columns.f15701h);

        /* compiled from: exposure */
        public class Columns {
            public static final SqlColumn f15694a = new SqlColumn("internal_id", "INTEGER PRIMARY KEY AUTOINCREMENT");
            public static final SqlColumn f15695b = new SqlColumn("name", "TEXT NOT NULL");
            public static final SqlColumn f15696c = new SqlColumn("type", "TEXT NOT NULL");
            public static final SqlColumn f15697d = new SqlColumn("semantic", "TEXT");
            public static final SqlColumn f15698e = new SqlColumn("subtext", "TEXT");
            public static final SqlColumn f15699f = new SqlColumn("bolded_subtext", "TEXT");
            public static final SqlColumn f15700g = new SqlColumn("cost", "DOUBLE NOT NULL");
            public static final SqlColumn f15701h = new SqlColumn("source", "TEXT");
        }

        public KeywordsTable() {
            super("keywords", f15702a);
        }
    }

    public static com.facebook.search.bootstrap.db.data.BootstrapDbSchemaPart m23417a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15703b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.bootstrap.db.data.BootstrapDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f15703b;	 Catch:{ all -> 0x003a }
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
        r0 = m23418b(r0);	 Catch:{ all -> 0x0035 }
        f15703b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15703b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.bootstrap.db.data.BootstrapDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.search.bootstrap.db.data.BootstrapDbSchemaPart");
    }

    private static BootstrapDbSchemaPart m23418b(InjectorLike injectorLike) {
        return new BootstrapDbSchemaPart((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public BootstrapDbSchemaPart(FbSharedPreferences fbSharedPreferences) {
        super("search_bootstrap", 30, ImmutableList.of(new BootstrapPropertiesTable(), new EntitiesTable(), new EntitiesIndexTable(), new EntitiesPhoneticIndexTable(), new KeywordsTable(), new KeywordsIndexTable()));
        this.f15704a = fbSharedPreferences;
    }

    protected final void m23419a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 28 || i2 != 30) {
            super.a(sQLiteDatabase, i, i2);
            this.f15704a.a(ImmutableSet.of(GraphSearchPrefKeys.f15917b, GraphSearchPrefKeys.f15918c));
            return;
        }
        ImmutableList immutableList = this.a;
        int size = immutableList.size();
        for (int i3 = 0; i3 < size; i3++) {
            String str = ((SqlTable) immutableList.get(i3)).a;
            if (str.equals("keywords")) {
                if (i == 28) {
                    String a = SqlTable.a(str, Columns.f15701h);
                    SQLiteDetour.a(-132900782);
                    sQLiteDatabase.execSQL(a);
                    SQLiteDetour.a(1310203058);
                }
                str = SqlTable.a(str, Columns.f15697d);
                SQLiteDetour.a(1359543427);
                sQLiteDatabase.execSQL(str);
                SQLiteDetour.a(-1317960811);
                return;
            }
        }
    }
}
