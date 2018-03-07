package com.facebook.search.results.rows.sections.entities;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.model.GraphQLGraphSearchResultsEdge;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.search.results.environment.SearchResultsEntitiesEnvironment;
import com.facebook.search.results.environment.SearchResultsEntitiesEnvironmentGenerated;
import com.facebook.search.results.rows.sections.videos.SearchResultsVideoChannelLargeRowPartDefinition;
import javax.inject.Inject;

@ContextScoped
@Deprecated
/* compiled from: RATING */
public class SearchResultsEntitiesRootGroupPartDefinition extends BaseMultiRowGroupPartDefinition<GraphQLGraphSearchResultsEdge, Void, SearchResultsEntitiesEnvironment> {
    private static SearchResultsEntitiesRootGroupPartDefinition f24147d;
    private static final Object f24148e = new Object();
    private final SearchResultsEntityWithFacepileLargeRowPartDefinition<SearchResultsEntitiesEnvironment> f24149a;
    private final OldSearchResultsEntityLargeRowPartDefinition<SearchResultsEntitiesEnvironment> f24150b;
    private final Lazy<SearchResultsVideoChannelLargeRowPartDefinition<SearchResultsEntitiesEnvironment>> f24151c;

    private static SearchResultsEntitiesRootGroupPartDefinition m27691b(InjectorLike injectorLike) {
        return new SearchResultsEntitiesRootGroupPartDefinition(SearchResultsEntityWithFacepileLargeRowPartDefinition.m27774a(injectorLike), OldSearchResultsEntityLargeRowPartDefinition.m27677a(injectorLike), IdBasedLazy.a(injectorLike, 10814));
    }

    public final Object m27692a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLGraphSearchResultsEdge graphQLGraphSearchResultsEdge = (GraphQLGraphSearchResultsEdge) obj;
        SubPartsSelector.a(baseMultiRowSubParts, ((SearchResultsEntitiesEnvironmentGenerated) anyEnvironment).mo1248s().m27098l() == GraphQLGraphSearchResultsDisplayStyle.VIDEO_PUBLISHERS, this.f24151c, graphQLGraphSearchResultsEdge).a(this.f24149a, graphQLGraphSearchResultsEdge.j()).a(this.f24150b, graphQLGraphSearchResultsEdge);
        return null;
    }

    @Inject
    public SearchResultsEntitiesRootGroupPartDefinition(SearchResultsEntityWithFacepileLargeRowPartDefinition searchResultsEntityWithFacepileLargeRowPartDefinition, OldSearchResultsEntityLargeRowPartDefinition oldSearchResultsEntityLargeRowPartDefinition, Lazy<SearchResultsVideoChannelLargeRowPartDefinition> lazy) {
        this.f24149a = searchResultsEntityWithFacepileLargeRowPartDefinition;
        this.f24150b = oldSearchResultsEntityLargeRowPartDefinition;
        this.f24151c = lazy;
    }

    public final boolean m27693a(Object obj) {
        return true;
    }

    public static SearchResultsEntitiesRootGroupPartDefinition m27690a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsEntitiesRootGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24148e) {
                SearchResultsEntitiesRootGroupPartDefinition searchResultsEntitiesRootGroupPartDefinition;
                if (a2 != null) {
                    searchResultsEntitiesRootGroupPartDefinition = (SearchResultsEntitiesRootGroupPartDefinition) a2.a(f24148e);
                } else {
                    searchResultsEntitiesRootGroupPartDefinition = f24147d;
                }
                if (searchResultsEntitiesRootGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27691b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24148e, b3);
                        } else {
                            f24147d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsEntitiesRootGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
