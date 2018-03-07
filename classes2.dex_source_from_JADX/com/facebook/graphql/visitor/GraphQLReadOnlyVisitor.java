package com.facebook.graphql.visitor;

/* compiled from: logVideoUnPausedEvent */
public abstract class GraphQLReadOnlyVisitor implements GraphQLModelMutatingVisitor {
    protected abstract boolean mo2927a(GraphQLVisitableModel graphQLVisitableModel);

    public final GraphQLVisitableModel mo2928b(GraphQLVisitableModel graphQLVisitableModel) {
        if (mo2927a(graphQLVisitableModel)) {
            graphQLVisitableModel.mo1404a(this);
        }
        return graphQLVisitableModel;
    }
}
