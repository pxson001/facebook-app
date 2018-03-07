package com.facebook.messaging.payment.util;

import com.facebook.payments.model.PaymentItemType;

/* compiled from: f2059fdd2bdbde10a6be9c94bc6cd552 */
public class PaymentFlowTypeUtil {
    public static PaymentItemType m15515a(boolean z) {
        return z ? PaymentItemType.MESSENGER_COMMERCE : PaymentItemType.P2P_TRANSFER;
    }
}
