package com.facebook.reaction.feed.environment;

import com.facebook.inject.Assisted;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionCommonConstants.CardSearchType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.common.ReactionUnitComponentUtil;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionMoreSubComponentsResultModel.ReactionPaginatedComponentsModel;
import javax.inject.Inject;

/* compiled from: badge_invalidation */
public class CanAddReactionComponentsImpl implements CanAddReactionComponents {
    private final HasReactionCardContainer f19121a;

    @Inject
    public CanAddReactionComponentsImpl(@Assisted HasReactionCardContainer hasReactionCardContainer) {
        this.f19121a = hasReactionCardContainer;
    }

    public final void mo694a(ReactionPaginatedComponentsModel reactionPaginatedComponentsModel, ReactionUnitComponentNode reactionUnitComponentNode) {
        ReactionCardContainer q = this.f19121a.mo705q();
        if (q != null) {
            ReactionUnitFragment a = q.mo725a(reactionUnitComponentNode.f18863c);
            if (a != null) {
                q.mo728a(ReactionUnitComponentUtil.m22897a(a, reactionPaginatedComponentsModel, reactionUnitComponentNode.f18862b.U()), reactionUnitComponentNode.f18863c, CardSearchType.UNIT_ID);
            }
        }
    }
}
