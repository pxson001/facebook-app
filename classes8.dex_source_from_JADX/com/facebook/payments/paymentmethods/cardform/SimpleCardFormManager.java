package com.facebook.payments.paymentmethods.cardform;

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
/* compiled from: tagged_profiles */
public class SimpleCardFormManager {
    private static SimpleCardFormManager f1872b;
    private static final Object f1873c = new Object();
    public final ImmutableMap<CardFormStyle, CardFormStyleAssociation> f1874a;

    private static SimpleCardFormManager m2072b(InjectorLike injectorLike) {
        return new SimpleCardFormManager(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$CardFormStyleAssociation(injectorLike)));
    }

    @Inject
    public SimpleCardFormManager(Set<CardFormStyleAssociation> set) {
        Builder builder = ImmutableMap.builder();
        for (CardFormStyleAssociation cardFormStyleAssociation : set) {
            builder.b(cardFormStyleAssociation.f1843a, cardFormStyleAssociation);
        }
        this.f1874a = builder.b();
    }

    public final SimpleCardFormStyleRenderer m2073a(CardFormStyle cardFormStyle) {
        return (SimpleCardFormStyleRenderer) (this.f1874a.containsKey(cardFormStyle) ? ((CardFormStyleAssociation) this.f1874a.get(cardFormStyle)).f1844b.get() : ((CardFormStyleAssociation) this.f1874a.get(CardFormStyle.SIMPLE)).f1844b.get());
    }

    public final SimpleCardFormAnalyticsEventSelector m2074b(CardFormStyle cardFormStyle) {
        return (SimpleCardFormAnalyticsEventSelector) (this.f1874a.containsKey(cardFormStyle) ? ((CardFormStyleAssociation) this.f1874a.get(cardFormStyle)).f1845c.get() : ((CardFormStyleAssociation) this.f1874a.get(CardFormStyle.SIMPLE)).f1845c.get());
    }

    public final SimpleCardFormConfigurator m2075c(CardFormStyle cardFormStyle) {
        return (SimpleCardFormConfigurator) (this.f1874a.containsKey(cardFormStyle) ? ((CardFormStyleAssociation) this.f1874a.get(cardFormStyle)).f1846d.get() : ((CardFormStyleAssociation) this.f1874a.get(CardFormStyle.SIMPLE)).f1846d.get());
    }

    public final SimpleCardFormViewController m2076d(CardFormStyle cardFormStyle) {
        return (SimpleCardFormViewController) (this.f1874a.containsKey(cardFormStyle) ? ((CardFormStyleAssociation) this.f1874a.get(cardFormStyle)).f1847e.get() : ((CardFormStyleAssociation) this.f1874a.get(CardFormStyle.SIMPLE)).f1847e.get());
    }

    public static SimpleCardFormManager m2071a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SimpleCardFormManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1873c) {
                SimpleCardFormManager simpleCardFormManager;
                if (a2 != null) {
                    simpleCardFormManager = (SimpleCardFormManager) a2.a(f1873c);
                } else {
                    simpleCardFormManager = f1872b;
                }
                if (simpleCardFormManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2072b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1873c, b3);
                        } else {
                            f1872b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = simpleCardFormManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
