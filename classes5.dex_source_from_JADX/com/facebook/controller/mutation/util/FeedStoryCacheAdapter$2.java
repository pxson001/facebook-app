package com.facebook.controller.mutation.util;

import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.mutator.FeedUnitMutator;

/* compiled from: account_info */
public class FeedStoryCacheAdapter$2 extends StoryVisitor {
    final /* synthetic */ GraphQLNegativeFeedbackActionType f11677a;
    final /* synthetic */ FeedStoryCacheAdapter f11678b;

    public FeedStoryCacheAdapter$2(FeedStoryCacheAdapter feedStoryCacheAdapter, String str, GraphQLNegativeFeedbackActionType graphQLNegativeFeedbackActionType) {
        this.f11678b = feedStoryCacheAdapter;
        this.f11677a = graphQLNegativeFeedbackActionType;
        super(str);
    }

    public final GraphQLStory mo1203a(GraphQLStory graphQLStory) {
        return (GraphQLStory) FeedUnitMutator.m22616a((FeedUnit) graphQLStory).m22623a(this.f11677a).mo1233a();
    }
}
