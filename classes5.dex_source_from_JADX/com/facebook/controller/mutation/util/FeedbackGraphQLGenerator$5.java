package com.facebook.controller.mutation.util;

import com.facebook.graphql.executor.iface.CacheVisitor;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

/* compiled from: accessibility_caption */
class FeedbackGraphQLGenerator$5 implements CacheVisitor {
    final /* synthetic */ CacheVisitor f11726a;
    final /* synthetic */ CacheVisitor f11727b;
    final /* synthetic */ ImmutableSet f11728c;
    final /* synthetic */ FeedbackGraphQLGenerator f11729d;

    FeedbackGraphQLGenerator$5(FeedbackGraphQLGenerator feedbackGraphQLGenerator, CacheVisitor cacheVisitor, CacheVisitor cacheVisitor2, ImmutableSet immutableSet) {
        this.f11729d = feedbackGraphQLGenerator;
        this.f11726a = cacheVisitor;
        this.f11727b = cacheVisitor2;
        this.f11728c = immutableSet;
    }

    public final <T> T m19780a(T t) {
        return this.f11726a.a(this.f11727b.a(t));
    }

    public final Set<String> m19781a() {
        return this.f11728c;
    }
}
