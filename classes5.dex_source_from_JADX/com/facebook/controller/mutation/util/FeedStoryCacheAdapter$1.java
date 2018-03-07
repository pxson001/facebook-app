package com.facebook.controller.mutation.util;

import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.model.mutator.FeedUnitMutator;

/* compiled from: account_info */
public class FeedStoryCacheAdapter$1 extends StoryVisitor {
    final /* synthetic */ StoryVisibility f11674a;
    final /* synthetic */ int f11675b;
    final /* synthetic */ FeedStoryCacheAdapter f11676c;

    public FeedStoryCacheAdapter$1(FeedStoryCacheAdapter feedStoryCacheAdapter, String str, StoryVisibility storyVisibility, int i) {
        this.f11676c = feedStoryCacheAdapter;
        this.f11674a = storyVisibility;
        this.f11675b = i;
        super(str);
    }

    public final GraphQLStory mo1203a(GraphQLStory graphQLStory) {
        if (GraphQLHelper.a(graphQLStory)) {
            return (GraphQLStory) FeedUnitMutator.m22616a((FeedUnit) graphQLStory).m22624a(this.f11674a).m22621a(this.f11675b).mo1233a();
        }
        String str;
        Builder a = Builder.a(graphQLStory);
        if (this.f11674a == null) {
            str = null;
        } else {
            str = this.f11674a.name();
        }
        Builder a2 = a.g(str).a(this.f11675b);
        a2.F = this.f11676c.b.a();
        return a2.a();
    }
}
