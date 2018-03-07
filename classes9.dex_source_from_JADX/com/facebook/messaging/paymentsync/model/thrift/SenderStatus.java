package com.facebook.messaging.paymentsync.model.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: download_size */
public class SenderStatus {
    public static final IntRangeSet f15988a = new IntRangeSet(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
    public static final Map<Integer, String> f15989b = new C18711();

    /* compiled from: download_size */
    final class C18711 extends HashMap<Integer, String> {
        C18711() {
            put(Integer.valueOf(1), "S_PENDING");
            put(Integer.valueOf(2), "S_PENDING_VERIFICATION");
            put(Integer.valueOf(3), "S_PENDING_VERIFICATION_PROCESSING");
            put(Integer.valueOf(4), "S_PENDING_MANUAL_REVIEW");
            put(Integer.valueOf(5), "S_CANCELED");
            put(Integer.valueOf(6), "S_CANCELED_SENDER_RISK");
            put(Integer.valueOf(7), "S_CANCELED_RECIPIENT_RISK");
            put(Integer.valueOf(8), "S_CANCELED_DECLINED");
            put(Integer.valueOf(9), "S_CANCELED_EXPIRED");
            put(Integer.valueOf(10), "S_CANCELED_SAME_CARD");
            put(Integer.valueOf(11), "S_CANCELED_CUSTOMER_SERVICE");
            put(Integer.valueOf(12), "S_CANCELED_CHARGEBACK");
            put(Integer.valueOf(13), "S_CANCELED_SYSTEM_FAIL");
            put(Integer.valueOf(14), "S_COMPLETED");
            put(Integer.valueOf(15), "S_SENT");
        }
    }
}
