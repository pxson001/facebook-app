package com.facebook.payments.checkout.recyclerview.decorator;

import com.facebook.payments.checkout.recyclerview.CheckoutRow;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/* compiled from: camera_never_ask_again_shown */
public class LoadingPurchaseInfoDecorator extends CheckoutRowsDecorator {
    private static final Predicate<CheckoutRow> f18576a = new C21521();
    private final boolean f18577b;

    /* compiled from: camera_never_ask_again_shown */
    final class C21521 implements Predicate<CheckoutRow> {
        C21521() {
        }

        public final boolean apply(Object obj) {
            return !((CheckoutRow) obj).mo637c();
        }
    }

    public LoadingPurchaseInfoDecorator(CheckoutRows checkoutRows, boolean z) {
        super(checkoutRows);
        this.f18577b = z;
    }

    public final ImmutableList<CheckoutRow> mo731a() {
        ImmutableList<CheckoutRow> a = super.mo731a();
        if (!this.f18577b) {
            return a;
        }
        FluentIterable a2 = FluentIterable.a(a);
        return ImmutableList.copyOf(FluentIterable.a(Iterables.c(a2.a, f18576a)).a);
    }
}
