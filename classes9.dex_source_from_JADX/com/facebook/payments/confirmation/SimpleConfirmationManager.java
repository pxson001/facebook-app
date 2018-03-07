package com.facebook.payments.confirmation;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Set;
import javax.inject.Inject;

@ContextScoped
/* compiled from: callLog */
public class SimpleConfirmationManager {
    private static SimpleConfirmationManager f18630b;
    private static final Object f18631c = new Object();
    private final ImmutableMap<ConfirmationStyle, ConfirmationStyleAssociation> f18632a;

    private static SimpleConfirmationManager m18647b(InjectorLike injectorLike) {
        return new SimpleConfirmationManager(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$ConfirmationStyleAssociation(injectorLike)));
    }

    @Inject
    public SimpleConfirmationManager(Set<ConfirmationStyleAssociation> set) {
        Builder builder = ImmutableMap.builder();
        for (ConfirmationStyleAssociation confirmationStyleAssociation : set) {
            builder.b(confirmationStyleAssociation.f15793a, confirmationStyleAssociation);
        }
        this.f18632a = builder.b();
    }

    public final SimpleConfirmationRowsGenerator m18648a(ConfirmationStyle confirmationStyle) {
        if (!this.f18632a.containsKey(confirmationStyle)) {
            confirmationStyle = ConfirmationStyle.SIMPLE;
        }
        return (SimpleConfirmationRowsGenerator) ((ConfirmationStyleAssociation) this.f18632a.get(confirmationStyle)).f15797e.get();
    }

    public final SimpleConfirmationRowViewHolderFactory m18649b(ConfirmationStyle confirmationStyle) {
        if (!this.f18632a.containsKey(confirmationStyle)) {
            confirmationStyle = ConfirmationStyle.SIMPLE;
        }
        return (SimpleConfirmationRowViewHolderFactory) ((ConfirmationStyleAssociation) this.f18632a.get(confirmationStyle)).f15796d.get();
    }

    public final SimpleConfirmationOnActivityResultHandler m18650c(ConfirmationStyle confirmationStyle) {
        if (!this.f18632a.containsKey(confirmationStyle)) {
            confirmationStyle = ConfirmationStyle.SIMPLE;
        }
        return (SimpleConfirmationOnActivityResultHandler) ((ConfirmationStyleAssociation) this.f18632a.get(confirmationStyle)).f15795c.get();
    }

    public final SimplePostPurchaseActionHandler m18651d(ConfirmationStyle confirmationStyle) {
        if (!this.f18632a.containsKey(confirmationStyle)) {
            confirmationStyle = ConfirmationStyle.SIMPLE;
        }
        return (SimplePostPurchaseActionHandler) ((ConfirmationStyleAssociation) this.f18632a.get(confirmationStyle)).f15794b.get();
    }

    public static SimpleConfirmationManager m18646a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SimpleConfirmationManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18631c) {
                SimpleConfirmationManager simpleConfirmationManager;
                if (a2 != null) {
                    simpleConfirmationManager = (SimpleConfirmationManager) a2.a(f18631c);
                } else {
                    simpleConfirmationManager = f18630b;
                }
                if (simpleConfirmationManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m18647b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18631c, b3);
                        } else {
                            f18630b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = simpleConfirmationManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
