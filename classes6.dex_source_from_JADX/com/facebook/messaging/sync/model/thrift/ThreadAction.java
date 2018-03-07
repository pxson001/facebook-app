package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: total_content_bytes */
public class ThreadAction {
    public static final IntRangeSet f2807a = new IntRangeSet(new int[]{0, 1, 2});
    public static final Map<Integer, String> f2808b = new C01381();

    /* compiled from: total_content_bytes */
    final class C01381 extends HashMap<Integer, String> {
        C01381() {
            put(Integer.valueOf(0), "ACTION_INVALID");
            put(Integer.valueOf(1), "ACTION_ARCHIVED");
            put(Integer.valueOf(2), "ACTION_UNARCHIVED");
        }
    }
}
