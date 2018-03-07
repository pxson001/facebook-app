package com.facebook.transliteration.database;

import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: exp_mqtt_sid */
public class DictionarySchema extends TablesDbSchemaPart {
    private static volatile DictionarySchema f15165a;

    /* compiled from: exp_mqtt_sid */
    public final class DictionaryTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f15164a = ImmutableList.of(Columns.f15160a, Columns.f15161b, Columns.f15162c, Columns.f15163d);

        /* compiled from: exp_mqtt_sid */
        public class Columns {
            public static final SqlColumn f15160a = new SqlColumn("id", "INTEGER PRIMARY KEY AUTOINCREMENT");
            public static final SqlColumn f15161b = new SqlColumn("locale", "INTEGER");
            public static final SqlColumn f15162c = new SqlColumn("source", "TEXT");
            public static final SqlColumn f15163d = new SqlColumn("target", "TEXT");
        }

        DictionaryTable() {
            super("dictionary_table", f15164a);
        }
    }

    public static com.facebook.transliteration.database.DictionarySchema m19158a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15165a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.transliteration.database.DictionarySchema.class;
        monitor-enter(r1);
        r0 = f15165a;	 Catch:{ all -> 0x0039 }
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
        r0 = m19159d();	 Catch:{ all -> 0x0034 }
        f15165a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f15165a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.transliteration.database.DictionarySchema.a(com.facebook.inject.InjectorLike):com.facebook.transliteration.database.DictionarySchema");
    }

    private static DictionarySchema m19159d() {
        return new DictionarySchema();
    }

    @Inject
    DictionarySchema() {
        super("dictionary", 1, ImmutableList.of(new DictionaryTable()));
    }
}
