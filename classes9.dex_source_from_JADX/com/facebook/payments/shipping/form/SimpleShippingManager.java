package com.facebook.payments.shipping.form;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.payments.shipping.model.ShippingStyle;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Set;
import javax.inject.Inject;

@ContextScoped
/* compiled from: backstage_space_update_seen_time */
public class SimpleShippingManager {
    private static SimpleShippingManager f18958b;
    private static final Object f18959c = new Object();
    public final ImmutableMap<ShippingStyle, ShippingStyleAssociation> f18960a;

    private static SimpleShippingManager m18956b(InjectorLike injectorLike) {
        return new SimpleShippingManager(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$ShippingStyleAssociation(injectorLike)));
    }

    @Inject
    public SimpleShippingManager(Set<ShippingStyleAssociation> set) {
        Builder builder = ImmutableMap.builder();
        for (ShippingStyleAssociation shippingStyleAssociation : set) {
            builder.b(shippingStyleAssociation.f13099a, shippingStyleAssociation);
        }
        this.f18960a = builder.b();
    }

    public final ShippingAddressMutator m18957a(ShippingStyle shippingStyle) {
        if (this.f18960a.containsKey(shippingStyle)) {
            return (ShippingAddressMutator) ((ShippingStyleAssociation) this.f18960a.get(shippingStyle)).f13101c.get();
        }
        return (ShippingAddressMutator) ((ShippingStyleAssociation) this.f18960a.get(ShippingStyle.SIMPLE)).f13101c.get();
    }

    public final SimpleShippingStyleRenderer m18958b(ShippingStyle shippingStyle) {
        if (this.f18960a.containsKey(shippingStyle)) {
            return (SimpleShippingStyleRenderer) ((ShippingStyleAssociation) this.f18960a.get(shippingStyle)).f13100b.get();
        }
        return (SimpleShippingStyleRenderer) ((ShippingStyleAssociation) this.f18960a.get(ShippingStyle.SIMPLE)).f13100b.get();
    }

    public static SimpleShippingManager m18955a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SimpleShippingManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18959c) {
                SimpleShippingManager simpleShippingManager;
                if (a2 != null) {
                    simpleShippingManager = (SimpleShippingManager) a2.a(f18959c);
                } else {
                    simpleShippingManager = f18958b;
                }
                if (simpleShippingManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m18956b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18959c, b3);
                        } else {
                            f18958b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = simpleShippingManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
