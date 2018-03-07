package com.facebook.controller.mutation.util;

import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.mutator.GraphQLPageMutator;

/* compiled from: account_info */
public class FeedStoryCacheAdapter$11 extends FeedStoryCacheAdapter$PageVisitor {
    final /* synthetic */ boolean f11646a;
    final /* synthetic */ FeedStoryCacheAdapter f11647b;

    public FeedStoryCacheAdapter$11(FeedStoryCacheAdapter feedStoryCacheAdapter, String str, boolean z) {
        this.f11647b = feedStoryCacheAdapter;
        this.f11646a = z;
        super(str);
    }

    public final GraphQLPage mo1204a(GraphQLPage graphQLPage) {
        if (graphQLPage.O() == this.f11646a) {
            return graphQLPage;
        }
        return GraphQLPageMutator.m22630a(graphQLPage).m22631a(this.f11646a).f13498a;
    }
}
