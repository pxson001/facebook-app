package com.facebook.search.results.factory.graphsearch;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLInterfaces.KeywordSearchModuleFragment;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLInterfaces.KeywordSearchModuleFragment.Results;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchModuleFragmentModel.SeeMoreQueryModel;
import com.facebook.search.results.factory.SearchResultsFeedUnitFactory;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: SUGGESTION */
public abstract class GraphSearchBaseCollectionUnitFactory<T> implements SearchResultsFeedUnitFactory<KeywordSearchModuleFragment, SearchResultsCollectionUnit<T>> {
    protected abstract ImmutableList<T> mo1262a(Results results, @Nullable String str);

    @Nullable
    protected abstract GraphQLObjectType mo1263b(@Nullable T t);

    @Nullable
    protected abstract String mo1264c(T t);

    public ImmutableList<SearchResultsCollectionUnit<T>> mo1266a(KeywordSearchModuleFragment keywordSearchModuleFragment) {
        ImmutableList a;
        String str = null;
        if (keywordSearchModuleFragment.m8541g() != null) {
            a = mo1262a(keywordSearchModuleFragment.m8541g(), keywordSearchModuleFragment.m8539c());
        } else {
            a = RegularImmutableList.a;
        }
        if (a.isEmpty()) {
            return RegularImmutableList.a;
        }
        Builder builder = new Builder();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            String c = mo1264c(a.get(i));
            if (c != null) {
                builder.c(c);
            }
        }
        GraphQLObjectType b = mo1263b(a.get(0));
        SeeMoreQueryModel jy_ = keywordSearchModuleFragment.jy_();
        String a2 = jy_ != null ? jy_.m8526a() : null;
        if (!(jy_ == null || jy_.m8527b() == null)) {
            str = jy_.m8527b().m8521a();
        }
        return ImmutableList.of(new SearchResultsCollectionUnit(GraphSearchModulesUtil.m26327a(keywordSearchModuleFragment), keywordSearchModuleFragment.jx_(), keywordSearchModuleFragment.m8543k(), a, builder.b(), b, a2, str, Integer.valueOf(keywordSearchModuleFragment.m8538b()), keywordSearchModuleFragment.m8539c()));
    }
}
