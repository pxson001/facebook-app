package com.facebook.offlinemode.db;

import android.content.Context;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.database.advancedsupplier.AdvancedAbstractDatabaseSupplier;
import com.facebook.database.threadchecker.DbThreadChecker;
import com.facebook.database.threadchecker.DbThreadCheckerDisallowUiThread;
import com.facebook.database.userchecker.DbUserChecker;
import com.facebook.database.userchecker.DbUserCheckerDefault;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: network_response_initial_scan */
public class OfflineModeDatabaseSupplier extends AdvancedAbstractDatabaseSupplier implements IHaveUserData {
    private static volatile OfflineModeDatabaseSupplier f12436a;

    public static com.facebook.offlinemode.db.OfflineModeDatabaseSupplier m18506a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12436a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.offlinemode.db.OfflineModeDatabaseSupplier.class;
        monitor-enter(r1);
        r0 = f12436a;	 Catch:{ all -> 0x003a }
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
        r0 = m18507b(r0);	 Catch:{ all -> 0x0035 }
        f12436a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12436a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offlinemode.db.OfflineModeDatabaseSupplier.a(com.facebook.inject.InjectorLike):com.facebook.offlinemode.db.OfflineModeDatabaseSupplier");
    }

    private static OfflineModeDatabaseSupplier m18507b(InjectorLike injectorLike) {
        return new OfflineModeDatabaseSupplier((Context) injectorLike.getInstance(Context.class), DbThreadCheckerDisallowUiThread.m2032a(injectorLike), DbUserCheckerDefault.m18514a(injectorLike), OfflineModeDbSchemaPart.m18524a(injectorLike));
    }

    @Inject
    protected OfflineModeDatabaseSupplier(Context context, DbThreadChecker dbThreadChecker, DbUserChecker dbUserChecker, OfflineModeDbSchemaPart offlineModeDbSchemaPart) {
        super(context, dbThreadChecker, dbUserChecker, ImmutableList.of(offlineModeDbSchemaPart), "offline_mode_db");
    }

    protected final int mo1451c() {
        return 204800;
    }

    public void clearUserData() {
        mo2481e();
    }
}
