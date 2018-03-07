package com.facebook.search.suggestions.systems;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.ui.typeahead.FetchState;
import com.facebook.ui.typeahead.SearchResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

@ContextScoped
/* compiled from: viewerDidLike() not supported yet */
public class NeueSingleStateSearchTypeaheadSystem extends BaseSearchTypeaheadSystem {
    private static NeueSingleStateSearchTypeaheadSystem f309a;
    private static final Object f310b = new Object();

    private static NeueSingleStateSearchTypeaheadSystem m454c() {
        return new NeueSingleStateSearchTypeaheadSystem();
    }

    public final TypeaheadUnit mo43a(GraphSearchQuery graphSearchQuery) {
        return null;
    }

    public final ImmutableList<TypeaheadUnit> mo44a(GraphSearchQuery graphSearchQuery, SearchResponse<TypeaheadUnit> searchResponse, TypeaheadUnit typeaheadUnit, FetchState fetchState) {
        return RegularImmutableList.a;
    }

    public static NeueSingleStateSearchTypeaheadSystem m453a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NeueSingleStateSearchTypeaheadSystem c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f310b) {
                NeueSingleStateSearchTypeaheadSystem neueSingleStateSearchTypeaheadSystem;
                if (a2 != null) {
                    neueSingleStateSearchTypeaheadSystem = (NeueSingleStateSearchTypeaheadSystem) a2.a(f310b);
                } else {
                    neueSingleStateSearchTypeaheadSystem = f309a;
                }
                if (neueSingleStateSearchTypeaheadSystem == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m454c();
                        if (a2 != null) {
                            a2.a(f310b, c);
                        } else {
                            f309a = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = neueSingleStateSearchTypeaheadSystem;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
