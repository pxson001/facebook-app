package com.facebook.feed.rows.sections.common.endoffeed;

import android.content.Context;
import com.facebook.api.feed.data.EndOfFeedSentinel$EndOfFeedSentinelFeedUnit;
import com.facebook.common.propertybag.PropertyBag;
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
/* compiled from: last_logout_time */
public class EndOfFeedRootPartsDeclaration implements RootPartsDeclaration {
    private static EndOfFeedRootPartsDeclaration f17960b;
    private static final Object f17961c = new Object();
    private final Lazy<EndOfFeedPartDefinition> f17962a;

    private static EndOfFeedRootPartsDeclaration m25198b(InjectorLike injectorLike) {
        return new EndOfFeedRootPartsDeclaration(IdBasedLazy.m1808a(injectorLike, 6020));
    }

    @Inject
    public EndOfFeedRootPartsDeclaration(Lazy<EndOfFeedPartDefinition> lazy) {
        this.f17962a = lazy;
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(EndOfFeedSentinel$EndOfFeedSentinelFeedUnit.class, this.f17962a);
    }

    public static EndOfFeedRootPartsDeclaration m25197a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EndOfFeedRootPartsDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f17961c) {
                EndOfFeedRootPartsDeclaration endOfFeedRootPartsDeclaration;
                if (a2 != null) {
                    endOfFeedRootPartsDeclaration = (EndOfFeedRootPartsDeclaration) a2.mo818a(f17961c);
                } else {
                    endOfFeedRootPartsDeclaration = f17960b;
                }
                if (endOfFeedRootPartsDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25198b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f17961c, b3);
                        } else {
                            f17960b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = endOfFeedRootPartsDeclaration;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
