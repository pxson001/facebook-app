package com.facebook.search.suggestions.nullstate;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.util.GraphSearchConfig;
import com.facebook.ultralight.Inject;

@ContextScoped
/* compiled from: web_view_start_url */
public class RecentSearchesMutatorSelector {
    private static RecentSearchesMutatorSelector f203c;
    private static final Object f204d = new Object();
    private final RecentSearchesNullStateSupplier f205a;
    private final Lazy<RecentVideoSearchesNullStateSupplier> f206b;

    private static RecentSearchesMutatorSelector m331b(InjectorLike injectorLike) {
        return new RecentSearchesMutatorSelector(RecentSearchesNullStateSupplier.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3398));
    }

    @Inject
    private RecentSearchesMutatorSelector(RecentSearchesNullStateSupplier recentSearchesNullStateSupplier, Lazy<RecentVideoSearchesNullStateSupplier> lazy) {
        this.f205a = recentSearchesNullStateSupplier;
        this.f206b = lazy;
    }

    public final RecentSearchesMutator m332a(GraphSearchQuery graphSearchQuery) {
        if (GraphSearchConfig.b(graphSearchQuery)) {
            return (RecentSearchesMutator) this.f206b.get();
        }
        return this.f205a;
    }

    public static RecentSearchesMutatorSelector m330a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RecentSearchesMutatorSelector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f204d) {
                RecentSearchesMutatorSelector recentSearchesMutatorSelector;
                if (a2 != null) {
                    recentSearchesMutatorSelector = (RecentSearchesMutatorSelector) a2.a(f204d);
                } else {
                    recentSearchesMutatorSelector = f203c;
                }
                if (recentSearchesMutatorSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m331b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f204d, b3);
                        } else {
                            f203c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = recentSearchesMutatorSelector;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
