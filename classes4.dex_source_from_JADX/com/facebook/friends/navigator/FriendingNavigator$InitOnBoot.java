package com.facebook.friends.navigator;

import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.init.INeedInit;
import com.facebook.content.event.FbEventSubscriber;
import com.facebook.friends.navigator.FriendingNavigator.FriendableContactsChangedSubscriber;
import com.facebook.friends.navigator.FriendingNavigator.FriendableContactsFetchedSubscriber;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: manifest/ */
public class FriendingNavigator$InitOnBoot implements INeedInit {
    private static volatile FriendingNavigator$InitOnBoot f8363f;
    private final GatekeeperStoreImpl f8364a;
    private final DefaultAndroidThreadUtil f8365b;
    private final NavigationEventBus f8366c;
    private final Lazy<FriendableContactsFetchedSubscriber> f8367d;
    private final Lazy<FriendableContactsChangedSubscriber> f8368e;

    public static com.facebook.friends.navigator.FriendingNavigator$InitOnBoot m8652a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8363f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friends.navigator.FriendingNavigator$InitOnBoot.class;
        monitor-enter(r1);
        r0 = f8363f;	 Catch:{ all -> 0x003a }
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
        r0 = m8653b(r0);	 Catch:{ all -> 0x0035 }
        f8363f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8363f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friends.navigator.FriendingNavigator$InitOnBoot.a(com.facebook.inject.InjectorLike):com.facebook.friends.navigator.FriendingNavigator$InitOnBoot");
    }

    private static FriendingNavigator$InitOnBoot m8653b(InjectorLike injectorLike) {
        return new FriendingNavigator$InitOnBoot(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), NavigationEventBus.m8655a(injectorLike), IdBasedLazy.a(injectorLike, 6690), IdBasedLazy.a(injectorLike, 6691));
    }

    @Inject
    public FriendingNavigator$InitOnBoot(GatekeeperStore gatekeeperStore, AndroidThreadUtil androidThreadUtil, NavigationEventBus navigationEventBus, Lazy<FriendableContactsChangedSubscriber> lazy, Lazy<FriendableContactsFetchedSubscriber> lazy2) {
        this.f8364a = gatekeeperStore;
        this.f8365b = androidThreadUtil;
        this.f8366c = navigationEventBus;
        this.f8367d = lazy2;
        this.f8368e = lazy;
    }

    public void init() {
        this.f8365b.b();
        if (this.f8364a.a(639, false)) {
            this.f8366c.a((FbEventSubscriber) this.f8367d.get());
            this.f8366c.a((FbEventSubscriber) this.f8368e.get());
        }
    }
}
