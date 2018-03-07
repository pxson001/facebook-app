package com.facebook.ufiservices.data;

import android.content.Context;
import com.facebook.api.graphql.reactions.FetchReactorsGraphQL.FeedbackReactorsString;
import com.facebook.api.story.FetchSingleStoryParams;
import com.facebook.api.ufiservices.FetchCommentsMethod;
import com.facebook.api.ufiservices.FetchFeedbackMethod;
import com.facebook.api.ufiservices.FetchPagesYouCanActMethod;
import com.facebook.api.ufiservices.FetchReactorsMethod;
import com.facebook.api.ufiservices.FetchSingleCommentMethod;
import com.facebook.api.ufiservices.FetchSingleCommentParams.Builder;
import com.facebook.api.ufiservices.FetchSingleMediaMethod;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.api.ufiservices.common.FetchFeedbackParams;
import com.facebook.api.ufiservices.common.FetchReactionsParams;
import com.facebook.api.ufiservices.common.FetchSingleMediaParams;
import com.facebook.api.ufiservices.common.FetchSingleMediaParams.FetchType;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.protocol.FetchGraphQLStoryMethod;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLBatchRequestProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.RequestObservable;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLCommentHelper;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ufiperf.perf.UfiPerfUtil;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: platform_upload_staging_resource_photos_params */
public class FeedbackLoader {
    private static final MediaToFeedback f4534a = new MediaToFeedback();
    private static FeedbackLoader f4535n;
    private static final Object f4536o = new Object();
    private FetchFeedbackMethod f4537b;
    private FetchPagesYouCanActMethod f4538c;
    private FetchReactorsMethod f4539d;
    private FetchSingleMediaMethod f4540e;
    public FetchCommentsMethod f4541f;
    private FetchSingleCommentMethod f4542g;
    private FetchGraphQLStoryMethod f4543h;
    public GraphQLQueryExecutor f4544i;
    private UfiPerfUtil f4545j;
    private DefaultFeedbackCacheProvider f4546k;
    private GraphQLBatchRequestProvider f4547l;
    public FeedbackMutator f4548m;

    /* compiled from: platform_upload_staging_resource_photos_params */
    class MediaToFeedback implements Function<GraphQLMedia, GraphQLFeedback> {
        public Object apply(Object obj) {
            GraphQLMedia graphQLMedia = (GraphQLMedia) obj;
            if (graphQLMedia == null) {
                return null;
            }
            return graphQLMedia.I();
        }
    }

    private static FeedbackLoader m5047b(InjectorLike injectorLike) {
        return new FeedbackLoader(FetchFeedbackMethod.b(injectorLike), FetchReactorsMethod.m5060b(injectorLike), FetchCommentsMethod.m5062b(injectorLike), FetchPagesYouCanActMethod.m5064a(injectorLike), FetchSingleCommentMethod.m5065b(injectorLike), FetchSingleMediaMethod.m5067b(injectorLike), FetchGraphQLStoryMethod.m5070b(injectorLike), GraphQLQueryExecutor.a(injectorLike), UfiPerfUtil.a(injectorLike), DefaultFeedbackCacheProvider.m5091a(injectorLike), (GraphQLBatchRequestProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GraphQLBatchRequestProvider.class), FeedbackMutator.a(injectorLike));
    }

    public static FeedbackLoader m5046a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedbackLoader b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4536o) {
                FeedbackLoader feedbackLoader;
                if (a2 != null) {
                    feedbackLoader = (FeedbackLoader) a2.a(f4536o);
                } else {
                    feedbackLoader = f4535n;
                }
                if (feedbackLoader == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5047b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4536o, b3);
                        } else {
                            f4535n = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = feedbackLoader;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FeedbackLoader(FetchFeedbackMethod fetchFeedbackMethod, FetchReactorsMethod fetchReactorsMethod, FetchCommentsMethod fetchCommentsMethod, FetchPagesYouCanActMethod fetchPagesYouCanActMethod, FetchSingleCommentMethod fetchSingleCommentMethod, FetchSingleMediaMethod fetchSingleMediaMethod, FetchGraphQLStoryMethod fetchGraphQLStoryMethod, GraphQLQueryExecutor graphQLQueryExecutor, UfiPerfUtil ufiPerfUtil, DefaultFeedbackCacheProvider defaultFeedbackCacheProvider, GraphQLBatchRequestProvider graphQLBatchRequestProvider, FeedbackMutator feedbackMutator) {
        this.f4537b = fetchFeedbackMethod;
        this.f4539d = fetchReactorsMethod;
        this.f4541f = fetchCommentsMethod;
        this.f4538c = fetchPagesYouCanActMethod;
        this.f4544i = graphQLQueryExecutor;
        this.f4545j = ufiPerfUtil;
        this.f4542g = fetchSingleCommentMethod;
        this.f4540e = fetchSingleMediaMethod;
        this.f4543h = fetchGraphQLStoryMethod;
        this.f4546k = defaultFeedbackCacheProvider;
        this.f4547l = graphQLBatchRequestProvider;
        this.f4548m = feedbackMutator;
    }

    public final ListenableFuture<GraphQLFeedback> m5052a(String str, DataFreshnessParam dataFreshnessParam, CommentOrderType commentOrderType, boolean z, String str2, boolean z2, CallerContext callerContext) {
        return m5053a(str, dataFreshnessParam, commentOrderType, z, str2, z2, callerContext, null);
    }

    public final ListenableFuture<GraphQLFeedback> m5053a(String str, DataFreshnessParam dataFreshnessParam, CommentOrderType commentOrderType, boolean z, String str2, boolean z2, CallerContext callerContext, @Nullable ViewerContext viewerContext) {
        if (Strings.isNullOrEmpty(str)) {
            return null;
        }
        if (dataFreshnessParam == DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA) {
            this.f4545j.b();
        }
        FetchFeedbackParams fetchFeedbackParams = new FetchFeedbackParams(str, 25, dataFreshnessParam, commentOrderType, z, str2, z2);
        if (dataFreshnessParam == DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA) {
            this.f4545j.c();
        }
        GraphQLRequest a = this.f4537b.a(fetchFeedbackParams).a(callerContext);
        if (viewerContext != null) {
            a.a(viewerContext);
        }
        return GraphQLQueryExecutor.a(this.f4544i.a(a));
    }

    public final ListenableFuture<GraphQLFeedback> m5051a(String str, CommentOrderType commentOrderType, RequestPriority requestPriority, CallerContext callerContext) {
        GraphQLRequest a = m5045a(str, commentOrderType, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, requestPriority, callerContext);
        return a == null ? null : Futures.a(GraphQLQueryExecutor.a(this.f4544i.a(a)), f4534a, MoreExecutors.a());
    }

    public final ListenableFuture<OperationResult> m5054a(String str, DataFreshnessParam dataFreshnessParam, RequestPriority requestPriority, CallerContext callerContext) {
        GraphQLRequest a = m5045a(str, CommentOrderType.DEFAULT_ORDER, dataFreshnessParam, requestPriority, callerContext);
        if (a == null) {
            return null;
        }
        this.f4545j.a.d(3735569, "Flyout_NetworkTimePhotoId");
        return GraphQLQueryExecutor.a(this.f4544i.a(a));
    }

    private GraphQLRequest<GraphQLMedia> m5045a(String str, CommentOrderType commentOrderType, DataFreshnessParam dataFreshnessParam, RequestPriority requestPriority, CallerContext callerContext) {
        if (Strings.isNullOrEmpty(str)) {
            return null;
        }
        GraphQLRequest<GraphQLMedia> a = this.f4540e.m5068a(new FetchSingleMediaParams(str, 25, FetchType.COMPLETE, dataFreshnessParam, commentOrderType), this.f4546k).a(requestPriority);
        a.f = callerContext;
        return a;
    }

    public final ListenableFuture<GraphQLFeedback> m5055a(String str, FeedbackReaction feedbackReaction, @Nullable String str2, int i, DataFreshnessParam dataFreshnessParam, @Nullable CallerContext callerContext) {
        return GraphQLQueryExecutor.a(this.f4544i.a(this.f4539d.m5061a(new FeedbackReactorsString(), new FetchReactionsParams(str, feedbackReaction, i, null, str2, dataFreshnessParam), callerContext)));
    }

    public final ListenableFuture<GraphQLComment> m5058a(String str, String str2, String str3, boolean z, boolean z2) {
        Builder builder = new Builder();
        builder.a = str2;
        builder = builder;
        builder.g = str3;
        builder = builder;
        builder.b = str;
        builder = builder;
        builder.c = 25;
        builder = builder;
        builder.f = z;
        builder = builder;
        builder.k = z2;
        return GraphQLQueryExecutor.a(this.f4544i.a(this.f4542g.m5066a(builder.a())));
    }

    public final ListenableFuture<GraphQLResult<GraphQLStory>> m5050a(String str, FetchSingleStoryParams.FetchType fetchType, DataFreshnessParam dataFreshnessParam) {
        return m5056a(str, null, fetchType, dataFreshnessParam, CommentOrderType.DEFAULT_ORDER, false);
    }

    public final ListenableFuture<GraphQLResult<GraphQLStory>> m5056a(String str, String str2, FetchSingleStoryParams.FetchType fetchType, DataFreshnessParam dataFreshnessParam, CommentOrderType commentOrderType, boolean z) {
        return m5057a(str, str2, fetchType, dataFreshnessParam, null, commentOrderType, z);
    }

    public final ListenableFuture<GraphQLResult<GraphQLStory>> m5057a(String str, String str2, FetchSingleStoryParams.FetchType fetchType, DataFreshnessParam dataFreshnessParam, @Nullable String str3, CommentOrderType commentOrderType, boolean z) {
        return this.f4544i.a(this.f4543h.m5073a(new FetchSingleStoryParams(str, dataFreshnessParam, fetchType, 25, str3, commentOrderType, str2, z), str3, this.f4546k));
    }

    public final GraphQLStory m5048a(@Nullable String str, FetchSingleStoryParams.FetchType fetchType, @Nullable String str2, CommentOrderType commentOrderType, boolean z) {
        GraphQLResult b;
        try {
            b = this.f4544i.b(this.f4543h.m5072a(new FetchSingleStoryParams(str, DataFreshnessParam.DO_NOT_CHECK_SERVER, fetchType, 25, str2, commentOrderType, null, z)));
        } catch (Throwable e) {
            BLog.a(FeedbackLoader.class, "Feedback cache query failed", e);
            b = null;
        }
        if (b != null) {
            return (GraphQLStory) b.d();
        }
        return null;
    }

    public final ListenableFuture<GraphQLFeedback> m5049a(GraphQLFeedback graphQLFeedback) {
        SettableFuture f = SettableFuture.f();
        1 1 = new 1(this, graphQLFeedback, f);
        GraphQLBatchRequest a = GraphQLBatchRequestProvider.a("FetchInterestingReplies");
        List arrayList = new ArrayList();
        ImmutableList i = GraphQLHelper.i(graphQLFeedback);
        int size = i.size();
        for (int i2 = 0; i2 < size; i2++) {
            GraphQLComment graphQLComment = (GraphQLComment) i.get(i2);
            if (GraphQLCommentHelper.k(graphQLComment)) {
                arrayList.add(a.a(this.f4537b.a(m5044a(graphQLComment, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA))));
            }
        }
        if (a.k.size() == 0) {
            FutureDetour.a(f, graphQLFeedback, -1316034325);
        } else {
            RequestObservable.a(arrayList).a(1);
            this.f4544i.a(a);
        }
        return f;
    }

    public final ListenableFuture<GraphQLFeedback> m5059b(GraphQLFeedback graphQLFeedback) {
        SettableFuture f = SettableFuture.f();
        Iterable arrayList = new ArrayList();
        ImmutableList i = GraphQLHelper.i(graphQLFeedback);
        int size = i.size();
        for (int i2 = 0; i2 < size; i2++) {
            GraphQLComment graphQLComment = (GraphQLComment) i.get(i2);
            if (GraphQLCommentHelper.k(graphQLComment)) {
                arrayList.add(GraphQLQueryExecutor.a(this.f4544i.a(this.f4537b.a(m5044a(graphQLComment, DataFreshnessParam.DO_NOT_CHECK_SERVER)))));
            }
        }
        if (arrayList.size() == 0) {
            FutureDetour.a(f, graphQLFeedback, -826808624);
        } else {
            Futures.a(Futures.b(arrayList), new 2(this, graphQLFeedback, f), DirectExecutor.INSTANCE);
        }
        return f;
    }

    private static FetchFeedbackParams m5044a(GraphQLComment graphQLComment, DataFreshnessParam dataFreshnessParam) {
        return new FetchFeedbackParams(graphQLComment.l().z_(), 1, dataFreshnessParam, CommentOrderType.DEFAULT_ORDER, ((GraphQLComment) graphQLComment.z().j().get(0)).y());
    }
}
