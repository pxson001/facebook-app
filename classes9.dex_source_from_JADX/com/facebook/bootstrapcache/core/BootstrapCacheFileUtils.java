package com.facebook.bootstrapcache.core;

import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

/* compiled from: receipt_after_cursor */
public class BootstrapCacheFileUtils {
    private static final String f5750a = BootstrapCacheFileUtils.class.getName();
    private static final byte[] f5751b = new byte[32768];

    /* compiled from: receipt_after_cursor */
    final class C06071 implements Runnable {
        final /* synthetic */ File f5749a;

        C06071(File file) {
            this.f5749a = file;
        }

        public final void run() {
            BootstrapCacheFileUtils.m5975b(this.f5749a);
        }
    }

    public static void m5972a(File file, File file2) {
        Throwable th;
        OutputStream outputStream = null;
        try {
            OutputStream fileOutputStream = new FileOutputStream(new File(file2, file.getName()));
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                while (true) {
                    try {
                        int read = fileInputStream.read(f5751b);
                        if (read > 0) {
                            fileOutputStream.write(f5751b, 0, read);
                        } else {
                            fileInputStream.close();
                            fileOutputStream.close();
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th4) {
                        th = th4;
                        outputStream = fileOutputStream;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            if (outputStream != null) {
                outputStream.close();
            }
            throw th;
        }
    }

    public static void m5974a(ExecutorService executorService, File file, File file2) {
        if (file != null && file.isDirectory()) {
            File file3 = new File(file2, file.getName());
            if (!file3.exists()) {
                file3.mkdirs();
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file4 : listFiles) {
                    File file5 = new File(file3, file4.getName());
                    m5973a(executorService, file5);
                    file4.renameTo(file5);
                }
                m5973a(executorService, file);
            }
        }
    }

    public static void m5973a(ExecutorService executorService, File file) {
        if (file != null && file.exists()) {
            File file2 = new File(file.getParentFile(), file.getName() + ".delete" + System.nanoTime());
            file.renameTo(file2);
            ExecutorDetour.a(executorService, new C06071(file2), 1311952664);
        }
    }

    public static void m5975b(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File b : listFiles) {
                m5975b(b);
            }
        }
        file.delete();
    }
}
