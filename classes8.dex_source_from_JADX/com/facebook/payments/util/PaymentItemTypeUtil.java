package com.facebook.payments.util;

import com.facebook.payments.model.PaymentItemType;

/* compiled from: storyteller4a */
public class PaymentItemTypeUtil {
    public static boolean m2242a(PaymentItemType paymentItemType) {
        switch (paymentItemType) {
            case EVENT_TICKETING:
            case MESSENGER_COMMERCE:
            case P2P_TRANSFER:
            case PAGES_COMMERCE:
            case NONE:
                return false;
            case INVOICE:
                return true;
            default:
                throw new UnsupportedOperationException("Not supported yet for " + paymentItemType);
        }
    }
}
