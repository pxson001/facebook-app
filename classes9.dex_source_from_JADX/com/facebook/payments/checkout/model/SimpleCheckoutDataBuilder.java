package com.facebook.payments.checkout.model;

import com.facebook.flatbuffers.Flattenable;
import com.facebook.payments.checkout.CheckoutParams;
import com.facebook.payments.checkout.statemachine.CheckoutStateMachineState;
import com.facebook.payments.model.PaymentsPin;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.shipping.model.MailingAddress;
import com.facebook.payments.shipping.model.ShippingOption;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: canonical_thread_pic */
public class SimpleCheckoutDataBuilder {
    public CheckoutParams f18503a;
    public boolean f18504b;
    public CheckoutItemPrice f18505c;
    public PaymentsPin f18506d;
    public String f18507e;
    public Optional<MailingAddress> f18508f;
    public ImmutableList<MailingAddress> f18509g;
    public Optional<ShippingOption> f18510h;
    public ImmutableList<ShippingOption> f18511i;
    public Flattenable f18512j;
    public CheckoutStateMachineState f18513k;
    public Optional<PaymentMethod> f18514l;
    public ImmutableList<PaymentMethod> f18515m;

    public final SimpleCheckoutDataBuilder m18526a(CheckoutData checkoutData) {
        this.f18503a = checkoutData.mo717a();
        this.f18504b = checkoutData.mo718b();
        this.f18505c = checkoutData.mo719c();
        this.f18506d = checkoutData.mo720d();
        this.f18507e = checkoutData.mo721e();
        this.f18508f = checkoutData.mo722f();
        SimpleCheckoutDataBuilder a = m18527a(checkoutData.mo723g());
        a.f18510h = checkoutData.mo724h();
        a = a;
        a.f18511i = checkoutData.mo725i();
        a = a;
        a.f18512j = checkoutData.mo726j();
        a = a;
        a.f18513k = checkoutData.mo727k();
        a = a;
        a.f18514l = checkoutData.mo728l();
        a = a;
        a.f18515m = checkoutData.mo729m();
        return a;
    }

    public final SimpleCheckoutDataBuilder m18527a(List<MailingAddress> list) {
        this.f18509g = (ImmutableList) list;
        return this;
    }

    public final SimpleCheckoutData m18528n() {
        return new SimpleCheckoutData(this);
    }
}
