package com.facebook.search.typeahead.rows.nullstate;

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
import com.facebook.search.model.GapTypeaheadUnit;
import com.facebook.search.model.NullStateModuleCollectionUnit;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.suggestions.environment.SearchSuggestionsEnvironment;
import javax.inject.Inject;

@ContextScoped
/* compiled from: validatePaymentCardBinParams */
public class NullStateModuleGroupPartDefinition extends BaseMultiRowGroupPartDefinition<NullStateModuleCollectionUnit, Void, SearchSuggestionsEnvironment> {
    private static NullStateModuleGroupPartDefinition f643e;
    private static final Object f644f = new Object();
    private final NullStateModuleTitlePartDefinition f645a;
    private final NullStateModuleItemsGroupPartDefinition f646b;
    private final NullStateModuleSeeMorePartDefinition f647c;
    private final NullStateModuleGapPartDefinition f648d;

    private static NullStateModuleGroupPartDefinition m745b(InjectorLike injectorLike) {
        return new NullStateModuleGroupPartDefinition(NullStateModuleTitlePartDefinition.m771a(injectorLike), NullStateModuleItemsGroupPartDefinition.m761a(injectorLike), NullStateModuleSeeMorePartDefinition.m766a(injectorLike), NullStateModuleGapPartDefinition.m740a(injectorLike));
    }

    public final Object m746a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        Object obj2;
        NullStateModuleCollectionUnit nullStateModuleCollectionUnit = (NullStateModuleCollectionUnit) obj;
        SearchSuggestionsEnvironment searchSuggestionsEnvironment = (SearchSuggestionsEnvironment) anyEnvironment;
        FeedProps c = FeedProps.c(nullStateModuleCollectionUnit);
        for (TypeaheadUnit typeaheadUnit : searchSuggestionsEnvironment.f115o.f422a) {
            if (!(typeaheadUnit instanceof GapTypeaheadUnit)) {
                obj2 = typeaheadUnit == nullStateModuleCollectionUnit ? 1 : null;
                if (obj2 == null) {
                    baseMultiRowSubParts.a(this.f648d, nullStateModuleCollectionUnit);
                }
                baseMultiRowSubParts.a(this.f645a, c);
                baseMultiRowSubParts.a(this.f646b, nullStateModuleCollectionUnit);
                baseMultiRowSubParts.a(this.f647c, nullStateModuleCollectionUnit);
                return null;
            }
        }
        obj2 = null;
        if (obj2 == null) {
            baseMultiRowSubParts.a(this.f648d, nullStateModuleCollectionUnit);
        }
        baseMultiRowSubParts.a(this.f645a, c);
        baseMultiRowSubParts.a(this.f646b, nullStateModuleCollectionUnit);
        baseMultiRowSubParts.a(this.f647c, nullStateModuleCollectionUnit);
        return null;
    }

    public final boolean m747a(Object obj) {
        return !((NullStateModuleCollectionUnit) obj).f().isEmpty();
    }

    @Inject
    public NullStateModuleGroupPartDefinition(NullStateModuleTitlePartDefinition nullStateModuleTitlePartDefinition, NullStateModuleItemsGroupPartDefinition nullStateModuleItemsGroupPartDefinition, NullStateModuleSeeMorePartDefinition nullStateModuleSeeMorePartDefinition, NullStateModuleGapPartDefinition nullStateModuleGapPartDefinition) {
        this.f645a = nullStateModuleTitlePartDefinition;
        this.f646b = nullStateModuleItemsGroupPartDefinition;
        this.f647c = nullStateModuleSeeMorePartDefinition;
        this.f648d = nullStateModuleGapPartDefinition;
    }

    public static NullStateModuleGroupPartDefinition m744a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateModuleGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f644f) {
                NullStateModuleGroupPartDefinition nullStateModuleGroupPartDefinition;
                if (a2 != null) {
                    nullStateModuleGroupPartDefinition = (NullStateModuleGroupPartDefinition) a2.a(f644f);
                } else {
                    nullStateModuleGroupPartDefinition = f643e;
                }
                if (nullStateModuleGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m745b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f644f, b3);
                        } else {
                            f643e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nullStateModuleGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
