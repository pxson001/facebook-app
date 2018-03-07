package com.facebook.search.results.rows.sections.collection;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.search.results.environment.SearchResultsFeedEnvironment;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.rows.sections.common.SearchResultsResultsEmptyFooterPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REQUESTS */
public class SearchResultsFooterPartDefinition<T> extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsCollectionUnit<T>>, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsFooterPartDefinition f23750d;
    private static final Object f23751e = new Object();
    private final SearchResultsResultsEmptyFooterPartDefinition<SearchResultsCollectionUnit<?>> f23752a;
    private final SearchResultsSeeMorePartDefinition<T, SearchResultsFeedEnvironment> f23753b;
    private final SearchResultsSeeMoreFigPartDefinition<T, SearchResultsFeedEnvironment> f23754c;

    private static SearchResultsFooterPartDefinition m27397b(InjectorLike injectorLike) {
        return new SearchResultsFooterPartDefinition(SearchResultsSeeMorePartDefinition.m27455a(injectorLike), SearchResultsSeeMoreFigPartDefinition.m27447a(injectorLike), SearchResultsResultsEmptyFooterPartDefinition.m27592a(injectorLike));
    }

    public final Object m27398a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f23754c, feedProps).a(this.f23753b, feedProps).a(this.f23752a, feedProps.a);
        return null;
    }

    public final boolean m27399a(Object obj) {
        return ((SearchResultsCollectionUnit) ((FeedProps) obj).a).mo1321k() != GraphQLGraphSearchResultRole.PROMOTED_ENTITY_MEDIA;
    }

    @Inject
    public SearchResultsFooterPartDefinition(SearchResultsSeeMorePartDefinition searchResultsSeeMorePartDefinition, SearchResultsSeeMoreFigPartDefinition searchResultsSeeMoreFigPartDefinition, SearchResultsResultsEmptyFooterPartDefinition searchResultsResultsEmptyFooterPartDefinition) {
        this.f23754c = searchResultsSeeMoreFigPartDefinition;
        this.f23752a = searchResultsResultsEmptyFooterPartDefinition;
        this.f23753b = searchResultsSeeMorePartDefinition;
    }

    public static SearchResultsFooterPartDefinition m27396a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23751e) {
                SearchResultsFooterPartDefinition searchResultsFooterPartDefinition;
                if (a2 != null) {
                    searchResultsFooterPartDefinition = (SearchResultsFooterPartDefinition) a2.a(f23751e);
                } else {
                    searchResultsFooterPartDefinition = f23750d;
                }
                if (searchResultsFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27397b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23751e, b3);
                        } else {
                            f23750d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
