package com.facebook.reaction.feed.nodes;

import com.facebook.graphql.model.GraphQLStory;
import com.facebook.reaction.common.ReactionItem;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;

/* compiled from: auto_identify_failed */
public class ReactionFeedStoryNode implements ReactionItem {
    public GraphQLStory f19131a;
    private final ReactionUnitFragment f19132b;

    public ReactionFeedStoryNode(GraphQLStory graphQLStory, ReactionUnitFragment reactionUnitFragment) {
        this.f19131a = graphQLStory;
        this.f19132b = reactionUnitFragment;
    }

    public final GraphQLStory mo1116f() {
        return this.f19131a;
    }

    public final ReactionUnitFragment mo1117k() {
        return this.f19132b;
    }
}
