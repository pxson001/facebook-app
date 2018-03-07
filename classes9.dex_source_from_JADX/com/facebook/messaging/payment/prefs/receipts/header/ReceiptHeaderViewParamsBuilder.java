package com.facebook.messaging.payment.prefs.receipts.header;

import com.facebook.messaging.payment.model.PaymentUser;

/* compiled from: getPrimaryPaymentCardId */
public class ReceiptHeaderViewParamsBuilder {
    public PaymentUser f14152a;
    public String f14153b;
    public String f14154c;
    public boolean f14155d;

    public final PaymentUser m14619a() {
        return this.f14152a;
    }

    public final ReceiptHeaderViewParamsBuilder m14620a(PaymentUser paymentUser) {
        this.f14152a = paymentUser;
        return this;
    }

    public final String m14624b() {
        return this.f14153b;
    }

    public final ReceiptHeaderViewParamsBuilder m14621a(String str) {
        this.f14153b = str;
        return this;
    }

    public final String m14625c() {
        return this.f14154c;
    }

    public final ReceiptHeaderViewParamsBuilder m14623b(String str) {
        this.f14154c = str;
        return this;
    }

    public final boolean m14626d() {
        return this.f14155d;
    }

    public final ReceiptHeaderViewParamsBuilder m14622a(boolean z) {
        this.f14155d = z;
        return this;
    }

    public final ReceiptHeaderViewParams m14627e() {
        return new ReceiptHeaderViewParams(this);
    }
}
