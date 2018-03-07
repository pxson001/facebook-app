package com.facebook.search.typeahead.rows.nullstate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.model.NullStateModuleCollectionUnit;
import com.facebook.search.suggestions.environment.SearchSuggestionsEnvironment;

@ContextScoped
/* compiled from: validate_only */
public class NullStateModuleGapPartDefinition extends MultiRowSinglePartDefinition<NullStateModuleCollectionUnit, Void, SearchSuggestionsEnvironment, View> {
    public static final ViewType f640a = new C00581();
    private static NullStateModuleGapPartDefinition f641b;
    private static final Object f642c = new Object();

    /* compiled from: validate_only */
    final class C00581 extends ViewType {
        C00581() {
        }

        public final View m739a(Context context) {
            return LayoutInflater.from(context).inflate(2130905505, null);
        }
    }

    private static NullStateModuleGapPartDefinition m741c() {
        return new NullStateModuleGapPartDefinition();
    }

    public final ViewType<View> m742a() {
        return f640a;
    }

    public final boolean m743a(Object obj) {
        return true;
    }

    public static NullStateModuleGapPartDefinition m740a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateModuleGapPartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f642c) {
                NullStateModuleGapPartDefinition nullStateModuleGapPartDefinition;
                if (a2 != null) {
                    nullStateModuleGapPartDefinition = (NullStateModuleGapPartDefinition) a2.a(f642c);
                } else {
                    nullStateModuleGapPartDefinition = f641b;
                }
                if (nullStateModuleGapPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m741c();
                        if (a2 != null) {
                            a2.a(f642c, c);
                        } else {
                            f641b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = nullStateModuleGapPartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
