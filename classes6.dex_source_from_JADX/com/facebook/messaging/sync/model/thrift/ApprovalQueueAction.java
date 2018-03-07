package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: uninvitable_friends */
public class ApprovalQueueAction {
    public static final IntRangeSet f2456a = new IntRangeSet(new int[]{0, 1});
    public static final Map<Integer, String> f2457b = new C01301();

    /* compiled from: uninvitable_friends */
    final class C01301 extends HashMap<Integer, String> {
        C01301() {
            put(Integer.valueOf(0), "REQUESTED");
            put(Integer.valueOf(1), "REMOVED");
        }
    }
}
