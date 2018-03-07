package com.facebook.feed.rows.sections.common.loadingmore;

import android.content.Context;
import com.facebook.api.feed.data.LoadingMoreSentinel$LoadingMoreSentinelFeedUnit;
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
/* compiled from: last_impression_timestamp */
public class LoadingMoreRootPartsDeclaration implements RootPartsDeclaration {
    private static LoadingMoreRootPartsDeclaration f17963b;
    private static final Object f17964c = new Object();
    private final Lazy<LoadingMorePartDefinition> f17965a;

    private static LoadingMoreRootPartsDeclaration m25209b(InjectorLike injectorLike) {
        return new LoadingMoreRootPartsDeclaration(IdBasedLazy.m1808a(injectorLike, 6021));
    }

    @Inject
    public LoadingMoreRootPartsDeclaration(Lazy<LoadingMorePartDefinition> lazy) {
        this.f17965a = lazy;
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(LoadingMoreSentinel$LoadingMoreSentinelFeedUnit.class, this.f17965a);
    }

    public static LoadingMoreRootPartsDeclaration m25208a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LoadingMoreRootPartsDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f17964c) {
                LoadingMoreRootPartsDeclaration loadingMoreRootPartsDeclaration;
                if (a2 != null) {
                    loadingMoreRootPartsDeclaration = (LoadingMoreRootPartsDeclaration) a2.mo818a(f17964c);
                } else {
                    loadingMoreRootPartsDeclaration = f17963b;
                }
                if (loadingMoreRootPartsDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25209b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f17964c, b3);
                        } else {
                            f17963b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = loadingMoreRootPartsDeclaration;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
