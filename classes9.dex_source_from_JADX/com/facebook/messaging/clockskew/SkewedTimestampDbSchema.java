package com.facebook.messaging.clockskew;

import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlKeys.PrimaryKey;
import com.facebook.database.sqlite.SqlKeys.SqlKey;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: messenger_pay_entity_id */
public class SkewedTimestampDbSchema extends TablesDbSchemaPart {
    private static volatile SkewedTimestampDbSchema f9775a;

    /* compiled from: messenger_pay_entity_id */
    public final class TimeSkewTable extends SqlTable {
        public static final SqlKey f9773a = new PrimaryKey(ImmutableList.of(Columns.f9770a));
        private static final ImmutableList<SqlColumn> f9774b = ImmutableList.of(Columns.f9770a, Columns.f9771b, Columns.f9772c);

        /* compiled from: messenger_pay_entity_id */
        public class Columns {
            public static final SqlColumn f9770a = new SqlColumn("thread_key", "INTEGER");
            public static final SqlColumn f9771b = new SqlColumn("skewed_timestamp", "INTEGER");
            public static final SqlColumn f9772c = new SqlColumn("raw_timestamp", "INTEGER");
        }

        TimeSkewTable() {
            super("time_skew", f9774b, f9773a);
        }
    }

    public static com.facebook.messaging.clockskew.SkewedTimestampDbSchema m10340a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9775a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messaging.clockskew.SkewedTimestampDbSchema.class;
        monitor-enter(r1);
        r0 = f9775a;	 Catch:{ all -> 0x0039 }
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
        r0 = m10341d();	 Catch:{ all -> 0x0034 }
        f9775a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f9775a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.clockskew.SkewedTimestampDbSchema.a(com.facebook.inject.InjectorLike):com.facebook.messaging.clockskew.SkewedTimestampDbSchema");
    }

    private static SkewedTimestampDbSchema m10341d() {
        return new SkewedTimestampDbSchema();
    }

    @Inject
    public SkewedTimestampDbSchema() {
        super("time_skew", 1, ImmutableList.of(new TimeSkewTable()));
    }
}
