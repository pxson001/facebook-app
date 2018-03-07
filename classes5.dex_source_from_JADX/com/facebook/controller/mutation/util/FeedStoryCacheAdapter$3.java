package com.facebook.controller.mutation.util;

import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPrivacyScope;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.model.GraphQLStory.StoryExtra;
import com.facebook.graphql.model.mutator.GraphQLStoryMutator;

/* compiled from: account_info */
public class FeedStoryCacheAdapter$3 extends StoryVisitor {
    final /* synthetic */ GraphQLPrivacyScope f11679a;
    final /* synthetic */ FeedStoryCacheAdapter f11680b;

    public FeedStoryCacheAdapter$3(FeedStoryCacheAdapter feedStoryCacheAdapter, String str, GraphQLPrivacyScope graphQLPrivacyScope) {
        this.f11680b = feedStoryCacheAdapter;
        this.f11679a = graphQLPrivacyScope;
        super(str);
    }

    public final GraphQLStory mo1203a(GraphQLStory graphQLStory) {
        if (GraphQLHelper.a(graphQLStory)) {
            GraphQLStoryMutator a = GraphQLStoryMutator.m22634a(graphQLStory);
            GraphQLPrivacyScope graphQLPrivacyScope = this.f11679a;
            StoryExtra bd = a.f13500a.bd();
            if (graphQLPrivacyScope != bd.a) {
                bd.a = graphQLPrivacyScope;
                bd.c();
            }
            return a.f13500a;
        }
        Builder a2 = Builder.a(graphQLStory);
        a2.ae = this.f11679a;
        a2 = a2;
        a2.F = this.f11680b.b.a();
        return a2.a();
    }
}
