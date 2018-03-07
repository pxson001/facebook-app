package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

/* compiled from: page_admin_panel_profile_tap */
public class DefaultFlexByteArrayPoolParams {
    public static final int f10496a = Runtime.getRuntime().availableProcessors();

    private DefaultFlexByteArrayPoolParams() {
    }

    public static SparseIntArray m15633a(int i, int i2, int i3) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        while (i <= i2) {
            sparseIntArray.put(i, i3);
            i *= 2;
        }
        return sparseIntArray;
    }

    public static PoolParams m15634a() {
        return new PoolParams(4194304, f10496a * 4194304, m15633a(131072, 4194304, f10496a), 131072, 4194304, f10496a);
    }
}
