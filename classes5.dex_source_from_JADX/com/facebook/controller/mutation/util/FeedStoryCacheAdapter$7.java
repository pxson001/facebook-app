package com.facebook.controller.mutation.util;

import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: account_info */
public class FeedStoryCacheAdapter$7 extends StoryVisitor {
    final /* synthetic */ GraphQLSavedState f11687a;
    final /* synthetic */ FeedStoryCacheAdapter f11688b;

    public FeedStoryCacheAdapter$7(FeedStoryCacheAdapter feedStoryCacheAdapter, String str, GraphQLSavedState graphQLSavedState) {
        this.f11688b = feedStoryCacheAdapter;
        this.f11687a = graphQLSavedState;
        super(str);
    }

    protected final GraphQLStory mo1203a(GraphQLStory graphQLStory) {
        return ((FeedStoryMutator) this.f11688b.a.get()).a(graphQLStory, this.f11687a);
    }
}
