package com.facebook.feed.protocol;

import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.ufiservices.FetchFeedbackMethod;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.protocol.FetchFeedMethod.FetcherCallback;
import com.facebook.feed.protocol.reaction.FetchReactionStoriesGraphQL.ReactionAttachmentsQueryString;
import com.facebook.feed.protocol.reaction.FetchReactionStoriesGraphQLModels.ReactionAttachmentsResultModel;
import com.facebook.feed.protocol.reaction.FetchReactionStoriesGraphQLModels.ReactionAttachmentsResultModel.ReactionAttachmentsModel;
import com.facebook.feed.protocol.reaction.FetchReactionStoriesGraphQLModels.ReactionAttachmentsResultModel.ReactionAttachmentsModel.EdgesModel;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLFeedHomeStories;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.perf.StartupPerfLogger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: minutiae_action */
public class FetchReactionFeedMethod extends FetchFeedMethod {
    private final GraphQLImageHelper f10325e;
    private final FetchFeedQueryUtil f10326f;

    public static FetchReactionFeedMethod m16281b(InjectorLike injectorLike) {
        return new FetchReactionFeedMethod(GraphQLProtocolHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), StartupPerfLogger.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), GraphQLImageHelper.a(injectorLike), FetchFeedQueryUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FetchFeedbackMethod.b(injectorLike));
    }

    public final /* synthetic */ GraphQlQueryString m16290f(Object obj) {
        return m16282e((FetchFeedParams) obj);
    }

    @Inject
    public FetchReactionFeedMethod(GraphQLProtocolHelper graphQLProtocolHelper, AbstractFbErrorReporter abstractFbErrorReporter, StartupPerfLogger startupPerfLogger, Clock clock, MonotonicClock monotonicClock, GraphQLImageHelper graphQLImageHelper, FetchFeedQueryUtil fetchFeedQueryUtil, QeAccessor qeAccessor, FetchFeedbackMethod fetchFeedbackMethod) {
        super(graphQLProtocolHelper, abstractFbErrorReporter, startupPerfLogger, clock, monotonicClock, qeAccessor, fetchFeedbackMethod);
        this.f10325e = graphQLImageHelper;
        this.f10326f = fetchFeedQueryUtil;
    }

    protected final String m16287c() {
        return "reaction_feed";
    }

    protected final String m16288c(FetchFeedParams fetchFeedParams) {
        return "ReactionFeedNetworkTime";
    }

    protected final int m16289d(FetchFeedParams fetchFeedParams) {
        return 655499;
    }

    public final int m16286b(Object obj, ApiResponse apiResponse) {
        return 1;
    }

    protected final GraphQLFeedHomeStories m16285a(FetchFeedParams fetchFeedParams, JsonParser jsonParser) {
        return m16280a((ReactionAttachmentsResultModel) this.b.a(jsonParser, ReactionAttachmentsResultModel.class, "fetch_reaction_attachments"));
    }

    public final GraphQLBatchRequest m16283a(FetchFeedParams fetchFeedParams, String str, FetcherCallback fetcherCallback) {
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest(str + "_single");
        graphQLBatchRequest.a(GraphQLRequest.a(m16282e(fetchFeedParams), ReactionAttachmentsResultModel.class)).a(fetcherCallback.a("feed_subscriber"));
        return graphQLBatchRequest;
    }

    private GraphQLFeedHomeStories m16280a(ReactionAttachmentsResultModel reactionAttachmentsResultModel) {
        Builder builder = ImmutableList.builder();
        ReactionAttachmentsModel a = reactionAttachmentsResultModel.m16522a();
        ImmutableList a2 = a.m16518a();
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            EdgesModel edgesModel = (EdgesModel) a2.get(i);
            GraphQLStory.Builder a3 = GraphQLStory.Builder.a(edgesModel.m16512a().m16508a());
            String padStart = Strings.padStart(Integer.toString(1000000000 - Integer.parseInt(edgesModel.m16514j())), 10, '#');
            GraphQLFeedUnitEdge.Builder builder2 = new GraphQLFeedUnitEdge.Builder();
            builder2.i = a3.a();
            GraphQLFeedUnitEdge.Builder builder3 = builder2;
            builder3.f = null;
            builder3 = builder3;
            builder3.k = padStart;
            GraphQLFeedUnitEdge.Builder builder4 = builder3;
            builder4.e = null;
            builder.c(builder4.a());
        }
        DefaultPageInfoFieldsModel j = a.m16519j();
        GraphQLPageInfo.Builder builder5 = new GraphQLPageInfo.Builder();
        builder5.h = j.v_();
        builder5 = builder5;
        builder5.e = j.a();
        builder5 = builder5;
        builder5.g = j.c();
        builder5 = builder5;
        builder5.f = j.b();
        GraphQLPageInfo a4 = builder5.a();
        GraphQLFeedHomeStories.Builder builder6 = new GraphQLFeedHomeStories.Builder();
        builder6.f = builder.b();
        builder6 = builder6;
        builder6.i = a4;
        return builder6.a();
    }

    public final GraphQLFeedHomeStories m16284a(FetchFeedParams fetchFeedParams, GraphQLResult graphQLResult) {
        Object obj = graphQLResult.e;
        if (obj instanceof ReactionAttachmentsResultModel) {
            return m16280a((ReactionAttachmentsResultModel) obj);
        }
        throw new RuntimeException("Unrecognized GraphQLResult:" + graphQLResult.toString());
    }

    private GraphQlQueryString m16282e(FetchFeedParams fetchFeedParams) {
        GraphQlQueryString reactionAttachmentsQueryString = new ReactionAttachmentsQueryString();
        this.f10326f.a(reactionAttachmentsQueryString);
        FetchFeedQueryUtil.a(reactionAttachmentsQueryString, fetchFeedParams, null, "after_cursor");
        this.f10326f.b(reactionAttachmentsQueryString);
        this.f10326f.c(reactionAttachmentsQueryString);
        FetchFeedQueryUtil.d(reactionAttachmentsQueryString);
        reactionAttachmentsQueryString.a("media_type", this.f10325e.a());
        if (fetchFeedParams != null) {
            reactionAttachmentsQueryString.a("reaction_story_id", fetchFeedParams.b.a()).a("result_count", Integer.toString(fetchFeedParams.c));
        }
        return reactionAttachmentsQueryString;
    }
}
