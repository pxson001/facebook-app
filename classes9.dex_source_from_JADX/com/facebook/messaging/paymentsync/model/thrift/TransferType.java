package com.facebook.messaging.paymentsync.model.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: download_media_caller_context */
public class TransferType {
    public static final IntRangeSet f15990a = new IntRangeSet(new int[]{1, 2, 3});
    public static final Map<Integer, String> f15991b = new C18721();

    /* compiled from: download_media_caller_context */
    final class C18721 extends HashMap<Integer, String> {
        C18721() {
            put(Integer.valueOf(1), "P2P_TRANSFER");
            put(Integer.valueOf(2), "P2P_INCENTIVE");
            put(Integer.valueOf(3), "MESSENGER_COMMERCE");
        }
    }
}
