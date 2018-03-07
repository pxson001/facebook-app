package com.facebook.api.feed.subscriptions;

import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feed.subscriptions.LiveVideoStatusSubscriptions.LiveVideoStatusUpdateSubscriptionString;
import com.facebook.api.feed.subscriptions.LiveVideoStatusSubscriptionsModels.LiveVideoStatusUpdateSubscriptionModel;
import com.facebook.api.feedcache.db.FeedDbMutationService;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.LiveVideoBroadcastStatusUpdateSubscribeInputData;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionConnectorException;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionHandle;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: session_cookies_string */
public class LiveVideoStatusHandler {
    private static volatile LiveVideoStatusHandler f5492d;
    public final GraphQLSubscriptionConnector f5493a;
    private final GraphQLStoryUtil f5494b;
    public Map<String, GraphQLSubscriptionHandle<LiveVideoStatusUpdateSubscriptionModel>> f5495c = new HashMap();

    public static com.facebook.api.feed.subscriptions.LiveVideoStatusHandler m9378a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5492d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.feed.subscriptions.LiveVideoStatusHandler.class;
        monitor-enter(r1);
        r0 = f5492d;	 Catch:{ all -> 0x003a }
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
        r0 = m9380b(r0);	 Catch:{ all -> 0x0035 }
        f5492d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5492d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feed.subscriptions.LiveVideoStatusHandler.a(com.facebook.inject.InjectorLike):com.facebook.api.feed.subscriptions.LiveVideoStatusHandler");
    }

    private static LiveVideoStatusHandler m9380b(InjectorLike injectorLike) {
        return new LiveVideoStatusHandler(GraphQLSubscriptionConnector.m9383a(injectorLike), GraphQLStoryUtil.m9565a(injectorLike));
    }

    @Inject
    public LiveVideoStatusHandler(GraphQLSubscriptionConnector graphQLSubscriptionConnector, GraphQLStoryUtil graphQLStoryUtil) {
        this.f5493a = graphQLSubscriptionConnector;
        this.f5494b = graphQLStoryUtil;
    }

    public final void m9382a(FetchFeedResult fetchFeedResult, FeedDbMutationService feedDbMutationService) {
        Map hashMap = new HashMap();
        ImmutableList d = fetchFeedResult.m22439d();
        int size = d.size();
        for (int i = 0; i < size; i++) {
            GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) d.get(i);
            GraphQLStoryAttachment p = GraphQLStoryUtil.m9585p((GraphQLStory) graphQLFeedUnitEdge.mo2540c());
            if (!(p == null || p.m23979r() == null || !p.m23979r().al())) {
                hashMap.put(p.m23979r().m24452b(), graphQLFeedUnitEdge.m19080b());
            }
        }
        for (Entry entry : hashMap.entrySet()) {
            String str = (String) entry.getKey();
            this.f5495c.put(str, m9379a(str, (FutureCallback) new 1(this, feedDbMutationService, (String) entry.getValue())));
        }
    }

    private static LiveVideoStatusUpdateSubscriptionString m9381b(String str) {
        GraphQlCallInput a = new LiveVideoBroadcastStatusUpdateSubscribeInputData().a(str);
        GraphQlQueryString liveVideoStatusUpdateSubscriptionString = new LiveVideoStatusUpdateSubscriptionString();
        liveVideoStatusUpdateSubscriptionString.m11310a("input", a);
        return liveVideoStatusUpdateSubscriptionString;
    }

    @Nullable
    private GraphQLSubscriptionHandle<LiveVideoStatusUpdateSubscriptionModel> m9379a(String str, FutureCallback<LiveVideoStatusUpdateSubscriptionModel> futureCallback) {
        GraphQLSubscriptionHandle<LiveVideoStatusUpdateSubscriptionModel> graphQLSubscriptionHandle = null;
        try {
            graphQLSubscriptionHandle = this.f5493a.m9386a(m9381b(str), futureCallback);
        } catch (GraphQLSubscriptionConnectorException e) {
            BLog.b("LiveVideoStatusHandler", "Live video broadcast status update subscription failed. %s", e);
        }
        return graphQLSubscriptionHandle;
    }
}
