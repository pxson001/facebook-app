package com.facebook.messaging.contacts.loader;

import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.search.BusinessSearchGatekeeperUtil;
import com.facebook.messaging.contacts.loader.ContactsLoader.FriendLists;
import com.facebook.messaging.contacts.loader.ContactsLoader.InitParams;
import java.util.EnumSet;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: fa_isc_max_bw_oh */
public class ContactsLoaderFactory {
    private static volatile ContactsLoaderFactory f12400g;
    public final BusinessSearchGatekeeperUtil f12401a;
    public final Provider<ContactsLoader> f12402b;
    public final Provider<Boolean> f12403c;
    private final Provider<Boolean> f12404d;
    public final boolean f12405e;
    private final GatekeeperStoreImpl f12406f;

    public static com.facebook.messaging.contacts.loader.ContactsLoaderFactory m13105a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12400g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.contacts.loader.ContactsLoaderFactory.class;
        monitor-enter(r1);
        r0 = f12400g;	 Catch:{ all -> 0x003a }
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
        r0 = m13106b(r0);	 Catch:{ all -> 0x0035 }
        f12400g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12400g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.contacts.loader.ContactsLoaderFactory.a(com.facebook.inject.InjectorLike):com.facebook.messaging.contacts.loader.ContactsLoaderFactory");
    }

    private static ContactsLoaderFactory m13106b(InjectorLike injectorLike) {
        return new ContactsLoaderFactory(BusinessSearchGatekeeperUtil.m13108b(injectorLike), IdBasedProvider.a(injectorLike, 2592), IdBasedProvider.a(injectorLike, 3900), IdBasedProvider.a(injectorLike, 3902), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ContactsLoaderFactory(BusinessSearchGatekeeperUtil businessSearchGatekeeperUtil, Provider<ContactsLoader> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, Boolean bool, GatekeeperStore gatekeeperStore) {
        this.f12401a = businessSearchGatekeeperUtil;
        this.f12402b = provider;
        this.f12403c = provider2;
        this.f12404d = provider3;
        this.f12405e = bool.booleanValue();
        this.f12406f = gatekeeperStore;
    }

    public final ContactsLoader m13107a() {
        ContactsLoader contactsLoader = (ContactsLoader) this.f12402b.get();
        contactsLoader.f13131v = new InitParams(EnumSet.of(FriendLists.FAVORITE_FRIENDS, FriendLists.TOP_FRIENDS_ON_MESSENGER, FriendLists.ONLINE_FRIENDS));
        return contactsLoader;
    }
}
