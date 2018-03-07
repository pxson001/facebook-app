package com.facebook.messaging.paymentsync.model.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: download_uri */
public class ProductAvailability {
    public static final IntRangeSet f15984a = new IntRangeSet(new int[]{1, 2, 3, 4, 5});
    public static final Map<Integer, String> f15985b = new C18691();

    /* compiled from: download_uri */
    final class C18691 extends HashMap<Integer, String> {
        C18691() {
            put(Integer.valueOf(1), "IN_STOCK");
            put(Integer.valueOf(2), "OUT_OF_STOCK");
            put(Integer.valueOf(3), "PREORDER");
            put(Integer.valueOf(4), "AVAILABLE_FOR_ORDER");
            put(Integer.valueOf(5), "DISCONTINUED");
        }
    }
}
