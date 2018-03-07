package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: touch_to_focus_count */
public class PaymentLogMessageType {
    public static final IntRangeSet f2790a = new IntRangeSet(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
    public static final Map<Integer, String> f2791b = new C01361();

    /* compiled from: touch_to_focus_count */
    final class C01361 extends HashMap<Integer, String> {
        C01361() {
            put(Integer.valueOf(1), "SENT_IN_GROUP");
            put(Integer.valueOf(2), "CANCELED_SENDER_RISK");
            put(Integer.valueOf(3), "CANCELED_DECLINED");
            put(Integer.valueOf(4), "CANCELED_RECIPIENT_RISK");
            put(Integer.valueOf(5), "CANCELED_EXPIRED");
            put(Integer.valueOf(6), "CANCELED_SAME_CARD");
            put(Integer.valueOf(7), "CANCELED_CUSTOMER_SERVICE");
            put(Integer.valueOf(8), "CANCELED_CHARGEBACK");
            put(Integer.valueOf(9), "CANCELED_SYSTEM_FAIL");
            put(Integer.valueOf(10), "REQUEST_CANCELED_BY_REQUESTER");
            put(Integer.valueOf(11), "REQUEST_DECLINED_BY_REQUESTEE");
            put(Integer.valueOf(12), "REQUEST_EXPIRED");
        }
    }
}
