package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: timestampSecs */
public class PresenceState {
    public static final IntRangeSet f2929a = new IntRangeSet(new int[]{0, 1});
    public static final Map<Integer, String> f2930b = new C01421();

    /* compiled from: timestampSecs */
    final class C01421 extends HashMap<Integer, String> {
        C01421() {
            put(Integer.valueOf(0), "INACTIVE");
            put(Integer.valueOf(1), "ACTIVE");
        }
    }
}
