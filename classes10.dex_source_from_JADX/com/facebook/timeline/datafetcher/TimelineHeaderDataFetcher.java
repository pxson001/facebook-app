package com.facebook.timeline.datafetcher;

import android.content.Context;
import android.os.Parcelable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.graphql.calls.RenderLocationInputRenderLocation;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.Assisted;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.datafetcher.TimelineGenericDataFetcher.State;
import com.facebook.timeline.intent.ModelBundleGraphQLInterfaces.ModelBundleProfileGraphQL;
import com.facebook.timeline.logging.TimelinePerformanceLogger;
import com.facebook.timeline.profileprotocol.FetchTimelineHeaderParamsFactory;
import com.facebook.timeline.protocol.FetchTimelineContextItemsGraphQL.TimelineContextItemsQueryString;
import com.facebook.timeline.protocol.FetchTimelineContextItemsGraphQLModels.TimelineContextItemsModel;
import com.facebook.timeline.protocol.FetchTimelineContextItemsGraphQLModels.TimelineContextItemsQueryModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderUserFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.UserTimelineSelfQueryFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderParams;
import com.facebook.timeline.protocol.ResultSource;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: groupInformation is null in sendCancelGroupJoinRequestRequest */
public class TimelineHeaderDataFetcher {
    private TimelineGenericDataFetcher f10521a;
    private final TimelineUserContext f10522b;
    public final TimelineDataFetcher f10523c;
    private final TimelinePerformanceLogger f10524d;
    public final QuickPerformanceLogger f10525e;
    private final TimelineEarlyFetcher f10526f;
    private final FetchTimelineHeaderParamsFactory f10527g;
    private final TimelineHeaderParallelQueryExecutor f10528h;
    private final Provider<TimelineContextItemQueryExecutor> f10529i;
    private final Executor f10530j;
    private final CallerContext f10531k;
    private final Context f10532l;
    private final TimelineGenericDataFetcherProvider f10533m;
    @Nullable
    private FetchTimelineHeaderParams f10534n = null;
    @Nullable
    private TimelineEarlyFetchFutures f10535o;
    public boolean f10536p = false;

    /* compiled from: groupInformation is null in sendCancelGroupJoinRequestRequest */
    class C15361 extends AbstractDisposableFutureCallback<GraphQLResult<? extends Parcelable>> {
        final /* synthetic */ TimelineHeaderDataFetcher f10518a;

        C15361(TimelineHeaderDataFetcher timelineHeaderDataFetcher) {
            this.f10518a = timelineHeaderDataFetcher;
        }

        protected final void m10605a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || !((graphQLResult.e instanceof TimelineHeaderUserFieldsModel) || (graphQLResult.e instanceof UserTimelineSelfQueryFieldsModel))) {
                this.f10518a.f10523c.m10569h();
                return;
            }
            TimelineDataFetcher timelineDataFetcher = this.f10518a.f10523c;
            timelineDataFetcher.f10430a.m10305a(graphQLResult.e, graphQLResult.freshness, ResultSource.fromGraphQLResultDataFreshness(graphQLResult.freshness));
        }

        protected final void m10606a(Throwable th) {
            this.f10518a.f10523c.m10569h();
        }
    }

    @Inject
    public TimelineHeaderDataFetcher(@Assisted Context context, @Assisted ViewCallback viewCallback, @Assisted TimelineUserContext timelineUserContext, @Nullable @Assisted TimelinePerformanceLogger timelinePerformanceLogger, @Nullable @Assisted CallerContext callerContext, QuickPerformanceLogger quickPerformanceLogger, TimelineEarlyFetcher timelineEarlyFetcher, TimelineGenericDataFetcherProvider timelineGenericDataFetcherProvider, FetchTimelineHeaderParamsFactory fetchTimelineHeaderParamsFactory, TimelineHeaderParallelQueryExecutor timelineHeaderParallelQueryExecutor, Provider<TimelineContextItemQueryExecutor> provider, Executor executor) {
        this.f10532l = context;
        this.f10533m = timelineGenericDataFetcherProvider;
        this.f10531k = callerContext;
        this.f10523c = viewCallback;
        this.f10522b = timelineUserContext;
        this.f10524d = timelinePerformanceLogger;
        this.f10525e = quickPerformanceLogger;
        this.f10526f = timelineEarlyFetcher;
        this.f10527g = fetchTimelineHeaderParamsFactory;
        this.f10528h = timelineHeaderParallelQueryExecutor;
        this.f10529i = provider;
        this.f10530j = executor;
    }

    private TimelineGenericDataFetcher m10610h() {
        if (this.f10521a == null) {
            this.f10521a = this.f10533m.m10601a(this.f10532l, new ProfileViewerContext(this.f10522b.b, this.f10522b.a), this.f10531k);
        }
        return this.f10521a;
    }

    public final void m10613a() {
        if (!this.f10536p) {
            m10610h().m10597a();
        }
    }

    public final void m10616b() {
        if (m10610h().f10515j == State.VISIBLE && !m10610h().m10600b()) {
            m10610h().f10515j = State.PAUSED;
        }
    }

    public final void m10617c() {
        if (m10610h().f10515j == State.REFRESH_ON_RESUME) {
            m10614a(1);
        }
        m10610h().f10515j = State.VISIBLE;
    }

    public final void m10618d() {
        m10610h().f10515j = State.REFRESH_ON_RESUME;
    }

    public final TimelineEarlyFetchFutures m10612a(@Nullable TimelineEarlyFetchFutures timelineEarlyFetchFutures, @Nullable ModelBundleProfileGraphQL modelBundleProfileGraphQL, @Nullable CallerContext callerContext) {
        if (this.f10524d != null) {
            this.f10524d.f();
            if (TimelineHeaderParallelQueryExecutor.m10624a(modelBundleProfileGraphQL)) {
                this.f10524d.c.a("TimelineFetchProfilePicUri");
            }
        }
        TimelineEarlyFetchFutures b = m10609b(timelineEarlyFetchFutures, modelBundleProfileGraphQL, callerContext);
        m10610h().m10599a(b.f10453a.f10417b, "timeline_fetch_header");
        this.f10535o = b;
        return b;
    }

    public final boolean m10619f() {
        if (this.f10535o == null) {
            return false;
        }
        GraphQLQueryFuture graphQLQueryFuture = this.f10535o.f10453a.f10416a;
        if (!graphQLQueryFuture.isDone() || graphQLQueryFuture.isCancelled()) {
            return false;
        }
        try {
            GraphQLResult graphQLResult = (GraphQLResult) Uninterruptibles.a(graphQLQueryFuture);
            return (graphQLResult == null || graphQLResult.d() == null) ? false : true;
        } catch (ExecutionException e) {
            return false;
        }
    }

    private TimelineEarlyFetchFutures m10609b(@Nullable TimelineEarlyFetchFutures timelineEarlyFetchFutures, @Nullable ModelBundleProfileGraphQL modelBundleProfileGraphQL, @Nullable CallerContext callerContext) {
        if (timelineEarlyFetchFutures != null) {
            return timelineEarlyFetchFutures;
        }
        FetchTimelineHeaderParams i = m10611i();
        TimelineHeaderParallelQueryExecutor timelineHeaderParallelQueryExecutor = this.f10528h;
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest("TimelineHeader");
        HeaderFetchFutures a = timelineHeaderParallelQueryExecutor.m10627a(graphQLBatchRequest, i, modelBundleProfileGraphQL, callerContext);
        timelineHeaderParallelQueryExecutor.f10540c.a(graphQLBatchRequest);
        timelineHeaderParallelQueryExecutor.m10628a(a);
        return new TimelineEarlyFetchFutures(a, null, null);
    }

    public final void m10614a(int i) {
        ListenableFuture a;
        if (this.f10524d != null) {
            this.f10524d.f();
        }
        if (i == 1) {
            a = this.f10528h.m10626a(m10611i(), GraphQLCachePolicy.d, this.f10531k);
        } else {
            a = this.f10528h.m10626a(m10611i(), GraphQLCachePolicy.b, this.f10531k);
        }
        Futures.a(a, new C15361(this), this.f10530j);
    }

    public final void m10615a(final DisposableFutureCallback<TimelineContextItemsModel> disposableFutureCallback) {
        Enum a;
        TimelineContextItemQueryExecutor timelineContextItemQueryExecutor = (TimelineContextItemQueryExecutor) this.f10529i.get();
        long j = this.f10522b.b;
        Optional optional = this.f10522b.b;
        GraphQlQueryString a2 = new TimelineContextItemsQueryString().a("profile_id", String.valueOf(j));
        String str = "icon_scale";
        if (GraphQlQueryDefaults.a() != null) {
            a = GraphQlQueryDefaults.a();
        } else {
            a = GraphQlQueryDefaults.a;
        }
        GraphQLQueryFuture a3 = timelineContextItemQueryExecutor.f10425a.a(GraphQLRequest.a((TimelineContextItemsQueryString) a2.a(str, a).a("render_location", RenderLocationInputRenderLocation.ANDROID_PROFILE_TILE).a("top_context_item_type", (String) optional.orNull())).a(GraphQLCachePolicy.c));
        m10610h().m10599a(a3, "timeline_fetch_context_items");
        this.f10525e.b(1703978);
        Futures.a(GraphQLQueryExecutor.a(a3), new AbstractDisposableFutureCallback<TimelineContextItemsQueryModel>(this) {
            final /* synthetic */ TimelineHeaderDataFetcher f10520b;

            protected final void m10607a(Object obj) {
                TimelineContextItemsQueryModel timelineContextItemsQueryModel = (TimelineContextItemsQueryModel) obj;
                if (timelineContextItemsQueryModel == null) {
                    m10608a(new NullPointerException("Context items result was null"));
                    return;
                }
                this.f10520b.f10525e.b(1703978, (short) 2);
                disposableFutureCallback.onSuccess(timelineContextItemsQueryModel.a());
            }

            protected final void m10608a(Throwable th) {
                this.f10520b.f10525e.b(1703978, (short) 3);
                disposableFutureCallback.onFailure(th);
            }
        }, this.f10530j);
    }

    public final void m10620g() {
        m10614a(1);
    }

    private FetchTimelineHeaderParams m10611i() {
        if (this.f10534n == null) {
            this.f10534n = this.f10527g.m12095a(this.f10522b.b, this.f10522b.b);
        }
        return this.f10534n;
    }
}
