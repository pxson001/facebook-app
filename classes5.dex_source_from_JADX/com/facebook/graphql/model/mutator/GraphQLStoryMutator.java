package com.facebook.graphql.model.mutator;

import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.StoryExtra;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.google.common.base.Preconditions;

/* compiled from: TS; */
public class GraphQLStoryMutator extends FeedUnitMutator {
    public final GraphQLStory f13500a;

    private GraphQLStoryMutator(GraphQLStory graphQLStory) {
        super(graphQLStory);
        this.f13500a = graphQLStory;
    }

    public static GraphQLStoryMutator m22634a(GraphQLStory graphQLStory) {
        Preconditions.checkNotNull(graphQLStory);
        return new GraphQLStoryMutator((GraphQLStory) graphQLStory.f());
    }

    public final GraphQLStoryMutator m22636a(GraphQLTextWithEntities graphQLTextWithEntities) {
        StoryExtra bd = this.f13500a.bd();
        if (graphQLTextWithEntities != bd.b) {
            bd.b = graphQLTextWithEntities;
            bd.c();
        }
        return this;
    }

    public final /* synthetic */ FeedUnit mo1233a() {
        return this.f13500a;
    }
}
