package com.facebook.messaging.tincan.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: circleCrop */
public class SalamanderType {
    public static final IntRangeSet f18214a = new IntRangeSet(new int[]{1, 2, 3, 4, 5, 6});
    public static final Map<Integer, String> f18215b = new C21161();

    /* compiled from: circleCrop */
    final class C21161 extends HashMap<Integer, String> {
        C21161() {
            put(Integer.valueOf(1), "LINK_ACCEPTED");
            put(Integer.valueOf(2), "LINK_DELETED");
            put(Integer.valueOf(3), "PLAIN_TEXT");
            put(Integer.valueOf(4), "ATTACHMENT_INFO_LIST");
            put(Integer.valueOf(5), "DEVICE_LOCAL_TEXT");
            put(Integer.valueOf(6), "STICKER_INFO");
        }
    }
}
