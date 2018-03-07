package com.facebook.backgroundtasks;

import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.inject.InjectorLike;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: errors */
public class BackgroundTaskPrerequisiteChecker {
    private static final Class<?> f12791a = BackgroundTaskPrerequisiteChecker.class;
    private static volatile BackgroundTaskPrerequisiteChecker f12792e;
    private final LoggedInUserSessionManager f12793b;
    private final FbNetworkManager f12794c;
    private final AppStateManager f12795d;

    public static com.facebook.backgroundtasks.BackgroundTaskPrerequisiteChecker m13647a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12792e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backgroundtasks.BackgroundTaskPrerequisiteChecker.class;
        monitor-enter(r1);
        r0 = f12792e;	 Catch:{ all -> 0x003a }
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
        r0 = m13649b(r0);	 Catch:{ all -> 0x0035 }
        f12792e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12792e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backgroundtasks.BackgroundTaskPrerequisiteChecker.a(com.facebook.inject.InjectorLike):com.facebook.backgroundtasks.BackgroundTaskPrerequisiteChecker");
    }

    private static BackgroundTaskPrerequisiteChecker m13649b(InjectorLike injectorLike) {
        return new BackgroundTaskPrerequisiteChecker(LoggedInUserSessionManager.a(injectorLike), FbNetworkManager.a(injectorLike), AppStateManager.a(injectorLike));
    }

    @Inject
    public BackgroundTaskPrerequisiteChecker(LoggedInUserSessionManager loggedInUserSessionManager, FbNetworkManager fbNetworkManager, AppStateManager appStateManager) {
        this.f12793b = loggedInUserSessionManager;
        this.f12794c = fbNetworkManager;
        this.f12795d = appStateManager;
    }

    public final boolean m13650a(BackgroundTask backgroundTask) {
        Set<Prerequisite> h = backgroundTask.mo594h();
        if (h.isEmpty()) {
            return true;
        }
        for (Prerequisite a : h) {
            if (!m13648a(a)) {
                return false;
            }
        }
        return true;
    }

    private boolean m13648a(Prerequisite prerequisite) {
        switch (prerequisite) {
            case USER_LOGGED_IN:
                return this.f12793b.b() && !this.f12793b.d();
            case NETWORK_CONNECTIVITY:
                return this.f12794c.d();
            case USER_LOGGED_IN_ALLOWING_LOGGING_OUT:
                return this.f12793b.b();
            case USER_IN_APP:
                return this.f12795d.l();
            default:
                throw new IllegalArgumentException("Unknown prerequisite: " + prerequisite);
        }
    }
}
