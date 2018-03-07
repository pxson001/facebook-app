package com.facebook.feedplugins.quickpromotion;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@LayoutSpec
@ContextScoped
/* compiled from: carrier_manager_shortcut_created */
public class QuickPromotionSocialContextComponentSpec {
    private static QuickPromotionSocialContextComponentSpec f8962a;
    private static final Object f8963b = new Object();

    private static QuickPromotionSocialContextComponentSpec m9682a() {
        return new QuickPromotionSocialContextComponentSpec();
    }

    public static QuickPromotionSocialContextComponentSpec m9683a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuickPromotionSocialContextComponentSpec a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f8963b) {
                QuickPromotionSocialContextComponentSpec quickPromotionSocialContextComponentSpec;
                if (a3 != null) {
                    quickPromotionSocialContextComponentSpec = (QuickPromotionSocialContextComponentSpec) a3.a(f8963b);
                } else {
                    quickPromotionSocialContextComponentSpec = f8962a;
                }
                if (quickPromotionSocialContextComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9682a();
                        if (a3 != null) {
                            a3.a(f8963b, a2);
                        } else {
                            f8962a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = quickPromotionSocialContextComponentSpec;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
