package com.facebook.video.videohome.liveupdates;

import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.network.NetworkMonitor.State;
import com.facebook.facecastdisplay.LiveStatusBatchPoller;
import com.facebook.facecastdisplay.protocol.FetchViewerCountAndBroadcastStatusQueryModels.FetchViewerCountAndBroadcastStatusQueryModel;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.video.videohome.abtest.VideoHomeConfig;
import com.facebook.video.videohome.protocol.VideoHomeSubscriptionsGraphQLHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array. */
public class LiveVideoStatusNotifier {
    private static volatile LiveVideoStatusNotifier f2956j;
    ArrayList<WeakReference<Object>> f2957a;
    public Runnable f2958b;
    private final Object f2959c = new Object();
    private final VideoHomeConfig f2960d;
    public final Lazy<VideoHomeSubscriptionsGraphQLHelper> f2961e;
    public final SubscriptionHandlersCollection f2962f;
    public final LiveStatusBatchPoller f2963g;
    public final NetworkMonitor f2964h;
    public SelfRegistrableReceiverImpl f2965i;

    /* compiled from: spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array. */
    public class C02841 implements Runnable {
        final /* synthetic */ LiveVideoStatusNotifier f2953a;

        public C02841(LiveVideoStatusNotifier liveVideoStatusNotifier) {
            this.f2953a = liveVideoStatusNotifier;
        }

        public void run() {
            LiveVideoStatusNotifier liveVideoStatusNotifier = this.f2953a;
            HashSet<String> hashSet = new HashSet(liveVideoStatusNotifier.f2962f.f2968c.keySet());
            if (!hashSet.isEmpty()) {
                liveVideoStatusNotifier.f2963g.c();
                for (String a : hashSet) {
                    liveVideoStatusNotifier.f2963g.a(a);
                }
                liveVideoStatusNotifier.f2963g.a();
            }
        }
    }

    /* compiled from: spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array. */
    class LiveStatusBatchPollerListener implements com.facebook.facecastdisplay.LiveStatusBatchPoller.LiveStatusBatchPollerListener {
        final /* synthetic */ LiveVideoStatusNotifier f2954a;

        public LiveStatusBatchPollerListener(LiveVideoStatusNotifier liveVideoStatusNotifier) {
            this.f2954a = liveVideoStatusNotifier;
        }

        public final void m2872a(Map<String, FetchViewerCountAndBroadcastStatusQueryModel> map) {
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                FetchViewerCountAndBroadcastStatusQueryModel fetchViewerCountAndBroadcastStatusQueryModel = (FetchViewerCountAndBroadcastStatusQueryModel) entry.getValue();
                if (fetchViewerCountAndBroadcastStatusQueryModel == null) {
                    LiveVideoStatusNotifier.m2874a(this.f2954a, str);
                } else {
                    LiveVideoStatusNotifier.m2875a(this.f2954a, str, fetchViewerCountAndBroadcastStatusQueryModel.j());
                }
            }
        }
    }

    /* compiled from: spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array. */
    public class SubscriptionHandlersCallback {
        public final /* synthetic */ LiveVideoStatusNotifier f2955a;

        public SubscriptionHandlersCallback(LiveVideoStatusNotifier liveVideoStatusNotifier) {
            this.f2955a = liveVideoStatusNotifier;
        }
    }

    public static com.facebook.video.videohome.liveupdates.LiveVideoStatusNotifier m2873a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2956j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.videohome.liveupdates.LiveVideoStatusNotifier.class;
        monitor-enter(r1);
        r0 = f2956j;	 Catch:{ all -> 0x003a }
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
        r0 = m2877b(r0);	 Catch:{ all -> 0x0035 }
        f2956j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2956j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.videohome.liveupdates.LiveVideoStatusNotifier.a(com.facebook.inject.InjectorLike):com.facebook.video.videohome.liveupdates.LiveVideoStatusNotifier");
    }

    private static LiveVideoStatusNotifier m2877b(InjectorLike injectorLike) {
        return new LiveVideoStatusNotifier(IdBasedLazy.a(injectorLike, 3715), LiveStatusBatchPoller.b(injectorLike), NetworkMonitor.a(injectorLike), VideoHomeConfig.a(injectorLike));
    }

    @Inject
    public LiveVideoStatusNotifier(Lazy<VideoHomeSubscriptionsGraphQLHelper> lazy, LiveStatusBatchPoller liveStatusBatchPoller, NetworkMonitor networkMonitor, VideoHomeConfig videoHomeConfig) {
        this.f2961e = lazy;
        this.f2960d = videoHomeConfig;
        this.f2963g = liveStatusBatchPoller;
        this.f2963g.j = true;
        this.f2963g.k = 0;
        this.f2963g.l = false;
        this.f2963g.h = new LiveStatusBatchPollerListener(this);
        this.f2964h = networkMonitor;
        this.f2962f = new SubscriptionHandlersCollection(new SubscriptionHandlersCallback(this));
        this.f2957a = new ArrayList();
        if (this.f2960d.b && this.f2965i == null) {
            if (this.f2958b == null) {
                this.f2958b = new C02841(this);
            }
            this.f2965i = this.f2964h.a(State.CONNECTED, this.f2958b);
        }
    }

    private void m2876a(String str, @Nullable GraphQLVideoBroadcastStatus graphQLVideoBroadcastStatus, int i) {
        synchronized (this.f2959c) {
            ArrayList arrayList = (ArrayList) this.f2957a.clone();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((WeakReference) arrayList.get(i2)).get();
            }
        }
    }

    public static void m2875a(LiveVideoStatusNotifier liveVideoStatusNotifier, String str, GraphQLVideoBroadcastStatus graphQLVideoBroadcastStatus) {
        Object obj;
        if (graphQLVideoBroadcastStatus == GraphQLVideoBroadcastStatus.LIVE) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            liveVideoStatusNotifier.f2962f.m2879a(str);
        }
        liveVideoStatusNotifier.m2876a(str, graphQLVideoBroadcastStatus, liveVideoStatusNotifier.f2962f.m2880b());
    }

    public static void m2874a(LiveVideoStatusNotifier liveVideoStatusNotifier, String str) {
        liveVideoStatusNotifier.f2962f.m2879a(str);
        liveVideoStatusNotifier.m2876a(str, null, liveVideoStatusNotifier.f2962f.m2880b());
    }
}
