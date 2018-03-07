package com.facebook.search.results.rows.sections.binders;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;

/* compiled from: RETURN_FROM_APP_STORE */
public class GraphQLNodeViewerLikeStateKey implements ContextStateKey<String, Boolean> {
    private final String f23631a;
    private final boolean f23632b;

    @Deprecated
    public GraphQLNodeViewerLikeStateKey(GraphQLNode graphQLNode) {
        this.f23631a = graphQLNode.dp();
        this.f23632b = graphQLNode.bP();
    }

    public GraphQLNodeViewerLikeStateKey(NodeModel nodeModel) {
        this.f23631a = nodeModel.mo572C();
        this.f23632b = nodeModel.m9758s();
    }

    public final Object m27291b() {
        return this.f23631a;
    }

    public final Object m27290a() {
        return Boolean.valueOf(this.f23632b);
    }
}
