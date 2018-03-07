package com.facebook.stetho.common;

import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: serialized */
public class Util {
    public static void m7712a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
