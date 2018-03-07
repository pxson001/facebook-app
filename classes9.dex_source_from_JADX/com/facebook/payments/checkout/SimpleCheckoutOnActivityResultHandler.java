package com.facebook.payments.checkout;

import android.content.Intent;
import com.facebook.payments.checkout.CheckoutFragment.C21384;
import com.facebook.payments.checkout.model.CheckoutData;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.shipping.model.MailingAddress;
import com.facebook.payments.shipping.model.ShippingOption;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: card_features */
public class SimpleCheckoutOnActivityResultHandler {
    public C21384 f18489a;

    public final void m18497a(CheckoutData checkoutData, int i, int i2, Intent intent) {
        Preconditions.checkNotNull(this.f18489a);
        switch (i) {
            case 100:
            case 101:
                m18496b(i2, intent);
                return;
            case 102:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("extra_shipping_option_id");
                    ImmutableList i3 = checkoutData.mo725i();
                    int size = i3.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        ShippingOption shippingOption = (ShippingOption) i3.get(i4);
                        if (shippingOption.mo646a().equals(stringExtra)) {
                            C21384 c21384 = this.f18489a;
                            c21384.f18468a.am.m15937a(c21384.f18468a.al, shippingOption);
                        }
                    }
                }
                return;
            case 103:
            case 104:
                m18495a(i2, intent);
                return;
            default:
                return;
        }
    }

    private void m18495a(int i, Intent intent) {
        if (i == -1) {
            MailingAddress mailingAddress = (MailingAddress) intent.getParcelableExtra("shipping_address");
            C21384 c21384 = this.f18489a;
            c21384.f18468a.am.mo640a(c21384.f18468a.al, mailingAddress);
        }
    }

    private void m18496b(int i, Intent intent) {
        if (i == -1) {
            PaymentMethod paymentMethod = (PaymentMethod) intent.getParcelableExtra("selected_payment_method");
            C21384 c21384 = this.f18489a;
            c21384.f18468a.am.m15935a(c21384.f18468a.al, paymentMethod);
        }
    }
}
