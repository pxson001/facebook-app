package com.facebook.controller.mutation.util;

import com.facebook.graphql.model.GraphQLStory;

/* compiled from: account_info */
public class FeedStoryCacheAdapter$17 extends StoryVisitor {
    final /* synthetic */ GraphQLStory f11672a;
    final /* synthetic */ FeedStoryCacheAdapter f11673b;

    public FeedStoryCacheAdapter$17(FeedStoryCacheAdapter feedStoryCacheAdapter, String str, GraphQLStory graphQLStory) {
        this.f11673b = feedStoryCacheAdapter;
        this.f11672a = graphQLStory;
        super(str);
    }

    protected final GraphQLStory mo1203a(GraphQLStory graphQLStory) {
        return (graphQLStory == null || !graphQLStory.g().equals(this.f11672a.g())) ? graphQLStory : this.f11672a;
    }
}
