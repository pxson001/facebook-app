package com.facebook.messaging.tincan.inbound;

import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.tincan.TincanDebugErrorReporter;
import com.facebook.messaging.tincan.gatekeepers.TincanGatekeepers;
import com.facebook.messaging.tincan.messenger.TincanIncomingDispatcher;
import com.facebook.messaging.tincan.omnistore.TincanMessage;
import com.facebook.messaging.tincan.omnistore.TincanOmnistoreRefresherByGatekeeper;
import com.facebook.omnistore.Collection;
import com.facebook.omnistore.Delta;
import com.facebook.omnistore.Delta.Type;
import com.facebook.omnistore.IndexedFields;
import com.facebook.omnistore.Omnistore;
import com.facebook.omnistore.module.OmnistoreComponent;
import com.facebook.omnistore.module.OmnistoreComponent$SubscriptionInfo;
import java.nio.ByteBuffer;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: landscape */
public class ConnectionReceiver implements OmnistoreComponent {
    private static final Class<?> f9661a = ConnectionReceiver.class;
    private static volatile ConnectionReceiver f9662h;
    private final Provider<String> f9663b;
    private final Provider<InboundConnectionQueue> f9664c;
    private final TincanGatekeepers f9665d;
    private final TincanDebugErrorReporter f9666e;
    private final TincanOmnistoreRefresherByGatekeeper f9667f;
    private Collection f9668g;

    public static com.facebook.messaging.tincan.inbound.ConnectionReceiver m10095a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9662h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.tincan.inbound.ConnectionReceiver.class;
        monitor-enter(r1);
        r0 = f9662h;	 Catch:{ all -> 0x003a }
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
        r0 = m10096b(r0);	 Catch:{ all -> 0x0035 }
        f9662h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9662h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.inbound.ConnectionReceiver.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.inbound.ConnectionReceiver");
    }

    private static ConnectionReceiver m10096b(InjectorLike injectorLike) {
        return new ConnectionReceiver(IdBasedProvider.a(injectorLike, 4443), IdBasedSingletonScopeProvider.a(injectorLike, 8581), TincanGatekeepers.b(injectorLike), TincanDebugErrorReporter.m10099b(injectorLike), TincanOmnistoreRefresherByGatekeeper.a(injectorLike));
    }

    @Inject
    public ConnectionReceiver(Provider<String> provider, Provider<InboundConnectionQueue> provider2, TincanGatekeepers tincanGatekeepers, TincanDebugErrorReporter tincanDebugErrorReporter, TincanOmnistoreRefresherByGatekeeper tincanOmnistoreRefresherByGatekeeper) {
        this.f9663b = provider;
        this.f9664c = provider2;
        this.f9665d = tincanGatekeepers;
        this.f9666e = tincanDebugErrorReporter;
        this.f9667f = tincanOmnistoreRefresherByGatekeeper;
        this.f9667f.a(this);
    }

    public OmnistoreComponent$SubscriptionInfo provideSubscriptionInfo(Omnistore omnistore) {
        if (this.f9665d.a()) {
            return OmnistoreComponent$SubscriptionInfo.forOpenSubscription(omnistore.createCollectionNameBuilder("tincan_sig").addSegment((String) this.f9663b.get()).build());
        }
        return OmnistoreComponent$SubscriptionInfo.IGNORED_INFO;
    }

    public synchronized void onCollectionAvailable(Collection collection) {
        this.f9668g = collection;
    }

    public void onDeltasReceived(List<Delta> list) {
        for (Delta delta : list) {
            try {
                delta.getCollectionName();
                delta.getPrimaryKey();
                delta.getSortKey();
                delta.getType();
                if (delta.getType() == Type.SAVE) {
                    ((TincanIncomingDispatcher) this.f9664c.get()).a(new TincanMessage(delta.getPrimaryKey(), delta.getBlob()));
                } else if (delta.getType() == Type.DELETE) {
                    ((TincanIncomingDispatcher) this.f9664c.get()).a(delta.getPrimaryKey());
                }
            } catch (Throwable e) {
                BLog.b(f9661a, "Exception processing signaling collection delta", e);
            }
        }
    }

    public IndexedFields indexObject(String str, String str2, ByteBuffer byteBuffer) {
        return new IndexedFields();
    }

    public synchronized void onCollectionInvalidated() {
        this.f9668g = null;
    }

    public final synchronized void m10097a(String str) {
        if (this.f9668g == null) {
            this.f9666e.m10100a(f9661a, "No signaling collection subscribed to clear signaling");
        } else {
            this.f9668g.deleteObject(str);
        }
    }
}
