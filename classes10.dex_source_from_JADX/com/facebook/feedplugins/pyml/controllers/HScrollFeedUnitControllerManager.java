package com.facebook.feedplugins.pyml.controllers;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android_og_dialog */
public class HScrollFeedUnitControllerManager {
    private static HScrollFeedUnitControllerManager f19647b;
    private static final Object f19648c = new Object();
    public final Map<Class, HScrollFeedUnitController> f19649a = Maps.c();

    private static HScrollFeedUnitControllerManager m19933b(InjectorLike injectorLike) {
        return new HScrollFeedUnitControllerManager(PymlEgoProfileSwipeItemController.m19960a(injectorLike));
    }

    @Inject
    public HScrollFeedUnitControllerManager(PymlEgoProfileSwipeItemController pymlEgoProfileSwipeItemController) {
        this.f19649a.put(pymlEgoProfileSwipeItemController.mo890c(), pymlEgoProfileSwipeItemController);
    }

    public static HScrollFeedUnitControllerManager m19932a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HScrollFeedUnitControllerManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19648c) {
                HScrollFeedUnitControllerManager hScrollFeedUnitControllerManager;
                if (a2 != null) {
                    hScrollFeedUnitControllerManager = (HScrollFeedUnitControllerManager) a2.a(f19648c);
                } else {
                    hScrollFeedUnitControllerManager = f19647b;
                }
                if (hScrollFeedUnitControllerManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m19933b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19648c, b3);
                        } else {
                            f19647b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = hScrollFeedUnitControllerManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
