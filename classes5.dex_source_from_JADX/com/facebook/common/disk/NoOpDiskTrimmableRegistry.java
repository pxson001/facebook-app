package com.facebook.common.disk;

/* compiled from: stop_time */
public class NoOpDiskTrimmableRegistry implements DiskTrimmableRegistry {
    private static NoOpDiskTrimmableRegistry f2524a = null;

    private NoOpDiskTrimmableRegistry() {
    }

    public static synchronized NoOpDiskTrimmableRegistry m3645a() {
        NoOpDiskTrimmableRegistry noOpDiskTrimmableRegistry;
        synchronized (NoOpDiskTrimmableRegistry.class) {
            if (f2524a == null) {
                f2524a = new NoOpDiskTrimmableRegistry();
            }
            noOpDiskTrimmableRegistry = f2524a;
        }
        return noOpDiskTrimmableRegistry;
    }

    public final void m3646a(DiskTrimmable diskTrimmable) {
    }
}
