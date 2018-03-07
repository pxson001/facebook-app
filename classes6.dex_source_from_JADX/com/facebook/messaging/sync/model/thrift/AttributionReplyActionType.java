package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: undoable */
public class AttributionReplyActionType {
    public static final IntRangeSet f2483a = new IntRangeSet(new int[]{1, 2, 3, 4});
    public static final Map<Integer, String> f2484b = new C01311();

    /* compiled from: undoable */
    final class C01311 extends HashMap<Integer, String> {
        C01311() {
            put(Integer.valueOf(1), "DEFAULT_REPLY");
            put(Integer.valueOf(2), "OPEN");
            put(Integer.valueOf(3), "PLAY");
            put(Integer.valueOf(4), "CUSTOM");
        }
    }
}
