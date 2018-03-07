package com.google.android.gms.common.data;

import java.util.ArrayList;

public final class DataBufferUtils {
    private DataBufferUtils() {
    }

    public static <T, E extends Freezable<T>> ArrayList<T> m12156a(DataBuffer<E> dataBuffer) {
        ArrayList<T> arrayList = new ArrayList(dataBuffer.mo735a());
        try {
            for (E a : dataBuffer) {
                arrayList.add(a.m12172a());
            }
            return arrayList;
        } finally {
            dataBuffer.mo736b();
        }
    }
}
