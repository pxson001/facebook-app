package com.facebook.payments.checkout;

import com.facebook.flatbuffers.Flattenable;
import com.facebook.payments.checkout.CheckoutFragment.C21373;
import com.facebook.payments.checkout.model.CheckoutData;
import com.facebook.payments.checkout.model.CheckoutItemPrice;
import com.facebook.payments.checkout.model.SimpleCheckoutData;
import com.facebook.payments.checkout.model.SimpleCheckoutDataBuilder;
import com.facebook.payments.checkout.statemachine.CheckoutStateMachineState;
import com.facebook.payments.model.PaymentsPin;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.shipping.model.MailingAddress;
import com.facebook.payments.shipping.model.ShippingOption;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Iterables;
import java.util.List;

/* compiled from: end_stream_upload */
public class SimpleCheckoutDataMutator {
    public C21373 f15751a;
    public SimplePaymentsComponentCallback f15752b;

    public final void m15931a(CheckoutData checkoutData, Flattenable flattenable) {
        checkoutData = (SimpleCheckoutData) checkoutData;
        Preconditions.checkNotNull(this.f15751a);
        SimpleCheckoutDataBuilder a = SimpleCheckoutData.newBuilder().m18526a(checkoutData);
        a.f18512j = flattenable;
        this.f15751a.m18469a(a.m18528n());
    }

    public final void m15932a(CheckoutData checkoutData, CheckoutItemPrice checkoutItemPrice) {
        checkoutData = (SimpleCheckoutData) checkoutData;
        Preconditions.checkNotNull(this.f15751a);
        SimpleCheckoutDataBuilder a = SimpleCheckoutData.newBuilder().m18526a(checkoutData);
        a.f18505c = checkoutItemPrice;
        this.f15751a.m18469a(a.m18528n());
    }

    public final void m15933a(CheckoutData checkoutData, CheckoutStateMachineState checkoutStateMachineState) {
        SimpleCheckoutDataBuilder a = SimpleCheckoutData.newBuilder().m18526a((SimpleCheckoutData) checkoutData);
        a.f18513k = checkoutStateMachineState;
        this.f15751a.m18469a(a.m18528n());
    }

    public final void m15934a(CheckoutData checkoutData, PaymentsPin paymentsPin) {
        SimpleCheckoutDataBuilder a = SimpleCheckoutData.newBuilder().m18526a((SimpleCheckoutData) checkoutData);
        a.f18506d = paymentsPin;
        this.f15751a.m18469a(a.m18528n());
    }

    public final void m15935a(CheckoutData checkoutData, PaymentMethod paymentMethod) {
        checkoutData = (SimpleCheckoutData) checkoutData;
        Preconditions.checkNotNull(this.f15751a);
        ImmutableList a = m15929a(checkoutData.mo729m(), paymentMethod);
        SimpleCheckoutDataBuilder a2 = SimpleCheckoutData.newBuilder().m18526a(checkoutData);
        a2.f18515m = a;
        SimpleCheckoutDataBuilder simpleCheckoutDataBuilder = a2;
        simpleCheckoutDataBuilder.f18514l = Optional.of(paymentMethod);
        this.f15751a.m18469a(simpleCheckoutDataBuilder.m18528n());
    }

    public final void m15937a(CheckoutData checkoutData, ShippingOption shippingOption) {
        checkoutData = (SimpleCheckoutData) checkoutData;
        Preconditions.checkNotNull(this.f15751a);
        SimpleCheckoutDataBuilder a = SimpleCheckoutData.newBuilder().m18526a(checkoutData);
        a.f18510h = Optional.of(shippingOption);
        this.f15751a.m18469a(a.m18528n());
    }

    public final void m15938a(CheckoutData checkoutData, ImmutableList immutableList) {
        checkoutData = (SimpleCheckoutData) checkoutData;
        Preconditions.checkNotNull(this.f15751a);
        SimpleCheckoutDataBuilder a = SimpleCheckoutData.newBuilder().m18526a(checkoutData);
        a.f18511i = immutableList;
        a = a;
        if (immutableList.isEmpty()) {
            a.f18510h = Absent.INSTANCE;
        }
        if (checkoutData.mo724h() == null && !immutableList.isEmpty()) {
            a.f18510h = Optional.fromNullable(Iterables.a(immutableList, null));
        }
        this.f15751a.m18469a(a.m18528n());
    }

    public final void m15939a(CheckoutData checkoutData, String str) {
        SimpleCheckoutDataBuilder a = SimpleCheckoutData.newBuilder().m18526a((SimpleCheckoutData) checkoutData);
        a.f18507e = str;
        this.f15751a.m18469a(a.m18528n());
    }

    public final void m15940a(CheckoutData checkoutData, boolean z) {
        SimpleCheckoutDataBuilder a = SimpleCheckoutData.newBuilder().m18526a((SimpleCheckoutData) checkoutData);
        a.f18504b = z;
        this.f15751a.m18469a(a.m18528n());
    }

    public final void m15942b(CheckoutData checkoutData, ImmutableList immutableList) {
        checkoutData = (SimpleCheckoutData) checkoutData;
        Preconditions.checkNotNull(this.f15751a);
        SimpleCheckoutDataBuilder a = SimpleCheckoutData.newBuilder().m18526a(checkoutData).m18527a((List) immutableList);
        if (immutableList.isEmpty()) {
            a.f18508f = Absent.INSTANCE;
        }
        if (checkoutData.mo722f() == null && !immutableList.isEmpty()) {
            a.f18508f = Optional.fromNullable(Iterables.a(immutableList, null));
        }
        this.f15751a.m18469a(a.m18528n());
    }

    public final void m15943c(CheckoutData checkoutData, ImmutableList immutableList) {
        checkoutData = (SimpleCheckoutData) checkoutData;
        Preconditions.checkNotNull(this.f15751a);
        SimpleCheckoutDataBuilder a = SimpleCheckoutData.newBuilder().m18526a(checkoutData);
        a.f18515m = immutableList;
        a = a;
        if (immutableList.isEmpty()) {
            a.f18514l = Absent.INSTANCE;
        }
        if (checkoutData.mo728l() == null && !immutableList.isEmpty()) {
            a.f18514l = Optional.fromNullable(Iterables.a(immutableList, null));
        }
        this.f15751a.m18469a(a.m18528n());
    }

    public void mo641a(SimpleCheckoutData simpleCheckoutData, MailingAddress mailingAddress) {
        Preconditions.checkNotNull(this.f15751a);
        SimpleCheckoutDataBuilder a = SimpleCheckoutData.newBuilder().m18526a((CheckoutData) simpleCheckoutData).m18527a(m15930a(simpleCheckoutData.mo723g(), mailingAddress));
        a.f18508f = Optional.of(mailingAddress);
        this.f15751a.m18469a(a.m18528n());
    }

    public static ImmutableList<MailingAddress> m15930a(ImmutableList<MailingAddress> immutableList, MailingAddress mailingAddress) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (((MailingAddress) immutableList.get(i)).mo760a().equals(mailingAddress.mo760a())) {
                return immutableList;
            }
        }
        Builder builder = new Builder();
        builder.b(immutableList);
        builder.c(mailingAddress);
        return builder.b();
    }

    @VisibleForTesting
    private static ImmutableList<PaymentMethod> m15929a(ImmutableList<PaymentMethod> immutableList, PaymentMethod paymentMethod) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (((PaymentMethod) immutableList.get(i)).a().equals(paymentMethod.a())) {
                return immutableList;
            }
        }
        Builder builder = new Builder();
        builder.b(immutableList);
        builder.c(paymentMethod);
        return builder.b();
    }
}
