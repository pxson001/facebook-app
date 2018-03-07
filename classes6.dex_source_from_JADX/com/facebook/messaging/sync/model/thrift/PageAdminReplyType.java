package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: trackingString */
public class PageAdminReplyType {
    public static final IntRangeSet f2781a = new IntRangeSet(new int[]{1, 2, 3});
    public static final Map<Integer, String> f2782b = new C01351();

    /* compiled from: trackingString */
    final class C01351 extends HashMap<Integer, String> {
        C01351() {
            put(Integer.valueOf(1), "ACTIVITY_REPLY");
            put(Integer.valueOf(2), "COMMERCE_LINK");
            put(Integer.valueOf(3), "COMMERCE_UNLINK");
        }
    }
}
