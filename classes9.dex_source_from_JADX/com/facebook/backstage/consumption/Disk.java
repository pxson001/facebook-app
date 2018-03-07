package com.facebook.backstage.consumption;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: sale */
public class Disk {
    private static final String f4597a = Disk.class.getSimpleName();

    public static void m4528a(byte[] bArr, File file) {
        Throwable e;
        if (file.exists()) {
            file.delete();
        }
        BufferedOutputStream bufferedOutputStream;
        try {
            OutputStream fileOutputStream = new FileOutputStream(file.getPath());
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            try {
                bufferedOutputStream.write(bArr);
                bufferedOutputStream.flush();
                fileOutputStream.getFD().sync();
                try {
                    bufferedOutputStream.close();
                } catch (IOException e2) {
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    throw new RuntimeException("Error saving file", e);
                } catch (Throwable th) {
                    e = th;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw e;
                }
            }
        } catch (IOException e5) {
            e = e5;
            bufferedOutputStream = null;
            throw new RuntimeException("Error saving file", e);
        } catch (Throwable th2) {
            e = th2;
            bufferedOutputStream = null;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw e;
        }
    }
}
