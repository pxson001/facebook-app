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
import javax.inject.Inject;

@ContextScoped
/* compiled from: PROMOTE_PAGE */
public class PulseCommonQuoteRowPartDefinition extends BaseMultiRowGroupPartDefinition<GraphQLQuotesAnalysisItem, Void, SearchResultsFeedEnvironment> {
    private static PulseCommonQuoteRowPartDefinition f24736b;
    private static final Object f24737c = new Object();
    private final PulseCommonQuoteContentPartDefinition f24738a;

    private static PulseCommonQuoteRowPartDefinition m28150b(InjectorLike injectorLike) {
        return new PulseCommonQuoteRowPartDefinition(PulseCommonQuoteContentPartDefinition.m28143a(injectorLike));
    }

    public final Object m28151a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        baseMultiRowSubParts.a(this.f24738a, (GraphQLQuotesAnalysisItem) obj);
        return null;
    }

    @Inject
    public PulseCommonQuoteRowPartDefinition(PulseCommonQuoteContentPartDefinition pulseCommonQuoteContentPartDefinition) {
        this.f24738a = pulseCommonQuoteContentPartDefinition;
    }

    public final boolean m28152a(Object obj) {
        return true;
    }

    public static PulseCommonQuoteRowPartDefinition m28149a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseCommonQuoteRowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24737c) {
                PulseCommonQuoteRowPartDefinition pulseCommonQuoteRowPartDefinition;
                if (a2 != null) {
                    pulseCommonQuoteRowPartDefinition = (PulseCommonQuoteRowPartDefinition) a2.a(f24737c);
                } else {
                    pulseCommonQuoteRowPartDefinition = f24736b;
                }
                if (pulseCommonQuoteRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28150b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24737c, b3);
                        } else {
                            f24736b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseCommonQuoteRowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
