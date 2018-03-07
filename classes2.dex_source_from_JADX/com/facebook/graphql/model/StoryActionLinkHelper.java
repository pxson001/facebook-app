package com.facebook.graphql.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: images/* */
public class StoryActionLinkHelper {
    private StoryActionLinkHelper() {
    }

    public static ImmutableList<GraphQLStoryActionLink> m28074a(GraphQLStory graphQLStory) {
        ImmutableList<GraphQLStoryActionLink> E = graphQLStory.m22319E();
        return E != null ? E : RegularImmutableList.f535a;
    }

    public static ImmutableList<GraphQLStoryActionLink> m28075b(GraphQLStory graphQLStory) {
        ImmutableList<GraphQLStoryActionLink> K = graphQLStory.m22325K();
        if (K != null) {
            return K;
        }
        return RegularImmutableList.f535a;
    }

    public static GraphQLStoryActionLink m28076c(GraphQLStory graphQLStory) {
        return m28073a(m28074a(graphQLStory));
    }

    public static GraphQLStoryActionLink m28077d(GraphQLStory graphQLStory) {
        return m28073a(graphQLStory.m22325K());
    }

    public static GraphQLStoryActionLink m28078e(GraphQLStory graphQLStory) {
        GraphQLStoryAttachment o = StoryAttachmentHelper.m28042o(graphQLStory);
        return o != null ? ActionLinkHelper.m22935a(o) : null;
    }

    private static GraphQLStoryActionLink m28073a(List<GraphQLStoryActionLink> list) {
        return (list == null || list.isEmpty()) ? null : (GraphQLStoryActionLink) list.get(0);
    }

    @Nullable
    public static GraphQLStoryActionLink m28072a(GraphQLStory graphQLStory, int i) {
        return ActionLinkHelper.m22938a(m28074a(graphQLStory), i);
    }
}
