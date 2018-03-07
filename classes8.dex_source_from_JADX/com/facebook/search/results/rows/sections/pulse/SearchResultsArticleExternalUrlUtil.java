package com.facebook.search.results.rows.sections.pulse;

import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.SearchResultsEdgeInterfaces.SearchResultsEdge;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlInterfaces.SearchResultsArticleExternalUrl;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.OpenGraphNodeModel;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlModels.SearchResultsArticleExternalUrlModel.OpenGraphNodeModel.Builder;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: PRE_INSTALLED_FONT_SERIF_BOLD */
public class SearchResultsArticleExternalUrlUtil {
    @Nullable
    public static SearchResultsEdge m28286a(SearchResultsProps<SearchResultsArticleExternalUrl> searchResultsProps, GraphQLSavedState graphQLSavedState) {
        if (((SearchResultsArticleExternalUrl) searchResultsProps.f23388a).mo574E() == null) {
            return null;
        }
        OpenGraphNodeModel a = OpenGraphNodeModel.m10460a(((SearchResultsArticleExternalUrl) searchResultsProps.f23388a).mo574E());
        Builder builder = new Builder();
        builder.f8814a = a.m10467b();
        builder.f8815b = a.m10468c();
        builder.f8816c = a.m10469d();
        Builder builder2 = builder;
        builder2.f8816c = graphQLSavedState;
        OpenGraphNodeModel a2 = builder2.m10457a();
        EdgesNodeModel.Builder a3 = EdgesNodeModel.Builder.m9595a((EdgesNodeModel) searchResultsProps.f23388a);
        a3.f8385E = a2;
        EdgesNodeModel a4 = a3.m9596a();
        SearchResultsEdgeModel searchResultsEdgeModel = searchResultsProps.f23390c;
        EdgesModel.Builder a5 = EdgesModel.Builder.m9585a(EdgesModel.m9696a((EdgesModel) searchResultsEdgeModel.m9770a().m9731S().m9710a().get(0)));
        a5.f8377a = a4;
        EdgesModel a6 = a5.m9586a();
        ModuleResultsModel.Builder a7 = ModuleResultsModel.Builder.m9582a(ModuleResultsModel.m9707a(searchResultsEdgeModel.m9770a().m9731S()));
        a7.f8376a = ImmutableList.of(a6);
        ModuleResultsModel a8 = a7.m9583a();
        NodeModel.Builder a9 = NodeModel.Builder.m9579a(NodeModel.m9712a(searchResultsEdgeModel.m9770a()));
        a9.f8339P = a8;
        NodeModel a10 = a9.m9580a();
        SearchResultsEdgeModel.Builder a11 = SearchResultsEdgeModel.Builder.m9576a(SearchResultsEdgeModel.m9767a(searchResultsEdgeModel));
        a11.f8320a = a10;
        return a11.m9577a();
    }
}
