package com.facebook.notifications.db;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.facebook.ipc.notifications.GraphQLNotificationsContract.GraphQLNotificationsTable.Columns;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: method/mobile.gatekeepers */
public class GraphQLNotificationsDbSchemaPart extends TablesDbSchemaPart {
    private static volatile GraphQLNotificationsDbSchemaPart f7831a;

    /* compiled from: method/mobile.gatekeepers */
    public final class NotificationsTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f7832a = ImmutableList.of(Columns.f7587a, Columns.f7588b, Columns.f7589c, Columns.f7590d, Columns.f7591e, Columns.f7592f, Columns.f7593g, Columns.f7594h, Columns.f7595i, Columns.f7596j, Columns.f7597k, Columns.f7598l, new SqlColumn[]{Columns.f7599m, Columns.f7600n, Columns.f7601o, Columns.f7602p, Columns.f7603q, Columns.f7604r, Columns.f7605s, Columns.f7606t, Columns.f7607u, Columns.f7608v, Columns.f7609w});

        public final void m8077b(SQLiteDatabase sQLiteDatabase) {
            SQLiteDetour.a(-721240128);
            sQLiteDatabase.execSQL("DELETE FROM gql_notifications");
            SQLiteDetour.a(-566569946);
        }

        NotificationsTable() {
            super("gql_notifications", f7832a);
        }
    }

    public static com.facebook.notifications.db.GraphQLNotificationsDbSchemaPart m8075a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7831a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.notifications.db.GraphQLNotificationsDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f7831a;	 Catch:{ all -> 0x0039 }
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
        r0 = m8076d();	 Catch:{ all -> 0x0034 }
        f7831a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f7831a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.db.GraphQLNotificationsDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.notifications.db.GraphQLNotificationsDbSchemaPart");
    }

    private static GraphQLNotificationsDbSchemaPart m8076d() {
        return new GraphQLNotificationsDbSchemaPart();
    }

    @Inject
    public GraphQLNotificationsDbSchemaPart() {
        super("notifications", 25, ImmutableList.of(new NotificationsTable()));
    }
}
