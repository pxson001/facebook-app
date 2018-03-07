package com.facebook.analytics2.logger;

import com.facebook.analytics2.logger.BatchLockState.BatchLock;
import com.facebook.debug.log.BLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.OverlappingFileLockException;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: this for writes */
class CrossProcessBatchLockState extends BatchLockState<File> {
    private static BatchLockState f1980b;

    @ThreadSafe
    /* compiled from: this for writes */
    public class CrossProcessBatchLock extends BatchLock {
        @GuardedBy("this")
        FileLock f1977c;
        @GuardedBy("this")
        private final FileChannel f1978d = new RandomAccessFile(this.f1979e, "rw").getChannel();
        @GuardedBy("this")
        private final File f1979e;

        protected CrossProcessBatchLock(BatchLockState batchLockState, File file) {
            super(batchLockState, file);
            this.f1979e = m2647a(file);
        }

        private static File m2647a(File file) {
            if (file.getParentFile().isDirectory() || file.getParentFile().mkdirs()) {
                return new File(file.getParentFile(), file.getName() + ".lock");
            }
            throw new IOException("Unable to create parent directories for: " + file);
        }

        public final synchronized void m2654f() {
            m2648i();
        }

        private synchronized void m2648i() {
            Throwable e;
            while (this.f1977c == null) {
                try {
                    this.f1977c = this.f1978d.lock();
                } catch (Throwable e2) {
                    throw new RuntimeException("File channel is closed prematurely or opened non-writable for: " + this.b, e2);
                } catch (Throwable e22) {
                    BLog.a("CrossProcessBatchLock", e22, "Interrupted while waiting to lock the file: %s", new Object[]{this.b});
                } catch (IOException e3) {
                    e22 = e3;
                } catch (NonWritableChannelException e4) {
                    e22 = e4;
                }
            }
            return;
            throw new RuntimeException("Failed to lock the file due to an IOException!", e22);
        }

        public final synchronized void m2656h() {
            m2649j();
        }

        private synchronized void m2649j() {
            if (this.f1977c == null) {
                throw new IllegalStateException("File lock was never held for: " + this.b);
            }
            try {
                this.f1977c.release();
                this.f1977c = null;
            } catch (Throwable e) {
                throw new RuntimeException("File Channel has been closed prematurely for: " + this.b, e);
            } catch (Throwable e2) {
                throw new RuntimeException("Failed to unlock the file due to an IOException!", e2);
            }
        }

        public final synchronized boolean m2655g() {
            return m2650k();
        }

        private synchronized boolean m2650k() {
            Throwable e;
            boolean z = false;
            synchronized (this) {
                if (this.f1977c == null) {
                    try {
                        this.f1977c = this.f1978d.tryLock();
                    } catch (Throwable e2) {
                        throw new RuntimeException("File channel closed prematurely for: " + this.b, e2);
                    } catch (IOException e3) {
                        e = e3;
                        BLog.a("CrossProcessBatchLock", e, "IOException happens when trying to lock the file.", new Object[0]);
                        if (this.f1977c != null) {
                            z = true;
                        }
                        return z;
                    } catch (OverlappingFileLockException e4) {
                        e = e4;
                        BLog.a("CrossProcessBatchLock", e, "IOException happens when trying to lock the file.", new Object[0]);
                        if (this.f1977c != null) {
                            z = true;
                        }
                        return z;
                    }
                }
                if (this.f1977c != null) {
                    z = true;
                }
            }
            return z;
        }

        protected final synchronized void m2651b() {
            super.b();
            try {
                this.f1978d.close();
            } catch (Throwable e) {
                BLog.c("CrossProcessBatchLock", e, "Failed to close the file channel associated with file: %s", new Object[]{this.b});
            }
        }

        public final synchronized void m2652d() {
            this.f1979e.delete();
        }

        public final synchronized boolean m2653e() {
            return !this.f1979e.exists();
        }
    }

    /* compiled from: this for writes */
    class FailedFileCreationException extends RuntimeException {
        public FailedFileCreationException(String str, Throwable th) {
            super(str, th);
        }
    }

    CrossProcessBatchLockState() {
    }

    protected final BatchLock m2658b(Object obj) {
        File file = (File) obj;
        try {
            return new CrossProcessBatchLock(this, file);
        } catch (Throwable e) {
            throw new FailedFileCreationException("Unexpected error, failed to create file: " + file, e);
        }
    }

    public static synchronized BatchLockState m2657a() {
        BatchLockState batchLockState;
        synchronized (CrossProcessBatchLockState.class) {
            if (f1980b == null) {
                f1980b = new CrossProcessBatchLockState();
            }
            batchLockState = f1980b;
        }
        return batchLockState;
    }
}
