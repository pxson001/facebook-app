package com.facebook.common.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* compiled from: source_activity */
public class Files {
    private Files() {
    }

    private static byte[] m3748a(InputStream inputStream, long j) {
        if (j <= 2147483647L) {
            return j == 0 ? ByteStreams.a(inputStream) : ByteStreams.a(inputStream, (int) j);
        } else {
            throw new OutOfMemoryError("file is too large to fit in a byte array: " + j + " bytes");
        }
    }

    public static byte[] m3747a(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] a = m3748a(fileInputStream, fileInputStream.getChannel().size());
                fileInputStream.close();
                return a;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }
}
