package com.facebook.controller.mutation.util;

import com.facebook.graphql.model.GraphQLStory;

/* compiled from: account_info */
class FeedStoryCacheAdapter$6 extends StoryVisitor {
    final /* synthetic */ boolean f11685a;
    final /* synthetic */ FeedStoryCacheAdapter f11686b;

    FeedStoryCacheAdapter$6(FeedStoryCacheAdapter feedStoryCacheAdapter, String str, boolean z) {
        this.f11686b = feedStoryCacheAdapter;
        this.f11685a = z;
        super(str);
    }

    public final GraphQLStory mo1203a(GraphQLStory graphQLStory) {
        GraphQLStory a = ((FeedStoryMutator) this.f11686b.a.get()).a(graphQLStory, this.f11685a);
        return a == null ? graphQLStory : a;
    }
}
