package com.facebook.graphql.executor.request;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import javax.annotation.Nullable;

/* compiled from: feedback */
public final class MutationRequest<T> {
    public final TypedGraphQLMutationString<T> f11808a;
    public final ImmutableSet<String> f11809b;
    public GraphQLVisitableModel f11810c;
    public boolean f11811d;
    @Nullable
    public ViewerContext f11812e;

    public MutationRequest(TypedGraphQLMutationString<T> typedGraphQLMutationString, ImmutableSet<String> immutableSet) {
        this.f11808a = typedGraphQLMutationString;
        this.f11809b = (ImmutableSet) Preconditions.checkNotNull(immutableSet);
    }

    public MutationRequest(TypedGraphQLMutationString<T> typedGraphQLMutationString) {
        this(typedGraphQLMutationString, RegularImmutableSet.a);
    }

    public final MutationRequest<T> m12413a(GraphQLVisitableModel graphQLVisitableModel) {
        Preconditions.checkState(!(graphQLVisitableModel instanceof TypeModel), "Fragment models are required for optimistic mutations");
        this.f11810c = graphQLVisitableModel;
        return this;
    }

    public final MutationRequest<T> m12412a(@Nullable ViewerContext viewerContext) {
        this.f11812e = viewerContext;
        return this;
    }

    @Nullable
    public final ViewerContext m12414d() {
        return this.f11812e;
    }
}
