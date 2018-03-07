package com.facebook.search.results.rows.sections.binders;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;

/* compiled from: RETURN_TO_COMPOSER */
public class GraphQLNodeViewerJoinStateKey implements ContextStateKey<String, GraphQLGroupJoinState> {
    private final String f23629a;
    private final GraphQLGroupJoinState f23630b;

    @Deprecated
    public GraphQLNodeViewerJoinStateKey(GraphQLNode graphQLNode) {
        this.f23629a = graphQLNode.dp();
        this.f23630b = graphQLNode.ji();
    }

    public GraphQLNodeViewerJoinStateKey(NodeModel nodeModel) {
        this.f23629a = nodeModel.mo572C();
        this.f23630b = nodeModel.ax();
    }

    public final Object m27289b() {
        return this.f23629a;
    }

    public final Object m27288a() {
        return this.f23630b;
    }
}
