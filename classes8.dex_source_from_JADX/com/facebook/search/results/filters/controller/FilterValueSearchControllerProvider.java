package com.facebook.search.results.filters.controller;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.model.converter.FilterValueGraphQLModelConverter;
import com.facebook.search.results.filters.loader.FilterValueLoader;
import com.facebook.search.results.filters.loader.OnFilterValuesFetchedListener;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.typeahead.TypeaheadSuggestionListUtilProvider;

/* compiled from: SOLD */
public class FilterValueSearchControllerProvider extends AbstractAssistedProvider<FilterValueSearchController> {
    public final FilterValueSearchController m26421a(OnFilterValuesFetchedListener onFilterValuesFetchedListener) {
        return new FilterValueSearchController(onFilterValuesFetchedListener, new FilterValueLoader(GraphQLQueryExecutor.a(this), ResourcesMethodAutoProvider.a(this), FilterValueGraphQLModelConverter.m25805a((InjectorLike) this), TasksManager.b(this), GraphSearchErrorReporter.a(this)), new FilterValueSuggestionDeduper(), (TypeaheadSuggestionListUtilProvider) getOnDemandAssistedProviderForStaticDi(TypeaheadSuggestionListUtilProvider.class));
    }
}
