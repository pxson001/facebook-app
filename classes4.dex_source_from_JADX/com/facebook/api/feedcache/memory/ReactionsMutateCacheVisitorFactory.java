package com.facebook.api.feedcache.memory;

import com.facebook.api.feedcache.memory.visitor.ReactionsMutateCacheVisitorProvider;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels$ViewerReactionsMutationFragmentModel;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.executor.iface.CustomMutationVisitorFactory;
import javax.inject.Inject;

/* compiled from: feed_hide_story */
public class ReactionsMutateCacheVisitorFactory implements CustomMutationVisitorFactory<ReactionsGraphQLModels$ViewerReactionsMutationFragmentModel> {
    private final ReactionsMutateCacheVisitorProvider f11879a;

    public final CacheVisitor mo882a(Object obj) {
        ReactionsGraphQLModels$ViewerReactionsMutationFragmentModel reactionsGraphQLModels$ViewerReactionsMutationFragmentModel = (ReactionsGraphQLModels$ViewerReactionsMutationFragmentModel) obj;
        return this.f11879a.a(reactionsGraphQLModels$ViewerReactionsMutationFragmentModel, reactionsGraphQLModels$ViewerReactionsMutationFragmentModel.m12480a().m3332k());
    }

    @Inject
    public ReactionsMutateCacheVisitorFactory(ReactionsMutateCacheVisitorProvider reactionsMutateCacheVisitorProvider) {
        this.f11879a = reactionsMutateCacheVisitorProvider;
    }

    public final Class mo883a() {
        return ReactionsGraphQLModels$ViewerReactionsMutationFragmentModel.class;
    }
}
