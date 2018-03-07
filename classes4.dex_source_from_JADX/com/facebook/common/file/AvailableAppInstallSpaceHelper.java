package com.facebook.common.file;

import android.content.ContentResolver;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import com.facebook.common.time.Clock;
import javax.inject.Inject;

/* compiled from: min_photos_to_allow_bulk_edit */
public class AvailableAppInstallSpaceHelper {
    private final ContentResolver f7669a;
    private final Clock f7670b;
    private long f7671c;
    private long f7672d;
    private long f7673e = -1;

    @Inject
    public AvailableAppInstallSpaceHelper(ContentResolver contentResolver, Clock clock) {
        this.f7669a = contentResolver;
        this.f7670b = clock;
    }

    public final boolean m8040a(int i) {
        if (this.f7670b.a() - 3600000 > this.f7673e) {
            long totalBytes;
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            if (VERSION.SDK_INT >= 18) {
                this.f7671c = statFs.getAvailableBytes();
                totalBytes = statFs.getTotalBytes();
            } else {
                this.f7671c = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
                totalBytes = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
            }
            int a = m8039a("sys_storage_threshold_percentage", 10);
            int a2 = m8039a("sys_storage_threshold_max_bytes", 524288000);
            this.f7672d = (long) ((((float) totalBytes) * ((float) a)) / 100.0f);
            this.f7672d = Math.min((long) a2, this.f7672d);
            this.f7673e = this.f7670b.a();
        }
        if (this.f7671c < this.f7672d) {
            return false;
        }
        return ((long) i) < this.f7671c - this.f7672d;
    }

    private int m8039a(String str, int i) {
        int i2 = Secure.getInt(this.f7669a, str, -1);
        if (i2 == -1) {
            i2 = System.getInt(this.f7669a, str, -1);
        }
        return i2 == -1 ? i : i2;
    }
}
