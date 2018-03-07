package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: titleMaxLines and bodyMaxLines must be non-negative */
public class ImageType {
    public static final IntRangeSet f2892a = new IntRangeSet(new int[]{1, 2});
    public static final Map<Integer, String> f2893b = new C01411();

    /* compiled from: titleMaxLines and bodyMaxLines must be non-negative */
    final class C01411 extends HashMap<Integer, String> {
        C01411() {
            put(Integer.valueOf(1), "FILE_ATTACHMENT");
            put(Integer.valueOf(2), "MESSENGER_CAM");
        }
    }
}
