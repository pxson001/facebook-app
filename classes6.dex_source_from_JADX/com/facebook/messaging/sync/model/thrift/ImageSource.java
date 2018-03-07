package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: transaction_products */
public class ImageSource {
    public static final IntRangeSet f2760a = new IntRangeSet(new int[]{1, 2, 3});
    public static final Map<Integer, String> f2761b = new C01321();

    /* compiled from: transaction_products */
    final class C01321 extends HashMap<Integer, String> {
        C01321() {
            put(Integer.valueOf(1), "FILE");
            put(Integer.valueOf(2), "QUICKCAM_FRONT");
            put(Integer.valueOf(3), "QUICKCAM_BACK");
        }
    }
}
