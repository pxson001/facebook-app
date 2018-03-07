package com.facebook.feed.data.freshfeed.ranking;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: session_duration_ms */
public class GlobalClientRankingSignal {
    public static long f5478a = 9;
    private static volatile GlobalClientRankingSignal f5479i;
    @JsonIgnore
    public final Lazy<FbDataConnectionManager> f5480b;
    @JsonIgnore
    public final Lazy<FbNetworkManager> f5481c;
    @JsonIgnore
    @LocalBroadcast
    public final Lazy<FbBroadcastManager> f5482d;
    @JsonIgnore
    public final MediaRollHelper f5483e;
    @JsonIgnore
    public ActionReceiver f5484f;
    @JsonIgnore
    public boolean f5485g = true;
    @JsonIgnore
    public boolean f5486h = false;
    @JsonProperty("connection_quality")
    public ConnectionQuality mConnectionQuality;
    @JsonProperty("is_connected")
    public boolean mIsConnected;
    @JsonProperty("is_photo_taken_in_last_n_min")
    public boolean mIsPhotoTakenInLastNMinutes = false;

    /* compiled from: session_duration_ms */
    public class C08971 implements ActionReceiver {
        final /* synthetic */ GlobalClientRankingSignal f22211a;

        public C08971(GlobalClientRankingSignal globalClientRankingSignal) {
            this.f22211a = globalClientRankingSignal;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -151826138);
            Bundle extras = intent.getExtras();
            GlobalClientRankingSignal globalClientRankingSignal = this.f22211a;
            ConnectionQuality connectionQuality = (ConnectionQuality) extras.get(FbDataConnectionManager.f1877b);
            if (!globalClientRankingSignal.mConnectionQuality.equals(connectionQuality)) {
                globalClientRankingSignal.mConnectionQuality = connectionQuality;
                globalClientRankingSignal.f5485g = true;
            }
            GlobalClientRankingSignal globalClientRankingSignal2 = this.f22211a;
            boolean z = extras.getBoolean(FbDataConnectionManager.f1879d);
            if (globalClientRankingSignal2.mIsConnected != z) {
                globalClientRankingSignal2.f5485g = true;
                globalClientRankingSignal2.mIsConnected = z;
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1849520687, a);
        }
    }

    public static com.facebook.feed.data.freshfeed.ranking.GlobalClientRankingSignal m9374a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5479i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.data.freshfeed.ranking.GlobalClientRankingSignal.class;
        monitor-enter(r1);
        r0 = f5479i;	 Catch:{ all -> 0x003a }
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
        r0 = m9375b(r0);	 Catch:{ all -> 0x0035 }
        f5479i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5479i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.data.freshfeed.ranking.GlobalClientRankingSignal.a(com.facebook.inject.InjectorLike):com.facebook.feed.data.freshfeed.ranking.GlobalClientRankingSignal");
    }

    private static GlobalClientRankingSignal m9375b(InjectorLike injectorLike) {
        return new GlobalClientRankingSignal(IdBasedSingletonScopeProvider.m1810b(injectorLike, 584), IdBasedSingletonScopeProvider.m1810b(injectorLike, 585), IdBasedLazy.m1808a(injectorLike, 401), new MediaRollHelper(SystemClockMethodAutoProvider.m1498a(injectorLike), (Context) injectorLike.getInstance(Context.class)));
    }

    @Inject
    public GlobalClientRankingSignal(Lazy<FbDataConnectionManager> lazy, Lazy<FbNetworkManager> lazy2, Lazy<FbBroadcastManager> lazy3, MediaRollHelper mediaRollHelper) {
        this.f5480b = lazy;
        this.f5481c = lazy2;
        this.f5482d = lazy3;
        this.f5483e = mediaRollHelper;
    }
}
