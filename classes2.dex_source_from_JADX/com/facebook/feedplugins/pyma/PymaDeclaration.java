package com.facebook.feedplugins.pyma;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.feedplugins.pyma.rows.PagesYouMayAdvertiseFooterPartDefinition;
import com.facebook.feedplugins.pyma.rows.PagesYouMayAdvertiseHeaderPartDefinition;
import com.facebook.graphql.model.GraphQLPagesYouMayAdvertiseFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: lac */
public class PymaDeclaration implements FeedRowSupportDeclaration, RootPartsDeclaration {
    private static PymaDeclaration f18259b;
    private static final Object f18260c = new Object();
    private final Lazy<PagesYouMayAdvertisePartDefinition> f18261a;

    private static PymaDeclaration m25597b(InjectorLike injectorLike) {
        return new PymaDeclaration(IdBasedLazy.m1808a(injectorLike, 6440));
    }

    @Inject
    public PymaDeclaration(Lazy<PagesYouMayAdvertisePartDefinition> lazy) {
        this.f18261a = lazy;
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        listItemRowController.m16558a(PagesYouMayAdvertiseHeaderPartDefinition.f19268a);
        listItemRowController.m16558a(PagesYouMayAdvertiseFooterPartDefinition.a);
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLPagesYouMayAdvertiseFeedUnit.class, this.f18261a);
    }

    public static PymaDeclaration m25596a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PymaDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18260c) {
                PymaDeclaration pymaDeclaration;
                if (a2 != null) {
                    pymaDeclaration = (PymaDeclaration) a2.mo818a(f18260c);
                } else {
                    pymaDeclaration = f18259b;
                }
                if (pymaDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25597b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18260c, b3);
                        } else {
                            f18259b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = pymaDeclaration;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
