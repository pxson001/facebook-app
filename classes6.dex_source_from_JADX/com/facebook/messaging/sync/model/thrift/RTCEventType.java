package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: total_sticker_count */
public class RTCEventType {
    public static final IntRangeSet f2792a = new IntRangeSet(new int[]{1, 2});
    public static final Map<Integer, String> f2793b = new C01371();

    /* compiled from: total_sticker_count */
    final class C01371 extends HashMap<Integer, String> {
        C01371() {
            put(Integer.valueOf(1), "VOICE_EVENT");
            put(Integer.valueOf(2), "VIDEO_EVENT");
        }
    }
}
