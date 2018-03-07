package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: click_payment_row */
public class ActionResult {
    public static final IntRangeSet f18095a = new IntRangeSet(new int[]{1, 2});
    public static final Map<Integer, String> f18096b = new C21141();

    /* compiled from: click_payment_row */
    final class C21141 extends HashMap<Integer, String> {
        C21141() {
            put(Integer.valueOf(1), "FAILURE");
            put(Integer.valueOf(2), "SUCCESS");
        }
    }
}
