package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: totalViewTypeCount */
public class VideoSource {
    public static final IntRangeSet f2824a = new IntRangeSet(new int[]{1, 2});
    public static final Map<Integer, String> f2825b = new C01401();

    /* compiled from: totalViewTypeCount */
    final class C01401 extends HashMap<Integer, String> {
        C01401() {
            put(Integer.valueOf(1), "NON_QUICKCAM");
            put(Integer.valueOf(2), "QUICKCAM");
        }
    }
}
