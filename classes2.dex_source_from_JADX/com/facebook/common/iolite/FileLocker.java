package com.facebook.common.iolite;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

/* compiled from: t_sac */
public final class FileLocker implements Closeable {
    private final FileOutputStream f3488a;
    private final FileLock f3489b;

    public static FileLocker m5690a(File file) {
        return new FileLocker(file);
    }

    private FileLocker(File file) {
        this.f3488a = new FileOutputStream(file);
        try {
            FileLock lock = this.f3488a.getChannel().lock();
            if (lock == null) {
            }
            this.f3489b = lock;
        } finally {
            this.f3488a.close();
        }
    }

    public final void close() {
        try {
            this.f3489b.release();
        } finally {
            this.f3488a.close();
        }
    }
}
