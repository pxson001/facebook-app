package com.facebook.reaction.common;

import com.facebook.graphql.model.BaseFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import javax.annotation.Nullable;

/* compiled from: blur */
public class ReactionCardNode extends BaseFeedUnit implements ReactionItem {
    public ReactionUnitFragment f18838a;
    public ReactionValidationResult f18839b;

    public ReactionCardNode(ReactionUnitFragment reactionUnitFragment, ReactionValidationResult reactionValidationResult) {
        this.f18838a = reactionUnitFragment;
        this.f18839b = reactionValidationResult;
    }

    public final String m22870g() {
        return Integer.toString(hashCode());
    }

    @Nullable
    public final GraphQLStory mo1116f() {
        return null;
    }

    public final ReactionUnitFragment mo1117k() {
        return this.f18838a;
    }
}
