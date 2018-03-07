package com.facebook.graphql.executor.cache;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlKeys$PrimaryKey;
import com.facebook.database.sqlite.SqlKeys$SqlKey;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: saved_for_later_android_in_app_browser */
public class GraphQLDBSchemaPart extends TablesDbSchemaPart {
    private static volatile GraphQLDBSchemaPart f6127a;

    /* compiled from: saved_for_later_android_in_app_browser */
    public final class GraphQLDiskCacheQueriesTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f6128a = ImmutableList.of(GraphQLDBContract$QueriesTable$Columns.f6129a, GraphQLDBContract$QueriesTable$Columns.f6130b, GraphQLDBContract$QueriesTable$Columns.f6131c, GraphQLDBContract$QueriesTable$Columns.f6133e, GraphQLDBContract$QueriesTable$Columns.f6134f, GraphQLDBContract$QueriesTable$Columns.f6132d, GraphQLDBContract$QueriesTable$Columns.f6135g, GraphQLDBContract$QueriesTable$Columns.f6136h, GraphQLDBContract$QueriesTable$Columns.f6137i, GraphQLDBContract$QueriesTable$Columns.f6138j, GraphQLDBContract$QueriesTable$Columns.f6139k, GraphQLDBContract$QueriesTable$Columns.f6140l, new SqlColumn[0]);

        GraphQLDiskCacheQueriesTable() {
            super("queries", f6128a);
        }

        public final void mo1453a(SQLiteDatabase sQLiteDatabase) {
            super.mo1453a(sQLiteDatabase);
            SQLiteDetour.a(1817052280);
            sQLiteDatabase.execSQL("CREATE UNIQUE INDEX query_user_unique ON queries(query_id, user_id);");
            SQLiteDetour.a(-1951003406);
        }

        public final void mo1454a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i <= 18) {
                String a = SqlTable.m2069a("flat");
                SQLiteDetour.a(-151360492);
                sQLiteDatabase.execSQL(a);
                SQLiteDetour.a(-1785026928);
            }
            if (i < 44) {
                super.mo1454a(sQLiteDatabase, i, i2);
            }
        }
    }

    /* compiled from: saved_for_later_android_in_app_browser */
    public class GraphQLDiskCacheTagsTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f6141a = ImmutableList.of(GraphQLDBContract$TagsTable$Columns.f6142a, GraphQLDBContract$TagsTable$Columns.f6143b);

        GraphQLDiskCacheTagsTable() {
            super("tags", f6141a, ImmutableList.of(new SqlKeys$PrimaryKey(ImmutableList.of(GraphQLDBContract$TagsTable$Columns.f6142a, GraphQLDBContract$TagsTable$Columns.f6143b))));
        }

        public final void mo1453a(SQLiteDatabase sQLiteDatabase) {
            super.mo1453a(sQLiteDatabase);
            String a = SqlTable.m2073a("tags", "tag_table_tags_index", ImmutableList.of(GraphQLDBContract$TagsTable$Columns.f6143b));
            SQLiteDetour.a(-562125305);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(-1221613956);
            a = SqlTable.m2073a("tags", "tag_table_rowid_ref_index", ImmutableList.of(GraphQLDBContract$TagsTable$Columns.f6142a));
            SQLiteDetour.a(1032646789);
            sQLiteDatabase.execSQL(a);
            SQLiteDetour.a(-143060535);
        }

        public final void mo1454a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i < 44) {
                super.mo1454a(sQLiteDatabase, i, i2);
            }
        }

        public final void mo1455c(SQLiteDatabase sQLiteDatabase) {
            super.mo1455c(sQLiteDatabase);
            SQLiteDetour.a(-741599143);
            sQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
            SQLiteDetour.a(-1232233864);
        }
    }

    /* compiled from: saved_for_later_android_in_app_browser */
    public class GraphQLConsistencyCacheTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f6145a = ImmutableList.of(GraphQLDBContract$ConsistencyTable$Columns.f6147a, GraphQLDBContract$ConsistencyTable$Columns.f6149c, GraphQLDBContract$ConsistencyTable$Columns.f6148b, GraphQLDBContract$ConsistencyTable$Columns.f6150d, GraphQLDBContract$ConsistencyTable$Columns.f6151e, GraphQLDBContract$ConsistencyTable$Columns.f6152f, GraphQLDBContract$ConsistencyTable$Columns.f6153g);
        private static final ImmutableList<SqlKeys$SqlKey> f6146b = ImmutableList.of(new SqlKeys$PrimaryKey(ImmutableList.of(GraphQLDBContract$ConsistencyTable$Columns.f6147a, GraphQLDBContract$ConsistencyTable$Columns.f6148b, GraphQLDBContract$ConsistencyTable$Columns.f6149c)));

        public GraphQLConsistencyCacheTable() {
            super("consistency", f6145a, f6146b);
        }

        public final void mo1454a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i < 44) {
                super.mo1454a(sQLiteDatabase, i, i2);
            }
        }
    }

    /* compiled from: saved_for_later_android_in_app_browser */
    public class GraphQLConsistencyIndexTable extends SqlTable {
        public GraphQLConsistencyIndexTable() {
            super("consistency_index", ImmutableList.of(GraphQLDBContract$ConsistencyIndexTable$Columns.f6154a, GraphQLDBContract$ConsistencyIndexTable$Columns.f6155b, GraphQLDBContract$ConsistencyIndexTable$Columns.f6156c, GraphQLDBContract$ConsistencyIndexTable$Columns.f6157d, GraphQLDBContract$ConsistencyIndexTable$Columns.f6158e), ImmutableList.of(new SqlKeys$PrimaryKey(ImmutableList.of(GraphQLDBContract$ConsistencyIndexTable$Columns.f6154a, GraphQLDBContract$ConsistencyIndexTable$Columns.f6155b, GraphQLDBContract$ConsistencyIndexTable$Columns.f6156c, GraphQLDBContract$ConsistencyIndexTable$Columns.f6157d, GraphQLDBContract$ConsistencyIndexTable$Columns.f6158e))));
        }

        public final void mo1454a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i < 44) {
                super.mo1454a(sQLiteDatabase, i, i2);
            }
        }
    }

    public static com.facebook.graphql.executor.cache.GraphQLDBSchemaPart m10318a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f6127a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.graphql.executor.cache.GraphQLDBSchemaPart.class;
        monitor-enter(r1);
        r0 = f6127a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m10319d();	 Catch:{ all -> 0x0034 }
        f6127a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f6127a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.executor.cache.GraphQLDBSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.graphql.executor.cache.GraphQLDBSchemaPart");
    }

    private static GraphQLDBSchemaPart m10319d() {
        return new GraphQLDBSchemaPart();
    }

    @Inject
    public GraphQLDBSchemaPart() {
        super("graphql_response_cache", 44, ImmutableList.of(new GraphQLDiskCacheQueriesTable(), new GraphQLDiskCacheTagsTable(), new GraphQLConsistencyCacheTable(), new GraphQLConsistencyIndexTable()));
    }
}
