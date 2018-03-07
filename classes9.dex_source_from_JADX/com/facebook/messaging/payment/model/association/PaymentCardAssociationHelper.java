package com.facebook.messaging.payment.model.association;

import com.facebook.payments.paymentmethods.model.FbPaymentCardType;

/* compiled from: hideableToken */
public class PaymentCardAssociationHelper {

    /* compiled from: hideableToken */
    public /* synthetic */ class C14891 {
        public static final /* synthetic */ int[] f13270a = new int[FbPaymentCardType.values().length];

        static {
            try {
                f13270a[FbPaymentCardType.AMEX.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13270a[FbPaymentCardType.DISCOVER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13270a[FbPaymentCardType.MASTER_CARD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f13270a[FbPaymentCardType.VISA.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f13270a[FbPaymentCardType.JCB.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f13270a[FbPaymentCardType.UNKNOWN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }
}
