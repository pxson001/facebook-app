package com.facebook.common.util;

import android.util.SparseArray;

/* compiled from: fetch_payment_transaction */
public final class SparseArrayUtil {
    private SparseArrayUtil() {
    }

    public static int[] m32359a(SparseArray sparseArray) {
        int size = sparseArray.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = sparseArray.keyAt(i);
        }
        return iArr;
    }
}
