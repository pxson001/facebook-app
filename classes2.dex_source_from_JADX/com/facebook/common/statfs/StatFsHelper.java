package com.facebook.common.statfs;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.facebook.common.internal.Throwables;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: video_fullscreen_player */
public class StatFsHelper {
    private static StatFsHelper f1203a;
    private static final long f1204b = TimeUnit.MINUTES.toMillis(2);
    private volatile StatFs f1205c = null;
    private volatile File f1206d;
    private volatile StatFs f1207e = null;
    private volatile File f1208f;
    @GuardedBy("lock")
    private long f1209g;
    private final Lock f1210h = new ReentrantLock();
    private volatile boolean f1211i = false;

    /* compiled from: video_fullscreen_player */
    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized StatFsHelper m2310a() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (f1203a == null) {
                f1203a = new StatFsHelper();
            }
            statFsHelper = f1203a;
        }
        return statFsHelper;
    }

    protected StatFsHelper() {
    }

    private void m2311c() {
        if (!this.f1211i) {
            this.f1210h.lock();
            try {
                if (!this.f1211i) {
                    this.f1206d = Environment.getDataDirectory();
                    this.f1208f = Environment.getExternalStorageDirectory();
                    m2313e();
                    this.f1211i = true;
                }
                this.f1210h.unlock();
            } catch (Throwable th) {
                this.f1210h.unlock();
            }
        }
    }

    public final boolean m2315a(StorageType storageType, long j) {
        m2311c();
        long a = m2314a(storageType);
        if (a <= 0 || a < j) {
            return true;
        }
        return false;
    }

    @SuppressLint({"DeprecatedMethod"})
    public final long m2314a(StorageType storageType) {
        m2311c();
        m2312d();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.f1205c : this.f1207e;
        if (statFs == null) {
            return 0;
        }
        long blockSizeLong;
        long availableBlocksLong;
        if (VERSION.SDK_INT >= 18) {
            blockSizeLong = statFs.getBlockSizeLong();
            availableBlocksLong = statFs.getAvailableBlocksLong();
        } else {
            blockSizeLong = (long) statFs.getBlockSize();
            availableBlocksLong = (long) statFs.getAvailableBlocks();
        }
        return availableBlocksLong * blockSizeLong;
    }

    private void m2312d() {
        if (this.f1210h.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.f1209g > f1204b) {
                    m2313e();
                }
                this.f1210h.unlock();
            } catch (Throwable th) {
                this.f1210h.unlock();
            }
        }
    }

    public final void m2316b() {
        if (this.f1210h.tryLock()) {
            try {
                m2311c();
                m2313e();
            } finally {
                this.f1210h.unlock();
            }
        }
    }

    @GuardedBy("lock")
    private void m2313e() {
        this.f1205c = m2308a(this.f1205c, this.f1206d);
        this.f1207e = m2308a(this.f1207e, this.f1208f);
        this.f1209g = SystemClock.uptimeMillis();
    }

    private static StatFs m2308a(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        if (statFs == null) {
            try {
                return m2309a(file.getAbsolutePath());
            } catch (IllegalArgumentException e) {
                return null;
            } catch (Throwable th) {
                RuntimeException b = Throwables.m15700b(th);
            }
        } else {
            statFs.restat(file.getAbsolutePath());
            return statFs;
        }
    }

    private static StatFs m2309a(String str) {
        return new StatFs(str);
    }
}
