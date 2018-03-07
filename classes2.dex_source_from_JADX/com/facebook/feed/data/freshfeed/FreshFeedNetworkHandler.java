package com.facebook.feed.data.freshfeed;

import android.os.Looper;
import android.os.Message;
import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feed.xconfig.NewsFeedXConfigReader;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.common.appstartup.AppStartupTracker;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.feed.data.FeedFetcherProcessor;
import com.facebook.feed.data.freshfeed.FreshFeedFetcher.FetchParams;
import com.facebook.feed.freshfeed.FreshFeedHandler;
import com.facebook.feed.loader.FeedFetcherCache;
import com.facebook.feed.loader.FetchFeedParamsGenerator;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger.FreshFeedEvent;
import com.facebook.feed.model.ClientFeedUnitEdgeBuilder;
import com.facebook.feed.protocol.FetchFeedMethod.FetcherCallback;
import com.facebook.feed.protocol.FetchNewsFeedMethod;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.RequestObserver;
import com.facebook.graphql.executor.RequestSubscriber;
import com.facebook.graphql.model.GraphQLFeedHomeStories;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.inject.Assisted;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: save_username */
public class FreshFeedNetworkHandler extends FreshFeedHandler {
    public static final String f6221b = FreshFeedNetworkHandler.class.getSimpleName();
    private static final int[] f6222c = new int[]{1, 3};
    @VisibleForTesting
    protected ArrayList<NetworkRequestSubscriber> f6223a = new ArrayList(2);
    private final DbFeedHomeStoriesHandler f6224d;
    private final ExecutorService f6225e;
    private final FetchFeedParamsGenerator f6226f;
    private final GraphQLQueryExecutor f6227g;
    public final FeedFetcherProcessor f6228h;
    public final FeedFetcherCache f6229i;
    public final FetchNewsFeedMethod f6230j;
    public final FreshFeedDataLoaderUIHandler f6231k;
    public final FreshFeedBackgroundUIWorkHandler f6232l;
    private final NewsFeedXConfigReader f6233m;
    public final NewsFeedEventLogger f6234n;
    public final AppStartupTracker f6235o;

    /* compiled from: save_username */
    public class NetworkRequestSubscriber extends RequestSubscriber<GraphQLResult> implements FetcherCallback {
        final /* synthetic */ FreshFeedNetworkHandler f6457a;
        private FetchParams f6458b;
        private FetchFeedParams f6459c;
        private boolean f6460d;
        private int f6461e = 0;

        protected NetworkRequestSubscriber(FreshFeedNetworkHandler freshFeedNetworkHandler) {
            this.f6457a = freshFeedNetworkHandler;
        }

        public final void mo1595a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            TracerDetour.a("NetworkRequestSubscriber.onNext", 1864227087);
            try {
                if (this.f6460d) {
                    GraphQLFeedHomeStories a = this.f6457a.f6230j.mo1422a(this.f6459c, graphQLResult);
                    this.f6457a.f6234n.m4413a(FreshFeedNetworkHandler.f6221b, FreshFeedEvent.NETWORK_NEXT, a == null ? "null" : String.valueOf(a.m22430k().size()));
                    if (a == null) {
                        TracerDetour.a(490891498);
                        return;
                    }
                    List<GraphQLFeedUnitEdge> d = m11185a(a).m22439d();
                    Builder builder = new Builder();
                    int a2 = m11184a(this.f6458b, this.f6461e == 0);
                    for (GraphQLFeedUnitEdge a3 : d) {
                        builder.m1069c(ClientFeedUnitEdgeBuilder.m21161a(a3));
                        this.f6461e++;
                    }
                    if (!(d == null || d.isEmpty()) || (this.f6461e == 0 && this.f6458b.f5959g.isManual())) {
                        if (this.f6458b.f5959g.isAutoRefresh()) {
                            this.f6457a.f6232l.m9983a(builder.m1068b());
                        } else {
                            this.f6457a.f6232l.m9984a(builder.m1068b(), a2);
                        }
                    }
                    TracerDetour.a(-1232118018);
                    return;
                }
                this.f6457a.f6234n.m4413a(FreshFeedNetworkHandler.f6221b, FreshFeedEvent.NETWORK_NEXT, String.valueOf(this.f6460d));
            } finally {
                TracerDetour.a(-1046889028);
            }
        }

        public final void m11188a(FetchParams fetchParams, FetchFeedParams fetchFeedParams) {
            this.f6458b = fetchParams;
            this.f6459c = fetchFeedParams;
            this.f6460d = true;
            this.f6461e = 0;
        }

        public final void m11191d() {
            this.f6459c = null;
            this.f6459c = null;
            this.f6460d = false;
            this.f6461e = 0;
        }

        public final RequestObserver mo1593a(String str) {
            if ("feedback_subscriber".equals(str)) {
                return null;
            }
            Preconditions.checkArgument("feed_subscriber".equals(str));
            return this;
        }

        public final void mo1594a() {
            TracerDetour.a("NetworkRequestSubscriber.onCompleted", 1799930823);
            try {
                this.f6457a.f6234n.m4413a(FreshFeedNetworkHandler.f6221b, FreshFeedEvent.NETWORK_SUCCESS, String.valueOf(this.f6460d));
                if (this.f6460d) {
                    if (this.f6458b.f5959g.isAutoRefresh()) {
                        this.f6457a.f6231k.m9907b(this.f6461e);
                    }
                    this.f6457a.f6231k.m9903a(this.f6461e, this.f6458b.f5959g.isNewStoriesFetch() ? 7 : 8);
                    this.f6457a.m10431a(this);
                    TracerDetour.a(-767030283);
                }
            } finally {
                TracerDetour.a(1177373767);
            }
        }

        public final void mo1596a(Throwable th) {
            TracerDetour.a("NetworkRequestSubscriber.onError", -1137562187);
            try {
                this.f6457a.f6234n.m4413a(FreshFeedNetworkHandler.f6221b, FreshFeedEvent.NETWORK_ERROR, th.getMessage());
                if (this.f6460d) {
                    this.f6457a.f6235o.m9076a(null, false, this.f6459c.m9913f());
                    if (this.f6458b.f5959g.isAutoRefresh()) {
                        this.f6457a.f6231k.m9907b(this.f6461e);
                    }
                    this.f6457a.f6231k.m9906a(th, this.f6458b.f5959g.isNewStoriesFetch() ? 7 : 8);
                    this.f6457a.m10431a(this);
                    TracerDetour.a(-172868489);
                }
            } finally {
                TracerDetour.a(1453400367);
            }
        }

        private FetchFeedResult m11185a(GraphQLFeedHomeStories graphQLFeedHomeStories) {
            FetchFeedResult b = this.f6457a.f6228h.m10528b(new FetchFeedResult(this.f6459c, graphQLFeedHomeStories, DataFreshnessResult.FROM_SERVER, this.f6458b.f5957e, false));
            FeedFetcherProcessor feedFetcherProcessor = this.f6457a.f6228h;
            DbFeedHomeStoriesHandler.m9126a(b);
            this.f6457a.f6229i.m10535a(b);
            return b;
        }

        private static int m11184a(FetchParams fetchParams, boolean z) {
            if (fetchParams.f5959g.isNewStoriesFetch()) {
                return z ? 0 : 6;
            } else {
                return 1;
            }
        }
    }

    @Inject
    public FreshFeedNetworkHandler(@Assisted Looper looper, @Assisted FreshFeedDataLoaderUIHandler freshFeedDataLoaderUIHandler, @Assisted FreshFeedBackgroundUIWorkHandler freshFeedBackgroundUIWorkHandler, DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler, ExecutorService executorService, FetchFeedParamsGenerator fetchFeedParamsGenerator, GraphQLQueryExecutor graphQLQueryExecutor, FeedFetcherProcessor feedFetcherProcessor, FeedFetcherCache feedFetcherCache, FetchNewsFeedMethod fetchNewsFeedMethod, NewsFeedXConfigReader newsFeedXConfigReader, NewsFeedEventLogger newsFeedEventLogger, AppStartupTracker appStartupTracker) {
        super(looper, f6222c);
        this.f6224d = dbFeedHomeStoriesHandler;
        this.f6225e = executorService;
        this.f6226f = fetchFeedParamsGenerator;
        this.f6227g = graphQLQueryExecutor;
        this.f6228h = feedFetcherProcessor;
        this.f6229i = feedFetcherCache;
        this.f6230j = fetchNewsFeedMethod;
        this.f6231k = freshFeedDataLoaderUIHandler;
        this.f6232l = freshFeedBackgroundUIWorkHandler;
        this.f6233m = newsFeedXConfigReader;
        this.f6234n = newsFeedEventLogger;
        this.f6235o = appStartupTracker;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                m10428c((FetchParams) message.obj);
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                m10427b((NetworkRequestSubscriber) message.obj);
                return;
            case 3:
                m10429d((FetchParams) message.obj);
                return;
            default:
                throw new IllegalArgumentException("Unknown what=" + message.what);
        }
    }

    private void m10427b(NetworkRequestSubscriber networkRequestSubscriber) {
        TracerDetour.a("FreshFeedNetworkHandler.doFreeNetworkCallback", -1519369458);
        try {
            networkRequestSubscriber.m11191d();
            this.f6223a.add(networkRequestSubscriber);
        } finally {
            TracerDetour.a(1398098831);
        }
    }

    private void m10428c(FetchParams fetchParams) {
        TracerDetour.a("FreshFeedNetworkHandler.doFetchNewStoriesFromNetwork", -711709132);
        try {
            FetcherCallback networkRequestSubscriber;
            FetchFeedParams a = this.f6226f.m9798a(fetchParams.f5954b, this.f6224d.m9175c(fetchParams.f5954b), this.f6233m.m8199n(), DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, fetchParams.f5959g);
            this.f6230j.mo1425a(a);
            if (this.f6223a.isEmpty()) {
                networkRequestSubscriber = new NetworkRequestSubscriber(this);
            } else {
                networkRequestSubscriber = (NetworkRequestSubscriber) this.f6223a.remove(0);
            }
            networkRequestSubscriber.m11188a(fetchParams, a);
            this.f6227g.m10453a(this.f6230j.m10085a(a, fetchParams.f5956d, networkRequestSubscriber, this.f6233m.m8199n(), this.f6233m.m8200o()), this.f6225e);
        } finally {
            TracerDetour.a(1285570240);
        }
    }

    private void m10429d(FetchParams fetchParams) {
        TracerDetour.a("FreshFeedNetworkHandler.doFetchMoreStoriesFromNetwork", 618411282);
        try {
            FetcherCallback networkRequestSubscriber;
            FetchFeedParams b = this.f6226f.m9802b(fetchParams.f5954b, fetchParams.f5958f, this.f6233m.m8199n(), DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, fetchParams.f5959g);
            this.f6230j.mo1425a(b);
            if (this.f6223a.isEmpty()) {
                networkRequestSubscriber = new NetworkRequestSubscriber(this);
            } else {
                networkRequestSubscriber = (NetworkRequestSubscriber) this.f6223a.remove(0);
            }
            networkRequestSubscriber.m11188a(fetchParams, b);
            this.f6227g.m10453a(this.f6230j.m10085a(b, fetchParams.f5956d, networkRequestSubscriber, this.f6233m.m8199n(), this.f6233m.m8200o()), this.f6225e);
        } finally {
            TracerDetour.a(-90149554);
        }
    }

    public final void m10430a(FetchParams fetchParams) {
        sendMessage(obtainMessage(1, fetchParams));
    }

    public final void m10431a(NetworkRequestSubscriber networkRequestSubscriber) {
        sendMessage(obtainMessage(2, networkRequestSubscriber));
    }

    public final void m10432b(FetchParams fetchParams) {
        sendMessage(obtainMessage(3, fetchParams));
    }
}
