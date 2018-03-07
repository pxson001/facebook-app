package com.facebook.payments.confirmation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.messaging.payment.pin.PaymentPinCreationActivity;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import javax.inject.Inject;

/* compiled from: emoji_attachment_popup */
public class SimplePostPurchaseActionHandler {
    public final Context f15823a;
    public SimplePaymentsComponentCallback f15824b;

    @Inject
    public SimplePostPurchaseActionHandler(Context context) {
        this.f15823a = context;
    }

    public final void m16008a(SimplePostPurchaseAction simplePostPurchaseAction) {
        switch (simplePostPurchaseAction.f18625b) {
            case SEE_RECEIPT:
                mo648a((ReceiptPostPurchaseAction) simplePostPurchaseAction);
                return;
            case ACTIVATE_SECURITY_PIN:
                this.f15824b.a(PaymentPinCreationActivity.m14149a(this.f15823a), 1);
                return;
            default:
                return;
        }
    }

    protected void mo648a(ReceiptPostPurchaseAction receiptPostPurchaseAction) {
        this.f15824b.b(new Intent("android.intent.action.VIEW").setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe("https://secure.m.facebook.com/settings?tab=payments&id=%s", receiptPostPurchaseAction.f18626a)).buildUpon().build()));
    }
}
