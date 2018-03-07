package com.facebook.controller.mutation.util;

import com.facebook.graphql.model.GraphQLStory;

/* compiled from: account_info */
class FeedStoryCacheAdapter$4 extends StoryVisitor {
    final /* synthetic */ GraphQLStory f11681a;
    final /* synthetic */ FeedStoryCacheAdapter f11682b;

    FeedStoryCacheAdapter$4(FeedStoryCacheAdapter feedStoryCacheAdapter, String str, GraphQLStory graphQLStory) {
        this.f11682b = feedStoryCacheAdapter;
        this.f11681a = graphQLStory;
        super(str);
    }

    protected final GraphQLStory mo1203a(GraphQLStory graphQLStory) {
        return (GraphQLStory) ((FeedStoryMutator) this.f11682b.a.get()).a(graphQLStory, this.f11681a).a;
    }
}
