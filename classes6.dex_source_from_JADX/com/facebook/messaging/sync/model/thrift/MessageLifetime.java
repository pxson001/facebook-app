package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: transaction_id */
public class MessageLifetime {
    public static final IntRangeSet f2764a = new IntRangeSet(new int[]{0, 1, 30000, 60000, 180000, 300000, 600000, 900000, 1800000, 3600000, 7200000, 14400000, 28800000, 43200000, 86400000});
    public static final Map<Integer, String> f2765b = new C01341();

    /* compiled from: transaction_id */
    final class C01341 extends HashMap<Integer, String> {
        C01341() {
            put(Integer.valueOf(0), "TTL_OFF");
            put(Integer.valueOf(1), "TTL_ON_UNKNOWN");
            put(Integer.valueOf(30000), "TTL_30SECONDS");
            put(Integer.valueOf(60000), "TTL_1MINUTE");
            put(Integer.valueOf(180000), "TTL_3MINUTES");
            put(Integer.valueOf(300000), "TTL_5MINUTES");
            put(Integer.valueOf(600000), "TTL_10MINUTES");
            put(Integer.valueOf(900000), "TTL_15MINUTES");
            put(Integer.valueOf(1800000), "TTL_30MINUTES");
            put(Integer.valueOf(3600000), "TTL_1HOUR");
            put(Integer.valueOf(7200000), "TTL_2HOURS");
            put(Integer.valueOf(14400000), "TTL_4HOURS");
            put(Integer.valueOf(28800000), "TTL_8HOURS");
            put(Integer.valueOf(43200000), "TTL_12HOURS");
            put(Integer.valueOf(86400000), "TTL_24HOURS");
        }
    }
}
