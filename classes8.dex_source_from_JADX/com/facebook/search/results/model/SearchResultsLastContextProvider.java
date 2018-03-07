package com.facebook.search.results.model;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.annotation.Nullable;

@ContextScoped
/* compiled from: SANS_SERIF */
public class SearchResultsLastContextProvider {
    private static SearchResultsLastContextProvider f23357b;
    private static final Object f23358c = new Object();
    @Nullable
    public SearchResultsMutableContext f23359a;

    private static SearchResultsLastContextProvider m27078c() {
        return new SearchResultsLastContextProvider();
    }

    public static SearchResultsLastContextProvider m27077a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsLastContextProvider c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23358c) {
                SearchResultsLastContextProvider searchResultsLastContextProvider;
                if (a2 != null) {
                    searchResultsLastContextProvider = (SearchResultsLastContextProvider) a2.a(f23358c);
                } else {
                    searchResultsLastContextProvider = f23357b;
                }
                if (searchResultsLastContextProvider == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m27078c();
                        if (a2 != null) {
                            a2.a(f23358c, c);
                        } else {
                            f23357b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = searchResultsLastContextProvider;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
