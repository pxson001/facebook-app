package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: fetcher */
public class PublishFormat {
    public static final IntRangeSet f23790a = new IntRangeSet(0, 1, 2);
    public static final Map<Integer, String> f23791b = new C09721();

    /* compiled from: fetcher */
    final class C09721 extends HashMap<Integer, String> {
        C09721() {
            put(Integer.valueOf(0), "RAW");
            put(Integer.valueOf(1), "ZLIB");
            put(Integer.valueOf(2), "ZLIB_OPTIONAL");
        }
    }
}
