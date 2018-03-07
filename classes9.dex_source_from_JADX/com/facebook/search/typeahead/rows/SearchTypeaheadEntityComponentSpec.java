package com.facebook.search.typeahead.rows;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.search.util.TypeaheadRowTitleFormatter;
import com.facebook.ultralight.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: verifyPaymentParams */
public class SearchTypeaheadEntityComponentSpec {
    public static final CallerContext f499a = CallerContext.a(SearchTypeaheadEntityComponentSpec.class, "search");
    private static SearchTypeaheadEntityComponentSpec f500e;
    private static final Object f501f = new Object();
    public final TypeaheadRowTitleFormatter f502b;
    public final FbDraweeControllerBuilder f503c;
    public final GatekeeperStoreImpl f504d;

    private static SearchTypeaheadEntityComponentSpec m609b(InjectorLike injectorLike) {
        return new SearchTypeaheadEntityComponentSpec(TypeaheadRowTitleFormatter.a(injectorLike), FbDraweeControllerBuilder.b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    private SearchTypeaheadEntityComponentSpec(TypeaheadRowTitleFormatter typeaheadRowTitleFormatter, FbDraweeControllerBuilder fbDraweeControllerBuilder, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f502b = typeaheadRowTitleFormatter;
        this.f503c = fbDraweeControllerBuilder;
        this.f504d = gatekeeperStoreImpl;
    }

    public static SearchTypeaheadEntityComponentSpec m608a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadEntityComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f501f) {
                SearchTypeaheadEntityComponentSpec searchTypeaheadEntityComponentSpec;
                if (a2 != null) {
                    searchTypeaheadEntityComponentSpec = (SearchTypeaheadEntityComponentSpec) a2.a(f501f);
                } else {
                    searchTypeaheadEntityComponentSpec = f500e;
                }
                if (searchTypeaheadEntityComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m609b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f501f, b3);
                        } else {
                            f500e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchTypeaheadEntityComponentSpec;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
