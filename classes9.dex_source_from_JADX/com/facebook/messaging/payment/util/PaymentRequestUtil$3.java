package com.facebook.messaging.payment.util;

import com.facebook.graphql.enums.GraphQLPeerToPeerPaymentRequestStatus;

/* compiled from: f0b773fe05b88f8aa9e08cff99020ce6 */
/* synthetic */ class PaymentRequestUtil$3 {
    static final /* synthetic */ int[] f15166a = new int[GraphQLPeerToPeerPaymentRequestStatus.values().length];

    static {
        try {
            f15166a[GraphQLPeerToPeerPaymentRequestStatus.INITED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f15166a[GraphQLPeerToPeerPaymentRequestStatus.TRANSFER_INITED.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f15166a[GraphQLPeerToPeerPaymentRequestStatus.TRANSFER_FAILED.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f15166a[GraphQLPeerToPeerPaymentRequestStatus.DECLINED.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f15166a[GraphQLPeerToPeerPaymentRequestStatus.TRANSFER_COMPLETED.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f15166a[GraphQLPeerToPeerPaymentRequestStatus.CANCELED.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
    }
}
