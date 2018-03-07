package com.facebook.common.internal;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* compiled from: unique_request */
public final class ByteStreams {
    private ByteStreams() {
    }

    public static long m3908a(InputStream inputStream, OutputStream outputStream) {
        Preconditions.a(inputStream);
        Preconditions.a(outputStream);
        byte[] bArr = new byte[4096];
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

    public static int m3907a(InputStream inputStream, byte[] bArr, int i, int i2) {
        Preconditions.a(inputStream);
        Preconditions.a(bArr);
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

    public static byte[] m3909a(InputStream inputStream) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m3908a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] m3910a(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = i;
        while (i2 > 0) {
            int i3 = i - i2;
            int read = inputStream.read(bArr, i3, i2);
            if (read == -1) {
                return Arrays.copyOf(bArr, i3);
            }
            i2 -= read;
        }
        i2 = inputStream.read();
        if (i2 == -1) {
            return bArr;
        }
        OutputStream fastByteArrayOutputStream = new FastByteArrayOutputStream();
        fastByteArrayOutputStream.write(i2);
        m3908a(inputStream, fastByteArrayOutputStream);
        Object obj = new byte[(fastByteArrayOutputStream.size() + i)];
        System.arraycopy(bArr, 0, obj, 0, i);
        fastByteArrayOutputStream.a(obj, i);
        return obj;
    }

    public static void m3911b(InputStream inputStream, byte[] bArr, int i, int i2) {
        int a = m3907a(inputStream, bArr, i, i2);
        if (a != i2) {
            throw new EOFException("reached end of stream after reading " + a + " bytes; " + i2 + " bytes expected");
        }
    }
}
