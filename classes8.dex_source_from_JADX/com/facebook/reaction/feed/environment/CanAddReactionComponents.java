package com.facebook.reaction.feed.environment;

import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionMoreSubComponentsResultModel.ReactionPaginatedComponentsModel;

/* compiled from: kicker_style */
public interface CanAddReactionComponents extends AnyEnvironment {
    void mo694a(ReactionPaginatedComponentsModel reactionPaginatedComponentsModel, ReactionUnitComponentNode reactionUnitComponentNode);
}
