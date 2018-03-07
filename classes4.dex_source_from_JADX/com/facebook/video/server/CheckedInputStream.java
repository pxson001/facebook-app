package com.facebook.video.server;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: pacing_mode */
public class CheckedInputStream extends FilterInputStream {
    public CheckedInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public int read() {
        try {
            return super.read();
        } catch (IOException e) {
            throw m5990a(e);
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            return super.read(bArr, i, i2);
        } catch (IOException e) {
            throw m5990a(e);
        }
    }

    private static IOException m5990a(IOException iOException) {
        return new NetworkAccessException("Error reading from network", iOException);
    }
}
