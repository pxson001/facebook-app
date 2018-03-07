package com.facebook.messaging.payment.value.input.pagescommerce;

import android.content.Context;
import com.facebook.messaging.payment.prefs.receipts.manual.InvoicesSummaryFragment;
import com.facebook.payments.confirmation.ReceiptPostPurchaseAction;
import com.facebook.payments.confirmation.SimplePostPurchaseActionHandler;
import javax.inject.Inject;

/* compiled from: emoji_ */
public class PagesCommercePostPurchaseActionHandler extends SimplePostPurchaseActionHandler {
    @Inject
    public PagesCommercePostPurchaseActionHandler(Context context) {
        super(context);
    }

    protected final void mo648a(ReceiptPostPurchaseAction receiptPostPurchaseAction) {
        this.f15824b.b(InvoicesSummaryFragment.m14671c(this.f15823a, receiptPostPurchaseAction.f18626a));
    }
}
