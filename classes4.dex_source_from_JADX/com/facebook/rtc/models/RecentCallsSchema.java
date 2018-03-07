package com.facebook.rtc.models;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: email */
public class RecentCallsSchema extends TablesDbSchemaPart {
    private static final Class<?> f13201a = RecentCallsSchema.class;
    private static volatile RecentCallsSchema f13202b;

    /* compiled from: email */
    public final class PersonSummaryTable extends SqlTable {
        private static final ImmutableList<SqlColumn> f13203a = ImmutableList.of(Columns.f13204a, Columns.f13205b, Columns.f13206c, Columns.f13207d, Columns.f13208e, Columns.f13209f, Columns.f13210g, Columns.f13211h, Columns.f13212i, Columns.f13213j, Columns.f13214k);

        /* compiled from: email */
        public class Columns {
            public static final SqlColumn f13204a = new SqlColumn("user_id", "INTEGER");
            public static final SqlColumn f13205b = new SqlColumn("last_call_time", "INTEGER NOT NULL");
            public static final SqlColumn f13206c = new SqlColumn("log_id", "INTEGER PRIMARY KEY AUTOINCREMENT");
            public static final SqlColumn f13207d = new SqlColumn("duration", "INTEGER");
            public static final SqlColumn f13208e = new SqlColumn("answered", "INTEGER");
            public static final SqlColumn f13209f = new SqlColumn("direction", "INTEGER");
            public static final SqlColumn f13210g = new SqlColumn("call_type", "INTEGER");
            public static final SqlColumn f13211h = new SqlColumn("acknowledged", "INTEGER");
            public static final SqlColumn f13212i = new SqlColumn("seen", "INTEGER");
            public static final SqlColumn f13213j = new SqlColumn("thread_id", "INTEGER");
            public static final SqlColumn f13214k = new SqlColumn("on_going", "INTEGER");
        }

        PersonSummaryTable() {
            super("person_summary", f13203a);
        }
    }

    public static com.facebook.rtc.models.RecentCallsSchema m14071a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13202b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.rtc.models.RecentCallsSchema.class;
        monitor-enter(r1);
        r0 = f13202b;	 Catch:{ all -> 0x0039 }
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
        r0 = m14072d();	 Catch:{ all -> 0x0034 }
        f13202b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f13202b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.models.RecentCallsSchema.a(com.facebook.inject.InjectorLike):com.facebook.rtc.models.RecentCallsSchema");
    }

    private static RecentCallsSchema m14072d() {
        return new RecentCallsSchema();
    }

    protected final void m14073a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Integer.valueOf(i);
        Integer.valueOf(i2);
        while (i < i2) {
            int i3 = 4;
            int i4 = i + 1;
            if (i != 4) {
                StringBuilder stringBuilder;
                String stringBuilder2;
                if (i == 3) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("ALTER TABLE ");
                    stringBuilder.append("person_summary");
                    stringBuilder.append(" ADD COLUMN ");
                    stringBuilder.append(Columns.f13214k.d);
                    stringBuilder.append(" ");
                    stringBuilder.append(Columns.f13214k.e);
                    stringBuilder2 = stringBuilder.toString();
                    SQLiteDetour.a(-544542558);
                    sQLiteDatabase.execSQL(stringBuilder2);
                    SQLiteDetour.a(427360307);
                    i3 = i4;
                } else if (i == 2) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("ALTER TABLE ");
                    stringBuilder.append("person_summary");
                    stringBuilder.append(" ADD COLUMN ");
                    stringBuilder.append(Columns.f13213j.d);
                    stringBuilder.append(" ");
                    stringBuilder.append(Columns.f13213j.e);
                    stringBuilder2 = stringBuilder.toString();
                    SQLiteDetour.a(-450315695);
                    sQLiteDatabase.execSQL(stringBuilder2);
                    SQLiteDetour.a(-1803849040);
                    i3 = i4;
                } else {
                    String a = SqlTable.a("person_summary");
                    SQLiteDetour.a(-1557231883);
                    sQLiteDatabase.execSQL(a);
                    SQLiteDetour.a(-933202942);
                    a(sQLiteDatabase);
                    i3 = i4;
                }
            }
            i = i3;
        }
    }

    public final void m14074b(SQLiteDatabase sQLiteDatabase) {
    }

    @Inject
    RecentCallsSchema() {
        super("call_summary", 4, ImmutableList.of(new PersonSummaryTable()));
    }
}
