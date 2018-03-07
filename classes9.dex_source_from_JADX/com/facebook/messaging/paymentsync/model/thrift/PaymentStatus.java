package com.facebook.messaging.paymentsync.model.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: drafts/# */
public class PaymentStatus {
    public static final IntRangeSet f15974a = new IntRangeSet(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18});
    public static final Map<Integer, String> f15975b = new C18681();

    /* compiled from: drafts/# */
    final class C18681 extends HashMap<Integer, String> {
        C18681() {
            put(Integer.valueOf(1), "PENDING_SENDER_MANUAL_REVIEW");
            put(Integer.valueOf(2), "PENDING_SENDER_VERIFICATION");
            put(Integer.valueOf(3), "CANCELED_SENDER_RISK");
            put(Integer.valueOf(4), "PENDING_RECIPIENT_NUX");
            put(Integer.valueOf(5), "CANCELED_DECLINED");
            put(Integer.valueOf(6), "PENDING_RECIPIENT_VERIFICATION");
            put(Integer.valueOf(7), "PENDING_RECIPIENT_MANUAL_REVIEW");
            put(Integer.valueOf(8), "PENDING_RECIPIENT_PROCESSING");
            put(Integer.valueOf(9), "PENDING_PUSH_FAIL");
            put(Integer.valueOf(10), "CANCELED_RECIPIENT_RISK");
            put(Integer.valueOf(11), "CANCELED_SYSTEM_FAIL");
            put(Integer.valueOf(12), "CANCELED_EXPIRED");
            put(Integer.valueOf(13), "COMPLETED");
            put(Integer.valueOf(14), "INTERMEDIATE_PROCESSING");
            put(Integer.valueOf(15), "PENDING_SENDER_INITED");
            put(Integer.valueOf(16), "CANCELED_SAME_CARD");
            put(Integer.valueOf(17), "PENDING_SENDER_VERIFICATION_PROCESSING");
            put(Integer.valueOf(18), "PENDING_RECIPIENT_VERIFICATION_PROCESSING");
        }
    }
}
