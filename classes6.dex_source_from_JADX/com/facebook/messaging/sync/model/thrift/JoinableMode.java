package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: transaction_payment */
public class JoinableMode {
    public static final IntRangeSet f2762a = new IntRangeSet(new int[]{0, 1});
    public static final Map<Integer, String> f2763b = new C01331();

    /* compiled from: transaction_payment */
    final class C01331 extends HashMap<Integer, String> {
        C01331() {
            put(Integer.valueOf(0), "PRIVATE");
            put(Integer.valueOf(1), "JOINABLE");
        }
    }
}
