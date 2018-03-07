package com.facebook.qe.store;

import com.facebook.androidcompat.AndroidCompat;
import com.facebook.common.iolite.Closeables;
import com.facebook.common.preconditions.Preconditions;
import com.facebook.debug.log.BLog;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: unknown_experiment_group */
public class StoreFs {
    private static final Class<StoreFs> f1943a = StoreFs.class;
    private final File f1944b;
    private boolean f1945c;

    public StoreFs(File file, boolean z) {
        Preconditions.m2017b(file.isAbsolute());
        boolean z2 = !file.exists() || file.isAbsolute();
        Preconditions.m2017b(z2);
        this.f1944b = file;
        this.f1945c = z;
    }

    public final void m3873a(String str, String str2) {
        Preconditions.m2016a(!this.f1945c);
        m3862c(m3867g(str, str2));
    }

    @Nullable
    public final String m3872a(String str) {
        File c = m3861c(str);
        if (!c.exists()) {
            return null;
        }
        try {
            Closeable dataInputStream = new DataInputStream(new FileInputStream(c));
            try {
                String readUTF = dataInputStream.readUTF();
                Closeables.m2789a(dataInputStream, false);
                if (readUTF == null || !m3858a(m3867g(str, readUTF))) {
                    return null;
                }
                return readUTF;
            } catch (Throwable th) {
                Closeables.m2789a(dataInputStream, true);
            }
        } catch (IOException e) {
            return null;
        }
    }

    private static boolean m3858a(File file) {
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(file, "index.bin");
        File file3 = new File(file, "data.bin");
        if (m3865e(file2) && m3865e(file3)) {
            return true;
        }
        return false;
    }

    public final ByteBuffer m3876b(String str, String str2) {
        return m3860b(m3868h(str, str2));
    }

    public final ByteBuffer m3878c(String str, String str2) {
        return m3860b(m3870j(str, str2));
    }

    public final void m3879d(String str, String str2) {
        boolean z = true;
        z = false;
        Preconditions.m2016a(!this.f1945c);
        File d = m3863d(str);
        OutputStream fileOutputStream = new FileOutputStream(d);
        Closeable dataOutputStream = new DataOutputStream(fileOutputStream);
        try {
            dataOutputStream.writeUTF(str2);
            fileOutputStream.getFD().sync();
        } finally {
            Closeables.m2789a(dataOutputStream, z);
        }
        d.renameTo(m3861c(str));
    }

    public final void m3874a(String str, String str2, byte[] bArr) {
        Preconditions.m2016a(!this.f1945c);
        m3857a(str, str2, bArr, "data.bin.tmp", "data.bin");
    }

    public final void m3877b(String str, String str2, byte[] bArr) {
        Preconditions.m2016a(!this.f1945c);
        m3857a(str, str2, bArr, "index.bin.tmp", "index.bin");
    }

    private void m3857a(String str, String str2, byte[] bArr, String str3, String str4) {
        File g = m3867g(str, str2);
        File file = new File(g, str3);
        Closeable fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.getFD().sync();
            file.renameTo(new File(g, str4));
        } finally {
            file = true;
            Closeables.m2789a(fileOutputStream, true);
        }
    }

    private static ByteBuffer m3860b(File file) {
        Throwable th;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            Throwable th2 = null;
            try {
                long length = randomAccessFile.length();
                if (length > 2147483647L) {
                    throw new StoreIntegrityException("impossibly long QE file");
                }
                int i = (int) length;
                byte[] bArr = new byte[i];
                int i2 = 0;
                while (i2 < i) {
                    int read = randomAccessFile.read(bArr, i2, i - i2);
                    if (read < 0) {
                        throw new StoreIntegrityException("unexpected short read of " + file);
                    }
                    i2 += read;
                }
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                randomAccessFile.close();
                return wrap;
            } catch (Throwable th22) {
                Throwable th3 = th22;
                th22 = th;
                th = th3;
            }
            if (th22 != null) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                randomAccessFile.close();
            }
            throw th;
            throw th;
        } catch (Throwable th5) {
            throw new StoreIntegrityException("error reading QE store " + file, th5);
        }
    }

    private static void m3862c(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new StoreIntegrityException(file + " exists but is not a directory!");
            }
        } else if (!file.mkdirs() && !file.exists()) {
            throw new IOException("Could not create dir " + file);
        }
    }

    public final void m3880e(String str, String str2) {
        int i = 0;
        Preconditions.m2016a(!this.f1945c);
        File[] listFiles = m3859b(str).listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            while (i < length) {
                File file = listFiles[i];
                if (file.isDirectory()) {
                    String name = file.getName();
                    if (!name.equals(str2)) {
                        m3866f(str, name);
                    }
                }
                i++;
            }
        }
    }

    public final void m3875a(Set<String> set) {
        Preconditions.m2016a(!this.f1945c);
        File[] listFiles = this.f1944b.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    String name = file.getName();
                    if (!set.contains(name)) {
                        File[] listFiles2 = file.listFiles();
                        if (listFiles2 != null) {
                            for (File file2 : listFiles2) {
                                if (file2.isDirectory()) {
                                    m3866f(name, file2.getName());
                                }
                            }
                        }
                        m3864d(m3861c(name));
                        m3864d(m3863d(name));
                        m3864d(file);
                    }
                }
            }
        }
    }

    private void m3866f(String str, String str2) {
        m3864d(m3870j(str, str2));
        m3864d(m3871k(str, str2));
        m3864d(m3868h(str, str2));
        m3864d(m3869i(str, str2));
        m3864d(m3867g(str, str2));
    }

    private static void m3864d(File file) {
        if (file.exists() && !file.delete()) {
            BLog.b(f1943a, "Failed to unlink %s", new Object[]{file});
        }
    }

    private static boolean m3865e(File file) {
        return file.exists() && file.length() > 0;
    }

    private File m3859b(String str) {
        return new File(this.f1944b, str);
    }

    private File m3861c(String str) {
        return new File(m3859b(str), "current.bin");
    }

    private File m3863d(String str) {
        return new File(m3859b(str), "current.bin.tmp");
    }

    private File m3867g(String str, String str2) {
        return new File(m3859b(str), str2);
    }

    private File m3868h(String str, String str2) {
        return new File(m3867g(str, str2), "data.bin");
    }

    private File m3869i(String str, String str2) {
        return new File(m3867g(str, str2), "data.bin.tmp");
    }

    private File m3870j(String str, String str2) {
        return new File(m3867g(str, str2), "index.bin");
    }

    private File m3871k(String str, String str2) {
        return new File(m3867g(str, str2), "index.bin.tmp");
    }
}
