package com.facebook.imageutils;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: last_sync_time */
public class StreamProcessor {
    StreamProcessor() {
    }

    public static int m25072a(InputStream inputStream, int i, boolean z) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            int read = inputStream.read();
            if (read == -1) {
                throw new IOException("no more bytes");
            }
            if (z) {
                i2 |= (read & 255) << (i3 * 8);
            } else {
                i2 = (i2 << 8) | (read & 255);
            }
        }
        return i2;
    }
}
