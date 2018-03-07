package com.facebook.messaging.payment.prefs.receipts.manual.model;

import android.content.res.Resources;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import javax.inject.Inject;

/* compiled from: generic_attachment_small_square_image_dimension */
public class TransactionInvoiceConverter {
    public final Resources f14269a;
    public final PaymentCurrencyUtil f14270b;

    @Inject
    public TransactionInvoiceConverter(Resources resources, PaymentCurrencyUtil paymentCurrencyUtil) {
        this.f14269a = resources;
        this.f14270b = paymentCurrencyUtil;
    }
}
