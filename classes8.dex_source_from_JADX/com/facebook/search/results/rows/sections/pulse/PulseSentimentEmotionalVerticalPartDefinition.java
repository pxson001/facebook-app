package com.facebook.search.results.rows.sections.pulse;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.GraphQLEmotionalAnalysisItem;
import com.facebook.graphql.model.GraphQLEmotionalAnalysisItemsEdge;
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
import com.facebook.search.results.model.unit.SearchResultsPulseSentimentUnit;
import com.facebook.search.results.rows.sections.pulse.PulseSentimentEmotionalItemPartDefinition.PulseEmotionalIconData;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PRICE */
public class PulseSentimentEmotionalVerticalPartDefinition extends BaseMultiRowGroupPartDefinition<SearchResultsPulseSentimentUnit, Void, SearchResultsFeedEnvironment> {
    private static PulseSentimentEmotionalVerticalPartDefinition f24914b;
    private static final Object f24915c = new Object();
    private final PulseSentimentEmotionalVerticalItemPartDefinition f24916a;

    private static PulseSentimentEmotionalVerticalPartDefinition m28275b(InjectorLike injectorLike) {
        return new PulseSentimentEmotionalVerticalPartDefinition(PulseSentimentEmotionalVerticalItemPartDefinition.m28267a(injectorLike));
    }

    public final Object m28276a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsPulseSentimentUnit searchResultsPulseSentimentUnit = (SearchResultsPulseSentimentUnit) obj;
        baseMultiRowSubParts.a(this.f24916a, new PulseEmotionalIconData(searchResultsPulseSentimentUnit.f23500b));
        if (!(searchResultsPulseSentimentUnit.f23499a == null || searchResultsPulseSentimentUnit.f23499a.a() == null || searchResultsPulseSentimentUnit.f23499a.a().a().size() == 0)) {
            ImmutableList a = searchResultsPulseSentimentUnit.f23499a.a().a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                GraphQLEmotionalAnalysisItem a2 = ((GraphQLEmotionalAnalysisItemsEdge) a.get(i)).a();
                baseMultiRowSubParts.a(this.f24916a, new PulseEmotionalIconData(a2.k().aG(), a2.a(), a2.j()));
            }
        }
        return null;
    }

    public final boolean m28277a(Object obj) {
        return !((SearchResultsPulseSentimentUnit) obj).m27186n();
    }

    @Inject
    public PulseSentimentEmotionalVerticalPartDefinition(PulseSentimentEmotionalVerticalItemPartDefinition pulseSentimentEmotionalVerticalItemPartDefinition) {
        this.f24916a = pulseSentimentEmotionalVerticalItemPartDefinition;
    }

    public static PulseSentimentEmotionalVerticalPartDefinition m28274a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseSentimentEmotionalVerticalPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24915c) {
                PulseSentimentEmotionalVerticalPartDefinition pulseSentimentEmotionalVerticalPartDefinition;
                if (a2 != null) {
                    pulseSentimentEmotionalVerticalPartDefinition = (PulseSentimentEmotionalVerticalPartDefinition) a2.a(f24915c);
                } else {
                    pulseSentimentEmotionalVerticalPartDefinition = f24914b;
                }
                if (pulseSentimentEmotionalVerticalPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28275b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24915c, b3);
                        } else {
                            f24914b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseSentimentEmotionalVerticalPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
