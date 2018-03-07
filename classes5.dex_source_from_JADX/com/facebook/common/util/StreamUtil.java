package com.facebook.common.util;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: settings_token */
public class StreamUtil {

    /* compiled from: settings_token */
    public final class C01981 extends ByteArrayOutputStream {
        public C01981(int i) {
            super(i);
        }

        public final byte[] toByteArray() {
            if (this.count == this.buf.length) {
                return this.buf;
            }
            return super.toByteArray();
        }
    }

    public static byte[] m3917a(InputStream inputStream) {
        OutputStream c01981 = new C01981(inputStream.available());
        ByteStreams.a(inputStream, c01981);
        return c01981.toByteArray();
    }

    public static long m3916a(InputStream inputStream, long j) {
        Preconditions.a(inputStream);
        Preconditions.a(j >= 0);
        long j2 = j;
        while (j2 > 0) {
            long skip = inputStream.skip(j2);
            if (skip > 0) {
                j2 -= skip;
            } else if (inputStream.read() == -1) {
                return j - j2;
            } else {
                j2--;
            }
        }
        return j;
    }
}
