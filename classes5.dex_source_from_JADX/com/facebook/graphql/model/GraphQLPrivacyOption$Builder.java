package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLPrivacyOptionTagExpansionType;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: ViewGroupFragmentHost */
public class GraphQLPrivacyOption$Builder extends Builder {
    public GraphQLPrivacyOptionTagExpansionType f12690d = GraphQLPrivacyOptionTagExpansionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public ImmutableList<GraphQLPrivacyAudienceMember> f12691e;
    @Nullable
    public String f12692f;
    @Nullable
    public GraphQLImage f12693g;
    @Nullable
    public String f12694h;
    public ImmutableList<GraphQLPrivacyAudienceMember> f12695i;
    @Nullable
    public String f12696j;
    @Nullable
    public String f12697k;
    @Nullable
    public GraphQLPrivacyRowInput f12698l;
    public ImmutableList<GraphQLPrivacyOptionTagExpansionType> f12699m;
    @Nullable
    public String f12700n;
    @Nullable
    public String f12701o;

    public GraphQLPrivacyOption$Builder() {
        Preconditions.checkState(this instanceof GraphQLPrivacyOption$Builder);
    }

    public static GraphQLPrivacyOption$Builder m20989a(GraphQLPrivacyOption graphQLPrivacyOption) {
        GraphQLPrivacyOption$Builder graphQLPrivacyOption$Builder = new GraphQLPrivacyOption$Builder();
        graphQLPrivacyOption.h();
        graphQLPrivacyOption$Builder.f12690d = graphQLPrivacyOption.E_();
        graphQLPrivacyOption$Builder.f12691e = graphQLPrivacyOption.g();
        graphQLPrivacyOption$Builder.f12692f = graphQLPrivacyOption.j();
        graphQLPrivacyOption$Builder.f12693g = graphQLPrivacyOption.l();
        graphQLPrivacyOption$Builder.f12694h = graphQLPrivacyOption.m();
        graphQLPrivacyOption$Builder.f12695i = graphQLPrivacyOption.F_();
        graphQLPrivacyOption$Builder.f12696j = graphQLPrivacyOption.c();
        graphQLPrivacyOption$Builder.f12697k = graphQLPrivacyOption.d();
        graphQLPrivacyOption$Builder.f12698l = graphQLPrivacyOption.n();
        graphQLPrivacyOption$Builder.f12699m = graphQLPrivacyOption.G_();
        graphQLPrivacyOption$Builder.f12700n = graphQLPrivacyOption.k();
        graphQLPrivacyOption$Builder.f12701o = graphQLPrivacyOption.o();
        Builder.a(graphQLPrivacyOption$Builder, graphQLPrivacyOption);
        return graphQLPrivacyOption$Builder;
    }

    public final GraphQLPrivacyOption$Builder m20990a(@Nullable String str) {
        this.f12696j = str;
        return this;
    }

    public final GraphQLPrivacyOption m20991a() {
        return new GraphQLPrivacyOption(this);
    }
}
