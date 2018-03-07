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
/* compiled from: ProfileImageRequest */
public class SearchResultsCommerceHeaderComponentSpec {
    private static SearchResultsCommerceHeaderComponentSpec f24369a;
    private static final Object f24370b = new Object();

    private static SearchResultsCommerceHeaderComponentSpec m27861a() {
        return new SearchResultsCommerceHeaderComponentSpec();
    }

    public static SearchResultsCommerceHeaderComponentSpec m27862a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsCommerceHeaderComponentSpec a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f24370b) {
                SearchResultsCommerceHeaderComponentSpec searchResultsCommerceHeaderComponentSpec;
                if (a3 != null) {
                    searchResultsCommerceHeaderComponentSpec = (SearchResultsCommerceHeaderComponentSpec) a3.a(f24370b);
                } else {
                    searchResultsCommerceHeaderComponentSpec = f24369a;
                }
                if (searchResultsCommerceHeaderComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m27861a();
                        if (a3 != null) {
                            a3.a(f24370b, a2);
                        } else {
                            f24369a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = searchResultsCommerceHeaderComponentSpec;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
