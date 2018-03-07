package com.facebook.messaging.payment.prefs.receipts.manual.model;

import android.content.Context;

/* compiled from: generic_attachment_tall_cover_image_width */
public class ShippingFulfillmentModelAdapter implements BasicReceiptSummaryModelAdapter {
    private final Context f14267a;

    public ShippingFulfillmentModelAdapter(Context context) {
        this.f14267a = context;
    }

    public final String mo558a() {
        return this.f14267a.getResources().getString(2131240589);
    }

    public final String mo559a(InvoicesSummaryModel invoicesSummaryModel) {
        return (String) invoicesSummaryModel.f14253f.get();
    }
}
