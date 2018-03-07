package com.facebook.search.results.rows.sections.header;

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
/* compiled from: PresenterUtils.setFeedback */
public class SearchResultsHeaderComponentSpec {
    private static SearchResultsHeaderComponentSpec f24392a;
    private static final Object f24393b = new Object();

    private static SearchResultsHeaderComponentSpec m27877a() {
        return new SearchResultsHeaderComponentSpec();
    }

    public static SearchResultsHeaderComponentSpec m27878a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsHeaderComponentSpec a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f24393b) {
                SearchResultsHeaderComponentSpec searchResultsHeaderComponentSpec;
                if (a3 != null) {
                    searchResultsHeaderComponentSpec = (SearchResultsHeaderComponentSpec) a3.a(f24393b);
                } else {
                    searchResultsHeaderComponentSpec = f24392a;
                }
                if (searchResultsHeaderComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m27877a();
                        if (a3 != null) {
                            a3.a(f24393b, a2);
                        } else {
                            f24392a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = searchResultsHeaderComponentSpec;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
