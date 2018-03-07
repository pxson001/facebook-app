package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

/* compiled from: page_admin_panel */
public class DefaultNativeMemoryChunkPoolParams {
    public static PoolParams m15636a() {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(1024, 5);
        sparseIntArray.put(2048, 5);
        sparseIntArray.put(4096, 5);
        sparseIntArray.put(8192, 5);
        sparseIntArray.put(16384, 5);
        sparseIntArray.put(32768, 5);
        sparseIntArray.put(65536, 5);
        sparseIntArray.put(131072, 5);
        sparseIntArray.put(262144, 2);
        sparseIntArray.put(524288, 2);
        sparseIntArray.put(1048576, 2);
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (min < 16777216) {
            min = 3145728;
        } else if (min < 33554432) {
            min = 6291456;
        } else {
            min = 12582912;
        }
        int i = min;
        min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (min < 16777216) {
            min /= 2;
        } else {
            min = (min / 4) * 3;
        }
        return new PoolParams(i, min, sparseIntArray);
    }
}
