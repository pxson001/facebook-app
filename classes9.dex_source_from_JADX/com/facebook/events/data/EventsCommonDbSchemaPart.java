package com.facebook.events.data;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.facebook.events.data.EventsCommonContract.EventsCommonTable.Columns;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: Text-string is null. */
public class EventsCommonDbSchemaPart extends TablesDbSchemaPart {
    private static volatile EventsCommonDbSchemaPart f24309a;

    /* compiled from: Text-string is null. */
    public final class EventsCommonTableImpl extends SqlTable {
        private static final ImmutableList<SqlColumn> f24308a = ImmutableList.of(Columns.f24273a, Columns.f24274b, Columns.f24275c, Columns.f24276d, Columns.f24277e, Columns.f24278f, Columns.f24279g, Columns.f24280h, Columns.f24281i, Columns.f24282j, Columns.f24283k, Columns.f24284l, new SqlColumn[]{Columns.f24285m, Columns.f24286n, Columns.f24287o, Columns.f24288p, Columns.f24289q, Columns.f24290r, Columns.f24291s, Columns.f24292t, Columns.f24293u, Columns.f24294v, Columns.f24295w, Columns.f24296x, Columns.f24297y, Columns.f24298z, Columns.f24247A, Columns.f24248B, Columns.f24249C, Columns.f24250D, Columns.f24251E, Columns.f24252F, Columns.f24253G, Columns.f24254H, Columns.f24255I, Columns.f24256J, Columns.f24257K, Columns.f24258L, Columns.f24259M, Columns.f24260N, Columns.f24261O, Columns.f24262P, Columns.f24263Q, Columns.f24264R, Columns.f24265S, Columns.f24266T, Columns.f24267U, Columns.f24268V, Columns.f24269W, Columns.f24270X, Columns.f24271Y, Columns.f24272Z, Columns.aa, Columns.ab, Columns.ac, Columns.ad, Columns.ae, Columns.af, Columns.ag, Columns.ah, Columns.ai, Columns.aj});

        EventsCommonTableImpl() {
            super("events", f24308a);
        }
    }

    public static com.facebook.events.data.EventsCommonDbSchemaPart m26204a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f24309a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.events.data.EventsCommonDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f24309a;	 Catch:{ all -> 0x0039 }
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
        r0 = m26205d();	 Catch:{ all -> 0x0034 }
        f24309a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f24309a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.data.EventsCommonDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.events.data.EventsCommonDbSchemaPart");
    }

    private static EventsCommonDbSchemaPart m26205d() {
        return new EventsCommonDbSchemaPart();
    }

    @Inject
    public EventsCommonDbSchemaPart() {
        super("events_common_part", 30, ImmutableList.of(new EventsCommonTableImpl()));
    }

    protected final void m26206a(SQLiteDatabase sQLiteDatabase) {
        super.a(sQLiteDatabase);
        String a = StringFormatUtil.a("CREATE INDEX IF NOT EXISTS events_start_time_idx ON %s(%s)", new Object[]{"events", Columns.f24254H.d});
        SQLiteDetour.a(-1120723495);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(780558820);
        a = StringFormatUtil.a("CREATE INDEX IF NOT EXISTS events_by_fbid_idx ON %s(%s)", new Object[]{"events", Columns.f24274b.d});
        SQLiteDetour.a(13113845);
        sQLiteDatabase.execSQL(a);
        SQLiteDetour.a(827434134);
    }
}
