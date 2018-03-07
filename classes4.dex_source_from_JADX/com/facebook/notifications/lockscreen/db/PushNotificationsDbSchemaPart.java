package com.facebook.notifications.lockscreen.db;

import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlKeys.PrimaryKey;
import com.facebook.database.sqlite.SqlKeys.SqlKey;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: logging_not_reset */
public class PushNotificationsDbSchemaPart extends TablesDbSchemaPart {
    private static volatile PushNotificationsDbSchemaPart f8909a;

    /* compiled from: logging_not_reset */
    public final class PushNotificationsTable extends SqlTable {
        @VisibleForTesting
        static final ImmutableList<SqlColumn> f8910a = ImmutableList.of(Columns.f8913a, Columns.f8914b, Columns.f8915c, Columns.f8916d, Columns.f8917e, Columns.f8918f, Columns.f8919g, Columns.f8920h);
        private static final SqlKey f8911b;
        private static final ImmutableList<SqlKey> f8912c;

        /* compiled from: logging_not_reset */
        public class Columns {
            public static final SqlColumn f8913a = new SqlColumn("id", "INTEGER");
            public static final SqlColumn f8914b = new SqlColumn("tag", "TEXT");
            public static final SqlColumn f8915c = new SqlColumn("graphql_id", "INTEGER");
            public static final SqlColumn f8916d = new SqlColumn("content_text", "TEXT");
            public static final SqlColumn f8917e = new SqlColumn("notification_time", "INT");
            public static final SqlColumn f8918f = new SqlColumn("notification_type", "INT");
            public static final SqlColumn f8919g = new SqlColumn("campaign_data", "TEXT");
            public static final SqlColumn f8920h = new SqlColumn("ndid", "TEXT");
        }

        static {
            PrimaryKey primaryKey = new PrimaryKey(ImmutableList.of(Columns.f8913a, Columns.f8914b));
            f8911b = primaryKey;
            f8912c = ImmutableList.of(primaryKey);
        }

        PushNotificationsTable() {
            super("push_notifications", f8910a, f8912c);
        }
    }

    public static com.facebook.notifications.lockscreen.db.PushNotificationsDbSchemaPart m9273a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8909a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.notifications.lockscreen.db.PushNotificationsDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f8909a;	 Catch:{ all -> 0x0039 }
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
        r0 = m9274d();	 Catch:{ all -> 0x0034 }
        f8909a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f8909a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.lockscreen.db.PushNotificationsDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.notifications.lockscreen.db.PushNotificationsDbSchemaPart");
    }

    private static PushNotificationsDbSchemaPart m9274d() {
        return new PushNotificationsDbSchemaPart();
    }

    @Inject
    PushNotificationsDbSchemaPart() {
        super("push_notifications", 2, ImmutableList.of(new PushNotificationsTable()));
    }
}
