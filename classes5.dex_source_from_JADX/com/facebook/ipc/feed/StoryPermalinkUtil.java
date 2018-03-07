package com.facebook.ipc.feed;

import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: TICKER_FLYOUT */
public class StoryPermalinkUtil {
    @Nullable
    public static GraphQLProfile m23433a(GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return null;
        }
        if (graphQLStory.aJ() != null && graphQLStory.aJ().j() != null && graphQLStory.aJ().b() != null) {
            return graphQLStory.aJ();
        }
        if (graphQLStory.L() != null) {
            GraphQLProfile a = m23433a(graphQLStory.L());
            if (a != null) {
                return a;
            }
        }
        if (StoryHierarchyHelper.a(graphQLStory) == null) {
            return null;
        }
        ImmutableList j = StoryHierarchyHelper.a(graphQLStory).j();
        int size = j.size();
        int i = 0;
        GraphQLProfile graphQLProfile = null;
        while (i < size) {
            GraphQLProfile a2 = m23433a((GraphQLStory) j.get(i));
            if (a2 == null) {
                return null;
            }
            if (graphQLProfile != null && graphQLProfile.b() != null && !graphQLProfile.b().equals(a2.b())) {
                return null;
            }
            i++;
            graphQLProfile = a2;
        }
        return graphQLProfile != null ? graphQLProfile : null;
    }

    @Nullable
    public static String m23434a(GraphQLProfile graphQLProfile) {
        return m23435a(graphQLProfile, 69076575);
    }

    public static String m23435a(GraphQLProfile graphQLProfile, int i) {
        if (graphQLProfile == null || graphQLProfile.j() == null || graphQLProfile.j().g() != i) {
            return null;
        }
        return graphQLProfile.b();
    }
}
