package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;

@Beta
/* compiled from: foreground_location_cached_location_at_start */
public final class ByteStreams {
    static final byte[] f11466a = new byte[8192];
    private static final OutputStream f11467b = new C05591();

    /* compiled from: foreground_location_cached_location_at_start */
    final class C05591 extends OutputStream {
        C05591() {
        }

        public final void write(int i) {
        }

        public final void write(byte[] bArr) {
            Preconditions.checkNotNull(bArr);
        }

        public final void write(byte[] bArr, int i, int i2) {
            Preconditions.checkNotNull(bArr);
        }

        public final String toString() {
            return "ByteStreams.nullOutputStream()";
        }
    }

    private ByteStreams() {
    }

    public static long m11949a(InputStream inputStream, OutputStream outputStream) {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(outputStream);
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    public static byte[] m11954a(InputStream inputStream) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m11949a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static OutputStream m11951a() {
        return f11467b;
    }

    public static InputStream m11950a(InputStream inputStream, long j) {
        return new LimitedInputStream(inputStream, j);
    }

    public static void m11953a(InputStream inputStream, byte[] bArr) {
        m11956b(inputStream, bArr, 0, bArr.length);
    }

    private static void m11956b(InputStream inputStream, byte[] bArr, int i, int i2) {
        int a = m11948a(inputStream, bArr, i, i2);
        if (a != i2) {
            throw new EOFException("reached end of stream after reading " + a + " bytes; " + i2 + " bytes expected");
        }
    }

    public static void m11955b(InputStream inputStream, long j) {
        long c = m11957c(inputStream, j);
        if (c < j) {
            throw new EOFException("reached end of stream after skipping " + c + " bytes; " + j + " bytes expected");
        }
    }

    static long m11957c(InputStream inputStream, long j) {
        long j2 = 0;
        while (j2 < j) {
            long j3;
            long j4 = j - j2;
            int available = inputStream.available();
            if (available == 0) {
                j3 = 0;
            } else {
                j3 = inputStream.skip(Math.min((long) available, j4));
            }
            long j5 = j3;
            if (j5 == 0) {
                j5 = (long) inputStream.read(f11466a, 0, (int) Math.min(j4, (long) f11466a.length));
                if (j5 == -1) {
                    break;
                }
            }
            j2 = j5 + j2;
        }
        return j2;
    }

    public static <T> T m11952a(InputStream inputStream, ByteProcessor<T> byteProcessor) {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(byteProcessor);
        byte[] bArr = new byte[8192];
        do {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            int i = 0;
            while (byteProcessor.d && i < read) {
                byteProcessor.d = bArr[i] == (byte) 0;
                i++;
            }
            byteProcessor.e += (long) read;
            byteProcessor.a.update(bArr, 0, read);
        } while (1 != 0);
        return byteProcessor.a();
    }

    public static int m11948a(InputStream inputStream, byte[] bArr, int i, int i2) {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(bArr);
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("len is negative");
        }
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i + i3, i2 - i3);
            if (read == -1) {
                break;
            }
            i3 += read;
        }
        return i3;
    }
}
