package com.facebook.nearby.data.db;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlKeys.PrimaryKey;
import com.facebook.database.sqlite.SqlKeys.SqlKey;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: userCert */
public class NearbyTilesDbSchemaPart extends TablesDbSchemaPart {
    private static final Class<?> f350a = NearbyTilesDbSchemaPart.class;
    private static volatile NearbyTilesDbSchemaPart f351b;

    /* compiled from: userCert */
    public final class NearbyTilesTable extends SqlTable {
        public static final SqlKey f345a = new PrimaryKey(ImmutableList.of(Columns.f335a, Columns.f336b, Columns.f337c));
        private static final ImmutableList<SqlColumn> f346b = ImmutableList.of(Columns.f335a, Columns.f336b, Columns.f337c, Columns.f338d, Columns.f339e, Columns.f340f, Columns.f341g, Columns.f342h, Columns.f343i, Columns.f344j);
        private static final ImmutableList<SqlKey> f347c = ImmutableList.of(f345a);

        /* compiled from: userCert */
        public class Columns {
            public static final SqlColumn f335a = new SqlColumn("tile_id", "TEXT");
            public static final SqlColumn f336b = new SqlColumn("queryFunctions", "TEXT");
            public static final SqlColumn f337c = new SqlColumn("topicIds", "TEXT");
            public static final SqlColumn f338d = new SqlColumn("northBound", "REAL");
            public static final SqlColumn f339e = new SqlColumn("southBound", "REAL");
            public static final SqlColumn f340f = new SqlColumn("eastBound", "REAL");
            public static final SqlColumn f341g = new SqlColumn("westBound", "REAL");
            public static final SqlColumn f342h = new SqlColumn("tileJson", "TEXT");
            public static final SqlColumn f343i = new SqlColumn("tileTtl", "INTEGER");
            public static final SqlColumn f344j = new SqlColumn("tileFetchedTime", "INTEGER");
        }

        NearbyTilesTable() {
            super("nearby_tiles", f346b, f347c);
        }

        public final void m427a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String a = SqlTable.a("nearby_tiles", "nearby_tiles_index", ImmutableList.of(Columns.f344j));
            SQLiteDetour.a(1018408890);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(-7522006);
        }
    }

    /* compiled from: userCert */
    public final class TileVersionTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f349a = ImmutableList.of(Columns.f348a);

        /* compiled from: userCert */
        public class Columns {
            public static final SqlColumn f348a = new SqlColumn("tileVersion", "TEXT PRIMARY KEY");
        }

        TileVersionTable() {
            super("nearby_tiles_version", f349a);
        }
    }

    public static com.facebook.nearby.data.db.NearbyTilesDbSchemaPart m428a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f351b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.nearby.data.db.NearbyTilesDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f351b;	 Catch:{ all -> 0x0039 }
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
        r0 = m429d();	 Catch:{ all -> 0x0034 }
        f351b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f351b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.nearby.data.db.NearbyTilesDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.nearby.data.db.NearbyTilesDbSchemaPart");
    }

    private static NearbyTilesDbSchemaPart m429d() {
        return new NearbyTilesDbSchemaPart();
    }

    @Inject
    public NearbyTilesDbSchemaPart() {
        super("nearby_tiles", 2, ImmutableList.of(new NearbyTilesTable(), new TileVersionTable()));
    }
}
