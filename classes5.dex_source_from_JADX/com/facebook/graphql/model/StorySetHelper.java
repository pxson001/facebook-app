package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLStorySetCollectionType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

/* compiled from: TV;>;)V */
public class StorySetHelper {
    private StorySetHelper() {
    }

    public static GraphQLStory m22583a(GraphQLStorySet graphQLStorySet) {
        if (graphQLStorySet.ac_() < m22584b(graphQLStorySet).size()) {
            return (GraphQLStory) m22584b(graphQLStorySet).get(graphQLStorySet.ac_());
        }
        return null;
    }

    public static ImmutableList<GraphQLStory> m22584b(GraphQLStorySet graphQLStorySet) {
        if (graphQLStorySet.z() == null || graphQLStorySet.z().j() == null) {
            return RegularImmutableList.a;
        }
        return graphQLStorySet.z().j();
    }

    public static boolean m22585c(GraphQLStorySet graphQLStorySet) {
        return !m22584b(graphQLStorySet).isEmpty() && StoryAttachmentHelper.s((GraphQLStory) m22584b(graphQLStorySet).get(0));
    }

    public static boolean m22586d(GraphQLStorySet graphQLStorySet) {
        ImmutableList G = graphQLStorySet.G();
        return G != null && G.contains(GraphQLStorySetCollectionType.VIDEO_STORIES);
    }
}
