package com.facebook.messaging.payment.method.verification;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.service.model.cards.FetchPaymentCardsResult;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.inject.Inject;

@ContextScoped
/* compiled from: imp_currency_selection */
public class PaymentCardsFetcher {
    private static PaymentCardsFetcher f13111c;
    private static final Object f13112d = new Object();
    public final PaymentProtocolUtil f13113a;
    public ListenableFuture<FetchPaymentCardsResult> f13114b;

    /* compiled from: imp_currency_selection */
    class C14622 implements Function<FetchPaymentCardsResult, ImmutableList<PaymentCard>> {
        final /* synthetic */ PaymentCardsFetcher f13110a;

        C14622(PaymentCardsFetcher paymentCardsFetcher) {
            this.f13110a = paymentCardsFetcher;
        }

        public Object apply(Object obj) {
            return ((FetchPaymentCardsResult) obj).f14636c;
        }
    }

    private static PaymentCardsFetcher m13431b(InjectorLike injectorLike) {
        return new PaymentCardsFetcher(PaymentProtocolUtil.m14937a(injectorLike));
    }

    @Inject
    public PaymentCardsFetcher(PaymentProtocolUtil paymentProtocolUtil) {
        this.f13113a = paymentProtocolUtil;
    }

    public static PaymentCardsFetcher m13429a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PaymentCardsFetcher b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13112d) {
                PaymentCardsFetcher paymentCardsFetcher;
                if (a2 != null) {
                    paymentCardsFetcher = (PaymentCardsFetcher) a2.a(f13112d);
                } else {
                    paymentCardsFetcher = f13111c;
                }
                if (paymentCardsFetcher == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m13431b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13112d, b3);
                        } else {
                            f13111c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = paymentCardsFetcher;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static ImmutableList<PaymentCard> m13430a(ImmutableList<PaymentCard> immutableList) {
        Builder builder = new Builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            PaymentCard paymentCard = (PaymentCard) immutableList.get(i);
            if (paymentCard.m13513t()) {
                builder.c(paymentCard);
            }
        }
        return builder.b();
    }

    public static ImmutableList<PaymentCard> m13432c(ImmutableList<PaymentCard> immutableList) {
        Builder builder = new Builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            PaymentCard paymentCard = (PaymentCard) immutableList.get(i);
            if (paymentCard.mo523h()) {
                builder.c(paymentCard);
            }
        }
        return builder.b();
    }

    public static ImmutableList<PaymentCard> m13433d(ImmutableList<PaymentCard> immutableList) {
        Builder builder = new Builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            PaymentCard paymentCard = (PaymentCard) immutableList.get(i);
            if (paymentCard.mo524k()) {
                builder.c(paymentCard);
            }
        }
        return builder.b();
    }

    public final ListenableFuture<ImmutableList<PaymentCard>> m13434a() {
        if (this.f13114b == null || this.f13114b.isDone()) {
            this.f13114b = this.f13113a.m14940a();
        }
        return Futures.a(this.f13114b, new C14622(this), MoreExecutors.a());
    }
}
