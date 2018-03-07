package com.facebook.search.results.rows.sections.collection;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
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
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.rows.sections.header.SearchResultsTitleActionPartDefinition;
import com.facebook.search.results.rows.sections.header.SearchResultsTitlePartDefinition;
import com.facebook.search.results.rows.sections.header.SearchResultsTitlePartDefinition.Props;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REQUIRED */
public class SearchResultsCollectionTitlePartDefinition<T> extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsCollectionUnit<T>>, Void, HasPositionInformation> {
    private static SearchResultsCollectionTitlePartDefinition f23740c;
    private static final Object f23741d = new Object();
    private SearchResultsTitleActionPartDefinition f23742a;
    private SearchResultsTitlePartDefinition f23743b;

    private static SearchResultsCollectionTitlePartDefinition m27384b(InjectorLike injectorLike) {
        return new SearchResultsCollectionTitlePartDefinition(SearchResultsTitleActionPartDefinition.m27883a(injectorLike), SearchResultsTitlePartDefinition.m27890a(injectorLike));
    }

    public final Object m27385a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) feedProps.a;
        SubPartsSelector.a(baseMultiRowSubParts, this.f23742a, feedProps).a(this.f23743b, new Props((String) searchResultsCollectionUnit.f23462c.get(), searchResultsCollectionUnit.mo1321k(), (GraphQLGraphSearchResultsDisplayStyle) searchResultsCollectionUnit.f23460a.orNull()));
        return null;
    }

    public final boolean m27386a(Object obj) {
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) ((FeedProps) obj).a;
        if (searchResultsCollectionUnit.mo1321k() != GraphQLGraphSearchResultRole.NEWS_PUBLISHERS) {
            return searchResultsCollectionUnit.f23462c.isPresent();
        }
        if (!searchResultsCollectionUnit.f23462c.isPresent() || searchResultsCollectionUnit.f23463d.size() <= 1) {
            return false;
        }
        return true;
    }

    @Inject
    public SearchResultsCollectionTitlePartDefinition(SearchResultsTitleActionPartDefinition searchResultsTitleActionPartDefinition, SearchResultsTitlePartDefinition searchResultsTitlePartDefinition) {
        this.f23742a = searchResultsTitleActionPartDefinition;
        this.f23743b = searchResultsTitlePartDefinition;
    }

    public static SearchResultsCollectionTitlePartDefinition m27383a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsCollectionTitlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23741d) {
                SearchResultsCollectionTitlePartDefinition searchResultsCollectionTitlePartDefinition;
                if (a2 != null) {
                    searchResultsCollectionTitlePartDefinition = (SearchResultsCollectionTitlePartDefinition) a2.a(f23741d);
                } else {
                    searchResultsCollectionTitlePartDefinition = f23740c;
                }
                if (searchResultsCollectionTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27384b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23741d, b3);
                        } else {
                            f23740c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsCollectionTitlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
