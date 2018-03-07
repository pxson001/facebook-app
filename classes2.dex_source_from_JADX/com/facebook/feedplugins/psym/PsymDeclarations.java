package com.facebook.feedplugins.psym;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.feedplugins.psym.rows.PagesStoriesYouMissedPartDefinition;
import com.facebook.graphql.model.GraphQLPageStoriesYouMissedFeedUnit;
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
/* compiled from: language_switch */
public class PsymDeclarations implements RootPartsDeclaration {
    private static PsymDeclarations f18243b;
    private static final Object f18244c = new Object();
    private final Lazy<PagesStoriesYouMissedPartDefinition> f18245a;

    private static PsymDeclarations m25570b(InjectorLike injectorLike) {
        return new PsymDeclarations(IdBasedLazy.m1808a(injectorLike, 6437));
    }

    @Inject
    public PsymDeclarations(Lazy<PagesStoriesYouMissedPartDefinition> lazy) {
        this.f18245a = lazy;
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLPageStoriesYouMissedFeedUnit.class, this.f18245a);
    }

    public static PsymDeclarations m25569a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PsymDeclarations b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18244c) {
                PsymDeclarations psymDeclarations;
                if (a2 != null) {
                    psymDeclarations = (PsymDeclarations) a2.mo818a(f18244c);
                } else {
                    psymDeclarations = f18243b;
                }
                if (psymDeclarations == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25570b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18244c, b3);
                        } else {
                            f18243b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = psymDeclarations;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
