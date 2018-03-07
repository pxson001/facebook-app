package com.facebook.api.feedcache.memory.visitor;

import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsMutationFragmentModel.Builder;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsMutationFragmentModel.FeedbackModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsMutationFragmentModel.FeedbackModel.LikersModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsMutationFragmentModel.FeedbackModel.ReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsMutationFragmentModel.FeedbackModel.ViewerFeedbackReactionModel;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.feedback.reactions.util.ReactionsModelConversionHelper;
import com.facebook.graphql.executor.GraphQLCacheAggregator;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: saved_collection_save_button_imp */
public class ReactionsMutateCacheVisitorHelper {
    private final ReactionsMutateCacheVisitorProvider f6177a;
    private final GraphQLCacheAggregator f6178b;
    private final DefaultAndroidThreadUtil f6179c;

    public static ReactionsMutateCacheVisitorHelper m10376b(InjectorLike injectorLike) {
        return new ReactionsMutateCacheVisitorHelper((ReactionsMutateCacheVisitorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionsMutateCacheVisitorProvider.class), GraphQLCacheAggregator.m10380b(injectorLike), DefaultAndroidThreadUtil.m1646b(injectorLike));
    }

    @Inject
    public ReactionsMutateCacheVisitorHelper(ReactionsMutateCacheVisitorProvider reactionsMutateCacheVisitorProvider, GraphQLCacheAggregator graphQLCacheAggregator, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f6177a = reactionsMutateCacheVisitorProvider;
        this.f6178b = graphQLCacheAggregator;
        this.f6179c = defaultAndroidThreadUtil;
    }

    public final void m10377a(GraphQLFeedback graphQLFeedback) {
        Object obj;
        this.f6179c.m1655b();
        if (graphQLFeedback == null || graphQLFeedback.m23211E() == null || graphQLFeedback.m23209C() == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            ReactionsMutateCacheVisitorProvider reactionsMutateCacheVisitorProvider = this.f6177a;
            Builder builder = new Builder();
            FeedbackModel.Builder builder2 = new FeedbackModel.Builder();
            builder2.a = graphQLFeedback.z_();
            builder2 = builder2;
            builder2.c = graphQLFeedback.mo2933j();
            builder2 = builder2;
            ViewerFeedbackReactionModel.Builder builder3 = new ViewerFeedbackReactionModel.Builder();
            builder3.a = graphQLFeedback.m23225S();
            builder2.h = builder3.a();
            builder2 = builder2;
            builder2.f = ReactionsModelConversionHelper.a(graphQLFeedback.m23219M());
            builder2 = builder2;
            LikersModel.Builder builder4 = new LikersModel.Builder();
            builder4.a = graphQLFeedback.m23209C().mo2914a();
            builder2.d = builder4.a();
            builder2 = builder2;
            ReactorsModel.Builder builder5 = new ReactorsModel.Builder();
            builder5.a = graphQLFeedback.m23211E().m22671a();
            builder2.e = builder5.a();
            builder.a = builder2.a();
            this.f6178b.m10384a(reactionsMutateCacheVisitorProvider.m10378a(builder.a(), graphQLFeedback.mo2933j()));
        }
    }

    public static ReactionsMutateCacheVisitorHelper m10375a(InjectorLike injectorLike) {
        return m10376b(injectorLike);
    }
}
