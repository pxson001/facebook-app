package com.facebook.video.commercialbreak;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.feed.protocol.FetchFeedQueryUtil;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.feedprefetch.VideoPrefetchVisitorProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.video.commercialbreak.CommercialBreakMessageSubscriber.CommercialBreakMessage;
import com.facebook.video.commercialbreak.abtest.CommercialBreakConfig;
import com.facebook.video.commercialbreak.logging.CommercialBreakLogger;
import com.facebook.video.commercialbreak.plugins.CommercialBreakPlugin;
import com.facebook.video.commercialbreak.plugins.CommercialBreakPlugin.CommercialBreakInfoChangedListener;
import com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent.State;
import com.google.common.util.concurrent.Futures;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: platform_webview_actionmanifest */
public class CommercialBreakInfoTracker {
    private static final String f4514a = CommercialBreakInfoTracker.class.getSimpleName();
    public static final CallerContext f4515b = CallerContext.a(CommercialBreakInfoTracker.class);
    private static volatile CommercialBreakInfoTracker f4516n;
    public final CommercialBreakMessageSubscriberPool f4517c;
    private final CommercialBreakVideoAdFetcher f4518d;
    public final CommercialBreakConfig f4519e;
    private final Executor f4520f;
    private final Provider<Boolean> f4521g;
    private final Toaster f4522h;
    public final Map<String, CommercialBreakInfo> f4523i = new HashMap();
    public final Map<String, InfoChangedListener> f4524j = new HashMap();
    public final MessageListener f4525k = new MessageListener(this);
    public final CommercialBreakLogger f4526l;
    public final VideoPrefetchVisitorProvider f4527m;

    /* compiled from: platform_webview_actionmanifest */
    public class MessageListener {
        final /* synthetic */ CommercialBreakInfoTracker f4533a;

        public MessageListener(CommercialBreakInfoTracker commercialBreakInfoTracker) {
            this.f4533a = commercialBreakInfoTracker;
        }

        public final void m5043a(CommercialBreakMessage commercialBreakMessage) {
            CommercialBreakInfo o = CommercialBreakInfoTracker.m5028o(this.f4533a, commercialBreakMessage.a);
            CommercialBreakInfoChangedListener commercialBreakInfoChangedListener = (CommercialBreakInfoChangedListener) this.f4533a.f4524j.get(commercialBreakMessage.a);
            switch (2.a[commercialBreakMessage.b.ordinal()]) {
                case 1:
                    CommercialBreakInfoTracker.m5027b(this.f4533a, commercialBreakMessage, o, commercialBreakInfoChangedListener);
                    return;
                case 2:
                    commercialBreakMessage.toString();
                    o.c = commercialBreakMessage.d;
                    if (commercialBreakMessage.c != -1) {
                        o.b = commercialBreakMessage.c;
                    }
                    if (commercialBreakInfoChangedListener != null) {
                        String str = CommercialBreakPlugin.f4465q;
                        if (commercialBreakInfoChangedListener.f4513a.f14096h.m5487r() == null || !commercialBreakInfoChangedListener.f4513a.f14096h.m5487r().equals("")) {
                            commercialBreakInfoChangedListener.f4513a.f4481t.sendEmptyMessage(1);
                        } else {
                            commercialBreakInfoChangedListener.f4513a.f4481t.removeCallbacksAndMessages(null);
                            commercialBreakInfoChangedListener.f4513a.f4481t.sendEmptyMessage(2);
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static com.facebook.video.commercialbreak.CommercialBreakInfoTracker m5025a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4516n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.commercialbreak.CommercialBreakInfoTracker.class;
        monitor-enter(r1);
        r0 = f4516n;	 Catch:{ all -> 0x003a }
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
        r0 = m5026b(r0);	 Catch:{ all -> 0x0035 }
        f4516n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4516n;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.commercialbreak.CommercialBreakInfoTracker.a(com.facebook.inject.InjectorLike):com.facebook.video.commercialbreak.CommercialBreakInfoTracker");
    }

    private static CommercialBreakInfoTracker m5026b(InjectorLike injectorLike) {
        return new CommercialBreakInfoTracker(new CommercialBreakMessageSubscriberPool((CommercialBreakMessageSubscriberProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CommercialBreakMessageSubscriberProvider.class), CommercialBreakConfig.m4866a(injectorLike)), new CommercialBreakVideoAdFetcher(FetchFeedQueryUtil.a(injectorLike), GraphQLQueryExecutor.a(injectorLike)), CommercialBreakConfig.m4866a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4363), Toaster.b(injectorLike), CommercialBreakLogger.m5040a(injectorLike), (VideoPrefetchVisitorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoPrefetchVisitorProvider.class));
    }

    @Inject
    public CommercialBreakInfoTracker(CommercialBreakMessageSubscriberPool commercialBreakMessageSubscriberPool, CommercialBreakVideoAdFetcher commercialBreakVideoAdFetcher, CommercialBreakConfig commercialBreakConfig, Executor executor, Provider<Boolean> provider, Toaster toaster, CommercialBreakLogger commercialBreakLogger, VideoPrefetchVisitorProvider videoPrefetchVisitorProvider) {
        this.f4517c = commercialBreakMessageSubscriberPool;
        this.f4518d = commercialBreakVideoAdFetcher;
        this.f4519e = commercialBreakConfig;
        this.f4520f = executor;
        this.f4521g = provider;
        this.f4522h = toaster;
        this.f4526l = commercialBreakLogger;
        this.f4527m = videoPrefetchVisitorProvider;
    }

    @Nullable
    public final FeedProps<GraphQLStory> m5031b(String str) {
        CommercialBreakInfo commercialBreakInfo = (CommercialBreakInfo) this.f4523i.get(str);
        if (commercialBreakInfo == null) {
            return null;
        }
        return commercialBreakInfo.a;
    }

    public final long m5032d(String str) {
        CommercialBreakInfo commercialBreakInfo = (CommercialBreakInfo) this.f4523i.get(str);
        if (commercialBreakInfo == null) {
            return -1;
        }
        return commercialBreakInfo.c;
    }

    public final State m5033e(String str) {
        CommercialBreakInfo commercialBreakInfo = (CommercialBreakInfo) this.f4523i.get(str);
        if (commercialBreakInfo == null) {
            return State.LIVE;
        }
        return commercialBreakInfo.d;
    }

    public final long m5034h(String str) {
        CommercialBreakInfo commercialBreakInfo = (CommercialBreakInfo) this.f4523i.get(str);
        if (commercialBreakInfo == null) {
            return -1;
        }
        return commercialBreakInfo.g;
    }

    public final long m5035j(String str) {
        CommercialBreakInfo commercialBreakInfo = (CommercialBreakInfo) this.f4523i.get(str);
        if (commercialBreakInfo == null) {
            return -1;
        }
        return commercialBreakInfo.i;
    }

    public final long m5036l(String str) {
        CommercialBreakInfo commercialBreakInfo = (CommercialBreakInfo) this.f4523i.get(str);
        if (commercialBreakInfo == null) {
            return -1;
        }
        return commercialBreakInfo.k;
    }

    public final void m5030a(String str, boolean z) {
        m5028o(this, str).j = z;
    }

    public static void m5027b(CommercialBreakInfoTracker commercialBreakInfoTracker, CommercialBreakMessage commercialBreakMessage, CommercialBreakInfo commercialBreakInfo, CommercialBreakInfoChangedListener commercialBreakInfoChangedListener) {
        int i;
        commercialBreakMessage.toString();
        commercialBreakInfo.b = commercialBreakMessage.c;
        commercialBreakInfo.f = CommercialBreakVideoAdFetcher.State.FETCHING;
        CommercialBreakVideoAdFetcher commercialBreakVideoAdFetcher = commercialBreakInfoTracker.f4518d;
        String str = commercialBreakMessage.a;
        long j = (commercialBreakInfo.b - commercialBreakInfoTracker.f4519e.f4319d) - commercialBreakInfoTracker.f4519e.f4320e;
        if (j < -2147483648L || j > 2147483647L) {
            i = 15500;
        } else {
            i = (int) j;
        }
        GraphQLQueryFuture a = commercialBreakVideoAdFetcher.m5039a(str, i);
        Futures.a(a, new 1(commercialBreakInfoTracker, a, commercialBreakInfo, commercialBreakMessage, commercialBreakInfoChangedListener), commercialBreakInfoTracker.f4520f);
    }

    public static CommercialBreakInfo m5028o(CommercialBreakInfoTracker commercialBreakInfoTracker, String str) {
        if (commercialBreakInfoTracker.f4523i.containsKey(str)) {
            return (CommercialBreakInfo) commercialBreakInfoTracker.f4523i.get(str);
        }
        CommercialBreakInfo commercialBreakInfo = new CommercialBreakInfo();
        commercialBreakInfoTracker.f4523i.put(str, commercialBreakInfo);
        return commercialBreakInfo;
    }

    public static void m5029p(CommercialBreakInfoTracker commercialBreakInfoTracker, String str) {
        if (((Boolean) commercialBreakInfoTracker.f4521g.get()).booleanValue()) {
            commercialBreakInfoTracker.f4522h.a(new ToastBuilder((CharSequence) str));
        }
    }
}
