package com.facebook.controller.mutation.util;

import com.facebook.graphql.executor.cache.GraphQLCachingVisitor;
import com.facebook.graphql.executor.cache.RecursiveModelTransformer;
import com.facebook.graphql.executor.iface.TypedModelVisitor;
import com.facebook.graphql.model.GraphQLPage;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: account_info */
abstract class FeedStoryCacheAdapter$PageVisitor extends GraphQLCachingVisitor {
    private final TypedModelVisitor<GraphQLPage> f11643a = new C10971(this);
    final RecursiveModelTransformer<GraphQLPage> f11644c;
    final String f11645d;

    /* compiled from: account_info */
    class C10971 implements TypedModelVisitor<GraphQLPage> {
        final /* synthetic */ FeedStoryCacheAdapter$PageVisitor f11698a;

        C10971(FeedStoryCacheAdapter$PageVisitor feedStoryCacheAdapter$PageVisitor) {
            this.f11698a = feedStoryCacheAdapter$PageVisitor;
        }

        @Nullable
        public final Object m19775a(@Nullable Object obj) {
            GraphQLPage graphQLPage = (GraphQLPage) obj;
            if (graphQLPage == null) {
                return null;
            }
            return this.f11698a.f11645d.equals(graphQLPage.ae()) ? this.f11698a.mo1204a(graphQLPage) : graphQLPage;
        }
    }

    protected abstract GraphQLPage mo1204a(GraphQLPage graphQLPage);

    public FeedStoryCacheAdapter$PageVisitor(String str) {
        Preconditions.checkNotNull(str);
        this.f11644c = new RecursiveModelTransformer(GraphQLPage.class, this.f11643a);
        this.f11645d = str;
    }

    public final <T> T m19747b(T t) {
        return this.f11644c.a(t);
    }

    public final Set<String> m19746a() {
        return ImmutableSet.of(this.f11645d);
    }
}
