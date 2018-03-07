package com.facebook.messaging.tincan.inbound;

import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.tincan.TincanDebugErrorReporter;
import com.facebook.messaging.tincan.TincanDeviceIdHolder;
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
/* compiled from: la_authenticate_deny */
public class MessageReceiver implements OmnistoreComponent {
    private static final Class<?> f9672a = MessageReceiver.class;
    private static volatile MessageReceiver f9673i;
    private final TincanDeviceIdHolder f9674b;
    private final Provider<String> f9675c;
    private final Provider<InboundMessageQueue> f9676d;
    private final TincanGatekeepers f9677e;
    private final Lazy<TincanDebugErrorReporter> f9678f;
    private final TincanOmnistoreRefresherByGatekeeper f9679g;
    private Collection f9680h;

    public static com.facebook.messaging.tincan.inbound.MessageReceiver m10102a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9673i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.tincan.inbound.MessageReceiver.class;
        monitor-enter(r1);
        r0 = f9673i;	 Catch:{ all -> 0x003a }
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
        r0 = m10103b(r0);	 Catch:{ all -> 0x0035 }
        f9673i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9673i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.inbound.MessageReceiver.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.inbound.MessageReceiver");
    }

    private static MessageReceiver m10103b(InjectorLike injectorLike) {
        return new MessageReceiver(TincanDeviceIdHolder.a(injectorLike), IdBasedProvider.a(injectorLike, 4443), IdBasedSingletonScopeProvider.a(injectorLike, 8581), TincanGatekeepers.b(injectorLike), IdBasedLazy.a(injectorLike, 2716), TincanOmnistoreRefresherByGatekeeper.a(injectorLike));
    }

    @Inject
    public MessageReceiver(TincanDeviceIdHolder tincanDeviceIdHolder, Provider<String> provider, Provider<InboundMessageQueue> provider2, TincanGatekeepers tincanGatekeepers, Lazy<TincanDebugErrorReporter> lazy, TincanOmnistoreRefresherByGatekeeper tincanOmnistoreRefresherByGatekeeper) {
        this.f9674b = tincanDeviceIdHolder;
        this.f9675c = provider;
        this.f9676d = provider2;
        this.f9677e = tincanGatekeepers;
        this.f9678f = lazy;
        this.f9679g = tincanOmnistoreRefresherByGatekeeper;
        this.f9679g.a(this);
    }

    public OmnistoreComponent$SubscriptionInfo provideSubscriptionInfo(Omnistore omnistore) {
        if (this.f9677e.a()) {
            return OmnistoreComponent$SubscriptionInfo.forOpenSubscription(omnistore.createCollectionNameBuilder("tincan_msg").addSegment((String) this.f9675c.get()).addSegment(this.f9674b.a()).build());
        }
        return OmnistoreComponent$SubscriptionInfo.IGNORED_INFO;
    }

    public synchronized void onCollectionAvailable(Collection collection) {
        this.f9680h = collection;
    }

    public void onDeltasReceived(List<Delta> list) {
        for (Delta delta : list) {
            try {
                delta.getCollectionName();
                delta.getPrimaryKey();
                delta.getSortKey();
                delta.getType();
                if (delta.getType() == Type.SAVE) {
                    ((TincanIncomingDispatcher) this.f9676d.get()).b(new TincanMessage(delta.getPrimaryKey(), delta.getBlob()));
                }
            } catch (Throwable e) {
                BLog.b(f9672a, "Exception processing messaging collection delta", e);
            }
        }
    }

    public IndexedFields indexObject(String str, String str2, ByteBuffer byteBuffer) {
        return new IndexedFields();
    }

    public synchronized void onCollectionInvalidated() {
        this.f9680h = null;
    }

    public final synchronized void m10104a(String str) {
        if (this.f9680h == null) {
            ((TincanDebugErrorReporter) this.f9678f.get()).m10100a(f9672a, "No messaging collection subscribed to drain");
        } else {
            this.f9680h.deleteObject(str);
        }
    }
}
