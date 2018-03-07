package com.facebook.search.results.rows.sections.commerce;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
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
import com.facebook.search.results.environment.SearchResultsFeedEnvironmentGenerated;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.model.unit.SearchResultsProductItemUnit;
import com.facebook.search.results.rows.sections.collection.SearchResultsFooterPartDefinition;
import com.facebook.search.results.rows.sections.header.SearchResultsCommerceHeaderComponentPartDefinition;
import com.facebook.search.results.rows.sections.header.SearchResultsCommerceHeaderComponentPartDefinition.HeaderProps;
import javax.inject.Inject;

@ContextScoped
/* compiled from: READY */
public class SearchResultsCommerceGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsCollectionUnit<SearchResultsProductItemUnit>>, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsCommerceGroupPartDefinition f23961e;
    private static final Object f23962f = new Object();
    private final CommerceItemSelectorPartDefinition f23963a;
    private final SearchResultsCommerceHeaderComponentPartDefinition f23964b;
    private final SearchResultsCommerceTitleTogglePartDefinition f23965c;
    private final SearchResultsFooterPartDefinition<SearchResultsProductItemUnit> f23966d;

    private static SearchResultsCommerceGroupPartDefinition m27545b(InjectorLike injectorLike) {
        return new SearchResultsCommerceGroupPartDefinition(SearchResultsCommerceHeaderComponentPartDefinition.m27855a(injectorLike), SearchResultsCommerceTitleTogglePartDefinition.m27550a(injectorLike), CommerceItemSelectorPartDefinition.m27467a(injectorLike), SearchResultsFooterPartDefinition.m27396a(injectorLike));
    }

    public final Object m27546a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SearchResultsFeedEnvironmentGenerated searchResultsFeedEnvironmentGenerated = (SearchResultsFeedEnvironmentGenerated) anyEnvironment;
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) feedProps.a;
        GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle = (GraphQLGraphSearchResultsDisplayStyle) searchResultsCollectionUnit.f23460a.orNull();
        boolean z = graphQLGraphSearchResultsDisplayStyle == GraphQLGraphSearchResultsDisplayStyle.ENTITY_HSCROLL;
        if (!z && searchResultsFeedEnvironmentGenerated.mo1245a(searchResultsCollectionUnit) == 0) {
            baseMultiRowSubParts.a(this.f23965c, feedProps);
        } else if (graphQLGraphSearchResultsDisplayStyle == GraphQLGraphSearchResultsDisplayStyle.ENTITY_HSCROLL || (graphQLGraphSearchResultsDisplayStyle == GraphQLGraphSearchResultsDisplayStyle.SALE_POST && searchResultsFeedEnvironmentGenerated.mo1245a(searchResultsCollectionUnit) == 0)) {
            int intValue;
            String str;
            if (searchResultsCollectionUnit.f23468i.isPresent()) {
                intValue = ((Integer) searchResultsCollectionUnit.f23468i.get()).intValue();
            } else {
                intValue = 0;
            }
            int i = intValue;
            Resources resources = searchResultsFeedEnvironmentGenerated.getContext().getResources();
            String str2 = (String) searchResultsCollectionUnit.f23462c.get();
            if (i <= 0 || !z) {
                str = null;
            } else {
                str = resources.getQuantityString(2131689717, i, new Object[]{Integer.valueOf(i)});
            }
            baseMultiRowSubParts.a(this.f23964b, new HeaderProps(str2, str, Boolean.valueOf(z)));
        }
        baseMultiRowSubParts.a(this.f23963a, feedProps);
        if (z) {
            baseMultiRowSubParts.a(this.f23966d, feedProps);
        }
        return null;
    }

    public final boolean m27547a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return ((SearchResultsCollectionUnit) feedProps.a).mo1321k() == GraphQLGraphSearchResultRole.COMMERCE_B2C || ((SearchResultsCollectionUnit) feedProps.a).mo1321k() == GraphQLGraphSearchResultRole.COMMERCE_C2C || ((SearchResultsCollectionUnit) feedProps.a).mo1321k() == GraphQLGraphSearchResultRole.COMMERCE_COMBINED;
    }

    @Inject
    public SearchResultsCommerceGroupPartDefinition(SearchResultsCommerceHeaderComponentPartDefinition searchResultsCommerceHeaderComponentPartDefinition, SearchResultsCommerceTitleTogglePartDefinition searchResultsCommerceTitleTogglePartDefinition, CommerceItemSelectorPartDefinition commerceItemSelectorPartDefinition, SearchResultsFooterPartDefinition searchResultsFooterPartDefinition) {
        this.f23964b = searchResultsCommerceHeaderComponentPartDefinition;
        this.f23965c = searchResultsCommerceTitleTogglePartDefinition;
        this.f23963a = commerceItemSelectorPartDefinition;
        this.f23966d = searchResultsFooterPartDefinition;
    }

    public static SearchResultsCommerceGroupPartDefinition m27544a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsCommerceGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23962f) {
                SearchResultsCommerceGroupPartDefinition searchResultsCommerceGroupPartDefinition;
                if (a2 != null) {
                    searchResultsCommerceGroupPartDefinition = (SearchResultsCommerceGroupPartDefinition) a2.a(f23962f);
                } else {
                    searchResultsCommerceGroupPartDefinition = f23961e;
                }
                if (searchResultsCommerceGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27545b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23962f, b3);
                        } else {
                            f23961e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsCommerceGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
