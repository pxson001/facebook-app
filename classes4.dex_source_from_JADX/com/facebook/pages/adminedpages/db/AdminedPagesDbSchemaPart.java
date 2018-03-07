package com.facebook.pages.adminedpages.db;

import com.facebook.database.sqlite.SqlColumn;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.database.supplier.TablesDbSchemaPart;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: error in temp file manager */
public class AdminedPagesDbSchemaPart extends TablesDbSchemaPart {
    private static volatile AdminedPagesDbSchemaPart f12833a;

    /* compiled from: error in temp file manager */
    public final class AdminedPagesTable extends SqlTable {
        @VisibleForTesting
        public static final ImmutableList<SqlColumn> f12834a = ImmutableList.of(Columns.f12824a, Columns.f12825b, Columns.f12826c, Columns.f12827d, Columns.f12828e, Columns.f12829f, Columns.f12830g);

        /* compiled from: error in temp file manager */
        public class Columns {
            public static final SqlColumn f12824a = new SqlColumn("page_id", "TEXT PRIMARY KEY");
            public static final SqlColumn f12825b = new SqlColumn("page_name", "TEXT");
            public static final SqlColumn f12826c = new SqlColumn("profile_pic_url", "TEXT");
            public static final SqlColumn f12827d = new SqlColumn("cover_photo_url", "TEXT");
            public static final SqlColumn f12828e = new SqlColumn("viewer_profile_permissions", "TEXT");
            public static final SqlColumn f12829f = new SqlColumn("can_viewer_promote", "TEXT");
            public static final SqlColumn f12830g = new SqlColumn("access_token", "TEXT");
        }

        AdminedPagesTable() {
            super("admined_pages_table", f12834a);
        }
    }

    public static com.facebook.pages.adminedpages.db.AdminedPagesDbSchemaPart m13667a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12833a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.pages.adminedpages.db.AdminedPagesDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f12833a;	 Catch:{ all -> 0x0039 }
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
        r0 = m13668d();	 Catch:{ all -> 0x0034 }
        f12833a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f12833a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.adminedpages.db.AdminedPagesDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.pages.adminedpages.db.AdminedPagesDbSchemaPart");
    }

    private static AdminedPagesDbSchemaPart m13668d() {
        return new AdminedPagesDbSchemaPart();
    }

    @Inject
    public AdminedPagesDbSchemaPart() {
        super("admined_pages_part", 1, ImmutableList.of(new AdminedPagesTable()));
    }
}
