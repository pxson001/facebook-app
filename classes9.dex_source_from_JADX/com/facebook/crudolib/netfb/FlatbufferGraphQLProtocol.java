package com.facebook.crudolib.netfb;

import com.facebook.debug.log.BLog;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* compiled from: TimelineCoverPhotoUriQuery */
public final class FlatbufferGraphQLProtocol {

    /* compiled from: TimelineCoverPhotoUriQuery */
    class AmbiguousResponseException extends IOException {
        public AmbiguousResponseException(String str) {
            super(str);
        }
    }

    public static ByteBuffer m26051a(InputStream inputStream) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        try {
            int a = m26050a(dataInputStream);
            int a2 = m26050a(dataInputStream);
            a = (a - a2) - 4;
            if (a == 0) {
                String str = new String(m26054a(dataInputStream, a2), "UTF-8");
                FbApiErrorParser.m26034a(str);
                throw new AmbiguousResponseException("Expected error reply, got: " + str);
            }
            if (a2 > 0) {
                Integer.valueOf(a2);
                m26052a((InputStream) dataInputStream, (long) a2);
            }
            byte[] a3 = m26054a(dataInputStream, a);
            if (dataInputStream.read() != -1) {
                BLog.a("FlatbufferGraphQLProtocol", "Ignoring junk after flatbuffer data");
            }
            ByteBuffer wrap = ByteBuffer.wrap(a3);
            return wrap;
        } finally {
            dataInputStream.close();
        }
    }

    private static byte[] m26054a(DataInputStream dataInputStream, int i) {
        if (i < 0) {
            throw new EOFException("size=" + i);
        } else if (i > 262144) {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            m26053a(dataInputStream, byteArrayOutputStream, i, new byte[2048]);
            return byteArrayOutputStream.toByteArray();
        } else {
            byte[] bArr = new byte[i];
            dataInputStream.readFully(bArr);
            return bArr;
        }
    }

    private static void m26052a(InputStream inputStream, long j) {
        long skip = inputStream.skip(j);
        if (skip != j) {
            throw new EOFException("Expected " + j + " bytes; got " + skip);
        }
    }

    private static void m26053a(InputStream inputStream, OutputStream outputStream, int i, byte[] bArr) {
        int i2 = i;
        while (i2 > 0) {
            int read = inputStream.read(bArr, 0, Math.min(bArr.length, i2));
            if (read < 0) {
                throw new EOFException("Expected " + i + " bytes, got " + (i - i2));
            }
            outputStream.write(bArr, 0, read);
            i2 -= read;
        }
    }

    private static int m26050a(DataInputStream dataInputStream) {
        return (((dataInputStream.readByte() & 255) | ((dataInputStream.readByte() & 255) << 8)) | ((dataInputStream.readByte() & 255) << 16)) | ((dataInputStream.readByte() & 255) << 24);
    }
}
