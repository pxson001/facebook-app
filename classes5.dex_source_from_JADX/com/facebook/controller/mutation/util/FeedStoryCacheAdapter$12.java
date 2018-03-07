package com.facebook.controller.mutation.util;

import com.facebook.graphql.model.GraphQLStory;
import com.facebook.story.UpdateTimelineAppCollectionParams.Action;

/* compiled from: account_info */
public class FeedStoryCacheAdapter$12 extends StoryVisitor {
    final /* synthetic */ String f11648a;
    final /* synthetic */ String f11649b;
    final /* synthetic */ Action f11650c;
    final /* synthetic */ FeedStoryCacheAdapter f11651d;

    public FeedStoryCacheAdapter$12(FeedStoryCacheAdapter feedStoryCacheAdapter, String str, String str2, String str3, Action action) {
        this.f11651d = feedStoryCacheAdapter;
        this.f11648a = str2;
        this.f11649b = str3;
        this.f11650c = action;
        super(str);
    }

    public final GraphQLStory mo1203a(GraphQLStory graphQLStory) {
        return ((FeedStoryMutator) this.f11651d.a.get()).a(graphQLStory, this.f11648a, this.f11649b, this.f11650c);
    }
}
