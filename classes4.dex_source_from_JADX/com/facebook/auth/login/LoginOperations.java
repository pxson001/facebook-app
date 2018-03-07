package com.facebook.auth.login;

import com.facebook.auth.component.LoginComponent;
import com.facebook.auth.component.STATICDI_MULTIBIND_PROVIDER$LoginComponent;
import com.facebook.auth.component.persistent.PersistentComponent;
import com.facebook.auth.component.persistent.STATICDI_MULTIBIND_PROVIDER$PersistentComponent;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.http.protocol.BatchComponentRunner;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: t%d.contact_internal_id) */
public class LoginOperations {
    private static volatile LoginOperations f1371e;
    public final LoggedInUserSessionManager f1372a;
    public final BatchComponentRunner f1373b;
    public final Set<LoginComponent> f1374c;
    public final Set<PersistentComponent> f1375d;

    public static com.facebook.auth.login.LoginOperations m1613a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1371e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.auth.login.LoginOperations.class;
        monitor-enter(r1);
        r0 = f1371e;	 Catch:{ all -> 0x003a }
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
        r0 = m1614b(r0);	 Catch:{ all -> 0x0035 }
        f1371e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1371e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.auth.login.LoginOperations.a(com.facebook.inject.InjectorLike):com.facebook.auth.login.LoginOperations");
    }

    private static LoginOperations m1614b(InjectorLike injectorLike) {
        return new LoginOperations(LoggedInUserSessionManager.a(injectorLike), BatchComponentRunner.m1565a(injectorLike), STATICDI_MULTIBIND_PROVIDER$LoginComponent.m1561a(injectorLike), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$PersistentComponent(injectorLike)));
    }

    @Inject
    public LoginOperations(LoggedInUserAuthDataStore loggedInUserAuthDataStore, BatchComponentRunner batchComponentRunner, Set<LoginComponent> set, Set<PersistentComponent> set2) {
        this.f1372a = loggedInUserAuthDataStore;
        this.f1373b = batchComponentRunner;
        this.f1374c = set;
        this.f1375d = set2;
    }
}
