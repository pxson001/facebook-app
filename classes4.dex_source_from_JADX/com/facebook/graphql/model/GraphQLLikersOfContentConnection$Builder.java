package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: rtc_voicemail_asset_url_ */
public class GraphQLLikersOfContentConnection$Builder extends Builder {
    public int f3156d;
    public ImmutableList<GraphQLActor> f3157e;
    @Nullable
    public GraphQLPageInfo f3158f;

    public GraphQLLikersOfContentConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLLikersOfContentConnection$Builder);
    }

    public static GraphQLLikersOfContentConnection$Builder m3397a(GraphQLLikersOfContentConnection graphQLLikersOfContentConnection) {
        GraphQLLikersOfContentConnection$Builder graphQLLikersOfContentConnection$Builder = new GraphQLLikersOfContentConnection$Builder();
        graphQLLikersOfContentConnection.h();
        graphQLLikersOfContentConnection$Builder.f3156d = graphQLLikersOfContentConnection.a();
        graphQLLikersOfContentConnection$Builder.f3157e = graphQLLikersOfContentConnection.j();
        graphQLLikersOfContentConnection$Builder.f3158f = graphQLLikersOfContentConnection.k();
        Builder.a(graphQLLikersOfContentConnection$Builder, graphQLLikersOfContentConnection);
        return graphQLLikersOfContentConnection$Builder;
    }

    public final GraphQLLikersOfContentConnection$Builder m3398a(int i) {
        this.f3156d = i;
        if (this.a != null && this.a.d) {
            this.a.b(this.b, 0, i);
        }
        return this;
    }

    public final GraphQLLikersOfContentConnection m3399a() {
        return new GraphQLLikersOfContentConnection(this);
    }
}
