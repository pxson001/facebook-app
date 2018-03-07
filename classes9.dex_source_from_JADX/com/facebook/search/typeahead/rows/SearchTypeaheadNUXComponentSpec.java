package com.facebook.search.typeahead.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@LayoutSpec
@ContextScoped
/* compiled from: vault_upload_state_idx */
public class SearchTypeaheadNUXComponentSpec {
    private static SearchTypeaheadNUXComponentSpec f574a;
    private static final Object f575b = new Object();

    private static SearchTypeaheadNUXComponentSpec m661a() {
        return new SearchTypeaheadNUXComponentSpec();
    }

    public static SearchTypeaheadNUXComponentSpec m662a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadNUXComponentSpec a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f575b) {
                SearchTypeaheadNUXComponentSpec searchTypeaheadNUXComponentSpec;
                if (a3 != null) {
                    searchTypeaheadNUXComponentSpec = (SearchTypeaheadNUXComponentSpec) a3.a(f575b);
                } else {
                    searchTypeaheadNUXComponentSpec = f574a;
                }
                if (searchTypeaheadNUXComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m661a();
                        if (a3 != null) {
                            a3.a(f575b, a2);
                        } else {
                            f574a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = searchTypeaheadNUXComponentSpec;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
