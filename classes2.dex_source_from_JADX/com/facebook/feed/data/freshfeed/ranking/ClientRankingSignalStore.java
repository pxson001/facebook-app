package com.facebook.feed.data.freshfeed.ranking;

import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.preconditions.Preconditions;
import com.facebook.feed.data.freshfeed.ranking.GlobalClientRankingSignal.C08971;
import com.facebook.feed.model.ClientFeedUnitEdge;
import com.facebook.inject.InjectorLike;
import java.util.HashMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: session_end */
public class ClientRankingSignalStore {
    private static volatile ClientRankingSignalStore f5473e;
    private final GlobalClientRankingSignal f5474a;
    private final HashMap<String, ClientRankingSignal> f5475b = new HashMap(250);
    private final HashMap<String, String> f5476c = new HashMap(250);
    private boolean f5477d = false;

    public static com.facebook.feed.data.freshfeed.ranking.ClientRankingSignalStore m9365a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5473e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.data.freshfeed.ranking.ClientRankingSignalStore.class;
        monitor-enter(r1);
        r0 = f5473e;	 Catch:{ all -> 0x003a }
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
        r0 = m9366b(r0);	 Catch:{ all -> 0x0035 }
        f5473e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5473e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.data.freshfeed.ranking.ClientRankingSignalStore.a(com.facebook.inject.InjectorLike):com.facebook.feed.data.freshfeed.ranking.ClientRankingSignalStore");
    }

    private static ClientRankingSignalStore m9366b(InjectorLike injectorLike) {
        return new ClientRankingSignalStore(GlobalClientRankingSignal.m9374a(injectorLike));
    }

    @Inject
    public ClientRankingSignalStore(GlobalClientRankingSignal globalClientRankingSignal) {
        this.f5474a = globalClientRankingSignal;
    }

    public final GlobalClientRankingSignal m9369a() {
        if (!this.f5477d) {
            GlobalClientRankingSignal globalClientRankingSignal = this.f5474a;
            if (!globalClientRankingSignal.f5486h) {
                globalClientRankingSignal.mConnectionQuality = ((FbDataConnectionManager) globalClientRankingSignal.f5480b.get()).m3801c();
                globalClientRankingSignal.mIsConnected = ((FbNetworkManager) globalClientRankingSignal.f5481c.get()).m3828d();
                globalClientRankingSignal.f5484f = new C08971(globalClientRankingSignal);
                ((BaseFbBroadcastManager) globalClientRankingSignal.f5482d.get()).m2951a().mo506a(FbDataConnectionManager.f1876a, globalClientRankingSignal.f5484f).mo503a().m3296b();
                globalClientRankingSignal.f5486h = true;
            }
            this.f5477d = true;
        }
        return this.f5474a;
    }

    public final synchronized ClientRankingSignal m9368a(String str) {
        return (ClientRankingSignal) this.f5475b.get(this.f5476c.get(str));
    }

    public final synchronized ClientRankingSignal m9371b(String str) {
        return (ClientRankingSignal) this.f5475b.get(str);
    }

    public final synchronized ClientRankingSignal m9367a(ClientFeedUnitEdge clientFeedUnitEdge) {
        ClientRankingSignal clientRankingSignal;
        boolean z = false;
        synchronized (this) {
            if (clientFeedUnitEdge != null) {
                z = true;
            }
            Preconditions.m2017b(z);
            String C = clientFeedUnitEdge.m21225C();
            String b = clientFeedUnitEdge.m19080b();
            if (b == null) {
                clientRankingSignal = null;
            } else {
                clientRankingSignal = m9371b(b);
                if (clientRankingSignal == null) {
                    clientRankingSignal = new ClientRankingSignal();
                }
                clientRankingSignal.m30078a(clientFeedUnitEdge.m21241z());
                clientRankingSignal.m30081b(clientFeedUnitEdge.X_());
                clientRankingSignal.m30079a(clientFeedUnitEdge.m21238w());
                clientRankingSignal.m30080a(clientFeedUnitEdge.m19088k());
                clientRankingSignal.m30082b(clientFeedUnitEdge.m21224B());
                clientRankingSignal.m30083c(0);
                this.f5475b.put(b, clientRankingSignal);
                if (C != null) {
                    this.f5476c.put(C, b);
                }
            }
        }
        return clientRankingSignal;
    }

    public final synchronized void m9370a(String str, int i) {
        ClientRankingSignal a = m9368a(str);
        if (a != null) {
            a.m30078a(i);
        }
    }

    public final synchronized void m9372b(String str, int i) {
        ClientRankingSignal a = m9368a(str);
        if (a != null) {
            a.m30082b(i);
        }
    }

    public final synchronized void m9373c(String str, int i) {
        ClientRankingSignal b = m9371b(str);
        if (b != null) {
            b.m30083c(i);
        }
    }
}
