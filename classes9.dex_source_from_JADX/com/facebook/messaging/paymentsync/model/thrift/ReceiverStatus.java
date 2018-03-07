package com.facebook.messaging.paymentsync.model.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: download_size_bytes */
public class ReceiverStatus {
    public static final IntRangeSet f15986a = new IntRangeSet(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18});
    public static final Map<Integer, String> f15987b = new C18701();

    /* compiled from: download_size_bytes */
    final class C18701 extends HashMap<Integer, String> {
        C18701() {
            put(Integer.valueOf(1), "R_PENDING");
            put(Integer.valueOf(2), "R_PENDING_VERIFICATION");
            put(Integer.valueOf(3), "R_PENDING_VERIFICATION_PROCESSING");
            put(Integer.valueOf(4), "R_PENDING_MANUAL_REVIEW");
            put(Integer.valueOf(5), "R_CANCELED");
            put(Integer.valueOf(6), "R_CANCELED_SENDER_RISK");
            put(Integer.valueOf(7), "R_CANCELED_RECIPIENT_RISK");
            put(Integer.valueOf(8), "R_CANCELED_DECLINED");
            put(Integer.valueOf(9), "R_CANCELED_EXPIRED");
            put(Integer.valueOf(10), "R_CANCELED_SAME_CARD");
            put(Integer.valueOf(11), "R_CANCELED_CUSTOMER_SERVICE");
            put(Integer.valueOf(12), "R_CANCELED_CHARGEBACK");
            put(Integer.valueOf(13), "R_CANCELED_SYSTEM_FAIL");
            put(Integer.valueOf(14), "R_COMPLETED");
            put(Integer.valueOf(15), "R_PENDING_NUX");
            put(Integer.valueOf(16), "R_PENDING_PROCESSING");
            put(Integer.valueOf(17), "R_PENDING_PUSH_FAIL");
            put(Integer.valueOf(18), "R_PENDING_PUSH_FAIL_CARD_EXPIRED");
        }
    }
}
