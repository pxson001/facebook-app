package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.IntRangeSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: total_assets_processed */
public class ThreadFolder {
    public static final IntRangeSet f2809a = new IntRangeSet(new int[]{0, 1, 2, 3, 4, 5, 6});
    public static final Map<Integer, String> f2810b = new C01391();

    /* compiled from: total_assets_processed */
    final class C01391 extends HashMap<Integer, String> {
        C01391() {
            put(Integer.valueOf(0), "FOLDER_INVALID");
            put(Integer.valueOf(1), "FOLDER_INBOX");
            put(Integer.valueOf(2), "FOLDER_OTHER");
            put(Integer.valueOf(3), "FOLDER_SPAM");
            put(Integer.valueOf(4), "FOLDER_PENDING");
            put(Integer.valueOf(5), "FOLDER_MONTAGE");
            put(Integer.valueOf(6), "FOLDER_HIDDEN");
        }
    }
}
