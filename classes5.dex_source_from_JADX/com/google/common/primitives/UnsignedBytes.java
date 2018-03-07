package com.google.common.primitives;

import javax.annotation.CheckReturnValue;

/* compiled from: bug_network_type */
public final class UnsignedBytes {
    private UnsignedBytes() {
    }

    @CheckReturnValue
    public static int m13821a(byte b) {
        return b & 255;
    }
}
