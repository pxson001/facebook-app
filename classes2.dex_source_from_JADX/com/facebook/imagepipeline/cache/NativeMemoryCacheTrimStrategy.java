package com.facebook.imagepipeline.cache;

import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.imagepipeline.cache.CountingMemoryCache.CacheTrimStrategy;
import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: options */
public class NativeMemoryCacheTrimStrategy implements CacheTrimStrategy {
    public final double mo2069a(MemoryTrimType memoryTrimType) {
        switch (1.a[memoryTrimType.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return 0.0d;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return 1.0d;
            default:
                FLog.b("NativeMemoryCacheTrimStrategy", "unknown trim type: %s", new Object[]{memoryTrimType});
                return 0.0d;
        }
    }
}
