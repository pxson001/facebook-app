package com.facebook.search.results.rows.sections.spellcorrection;

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
import com.facebook.search.results.model.unit.SearchResultsSpellCorrectionUnit;
import com.facebook.search.results.rows.sections.common.SearchResultsResultsEmptyHeaderPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PRELIMINARY_INITIALIZED */
public class SearchResultsSpellCorrectionGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsSpellCorrectionUnit>, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsSpellCorrectionGroupPartDefinition f25020d;
    private static final Object f25021e = new Object();
    private final SearchResultsSpellCorrectionEscapePartDefinition<SearchResultsFeedEnvironment> f25022a;
    private final SearchResultsSpellCorrectionTitlePartDefinition f25023b;
    private final SearchResultsResultsEmptyHeaderPartDefinition<SearchResultsSpellCorrectionUnit> f25024c;

    private static SearchResultsSpellCorrectionGroupPartDefinition m28351b(InjectorLike injectorLike) {
        return new SearchResultsSpellCorrectionGroupPartDefinition(SearchResultsResultsEmptyHeaderPartDefinition.m27597a(injectorLike), SearchResultsSpellCorrectionTitlePartDefinition.m28354a(injectorLike), SearchResultsSpellCorrectionEscapePartDefinition.m28343a(injectorLike));
    }

    public final Object m28352a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f25024c, (SearchResultsSpellCorrectionUnit) feedProps.a);
        baseMultiRowSubParts.a(this.f25023b, feedProps);
        baseMultiRowSubParts.a(this.f25022a, feedProps);
        return null;
    }

    @Inject
    public SearchResultsSpellCorrectionGroupPartDefinition(SearchResultsResultsEmptyHeaderPartDefinition searchResultsResultsEmptyHeaderPartDefinition, SearchResultsSpellCorrectionTitlePartDefinition searchResultsSpellCorrectionTitlePartDefinition, SearchResultsSpellCorrectionEscapePartDefinition searchResultsSpellCorrectionEscapePartDefinition) {
        this.f25022a = searchResultsSpellCorrectionEscapePartDefinition;
        this.f25023b = searchResultsSpellCorrectionTitlePartDefinition;
        this.f25024c = searchResultsResultsEmptyHeaderPartDefinition;
    }

    public static SearchResultsSpellCorrectionGroupPartDefinition m28350a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsSpellCorrectionGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25021e) {
                SearchResultsSpellCorrectionGroupPartDefinition searchResultsSpellCorrectionGroupPartDefinition;
                if (a2 != null) {
                    searchResultsSpellCorrectionGroupPartDefinition = (SearchResultsSpellCorrectionGroupPartDefinition) a2.a(f25021e);
                } else {
                    searchResultsSpellCorrectionGroupPartDefinition = f25020d;
                }
                if (searchResultsSpellCorrectionGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28351b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25021e, b3);
                        } else {
                            f25020d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsSpellCorrectionGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m28353a(Object obj) {
        return true;
    }
}
