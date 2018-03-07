package com.facebook.search.results.rows.sections.noresults;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
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
import com.facebook.search.results.model.unit.SearchResultsResultsNoUnit;
import com.facebook.search.results.rows.sections.common.SearchResultsResultsEmptyFooterPartDefinition;
import com.facebook.search.results.rows.sections.common.SearchResultsResultsEmptyHeaderPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PULL_TO_REFRESH */
public class SearchResultsNoResultsGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsResultsNoUnit>, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsNoResultsGroupPartDefinition f24706d;
    private static final Object f24707e = new Object();
    private final SearchResultsResultsEmptyFooterPartDefinition f24708a;
    private final SearchResultsNoResultsContentPartDefinition f24709b;
    private final SearchResultsResultsEmptyHeaderPartDefinition f24710c;

    private static SearchResultsNoResultsGroupPartDefinition m28126b(InjectorLike injectorLike) {
        return new SearchResultsNoResultsGroupPartDefinition(SearchResultsResultsEmptyHeaderPartDefinition.m27597a(injectorLike), SearchResultsNoResultsContentPartDefinition.m28119a(injectorLike), SearchResultsResultsEmptyFooterPartDefinition.m27592a(injectorLike));
    }

    public final Object m28127a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f24710c, feedProps.a);
        baseMultiRowSubParts.a(this.f24709b, feedProps);
        baseMultiRowSubParts.a(this.f24708a, feedProps.a);
        return null;
    }

    @Inject
    public SearchResultsNoResultsGroupPartDefinition(SearchResultsResultsEmptyHeaderPartDefinition searchResultsResultsEmptyHeaderPartDefinition, SearchResultsNoResultsContentPartDefinition searchResultsNoResultsContentPartDefinition, SearchResultsResultsEmptyFooterPartDefinition searchResultsResultsEmptyFooterPartDefinition) {
        this.f24708a = searchResultsResultsEmptyFooterPartDefinition;
        this.f24709b = searchResultsNoResultsContentPartDefinition;
        this.f24710c = searchResultsResultsEmptyHeaderPartDefinition;
    }

    public final boolean m28128a(Object obj) {
        return true;
    }

    public static SearchResultsNoResultsGroupPartDefinition m28125a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsNoResultsGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24707e) {
                SearchResultsNoResultsGroupPartDefinition searchResultsNoResultsGroupPartDefinition;
                if (a2 != null) {
                    searchResultsNoResultsGroupPartDefinition = (SearchResultsNoResultsGroupPartDefinition) a2.a(f24707e);
                } else {
                    searchResultsNoResultsGroupPartDefinition = f24706d;
                }
                if (searchResultsNoResultsGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28126b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24707e, b3);
                        } else {
                            f24706d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsNoResultsGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
