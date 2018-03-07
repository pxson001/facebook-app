package com.facebook.messaging.payment.prefs.receipts.manual.model;

import android.content.Context;

/* compiled from: geo_locations */
public class PaymentStatusModelAdapter implements BasicReceiptSummaryModelAdapter {
    private final Context f14265a;

    public PaymentStatusModelAdapter(Context context) {
        this.f14265a = context;
    }

    public final String mo558a() {
        return this.f14265a.getResources().getString(2131240588);
    }

    public final String mo559a(InvoicesSummaryModel invoicesSummaryModel) {
        return ((String) invoicesSummaryModel.f14264q.get()).toString();
    }
}
