package com.facebook.messaging.payment.prefs.receipts.manual.model;

import android.content.Context;

/* compiled from: geo */
public class ShippingAddressModelAdapter implements BasicReceiptSummaryModelAdapter {
    private final Context f14266a;

    public ShippingAddressModelAdapter(Context context) {
        this.f14266a = context;
    }

    public final String mo558a() {
        return this.f14266a.getResources().getString(2131240248);
    }

    public final String mo559a(InvoicesSummaryModel invoicesSummaryModel) {
        return (String) invoicesSummaryModel.f14251d.get();
    }
}
