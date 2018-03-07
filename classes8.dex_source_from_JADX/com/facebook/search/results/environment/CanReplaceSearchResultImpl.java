package com.facebook.search.results.environment;

import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.search.results.model.SearchResultUnit;
import com.facebook.search.results.model.SearchResultsCollection;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.Builder;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel.EdgesNodeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeUtil;
import com.facebook.story.GraphQLStoryHelper;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Suggested Photos */
public class CanReplaceSearchResultImpl implements CanReplaceSearchResult {
    private final SearchResultsCollection f22539a;
    private final HasSearchResultPosition f22540b;

    @Inject
    public CanReplaceSearchResultImpl(@Assisted SearchResultsCollection searchResultsCollection, @Assisted HasSearchResultPosition hasSearchResultPosition) {
        this.f22539a = searchResultsCollection;
        this.f22540b = hasSearchResultPosition;
    }

    public final boolean mo1244a(FeedUnit feedUnit) {
        for (SearchResultUnit searchResultUnit : this.f22539a.m27044g()) {
            if (m26014a(searchResultUnit.f23325a, feedUnit)) {
                return true;
            }
        }
        return false;
    }

    public final void mo1243a(SearchResultsEdgeModel searchResultsEdgeModel, SearchResultsEdgeModel searchResultsEdgeModel2) {
        int a = this.f22540b.mo1247a(searchResultsEdgeModel);
        if (a != -1) {
            SearchResultsCollection searchResultsCollection = this.f22539a;
            SearchResultUnit searchResultUnit = (SearchResultUnit) searchResultsCollection.f23338b.set(a, new SearchResultUnit(searchResultsEdgeModel2));
        }
    }

    public final void mo1242a(GraphQLStory graphQLStory) {
        for (SearchResultUnit searchResultUnit : this.f22539a.m27044g()) {
            SearchResultsEdgeModel searchResultsEdgeModel = searchResultUnit.f23325a;
            SearchResultsEdgeModel a = m26013a(searchResultsEdgeModel, graphQLStory);
            if (a != null) {
                mo1243a(searchResultsEdgeModel, a);
                return;
            }
        }
    }

    @Nullable
    public static SearchResultsEdgeModel m26013a(SearchResultsEdgeModel searchResultsEdgeModel, GraphQLStory graphQLStory) {
        NodeModel a = searchResultsEdgeModel.m9770a();
        if (a == null) {
            return null;
        }
        if (GraphQLStoryHelper.a(a.mo591p(), graphQLStory)) {
            Builder a2 = Builder.m9579a(NodeModel.m9712a(a));
            a2.f8361l = graphQLStory;
            a = a2.m9580a();
            SearchResultsEdgeModel.Builder a3 = SearchResultsEdgeModel.Builder.m9576a(SearchResultsEdgeModel.m9767a(searchResultsEdgeModel));
            a3.f8320a = a;
            return a3.m9577a();
        }
        ModuleResultsModel S = a.m9731S();
        if (S == null) {
            return null;
        }
        ImmutableList a4 = S.m9710a();
        int size = a4.size();
        int i = 0;
        while (i < size) {
            EdgesNodeModel a5 = ((EdgesModel) a4.get(i)).m9699a();
            if (a5 == null || !GraphQLStoryHelper.a(a5.mo591p(), graphQLStory)) {
                i++;
            } else {
                EdgesNodeModel.Builder a6 = EdgesNodeModel.Builder.m9595a(EdgesNodeModel.m9641a(a5));
                a6.f8410f = graphQLStory;
                EdgesNodeModel a7 = a6.m9596a();
                int a8 = SearchResultsEdgeUtil.m9798a(a5, searchResultsEdgeModel);
                ImmutableList e = SearchResultsEdgeUtil.m9803e(searchResultsEdgeModel);
                ImmutableList.Builder builder = new ImmutableList.Builder();
                for (int i2 = 0; i2 < e.size(); i2++) {
                    EdgesModel a9 = EdgesModel.m9696a((EdgesModel) e.get(i2));
                    if (i2 != a8) {
                        builder.c(a9);
                    } else {
                        EdgesModel.Builder a10 = EdgesModel.Builder.m9585a(a9);
                        a10.f8377a = a7;
                        builder.c(a10.m9586a());
                    }
                }
                SearchResultsEdgeModel a11 = SearchResultsEdgeModel.m9767a(searchResultsEdgeModel);
                ModuleResultsModel moduleResultsModel = (ModuleResultsModel) Preconditions.checkNotNull(((NodeModel) Preconditions.checkNotNull(a11.m9774j())).aO());
                SearchResultsEdgeModel.Builder a12 = SearchResultsEdgeModel.Builder.m9576a(a11);
                Builder a13 = Builder.m9579a(a11.m9774j());
                ModuleResultsModel.Builder a14 = ModuleResultsModel.Builder.m9582a(moduleResultsModel);
                a14.f8376a = builder.b();
                a13.f8339P = a14.m9583a();
                a12.f8320a = a13.m9580a();
                return a12.m9577a();
            }
        }
        return null;
    }

    public static boolean m26014a(SearchResultsEdgeModel searchResultsEdgeModel, FeedUnit feedUnit) {
        if (!(feedUnit instanceof GraphQLStory)) {
            return false;
        }
        GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
        NodeModel a = searchResultsEdgeModel.m9770a();
        if (a == null) {
            return false;
        }
        if (GraphQLStoryHelper.a(graphQLStory, a.mo591p())) {
            return true;
        }
        ModuleResultsModel S = a.m9731S();
        if (S == null) {
            return false;
        }
        ImmutableList a2 = S.m9710a();
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            EdgesNodeModel a3 = ((EdgesModel) a2.get(i)).m9699a();
            if (a3 != null && GraphQLStoryHelper.a(a3.mo591p(), graphQLStory)) {
                return true;
            }
        }
        return false;
    }
}
