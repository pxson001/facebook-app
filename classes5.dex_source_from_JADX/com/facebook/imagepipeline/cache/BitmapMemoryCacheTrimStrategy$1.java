package com.facebook.imagepipeline.cache;

import com.facebook.common.memory.MemoryTrimType;

/* compiled from: TRANSPOSE */
/* synthetic */ class BitmapMemoryCacheTrimStrategy$1 {
    static final /* synthetic */ int[] f13678a = new int[MemoryTrimType.values().length];

    static {
        try {
            f13678a[MemoryTrimType.OnCloseToDalvikHeapLimit.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f13678a[MemoryTrimType.OnAppBackgrounded.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f13678a[MemoryTrimType.OnSystemLowMemoryWhileAppInForeground.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f13678a[MemoryTrimType.OnSystemLowMemoryWhileAppInBackground.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
