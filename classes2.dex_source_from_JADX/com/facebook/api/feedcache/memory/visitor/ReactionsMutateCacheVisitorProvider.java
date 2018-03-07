package com.facebook.api.feedcache.memory.visitor;

import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsMutationFragmentModel;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: saved_collection_ego_imp */
public class ReactionsMutateCacheVisitorProvider extends AbstractAssistedProvider<ReactionsMutateCacheVisitor> {
    public final ReactionsMutateCacheVisitor m10378a(ViewerReactionsMutationFragmentModel viewerReactionsMutationFragmentModel, String str) {
        return new ReactionsMutateCacheVisitor(FeedbackMutator.m10618a((InjectorLike) this), GraphQLActorCacheImpl.m14532a(this), viewerReactionsMutationFragmentModel, str);
    }
}
