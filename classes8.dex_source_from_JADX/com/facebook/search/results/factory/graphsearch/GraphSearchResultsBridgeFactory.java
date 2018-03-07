package com.facebook.search.results.factory.graphsearch;

import com.facebook.graphql.model.FeedUnit;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchModuleFragmentModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchModuleFragmentModel.SeeMoreQueryModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.ModuleResultEdgeModel;
import com.facebook.search.results.model.SearchResultsBridge;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel;
import com.facebook.search.results.protocol.SearchResultsSeeMoreQueryModels.SearchResultsSeeMoreQueryModel;
import com.facebook.search.results.protocol.SearchResultsSeeMoreQueryModels.SearchResultsSeeMoreQueryModel.QueryTitleModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: START_BLE_SCAN */
public abstract class GraphSearchResultsBridgeFactory extends GraphSearchSingleFeedUnitFactory<SearchResultsBridge> {
    @Nullable
    public abstract EdgesModel mo1267a(ModuleResultEdgeModel moduleResultEdgeModel);

    @Nullable
    protected final FeedUnit mo1261a(KeywordSearchModuleFragmentModel keywordSearchModuleFragmentModel) {
        ImmutableList a;
        if (keywordSearchModuleFragmentModel.m8541g() != null) {
            a = keywordSearchModuleFragmentModel.m8541g().m8515a();
        } else {
            a = RegularImmutableList.a;
        }
        ImmutableList immutableList = a;
        if (immutableList.isEmpty()) {
            return null;
        }
        Builder builder = new Builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            EdgesModel a2 = mo1267a((ModuleResultEdgeModel) immutableList.get(i));
            if (a2 != null) {
                builder.c(a2);
            }
        }
        if (builder.b().isEmpty()) {
            return null;
        }
        SearchResultsSeeMoreQueryModel searchResultsSeeMoreQueryModel;
        SearchResultsEdgeModel.Builder builder2 = new SearchResultsEdgeModel.Builder();
        NodeModel.Builder builder3 = new NodeModel.Builder();
        builder3.f8340Q = keywordSearchModuleFragmentModel.jx_();
        builder3 = builder3;
        builder3.f8363n = keywordSearchModuleFragmentModel.m8536a();
        builder3 = builder3;
        builder3.f8342S = keywordSearchModuleFragmentModel.m8543k();
        builder3 = builder3;
        ModuleResultsModel.Builder builder4 = new ModuleResultsModel.Builder();
        builder4.f8376a = builder.b();
        builder3.f8339P = builder4.m9583a();
        builder3 = builder3;
        SeeMoreQueryModel jy_ = keywordSearchModuleFragmentModel.jy_();
        if (jy_ == null) {
            searchResultsSeeMoreQueryModel = null;
        } else {
            QueryTitleModel queryTitleModel;
            SearchResultsSeeMoreQueryModel.Builder builder5 = new SearchResultsSeeMoreQueryModel.Builder();
            builder5.f8567a = jy_.m8526a();
            builder5 = builder5;
            SeeMoreQueryModel.QueryTitleModel b = jy_.m8527b();
            if (b == null) {
                queryTitleModel = null;
            } else {
                QueryTitleModel.Builder builder6 = new QueryTitleModel.Builder();
                builder6.f8570a = b.m8521a();
                queryTitleModel = builder6.m9832a();
            }
            builder5.f8568b = queryTitleModel;
            builder5 = builder5;
            builder5.f8569c = jy_.m8528c();
            searchResultsSeeMoreQueryModel = builder5.m9830a();
        }
        builder3.ah = searchResultsSeeMoreQueryModel;
        builder2.f8320a = builder3.m9580a();
        return SearchResultsBridge.m27031a(builder2.m9577a(), keywordSearchModuleFragmentModel.m8539c());
    }
}
