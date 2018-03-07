package com.facebook.graphql.cursor.database;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlKeys.PrimaryKey;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: metadata_at_text_ranges */
public class GraphCursorDbSchemaPart extends TablesDbSchemaPart {
    private static volatile GraphCursorDbSchemaPart f7864a;

    /* compiled from: metadata_at_text_ranges */
    public final class GraphCursorConnectionsTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f7865a = ImmutableList.of(GraphCursorDatabaseContract$ConnectionsTable$Columns.f7866a, GraphCursorDatabaseContract$ConnectionsTable$Columns.f7867b, GraphCursorDatabaseContract$ConnectionsTable$Columns.f7868c, GraphCursorDatabaseContract$ConnectionsTable$Columns.f7869d, GraphCursorDatabaseContract$ConnectionsTable$Columns.f7870e, GraphCursorDatabaseContract$ConnectionsTable$Columns.f7871f, GraphCursorDatabaseContract$ConnectionsTable$Columns.f7872g, GraphCursorDatabaseContract$ConnectionsTable$Columns.f7873h);

        public GraphCursorConnectionsTable() {
            super("connections", f7865a);
        }

        public final void m8174a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String str = "CREATE INDEX idx_sessions_sorted ON connections(" + GraphCursorDatabaseContract$ConnectionsTable$Columns.f7869d.d + ", " + GraphCursorDatabaseContract$ConnectionsTable$Columns.f7872g.d + ");";
            SQLiteDetour.a(1545526307);
            sQLiteDatabase.execSQL(str);
            SQLiteDetour.a(-104029750);
        }

        public final void m8176c(SQLiteDatabase sQLiteDatabase) {
            super.c(sQLiteDatabase);
            SQLiteDetour.a(-2132646108);
            sQLiteDatabase.execSQL("PRAGMA synchronous=OFF;");
            SQLiteDetour.a(696908247);
        }

        public final void m8175b(SQLiteDatabase sQLiteDatabase) {
            GraphCursorDatabase.m8132a(sQLiteDatabase);
        }
    }

    /* compiled from: metadata_at_text_ranges */
    public final class GraphCursorChunksTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f7874a = ImmutableList.of(GraphCursorDatabaseContract$ChunksTable$Columns.f7875a, GraphCursorDatabaseContract$ChunksTable$Columns.f7876b, GraphCursorDatabaseContract$ChunksTable$Columns.f7877c, GraphCursorDatabaseContract$ChunksTable$Columns.f7878d, GraphCursorDatabaseContract$ChunksTable$Columns.f7879e, GraphCursorDatabaseContract$ChunksTable$Columns.f7880f, GraphCursorDatabaseContract$ChunksTable$Columns.f7881g);

        public GraphCursorChunksTable() {
            super("chunks", f7874a);
        }

        public final void m8177a(SQLiteDatabase sQLiteDatabase) {
            super.a(sQLiteDatabase);
            String str = "CREATE INDEX idx_chunk_sessions_sorted ON chunks(" + GraphCursorDatabaseContract$ChunksTable$Columns.f7876b.d + ", " + GraphCursorDatabaseContract$ChunksTable$Columns.f7877c.d + ");";
            SQLiteDetour.a(164245875);
            sQLiteDatabase.execSQL(str);
            SQLiteDetour.a(-1910963267);
        }

        public final void m8178b(SQLiteDatabase sQLiteDatabase) {
            GraphCursorDatabase.m8132a(sQLiteDatabase);
        }
    }

    /* compiled from: metadata_at_text_ranges */
    public final class GraphCursorModelsTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f7882a = ImmutableList.of(GraphCursorDatabaseContract$ModelsTable$Columns.f7883a, GraphCursorDatabaseContract$ModelsTable$Columns.f7884b, GraphCursorDatabaseContract$ModelsTable$Columns.f7885c, GraphCursorDatabaseContract$ModelsTable$Columns.f7886d, GraphCursorDatabaseContract$ModelsTable$Columns.f7887e);

        public GraphCursorModelsTable() {
            super("models", f7882a);
        }

        public final void m8179b(SQLiteDatabase sQLiteDatabase) {
            GraphCursorDatabase.m8132a(sQLiteDatabase);
        }
    }

    /* compiled from: metadata_at_text_ranges */
    public final class GraphCursorTagsTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f7888a = ImmutableList.of(GraphCursorDatabaseContract$TagsTable$Columns.f7889a, GraphCursorDatabaseContract$TagsTable$Columns.f7890b);

        public GraphCursorTagsTable() {
            super("tags", f7888a, ImmutableList.of(new PrimaryKey(ImmutableList.of(GraphCursorDatabaseContract$TagsTable$Columns.f7889a, GraphCursorDatabaseContract$TagsTable$Columns.f7890b))));
        }

        public final void m8180b(SQLiteDatabase sQLiteDatabase) {
            GraphCursorDatabase.m8132a(sQLiteDatabase);
        }

        public final void m8181c(SQLiteDatabase sQLiteDatabase) {
            super.c(sQLiteDatabase);
            SQLiteDetour.a(-1869856658);
            sQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
            SQLiteDetour.a(1381465299);
        }
    }

    public static com.facebook.graphql.cursor.database.GraphCursorDbSchemaPart m8172a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7864a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.graphql.cursor.database.GraphCursorDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f7864a;	 Catch:{ all -> 0x0039 }
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
        r0 = m8173d();	 Catch:{ all -> 0x0034 }
        f7864a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f7864a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.cursor.database.GraphCursorDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.graphql.cursor.database.GraphCursorDbSchemaPart");
    }

    private static GraphCursorDbSchemaPart m8173d() {
        return new GraphCursorDbSchemaPart();
    }

    @Inject
    public GraphCursorDbSchemaPart() {
        super("graph_cursors", 28, ImmutableList.of(new GraphCursorConnectionsTable(), new GraphCursorChunksTable(), new GraphCursorModelsTable(), new GraphCursorTagsTable()));
    }
}
