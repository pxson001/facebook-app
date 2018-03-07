package com.facebook.search.results.rows.sections.newscontext;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
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
import com.facebook.search.results.model.unit.SearchResultsNewsContextUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PageCallToActionCoreCreateMutation */
public class SearchResultsNewsContextSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsNewsContextUnit>, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsNewsContextSelectorPartDefinition f24653c;
    private static final Object f24654d = new Object();
    private final SearchResultsNewsContextFullHeightPartDefinition f24655a;
    private final SearchResultsNewsContextGroupPartDefinition f24656b;

    private static SearchResultsNewsContextSelectorPartDefinition m28067b(InjectorLike injectorLike) {
        return new SearchResultsNewsContextSelectorPartDefinition(SearchResultsNewsContextGroupPartDefinition.m28049a(injectorLike), SearchResultsNewsContextFullHeightPartDefinition.m28044a(injectorLike));
    }

    public final Object m28068a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f24655a, feedProps).a(this.f24656b, feedProps);
        return null;
    }

    @Inject
    public SearchResultsNewsContextSelectorPartDefinition(SearchResultsNewsContextGroupPartDefinition searchResultsNewsContextGroupPartDefinition, SearchResultsNewsContextFullHeightPartDefinition searchResultsNewsContextFullHeightPartDefinition) {
        this.f24656b = searchResultsNewsContextGroupPartDefinition;
        this.f24655a = searchResultsNewsContextFullHeightPartDefinition;
    }

    public final boolean m28069a(Object obj) {
        return true;
    }

    public static SearchResultsNewsContextSelectorPartDefinition m28066a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsNewsContextSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24654d) {
                SearchResultsNewsContextSelectorPartDefinition searchResultsNewsContextSelectorPartDefinition;
                if (a2 != null) {
                    searchResultsNewsContextSelectorPartDefinition = (SearchResultsNewsContextSelectorPartDefinition) a2.a(f24654d);
                } else {
                    searchResultsNewsContextSelectorPartDefinition = f24653c;
                }
                if (searchResultsNewsContextSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28067b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24654d, b3);
                        } else {
                            f24653c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsNewsContextSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
