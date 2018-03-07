package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: uniqueId */
public class ApprovalMode {
    public static final IntRangeSet f2454a = new IntRangeSet(new int[]{0, 1});
    public static final Map<Integer, String> f2455b = new C01291();

    /* compiled from: uniqueId */
    final class C01291 extends HashMap<Integer, String> {
        C01291() {
            put(Integer.valueOf(0), "OPEN");
            put(Integer.valueOf(1), "APPROVALS");
        }
    }
}
