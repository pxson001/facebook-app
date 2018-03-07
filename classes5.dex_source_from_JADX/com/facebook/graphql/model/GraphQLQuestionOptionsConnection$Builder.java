package com.facebook.graphql.model;

import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: VIEW_PROFILE */
public class GraphQLQuestionOptionsConnection$Builder extends Builder {
    public ImmutableList<GraphQLQuestionOption> f12842d;

    public GraphQLQuestionOptionsConnection$Builder() {
        Preconditions.checkState(this instanceof GraphQLQuestionOptionsConnection$Builder);
    }

    public static GraphQLQuestionOptionsConnection$Builder m21185a(GraphQLQuestionOptionsConnection graphQLQuestionOptionsConnection) {
        GraphQLQuestionOptionsConnection$Builder graphQLQuestionOptionsConnection$Builder = new GraphQLQuestionOptionsConnection$Builder();
        graphQLQuestionOptionsConnection.h();
        graphQLQuestionOptionsConnection$Builder.f12842d = graphQLQuestionOptionsConnection.a();
        Builder.a(graphQLQuestionOptionsConnection$Builder, graphQLQuestionOptionsConnection);
        return graphQLQuestionOptionsConnection$Builder;
    }

    public final GraphQLQuestionOptionsConnection m21186a() {
        return new GraphQLQuestionOptionsConnection(this);
    }
}
