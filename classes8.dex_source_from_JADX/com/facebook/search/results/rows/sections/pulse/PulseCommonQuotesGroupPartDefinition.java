package com.facebook.search.results.rows.sections.pulse;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.GraphQLQuotesAnalysisItem;
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
import com.google.common.base.Optional;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PROMINENT */
public class PulseCommonQuotesGroupPartDefinition extends BaseMultiRowGroupPartDefinition<SearchResultsCollectionUnit<?>, Void, SearchResultsFeedEnvironment> {
    private static PulseCommonQuotesGroupPartDefinition f24739b;
    private static final Object f24740c = new Object();
    PulseCommonQuoteRowPartDefinition f24741a;

    private static PulseCommonQuotesGroupPartDefinition m28155b(InjectorLike injectorLike) {
        return new PulseCommonQuotesGroupPartDefinition(PulseCommonQuoteRowPartDefinition.m28149a(injectorLike));
    }

    public final Object m28156a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) obj;
        for (int i = 0; i < searchResultsCollectionUnit.f23463d.size(); i++) {
            baseMultiRowSubParts.a(this.f24741a, searchResultsCollectionUnit.f23463d.get(i));
        }
        return null;
    }

    @Inject
    public PulseCommonQuotesGroupPartDefinition(PulseCommonQuoteRowPartDefinition pulseCommonQuoteRowPartDefinition) {
        this.f24741a = pulseCommonQuoteRowPartDefinition;
    }

    public static PulseCommonQuotesGroupPartDefinition m28153a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseCommonQuotesGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24740c) {
                PulseCommonQuotesGroupPartDefinition pulseCommonQuotesGroupPartDefinition;
                if (a2 != null) {
                    pulseCommonQuotesGroupPartDefinition = (PulseCommonQuotesGroupPartDefinition) a2.a(f24740c);
                } else {
                    pulseCommonQuotesGroupPartDefinition = f24739b;
                }
                if (pulseCommonQuotesGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28155b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24740c, b3);
                        } else {
                            f24739b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseCommonQuotesGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static boolean m28154a(SearchResultsCollectionUnit<?> searchResultsCollectionUnit) {
        return !searchResultsCollectionUnit.f23463d.isEmpty() && searchResultsCollectionUnit.m27154o().equals(Optional.of(GraphQLQuotesAnalysisItem.class));
    }
}
