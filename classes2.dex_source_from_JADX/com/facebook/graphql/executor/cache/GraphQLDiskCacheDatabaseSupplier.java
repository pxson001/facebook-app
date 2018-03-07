package com.facebook.graphql.executor.cache;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.os.Build.VERSION;
import com.facebook.common.file.StatFsHelperMethodAutoProvider;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.database.supplier.AOSP_API16_DefaultDatabaseErrorHandler;
import com.facebook.database.supplier.AbstractDatabaseSupplier;
import com.facebook.database.threadchecker.DbThreadChecker;
import com.facebook.database.threadchecker.DbThreadChecker_AllowAnyThreadMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: saved_item_pic_height */
public class GraphQLDiskCacheDatabaseSupplier extends AbstractDatabaseSupplier {
    private static volatile GraphQLDiskCacheDatabaseSupplier f6125b;
    private final StatFsHelper f6126a;

    public static com.facebook.graphql.executor.cache.GraphQLDiskCacheDatabaseSupplier m10310a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f6125b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.graphql.executor.cache.GraphQLDiskCacheDatabaseSupplier.class;
        monitor-enter(r1);
        r0 = f6125b;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m10311b(r0);	 Catch:{ all -> 0x0035 }
        f6125b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6125b;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.executor.cache.GraphQLDiskCacheDatabaseSupplier.a(com.facebook.inject.InjectorLike):com.facebook.graphql.executor.cache.GraphQLDiskCacheDatabaseSupplier");
    }

    private static GraphQLDiskCacheDatabaseSupplier m10311b(InjectorLike injectorLike) {
        return new GraphQLDiskCacheDatabaseSupplier((Context) injectorLike.getInstance(Context.class), DbThreadChecker_AllowAnyThreadMethodAutoProvider.m10315a(injectorLike), GraphQLDBSchemaPart.m10318a(injectorLike), StatFsHelperMethodAutoProvider.m2307a(injectorLike), "graphql_cache");
    }

    @Inject
    public GraphQLDiskCacheDatabaseSupplier(Context context, DbThreadChecker dbThreadChecker, GraphQLDBSchemaPart graphQLDBSchemaPart, StatFsHelper statFsHelper, String str) {
        super(context, dbThreadChecker, ImmutableList.of(graphQLDBSchemaPart), str);
        this.f6126a = statFsHelper;
    }

    public final long mo1450b() {
        return m10309a(5242880, (this.f6126a.m2314a(StorageType.INTERNAL) * 2) / 100, 26214400);
    }

    protected final int mo1451c() {
        return 25600;
    }

    private static long m10309a(long j, long j2, long j3) {
        return Math.max(j, Math.min(j2, j3));
    }

    protected final DatabaseErrorHandler mo1452j() {
        if (VERSION.SDK_INT == 16) {
            return new AOSP_API16_DefaultDatabaseErrorHandler();
        }
        return super.mo1452j();
    }
}
