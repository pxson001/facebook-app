package com.facebook.facecastdisplay;

import android.text.TextUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.facecastdisplay.LiveEventModel.LiveEventType;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQuery.FetchLiveVideoNewestCommentsHeadQueryString;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQuery.FetchLiveVideoNewestCommentsInitialQueryString;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQuery.FetchLiveVideoNewestCommentsNeckQueryString;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FeedbackLiveVideoCommentCoreFragmentModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FeedbackLiveVideoNewestCommentStreamHeadFragmentModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FeedbackLiveVideoNewestCommentStreamInitialFragmentModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FeedbackLiveVideoNewestCommentStreamNeckFragmentModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveVideoNewestCommentsHeadQueryModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveVideoNewestCommentsInitialQueryModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveVideoNewestCommentsNeckQueryModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveVideoTopLevelCommentsModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveVideoTopLevelCommentsModel.EdgesModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: strength */
public class LiveCommentsDownloader extends LiveEventsDownloader {
    public static final String f2880f = LiveCommentsDownloader.class.getName();
    private final ExecutorService f2881g;
    private final GraphQLQueryExecutor f2882h;
    public final AbstractFbErrorReporter f2883i;
    private String f2884j;
    private int f2885k;
    @Nullable
    public volatile Future<? extends GraphQLResult> f2886l;

    /* compiled from: strength */
    abstract class TopLevelCommentsGetter<R, F> {
        @Nullable
        protected abstract LiveVideoTopLevelCommentsModel mo123a(F f);

        @Nullable
        protected abstract F mo124b(R r);

        @Nullable
        public final LiveVideoTopLevelCommentsModel m3160a(@Nullable GraphQLResult<R> graphQLResult) {
            if (graphQLResult == null) {
                return null;
            }
            Object obj = graphQLResult.e;
            if (obj == null) {
                return null;
            }
            obj = mo124b(obj);
            if (obj != null) {
                return mo123a(obj);
            }
            return null;
        }
    }

    /* compiled from: strength */
    class C02491 extends TopLevelCommentsGetter<FetchLiveVideoNewestCommentsInitialQueryModel, FeedbackLiveVideoNewestCommentStreamInitialFragmentModel> {
        final /* synthetic */ LiveCommentsDownloader f2875a;

        C02491(LiveCommentsDownloader liveCommentsDownloader) {
            this.f2875a = liveCommentsDownloader;
        }

        @Nullable
        protected final LiveVideoTopLevelCommentsModel mo123a(Object obj) {
            return ((FeedbackLiveVideoNewestCommentStreamInitialFragmentModel) obj).m3583q();
        }

        @Nullable
        protected final Object mo124b(Object obj) {
            return ((FetchLiveVideoNewestCommentsInitialQueryModel) obj).m3718j();
        }
    }

    /* compiled from: strength */
    class C02502 extends TopLevelCommentsGetter<FetchLiveVideoNewestCommentsNeckQueryModel, FeedbackLiveVideoNewestCommentStreamNeckFragmentModel> {
        final /* synthetic */ LiveCommentsDownloader f2876a;

        C02502(LiveCommentsDownloader liveCommentsDownloader) {
            this.f2876a = liveCommentsDownloader;
        }

        @Nullable
        protected final LiveVideoTopLevelCommentsModel mo123a(Object obj) {
            return ((FeedbackLiveVideoNewestCommentStreamNeckFragmentModel) obj).m3608q();
        }

        @Nullable
        protected final Object mo124b(Object obj) {
            return ((FetchLiveVideoNewestCommentsNeckQueryModel) obj).m3725j();
        }
    }

    /* compiled from: strength */
    class C02513 extends TopLevelCommentsGetter<FetchLiveVideoNewestCommentsHeadQueryModel, FeedbackLiveVideoNewestCommentStreamHeadFragmentModel> {
        final /* synthetic */ LiveCommentsDownloader f2877a;

        C02513(LiveCommentsDownloader liveCommentsDownloader) {
            this.f2877a = liveCommentsDownloader;
        }

        @Nullable
        protected final LiveVideoTopLevelCommentsModel mo123a(Object obj) {
            return ((FeedbackLiveVideoNewestCommentStreamHeadFragmentModel) obj).m3558q();
        }

        @Nullable
        protected final Object mo124b(Object obj) {
            return ((FetchLiveVideoNewestCommentsHeadQueryModel) obj).m3711j();
        }
    }

    /* compiled from: strength */
    class TopLevelCommentsGraphQLCallback<R, F> extends AbstractDisposableFutureCallback<GraphQLResult<R>> {
        final /* synthetic */ LiveCommentsDownloader f2878a;
        private TopLevelCommentsGetter<R, F> f2879b;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected final void m3169a(@javax.annotation.Nullable java.lang.Object r4) {
            /*
            r3 = this;
            r4 = (com.facebook.graphql.executor.GraphQLResult) r4;
            r1 = r3.f2878a;
            monitor-enter(r1);
            r0 = r3.f2878a;	 Catch:{ all -> 0x0024 }
            r0 = r0.f2886l;	 Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0015;
        L_0x000b:
            r0 = r3.f2878a;	 Catch:{ all -> 0x0024 }
            r0 = r0.f2886l;	 Catch:{ all -> 0x0024 }
            r0 = r0.isCancelled();	 Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0017;
        L_0x0015:
            monitor-exit(r1);	 Catch:{ all -> 0x0024 }
        L_0x0016:
            return;
        L_0x0017:
            r0 = r3.f2878a;	 Catch:{ all -> 0x0024 }
            r2 = r3.f2879b;	 Catch:{ all -> 0x0024 }
            r2 = r2.m3160a(r4);	 Catch:{ all -> 0x0024 }
            com.facebook.facecastdisplay.LiveCommentsDownloader.m3171a(r0, r2);	 Catch:{ all -> 0x0024 }
            monitor-exit(r1);	 Catch:{ all -> 0x0024 }
            goto L_0x0016;
        L_0x0024:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0024 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecastdisplay.LiveCommentsDownloader.TopLevelCommentsGraphQLCallback.a(java.lang.Object):void");
        }

        public TopLevelCommentsGraphQLCallback(LiveCommentsDownloader liveCommentsDownloader, TopLevelCommentsGetter<R, F> topLevelCommentsGetter) {
            this.f2878a = liveCommentsDownloader;
            this.f2879b = topLevelCommentsGetter;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected final void m3170a(java.lang.Throwable r7) {
            /*
            r6 = this;
            r0 = 1;
            r2 = r6.f2878a;
            monitor-enter(r2);
            r1 = r6.f2878a;	 Catch:{ all -> 0x0065 }
            r1 = r1.f2886l;	 Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0014;
        L_0x000a:
            r1 = r6.f2878a;	 Catch:{ all -> 0x0065 }
            r1 = r1.f2886l;	 Catch:{ all -> 0x0065 }
            r1 = r1.isCancelled();	 Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0016;
        L_0x0014:
            monitor-exit(r2);	 Catch:{ all -> 0x0065 }
        L_0x0015:
            return;
        L_0x0016:
            r1 = r6.f2878a;	 Catch:{ all -> 0x0065 }
            r3 = r1.f2883i;	 Catch:{ all -> 0x0065 }
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0065 }
            r1.<init>();	 Catch:{ all -> 0x0065 }
            r4 = com.facebook.facecastdisplay.LiveCommentsDownloader.f2880f;	 Catch:{ all -> 0x0065 }
            r1 = r1.append(r4);	 Catch:{ all -> 0x0065 }
            r4 = "_graphFailure";
            r1 = r1.append(r4);	 Catch:{ all -> 0x0065 }
            r4 = r1.toString();	 Catch:{ all -> 0x0065 }
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0065 }
            r5 = "Failed to get live comments for ";
            r1.<init>(r5);	 Catch:{ all -> 0x0065 }
            r5 = r6.f2878a;	 Catch:{ all -> 0x0065 }
            r5 = r5.f2838c;	 Catch:{ all -> 0x0065 }
            r1 = r1.append(r5);	 Catch:{ all -> 0x0065 }
            r1 = r1.toString();	 Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0068;
        L_0x0044:
            r1 = r6.f2878a;	 Catch:{ all -> 0x0065 }
            r1 = r1.f2838c;	 Catch:{ all -> 0x0065 }
        L_0x0048:
            r3.a(r4, r1, r7);	 Catch:{ all -> 0x0065 }
            r1 = r6.f2878a;	 Catch:{ all -> 0x0065 }
            r1 = r1.f2840e;	 Catch:{ all -> 0x0065 }
            if (r1 != 0) goto L_0x006b;
        L_0x0051:
            r1 = r6.f2878a;	 Catch:{ all -> 0x0065 }
            r3 = 1;
            r1.e = r3;	 Catch:{ all -> 0x0065 }
            r1 = r6.f2878a;	 Catch:{ all -> 0x0065 }
            r1 = r1.f2837b;	 Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0063;
        L_0x005c:
            r1 = r6.f2878a;	 Catch:{ all -> 0x0065 }
            r1 = r1.f2837b;	 Catch:{ all -> 0x0065 }
            r1.m3272c(r0);	 Catch:{ all -> 0x0065 }
        L_0x0063:
            monitor-exit(r2);	 Catch:{ all -> 0x0065 }
            goto L_0x0015;
        L_0x0065:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x0065 }
            throw r0;
        L_0x0068:
            r1 = "no story id";
            goto L_0x0048;
        L_0x006b:
            r0 = 0;
            goto L_0x0051;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecastdisplay.LiveCommentsDownloader.TopLevelCommentsGraphQLCallback.a(java.lang.Throwable):void");
        }
    }

    @Inject
    public LiveCommentsDownloader(@Assisted ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor, AbstractFbErrorReporter abstractFbErrorReporter, Clock clock) {
        super(clock);
        this.f2881g = executorService;
        this.f2882h = graphQLQueryExecutor;
        this.f2883i = abstractFbErrorReporter;
    }

    public final synchronized void mo125a(String str) {
        super.mo125a(str);
    }

    private void m3173i() {
        m3172a((TypedGraphQlQueryString) new FetchLiveVideoNewestCommentsInitialQueryString(), new C02491(this));
    }

    public final synchronized void mo119a() {
        super.mo119a();
        if (TextUtils.isEmpty(this.f2838c)) {
            this.f2883i.a(f2880f + "_startFetching", "Tried to fetch without a story id.");
        } else if (TextUtils.isEmpty(this.f2884j)) {
            m3173i();
        } else if (this.f2885k < 0) {
            m3174j();
        } else {
            m3175k();
        }
    }

    public final synchronized void mo120b() {
        if (this.f2886l != null) {
            this.f2886l.cancel(false);
        }
        this.f2885k = 0;
    }

    public final synchronized boolean mo121c() {
        boolean z;
        z = (this.f2886l == null || this.f2886l.isDone()) ? false : true;
        return z;
    }

    public final int hq_() {
        return 3;
    }

    public final LiveEventType mo122d() {
        return LiveEventType.LIVE_COMMENT_EVENT;
    }

    private void m3174j() {
        m3172a((TypedGraphQlQueryString) new FetchLiveVideoNewestCommentsNeckQueryString(), new C02502(this));
    }

    private void m3175k() {
        m3172a((TypedGraphQlQueryString) new FetchLiveVideoNewestCommentsHeadQueryString(), new C02513(this));
    }

    private <R, F> void m3172a(TypedGraphQlQueryString<R> typedGraphQlQueryString, TopLevelCommentsGetter<R, F> topLevelCommentsGetter) {
        typedGraphQlQueryString.a("targetID", this.f2838c);
        typedGraphQlQueryString.a("count", Integer.valueOf(5));
        typedGraphQlQueryString.a("cursor", this.f2884j);
        GraphQLQueryFuture a = this.f2882h.a(GraphQLRequest.a(typedGraphQlQueryString));
        this.f2886l = a;
        Futures.a(a, new TopLevelCommentsGraphQLCallback(this, topLevelCommentsGetter), this.f2881g);
    }

    public static void m3171a(@Nullable LiveCommentsDownloader liveCommentsDownloader, LiveVideoTopLevelCommentsModel liveVideoTopLevelCommentsModel) {
        if (liveVideoTopLevelCommentsModel == null) {
            liveCommentsDownloader.f2883i.a(f2880f + "_parseComments", "Top level comments were null.");
            return;
        }
        DefaultPageInfoFieldsModel k = liveVideoTopLevelCommentsModel.m3863k();
        if (k != null) {
            Object v_ = k.v_();
            if (!TextUtils.isEmpty(v_)) {
                liveCommentsDownloader.f2884j = v_;
            }
        }
        ImmutableList<EdgesModel> j = liveVideoTopLevelCommentsModel.m3862j();
        if (j == null) {
            liveCommentsDownloader.f2883i.a(f2880f + "_parseComments", "Comments were null.");
            return;
        }
        boolean z;
        liveCommentsDownloader.f2885k = 0;
        if (!j.isEmpty()) {
            FeedbackLiveVideoCommentCoreFragmentModel a = ((EdgesModel) j.get(0)).m3854a();
            if (a != null) {
                liveCommentsDownloader.f2885k = liveVideoTopLevelCommentsModel.m3857a() - a.m3529j();
            }
        }
        List linkedList = new LinkedList();
        for (EdgesModel a2 : j) {
            LiveCommentEventModel liveCommentEventModel;
            FeedbackLiveVideoCommentCoreFragmentModel a3 = a2.m3854a();
            if (a3 == null) {
                liveCommentEventModel = null;
            } else {
                liveCommentEventModel = LiveCommentEventModel.m3147a(a3);
            }
            LiveCommentEventModel liveCommentEventModel2 = liveCommentEventModel;
            if (liveCommentEventModel2 != null) {
                linkedList.addFirst(liveCommentEventModel2);
            }
        }
        if (liveCommentsDownloader.f2840e) {
            z = false;
        } else {
            z = true;
        }
        liveCommentsDownloader.e = true;
        if (liveCommentsDownloader.f2837b != null) {
            liveCommentsDownloader.f2837b.m3267a(linkedList, z);
        }
    }
}
