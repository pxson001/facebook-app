package com.facebook.messaging.payment.prefs.receipts.header;

import com.facebook.messaging.payment.model.PaymentUser;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: getRecipientEligibility */
public class ReceiptHeaderViewParams {
    public final PaymentUser f14148a;
    public final String f14149b;
    public final String f14150c;
    public final boolean f14151d;

    public ReceiptHeaderViewParams(ReceiptHeaderViewParamsBuilder receiptHeaderViewParamsBuilder) {
        Preconditions.checkNotNull(receiptHeaderViewParamsBuilder.f14152a);
        this.f14148a = receiptHeaderViewParamsBuilder.f14152a;
        this.f14149b = receiptHeaderViewParamsBuilder.f14153b;
        this.f14150c = receiptHeaderViewParamsBuilder.f14154c;
        this.f14151d = receiptHeaderViewParamsBuilder.f14155d;
    }

    public static ReceiptHeaderViewParamsBuilder newBuilder() {
        return new ReceiptHeaderViewParamsBuilder();
    }
}
