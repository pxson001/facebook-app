package com.facebook.messaging.prefs.omnistore;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.omnistore.Collection;
import com.facebook.omnistore.Delta;
import com.facebook.omnistore.IndexedFields;
import com.facebook.omnistore.Omnistore;
import com.facebook.omnistore.module.OmnistoreComponent;
import com.facebook.omnistore.module.OmnistoreComponent$SubscriptionInfo;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: language_switcher_login */
public class MessengerUserPrefsOmnistoreComponent implements OmnistoreComponent {
    private static final Class<?> f9655a = MessengerUserPrefsOmnistoreComponent.class;
    private static volatile MessengerUserPrefsOmnistoreComponent f9656e;
    private final GatekeeperStoreImpl f9657b;
    private final Provider<String> f9658c;
    @Nullable
    public Collection f9659d;

    public static com.facebook.messaging.prefs.omnistore.MessengerUserPrefsOmnistoreComponent m10091a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f9656e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.prefs.omnistore.MessengerUserPrefsOmnistoreComponent.class;
        monitor-enter(r1);
        r0 = f9656e;	 Catch:{ all -> 0x003a }
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
        r0 = m10092b(r0);	 Catch:{ all -> 0x0035 }
        f9656e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9656e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.prefs.omnistore.MessengerUserPrefsOmnistoreComponent.a(com.facebook.inject.InjectorLike):com.facebook.messaging.prefs.omnistore.MessengerUserPrefsOmnistoreComponent");
    }

    private static MessengerUserPrefsOmnistoreComponent m10092b(InjectorLike injectorLike) {
        return new MessengerUserPrefsOmnistoreComponent(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4443));
    }

    @Inject
    public MessengerUserPrefsOmnistoreComponent(GatekeeperStore gatekeeperStore, Provider<String> provider) {
        this.f9657b = gatekeeperStore;
        this.f9658c = provider;
    }

    public OmnistoreComponent$SubscriptionInfo provideSubscriptionInfo(Omnistore omnistore) {
        if (this.f9657b.a(344, false)) {
            return OmnistoreComponent$SubscriptionInfo.forOpenSubscription(omnistore.createCollectionNameBuilder("messenger_user_prefs").addSegment((String) this.f9658c.get()).build());
        }
        return OmnistoreComponent$SubscriptionInfo.IGNORED_INFO;
    }

    public void onCollectionAvailable(Collection collection) {
        this.f9659d = collection;
    }

    public void onDeltasReceived(List<Delta> list) {
        Integer.valueOf(list.size());
    }

    public IndexedFields indexObject(String str, String str2, ByteBuffer byteBuffer) {
        return new IndexedFields();
    }

    public void onCollectionInvalidated() {
        this.f9659d = null;
    }
}
