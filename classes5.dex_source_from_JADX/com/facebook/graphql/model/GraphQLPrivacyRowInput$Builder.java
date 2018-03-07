package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLPrivacyBaseState;
import com.facebook.graphql.enums.GraphQLPrivacyTagExpansionState;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: VideoChannel */
public class GraphQLPrivacyRowInput$Builder extends Builder {
    public ImmutableList<String> f12706d;
    public GraphQLPrivacyBaseState f12707e = GraphQLPrivacyBaseState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public ImmutableList<String> f12708f;
    public GraphQLPrivacyTagExpansionState f12709g = GraphQLPrivacyTagExpansionState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;

    public GraphQLPrivacyRowInput$Builder() {
        Preconditions.checkState(this instanceof GraphQLPrivacyRowInput$Builder);
    }

    public static GraphQLPrivacyRowInput$Builder m21020a(GraphQLPrivacyRowInput graphQLPrivacyRowInput) {
        GraphQLPrivacyRowInput$Builder graphQLPrivacyRowInput$Builder = new GraphQLPrivacyRowInput$Builder();
        graphQLPrivacyRowInput.h();
        graphQLPrivacyRowInput$Builder.f12706d = graphQLPrivacyRowInput.a();
        graphQLPrivacyRowInput$Builder.f12707e = graphQLPrivacyRowInput.j();
        graphQLPrivacyRowInput$Builder.f12708f = graphQLPrivacyRowInput.k();
        graphQLPrivacyRowInput$Builder.f12709g = graphQLPrivacyRowInput.l();
        Builder.a(graphQLPrivacyRowInput$Builder, graphQLPrivacyRowInput);
        return graphQLPrivacyRowInput$Builder;
    }

    public final GraphQLPrivacyRowInput m21021a() {
        return new GraphQLPrivacyRowInput(this);
    }
}
