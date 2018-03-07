package com.facebook.controller.mutation.util;

import com.facebook.graphql.executor.cache.GraphQLCachingVisitor;
import com.facebook.graphql.executor.cache.RecursiveModelTransformer;
import com.facebook.graphql.executor.iface.TypedModelVisitor;
import com.facebook.graphql.model.GraphQLAdditionalSuggestedPostAdItemsConnection;
import com.facebook.graphql.model.GraphQLAdditionalSuggestedPostAdItemsEdge;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.GraphQLStorySet$Builder;
import com.facebook.graphql.model.GraphQLStorySetStoriesConnection;
import com.facebook.graphql.model.GraphQLStorySetStoriesConnection$Builder;
import com.facebook.graphql.model.PropertyHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: account_info */
public class FeedStoryCacheAdapter$16 extends GraphQLCachingVisitor {
    final RecursiveModelTransformer<GraphQLStorySet> f11668a = new RecursiveModelTransformer(GraphQLStorySet.class, new C10941(this));
    final /* synthetic */ String f11669b;
    final /* synthetic */ GraphQLAdditionalSuggestedPostAdItemsConnection f11670c;
    final /* synthetic */ FeedStoryCacheAdapter f11671d;

    /* compiled from: account_info */
    class C10941 implements TypedModelVisitor<GraphQLStorySet> {
        final /* synthetic */ FeedStoryCacheAdapter$16 f11667a;

        C10941(FeedStoryCacheAdapter$16 feedStoryCacheAdapter$16) {
            this.f11667a = feedStoryCacheAdapter$16;
        }

        @Nullable
        public final Object m19759a(@Nullable Object obj) {
            GraphQLStorySet graphQLStorySet = (GraphQLStorySet) obj;
            if (graphQLStorySet == null || !this.f11667a.f11669b.equals(graphQLStorySet.g())) {
                return graphQLStorySet;
            }
            FeedStoryMutator feedStoryMutator = (FeedStoryMutator) this.f11667a.f11671d.a.get();
            GraphQLAdditionalSuggestedPostAdItemsConnection graphQLAdditionalSuggestedPostAdItemsConnection = this.f11667a.f11670c;
            GraphQLStorySetStoriesConnection a = FeedStoryMutator.a(graphQLStorySet);
            Builder builder = ImmutableList.builder();
            builder.b(a.j());
            if (graphQLAdditionalSuggestedPostAdItemsConnection.a() != null) {
                ImmutableList a2 = graphQLAdditionalSuggestedPostAdItemsConnection.a();
                int size = a2.size();
                for (int i = 0; i < size; i++) {
                    GraphQLAdditionalSuggestedPostAdItemsEdge graphQLAdditionalSuggestedPostAdItemsEdge = (GraphQLAdditionalSuggestedPostAdItemsEdge) a2.get(i);
                    if (!(graphQLAdditionalSuggestedPostAdItemsEdge.m6458a() == null || graphQLAdditionalSuggestedPostAdItemsEdge.m6458a().m21899k() == null)) {
                        builder.c(graphQLAdditionalSuggestedPostAdItemsEdge.m6458a().m21899k());
                    }
                }
            }
            GraphQLStorySet$Builder a3 = GraphQLStorySet$Builder.m21888a(graphQLStorySet);
            GraphQLStorySetStoriesConnection$Builder a4 = GraphQLStorySetStoriesConnection$Builder.m21907a(a);
            a4.f13197e = builder.b();
            a3.f13174e = a4.m21908a();
            a3 = a3;
            a3.f13179j = feedStoryMutator.i.a();
            GraphQLStorySet a5 = a3.m21889a();
            PropertyHelper.a(a5, null);
            return a5;
        }

        public boolean equals(@Nullable Object obj) {
            return false;
        }
    }

    public FeedStoryCacheAdapter$16(FeedStoryCacheAdapter feedStoryCacheAdapter, String str, GraphQLAdditionalSuggestedPostAdItemsConnection graphQLAdditionalSuggestedPostAdItemsConnection) {
        this.f11671d = feedStoryCacheAdapter;
        this.f11669b = str;
        this.f11670c = graphQLAdditionalSuggestedPostAdItemsConnection;
    }

    public final <T> T m19761b(T t) {
        return this.f11668a.a(t);
    }

    public final Set<String> m19760a() {
        return ImmutableSet.of(this.f11669b);
    }
}
