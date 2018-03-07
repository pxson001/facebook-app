package com.facebook.search.results.rows.sections.pulse;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.GraphQLPhrasesAnalysisItem;
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
/* compiled from: PUBLIC_GOING */
public class PulseCommonPhrasesGroupPartDefinition extends BaseMultiRowGroupPartDefinition<SearchResultsCollectionUnit<?>, Void, SearchResultsFeedEnvironment> {
    private static PulseCommonPhrasesGroupPartDefinition f24728b;
    private static final Object f24729c = new Object();
    PulseCommonPhraseItemPartDefinition<SearchResultsFeedEnvironment> f24730a;

    private static PulseCommonPhrasesGroupPartDefinition m28139b(InjectorLike injectorLike) {
        return new PulseCommonPhrasesGroupPartDefinition(PulseCommonPhraseItemPartDefinition.m28131a(injectorLike));
    }

    public final Object m28140a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) obj;
        for (int i = 0; i < searchResultsCollectionUnit.f23463d.size(); i++) {
            baseMultiRowSubParts.a(this.f24730a, searchResultsCollectionUnit.f23463d.get(i));
        }
        return null;
    }

    @Inject
    public PulseCommonPhrasesGroupPartDefinition(PulseCommonPhraseItemPartDefinition pulseCommonPhraseItemPartDefinition) {
        this.f24730a = pulseCommonPhraseItemPartDefinition;
    }

    public static PulseCommonPhrasesGroupPartDefinition m28137a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseCommonPhrasesGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24729c) {
                PulseCommonPhrasesGroupPartDefinition pulseCommonPhrasesGroupPartDefinition;
                if (a2 != null) {
                    pulseCommonPhrasesGroupPartDefinition = (PulseCommonPhrasesGroupPartDefinition) a2.a(f24729c);
                } else {
                    pulseCommonPhrasesGroupPartDefinition = f24728b;
                }
                if (pulseCommonPhrasesGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28139b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24729c, b3);
                        } else {
                            f24728b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseCommonPhrasesGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static boolean m28138a(SearchResultsCollectionUnit<?> searchResultsCollectionUnit) {
        return !searchResultsCollectionUnit.f23463d.isEmpty() && searchResultsCollectionUnit.m27154o().equals(Optional.of(GraphQLPhrasesAnalysisItem.class));
    }
}
