package com.facebook.analytics.storagereportingutil;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Maps;
import java.io.File;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: image_load_state */
public class StorageReportingUtil {
    private final Context f10491a;
    private final MoreFileUtils f10492b;

    public static StorageReportingUtil m11042a(InjectorLike injectorLike) {
        return new StorageReportingUtil((Context) injectorLike.getInstance(Context.class, ForAppContext.class), MoreFileUtils.a(injectorLike));
    }

    @Inject
    public StorageReportingUtil(@ForAppContext Context context, MoreFileUtils moreFileUtils) {
        this.f10491a = context;
        this.f10492b = moreFileUtils;
    }

    public final Map<String, ?> m11043a() {
        StatFs statFs;
        long availableBlocks;
        long blockSize;
        long d;
        File externalCacheDir;
        long j = 0;
        Map<String, ?> c = Maps.c();
        try {
            statFs = new StatFs(Environment.getDataDirectory().getPath());
            availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            try {
                blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
            } catch (Exception e) {
                blockSize = availableBlocks;
                availableBlocks = blockSize;
                blockSize = j;
                c.put("device_free_space", Long.valueOf(availableBlocks));
                c.put("device_total_space", Long.valueOf(blockSize));
                statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
                blockSize = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
                c.put("sd_free_space", Long.valueOf(availableBlocks));
                c.put("sd_total_space", Long.valueOf(blockSize));
                d = this.f10492b.d(this.f10491a.getCacheDir().getCanonicalFile());
                try {
                    externalCacheDir = this.f10491a.getExternalCacheDir();
                    if (externalCacheDir != null) {
                        availableBlocks = this.f10492b.d(externalCacheDir.getCanonicalFile());
                    } else {
                        availableBlocks = j;
                    }
                    try {
                        blockSize = this.f10492b.d(this.f10491a.getFilesDir().getParentFile().getCanonicalFile());
                        try {
                            j = this.f10492b.d(this.f10491a.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getParentFile().getCanonicalFile());
                        } catch (Exception e2) {
                        }
                    } catch (Exception e3) {
                        blockSize = j;
                    }
                } catch (Exception e4) {
                    blockSize = j;
                    availableBlocks = j;
                }
                c.put("cache_size", Long.valueOf(d));
                c.put("external_cache_size", Long.valueOf(availableBlocks));
                c.put("app_data_size", Long.valueOf(blockSize - d));
                c.put("external_app_data_size", Long.valueOf(j - availableBlocks));
                return c;
            }
        } catch (Exception e5) {
            blockSize = j;
            availableBlocks = blockSize;
            blockSize = j;
            c.put("device_free_space", Long.valueOf(availableBlocks));
            c.put("device_total_space", Long.valueOf(blockSize));
            statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            blockSize = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            c.put("sd_free_space", Long.valueOf(availableBlocks));
            c.put("sd_total_space", Long.valueOf(blockSize));
            d = this.f10492b.d(this.f10491a.getCacheDir().getCanonicalFile());
            externalCacheDir = this.f10491a.getExternalCacheDir();
            if (externalCacheDir != null) {
                availableBlocks = j;
            } else {
                availableBlocks = this.f10492b.d(externalCacheDir.getCanonicalFile());
            }
            blockSize = this.f10492b.d(this.f10491a.getFilesDir().getParentFile().getCanonicalFile());
            j = this.f10492b.d(this.f10491a.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getParentFile().getCanonicalFile());
            c.put("cache_size", Long.valueOf(d));
            c.put("external_cache_size", Long.valueOf(availableBlocks));
            c.put("app_data_size", Long.valueOf(blockSize - d));
            c.put("external_app_data_size", Long.valueOf(j - availableBlocks));
            return c;
        }
        c.put("device_free_space", Long.valueOf(availableBlocks));
        c.put("device_total_space", Long.valueOf(blockSize));
        try {
            statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            try {
                blockSize = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            } catch (Exception e6) {
                blockSize = availableBlocks;
                availableBlocks = blockSize;
                blockSize = j;
                c.put("sd_free_space", Long.valueOf(availableBlocks));
                c.put("sd_total_space", Long.valueOf(blockSize));
                d = this.f10492b.d(this.f10491a.getCacheDir().getCanonicalFile());
                externalCacheDir = this.f10491a.getExternalCacheDir();
                if (externalCacheDir != null) {
                    availableBlocks = j;
                } else {
                    availableBlocks = this.f10492b.d(externalCacheDir.getCanonicalFile());
                }
                blockSize = this.f10492b.d(this.f10491a.getFilesDir().getParentFile().getCanonicalFile());
                j = this.f10492b.d(this.f10491a.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getParentFile().getCanonicalFile());
                c.put("cache_size", Long.valueOf(d));
                c.put("external_cache_size", Long.valueOf(availableBlocks));
                c.put("app_data_size", Long.valueOf(blockSize - d));
                c.put("external_app_data_size", Long.valueOf(j - availableBlocks));
                return c;
            }
        } catch (Exception e7) {
            blockSize = j;
            availableBlocks = blockSize;
            blockSize = j;
            c.put("sd_free_space", Long.valueOf(availableBlocks));
            c.put("sd_total_space", Long.valueOf(blockSize));
            d = this.f10492b.d(this.f10491a.getCacheDir().getCanonicalFile());
            externalCacheDir = this.f10491a.getExternalCacheDir();
            if (externalCacheDir != null) {
                availableBlocks = this.f10492b.d(externalCacheDir.getCanonicalFile());
            } else {
                availableBlocks = j;
            }
            blockSize = this.f10492b.d(this.f10491a.getFilesDir().getParentFile().getCanonicalFile());
            j = this.f10492b.d(this.f10491a.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getParentFile().getCanonicalFile());
            c.put("cache_size", Long.valueOf(d));
            c.put("external_cache_size", Long.valueOf(availableBlocks));
            c.put("app_data_size", Long.valueOf(blockSize - d));
            c.put("external_app_data_size", Long.valueOf(j - availableBlocks));
            return c;
        }
        c.put("sd_free_space", Long.valueOf(availableBlocks));
        c.put("sd_total_space", Long.valueOf(blockSize));
        try {
            d = this.f10492b.d(this.f10491a.getCacheDir().getCanonicalFile());
            externalCacheDir = this.f10491a.getExternalCacheDir();
            if (externalCacheDir != null) {
                availableBlocks = this.f10492b.d(externalCacheDir.getCanonicalFile());
            } else {
                availableBlocks = j;
            }
            blockSize = this.f10492b.d(this.f10491a.getFilesDir().getParentFile().getCanonicalFile());
            j = this.f10492b.d(this.f10491a.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getParentFile().getCanonicalFile());
        } catch (Exception e8) {
            blockSize = j;
            availableBlocks = j;
            d = j;
        }
        c.put("cache_size", Long.valueOf(d));
        c.put("external_cache_size", Long.valueOf(availableBlocks));
        c.put("app_data_size", Long.valueOf(blockSize - d));
        c.put("external_app_data_size", Long.valueOf(j - availableBlocks));
        return c;
    }
}
