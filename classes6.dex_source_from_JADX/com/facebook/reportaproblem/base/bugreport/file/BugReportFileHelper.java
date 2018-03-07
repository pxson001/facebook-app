package com.facebook.reportaproblem.base.bugreport.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: sharePreview */
public class BugReportFileHelper {
    public static void m7048a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.exists()) {
                    file2.delete();
                }
            }
        }
        file.delete();
    }

    public static void m7049a(File file, File file2) {
        FileOutputStream fileOutputStream;
        Throwable th;
        FileInputStream fileInputStream = null;
        try {
            InputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    m7050a(fileInputStream2, (OutputStream) fileOutputStream);
                    try {
                        fileOutputStream.close();
                        fileInputStream2.close();
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public static void m7050a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
