package com.facebook.feed.rows.sections.common.scissor;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.model.GapFeedEdge.GapFeedUnit;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
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
/* compiled from: last_impression/ */
public class ScissorRootPartsDeclaration implements RootPartsDeclaration {
    private static ScissorRootPartsDeclaration f17966b;
    private static final Object f17967c = new Object();
    private final Lazy<ScissorPartDefinition> f17968a;

    private static ScissorRootPartsDeclaration m25212b(InjectorLike injectorLike) {
        return new ScissorRootPartsDeclaration(IdBasedLazy.m1808a(injectorLike, 6022));
    }

    @Inject
    public ScissorRootPartsDeclaration(Lazy<ScissorPartDefinition> lazy) {
        this.f17968a = lazy;
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GapFeedUnit.class, this.f17968a);
    }

    public static ScissorRootPartsDeclaration m25211a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ScissorRootPartsDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f17967c) {
                ScissorRootPartsDeclaration scissorRootPartsDeclaration;
                if (a2 != null) {
                    scissorRootPartsDeclaration = (ScissorRootPartsDeclaration) a2.mo818a(f17967c);
                } else {
                    scissorRootPartsDeclaration = f17966b;
                }
                if (scissorRootPartsDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25212b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f17967c, b3);
                        } else {
                            f17966b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = scissorRootPartsDeclaration;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
