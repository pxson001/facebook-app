package com.facebook.messaging.paymentsync.model.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: drag */
public class PaymentRequestStatus {
    public static final IntRangeSet f15972a = new IntRangeSet(new int[]{1, 2, 3, 4, 5, 6});
    public static final Map<Integer, String> f15973b = new C18671();

    /* compiled from: drag */
    final class C18671 extends HashMap<Integer, String> {
        C18671() {
            put(Integer.valueOf(1), "INITED");
            put(Integer.valueOf(2), "DECLINED");
            put(Integer.valueOf(3), "TRANSFER_INITED");
            put(Integer.valueOf(4), "TRANSFER_COMPLETED");
            put(Integer.valueOf(5), "TRANSFER_FAILED");
            put(Integer.valueOf(6), "CANCELED");
        }
    }
}
