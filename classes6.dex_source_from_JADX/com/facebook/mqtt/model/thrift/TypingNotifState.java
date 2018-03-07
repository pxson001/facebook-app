package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: timeline_context_list_item_type */
public class TypingNotifState {
    public static final IntRangeSet f2996a = new IntRangeSet(new int[]{0, 1});
    public static final Map<Integer, String> f2997b = new C01431();

    /* compiled from: timeline_context_list_item_type */
    final class C01431 extends HashMap<Integer, String> {
        C01431() {
            put(Integer.valueOf(0), "IDLE");
            put(Integer.valueOf(1), "TYPING");
        }
    }
}
