package com.facebook.messaging.payment.util;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.TransferStatus;
import com.facebook.messaging.util.date.MessagingDateUtil;
import com.facebook.user.model.User;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: extra_user_action */
public class PaymentTransactionUtil {
    private static PaymentTransactionUtil f15167c;
    private static final Object f15168d = new Object();
    private final Provider<User> f15169a;
    private final MessagingDateUtil f15170b;

    private static PaymentTransactionUtil m15522b(InjectorLike injectorLike) {
        return new PaymentTransactionUtil(IdBasedProvider.a(injectorLike, 3596), MessagingDateUtil.a(injectorLike));
    }

    @Inject
    public PaymentTransactionUtil(Provider<User> provider, MessagingDateUtil messagingDateUtil) {
        this.f15169a = provider;
        this.f15170b = messagingDateUtil;
    }

    public final boolean m15527c(PaymentTransaction paymentTransaction) {
        return m15520a().equals(paymentTransaction.f13232e.mo526b());
    }

    public static PaymentTransactionUtil m15519a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PaymentTransactionUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f15168d) {
                PaymentTransactionUtil paymentTransactionUtil;
                if (a2 != null) {
                    paymentTransactionUtil = (PaymentTransactionUtil) a2.a(f15168d);
                } else {
                    paymentTransactionUtil = f15167c;
                }
                if (paymentTransactionUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15522b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f15168d, b3);
                        } else {
                            f15167c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = paymentTransactionUtil;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m15525a(String str) {
        return m15520a().equals(str);
    }

    public final boolean m15528d(PaymentTransaction paymentTransaction) {
        return m15520a().equals(String.valueOf(paymentTransaction.f13231d.mo526b()));
    }

    private String m15520a() {
        return ((User) this.f15169a.get()).a;
    }

    public static boolean m15523e(@Nullable PaymentTransaction paymentTransaction) {
        return m15524f(paymentTransaction) && (paymentTransaction.f13234g == TransferStatus.R_COMPLETED || paymentTransaction.f13234g == TransferStatus.S_COMPLETED);
    }

    public static boolean m15524f(@Nullable PaymentTransaction paymentTransaction) {
        return (paymentTransaction == null || paymentTransaction.f13239l.m13951b() == null) ? false : true;
    }

    public final String m15526b(String str) {
        return this.f15170b.d(Long.parseLong(str) * 1000);
    }

    public static boolean m15521a(PaymentTransaction paymentTransaction) {
        return paymentTransaction.f13238k.m13469d() == paymentTransaction.f13237j.m13469d();
    }
}
