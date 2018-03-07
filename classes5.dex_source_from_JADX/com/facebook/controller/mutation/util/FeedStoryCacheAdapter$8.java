package com.facebook.controller.mutation.util;

import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.executor.cache.GraphQLCachingVisitor;
import com.facebook.graphql.executor.cache.RecursiveModelTransformer;
import com.facebook.graphql.executor.iface.TypedModelVisitor;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLNode$Builder;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLPlace$Builder;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: account_info */
public class FeedStoryCacheAdapter$8 extends GraphQLCachingVisitor {
    final RecursiveModelTransformer<GraphQLPlace> f11691a = new RecursiveModelTransformer(GraphQLPlace.class, new C10951(this));
    final RecursiveModelTransformer<GraphQLNode> f11692b = new RecursiveModelTransformer(GraphQLNode.class, new C10962(this));
    final /* synthetic */ String f11693c;
    final /* synthetic */ GraphQLSavedState f11694d;
    final /* synthetic */ FeedStoryCacheAdapter f11695e;

    /* compiled from: account_info */
    class C10951 implements TypedModelVisitor<GraphQLPlace> {
        final /* synthetic */ FeedStoryCacheAdapter$8 f11689a;

        C10951(FeedStoryCacheAdapter$8 feedStoryCacheAdapter$8) {
            this.f11689a = feedStoryCacheAdapter$8;
        }

        @Nullable
        public final Object m19770a(@Nullable Object obj) {
            GraphQLPlace graphQLPlace = (GraphQLPlace) obj;
            return (graphQLPlace == null || !this.f11689a.f11693c.equals(graphQLPlace.x())) ? graphQLPlace : GraphQLPlace$Builder.m20830a(graphQLPlace).m20831a(this.f11689a.f11694d).m20832a();
        }

        public boolean equals(@Nullable Object obj) {
            return false;
        }
    }

    /* compiled from: account_info */
    class C10962 implements TypedModelVisitor<GraphQLNode> {
        final /* synthetic */ FeedStoryCacheAdapter$8 f11690a;

        C10962(FeedStoryCacheAdapter$8 feedStoryCacheAdapter$8) {
            this.f11690a = feedStoryCacheAdapter$8;
        }

        @Nullable
        public final Object m19771a(@Nullable Object obj) {
            GraphQLNode graphQLNode = (GraphQLNode) obj;
            if (graphQLNode == null || !this.f11690a.f11693c.equals(graphQLNode.dp())) {
                return graphQLNode;
            }
            GraphQLNode$Builder a = GraphQLNode$Builder.m9282a(graphQLNode);
            a.m9286a(this.f11690a.f11694d);
            return a.m9287a();
        }

        public boolean equals(@Nullable Object obj) {
            return false;
        }
    }

    public FeedStoryCacheAdapter$8(FeedStoryCacheAdapter feedStoryCacheAdapter, String str, GraphQLSavedState graphQLSavedState) {
        this.f11695e = feedStoryCacheAdapter;
        this.f11693c = str;
        this.f11694d = graphQLSavedState;
    }

    public final <T> T m19773b(T t) {
        return this.f11691a.a(this.f11692b.a(t));
    }

    public final Set<String> m19772a() {
        return ImmutableSet.of(this.f11693c);
    }
}
