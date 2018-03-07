package com.facebook.payments.paymentmethods.picker.protocol.parser;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import java.util.Set;
import javax.inject.Inject;

@ContextScoped
/* compiled from: bd4ff7cf1066d15af17312acac9e2680 */
public class PaymentMethodsInfoParserManager {
    private static PaymentMethodsInfoParserManager f18873d;
    private static final Object f18874e = new Object();
    public final Set<PaymentMethodParser> f18875a;
    public final Set<NMORNewPaymentOptionParser> f18876b;
    public final Set<MORNewPaymentOptionParser> f18877c;

    private static PaymentMethodsInfoParserManager m18885b(InjectorLike injectorLike) {
        return new PaymentMethodsInfoParserManager(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$PaymentMethodParser(injectorLike)), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$NMORNewPaymentOptionParser(injectorLike)), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$MORNewPaymentOptionParser(injectorLike)));
    }

    @Inject
    public PaymentMethodsInfoParserManager(Set<PaymentMethodParser> set, Set<NMORNewPaymentOptionParser> set2, Set<MORNewPaymentOptionParser> set3) {
        this.f18875a = set;
        this.f18876b = set2;
        this.f18877c = set3;
    }

    public static PaymentMethodsInfoParserManager m18884a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PaymentMethodsInfoParserManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18874e) {
                PaymentMethodsInfoParserManager paymentMethodsInfoParserManager;
                if (a2 != null) {
                    paymentMethodsInfoParserManager = (PaymentMethodsInfoParserManager) a2.a(f18874e);
                } else {
                    paymentMethodsInfoParserManager = f18873d;
                }
                if (paymentMethodsInfoParserManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m18885b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18874e, b3);
                        } else {
                            f18873d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = paymentMethodsInfoParserManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
