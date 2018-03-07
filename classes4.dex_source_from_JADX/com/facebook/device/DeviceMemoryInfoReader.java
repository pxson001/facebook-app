package com.facebook.device;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import javax.annotation.Nullable;

/* compiled from: happy_birthday_card */
public abstract class DeviceMemoryInfoReader {
    private final ActivityManager f10904a;

    public abstract long mo828a(@Nullable MemoryInfo memoryInfo);

    public DeviceMemoryInfoReader(ActivityManager activityManager) {
        this.f10904a = activityManager;
    }

    public final MemoryInfoCompat m11335a() {
        MemoryInfo memoryInfo = new MemoryInfo();
        this.f10904a.getMemoryInfo(memoryInfo);
        return new MemoryInfoCompat(memoryInfo, mo828a(memoryInfo));
    }
}
