package com.facebook.video.server;

import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;

/* compiled from: offline_mode_operation_dropped_new_build_detected */
public class VideoCacheSizePolicy {
    private final StatFsHelper f11397a;
    private final long f11398b;

    public VideoCacheSizePolicy(StatFsHelper statFsHelper, long j) {
        this.f11397a = statFsHelper;
        this.f11398b = j;
    }

    public final long m16697a(long j) {
        long min = Math.min(this.f11398b, (this.f11397a.m2314a(StorageType.INTERNAL) + j) / 2);
        return j > min ? min / 2 : min;
    }
}
