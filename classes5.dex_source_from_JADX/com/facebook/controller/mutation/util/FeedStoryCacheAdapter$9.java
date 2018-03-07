package com.facebook.controller.mutation.util;

import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.model.PropertyHelper;

/* compiled from: account_info */
public class FeedStoryCacheAdapter$9 extends StoryVisitor {
    final /* synthetic */ FeedUnit f11696a;
    final /* synthetic */ FeedStoryCacheAdapter f11697b;

    public FeedStoryCacheAdapter$9(FeedStoryCacheAdapter feedStoryCacheAdapter, String str, FeedUnit feedUnit) {
        this.f11697b = feedStoryCacheAdapter;
        this.f11696a = feedUnit;
        super(str);
    }

    public final GraphQLStory mo1203a(GraphQLStory graphQLStory) {
        FeedStoryMutator feedStoryMutator = (FeedStoryMutator) this.f11697b.a.get();
        FeedUnit feedUnit = this.f11696a;
        Builder a = Builder.a(graphQLStory);
        a.F = feedStoryMutator.i.a();
        GraphQLStory a2 = a.a();
        PropertyHelper.a(a2).l = feedUnit;
        return a2;
    }
}
