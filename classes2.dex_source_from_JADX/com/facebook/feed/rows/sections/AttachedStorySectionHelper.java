package com.facebook.feed.rows.sections;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;

/* compiled from: feedback_reactions_floating_effect */
public class AttachedStorySectionHelper {
    private final GraphQLStoryUtil f24393a;

    public AttachedStorySectionHelper(GraphQLStoryUtil graphQLStoryUtil) {
        this.f24393a = graphQLStoryUtil;
    }

    public final boolean m32700a(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        if (graphQLStory.m22326L() == null) {
            return false;
        }
        if (graphQLStory.m22326L().m22349b() == null || graphQLStory.m22326L().m22349b().isEmpty()) {
            return false;
        }
        if (this.f24393a.m9600i(feedProps.m19803a(graphQLStory.m22326L())) <= 1) {
            GraphQLStory c = StoryProps.m27456c(feedProps);
            Object obj = (c == null || c.m22326L() == null || !c.m22326L().m22350c().equals(((GraphQLStory) feedProps.f13444a).m22326L().m22350c())) ? null : 1;
            if (obj == null) {
                return true;
            }
        }
        return false;
    }
}
