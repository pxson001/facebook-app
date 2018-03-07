package com.facebook.payments.checkout.model;

import android.os.Parcelable;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.payments.checkout.CheckoutParams;
import com.facebook.payments.checkout.statemachine.CheckoutStateMachineState;
import com.facebook.payments.model.PaymentsPin;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.shipping.model.MailingAddress;
import com.facebook.payments.shipping.model.ShippingOption;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: captions */
public interface CheckoutData extends Parcelable {
    CheckoutParams mo717a();

    boolean mo718b();

    @Nullable
    CheckoutItemPrice mo719c();

    @Nullable
    PaymentsPin mo720d();

    @Nullable
    String mo721e();

    @Nullable
    Optional<MailingAddress> mo722f();

    @Nullable
    ImmutableList<MailingAddress> mo723g();

    @Nullable
    Optional<ShippingOption> mo724h();

    @Nullable
    ImmutableList<ShippingOption> mo725i();

    @Nullable
    Flattenable mo726j();

    CheckoutStateMachineState mo727k();

    @Nullable
    Optional<PaymentMethod> mo728l();

    @Nullable
    ImmutableList<PaymentMethod> mo729m();
}
