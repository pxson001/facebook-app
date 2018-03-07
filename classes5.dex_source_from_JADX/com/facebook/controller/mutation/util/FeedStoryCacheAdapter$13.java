package com.facebook.controller.mutation.util;

import com.facebook.graphql.executor.cache.GraphQLCachingVisitor;
import com.facebook.graphql.executor.cache.RecursiveModelTransformer;
import com.facebook.graphql.executor.iface.TypedModelVisitor;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnit;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: account_info */
class FeedStoryCacheAdapter$13 extends GraphQLCachingVisitor {
    final RecursiveModelTransformer<GraphQLPaginatedPeopleYouMayKnowFeedUnit> f11653a = new RecursiveModelTransformer(GraphQLPaginatedPeopleYouMayKnowFeedUnit.class, new C10911(this));
    final /* synthetic */ String f11654b;
    final /* synthetic */ GraphQLPaginatedPeopleYouMayKnowFeedUnit f11655c;
    final /* synthetic */ FeedStoryCacheAdapter f11656d;

    /* compiled from: account_info */
    class C10911 implements TypedModelVisitor<GraphQLPaginatedPeopleYouMayKnowFeedUnit> {
        final /* synthetic */ FeedStoryCacheAdapter$13 f11652a;

        C10911(FeedStoryCacheAdapter$13 feedStoryCacheAdapter$13) {
            this.f11652a = feedStoryCacheAdapter$13;
        }

        @Nullable
        public final Object m19750a(@Nullable Object obj) {
            GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit = (GraphQLPaginatedPeopleYouMayKnowFeedUnit) obj;
            return (graphQLPaginatedPeopleYouMayKnowFeedUnit == null || !this.f11652a.f11654b.equals(graphQLPaginatedPeopleYouMayKnowFeedUnit.g())) ? graphQLPaginatedPeopleYouMayKnowFeedUnit : this.f11652a.f11655c;
        }

        public boolean equals(@Nullable Object obj) {
            return false;
        }
    }

    FeedStoryCacheAdapter$13(FeedStoryCacheAdapter feedStoryCacheAdapter, String str, GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit) {
        this.f11656d = feedStoryCacheAdapter;
        this.f11654b = str;
        this.f11655c = graphQLPaginatedPeopleYouMayKnowFeedUnit;
    }

    public final <T> T m19752b(T t) {
        return this.f11653a.a(t);
    }

    public final Set<String> m19751a() {
        return ImmutableSet.of(this.f11654b);
    }
}
