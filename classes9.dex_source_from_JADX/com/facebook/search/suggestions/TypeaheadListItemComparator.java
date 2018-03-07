package com.facebook.search.suggestions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.ListItemComparator;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.TypeaheadUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: {provider_page_fbid} */
public class TypeaheadListItemComparator implements ListItemComparator<TypeaheadUnit> {
    private static TypeaheadListItemComparator f110b;
    private static final Object f111c = new Object();
    private final boolean f112a;

    private static TypeaheadListItemComparator m203b(InjectorLike injectorLike) {
        return new TypeaheadListItemComparator(GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public final boolean m204a(Object obj, Object obj2) {
        TypeaheadUnit typeaheadUnit = (TypeaheadUnit) obj;
        TypeaheadUnit typeaheadUnit2 = (TypeaheadUnit) obj2;
        if (typeaheadUnit.getClass() != EntityTypeaheadUnit.class || typeaheadUnit2.getClass() != EntityTypeaheadUnit.class || !this.f112a) {
            return false;
        }
        if (((EntityTypeaheadUnit) typeaheadUnit).a.equals(((EntityTypeaheadUnit) typeaheadUnit2).a)) {
            return true;
        }
        return false;
    }

    public final boolean m205a(Object obj, Object obj2, long j) {
        TypeaheadUnit typeaheadUnit = (TypeaheadUnit) obj;
        TypeaheadUnit typeaheadUnit2 = (TypeaheadUnit) obj2;
        return typeaheadUnit.getClass() == typeaheadUnit2.getClass() && typeaheadUnit.a(typeaheadUnit, typeaheadUnit2);
    }

    @Inject
    public TypeaheadListItemComparator(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f112a = gatekeeperStoreImpl.a(SearchAbTestGatekeepers.D, false);
    }

    public static TypeaheadListItemComparator m202a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TypeaheadListItemComparator b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f111c) {
                TypeaheadListItemComparator typeaheadListItemComparator;
                if (a2 != null) {
                    typeaheadListItemComparator = (TypeaheadListItemComparator) a2.a(f111c);
                } else {
                    typeaheadListItemComparator = f110b;
                }
                if (typeaheadListItemComparator == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m203b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f111c, b3);
                        } else {
                            f110b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = typeaheadListItemComparator;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
