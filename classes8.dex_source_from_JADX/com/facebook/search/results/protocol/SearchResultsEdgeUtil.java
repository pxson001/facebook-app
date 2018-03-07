package com.facebook.search.results.protocol;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.search.results.protocol.SearchResultsEdgeInterfaces.SearchResultsEdge;
import com.facebook.search.results.protocol.SearchResultsEdgeInterfaces.SearchResultsEdge.Node.ModuleResults.Edges;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: module_impression */
public class SearchResultsEdgeUtil {
    public static GraphQLGraphSearchResultRole m9799a(SearchResultsEdgeModel searchResultsEdgeModel) {
        if (searchResultsEdgeModel.m9773d() == null || searchResultsEdgeModel.m9773d() == GraphQLGraphSearchResultRole.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            return m9800b(searchResultsEdgeModel);
        }
        return searchResultsEdgeModel.m9773d();
    }

    public static GraphQLGraphSearchResultRole m9800b(SearchResultsEdgeModel searchResultsEdgeModel) {
        NodeModel a = searchResultsEdgeModel.m9770a();
        return (a == null || a.m9732T() == null) ? GraphQLGraphSearchResultRole.UNSET_OR_UNRECOGNIZED_ENUM_VALUE : a.m9732T();
    }

    public static GraphQLGraphSearchResultsDisplayStyle m9801c(SearchResultsEdgeModel searchResultsEdgeModel) {
        if (!searchResultsEdgeModel.m9772c().isEmpty()) {
            return (GraphQLGraphSearchResultsDisplayStyle) searchResultsEdgeModel.m9772c().get(0);
        }
        NodeModel a = searchResultsEdgeModel.m9770a();
        return (a == null || a.m9757r().isEmpty()) ? GraphQLGraphSearchResultsDisplayStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE : (GraphQLGraphSearchResultsDisplayStyle) a.m9757r().get(0);
    }

    @Nullable
    public static String m9802d(SearchResultsEdgeModel searchResultsEdgeModel) {
        if (searchResultsEdgeModel.m9770a() != null) {
            return searchResultsEdgeModel.m9770a().m9734V();
        }
        return null;
    }

    public static ImmutableList<? extends Edges> m9803e(SearchResultsEdge searchResultsEdge) {
        return (searchResultsEdge.m9770a() == null || searchResultsEdge.m9770a().m9731S() == null) ? RegularImmutableList.a : searchResultsEdge.m9770a().m9731S().m9710a();
    }

    public static int m9798a(EdgesNodeModel edgesNodeModel, SearchResultsEdgeModel searchResultsEdgeModel) {
        ImmutableList e = m9803e(searchResultsEdgeModel);
        for (int i = 0; i < e.size(); i++) {
            if (((EdgesModel) e.get(i)).m9699a() == edgesNodeModel) {
                return i;
            }
        }
        throw new IllegalArgumentException("Node: " + edgesNodeModel + " not found in parent edge: " + searchResultsEdgeModel);
    }

    public static int m9804f(SearchResultsEdgeModel searchResultsEdgeModel) {
        return m9803e(searchResultsEdgeModel).size();
    }
}
