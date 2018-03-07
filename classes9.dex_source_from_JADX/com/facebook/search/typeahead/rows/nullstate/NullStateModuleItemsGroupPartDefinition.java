package com.facebook.search.typeahead.rows.nullstate;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.search.model.NullStateModuleCollectionUnit;
import com.facebook.search.suggestions.environment.SearchSuggestionsEnvironment;
import javax.inject.Inject;

@ContextScoped
/* compiled from: v_tex */
public class NullStateModuleItemsGroupPartDefinition extends BaseMultiRowGroupPartDefinition<NullStateModuleCollectionUnit, Void, SearchSuggestionsEnvironment> {
    private static NullStateModuleItemsGroupPartDefinition f670b;
    private static final Object f671c = new Object();
    private final NullStateModuleItemPartDefinition f672a;

    private static NullStateModuleItemsGroupPartDefinition m762b(InjectorLike injectorLike) {
        return new NullStateModuleItemsGroupPartDefinition(NullStateModuleItemPartDefinition.m753a(injectorLike));
    }

    public final Object m763a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        int size;
        NullStateModuleCollectionUnit nullStateModuleCollectionUnit = (NullStateModuleCollectionUnit) obj;
        if (nullStateModuleCollectionUnit.g) {
            size = nullStateModuleCollectionUnit.f().size();
        } else {
            size = Math.min(nullStateModuleCollectionUnit.f().size(), nullStateModuleCollectionUnit.f);
        }
        for (int i = 0; i < size; i++) {
            baseMultiRowSubParts.a(this.f672a, nullStateModuleCollectionUnit.f().get(i));
        }
        return null;
    }

    @Inject
    public NullStateModuleItemsGroupPartDefinition(NullStateModuleItemPartDefinition nullStateModuleItemPartDefinition) {
        this.f672a = nullStateModuleItemPartDefinition;
    }

    public final boolean m764a(Object obj) {
        return true;
    }

    public static NullStateModuleItemsGroupPartDefinition m761a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateModuleItemsGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f671c) {
                NullStateModuleItemsGroupPartDefinition nullStateModuleItemsGroupPartDefinition;
                if (a2 != null) {
                    nullStateModuleItemsGroupPartDefinition = (NullStateModuleItemsGroupPartDefinition) a2.a(f671c);
                } else {
                    nullStateModuleItemsGroupPartDefinition = f670b;
                }
                if (nullStateModuleItemsGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m762b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f671c, b3);
                        } else {
                            f670b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nullStateModuleItemsGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
