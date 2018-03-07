package com.facebook.friendsharing.souvenirs.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: montage_thread_fbid */
public class SouvenirsDbSchemaPart extends TablesDbSchemaPart {
    private static volatile SouvenirsDbSchemaPart f13330a;

    /* compiled from: montage_thread_fbid */
    public final class ModelsTable extends SqlTable {

        /* compiled from: montage_thread_fbid */
        public class Columns {
            public static final SqlColumn f13331a = new SqlColumn("id", "STRING PRIMARY KEY");
            public static final SqlColumn f13332b = new SqlColumn("start_date", "LONG");
            public static final SqlColumn f13333c = new SqlColumn("blob", "TEXT");
        }

        public ModelsTable() {
            super("models", ImmutableList.of(Columns.f13331a, Columns.f13332b, Columns.f13333c));
        }
    }

    /* compiled from: montage_thread_fbid */
    public final class UploadedModelsTable extends SqlTable {

        /* compiled from: montage_thread_fbid */
        public class Columns {
            public static final SqlColumn f13334a = new SqlColumn("id", "STRING PRIMARY KEY");
            public static final SqlColumn f13335b = new SqlColumn("uploaded_date", "LONG");
        }

        public UploadedModelsTable() {
            super("uploaded_models", ImmutableList.of(Columns.f13334a, Columns.f13335b));
        }
    }

    /* compiled from: montage_thread_fbid */
    public final class PromptsTable extends SqlTable {

        /* compiled from: montage_thread_fbid */
        public class Columns {
            public static final SqlColumn f13336a = new SqlColumn("id", "STRING PRIMARY KEY");
            public static final SqlColumn f13337b = new SqlColumn("show_date", "LONG");
        }

        public PromptsTable() {
            super("prompted_models", ImmutableList.of(Columns.f13336a, Columns.f13337b));
        }
    }

    public static com.facebook.friendsharing.souvenirs.persistence.SouvenirsDbSchemaPart m19637a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13330a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.friendsharing.souvenirs.persistence.SouvenirsDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f13330a;	 Catch:{ all -> 0x0039 }
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
        r0 = m19638d();	 Catch:{ all -> 0x0034 }
        f13330a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f13330a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friendsharing.souvenirs.persistence.SouvenirsDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.friendsharing.souvenirs.persistence.SouvenirsDbSchemaPart");
    }

    private static SouvenirsDbSchemaPart m19638d() {
        return new SouvenirsDbSchemaPart();
    }

    @Inject
    public SouvenirsDbSchemaPart() {
        super("souvenirs_part_1", 3, ImmutableList.of(new ModelsTable(), new UploadedModelsTable(), new PromptsTable()));
    }

    protected final void mo319a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if ((i == 1 || i == 2) && i2 == 3) {
            SqlTable sqlTable = (SqlTable) this.f1010a.get(2);
            Preconditions.checkState(sqlTable instanceof PromptsTable);
            sqlTable.mo1454a(sQLiteDatabase, i, i2);
            return;
        }
        super.mo319a(sQLiteDatabase, i, i2);
    }
}
