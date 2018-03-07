package com.facebook.common.tempfile;

import com.facebook.common.time.SystemClock;
import com.facebook.debug.log.BLog;
import com.google.common.base.Preconditions;
import java.io.File;

/* compiled from: mInsetT */
public class TempFileDirectoryManager {
    private static final Class<?> f8671a = TempFileDirectoryManager.class;
    private final File f8672b;

    TempFileDirectoryManager(File file) {
        Preconditions.checkNotNull(file);
        this.f8672b = file;
    }

    final File m8921a(String str, String str2) {
        if (!m8920a()) {
            return null;
        }
        File file;
        if (str == null || str.trim().length() == 0) {
            str = "";
        }
        if (str2 == null || str2.trim().length() == 0) {
            str2 = ".tmp";
        }
        String str3 = "";
        do {
            try {
                str3 = str + SystemClock.b().a() + str2;
                file = new File(this.f8672b, str3);
            } catch (Throwable e) {
                BLog.b(f8671a, e, "Error occurred when creating the temporary file %s in directory %s.", new Object[]{str3, this.f8672b.getName()});
                return null;
            }
        } while (!file.createNewFile());
        return file;
    }

    final boolean m8922a(long j) {
        boolean z = false;
        long a = SystemClock.a.a();
        File[] listFiles = this.f8672b.listFiles(new TempFileFilter());
        if (listFiles != null) {
            for (File file : listFiles) {
                if (a - file.lastModified() < j || !file.delete()) {
                    z = true;
                }
            }
        }
        return z;
    }

    private boolean m8920a() {
        if (this.f8672b.exists()) {
            if (this.f8672b.isDirectory() && this.f8672b.canRead() && this.f8672b.canWrite()) {
                return true;
            }
            return false;
        } else if (this.f8672b.mkdirs()) {
            try {
                new File(this.f8672b, ".nomedia").createNewFile();
                return true;
            } catch (Throwable e) {
                BLog.b(f8671a, "error in temp file manager", e);
                return false;
            }
        } else {
            BLog.b(f8671a, "Unable to create a directory");
            return false;
        }
    }
}
