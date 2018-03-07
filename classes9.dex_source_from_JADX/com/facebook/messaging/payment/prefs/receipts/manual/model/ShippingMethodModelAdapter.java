package com.facebook.messaging.payment.prefs.receipts.manual.model;

import android.content.Context;

/* compiled from: generic_attachment_tall_cover_image_height */
public class ShippingMethodModelAdapter implements BasicReceiptSummaryModelAdapter {
    private final Context f14268a;

    public ShippingMethodModelAdapter(Context context) {
        this.f14268a = context;
    }

    public final String mo558a() {
        return this.f14268a.getResources().getString(2131240249);
    }

    public final String mo559a(InvoicesSummaryModel invoicesSummaryModel) {
        return (String) invoicesSummaryModel.f14252e.get();
    }
}
