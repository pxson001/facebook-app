package com.facebook.common.memory;

/* compiled from: op */
public class NoOpMemoryTrimmableRegistry implements MemoryTrimmableRegistry {
    private static NoOpMemoryTrimmableRegistry f11006a = null;

    public static synchronized NoOpMemoryTrimmableRegistry m16319a() {
        NoOpMemoryTrimmableRegistry noOpMemoryTrimmableRegistry;
        synchronized (NoOpMemoryTrimmableRegistry.class) {
            if (f11006a == null) {
                f11006a = new NoOpMemoryTrimmableRegistry();
            }
            noOpMemoryTrimmableRegistry = f11006a;
        }
        return noOpMemoryTrimmableRegistry;
    }

    public final void mo1390a(MemoryTrimmable memoryTrimmable) {
    }
}
