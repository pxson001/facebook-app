package com.facebook.katana.urimap;

import com.facebook.gk.init.INeedInitForGatekeepersListenerRegistration;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: token_fetch_failed */
public class C0168x226977e2 extends INeedInitForGatekeepersListenerRegistration<LinkSharingNativeComposerPrefsWatcher> {
    private static volatile C0168x226977e2 f2432b;

    public static com.facebook.katana.urimap.C0168x226977e2 m4630a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2432b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.urimap.C0168x226977e2.class;
        monitor-enter(r1);
        r0 = f2432b;	 Catch:{ all -> 0x003a }
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
        r0 = com.facebook.katana.urimap.C0168x226977e2.m4631b(r0);	 Catch:{ all -> 0x0035 }
        f2432b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2432b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.urimap.LinkSharingNativeComposerPrefsWatcher$MasterSwitchListenerRegistration.a(com.facebook.inject.InjectorLike):com.facebook.katana.urimap.LinkSharingNativeComposerPrefsWatcher$MasterSwitchListenerRegistration");
    }

    private static C0168x226977e2 m4631b(InjectorLike injectorLike) {
        return new C0168x226977e2(IdBasedSingletonScopeProvider.m1810b(injectorLike, 2438));
    }

    protected final void mo659a(GatekeeperStoreImpl gatekeeperStoreImpl, int i, Object obj) {
        LinkSharingNativeComposerPrefsWatcher.a((LinkSharingNativeComposerPrefsWatcher) obj);
    }

    @Inject
    public C0168x226977e2(Lazy<LinkSharingNativeComposerPrefsWatcher> lazy) {
        super((Lazy) lazy, 626);
    }
}
