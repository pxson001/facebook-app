package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: VideoTimestampedCommentsEdge */
public class GraphQLPrivacyOptionsContentConnection$Builder extends Builder {
    public ImmutableList<GraphQLPrivacyOptionsContentEdge> f12702d;

    public GraphQLPrivacyOptionsContentConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLPrivacyOptionsContentConnection$Builder);
    }

    public static GraphQLPrivacyOptionsContentConnection$Builder m21003a(GraphQLPrivacyOptionsContentConnection graphQLPrivacyOptionsContentConnection) {
        GraphQLPrivacyOptionsContentConnection$Builder graphQLPrivacyOptionsContentConnection$Builder = new GraphQLPrivacyOptionsContentConnection$Builder();
        graphQLPrivacyOptionsContentConnection.h();
        graphQLPrivacyOptionsContentConnection$Builder.f12702d = graphQLPrivacyOptionsContentConnection.a();
        Builder.a(graphQLPrivacyOptionsContentConnection$Builder, graphQLPrivacyOptionsContentConnection);
        return graphQLPrivacyOptionsContentConnection$Builder;
    }

    public final GraphQLPrivacyOptionsContentConnection m21004a() {
        return new GraphQLPrivacyOptionsContentConnection(this);
    }
}
