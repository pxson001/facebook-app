package com.facebook.api.feedcache.resync;

import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.init.AppInitLock;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: menu_options */
public class NewsFeedCacheSyncPreRunChecker {
    private static volatile NewsFeedCacheSyncPreRunChecker f5435e;
    private final LoggedInUserSessionManager f5436a;
    private final AppStateManager f5437b;
    private final AppInitLock f5438c;
    private final QeAccessor f5439d;

    public static com.facebook.api.feedcache.resync.NewsFeedCacheSyncPreRunChecker m6659a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5435e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.feedcache.resync.NewsFeedCacheSyncPreRunChecker.class;
        monitor-enter(r1);
        r0 = f5435e;	 Catch:{ all -> 0x003a }
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
        r0 = m6660b(r0);	 Catch:{ all -> 0x0035 }
        f5435e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5435e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.resync.NewsFeedCacheSyncPreRunChecker.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.resync.NewsFeedCacheSyncPreRunChecker");
    }

    private static NewsFeedCacheSyncPreRunChecker m6660b(InjectorLike injectorLike) {
        return new NewsFeedCacheSyncPreRunChecker(LoggedInUserSessionManager.a(injectorLike), AppStateManager.a(injectorLike), AppInitLock.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NewsFeedCacheSyncPreRunChecker(LoggedInUserSessionManager loggedInUserSessionManager, AppStateManager appStateManager, AppInitLock appInitLock, QeAccessor qeAccessor) {
        this.f5436a = loggedInUserSessionManager;
        this.f5437b = appStateManager;
        this.f5438c = appInitLock;
        this.f5439d = qeAccessor;
    }

    public final boolean m6661b() {
        return this.f5438c.c() && this.f5437b.j();
    }

    public final boolean m6662c() {
        return (!this.f5436a.b() || this.f5436a.c().a == null || "0".equals(this.f5436a.c().a)) ? false : true;
    }
}
