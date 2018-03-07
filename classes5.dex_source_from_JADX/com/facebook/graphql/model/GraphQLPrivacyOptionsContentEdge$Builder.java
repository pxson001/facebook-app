package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLPrivacyOptionInfoType;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: VideoGuidedTourKeyframe */
public class GraphQLPrivacyOptionsContentEdge$Builder extends Builder {
    public boolean f12703d;
    @Nullable
    public GraphQLPrivacyOption f12704e;
    public GraphQLPrivacyOptionInfoType f12705f = GraphQLPrivacyOptionInfoType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;

    public GraphQLPrivacyOptionsContentEdge$Builder() {
        Preconditions.checkState(this instanceof GraphQLPrivacyOptionsContentEdge$Builder);
    }

    public static GraphQLPrivacyOptionsContentEdge$Builder m21011a(GraphQLPrivacyOptionsContentEdge graphQLPrivacyOptionsContentEdge) {
        GraphQLPrivacyOptionsContentEdge$Builder graphQLPrivacyOptionsContentEdge$Builder = new GraphQLPrivacyOptionsContentEdge$Builder();
        graphQLPrivacyOptionsContentEdge.h();
        graphQLPrivacyOptionsContentEdge$Builder.f12703d = graphQLPrivacyOptionsContentEdge.a();
        graphQLPrivacyOptionsContentEdge$Builder.f12704e = graphQLPrivacyOptionsContentEdge.j();
        graphQLPrivacyOptionsContentEdge$Builder.f12705f = graphQLPrivacyOptionsContentEdge.k();
        Builder.a(graphQLPrivacyOptionsContentEdge$Builder, graphQLPrivacyOptionsContentEdge);
        return graphQLPrivacyOptionsContentEdge$Builder;
    }

    public final GraphQLPrivacyOptionsContentEdge m21012a() {
        return new GraphQLPrivacyOptionsContentEdge(this);
    }
}
