package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: USER_SETTING */
public class GraphQLStorySetStoriesConnection$Builder extends Builder {
    public int f13196d;
    public ImmutableList<GraphQLStory> f13197e;
    @Nullable
    public GraphQLPageInfo f13198f;

    public GraphQLStorySetStoriesConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLStorySetStoriesConnection$Builder);
    }

    public static GraphQLStorySetStoriesConnection$Builder m21907a(GraphQLStorySetStoriesConnection graphQLStorySetStoriesConnection) {
        GraphQLStorySetStoriesConnection$Builder graphQLStorySetStoriesConnection$Builder = new GraphQLStorySetStoriesConnection$Builder();
        graphQLStorySetStoriesConnection.h();
        graphQLStorySetStoriesConnection$Builder.f13196d = graphQLStorySetStoriesConnection.a();
        graphQLStorySetStoriesConnection$Builder.f13197e = graphQLStorySetStoriesConnection.j();
        graphQLStorySetStoriesConnection$Builder.f13198f = graphQLStorySetStoriesConnection.k();
        Builder.a(graphQLStorySetStoriesConnection$Builder, graphQLStorySetStoriesConnection);
        return graphQLStorySetStoriesConnection$Builder;
    }

    public final GraphQLStorySetStoriesConnection m21908a() {
        return new GraphQLStorySetStoriesConnection(this);
    }
}
