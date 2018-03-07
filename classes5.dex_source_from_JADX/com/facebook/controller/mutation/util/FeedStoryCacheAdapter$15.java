package com.facebook.controller.mutation.util;

import com.facebook.graphql.executor.cache.GraphQLCachingVisitor;
import com.facebook.graphql.executor.cache.RecursiveModelTransformer;
import com.facebook.graphql.executor.iface.TypedModelVisitor;
import com.facebook.graphql.model.GraphQLPeopleYouShouldFollowFeedUnit;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: account_info */
class FeedStoryCacheAdapter$15 extends GraphQLCachingVisitor {
    final RecursiveModelTransformer<GraphQLPeopleYouShouldFollowFeedUnit> f11663a = new RecursiveModelTransformer(GraphQLPeopleYouShouldFollowFeedUnit.class, new C10931(this));
    final /* synthetic */ String f11664b;
    final /* synthetic */ GraphQLPeopleYouShouldFollowFeedUnit f11665c;
    final /* synthetic */ FeedStoryCacheAdapter f11666d;

    /* compiled from: account_info */
    class C10931 implements TypedModelVisitor<GraphQLPeopleYouShouldFollowFeedUnit> {
        final /* synthetic */ FeedStoryCacheAdapter$15 f11662a;

        C10931(FeedStoryCacheAdapter$15 feedStoryCacheAdapter$15) {
            this.f11662a = feedStoryCacheAdapter$15;
        }

        @Nullable
        public final Object m19756a(@Nullable Object obj) {
            GraphQLPeopleYouShouldFollowFeedUnit graphQLPeopleYouShouldFollowFeedUnit = (GraphQLPeopleYouShouldFollowFeedUnit) obj;
            return (graphQLPeopleYouShouldFollowFeedUnit == null || !this.f11662a.f11664b.equals(graphQLPeopleYouShouldFollowFeedUnit.g())) ? graphQLPeopleYouShouldFollowFeedUnit : this.f11662a.f11665c;
        }

        public boolean equals(@Nullable Object obj) {
            return false;
        }
    }

    FeedStoryCacheAdapter$15(FeedStoryCacheAdapter feedStoryCacheAdapter, String str, GraphQLPeopleYouShouldFollowFeedUnit graphQLPeopleYouShouldFollowFeedUnit) {
        this.f11666d = feedStoryCacheAdapter;
        this.f11664b = str;
        this.f11665c = graphQLPeopleYouShouldFollowFeedUnit;
    }

    public final <T> T m19758b(T t) {
        return this.f11663a.a(t);
    }

    public final Set<String> m19757a() {
        return ImmutableSet.of(this.f11664b);
    }
}
