package com.facebook.reaction.feed.nodes;

import com.facebook.graphql.model.GraphQLStory;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;

/* compiled from: auto_identify */
public class ReactionPagesFeedStoryNode extends ReactionFeedStoryNode {
    public final boolean f19133a;

    public ReactionPagesFeedStoryNode(GraphQLStory graphQLStory, ReactionUnitFragment reactionUnitFragment, boolean z) {
        super(graphQLStory, reactionUnitFragment);
        this.f19133a = z;
    }
}
