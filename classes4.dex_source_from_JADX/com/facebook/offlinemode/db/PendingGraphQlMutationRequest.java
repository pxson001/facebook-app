package com.facebook.offlinemode.db;

import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.offlinemode.common.PendingRequest;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;

/* compiled from: feed_trim_cache */
public class PendingGraphQlMutationRequest extends PendingRequest {
    public final Class<? extends TypedGraphQLMutationString> f11835h;
    public final GraphQlQueryParamSet f11836i;
    public final GraphQLVisitableModel f11837j;
    public final ImmutableSet<String> f11838k;
    @Nullable
    private final MutationRequest f11839l;

    /* compiled from: feed_trim_cache */
    public class Builder extends com.facebook.offlinemode.common.PendingRequest.Builder {
        public Class<? extends TypedGraphQLMutationString> f11817g;
        public GraphQlQueryParamSet f11818h;
        public GraphQLVisitableModel f11819i;
        public MutationRequest f11820j;
        public ImmutableSet<String> f11821k;

        public final /* synthetic */ PendingRequest mo880a() {
            return m12421b();
        }

        public final Builder m12416a(MutationRequest<?> mutationRequest) {
            this.f11820j = mutationRequest;
            this.f11817g = mutationRequest.f11808a.getClass();
            this.f11818h = mutationRequest.f11808a.a;
            m12418a(mutationRequest.f11810c);
            this.f11821k = mutationRequest.f11809b;
            return this;
        }

        public final Builder m12420a(Class<? extends TypedGraphQLMutationString> cls) {
            this.f11817g = cls;
            return this;
        }

        public final Builder m12417a(GraphQlQueryParamSet graphQlQueryParamSet) {
            this.f11818h = graphQlQueryParamSet;
            return this;
        }

        public final Builder m12418a(GraphQLVisitableModel graphQLVisitableModel) {
            boolean z = graphQLVisitableModel == null || (graphQLVisitableModel instanceof Flattenable);
            Preconditions.checkArgument(z);
            this.f11819i = graphQLVisitableModel;
            return this;
        }

        public final Builder m12419a(ImmutableSet<String> immutableSet) {
            this.f11821k = immutableSet;
            return this;
        }

        public final PendingGraphQlMutationRequest m12421b() {
            Preconditions.checkState(this.f11817g != null);
            return new PendingGraphQlMutationRequest(this.f11822a, this.f11823b, this.f11825d, this.f11824c, this.f11826e, this.f11827f, this.f11817g, this.f11818h, this.f11819i, this.f11821k, this.f11820j);
        }
    }

    private PendingGraphQlMutationRequest(@Nullable String str, @Nullable String str2, long j, long j2, int i, int i2, Class<? extends TypedGraphQLMutationString> cls, GraphQlQueryParamSet graphQlQueryParamSet, GraphQLVisitableModel graphQLVisitableModel, ImmutableSet<String> immutableSet, @Nullable MutationRequest mutationRequest) {
        super(i, j, str, str2, i2, j2);
        this.f11835h = cls;
        this.f11836i = graphQlQueryParamSet;
        this.f11837j = graphQLVisitableModel;
        this.f11838k = (ImmutableSet) Preconditions.checkNotNull(immutableSet);
        this.f11839l = mutationRequest;
    }

    public final MutationRequest m12432d() {
        if (this.f11839l != null) {
            return this.f11839l;
        }
        TypedGraphQLMutationString typedGraphQLMutationString = (TypedGraphQLMutationString) this.f11835h.newInstance();
        typedGraphQLMutationString.a = this.f11836i;
        return new MutationRequest(typedGraphQLMutationString, this.f11838k).m12413a(this.f11837j);
    }

    public final String mo881c() {
        return this.f11835h.getName();
    }

    public final PendingGraphQlMutationRequest m12433e() {
        com.facebook.offlinemode.common.PendingRequest.Builder builder = new Builder();
        builder.f11822a = this.f11829b;
        builder.f11823b = this.f11830c;
        builder.f11825d = this.f11832e;
        builder.f11824c = this.f11831d;
        builder.f11826e = this.f11833f;
        builder.f11827f = this.f11834g;
        builder.f11817g = this.f11835h;
        builder.f11818h = this.f11836i;
        builder.m12418a(this.f11837j);
        builder.f11821k = this.f11838k;
        builder = builder;
        builder.f11826e = this.f11833f + 1;
        return (PendingGraphQlMutationRequest) builder.mo880a();
    }
}
