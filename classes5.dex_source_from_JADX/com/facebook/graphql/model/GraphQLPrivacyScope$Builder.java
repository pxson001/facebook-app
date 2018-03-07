package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: Video Call */
public class GraphQLPrivacyScope$Builder extends Builder {
    public boolean f12710d;
    @Nullable
    public String f12711e;
    @Nullable
    public GraphQLPrivacyEducationInfo f12712f;
    @Nullable
    public GraphQLIcon f12713g;
    @Nullable
    public GraphQLImage f12714h;
    @Nullable
    public String f12715i;
    @Nullable
    public String f12716j;
    @Nullable
    public GraphQLPrivacyOptionsContentConnection f12717k;
    @Nullable
    public GraphQLPrivacyOptionsContentConnection f12718l;
    public boolean f12719m;
    @Nullable
    public String f12720n;

    public GraphQLPrivacyScope$Builder() {
        Preconditions.checkState(this instanceof GraphQLPrivacyScope$Builder);
    }

    public static GraphQLPrivacyScope$Builder m21026a(GraphQLPrivacyScope graphQLPrivacyScope) {
        GraphQLPrivacyScope$Builder graphQLPrivacyScope$Builder = new GraphQLPrivacyScope$Builder();
        graphQLPrivacyScope.h();
        graphQLPrivacyScope$Builder.f12710d = graphQLPrivacyScope.a();
        graphQLPrivacyScope$Builder.f12711e = graphQLPrivacyScope.j();
        graphQLPrivacyScope$Builder.f12712f = graphQLPrivacyScope.k();
        graphQLPrivacyScope$Builder.f12713g = graphQLPrivacyScope.l();
        graphQLPrivacyScope$Builder.f12714h = graphQLPrivacyScope.m();
        graphQLPrivacyScope$Builder.f12715i = graphQLPrivacyScope.n();
        graphQLPrivacyScope$Builder.f12716j = graphQLPrivacyScope.o();
        graphQLPrivacyScope$Builder.f12717k = graphQLPrivacyScope.p();
        graphQLPrivacyScope$Builder.f12718l = graphQLPrivacyScope.q();
        graphQLPrivacyScope$Builder.f12719m = graphQLPrivacyScope.r();
        graphQLPrivacyScope$Builder.f12720n = graphQLPrivacyScope.s();
        Builder.a(graphQLPrivacyScope$Builder, graphQLPrivacyScope);
        return graphQLPrivacyScope$Builder;
    }

    public final GraphQLPrivacyScope$Builder m21028c(@Nullable String str) {
        this.f12720n = str;
        if (this.a != null && this.a.d) {
            this.a.a(this.b, 10, str);
        }
        return this;
    }

    public final GraphQLPrivacyScope m21027a() {
        return new GraphQLPrivacyScope(this);
    }
}
