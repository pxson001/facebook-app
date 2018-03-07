package com.facebook.controller.mutation.util;

import com.facebook.graphql.executor.cache.GraphQLCachingVisitor;
import com.facebook.graphql.executor.cache.RecursiveModelTransformer;
import com.facebook.graphql.executor.iface.TypedModelVisitor;
import com.facebook.graphql.model.GraphQLStory;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: account_status */
public abstract class StoryVisitor extends GraphQLCachingVisitor {
    private final TypedModelVisitor<GraphQLStory> f11638a = new C10991(this);
    final RecursiveModelTransformer<GraphQLStory> f11639e;
    final String f11640f;

    /* compiled from: account_status */
    class C10991 implements TypedModelVisitor<GraphQLStory> {
        final /* synthetic */ StoryVisitor f11741a;

        C10991(StoryVisitor storyVisitor) {
            this.f11741a = storyVisitor;
        }

        @Nullable
        public final Object m19789a(@Nullable Object obj) {
            GraphQLStory graphQLStory = (GraphQLStory) obj;
            if (graphQLStory == null) {
                return null;
            }
            return (this.f11741a.f11640f.equals(graphQLStory.c()) || this.f11741a.f11640f.equals(graphQLStory.g()) || this.f11741a.f11640f.equals(Strings.nullToEmpty(graphQLStory.ai()))) ? this.f11741a.mo1203a(graphQLStory) : graphQLStory;
        }
    }

    protected abstract GraphQLStory mo1203a(GraphQLStory graphQLStory);

    public StoryVisitor(String str) {
        Preconditions.checkNotNull(str);
        this.f11639e = new RecursiveModelTransformer(GraphQLStory.class, this.f11638a);
        this.f11640f = str;
    }

    public final <T> T m19743b(T t) {
        return this.f11639e.a(t);
    }

    public final Set<String> m19742a() {
        return ImmutableSet.of(this.f11640f);
    }
}
