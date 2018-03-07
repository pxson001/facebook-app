package com.facebook.search.results.rows.sections.binders;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;

/* compiled from: REVIEW */
public class GraphQLNodeViewerGuestStateKey implements ContextStateKey<String, GraphQLEventGuestStatus> {
    private final String f23627a;
    private final GraphQLEventGuestStatus f23628b;

    @Deprecated
    public GraphQLNodeViewerGuestStateKey(GraphQLNode graphQLNode) {
        this.f23627a = graphQLNode.dp();
        this.f23628b = graphQLNode.je();
    }

    public GraphQLNodeViewerGuestStateKey(NodeModel nodeModel) {
        this.f23627a = nodeModel.mo572C();
        this.f23628b = nodeModel.aw();
    }

    public final Object m27287b() {
        return this.f23627a;
    }

    public final Object m27286a() {
        return this.f23628b;
    }
}
