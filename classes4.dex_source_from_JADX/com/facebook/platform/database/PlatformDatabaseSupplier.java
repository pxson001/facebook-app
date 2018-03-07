package com.facebook.platform.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.supplier.AbstractDatabaseSupplier;
import com.facebook.database.supplier.C0545xf11fd559;
import com.facebook.database.supplier.SharedSQLiteSchemaPart;
import com.facebook.database.threadchecker.DbThreadChecker;
import com.facebook.database.threadchecker.DbThreadCheckerDisallowUiThread;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: geopixel_ping_failed */
public class PlatformDatabaseSupplier extends AbstractDatabaseSupplier {
    private static volatile PlatformDatabaseSupplier f11257b;
    private boolean f11258a = false;

    public static com.facebook.platform.database.PlatformDatabaseSupplier m11676a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11257b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.platform.database.PlatformDatabaseSupplier.class;
        monitor-enter(r1);
        r0 = f11257b;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m11677b(r0);	 Catch:{ all -> 0x0035 }
        f11257b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11257b;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.platform.database.PlatformDatabaseSupplier.a(com.facebook.inject.InjectorLike):com.facebook.platform.database.PlatformDatabaseSupplier");
    }

    private static PlatformDatabaseSupplier m11677b(InjectorLike injectorLike) {
        return new PlatformDatabaseSupplier((Context) injectorLike.getInstance(Context.class), (DbThreadChecker) DbThreadCheckerDisallowUiThread.a(injectorLike), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new C0545xf11fd559(injectorLike)));
    }

    public /* synthetic */ Object get() {
        return a();
    }

    @Inject
    public PlatformDatabaseSupplier(Context context, DbThreadChecker dbThreadChecker, Set<SharedSQLiteSchemaPart> set) {
        super(context, dbThreadChecker, ImmutableList.copyOf(set), "platform_db");
    }

    public final synchronized SQLiteDatabase m11678a() {
        SQLiteDatabase a;
        a = super.a();
        if (!(a == null || this.f11258a)) {
            SQLiteDetour.a(1476584894);
            a.execSQL("PRAGMA foreign_keys = ON;");
            SQLiteDetour.a(-1839487271);
            this.f11258a = true;
        }
        return a;
    }
}
