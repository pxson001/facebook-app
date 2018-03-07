package com.facebook.crudolib.processname;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.annotation.Nullable;

/* compiled from: vault */
public class ProcessNameHelper {
    private static volatile boolean f1306a;
    @Nullable
    private static volatile String f1307b;

    @Nullable
    public static String m2551a() {
        if (!f1306a) {
            String b;
            try {
                b = m2552b();
            } catch (IOException e) {
                b = null;
            }
            f1307b = b;
            f1306a = true;
        }
        return f1307b;
    }

    private static String m2552b() {
        FileInputStream fileInputStream = new FileInputStream(new File("/proc/self/cmdline"));
        byte[] bArr = new byte[512];
        try {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                throw new EOFException();
            }
            String trim = new String(bArr, 0, read).trim();
            return trim;
        } finally {
            fileInputStream.close();
        }
    }
}
