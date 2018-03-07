package com.facebook.payments.checkout;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.payments.checkout.recyclerview.SimpleCheckoutSubScreenParamsGenerator;
import com.facebook.payments.checkout.statemachine.SimpleCheckoutStateMachineOrganizer;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Set;
import javax.inject.Inject;

@ContextScoped
/* compiled from: card_first_six */
public class SimpleCheckoutManager {
    private static SimpleCheckoutManager f18486b;
    private static final Object f18487c = new Object();
    public final ImmutableMap<CheckoutStyle, CheckoutStyleAssociation> f18488a;

    private static SimpleCheckoutManager m18490b(InjectorLike injectorLike) {
        return new SimpleCheckoutManager(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$CheckoutStyleAssociation(injectorLike)));
    }

    @Inject
    public SimpleCheckoutManager(Set<CheckoutStyleAssociation> set) {
        Builder builder = ImmutableMap.builder();
        for (CheckoutStyleAssociation checkoutStyleAssociation : set) {
            builder.b(checkoutStyleAssociation.f15723a, checkoutStyleAssociation);
        }
        this.f18488a = builder.b();
    }

    public final SimpleCheckoutDataLoader m18491a(CheckoutStyle checkoutStyle) {
        if (this.f18488a.containsKey(checkoutStyle)) {
            return (SimpleCheckoutDataLoader) ((CheckoutStyleAssociation) this.f18488a.get(checkoutStyle)).f15724b.get();
        }
        return (SimpleCheckoutDataLoader) ((CheckoutStyleAssociation) this.f18488a.get(CheckoutStyle.SIMPLE)).f15724b.get();
    }

    public final SimpleCheckoutDataMutator m18492b(CheckoutStyle checkoutStyle) {
        if (this.f18488a.containsKey(checkoutStyle)) {
            return (SimpleCheckoutDataMutator) ((CheckoutStyleAssociation) this.f18488a.get(checkoutStyle)).f15725c.get();
        }
        return (SimpleCheckoutDataMutator) ((CheckoutStyleAssociation) this.f18488a.get(CheckoutStyle.SIMPLE)).f15725c.get();
    }

    public static SimpleCheckoutManager m18489a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SimpleCheckoutManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18487c) {
                SimpleCheckoutManager simpleCheckoutManager;
                if (a2 != null) {
                    simpleCheckoutManager = (SimpleCheckoutManager) a2.a(f18487c);
                } else {
                    simpleCheckoutManager = f18486b;
                }
                if (simpleCheckoutManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m18490b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18487c, b3);
                        } else {
                            f18486b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = simpleCheckoutManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final SimpleCheckoutSubScreenParamsGenerator m18493d(CheckoutStyle checkoutStyle) {
        if (this.f18488a.containsKey(checkoutStyle)) {
            return (SimpleCheckoutSubScreenParamsGenerator) ((CheckoutStyleAssociation) this.f18488a.get(checkoutStyle)).f15727e.get();
        }
        return (SimpleCheckoutSubScreenParamsGenerator) ((CheckoutStyleAssociation) this.f18488a.get(CheckoutStyle.SIMPLE)).f15727e.get();
    }

    public final SimpleCheckoutStateMachineOrganizer m18494g(CheckoutStyle checkoutStyle) {
        if (this.f18488a.containsKey(checkoutStyle)) {
            return (SimpleCheckoutStateMachineOrganizer) ((CheckoutStyleAssociation) this.f18488a.get(checkoutStyle)).f15730h.get();
        }
        return (SimpleCheckoutStateMachineOrganizer) ((CheckoutStyleAssociation) this.f18488a.get(CheckoutStyle.SIMPLE)).f15730h.get();
    }
}
