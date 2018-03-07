package com.facebook.feed.ui.chaining;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TransliterationGetModel */
public class HScrollChainingViewControllerManager {
    private static HScrollChainingViewControllerManager f21860b;
    private static final Object f21861c = new Object();
    public final Map<Class, HScrollChainingViewController> f21862a = Maps.c();

    private static HScrollChainingViewControllerManager m24454b(InjectorLike injectorLike) {
        return new HScrollChainingViewControllerManager(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$HScrollChainingViewController(injectorLike)));
    }

    @Inject
    public HScrollChainingViewControllerManager(Set<HScrollChainingViewController> set) {
        for (HScrollChainingViewController hScrollChainingViewController : set) {
            this.f21862a.put(hScrollChainingViewController.mo1566c(), hScrollChainingViewController);
        }
    }

    public final HScrollChainingViewController m24455a(Class cls) {
        Preconditions.checkArgument(ScrollableItemListFeedUnit.class.isAssignableFrom(cls), "HScrollChainingView can only be bound to FeedUnits which implement the ScrollableItemListFeedUnit interface.");
        return (HScrollChainingViewController) this.f21862a.get(cls);
    }

    public static HScrollChainingViewControllerManager m24453a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HScrollChainingViewControllerManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21861c) {
                HScrollChainingViewControllerManager hScrollChainingViewControllerManager;
                if (a2 != null) {
                    hScrollChainingViewControllerManager = (HScrollChainingViewControllerManager) a2.a(f21861c);
                } else {
                    hScrollChainingViewControllerManager = f21860b;
                }
                if (hScrollChainingViewControllerManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24454b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21861c, b3);
                        } else {
                            f21860b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = hScrollChainingViewControllerManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
