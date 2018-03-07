package com.facebook.controller.mutation.util;

import com.facebook.graphql.model.GraphQLStory;
import com.facebook.ipc.composer.model.ProductItemAttachment;

/* compiled from: account_info */
class FeedStoryCacheAdapter$5 extends StoryVisitor {
    final /* synthetic */ ProductItemAttachment f11683a;
    final /* synthetic */ FeedStoryCacheAdapter f11684b;

    FeedStoryCacheAdapter$5(FeedStoryCacheAdapter feedStoryCacheAdapter, String str, ProductItemAttachment productItemAttachment) {
        this.f11684b = feedStoryCacheAdapter;
        this.f11683a = productItemAttachment;
        super(str);
    }

    public final GraphQLStory mo1203a(GraphQLStory graphQLStory) {
        return (GraphQLStory) ((FeedStoryMutator) this.f11684b.a.get()).a(graphQLStory, this.f11683a, false).a;
    }
}
