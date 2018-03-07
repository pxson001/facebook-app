package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Supplier;

/* compiled from: orca_video_segmented_trans_upload */
public class DefaultEncodedMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {
    public final Object mo2058a() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (min < 16777216) {
            min = 1048576;
        } else if (min < 33554432) {
            min = 2097152;
        } else {
            min = 4194304;
        }
        int i = min;
        return new MemoryCacheParams(i, Integer.MAX_VALUE, i, Integer.MAX_VALUE, i / 8);
    }
}
