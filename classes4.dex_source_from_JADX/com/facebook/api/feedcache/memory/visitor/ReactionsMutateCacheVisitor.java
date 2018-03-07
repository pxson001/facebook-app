package com.facebook.api.feedcache.memory.visitor;

import com.facebook.api.graphql.reactions.ReactionsGraphQLModels$ViewerReactionsMutationFragmentModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels$ViewerReactionsMutationFragmentModel.FeedbackModel;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.graphql.model.ConsistentFeedbackTopReactionsConnection;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLFeedback.FeedbackExtra;
import com.facebook.graphql.model.GraphQLTopReactionsConnection;
import com.facebook.graphql.model.mutator.GraphQLFeedbackMutator;
import com.facebook.inject.Assisted;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: rtt_low */
public class ReactionsMutateCacheVisitor extends PayloadVisitor<ReactionsGraphQLModels$ViewerReactionsMutationFragmentModel> {
    private final FeedbackMutator f3023a;
    private final GraphQLActorCacheImpl f3024b;

    public final GraphQLFeedback mo267a(GraphQLFeedback graphQLFeedback) {
        FeedbackModel a = ((ReactionsGraphQLModels$ViewerReactionsMutationFragmentModel) this.f3025a).m12480a();
        if (graphQLFeedback == null || graphQLFeedback.z_() == null || !graphQLFeedback.z_().equals(a.m3331j())) {
            return graphQLFeedback;
        }
        GraphQLFeedback a2 = this.f3023a.a(this.f3024b.a(), graphQLFeedback, a);
        Preconditions.checkNotNull(a2);
        GraphQLFeedbackMutator graphQLFeedbackMutator = new GraphQLFeedbackMutator(a2);
        GraphQLTopReactionsConnection M = a2.M();
        GraphQLFeedback graphQLFeedback2 = graphQLFeedbackMutator.f3163a;
        ConsistentFeedbackTopReactionsConnection consistentFeedbackTopReactionsConnection = new ConsistentFeedbackTopReactionsConnection();
        consistentFeedbackTopReactionsConnection.f3164a = M;
        ConsistentFeedbackTopReactionsConnection consistentFeedbackTopReactionsConnection2 = consistentFeedbackTopReactionsConnection;
        FeedbackExtra Y = graphQLFeedback2.Y();
        if (consistentFeedbackTopReactionsConnection2 != Y.a) {
            Y.a = consistentFeedbackTopReactionsConnection2;
            Y.c();
        }
        return graphQLFeedbackMutator.f3163a;
    }

    @Inject
    public ReactionsMutateCacheVisitor(FeedbackMutator feedbackMutator, GraphQLActorCacheImpl graphQLActorCacheImpl, @Assisted ReactionsGraphQLModels$ViewerReactionsMutationFragmentModel reactionsGraphQLModels$ViewerReactionsMutationFragmentModel, @Assisted String str) {
        super(str, reactionsGraphQLModels$ViewerReactionsMutationFragmentModel);
        this.f3023a = feedbackMutator;
        this.f3024b = graphQLActorCacheImpl;
    }
}
