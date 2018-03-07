package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLPhotosAlbumAPIType;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: job_tag */
public class GraphQLAlbum$Builder extends Builder {
    @Nullable
    public GraphQLTextWithEntities f3318A;
    @Nullable
    public String f3319B;
    @Nullable
    public GraphQLPhoto f3320d;
    public GraphQLPhotosAlbumAPIType f3321e = GraphQLPhotosAlbumAPIType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public boolean f3322f;
    @Nullable
    public GraphQLApplication f3323g;
    public boolean f3324h;
    public boolean f3325i;
    public boolean f3326j;
    public ImmutableList<GraphQLActor> f3327k;
    public long f3328l;
    @Nullable
    public GraphQLPlace f3329m;
    @Nullable
    public GraphQLFeedback f3330n;
    @Nullable
    public String f3331o;
    @Nullable
    public GraphQLPlace f3332p;
    @Nullable
    public GraphQLMediaSetMediaConnection f3333q;
    @Nullable
    public GraphQLMediaSetMediaConnection f3334r;
    @Nullable
    public GraphQLProfile f3335s;
    @Nullable
    public GraphQLTextWithEntities f3336t;
    public long f3337u;
    @Nullable
    public String f3338v;
    @Nullable
    public GraphQLActor f3339w;
    @Nullable
    public GraphQLMediaSetMediaConnection f3340x;
    @Nullable
    public GraphQLPrivacyScope f3341y;
    @Nullable
    public GraphQLTextWithEntities f3342z;

    public GraphQLAlbum$Builder() {
        Preconditions.checkState(this instanceof GraphQLAlbum$Builder);
    }

    public static GraphQLAlbum$Builder m6504a(GraphQLAlbum graphQLAlbum) {
        GraphQLAlbum$Builder graphQLAlbum$Builder = new GraphQLAlbum$Builder();
        graphQLAlbum.h();
        graphQLAlbum$Builder.f3320d = graphQLAlbum.j();
        graphQLAlbum$Builder.f3321e = graphQLAlbum.k();
        graphQLAlbum$Builder.f3322f = graphQLAlbum.l();
        graphQLAlbum$Builder.f3323g = graphQLAlbum.m();
        graphQLAlbum$Builder.f3324h = graphQLAlbum.n();
        graphQLAlbum$Builder.f3325i = graphQLAlbum.o();
        graphQLAlbum$Builder.f3326j = graphQLAlbum.p();
        graphQLAlbum$Builder.f3327k = graphQLAlbum.q();
        graphQLAlbum$Builder.f3328l = graphQLAlbum.r();
        graphQLAlbum$Builder.f3329m = graphQLAlbum.s();
        graphQLAlbum$Builder.f3330n = graphQLAlbum.t();
        graphQLAlbum$Builder.f3331o = graphQLAlbum.u();
        graphQLAlbum$Builder.f3332p = graphQLAlbum.v();
        graphQLAlbum$Builder.f3333q = graphQLAlbum.w();
        graphQLAlbum$Builder.f3334r = graphQLAlbum.H();
        graphQLAlbum$Builder.f3335s = graphQLAlbum.x();
        graphQLAlbum$Builder.f3336t = graphQLAlbum.y();
        graphQLAlbum$Builder.f3337u = graphQLAlbum.z();
        graphQLAlbum$Builder.f3338v = graphQLAlbum.A();
        graphQLAlbum$Builder.f3339w = graphQLAlbum.B();
        graphQLAlbum$Builder.f3340x = graphQLAlbum.C();
        graphQLAlbum$Builder.f3341y = graphQLAlbum.D();
        graphQLAlbum$Builder.f3342z = graphQLAlbum.E();
        graphQLAlbum$Builder.f3318A = graphQLAlbum.F();
        graphQLAlbum$Builder.f3319B = graphQLAlbum.G();
        Builder.a(graphQLAlbum$Builder, graphQLAlbum);
        return graphQLAlbum$Builder;
    }

    public final GraphQLAlbum m6505a() {
        return new GraphQLAlbum(this);
    }
}
