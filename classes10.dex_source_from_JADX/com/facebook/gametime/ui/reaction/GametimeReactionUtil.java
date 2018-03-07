package com.facebook.gametime.ui.reaction;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQL.GametimeDashboardReactionTailLoadQueryString;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQL.GametimeReactionHeadLoadQueryString;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQL.GametimeReactionTailLoadQueryString;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeDashboardReactionTailLoadFragmentModel;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeReactionHeadLoadFragmentModel;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeReactionTailLoadFragmentModel;
import com.facebook.graphql.calls.GametimeReactionUnitsInputTriggerData;
import com.facebook.graphql.calls.GametimeReactionUnitsInputTriggerData.ReactionContext;
import com.facebook.graphql.calls.GametimeReactionUnitsInputTriggerData.ReactionContext.RequestType;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.event.ReactionEventBus;
import com.facebook.reaction.event.ReactionFetchEvents.InvalidResponseEvent;
import com.facebook.reaction.event.ReactionFetchEvents.ReactionRequestEvent;
import com.facebook.reaction.event.ReactionFetchEvents.ReactionResultEvent;
import com.facebook.reaction.event.ReactionFetchEvents.RequestNonCancellationFailureEvent;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.ui.futures.TasksManager;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: {source unknown} */
public class GametimeReactionUtil {
    public final Clock f33a;
    public final GraphQLQueryExecutor f34b;
    public final ReactionEventBus f35c;
    public final ReactionSessionManager f36d;
    public final ReactionUtil f37e;
    public final TasksManager<String> f38f;

    /* compiled from: {source unknown} */
    public class C00032 implements Runnable {
        final /* synthetic */ String f27a;
        final /* synthetic */ Surface f28b;
        final /* synthetic */ GametimeReactionUtil f29c;

        public C00032(GametimeReactionUtil gametimeReactionUtil, String str, Surface surface) {
            this.f29c = gametimeReactionUtil;
            this.f27a = str;
            this.f28b = surface;
        }

        public void run() {
            GametimeReactionUtil gametimeReactionUtil = this.f29c;
            String str = this.f27a;
            Surface surface = this.f28b;
            GraphQlQueryString gametimeDashboardReactionTailLoadQueryString = new GametimeDashboardReactionTailLoadQueryString();
            gametimeReactionUtil.f37e.a(gametimeDashboardReactionTailLoadQueryString, surface);
            ReactionUtil reactionUtil = gametimeReactionUtil.f37e;
            ReactionContext.Surface valueOf = ReactionContext.Surface.valueOf(surface.toString());
            RequestType requestType = RequestType.NORMAL;
            ReactionContext reactionContext = new ReactionContext();
            reactionContext.a("request_type", requestType);
            GraphQlCallInput graphQlCallInput = reactionContext;
            graphQlCallInput.a("surface", valueOf);
            GraphQlCallInput graphQlCallInput2 = graphQlCallInput;
            graphQlCallInput2.a("session_id", str);
            graphQlCallInput2 = graphQlCallInput2;
            graphQlCallInput2.a("unit_styles", reactionUtil.i);
            graphQlCallInput2 = graphQlCallInput2;
            graphQlCallInput2.a("story_header_styles", reactionUtil.t);
            graphQlCallInput2 = graphQlCallInput2;
            graphQlCallInput2.a("story_attachment_styles", reactionUtil.l.a());
            graphQlCallInput2 = graphQlCallInput2;
            graphQlCallInput2.a("action_styles", reactionUtil.r.a(surface));
            graphQlCallInput2 = graphQlCallInput2;
            graphQlCallInput2.a("component_styles", reactionUtil.w.a());
            graphQlCallInput2 = graphQlCallInput2;
            GametimeReactionUnitsInputTriggerData gametimeReactionUnitsInputTriggerData = new GametimeReactionUnitsInputTriggerData();
            gametimeReactionUnitsInputTriggerData.a("reaction_context", graphQlCallInput2);
            gametimeDashboardReactionTailLoadQueryString.a("afterCursor", null).a("count", Integer.valueOf(10)).a("trigger_data", gametimeReactionUnitsInputTriggerData);
            gametimeReactionUtil.f38f.a(str, gametimeReactionUtil.f34b.a(GraphQLRequest.a(gametimeDashboardReactionTailLoadQueryString).a(GraphQLCachePolicy.c)), new GametimeSuccessCallback(gametimeReactionUtil, str));
            gametimeReactionUtil.f35c.a(new ReactionRequestEvent(str, null));
        }
    }

    /* compiled from: {source unknown} */
    public class GametimeSuccessCallback<T> extends AbstractDisposableFutureCallback<GraphQLResult<T>> {
        final /* synthetic */ GametimeReactionUtil f30a;
        private String f31b;
        private long f32c;

        protected final void m15a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            ReactionStories reactionStories = null;
            if (graphQLResult.e instanceof GametimeReactionTailLoadFragmentModel) {
                reactionStories = ((GametimeReactionTailLoadFragmentModel) graphQLResult.e).a();
            } else if (graphQLResult.e instanceof GametimeReactionHeadLoadFragmentModel) {
                reactionStories = ((GametimeReactionHeadLoadFragmentModel) graphQLResult.e).a();
            } else if (graphQLResult.e instanceof GametimeDashboardReactionTailLoadFragmentModel) {
                reactionStories = ((GametimeDashboardReactionTailLoadFragmentModel) graphQLResult.e).a();
            }
            if (reactionStories == null) {
                this.f30a.f35c.a(new InvalidResponseEvent("ERROR_INVALID_RESPONSE", this.f31b));
            } else if (reactionStories.a().isEmpty()) {
                this.f30a.f35c.a(new InvalidResponseEvent("NO_UNITS_RETURNED", this.f31b));
            } else {
                this.f30a.f35c.a(new ReactionResultEvent(reactionStories, this.f31b, graphQLResult.clientTimeMs - this.f32c, this.f32c));
            }
        }

        public GametimeSuccessCallback(GametimeReactionUtil gametimeReactionUtil, String str) {
            this.f30a = gametimeReactionUtil;
            this.f31b = str;
            this.f32c = gametimeReactionUtil.f33a.a();
        }

        protected final void m16a(Throwable th) {
            this.f30a.f35c.a(new RequestNonCancellationFailureEvent(th, this.f31b));
        }
    }

    /* compiled from: {source unknown} */
    public enum LoadType {
        HEAD_LOAD,
        TAIL_LOAD
    }

    public static GametimeReactionUtil m17b(InjectorLike injectorLike) {
        return new GametimeReactionUtil((Clock) SystemClockMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), ReactionEventBus.a(injectorLike), ReactionSessionManager.a(injectorLike), ReactionUtil.a(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public GametimeReactionUtil(Clock clock, GraphQLQueryExecutor graphQLQueryExecutor, ReactionEventBus reactionEventBus, ReactionSessionManager reactionSessionManager, ReactionUtil reactionUtil, TasksManager tasksManager) {
        this.f33a = clock;
        this.f34b = graphQLQueryExecutor;
        this.f35c = reactionEventBus;
        this.f36d = reactionSessionManager;
        this.f37e = reactionUtil;
        this.f38f = tasksManager;
    }

    public final ReactionSession m19a(Surface surface, String str, LoadType loadType) {
        final String uuid = SafeUUIDGenerator.a().toString();
        ReactionSession a = this.f36d.a(uuid, surface);
        final String str2 = str;
        final Surface surface2 = surface;
        final LoadType loadType2 = loadType;
        a.A = new Runnable(this) {
            final /* synthetic */ GametimeReactionUtil f26e;

            public void run() {
                this.f26e.m20a(str2, uuid, surface2, loadType2, null, null);
            }
        };
        this.f36d.c(uuid);
        this.f36d.d(uuid);
        m20a(str, uuid, surface, loadType, null, null);
        return a;
    }

    public final void m20a(String str, String str2, Surface surface, LoadType loadType, @Nullable String str3, @Nullable String str4) {
        if (loadType == LoadType.HEAD_LOAD) {
            GraphQlQueryString gametimeReactionHeadLoadQueryString = new GametimeReactionHeadLoadQueryString();
            this.f37e.a(gametimeReactionHeadLoadQueryString, surface);
            gametimeReactionHeadLoadQueryString.a("beforeCursor", str4).a("count", Integer.valueOf(10)).a("trigger_data", this.f37e.a(surface, str, str2));
            this.f38f.a(str2, this.f34b.a(GraphQLRequest.a(gametimeReactionHeadLoadQueryString).a(GraphQLCachePolicy.c)), new GametimeSuccessCallback(this, str2));
            this.f35c.a(new ReactionRequestEvent(str2, null));
            return;
        }
        m18b(str3, str, str2, surface);
    }

    private void m18b(@Nullable String str, String str2, String str3, Surface surface) {
        GraphQlQueryString gametimeReactionTailLoadQueryString = new GametimeReactionTailLoadQueryString();
        this.f37e.a(gametimeReactionTailLoadQueryString, surface);
        gametimeReactionTailLoadQueryString.a("afterCursor", str).a("count", Integer.valueOf(10)).a("trigger_data", this.f37e.a(surface, str2, str3));
        this.f38f.a(str3, this.f34b.a(GraphQLRequest.a(gametimeReactionTailLoadQueryString).a(GraphQLCachePolicy.c)), new GametimeSuccessCallback(this, str3));
        this.f35c.a(new ReactionRequestEvent(str3, null));
    }
}
