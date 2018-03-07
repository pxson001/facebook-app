package com.facebook.controller.mutation.util;

import com.facebook.graphql.executor.cache.GraphQLCachingVisitor;
import com.facebook.graphql.executor.cache.RecursiveModelTransformer;
import com.facebook.graphql.executor.iface.TypedModelVisitor;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnit;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: account_info */
class FeedStoryCacheAdapter$14 extends GraphQLCachingVisitor {
    final RecursiveModelTransformer<GraphQLPeopleYouMayInviteFeedUnit> f11658a = new RecursiveModelTransformer(GraphQLPeopleYouMayInviteFeedUnit.class, new C10921(this));
    final /* synthetic */ String f11659b;
    final /* synthetic */ GraphQLPeopleYouMayInviteFeedUnit f11660c;
    final /* synthetic */ FeedStoryCacheAdapter f11661d;

    /* compiled from: account_info */
    class C10921 implements TypedModelVisitor<GraphQLPeopleYouMayInviteFeedUnit> {
        final /* synthetic */ FeedStoryCacheAdapter$14 f11657a;

        C10921(FeedStoryCacheAdapter$14 feedStoryCacheAdapter$14) {
            this.f11657a = feedStoryCacheAdapter$14;
        }

        @Nullable
        public final Object m19753a(@Nullable Object obj) {
            GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit = (GraphQLPeopleYouMayInviteFeedUnit) obj;
            return (graphQLPeopleYouMayInviteFeedUnit == null || !this.f11657a.f11659b.equals(graphQLPeopleYouMayInviteFeedUnit.g())) ? graphQLPeopleYouMayInviteFeedUnit : this.f11657a.f11660c;
        }

        public boolean equals(@Nullable Object obj) {
            return false;
        }
    }

    FeedStoryCacheAdapter$14(FeedStoryCacheAdapter feedStoryCacheAdapter, String str, GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit) {
        this.f11661d = feedStoryCacheAdapter;
        this.f11659b = str;
        this.f11660c = graphQLPeopleYouMayInviteFeedUnit;
    }

    public final <T> T m19755b(T t) {
        return this.f11658a.a(t);
    }

    public final Set<String> m19754a() {
        return ImmutableSet.of(this.f11659b);
    }
}
