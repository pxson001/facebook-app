package com.facebook.search.results.model.mutator;

import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLNode.Builder;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.SearchResultsEdgeInterfaces.SearchResultsEdge;
import com.facebook.search.results.protocol.SearchResultsEdgeInterfaces.SearchResultsEdge.Node;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;
import com.google.common.collect.ImmutableMap;

/* compiled from: RichDocumentGetAction */
public class SearchResultsGraphQLNodeMutator {
    private static final ImmutableMap<GraphQLFriendshipStatus, GraphQLFriendshipStatus> f23402a = ImmutableMap.of(GraphQLFriendshipStatus.CAN_REQUEST, GraphQLFriendshipStatus.OUTGOING_REQUEST, GraphQLFriendshipStatus.OUTGOING_REQUEST, GraphQLFriendshipStatus.CAN_REQUEST, GraphQLFriendshipStatus.INCOMING_REQUEST, GraphQLFriendshipStatus.ARE_FRIENDS);

    public static GraphQLNode m27119a(GraphQLNode graphQLNode) {
        int g = graphQLNode.j() != null ? graphQLNode.j().g() : 0;
        switch (g) {
            case 2479791:
                boolean z;
                Builder a = Builder.a(graphQLNode);
                if (graphQLNode.bP()) {
                    z = false;
                } else {
                    z = true;
                }
                a.bY = z;
                return a.a();
            case 2645995:
                return m27122b(graphQLNode);
            case 67338874:
                return m27126e(graphQLNode);
            case 69076575:
                return m27124d(graphQLNode);
            default:
                throw new IllegalArgumentException("Unsupported node type: " + g);
        }
    }

    public static SearchResultsEdge m27120a(SearchResultsProps<Node> searchResultsProps) {
        if (searchResultsProps.m27108f()) {
            throw new UnsupportedOperationException("Edge mutation currently only implemented for top-level nodes that are not within a module.");
        }
        SearchResultsEdgeModel searchResultsEdgeModel = searchResultsProps.f23390c;
        NodeModel nodeModel = (NodeModel) searchResultsProps.f23388a;
        int g = nodeModel.m9745b() != null ? nodeModel.m9745b().g() : 0;
        switch (g) {
            case 2479791:
                boolean z;
                NodeModel a = searchResultsEdgeModel.m9770a();
                SearchResultsEdgeModel.Builder a2 = SearchResultsEdgeModel.Builder.m9576a(SearchResultsEdgeModel.m9767a(searchResultsEdgeModel));
                NodeModel.Builder a3 = NodeModel.Builder.m9579a(NodeModel.m9712a(a));
                if (a.m9758s()) {
                    z = false;
                } else {
                    z = true;
                }
                a3.f8364o = z;
                a2.f8320a = a3.m9580a();
                return a2.m9577a();
            case 2645995:
                return m27121a(searchResultsEdgeModel);
            case 67338874:
                return m27125d(searchResultsEdgeModel);
            case 69076575:
                return m27123c(searchResultsEdgeModel);
            default:
                throw new IllegalArgumentException("Unsupported node type: " + g);
        }
    }

    private static GraphQLNode m27122b(GraphQLNode graphQLNode) {
        GraphQLFriendshipStatus graphQLFriendshipStatus = (GraphQLFriendshipStatus) f23402a.get(graphQLNode.cU());
        return graphQLFriendshipStatus == null ? graphQLNode : Builder.a(graphQLNode).a(graphQLFriendshipStatus).a();
    }

    private static SearchResultsEdgeModel m27121a(SearchResultsEdgeModel searchResultsEdgeModel) {
        NodeModel a = searchResultsEdgeModel.m9770a();
        GraphQLFriendshipStatus graphQLFriendshipStatus = (GraphQLFriendshipStatus) f23402a.get(a.m9762w());
        if (graphQLFriendshipStatus == null) {
            return searchResultsEdgeModel;
        }
        SearchResultsEdgeModel.Builder a2 = SearchResultsEdgeModel.Builder.m9576a(SearchResultsEdgeModel.m9767a(searchResultsEdgeModel));
        NodeModel.Builder a3 = NodeModel.Builder.m9579a(NodeModel.m9712a(a));
        a3.f8368s = graphQLFriendshipStatus;
        a2.f8320a = a3.m9580a();
        return a2.m9577a();
    }

    private static GraphQLNode m27124d(GraphQLNode graphQLNode) {
        if (graphQLNode.ji() == GraphQLGroupJoinState.REQUESTED) {
            return graphQLNode;
        }
        Builder a = Builder.a(graphQLNode);
        GraphQLGroupJoinState graphQLGroupJoinState = GraphQLGroupJoinState.REQUESTED;
        a.kA = graphQLGroupJoinState;
        if (a.a != null && a.a.d) {
            a.a.a(a.b, 532, graphQLGroupJoinState);
        }
        return a.a();
    }

    private static SearchResultsEdgeModel m27123c(SearchResultsEdgeModel searchResultsEdgeModel) {
        NodeModel a = searchResultsEdgeModel.m9770a();
        if (a.ax() == GraphQLGroupJoinState.REQUESTED) {
            return searchResultsEdgeModel;
        }
        SearchResultsEdgeModel.Builder a2 = SearchResultsEdgeModel.Builder.m9576a(SearchResultsEdgeModel.m9767a(searchResultsEdgeModel));
        NodeModel.Builder a3 = NodeModel.Builder.m9579a(NodeModel.m9712a(a));
        a3.av = GraphQLGroupJoinState.REQUESTED;
        a2.f8320a = a3.m9580a();
        return a2.m9577a();
    }

    private static GraphQLNode m27126e(GraphQLNode graphQLNode) {
        return graphQLNode.je() == GraphQLEventGuestStatus.GOING ? graphQLNode : Builder.a(graphQLNode).a(GraphQLEventGuestStatus.GOING).a();
    }

    private static SearchResultsEdgeModel m27125d(SearchResultsEdgeModel searchResultsEdgeModel) {
        NodeModel a = searchResultsEdgeModel.m9770a();
        if (a.aw() == GraphQLEventGuestStatus.GOING) {
            return searchResultsEdgeModel;
        }
        SearchResultsEdgeModel.Builder a2 = SearchResultsEdgeModel.Builder.m9576a(SearchResultsEdgeModel.m9767a(searchResultsEdgeModel));
        NodeModel.Builder a3 = NodeModel.Builder.m9579a(NodeModel.m9712a(a));
        a3.au = GraphQLEventGuestStatus.GOING;
        a2.f8320a = a3.m9580a();
        return a2.m9577a();
    }
}
