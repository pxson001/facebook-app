package com.facebook.abtest.qe.db;

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
/* compiled from: thumb_url */
public class QuickExperimentDbSchemaPart extends TablesDbSchemaPart {
    private static volatile QuickExperimentDbSchemaPart f1090a;

    /* compiled from: thumb_url */
    public class ExperimentsDbTable extends SqlTable {
        private static final SqlKey f1091a = new PrimaryKey(ImmutableList.of(QuickExperimentContract$ExperimentsTable$Columns.f1080a, QuickExperimentContract$ExperimentsTable$Columns.f1081b, QuickExperimentContract$ExperimentsTable$Columns.f1088i));
        private static final ImmutableList<SqlColumn> f1092b = ImmutableList.of(QuickExperimentContract$ExperimentsTable$Columns.f1080a, QuickExperimentContract$ExperimentsTable$Columns.f1081b, QuickExperimentContract$ExperimentsTable$Columns.f1082c, QuickExperimentContract$ExperimentsTable$Columns.f1083d, QuickExperimentContract$ExperimentsTable$Columns.f1084e, QuickExperimentContract$ExperimentsTable$Columns.f1085f, QuickExperimentContract$ExperimentsTable$Columns.f1086g, QuickExperimentContract$ExperimentsTable$Columns.f1087h, QuickExperimentContract$ExperimentsTable$Columns.f1088i);
        private static final ImmutableList<SqlKey> f1093c = ImmutableList.of(f1091a);

        ExperimentsDbTable() {
            super("experiments", f1092b, f1093c);
        }

        public final void m1378a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i != 10 && i != 15) {
                super.a(sQLiteDatabase, i, i2);
            }
        }
    }

    /* compiled from: thumb_url */
    public class ExperimentsDbMetaInfoTable extends SqlTable {
        private static final SqlKey f1094a = new PrimaryKey(ImmutableList.of(QuickExperimentContract$ExperimentsMetaInfoTable$Columns.f1097a));
        private static final ImmutableList<SqlColumn> f1095b = ImmutableList.of(QuickExperimentContract$ExperimentsMetaInfoTable$Columns.f1097a, QuickExperimentContract$ExperimentsMetaInfoTable$Columns.f1098b);
        private static final ImmutableList<SqlKey> f1096c = ImmutableList.of(f1094a);

        ExperimentsDbMetaInfoTable() {
            super("metainfo", f1095b, f1096c);
        }

        public final void m1379a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i == 15) {
                String str = "DELETE FROM " + this.a;
                SQLiteDetour.a(-1456719223);
                sQLiteDatabase.execSQL(str);
                SQLiteDetour.a(-53089262);
                str = "INSERT INTO " + this.a + " SELECT * FROM metainfo_tmp";
                SQLiteDetour.a(1580730490);
                sQLiteDatabase.execSQL(str);
                SQLiteDetour.a(-155191233);
                SQLiteDetour.a(-461115976);
                sQLiteDatabase.execSQL("DROP TABLE metainfo_tmp");
                SQLiteDetour.a(1574915372);
                return;
            }
            super.a(sQLiteDatabase, i, i2);
        }
    }

    public static com.facebook.abtest.qe.db.QuickExperimentDbSchemaPart m1376a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1090a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.abtest.qe.db.QuickExperimentDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f1090a;	 Catch:{ all -> 0x0039 }
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
        r0 = m1377d();	 Catch:{ all -> 0x0034 }
        f1090a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f1090a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.abtest.qe.db.QuickExperimentDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.abtest.qe.db.QuickExperimentDbSchemaPart");
    }

    private static QuickExperimentDbSchemaPart m1377d() {
        return new QuickExperimentDbSchemaPart();
    }

    @Inject
    public QuickExperimentDbSchemaPart() {
        super("quick_experiment", 20, ImmutableList.of(new ExperimentsDbTable(), new ExperimentsDbMetaInfoTable()));
    }
}
