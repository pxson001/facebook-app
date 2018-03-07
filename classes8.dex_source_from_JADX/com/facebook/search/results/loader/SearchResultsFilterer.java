package com.facebook.search.results.loader;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.results.protocol.SearchResultsEdgeInterfaces.SearchResultsEdge;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: SEARCH_ICON_CLICKED */
public class SearchResultsFilterer {
    private static SearchResultsFilterer f23231b;
    private static final Object f23232c = new Object();
    public final GraphSearchErrorReporter f23233a;

    private static SearchResultsFilterer m26940b(InjectorLike injectorLike) {
        return new SearchResultsFilterer(GraphSearchErrorReporter.a(injectorLike));
    }

    @Inject
    public SearchResultsFilterer(GraphSearchErrorReporter graphSearchErrorReporter) {
        this.f23233a = graphSearchErrorReporter;
    }

    public final ImmutableList<SearchResultsEdge> m26941a(ImmutableList<SearchResultsEdge> immutableList) {
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            if (m26939a((SearchResultsEdgeModel) immutableList.get(i))) {
                i++;
            } else {
                Builder builder = new Builder();
                int size2 = immutableList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    SearchResultsEdgeModel searchResultsEdgeModel = (SearchResultsEdgeModel) immutableList.get(i2);
                    if (m26939a(searchResultsEdgeModel)) {
                        builder.c(searchResultsEdgeModel);
                    } else {
                        this.f23233a.a(GraphSearchError.INVALID_SEARCH_RESULT, searchResultsEdgeModel.toString());
                    }
                }
                return builder.b();
            }
        }
        return immutableList;
    }

    public static boolean m26939a(SearchResultsEdgeModel searchResultsEdgeModel) {
        return SearchResultsEdgeUtil.m9799a(searchResultsEdgeModel) != GraphQLGraphSearchResultRole.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }

    public static SearchResultsFilterer m26938a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsFilterer b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23232c) {
                SearchResultsFilterer searchResultsFilterer;
                if (a2 != null) {
                    searchResultsFilterer = (SearchResultsFilterer) a2.a(f23232c);
                } else {
                    searchResultsFilterer = f23231b;
                }
                if (searchResultsFilterer == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26940b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23232c, b3);
                        } else {
                            f23231b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsFilterer;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
